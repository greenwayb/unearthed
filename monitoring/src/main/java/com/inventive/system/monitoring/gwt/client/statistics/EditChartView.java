package com.inventive.system.monitoring.gwt.client.statistics;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;

/**
 * User: grant
 */
public class EditChartView implements EditChartPresenter.View {

    interface MyUiBinder extends UiBinder<HTMLPanel, EditChartView> {}
    private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

    @UiField
    TextBox titleTextBox;

    @UiField
    ListBox propertiesListBox;

    @UiField
    HTMLPanel rootPanel;

    @UiField
    Button okButton;

    @UiField
    Button removeButton;

    @UiField
    Button cancelButton;

    @UiField
    Button addButton;

    private DialogBox dialogBox;

    public EditChartView() {
        uiBinder.createAndBindUi(this);
        propertiesListBox.setVisibleItemCount(10);
    }

    @Override
    public Widget asWidget() {
        return rootPanel;
    }

    @Override
    public DialogBox getDialogBox() {
        if (null == dialogBox) {
            dialogBox = new DialogBox();
            dialogBox.setWidget(this);
            dialogBox.setText("Edit Chart");
        }
        return dialogBox;
    }

    @Override
    public HasClickHandlers getAdd() {
        return addButton;
    }

    @Override
    public ListBox getListBox() {
        return propertiesListBox;
    }

    @Override
    public HasValue<String> getTitle() {
        return titleTextBox;
    }

    @Override
    public HasClickHandlers getOk() {
        return okButton;
    }

    @Override
    public HasClickHandlers getCancel() {
        return cancelButton;
    }

    @Override
    public HasClickHandlers getRemove() {
        return removeButton;
    }

    @Override
    public HasEnabled getRemoveEnabled() {
        return removeButton;
    }
}
