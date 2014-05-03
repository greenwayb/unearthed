package com.inventive.system.monitoring.gwt.client.statistics;

import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.*;
import com.inventive.system.monitoring.gwt.client.statistics.dto.GwtStatisticDescriptor;

/**
 * User: grant
 */
public class DescriptorsView implements DescriptorsPresenter.View {

    interface MyUiBinder extends UiBinder<DockLayoutPanel, DescriptorsView> {}

    private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

    @UiField
    DockLayoutPanel rootPanel;

    @UiField
    Button addChartButton;

    @UiField
    Button addDescriptorButton;

    @UiField
    Button refreshButton;


    @UiField
    DataGrid<GwtStatisticDescriptor> dataGrid;

    private MultiSelectionModel<GwtStatisticDescriptor> selectionModel;

//    @UiField(provided = true)
//    SimplePager pager;

    public DescriptorsView() {
        init();
    }

    private void init() {
        uiBinder.createAndBindUi(this);

//        dataGrid.setWidth("100%");
        dataGrid.setEmptyTableWidget(new Label("No data to display"));

        // Attach a column sort handler to the ListDataProvider to sort the list.
//    ColumnSortEvent.ListHandler<StatisticPublisher> sortHandler =
//        new ColumnSortEvent.ListHandler<StatisticPublisher>(ContactDatabase.get().getDataProvider().getList());
//    dataGrid.addColumnSortHandler(sortHandler);

        // Create a Pager to control the table.
//        SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
//        pager = new SimplePager(SimplePager.TextLocation.CENTER, pagerResources, false, 0, true);
//        pager.setDisplay(dataGrid);

        // Add a selection model so we can select cells.
        selectionModel =
                new MultiSelectionModel<GwtStatisticDescriptor>(GwtStatisticDescriptor.KEY_PROVIDER);
        dataGrid.setSelectionModel(selectionModel, DefaultSelectionEventManager
                .<GwtStatisticDescriptor>createCheckboxManager());

        initTableColumns(selectionModel);

        dataGrid.flush();
    }

    @Override
    public Widget asWidget() {
        return rootPanel;
    }

    @Override
    public HasClickHandlers getAddChart() {
        return addChartButton;
    }

    @Override
    public SetSelectionModel<GwtStatisticDescriptor> getSelectionModel() {
        return selectionModel;
    }

    @Override
    public HasEnabled getAddButtonEnabled() {
        return addChartButton;
    }

    private void initTableColumns(final SelectionModel<GwtStatisticDescriptor> selectionModel) {
        // Checkbox column. This table will uses a checkbox column for selection.
        // Alternatively, you can call dataGrid.setSelectionEnabled(true) to enable
        // mouse selection.
        Column<GwtStatisticDescriptor, Boolean> checkColumn =
                new Column<GwtStatisticDescriptor, Boolean>(new CheckboxCell(true, false)) {
                    @Override
                    public Boolean getValue(GwtStatisticDescriptor object) {
                        // Get the value from the selection model.
                        return selectionModel.isSelected(object);
                    }
                };
        dataGrid.addColumn(checkColumn, SafeHtmlUtils.fromSafeConstant("<br/>"));
        dataGrid.setColumnWidth(checkColumn, 40, Style.Unit.PX);

        // Environment name.
        Column<GwtStatisticDescriptor, String> environmentNameColumn =
                new Column<GwtStatisticDescriptor, String>(new EditTextCell()) {
                    @Override
                    public String getValue(GwtStatisticDescriptor object) {
                        return object.getJmxStatisticKey().getEnvironment();
                    }
                };
        environmentNameColumn.setSortable(true);
        dataGrid.addColumn(environmentNameColumn, "Environment");
        dataGrid.setColumnWidth(environmentNameColumn, 100, Style.Unit.PX);


        // Machine name.
        Column<GwtStatisticDescriptor, String> machineNameColumn =
                new Column<GwtStatisticDescriptor, String>(new EditTextCell()) {
                    @Override
                    public String getValue(GwtStatisticDescriptor object) {
                        return object.getJmxStatisticKey().getMachineName();
                    }
                };
        machineNameColumn.setSortable(true);
        dataGrid.addColumn(machineNameColumn, "Machine Name");
        dataGrid.setColumnWidth(machineNameColumn, 100, Style.Unit.PX);

        // Process name.
        Column<GwtStatisticDescriptor, String> processNameColumn =
                new Column<GwtStatisticDescriptor, String>(new EditTextCell()) {
                    @Override
                    public String getValue(GwtStatisticDescriptor object) {
                        return object.getJmxStatisticKey().getProcessName();
                    }
                };
        processNameColumn.setSortable(true);
        dataGrid.addColumn(processNameColumn, "Process Name");
        dataGrid.setColumnWidth(processNameColumn, 100, Style.Unit.PX);

        // Object name.
        Column<GwtStatisticDescriptor, String> objectNameColumn =
                new Column<GwtStatisticDescriptor, String>(new EditTextCell()) {
                    @Override
                    public String getValue(GwtStatisticDescriptor object) {
                        return object.getJmxStatisticKey().getObjectName();
                    }
                };
        objectNameColumn.setSortable(true);
        dataGrid.addColumn(objectNameColumn, "Object Name");
        dataGrid.setColumnWidth(objectNameColumn, 100, Style.Unit.PX);

        // Property name.
        Column<GwtStatisticDescriptor, String> propertyNameColumn =
                new Column<GwtStatisticDescriptor, String>(new EditTextCell()) {
                    @Override
                    public String getValue(GwtStatisticDescriptor object) {
                        return object.getJmxStatisticKey().getPropertyName();
                    }
                };
        propertyNameColumn.setSortable(true);
        dataGrid.addColumn(propertyNameColumn, "Property Name");
        dataGrid.setColumnWidth(propertyNameColumn, 100, Style.Unit.PX);

        // Field name.
        Column<GwtStatisticDescriptor, String> fieldNameColumn =
                new Column<GwtStatisticDescriptor, String>(new EditTextCell()) {
                    @Override
                    public String getValue(GwtStatisticDescriptor object) {
                        return object.getJmxStatisticKey().getFieldName();
                    }
                };
        fieldNameColumn.setSortable(true);
        dataGrid.addColumn(fieldNameColumn, "Field Name");
        dataGrid.setColumnWidth(fieldNameColumn, 100, Style.Unit.PX);


    }

    @Override
    public HasData<GwtStatisticDescriptor> getTable() {
        return dataGrid;
    }

    @Override
    public void resize() {
        dataGrid.onResize();
    }

    @Override
    public HasClickHandlers getAddPublisher() {
        return addDescriptorButton;
    }

    @Override
    public HasClickHandlers getRefresh() {
        return refreshButton;
    }
}
