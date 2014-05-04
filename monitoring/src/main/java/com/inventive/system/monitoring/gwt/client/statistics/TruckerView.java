package com.inventive.system.monitoring.gwt.client.statistics;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * User: grant
 */
public class TruckerView implements TruckerPresenter.View {

    interface MyUiBinder extends UiBinder<HTMLPanel, TruckerView> {}

    @UiField
    HTMLPanel htmlPanel;

    @UiField
    Button dropButton;

    @UiField
    Button pickupButton;

    @UiField
    Button moveToLoad;

    @UiField
    Button moveToUnload;

    @UiField
    TextBox numberField;

    private static MyUiBinder ourUiBinder = GWT.create(MyUiBinder.class);

    public TruckerView() {
        htmlPanel = ourUiBinder.createAndBindUi(this);
    }

    @Override
    public Widget asWidget() {
        return htmlPanel;
    }
}
