import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Filip on 02.11.2014.
 */
public class GUI {

    // OBS OBS: VisLeggTilDyr og VisGjenfangstDyr kunne vært splittet opp.

    final String[] tilgjengeligeDyr = {"Hare", "Gaupe"};
    final String[] dyreKjønn = {"Hann", "Hunn"};

    public void VisHovedMeny()
    {
        boolean fortsett = true;
        final String[] ALTERNATIVER = {"Legg til nye dyr","Gjenfangst av dyr","Søk på dyr","Liste over gjenfangster",
                "Finn haretyper", "Usortert rapport", "Avslutt"};

        while(fortsett)
        {
            int valg = JOptionPane.showOptionDialog(null, "Velg hva du ønsker å gjøre", "Dyrefangst",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, ALTERNATIVER, ALTERNATIVER[0]);
            switch(valg)
            {
                case 0: VisLeggTilDyr();
                    break;
                case 1: VisSøkDyr("gjenfangst");
                    break;
                case 2: VisSøkDyr("søk");
                    break;
                case 3: VisListeGjenfangstDyr();
                    break;
                case 4: VisFinnHareTyper();
                    break;
                case 5: VisUsortertRapport();
                    break;

                default: fortsett = false; // Avslutt
            }
        }
    }

    public void VisLeggTilDyr()
    {

        //Jeg har forsøkt å få JPanel til å populere tekstboksene dynamisk utifra hvilket valg som blir
        //gjort i comboboxen, men etter 6 timer, så ga jeg opp med å få det til å fungere, og valgte denne
        //løsningen, den er ikke ideel, men den gjør det oppgaven krever.

        // Spesifikt for alle dyr
        JTextField txtFangstDato = new JTextField(20);
        JTextField txtFangstSted = new JTextField(20);
        JTextField txtDyreLengde = new JTextField(20);
        JTextField txtDyreVekt = new JTextField(20);

        // For Hare
        JTextField txtHareType = new JTextField(20);
        JTextField txtHareFarge = new JTextField(20);

        // For gaupe
        JTextField txtGaupeØretustLengde = new JTextField(10);

        JPanel mainPanel = new JPanel();

        final JComboBox lstDyreliste = new JComboBox(tilgjengeligeDyr);
        final JComboBox lstdyreKjønn = new JComboBox(dyreKjønn);

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); // verikal oppdeling for å skape penere gui
        mainPanel.add(Box.createHorizontalStrut(15)); // mellomrom mellom labels
        mainPanel.add(new JLabel("Type dyr:"));
        mainPanel.add(lstDyreliste);
        mainPanel.add(new JLabel("Kjønn:"));
        mainPanel.add(lstdyreKjønn);
        mainPanel.add(new JLabel("Fangstdato (DD.MM.ÅÅÅÅ):"));
        mainPanel.add(txtFangstDato);
        mainPanel.add(new JLabel("Fangststed:"));
        mainPanel.add(txtFangstSted);
        mainPanel.add(new JLabel("Lengde:"));
        mainPanel.add(txtDyreLengde);
        mainPanel.add(new JLabel("Vekt:"));
        mainPanel.add(txtDyreVekt);
        mainPanel.add(new JLabel("Harefarge:"));
        mainPanel.add(txtHareFarge);
        mainPanel.add(new JLabel("Haretype:"));
        mainPanel.add(txtHareType);
        mainPanel.add(new JLabel("Øretust lengde (gaupe):"));
        mainPanel.add(txtGaupeØretustLengde);

        lstDyreliste.setSelectedIndex(0);

