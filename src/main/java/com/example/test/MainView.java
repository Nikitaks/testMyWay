package com.example.test;


import org.jboss.logging.Logger;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinServlet;


@Route("main")
public class MainView extends VerticalLayout {

	private static final long serialVersionUID = 1L;
	
	private CounterService counterService;
	
    public MainView() {
    	
    	counterService = WebApplicationContextUtils
    	        .getWebApplicationContext(VaadinServlet.getCurrent().getServletContext())
    	        .getBean(CounterService.class);
    	Counter h2Counter = counterService.read();
    	
        TextField h2CounterField = new TextField();
        h2CounterField.setPattern("-?\\d+");
        
    	Binder<Counter> binder = new Binder<>(Counter.class);
    	binder.bind(h2CounterField, 
    			counter -> String.valueOf(counter.getCount()), 
    			(counter, newCounter) -> counter.setCount(Integer.parseInt(newCounter)));
    	
    	binder.readBean(h2Counter);
    	h2CounterField.addValueChangeListener(event -> {
            if (h2CounterField.isEmpty())
            	return;
            try {
            	binder.writeBean(h2Counter);
            	counterService.update(h2Counter);
            }
            catch (ValidationException e) {
            	Logger.getLogger(MainView.class).info(e);
            }
        });
    	h2CounterField.setValueChangeMode(ValueChangeMode.LAZY);
    	
    	Button incrementButton = new Button("Increment");
    	incrementButton.addClickListener(event -> {
    		h2Counter.setCount(h2Counter.getCount() + 1);
    		binder.readBean(h2Counter);
    		counterService.update(h2Counter);
    	});
    	
    	add(h2CounterField, incrementButton);
    }
}
