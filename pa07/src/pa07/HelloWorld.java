package pa07;
import javax.swing.JOptionPane;

public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "Hello World");
		
		String name = JOptionPane.showInputDialog(null,"What's your name?");
		int choice = JOptionPane.showConfirmDialog(null,
				"Do you like this demo?");
		
		if (choice==JOptionPane.YES_OPTION){
			JOptionPane.showMessageDialog(null,"Great! I'm glad");
		}else if (choice==JOptionPane.NO_OPTION){
			JOptionPane.showMessageDialog(null, "I'm sorry to hear that!");			
		}else{
			JOptionPane.showMessageDialog(null, "Why'd you have to cancel!!");
		}
		
	}

}
