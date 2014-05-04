package com.inventive.system.monitoring.gwt.client.statistics;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasValue;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.inventive.system.monitoring.gwt.client.dialog.CancelEvent;
import com.inventive.system.monitoring.gwt.client.dialog.CancelHandler;
import com.inventive.system.monitoring.gwt.client.dialog.OkEvent;
import com.inventive.system.monitoring.gwt.client.dialog.OkHandler;
import com.inventive.system.monitoring.gwt.client.mvp.AbstractMvpPresenter;
import com.inventive.system.monitoring.gwt.client.mvp.MvpView;
import com.inventive.system.monitoring.gwt.client.statistics.dto.GwtFilterKey;

/**
 * User: grant
 */
public class AddFilterPresenter extends AbstractMvpPresenter<AddFilterPresenter.View> {

    private GwtFilterKey gwtFilterKey;
    private EventBus eventBus;

    @ImplementedBy(AddFilterView.class)
    public static interface View extends MvpView {
        HasValue<String> getFilterValue();
        HasValue<String> getDisplayNameValue();
        HasClickHandlers getOk();
        HasClickHandlers getCancel();
        DialogBox getDialogBox();
    }

    @Inject
    public AddFilterPresenter(View view) {

        super(view);
        init();
    }


    private void init() {
        eventBus = new SimpleEventBus();
        getView().getOk().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (null == gwtFilterKey) {
                    gwtFilterKey = new GwtFilterKey();
                }
                gwtFilterKey.setQuery(getView().getFilterValue().getValue());
                gwtFilterKey.setDisplayName(getView().getDisplayNameValue().getValue());
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

    }

    public void reset() {
        gwtFilterKey = null;
        getView().getFilterValue().setValue(null);
        getView().getDisplayNameValue().setValue(null);
    }

    public GwtFilterKey getGwtFilterKey() {
        return gwtFilterKey;
    }

    public void show() {
        getView().getDialogBox().center();
        getView().getDialogBox().show();
        gwtFilterKey = null;
    }

    public HandlerRegistration addOkHandler(OkHandler handler) {
        return eventBus.addHandler(OkEvent.TYPE, handler);
    }

    public HandlerRegistration addCancelHandler(CancelHandler handler) {
        return eventBus.addHandler(CancelEvent.TYPE, handler);
    }

}