        int result = JOptionPane.showConfirmDialog(null, mainPanel,
                "Dyrefangst", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try
            {
                Kontroll kontroll = Kontroll.getInstance();

                if (lstDyreliste.getSelectedIndex() == 0)
                {
                    // hare er valgt
                    kontroll.LeggTilHare(lstdyreKjønn.getSelectedItem().toString(), txtHareType.getText(),txtHareFarge.getText(),
                            txtFangstDato.getText(),txtFangstSted.getText(), Double.parseDouble(txtDyreLengde.getText()),
                            Double.parseDouble(txtDyreVekt.getText()));
                    JOptionPane.showMessageDialog(null,"Dyret ble lagt til uten feil");
                    VisHovedMeny();

                }
                else
                {
                    // gaupe er valgt
                    kontroll.LeggTilGaupe(lstdyreKjønn.getSelectedItem().toString(), Double.parseDouble(txtGaupeØretustLengde.getText()),
                            txtFangstDato.getText(),txtFangstSted.getText(),Double.parseDouble(txtDyreLengde.getText()),
                            Double.parseDouble(txtDyreLengde.getText()));
                    JOptionPane.showMessageDialog(null, "Dyret ble lagt til uten feil");
                    VisHovedMeny();
                }

            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
                VisLeggTilDyr(); // viser menyen igjen, dersom en feil dukker opp.
            }
        }

    }

    public void VisGjenfangstDyr(Object o)
    {
        // Spesifikt for alle dyr
        JTextField txtFangstDato = new JTextField(20);
        JTextField txtFangstSted = new JTextField(20);
        JTextField txtDyreLengde = new JTextField(20);
        JTextField txtDyreVekt = new JTextField(20);
        JTextField txtHareFarge = new JTextField(20);
        JTextField txtTustLengde = new JTextField(20);


        JPanel gjenfangst = new JPanel();
        gjenfangst.setLayout(new BoxLayout(gjenfangst, BoxLayout.Y_AXIS)); // verikal oppdeling for å skape penere gui
        gjenfangst.add(Box.createHorizontalStrut(15)); // mellomrom mellom labels

         if (o instanceof Hare)
        {
            // funnet hare
            gjenfangst.add(new JLabel("Hare ID: "+((Hare) o).getDyrID()));
            gjenfangst.add(new JLabel("Haretype: "+((Hare) o).get_hareType()));
            gjenfangst.add(new JLabel("Harefarge:"));

            gjenfangst.add(txtHareFarge);

        }
        else if (o instanceof Gaupe)
        {
            // funnet gaupe
            gjenfangst.add(new JLabel("Gaupe ID: "+((Gaupe) o).getDyrID()));
            gjenfangst.add(new JLabel("Øretust lengde:"));
            gjenfangst.add(txtTustLengde);
        }

        gjenfangst.add(new JLabel("Fangstdato (DD.MM.ÅÅÅÅ):"));
        gjenfangst.add(txtFangstDato);
        gjenfangst.add(new JLabel("Fangststed:"));
        gjenfangst.add(txtFangstSted);
        gjenfangst.add(new JLabel("Lengde:"));
        gjenfangst.add(txtDyreLengde);
        gjenfangst.add(new JLabel("Vekt:"));
        gjenfangst.add(txtDyreVekt);

        int result = JOptionPane.showConfirmDialog(null, gjenfangst,
                "Gjenfangst", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION)
        {

            try{
                if (o instanceof Hare) {
                    Kontroll.getInstance().GjenfangstHARE(o, txtFangstDato.getText(), txtFangstSted.getText(), txtHareFarge.getText(),
                            Double.parseDouble(txtDyreLengde.getText()), Double.parseDouble(txtDyreVekt.getText()));

                }
                if (o instanceof Gaupe) {
                    Kontroll.getInstance().GjenfangstGaupe(o, txtFangstDato.getText(), txtFangstSted.getText(),
                            Double.parseDouble(txtTustLengde.getText()), Double.parseDouble(txtDyreLengde.getText()),
                            Double.parseDouble(txtDyreVekt.getText()));
                }
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
                VisGjenfangstDyr(o);
            }


        }


    }

    public void VisSøkDyr(String Opsjon)
    {
        JPanel searchPanel = new JPanel();
        JTextField txtSøkefelt = new JTextField(5);
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.Y_AXIS)); // verikal oppdeling for å skape penere gui
        searchPanel.add(Box.createHorizontalStrut(15)); // mellomrom mellom labels

        searchPanel.add(new JLabel("Hva er dyrets identitet?"));
        searchPanel.add(txtSøkefelt);

        int result = JOptionPane.showConfirmDialog(null, searchPanel,
                "Søk etter dyr", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION)
        {
            Object søkeobjekt = Kontroll.getInstance().SøkEtterDyr(txtSøkefelt.getText());
            if (søkeobjekt != null && Opsjon.equals("gjenfangst"))
            {
                VisGjenfangstDyr(søkeobjekt);
            }
            else if (søkeobjekt != null && Opsjon.equals("søk"))
            {
                VisGjenfangstValgtDyr(søkeobjekt);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Ingen dyr funnet på den ID'en");
                VisSøkDyr(Opsjon);
            }


        }

    }

    public void VisListeGjenfangstDyr()
    {
        JPanel searchPanel = new JPanel();
        JTextField txtSøkefelt = new JTextField(5);

        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.Y_AXIS)); // verikal oppdeling for å skape penere gui
        searchPanel.add(Box.createHorizontalStrut(15)); // mellomrom mellom labels

        searchPanel.add(new JLabel("Hvilket årstall vil du søke på?"));
        searchPanel.add(txtSøkefelt);

        int result = JOptionPane.showConfirmDialog(null, searchPanel,
                "Søk etter gjenfangster", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION)
        {
            try {
                Integer[] arrDyr = Kontroll.getInstance().FinnGjenfangDyr(txtSøkefelt.getText());
                JOptionPane.showMessageDialog(null, "Antall gauper: " + arrDyr[0].toString() + " | Antall " +
                        "harer: " + arrDyr[1].toString());
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "Ingen dyr å vise gjenfangster på i " + txtSøkefelt.getText());
            }

        }
    }

    public void VisFinnHareTyper()
    {
        try
        {
            Integer[] arrHareType = Kontroll.getInstance().FinnHareTyper();
            JOptionPane.showMessageDialog(null, "Antall vanlige: " + arrHareType[0] + " | Antall sørharer: " + arrHareType[1] );
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

    }
    public void VisUsortertRapport()
    {
        try {
            JFrame.setDefaultLookAndFeelDecorated(true);
            JFrame frame = new JFrame("Usortert rapport");
            frame.setLayout(new FlowLayout());
            JList list = new JList(Kontroll.getInstance().UsortertRapport());
            list.setSelectedIndex(1);
            frame.add(new JScrollPane(list));
            frame.pack();
            frame.setVisible(true);

            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing(e);
                    frame.setVisible(false);
                    VisHovedMeny();
                }
            });
        }
        catch (Exception e) {JOptionPane.showMessageDialog(null,"Ingen data tilgjengelig");}
    }
    public void VisGjenfangstValgtDyr(Object o)
    {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Gjenfangster på valgt dyr");
        frame.setLayout(new FlowLayout());
        JList list = new JList(Kontroll.getInstance().DyreRapport(o));
        list.setSelectedIndex(1);
        frame.add(new JScrollPane(list));
        frame.pack();
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                frame.setVisible(false);
                VisHovedMeny();
            }
        });
    }
}
