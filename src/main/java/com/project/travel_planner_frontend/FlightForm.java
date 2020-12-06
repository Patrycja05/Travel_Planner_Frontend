package com.project.travel_planner_frontend;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;

@Route
public class FlightForm extends FormLayout {

    private TextField flightStartingPoint = new TextField("flightStartingPoint");
    private TextField flightDirection = new TextField("flightDirection");
    private TextField flightDate = new TextField("flightDate");
    private TextField flightTime = new TextField("flightTime");
    private Button save = new Button("Save");
    private Button delete = new Button("Delete");
    private Button weather = new Button("Check the weather");
    private Button choseFlight = new Button("Chose Flight");
    private Button coronavirusInformation = new Button("Check coronavirus information");
    private Binder <Flight>binder = new Binder<>(Flight.class);
    private FlightService service = FlightService.getInstance();
    private MainView mainView;


    public FlightForm(MainView mainView) {
        this.mainView = mainView;
        HorizontalLayout buttons = new HorizontalLayout(save, delete, weather, coronavirusInformation, choseFlight);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(flightStartingPoint, flightDirection, flightDate, flightTime, buttons);
        binder.bindInstanceFields(this);
        save.addClickListener(event -> save());
        delete.addClickListener(event -> delete());
    }

    private void save() {
        Flight flight = binder.getBean();
        service.save(flight);
        mainView.refresh();
        setFlight(null);
    }

    private void setFlight(Object o) {
    }

    private void delete() {
        Flight flight = binder.getBean();
        service.delete(flight);
        mainView.refresh();
        setFlight(null);
    }
}




