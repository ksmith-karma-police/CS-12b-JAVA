package pa07;
import java.awt.*;
import javax.swing.*;

public class ComponentDemo {


	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(300,150));
		frame.setBackground(Color.WHITE);
		frame.setTitle("CompDemo");
		frame.setLayout(new FlowLayout());
		
		JLabel label1 = new JLabel("Component Demo!!");
		frame.add(label1);
		
		JButton button1 = new JButton();
		button1.setText("Go");
		button1.setForeground(Color.GREEN);
		button1.setToolTipText("push to get going!");
		frame.add(button1);
		
		JButton button2 = new JButton();
		button2.setText("Stop");
		button2.setForeground(Color.RED);
		button2.setToolTipText("push to stop everything!");
		frame.add(button2);
		
		

		JLabel labelText = new JLabel("height:");
		
		JTextField text1 = new JTextField();
		text1.setText("68.0");
		text1.setToolTipText("Enter your height in inches");

		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		panel1.add(labelText);
		panel1.add(text1);
		
		JLabel label2 = new JLabel(".........");

		frame.add(panel1);
		
		JSlider slider1 = new JSlider();
		frame.add(slider1);
		
		
		
		frame.pack();
		frame.setVisible(true);
		

	}
	

}
