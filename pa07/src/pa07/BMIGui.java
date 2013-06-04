package pa07;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BMIGui implements ActionListener {
	private JFrame frame;
	private JTextField heightField;
	private JTextField weightField;
	private JLabel bmiLabel;
	private JButton computeButton;
	

	public BMIGui() {
		heightField = new JTextField(5);
		weightField = new JTextField(5);
		bmiLabel = new JLabel("Enter your height and weight");
		computeButton = new JButton("Compute BMI");
		computeButton.addActionListener(this);
		
		//layout
		JPanel north = new JPanel(new GridLayout(2,2));
		north.add(new JLabel("Height:"));
		north.add(heightField);
		north.add(new JLabel("Weight:"));
		north.add(weightField);
		
		//setup frame
		frame = new JFrame("BMI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(north,BorderLayout.NORTH);
		frame.add(bmiLabel, BorderLayout.CENTER);
		frame.add(computeButton,BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent event){
		String heightText = heightField.getText();
		String weightText = weightField.getText();
		double height = Double.parseDouble(heightText);
		double weight = Double.parseDouble(weightText);
		
		double bmi = 703* weight/(height*height);
		bmiLabel.setText("BMI: "+bmi);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BMIGui app = new BMIGui();

	}

}
