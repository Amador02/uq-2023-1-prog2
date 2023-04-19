package co.edu.uniquindio.agentatelefonica.p2.views.internal;

import co.edu.uniquindio.centroimpresion.util.Boton;
import co.edu.uniquindio.centroimpresion.util.Utility;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class PanelBuscarContacto extends BorderPane {
	public PanelBuscarContacto(EventHandler<? super MouseEvent> eventoVolver) {
		VBox vbox = new VBox(20);
		TextField tfNombre = new TextField();
		Boton botonAgregar = new Boton("Buscar", e -> {
			System.out.println("buscado");
		});
		vbox.setId("centered-box");
		vbox.getChildren().add(Utility.generarHBox("Escribe un nombre para buscar el contacto", tfNombre));
		vbox.getChildren().add(botonAgregar);
		Boton botonVolver = new Boton("Volver", eventoVolver, "btn-volver");
		setCenter(vbox);
		setBottom(botonVolver);
	}
}