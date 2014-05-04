package com.inventive.system.monitoring.gwt.client.statistics;

import com.google.gwt.event.dom.client.*;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.ListBox;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.inventive.system.monitoring.gwt.client.dialog.CancelEvent;
import com.inventive.system.monitoring.gwt.client.dialog.CancelHandler;
import com.inventive.system.monitoring.gwt.client.dialog.OkEvent;
import com.inventive.system.monitoring.gwt.client.dialog.OkHandler;
import com.inventive.system.monitoring.gwt.client.mvp.AbstractMvpPresenter;
import com.inventive.system.monitoring.gwt.client.mvp.MvpView;
import com.inventive.system.monitoring.gwt.client.statistics.dto.Chart;
import com.inventive.system.monitoring.gwt.client.statistics.dto.GwtFilterKey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * User: grant
 */
public class EditChartPresenter extends AbstractMvpPresenter<EditChartPresenter.View> {

    @ImplementedBy(EditChartView.class)
    public static interface View extends MvpView {
        DialogBox getDialogBox();
        HasClickHandlers getOk();
        HasClickHandlers getCancel();
        HasValue<String> getTitle();
        HasClickHandlers getAdd();
        HasClickHandlers getRemove();
        ListBox getListBox();
        HasEnabled getRemoveEnabled();
    }

    private Chart chart;
    private EventBus eventBus;
    private HandlerRegistration okHandlerRegistration;
    private HandlerRegistration cancelHandlerRegistration;

    private AddFilterPresenter addFilterPresenter;

    private Map<String, GwtFilterKey> indexes = new HashMap<String, GwtFilterKey>();

    @Inject
    public EditChartPresenter(View view,
                              AddFilterPresenter addFilterPresenter) {
        super(view);
        eventBus = new SimpleEventBus();
        this.addFilterPresenter = addFilterPresenter;
        init();
    }

    private void init() {
        getView().getRemoveEnabled().setEnabled(false);
        eventBus = new SimpleEventBus();
        getView().getOk().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (null == chart) {
                    chart = new Chart();
                }
                chart.setTitle(getView().getTitle().getValue());
                chart.setKeys(new ArrayList<GwtFilterKey>(indexes.values()));
                eventBus.fireEvent(new OkEvent());
                getView().getDialogBox().hide();
            }
        });

        getView().getCancel().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                eventBus.fireEvent(new CancelEvent());
                getView().getDialogBox().hide();
            }
        });

        getView().getAdd().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                okHandlerRegistration = addFilterPresenter.addOkHandler(new OkHandler() {
                    @Override
                    public void onOk(OkEvent event) {
                        GwtFilterKey jmxStatisticKey = addFilterPresenter.getGwtFilterKey();
                        indexes.put(jmxStatisticKey.getDisplayName(), jmxStatisticKey);
                        getView().getListBox().addItem(jmxStatisticKey.getDisplayName());
                        removeRegistrations();
                    }
                });
                cancelHandlerRegistration = addFilterPresenter.addCancelHandler(new CancelHandler() {
                    @Override
                    public void onCancel(CancelEvent event) {
                        removeRegistrations();
                    }
                });
                addFilterPresenter.show();
            }
        });

        getView().getRemove().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                String value = getView().getListBox().getValue(getView().getListBox().getSelectedIndex());
                indexes.remove(value);
                getView().getListBox().removeItem(getView().getListBox().getSelectedIndex());
                getView().getRemoveEnabled().setEnabled(false);
            }
        });

        getView().getListBox().addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent event) {
                int index = getView().getListBox().getSelectedIndex();
                getView().getRemoveEnabled().setEnabled(index >= 0);
            }
        });

    }

    public void reset() {
//        addJmxPropertyPresenter.reset();
        chart = null;
        getView().getTitle().setValue(null);
        indexes.clear();
        getView().getListBox().clear();
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


    public void show() {
        getView().getDialogBox().center();
        getView().getDialogBox().show();
    }

    public Chart getChart() {
        return chart;
    }


    public HandlerRegistration addOkHandler(OkHandler handler) {
        return eventBus.addHandler(OkEvent.TYPE, handler);
    }

    public HandlerRegistration addCancelHandler(CancelHandler handler) {
        return eventBus.addHandler(CancelEvent.TYPE, handler);
    }

    private void refresh() {
        getView().getListBox().clear();
        if (null != chart) {
            getView().getTitle().setValue(chart.getTitle());
            for (GwtFilterKey jmxStatisticKey : chart.getKeys()) {
                indexes.put(jmxStatisticKey.getDisplayName(), jmxStatisticKey);
                getView().getListBox().addItem(jmxStatisticKey.getDisplayName());

            }
        } else {
            getView().getTitle().setValue(null);
        }
    }

    public void setChart(Chart chart) {
        this.chart = chart;
        refresh();
    }
}
