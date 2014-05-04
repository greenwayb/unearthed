package com.inventive.system.monitoring.gwt.client.statistics;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;

/**
 * User: grant
 */
public class AddFilterView implements AddFilterPresenter.View {

    interface SystemMonitoringViewUiBinder extends UiBinder<HTMLPanel, AddFilterView> {}
    private static SystemMonitoringViewUiBinder ourUiBinder = GWT.create(SystemMonitoringViewUiBinder.class);

    @UiField
    Button okButton;

    @UiField
    Button cancelButton;

    @UiField
    HTMLPanel rootPanel;

    @UiField
    TextArea filterTextArea;

    private DialogBox dialogBox;


    @UiField
    TextBox displayNameTextBox;


    @Override
    public Widget asWidget() {
        return rootPanel;
    }

    public AddFilterView() {
        ourUiBinder.createAndBindUi(this);
        dialogBox = new DialogBox();
        dialogBox.setWidget(this);
        dialogBox.setText("Filter Properties");

    }

    @Override
    public HasValue<String> getFilterValue() {
        return filterTextArea;
    }

    @Override
    public HasValue<String> getDisplayNameValue() {
        return displayNameTextBox;
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
    public HasClickHandlers getCancel() {
        return cancelButton;
    }
}
