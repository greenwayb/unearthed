package com.inventive.system.monitoring.gwt.client.statistics;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;

/**
 * User: grant
 */
public class ChartHeaderView implements ChartHeaderPresenter.View {

    interface MyUiBinder extends UiBinder<HTMLPanel, ChartHeaderView> {}
    private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

    @UiField
    HTMLPanel wrapperPanel;

    @UiField
    HTML headerText;

    @UiField
    Image editImage;

    @UiField
    Image closeImage;


    public ChartHeaderView() {
        uiBinder.createAndBindUi(this);
    }

    @Override
    public Widget asWidget() {
        return wrapperPanel;
    }

    @Override
    public HasHTML getTitle() {
        return headerText;
    }

    @Override
    public HasClickHandlers getEdit() {
        return editImage;
    }

    @Override
    public HasClickHandlers getClose() {
        return closeImage;
    }

    @Override
    public Widget getDragHandle() {
        return headerText;
    }
}
