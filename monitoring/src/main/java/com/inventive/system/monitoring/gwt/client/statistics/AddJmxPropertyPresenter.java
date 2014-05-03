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
import com.inventive.system.monitoring.gwt.client.statistics.dto.JmxStatisticKey;

/**
 * User: grant
 */
public class AddJmxPropertyPresenter extends AbstractMvpPresenter<AddJmxPropertyPresenter.View> {

    private JmxStatisticKey jmxStatisticKey;
    private EventBus eventBus;

    @ImplementedBy(AddJmxPropertyView.class)
    public static interface View extends MvpView {
        HasValue<String> getObjectValue();
        HasValue<String> getPropertyValue();
        HasValue<String> getMachineValue();
        HasValue<String> getProcessValue();
        HasValue<String> getFieldValue();
        HasClickHandlers getOk();
        HasClickHandlers getCancel();
        DialogBox getDialogBox();
    }

    @Inject
    public AddJmxPropertyPresenter(View view) {

        super(view);
        init();
    }


    private void init() {
        eventBus = new SimpleEventBus();
        getView().getOk().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (null == jmxStatisticKey) {
                    jmxStatisticKey = new JmxStatisticKey();
                }
                jmxStatisticKey.setObjectName(getView().getObjectValue().getValue());
                jmxStatisticKey.setPropertyName(getView().getPropertyValue().getValue());
                jmxStatisticKey.setMachineName(getView().getMachineValue().getValue());
                jmxStatisticKey.setProcessName(getView().getProcessValue().getValue().trim().equals("") ? null : getView().getProcessValue().getValue());
                jmxStatisticKey.setFieldName(getView().getFieldValue().getValue().trim().equals("") ? null : getView().getFieldValue().getValue());
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
        jmxStatisticKey = null;
        getView().getObjectValue().setValue(null);
        getView().getPropertyValue().setValue(null);
        getView().getMachineValue().setValue(null);
        getView().getProcessValue().setValue(null);
        getView().getFieldValue().setValue(null);
    }

    public JmxStatisticKey getJmxStatisticKey() {
        return jmxStatisticKey;
    }

    public void show() {
        getView().getDialogBox().center();
        getView().getDialogBox().show();
        jmxStatisticKey = null;
    }

    public HandlerRegistration addOkHandler(OkHandler handler) {
        return eventBus.addHandler(OkEvent.TYPE, handler);
    }

    public HandlerRegistration addCancelHandler(CancelHandler handler) {
        return eventBus.addHandler(CancelEvent.TYPE, handler);
    }

}
