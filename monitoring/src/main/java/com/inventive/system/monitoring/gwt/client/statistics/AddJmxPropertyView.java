package com.inventive.system.monitoring.gwt.client.statistics;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;

/**
 * User: grant
 */
public class AddJmxPropertyView implements AddJmxPropertyPresenter.View {

    interface SystemMonitoringViewUiBinder extends UiBinder<HTMLPanel, AddJmxPropertyView> {}
    private static SystemMonitoringViewUiBinder ourUiBinder = GWT.create(SystemMonitoringViewUiBinder.class);

    @UiField
    Button okButton;

    @UiField
    Button cancelButton;

    @UiField
    HTMLPanel rootPanel;

    private DialogBox dialogBox;

    @UiField
    TextBox objectNameTextBox;
    @UiField
    TextBox propertyNameTextBox;
    @UiField
    TextBox machineNameTextBox;
    @UiField
    TextBox processNameTextBox;
    @UiField
    TextBox fieldNameTextBox;

    @Override
    public Widget asWidget() {
        return rootPanel;
    }

    public AddJmxPropertyView() {
        ourUiBinder.createAndBindUi(this);
        dialogBox = new DialogBox();
        dialogBox.setWidget(this);
        dialogBox.setText("JMX Properties");

    }

    @Override
    public HasValue<String> getObjectValue() {
        return objectNameTextBox;
    }

    @Override
    public HasValue<String> getMachineValue() {
        return machineNameTextBox;
    }

    @Override
    public HasValue<String> getProcessValue() {
        return processNameTextBox;
    }

    @Override
    public HasValue<String> getFieldValue() {
        return fieldNameTextBox;
    }

    @Override
    public HasClickHandlers getOk() {
        return okButton;
    }

    @Override
    public DialogBox getDialogBox() {
        return dialogBox;
    }

    @Override
    public HasValue<String> getPropertyValue() {
        return  propertyNameTextBox;
    }

    @Override
    public HasClickHandlers getCancel() {
        return cancelButton;
    }
}
