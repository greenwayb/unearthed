package com.inventive.system.monitoring.gwt.client.statistics;

import com.allen_sauer.gwt.dnd.client.*;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.visualization.client.AbstractDataTable;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.LegendPosition;
import com.google.gwt.visualization.client.TimeOfDay;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.inventive.system.monitoring.gwt.client.dialog.CancelEvent;
import com.inventive.system.monitoring.gwt.client.dialog.CancelHandler;
import com.inventive.system.monitoring.gwt.client.dialog.OkEvent;
import com.inventive.system.monitoring.gwt.client.dialog.OkHandler;
import com.inventive.system.monitoring.gwt.client.mvp.AbstractMvpPresenter;
import com.inventive.system.monitoring.gwt.client.mvp.MvpView;
import com.inventive.system.monitoring.gwt.client.service.action.AbstractAsyncCallback;
import com.inventive.system.monitoring.gwt.client.service.action.ActionServiceAsync;
import com.inventive.system.monitoring.gwt.client.service.streaming.NumberStatisticMessage;
import com.google.gwt.visualization.client.visualizations.corechart.LineChart;
import com.google.gwt.visualization.client.visualizations.corechart.Options;
import com.inventive.system.monitoring.gwt.client.service.streaming.StreamMessage;
import com.inventive.system.monitoring.gwt.client.service.streaming.StreamMessageHandler;
import com.inventive.system.monitoring.gwt.client.service.streaming.StreamingService;
import com.inventive.system.monitoring.gwt.client.statistics.commands.*;
import com.inventive.system.monitoring.gwt.client.statistics.dto.Chart;
import com.inventive.system.monitoring.gwt.client.statistics.dto.JmxStatisticKey;
import com.inventive.system.monitoring.gwt.client.statistics.dto.ResetMessage;
import com.inventive.system.monitoring.gwt.client.statistics.events.ChartClosedEvent;
import com.inventive.system.monitoring.gwt.client.statistics.events.ChartClosedEventHandler;

import java.util.HashMap;
import java.util.Map;

/**
 */
public class LineChartPresenter extends AbstractMvpPresenter<LineChartPresenter.View>   {

    @ImplementedBy(LineChartView.class)
    public static interface View extends MvpView {
        LineChart createChart(Options options, DataTable dataTable);
        void setHeader(IsWidget widget);
    }

    private DataTable data;
    private LineChart viz;
    private int columnIndex=0;
    private Options options;
    private Map<JmxStatisticKey, Integer> columnIndexes = new HashMap<JmxStatisticKey, Integer>();
    private Map<TimeOfDay, Integer> rowIndexes = new HashMap<TimeOfDay, Integer>(10000);
    private DragController dragController;
    private ChartHeaderPresenter chartHeaderPresenter;
    private StreamingService streamingService;
    private ActionServiceAsync actionServiceAsync;
    private Chart chart;
    private EventBus eventBus;
    private EditChartPresenter editChartPresenter;
    private HandlerRegistration okHandlerRegistration;
    private HandlerRegistration cancelHandlerRegistration;
    private RecreateChartDragHandler recreateChartDragHandler = new RecreateChartDragHandler();
    private MyStreamMessageHandler streamHandler;


    @Inject
    public LineChartPresenter(View view,
                              ChartHeaderPresenter chartHeaderPresenter,
                              StreamingService streamingService,
                              ActionServiceAsync actionServiceAsync,
                              EditChartPresenter editChartPresenter) {
        super(view);
        this.chartHeaderPresenter = chartHeaderPresenter;
        this.streamingService = streamingService;
        this.actionServiceAsync = actionServiceAsync;
        this.editChartPresenter = editChartPresenter;
        init();
    }

    public void setDragController(DragController dragController) {
        if (null != dragController) {
            dragController.addDragHandler(recreateChartDragHandler);
        }
        else if (this.dragController != null) {
            this.dragController.removeDragHandler(recreateChartDragHandler);
        }
        this.dragController = dragController;

    }

