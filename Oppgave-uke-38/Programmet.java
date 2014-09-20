/**
 * Created by Filip on 19.09.2014.
 */
import javax.swing.*;
import javax.swing.text.html.ObjectView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

public class Programmet {
    public static void main(String[] args) {
        Programmet gui = new Programmet();
        gui.meny();
        Kontroller kontroller = Kontroller.getKontroller();
    }

    public void meny()
    {
        boolean fortsett = true;
        final String[] ALTERNATIVER = {"Ny person", "Finn person", "Legg til bil", "Avslutt"};

        while(fortsett)
        {
            int valg = JOptionPane.showOptionDialog(null, "Velg hva du ønsker å gjøre","Personer", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, ALTERNATIVER, ALTERNATIVER[0]);
            switch(valg)
            {
                case 0: LeggTilPerson();
                    break;
                case 1: FinnPerson();
                    break;
                case 2: LeggTilBil();
                    break;
                default: fortsett = false;
            }
        }

    }

    public void LeggTilPerson()
    {
        JTextField fornavn = new JTextField(20);
        JTextField etternavn = new JTextField(20);
        JTextField fdato = new JTextField(20);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Fornavn:"));
        myPanel.add(fornavn);
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Etternavn:"));
        myPanel.add(etternavn);
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Fødselsdato:"));
        myPanel.add(fdato);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Skriv inn persondata", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {

            Kontroller.getKontroller().LeggTilPerson(fornavn.getText(),etternavn.getText(),Integer.parseInt(fdato.getText()));
            JOptionPane.showMessageDialog(null, "Ny person ble lagt til uten feil");
        }

    }

    public void FinnPerson()
    {
        JTextField søkestreng = new JTextField(20);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Søkestreng:"));
        myPanel.add(søkestreng);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Skriv inn søkedata", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            Person person = Kontroller.getKontroller().HentPerson(søkestreng.getText());
         }

    }

    public void LeggTilBil()
    {
        JTextField modell = new JTextField(20);
        JTextField type = new JTextField(20);
        JTextField regnr = new JTextField(20);
        JComboBox eierListe = new JComboBox();

        for (Person person : Kontroller.getKontroller().HentPersoner())
        {
            eierListe.addItem(person);
        }

        JPanel myPanel = new JPanel();
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
        myPanel.add(new JLabel("Modell:"));
        myPanel.add(modell);
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Type:"));
        myPanel.add(type);
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Registreringsnummer:"));
        myPanel.add(regnr);
        myPanel.add(new JLabel("Velg eier:"));
        myPanel.add(eierListe);
        eierListe.setVisible(true);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Skriv inn bildata", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            Object eier = eierListe.getSelectedItem();
            Kontroller.getKontroller().LeggTilBil(modell.getText(), type.getText(), Integer.parseInt(regnr.getText()), eier);
            JOptionPane.showMessageDialog(null, "Ny bil ble lagt til uten feil");
        }

    }

}
