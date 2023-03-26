package customized;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class CustomBoton extends JPanel implements MouseListener {

	private String opt[];
	private JLabel label;
	private Color colCambio = Herramientas.white;
	private int pos = 0;
	private List<BotonListener> listaCambios = new ArrayList<BotonListener>();

	public CustomBoton(String opt[]) {
		setOptions(opt);
		label = new JLabel();
		getLabel().setText(opt[pos]);
		getLabel().setFont(Herramientas.FUENTE_COOLVETICA);
		getLabel().setHorizontalAlignment(0);
		setCursor(Herramientas.HAND_CURSOR);
		setLayout(new BorderLayout());
		setBackground(Herramientas.black);
		setForeground(Herramientas.white);
		addMouseListener(this);
		setBorder(new LineBorder(getColCambio()));
		add(getLabel(), "Center");
	}

	public void setFontSize(float size) {
		getLabel().setFont(getLabel().getFont().deriveFont(size));
	}

	public CustomBoton(String opt) {
		String arr[] = new String[1];
		arr[0] = opt;
		setOptions(arr);
		label = new JLabel();
		getLabel().setText(opt);
		getLabel().setFont(Herramientas.FUENTE_COOLVETICA);
		getLabel().setHorizontalAlignment(0);
		setCursor(Herramientas.HAND_CURSOR);
		setLayout(new BorderLayout());
		setBackground(Herramientas.black);
		setForeground(Herramientas.white);
		addMouseListener(this);
		setBorder(new LineBorder(getColCambio()));
		add(getLabel(), "Center");
	}

	public void addBotonListener(BotonListener evento) {
		listaCambios.add(evento);
	}

	public String getText() {
		if (getLabel() != null)
			return getLabel().getText();
		return null;
	}

	public void setForeground(Color c) {
		if (getLabel() != null)
			getLabel().setForeground(c);
	}

	public void setFont(Font f) {
		if (getLabel() != null) {
			if (getHeight() != 0) {
				getLabel().setFont(f);
			} else {
				getLabel().setFont(f);
			}
		}
	}

	public Font getFont() {
		if (getLabel() != null) {
			return getLabel().getFont();
		}
		return super.getFont();
	}

	public void setText(String text) {
		getLabel().setText(text);
	}

	public String[] getOptions() {
		return opt;
	}

	public void setOptions(String opt[]) {
		this.opt = opt;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {

	}

	public boolean estaEnRango() {
		return getMousePosition() != null;
	}

	public void mouseReleased(MouseEvent e) {
		if (estaEnRango()) {
			pos++;
			if (getOptions().length > pos) {
				setText(getOptions()[pos]);
			} else {
				pos = 0;
				setText(getOptions()[0]);
			}
			for (BotonListener c : listaCambios)
				c.BotonPresionado(this);
		}
	}

	public void mouseEntered(MouseEvent e) {
		setBackground(getColCambio());
		setForeground(Herramientas.black);
	}

	public void mouseExited(MouseEvent e) {
		setBackground(Herramientas.black);
		setForeground(getColCambio());
	}

	public Color getColCambio() {
		return colCambio;
	}

	public void actualizarColor(Color colCambio) {
		this.colCambio = colCambio;
		setBorder(new LineBorder(getColCambio()));
		setBackground(Herramientas.black);
		setForeground(getColCambio());
	}

	public void setBounds(Rectangle r) {
		super.setBounds(r);
		if (getLabel() != null)
			Herramientas.cambiarTamLabel(getBounds(), getLabel());
	}

	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);
		if (getLabel() != null)
			Herramientas.cambiarTamLabel(getBounds(), getLabel());
	}
}
