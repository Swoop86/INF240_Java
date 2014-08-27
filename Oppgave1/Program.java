import javax.swing.JOptionPane;


public class Program {
	
	public static void main(String[] args) {
		Greeting Hilsen = new Greeting();
		Hilsen.SetNavn(JOptionPane.showInputDialog("Skriv navnet ditt: "));
		Hilsen.SetHilsen(JOptionPane.showInputDialog("Skriv din hilsen: "));
		
		/** GetNavn & GetHilsen:
		* 0 gir kun verdien som er lagret
		* 1 gir en hilsning etterfulgt av verdien
		* alt annet gir null
		*/ 
		String navn = Hilsen.GetNavn(1);
		String hilsen = Hilsen.GetHilsen(1);
		
		JOptionPane.showMessageDialog(null, hilsen, navn, JOptionPane.PLAIN_MESSAGE);
	}
	
}
