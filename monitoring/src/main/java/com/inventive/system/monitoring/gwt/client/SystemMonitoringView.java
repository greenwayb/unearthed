package com.inventive.system.monitoring.gwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.event.logical.shared.HasSelectionHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Grant Little <grant.little@inventivesoftware.com.au>
 */
public class SystemMonitoringView implements SystemMonitoringPresenter.View {

    interface SystemMonitoringViewUiBinder extends UiBinder<TabLayoutPanel, SystemMonitoringView> {
    }

    private static SystemMonitoringViewUiBinder ourUiBinder = GWT.create(SystemMonitoringViewUiBinder.class);

    @UiField
    TabLayoutPanel tabLayoutPanel;


    @UiField
    Button addWidgetButton;

    @UiField
    SimpleLayoutPanel descriptorsWrapperPanel;

    @UiField
    SimplePanel dragDropWrapperPanel;

    public SystemMonitoringView() {
        ourUiBinder.createAndBindUi(this);
    }

    @Override
    public HasClickHandlers getAddWidgetButton() {
        return addWidgetButton;
    }

    @Override
    public Widget asWidget() {
        return tabLayoutPanel;
    }

    @Override
    public HasEnabled getAddButtonEnabled() {
        return addWidgetButton;
    }

//    @Override
//    public HasOneWidget getDescriptorsWrapperPanel() {
//        return descriptorsWrapperPanel;
//    }

    @Override
    public HasSelectionHandlers<Integer> getTabSelectionHandlers() {
        return tabLayoutPanel;
    }

    @Override
    public void setDragDopView(IsWidget dragDropView) {
        dragDropWrapperPanel.setWidget(dragDropView);
    }
}