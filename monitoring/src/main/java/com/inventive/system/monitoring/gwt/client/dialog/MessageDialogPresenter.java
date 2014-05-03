package com.inventive.system.monitoring.gwt.client.dialog;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.inventive.system.monitoring.gwt.client.mvp.AbstractMvpPresenter;
import com.inventive.system.monitoring.gwt.client.mvp.MvpView;

/**
 * User: Grant Little <grant.little@inventivesoftware.com.au>
 */
public class MessageDialogPresenter extends AbstractMvpPresenter<MessageDialogPresenter.View> {

    @ImplementedBy(MessageDialogView.class)
    public static interface View extends MvpView {
        DialogBox getDialog();
        HasClickHandlers getOkButton();
    }

    @Inject
    public MessageDialogPresenter(MessageDialogPresenter.View view) {
        super(view);
        init();

    }

    private void init() {
        getView().getOkButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                getView().getDialog().hide();
            }
        });
    }

    public void show(String title, String text) {
        getView().getDialog().setText(text);
        getView().getDialog().setTitle(title);
        getView().getDialog().center();
        getView().getDialog().show();
    }
}
