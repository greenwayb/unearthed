package com.inventive.system.monitoring.gwt.client.dnd;

import com.google.gwt.user.client.ui.IsWidget;

/**
 * User: grant
 */
public interface HasPosition {

    int getColumn();

    int getRow();

    void setPosition(int row, int column);

}
