package br.com.temperatura.view;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ConversorOverview extends JFrame{
	
	private JLabel simboloTemperaturaLabel;
	private JTextField valorTextField;
	private JButton converterButton;
	private JRadioButton celsiusRadioButton;
	private JRadioButton fahrenheitRadioButton;
	private JLabel resultadoConversaoLabel;
	private JPanel jContentPane;
	private JLabel resultadoTitleConversaoLabel;
	private JLabel valorLabel;
	private JLabel titleLabel;
	
	public ConversorOverview() {
		super();
		initialize();
	}
	
	private void initialize() {
		this.setSize(408, 359);
		this.setContentPane(getJContentPane());
		this.setTitle("Conversor de Temperatura");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocation(
						((Toolkit.getDefaultToolkit().getScreenSize().width / 2) - (this
								.getWidth() / 2)),
						((Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (this
								.getHeight() / 2)));
		
		createRbGroup();
	}
	
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			jContentPane.setPreferredSize(new Dimension(850, 850));
			jContentPane.add(getResultadoTitleConversaoLabel(), null);
			jContentPane.add(getValorLabel(), null);
			jContentPane.add(getTitleLabel(), null);
			jContentPane.add(getSimboloTemperaturaLabel(), null);
			jContentPane.add(getValorTextField(), null);
			jContentPane.add(getConverterButton(), null);
			jContentPane.add(getCelsiusRadioButton(), null);
			jContentPane.add(getFahrenheitRadioButton(), null);
			jContentPane.add(getResultadoConversaoLabel(), null);
		}
		return jContentPane;
	}
	
	public JButton getConverterButton() {
		if(converterButton == null){
			converterButton = new JButton("Converter");
			converterButton.setBounds(new Rectangle(157, 215, 110, 25));
			converterButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					handleConverterButton();
				}
			});
		}
		return converterButton;
	}
	
	public JLabel getSimboloTemperaturaLabel() {
		if(simboloTemperaturaLabel == null){
			simboloTemperaturaLabel = new JLabel("C");
			simboloTemperaturaLabel.setBounds(new Rectangle(205, 90, 40, 17));
		}
		return simboloTemperaturaLabel;
	}
	
	public JTextField getValorTextField() {
		if(valorTextField == null){
			valorTextField = new JTextField("");
			valorTextField.setBounds(new Rectangle(105, 90, 75, 17));
		}
		return valorTextField;
	}
	
	public JRadioButton getCelsiusRadioButton() {
		if(celsiusRadioButton == null){
			celsiusRadioButton = new JRadioButton("Celsius");
			celsiusRadioButton.setBounds(new Rectangle(154, 132, 150, 17));
			celsiusRadioButton.setSelected(true);
			celsiusRadioButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					getSimboloTemperaturaLabel().setText("C");
				}
			});
		}
		return celsiusRadioButton;
	}
	
	public JRadioButton getFahrenheitRadioButton() {
		if(fahrenheitRadioButton == null){
			fahrenheitRadioButton = new JRadioButton("Fahrenheit");
			fahrenheitRadioButton.setBounds(new Rectangle(154, 166, 150, 17));
			fahrenheitRadioButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					getSimboloTemperaturaLabel().setText("F");
				}
			});
		}
		return fahrenheitRadioButton;
	}
	
	public JLabel getTitleLabel() {
		if(titleLabel == null){
			titleLabel = new JLabel("Conversor de Temperatura");
			titleLabel.setBounds(new Rectangle(19, 36, 200, 17));
		}
		return titleLabel;
	}
	
	public JLabel getValorLabel() {
		if(valorLabel == null){
			valorLabel = new JLabel("Valor");
			valorLabel.setBounds(new Rectangle(47, 90, 80, 17));
		}
		return valorLabel;
	}
	
	public JLabel getResultadoTitleConversaoLabel() {
		if(resultadoTitleConversaoLabel == null){
			resultadoTitleConversaoLabel = new JLabel("Resultado");
			resultadoTitleConversaoLabel.setBounds(new Rectangle(47, 273, 200, 17));
		}
		return resultadoTitleConversaoLabel;
	}
	
	public JLabel getResultadoConversaoLabel() {
		if(resultadoConversaoLabel == null){
			resultadoConversaoLabel = new JLabel("");
			resultadoConversaoLabel.setBounds(new Rectangle(143, 273, 200, 17));
		}
		return resultadoConversaoLabel;
	}
	
	private void createRbGroup(){
		ButtonGroup group = new ButtonGroup();
		group.add(getFahrenheitRadioButton());
		group.add(getCelsiusRadioButton());
	}
	
	private void handleConverterButton() {
		// Formula: c/5 = (f-32)/9;
		int valor = Integer.parseInt(getValorTextField().getText());
		String resultado = "";
		
		if(getCelsiusRadioButton().isSelected()){ // Celsius -> Fahrenheit
			double f = (1.8 * valor) + 32;
			resultado = String.format("%.1f", f) + " F";
			
		} else{ // Fahrenheit -> Celsius
			double c = (double) ((valor - 32) / 1.8);
			resultado = String.format("%.1f", c) + " C";
		}
		
		getResultadoConversaoLabel().setText(resultado);
	}
}
