package com.inventive.system.monitoring.gwt.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.logical.shared.HasSelectionHandlers;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.visualization.client.VisualizationUtils;
import com.google.gwt.visualization.client.visualizations.corechart.LineChart;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.inventive.system.monitoring.gwt.client.dialog.CancelEvent;
import com.inventive.system.monitoring.gwt.client.dialog.CancelHandler;
import com.inventive.system.monitoring.gwt.client.dialog.OkEvent;
import com.inventive.system.monitoring.gwt.client.dialog.OkHandler;
import com.inventive.system.monitoring.gwt.client.dnd.DragDropGridPresenter;
import com.inventive.system.monitoring.gwt.client.mvp.AbstractMvpPresenter;
import com.inventive.system.monitoring.gwt.client.mvp.MvpView;
import com.inventive.system.monitoring.gwt.client.service.action.AbstractAsyncCallback;
import com.inventive.system.monitoring.gwt.client.service.action.ActionServiceAsync;
import com.inventive.system.monitoring.gwt.client.service.streaming.StreamingService;
import com.inventive.system.monitoring.gwt.client.statistics.EditChartPresenter;
import com.inventive.system.monitoring.gwt.client.statistics.LineChartPresenterFactory;
import com.inventive.system.monitoring.gwt.client.statistics.commands.GetChartsAction;
import com.inventive.system.monitoring.gwt.client.statistics.commands.GetChartsResult;
import com.inventive.system.monitoring.gwt.client.statistics.dto.Chart;
import com.inventive.system.monitoring.gwt.client.statistics.dto.GwtFilterKey;
import com.inventive.system.monitoring.gwt.client.statistics.events.AddChartEvent;
import com.inventive.system.monitoring.gwt.client.statistics.events.AddChartEventHandler;
import com.inventive.system.monitoring.gwt.client.statistics.events.LoggedInEvent;
import com.inventive.system.monitoring.gwt.client.statistics.events.LoggedInEventHandler;

import java.util.ArrayList;

/**
 * User: Grant Little <grant.little@inventivesoftware.com.au>
 */
public class SystemMonitoringPresenter extends AbstractMvpPresenter<SystemMonitoringView> {

    @ImplementedBy(SystemMonitoringView.class)
    public static interface View extends MvpView {
        HasClickHandlers getAddWidgetButton();
        HasEnabled getAddButtonEnabled();
//        HasOneWidget getDescriptorsWrapperPanel();
        HasSelectionHandlers<Integer> getTabSelectionHandlers();
        void setDragDopView(IsWidget dragDropView);

    }

    private EditChartPresenter editChartPresenter;
    private HandlerRegistration okHandlerRegistration;
    private HandlerRegistration cancelHandlerRegistration;
    private ActionServiceAsync actionServiceAsync;
    private StreamingService streamingService;
    private LineChartPresenterFactory lineChartPresenterFactory;
    private EventBus eventBus;
    private boolean loggedIn = false;
    private boolean visualizationsLoaded = false;
    private DragDropGridPresenter dragDropGridPresenter;

    @Inject
    public SystemMonitoringPresenter(SystemMonitoringView view,
                                     EditChartPresenter editChartPresenter,
                                     ActionServiceAsync actionServiceAsync,
                                     StreamingService streamingService,
                                     EventBus eventBus,
                                     DragDropGridPresenter dragDropGridPresenter) {
        super(view);
        this.actionServiceAsync = actionServiceAsync;
        this.editChartPresenter = editChartPresenter;
        this.streamingService = streamingService;
        this.eventBus = eventBus;
        this.dragDropGridPresenter = dragDropGridPresenter;
        init();
    }

    public void init() {
//        getView().getAddButtonEnabled().setEnabled(false);

//        getView().getDescriptorsWrapperPanel().setWidget(descriptorsPresenter.getView());

        Runnable onLoadCallback = new Runnable() {
            public void run() {
                visualizationsLoaded = true;
                if (visualizationsLoaded && loggedIn) {
                    getCharts();
                }
//                getView().getAddButtonEnabled().setEnabled(true);
            }
        };

        VisualizationUtils.loadVisualizationApi(onLoadCallback, LineChart.PACKAGE);

        getView().getAddWidgetButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                okHandlerRegistration = editChartPresenter.addOkHandler(new AddChartHandler());
                cancelHandlerRegistration = editChartPresenter.addCancelHandler(new CancelHandler() {
                    @Override
                    public void onCancel(CancelEvent event) {
                        removeRegistrations();
                    }
                });
                editChartPresenter.reset();
                editChartPresenter.show();

            }
        });

        eventBus.addHandler(LoggedInEvent.TYPE, new LoggedInEventHandler() {
            @Override
            public void onLoggedIn(LoggedInEvent event) {
                loggedIn = true;
                if (visualizationsLoaded && loggedIn) {
                    getCharts();
                }
            }
        });

