package co.edu.uniquindio.centroimpresion.view.print;

import co.edu.uniquindio.centroimpresion.controllers.CtrlPrintDoc;
import co.edu.uniquindio.centroimpresion.view.custom.PanelConVolver;
import co.edu.uniquindio.centroimpresion.view.custom.PanelMenuOpcionObjetos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class PanelPrintEspDoc extends PanelConVolver {
	private PanelMenuOpcionObjetos panel;

	public PanelPrintEspDoc(PanelMenuOpcionObjetos panel) {
		this.panel = panel;
		initComp();
	}

	public void initComp() {
		super.initComp();

		VBox vbox = new VBox(30);
		Label btnImprimir = new Label("Imprimir");
		Label btnVerCola = new Label("Ver cola");
		BorderPane btnImprimirCase = new BorderPane(btnImprimir);
		BorderPane btnVerColaCase = new BorderPane(btnVerCola);

		vbox.setId("centered-box");
		btnVerCola.setId("btn");
		btnImprimir.setId("btn");
		btnImprimirCase.setId("btn-case");
		btnVerColaCase.setId("btn-case");

		btnImprimir.setOnMouseReleased(evt -> CtrlPrintDoc.irAPedirImpresora(panel, this, stage));
		btnVerCola.setOnMouseReleased(evt -> CtrlPrintDoc.verPrimerDocumento(stage));
		vbox.getChildren().add(btnImprimirCase);
		vbox.getChildren().add(btnVerColaCase);
		setCenter(vbox);
	}

	@Override
	public void volverPresionado() {
		panel.initComp();
	}
}
