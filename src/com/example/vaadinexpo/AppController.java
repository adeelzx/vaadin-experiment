package com.example.vaadinexpo;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Calendar;
import com.vaadin.ui.ColorPicker;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("vaadinexpo")
public class AppController extends UI {
	
	
	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = AppController.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		Button button = new Button("Click Me");
		button.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				layout.addComponent(new Label("Thank you for clicking Adeel"));
			}
		});
		ColorPicker picker = new ColorPicker("Pick something for you");
		Accordion ac = new Accordion();
		ac.addComponent(new Button("Hey there"));
		ac.setCaption("Captions");
		Button a = new Button("Button with Action Listener");
		ac.addComponent(new Label("All contents here"));
		a.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
			Calendar cal = new Calendar();
			layout.addComponent(cal);
			}
		});
		TabSheet sheet = new TabSheet();
		
		Component result = null;
		result = new InlineTextEditor("Adeel");
		
		sheet.addComponents(picker,a,ac);
		layout.addComponent(sheet);
		layout.addComponent(result);
	}
}