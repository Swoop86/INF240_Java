import javax.swing.JOptionPane;


public class Program {
	
	public static void main(String[] args) {
		Greeting Hilsen = new Greeting();
		Hilsen.SetNavn(JOptionPane.showInputDialog("Skriv navnet ditt: "));
		Hilsen.SetHilsen(JOptionPane.showInputDialog("Skriv din hilsen: "));
		
		/** GetHilsen, 0 gir kun hilsningen som er lagret
		* 1 gir "Din hilsen er:" + hilsning
		* alt annet gir null
		*/ 
		JOptionPane.showMessageDialog(null, Hilsen.GetHilsen(1));
	}
	
}