    private void init() {
        this.eventBus = new SimpleEventBus();
        getView().setHeader(chartHeaderPresenter.getView().asWidget());

        chartHeaderPresenter.getEdit().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                okHandlerRegistration = editChartPresenter.addOkHandler(new EditChartHandler());
                cancelHandlerRegistration = editChartPresenter.addCancelHandler(new CancelHandler() {
                    @Override
                    public void onCancel(CancelEvent event) {
                        removeRegistrations();
                    }
                });
                editChartPresenter.setChart(chart);
                editChartPresenter.show();
            }
        });

        chartHeaderPresenter.getClose().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                actionServiceAsync.execute(new RemoveSubscriptionAction(chart.getKeys(), streamingService.getSessionId()), new AbstractAsyncCallback<RemoveSubscriptionResult>() {
                    @Override
                    public void onSuccess(RemoveSubscriptionResult result) {
                        eventBus.fireEvent(new ChartClosedEvent(chart));
                    }
                });
            }
        });
    }

    private void removeRegistrations() {
        if (null != okHandlerRegistration) {
            okHandlerRegistration.removeHandler();
            okHandlerRegistration = null;
        }
        if (null != cancelHandlerRegistration) {
            cancelHandlerRegistration.removeHandler();
            cancelHandlerRegistration = null;
        }
    }

    public Chart getChart() {
        return chart;
    }

    public void setChart(Chart chart) {
        this.chart = chart;
    }

    private class EditChartHandler implements OkHandler {


        @Override
        public void onOk(OkEvent event) {
            final Chart chart = editChartPresenter.getChart();
            if (chart.getKeys() != null && chart.getKeys().size() > 0) {
//                actionServiceAsync.execute(new SaveChartAction(chart), new AbstractAsyncCallback<SaveChartResult>() {
//                    @Override
//                    public void onSuccess(final SaveChartResult result) {
//                        LineChartPresenter.this.chart = result.getChart();
//                        actionServiceAsync.execute(new RemoveSubscriptionAction(result.getChart().getKeys(), streamingService.getSessionId()), new AbstractAsyncCallback<RemoveSubscriptionResult>() {
//                            @Override
//                            public void onSuccess(RemoveSubscriptionResult removeSubResult) {
//                                stop();
//                                createChart(chart);
//                                actionServiceAsync.execute(new AddSubscriptionAction(result.getChart().getKeys(), streamingService.getSessionId()), new AbstractAsyncCallback<AddSubscriptionResult>() {
//                                    @Override
//                                    public void onSuccess(AddSubscriptionResult result) {
//                                    }
//                                });
//                            }
//                        });
//                    }
//                });

            }
            removeRegistrations();
        }
    }

    public void createChart(Chart chart) {
        this.chart = chart;
        setTitle(chart.getTitle());
        options = Options.create();
        options.setHeight(240);
        options.setWidth(450);
        options.setPointSize(0);
        options.setLegend(LegendPosition.BOTTOM);
        options.set("animation.duration", 200.0);
        options.set("legend.textStyle", "{color: green, fontName: Arial, fontSize: 12}");
        options.setInterpolateNulls(true);

        if (null == data) {
            createDataTable();
            start();
        }
        viz = getView().createChart(options, data);

    }

    private void createDataTable() {
        data = DataTable.create();
        data.addColumn(AbstractDataTable.ColumnType.TIMEOFDAY, "Time");
    }

    public void updateData(NumberStatisticMessage msg) {
        if (null != msg) {

            for (NumberStatisticMessage.TimeAndValue timeAndValue : msg.getValues()) {
                try {
                    @SuppressWarnings("deprecation")
                    TimeOfDay timeOfDay = new TimeOfDay(timeAndValue.getTime().getHours(), timeAndValue.getTime().getMinutes(), timeAndValue.getTime().getSeconds(), 0);
                    Integer rowIndex = rowIndexes.get(timeOfDay);
                    if (null == rowIndex) {
                        rowIndex = data.getNumberOfRows();
                        rowIndexes.put(timeOfDay, rowIndex);
                        data.addRow();
                    }
                    data.setValue(rowIndex, 0, timeOfDay);
                    Integer index = columnIndexes.get(msg.getIdentifier());
                    if (index == null) {
                        index = ++columnIndex;
                        data.addColumn(AbstractDataTable.ColumnType.NUMBER, msg.getIdentifier().getDisplayName());
                        columnIndexes.put(msg.getIdentifier(), columnIndex);
                    }

                    //Now we need to set all other columns to null
//                    for (int x=0; x< data.getNumberOfColumns()-1; x++) {
//                        if (index != x) {
//                            data.setValueNull(rowIndex, x);
//                        }
//                    }
                    data.setValue(rowIndex, index, timeAndValue.getValue().doubleValue());

                } catch (TimeOfDay.BadTimeException e) {
                    GWT.log("Error: " + e.getMessage());
                }
            }
            viz.draw(data, options);

        }
    }

    public Widget getWidget() {
        return getView().asWidget();
    }

    public void setTitle(String title) {
        chartHeaderPresenter.setTitle(title);
    }

    public HasDragHandle getDragHandle() {
        return chartHeaderPresenter.getDragHandle();
    }


    private class RecreateChartDragHandler implements DragHandler {
        @Override
        public void onDragEnd(DragEndEvent dragEndEvent) {
            createChart(chart);
        }

        @Override
        public void onDragStart(DragStartEvent dragStartEvent) {
        }

        @Override
        public void onPreviewDragEnd(DragEndEvent dragEndEvent) throws VetoDragException {
        }

        @Override
        public void onPreviewDragStart(DragStartEvent dragStartEvent) throws VetoDragException {
        }
    }

    public void start() {
        streamingService.addHandler(streamHandler = new MyStreamMessageHandler(), NumberStatisticMessage.class);
        streamingService.addHandler(new StreamMessageHandler() {
            @Override
            public void handleMessage(StreamMessage message) {
                data = null;
                createDataTable();
                rowIndexes.clear();
                columnIndex = 0;
                columnIndexes.clear();
            }
        }, ResetMessage.class);
    }

    public void stop() {
        data = null;
        rowIndexes.clear();
        columnIndex=0;
        columnIndexes.clear();
        streamingService.removeHandler(streamHandler, NumberStatisticMessage.class);
    }

    public HandlerRegistration addChartClosedEventHandler(ChartClosedEventHandler handler) {
        return eventBus.addHandler(ChartClosedEvent.TYPE, handler);
    }

    private class MyStreamMessageHandler implements StreamMessageHandler {

        @Override
        public void handleMessage(final StreamMessage message) {
            if (message instanceof NumberStatisticMessage) {
                NumberStatisticMessage msg = (NumberStatisticMessage) message;
                if (chart.getKeys().contains(msg.getIdentifier())) {
                    updateData(msg);
                }
            }
        }

    }
}
