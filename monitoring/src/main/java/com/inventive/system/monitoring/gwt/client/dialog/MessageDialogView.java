package com.inventive.system.monitoring.gwt.client.dialog;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * User: Grant Little <grant.little@inventivesoftware.com.au>
 */
public class MessageDialogView extends DialogBox implements MessageDialogPresenter.View {

    interface SystemMonitoringViewUiBinder extends UiBinder<HTMLPanel, MessageDialogView> {}
    private static SystemMonitoringViewUiBinder ourUiBinder = GWT.create(SystemMonitoringViewUiBinder.class);

    @UiField
    HTMLPanel rootPanel;

    @UiField
    Button okButton;


    public MessageDialogView() {
        init();
    }

    @Override
    public HasClickHandlers getOkButton() {
        return okButton;
    }

    public void init() {
        ourUiBinder.createAndBindUi(this);
        setWidget(rootPanel);
    }

    @Override
    public DialogBox getDialog() {
        return this;
    }

}