//        getView().getTabSelectionHandlers().addSelectionHandler(new SelectionHandler<Integer>() {
//            @Override
//            public void onSelection(SelectionEvent<Integer> event) {
//                descriptorsPresenter.resize();
//            }
//        });

        eventBus.addHandler(AddChartEvent.TYPE, new AddChartEventHandler() {
            @Override
            public void onAddChart(AddChartEvent event) {
                okHandlerRegistration = editChartPresenter.addOkHandler(new AddChartHandler());
                cancelHandlerRegistration = editChartPresenter.addCancelHandler(new CancelHandler() {
                    @Override
                    public void onCancel(CancelEvent event) {
                        removeRegistrations();
                    }
                });
                editChartPresenter.reset();
                Chart chart = new Chart();
                chart.setKeys(new ArrayList<GwtFilterKey>(event.getKeys()));
                editChartPresenter.setChart(chart);
                editChartPresenter.show();

            }
        });

        getView().setDragDopView(dragDropGridPresenter.getView());
    }

    private void getCharts() {
        actionServiceAsync.execute(new GetChartsAction(), new AbstractAsyncCallback<GetChartsResult>() {
            @Override
            public void onSuccess(GetChartsResult result) {
                if (result.getCharts() != null && result.getCharts().size() > 0) {
                    for (Chart chart : result.getCharts()) {
                        addSubscription(chart);
                    }
                }
            }
        });
    }

    public void setLineChartPresenterFactory(LineChartPresenterFactory lineChartPresenterFactory) {
        this.lineChartPresenterFactory = lineChartPresenterFactory;
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

    private class AddChartHandler implements OkHandler {


        @Override
        public void onOk(OkEvent event) {
            final Chart chart = editChartPresenter.getChart();
            if (chart.getKeys() != null && chart.getKeys().size() > 0) {
                saveChartChart(chart, new SaveChartCallback() {
                    @Override
                    public void onSuccess(Chart chart) {
                        addSubscription(chart);
                    }
                });
            }
            removeRegistrations();
        }
    }

    private void addSubscription(final Chart chart) {
//        actionServiceAsync.execute(new AddSubscriptionAction(chart.getKeys(), streamingService.getSessionId()), new AbstractAsyncCallback<AddSubscriptionResult>() {
//            @Override
//            public void onSuccess(AddSubscriptionResult result) {
//                final LineChartPresenter presenter = lineChartPresenterFactory.newLineChartPresenter();
//                presenter.addChartClosedEventHandler(new ChartClosedEventHandler() {
//                    @Override
//                    public void chartClosed(ChartClosedEvent event) {
//                        actionServiceAsync.execute(new RemoveChartAction(presenter.getChart()), new AbstractAsyncCallback<RemoveChartResult>() {
//                            @Override
//                            public void onSuccess(RemoveChartResult result) {
//                                dragDropGridPresenter.removeWidget(presenter.getWidget(), chart);
//                                presenter.setDragController(null);
//                            }
//                        });
//                    }
//                });
//                presenter.createChart(chart);
//
//                dragDropGridPresenter.addWidget(presenter.getWidget(), new HasPosition() {
//
//                    @Override
//                    public int getColumn() {
//                        return chart.getColumn();
//                    }
//
//                    @Override
//                    public int getRow() {
//                        return chart.getRow();
//                    }
//
//                    @Override
//                    public void setPosition(int row, int column) {
//                        chart.setPosition(row, column);
//                        saveChartChart(chart, new SaveChartCallback() {
//                            @Override
//                            public void onSuccess(Chart savedChart) {
//                                presenter.setChart(savedChart);
//                            }
//                        });
//                    }
//                });
//            }
//        });
    }

    private void saveChartChart(final Chart chart, final SaveChartCallback callback) {
//        actionServiceAsync.execute(new SaveChartAction(chart), new AbstractAsyncCallback<SaveChartResult>() {
//            @Override
//            public void onSuccess(SaveChartResult result) {
//                final Chart savedChart = result.getChart();
//                if (callback != null) {
//                    callback.onSuccess(savedChart);
//                }
//            }
//        });

    }

    private interface SaveChartCallback {
        void onSuccess(Chart chart);
    }
}
