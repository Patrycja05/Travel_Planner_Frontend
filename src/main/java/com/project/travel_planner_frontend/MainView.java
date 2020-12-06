package com.project.travel_planner_frontend;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

    private FlightService flightService = FlightService.getInstance();
    private Grid grid = new Grid<>(Flight.class);
    private FlightForm form = new FlightForm(this);

    public MainView() {
        grid.setColumns("flightStartingPoint", "flightDirection", "flightDate", "flightTime");
        HorizontalLayout mainContent = new HorizontalLayout(grid, form);
        mainContent.setSizeFull();
        grid.setSizeFull();

        add(mainContent);
        setSizeFull();
        refresh();
    }

    public void refresh() {
        grid.setItems(flightService.getFlights());
    }
}
