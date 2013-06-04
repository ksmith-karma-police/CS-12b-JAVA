package pa07;
import javax.swing.JOptionPane;

public class BMI {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String weight = JOptionPane.showInputDialog(null,"What is your weight in pounds?");
		String height = JOptionPane.showInputDialog(null,"What is your height in inches");
		double w = Double.parseDouble(weight);
		double h = Double.parseDouble(height);
		double wkg = w/2.2;
		double hm = h/39.6;
		double bmi = wkg/(hm*hm);
		JOptionPane.showMessageDialog(null,"Your BMI is "+bmi);
	}

}
