package com.inventive.system.monitoring.gwt.client.dnd;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * User: grant
 */
public class DragDropContainer extends HTMLPanel {

    private IsWidget widget;

    public DragDropContainer() {
        super("");
        setWidth("450px");
        setHeight("265px");

//        getElement().getStyle().setBorderColor("blue");
//        getElement().getStyle().setBorderStyle(Style.BorderStyle.DASHED);

    }

    public void setWidget(IsWidget widget) {
        if (null != this.widget) {
            remove(this.widget);
        }
        add(widget);
        this.widget = widget;
    }

}
