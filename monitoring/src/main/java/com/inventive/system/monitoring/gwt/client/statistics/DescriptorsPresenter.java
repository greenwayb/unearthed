package com.inventive.system.monitoring.gwt.client.statistics;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.view.client.AbstractDataProvider;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SetSelectionModel;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.inventive.system.monitoring.gwt.client.mvp.AbstractMvpPresenter;
import com.inventive.system.monitoring.gwt.client.mvp.MvpView;
import com.inventive.system.monitoring.gwt.client.service.action.AbstractAsyncCallback;
import com.inventive.system.monitoring.gwt.client.service.action.ActionServiceAsync;
import com.inventive.system.monitoring.gwt.client.statistics.commands.GetPublishersAction;
import com.inventive.system.monitoring.gwt.client.statistics.commands.GetPublishersResult;
import com.inventive.system.monitoring.gwt.client.statistics.dto.GwtStatisticDescriptor;
import com.inventive.system.monitoring.gwt.client.statistics.dto.JmxStatisticKey;
import com.inventive.system.monitoring.gwt.client.statistics.events.AddChartEvent;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * User: grant
 */
public class DescriptorsPresenter extends AbstractMvpPresenter<DescriptorsPresenter.View> {

    @ImplementedBy(DescriptorsView.class)
    public static interface View extends MvpView {
        HasData<GwtStatisticDescriptor> getTable();
        void resize();
        HasClickHandlers getAddChart();
        HasClickHandlers getAddPublisher();
        HasClickHandlers getRefresh();
        SetSelectionModel<GwtStatisticDescriptor> getSelectionModel();
        HasEnabled getAddButtonEnabled();
    }

    private ActionServiceAsync actionServiceAsync;
    private AddJmxPropertyPresenter addJmxPropertyPresenter;
    private EventBus eventBus;
    private HandlerRegistration okHandlerRegistration;
    private HandlerRegistration cancelHandlerRegistration;
    private DataProvider dataProvider;

    @Inject
    public DescriptorsPresenter(View view,
                                ActionServiceAsync actionServiceAsync,
                                EventBus eventBus,
                                AddJmxPropertyPresenter addJmxPropertyPresenter) {
        super(view);
        this.actionServiceAsync = actionServiceAsync;
        this.eventBus = eventBus;
        this.addJmxPropertyPresenter = addJmxPropertyPresenter;
        init();
    }

    private void init() {

        dataProvider = new DataProvider();

        dataProvider.addDataDisplay(getView().getTable());

        getView().getAddChart().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Set<JmxStatisticKey> keys = new HashSet<JmxStatisticKey>();
                for (GwtStatisticDescriptor publisher : getView().getSelectionModel().getSelectedSet()) {
                    keys.add(publisher.getJmxStatisticKey());
                };
                eventBus.fireEvent(new AddChartEvent(keys));
            }
        });

        getView().getSelectionModel().addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
            @Override
            public void onSelectionChange(SelectionChangeEvent event) {
                getView().getAddButtonEnabled().setEnabled(getView().getSelectionModel().getSelectedSet().size() > 0);
            }
        });

        getView().getRefresh().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                refresh();
            }
        });


    }

    private void removeHandlerRegistrations() {
        if (null != okHandlerRegistration) {
            okHandlerRegistration.removeHandler();
            okHandlerRegistration = null;
        }
        if (null != cancelHandlerRegistration) {
            cancelHandlerRegistration.removeHandler();
            cancelHandlerRegistration = null;
        }
    }



    private class DataProvider extends AbstractDataProvider<GwtStatisticDescriptor> {

        @Override
        protected void onRangeChanged(final HasData<GwtStatisticDescriptor> display) {
            actionServiceAsync.execute(new GetPublishersAction(), new AbstractAsyncCallback<GetPublishersResult>() {
                @Override
                public void onSuccess(GetPublishersResult result) {
                    updateRowData(display, 0, new ArrayList<GwtStatisticDescriptor>(result.getGwtStatisticDescriptors()));
                }
            });
        }
    }

    public void resize() {
        getView().resize();
    }

    private void refresh() {
        if (null != dataProvider) {
            dataProvider.removeDataDisplay(getView().getTable());
            dataProvider.addDataDisplay(getView().getTable());
        }
    }
}
