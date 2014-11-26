import org.junit.internal.runners.statements.ExpectException;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fkotl_000 on 29.10.2014.
 */
public class Kontroll {
    List<Dyr> lstFangetDyr = new ArrayList<Dyr>();
    private static Kontroll kontroll = new Kontroll();
    private Kontroll(){}

    //singleton, sjekk om instansen finnes, hvis ikke, lag den.
    public static Kontroll getInstance()
    {
        if (kontroll == null)
        {Kontroll kontroll = new Kontroll();}
        return kontroll;
    }

    public void LeggTilHare(String _kjønn, String _hareType, String _hareFarge, String _fangstDato, String _fangstSted,
                            double _lengde, double _vekt)
    {
        try
        {
            Hare nyHare = new Hare(_kjønn, _hareType, _hareFarge, _fangstDato, _fangstSted, _lengde, _vekt);
            lstFangetDyr.add(nyHare);
            LagreDyr();
        }
        catch (Exception e)
        {
            throw new IllegalArgumentException("Kunne ikke opprette hare, sjekk input");
        }

    }
    public void LeggTilGaupe(String _kjønn, double _lengdeØreTuster, String _fangstDato, String _fangstSted, double _lengde,
                             double _vekt)
    {
        try
        {
            Gaupe nyGaupe = new Gaupe(_kjønn, _lengdeØreTuster, _fangstDato, _fangstSted, _lengde, _vekt);
            lstFangetDyr.add(nyGaupe);
            LagreDyr();
        }
        catch (Exception e)
        {
            throw new IllegalArgumentException("Kunne ikke opprette gaupen, sjekk input");
        }

    }

    public void GjenfangstHARE(Object h, String _gjenfangstDato, String _gjenfangstSted, String _farge, double _lengde, double _vekt)
    {
        for (Dyr item : lstFangetDyr)
        {
            if (item instanceof Hare)
            {
                Hare hare = ((Hare) item);
                if (hare.equals(h))
                {
                    try {
                        hare.LeggTilGjenfangst(hare, _gjenfangstDato,_gjenfangstSted, _farge, _lengde, _vekt);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }

                }
            }
        }

    }

    public void GjenfangstGaupe(Object g, String _fangstDato, String _fangstSted, double _lengdeØreTuster, double _lengde,
                                double _vekt)
    {
        for (Dyr item : lstFangetDyr)
        {
            if (item instanceof Gaupe)
            {
                Gaupe gaupe = ((Gaupe) item);
                if (gaupe.equals(g))
                {
                        gaupe.LeggTilGjenfangst(gaupe, _fangstDato, _fangstSted, _lengdeØreTuster, _lengde, _vekt);
                }
            }
        }
    }

    public Integer[] FinnGjenfangDyr(String årstall)
    {
        int gauper = 0;
        int harer = 0;

        for (Dyr dyr : lstFangetDyr)
        {
            if (dyr.is_gjenfangst())
            {
                if (dyr instanceof Gaupe && ((Gaupe) dyr).finnÅr(årstall))
                {
                    gauper = gauper+1;
                }
                if (dyr instanceof Hare && ((Hare) dyr).finnÅr(årstall))
                {
                    harer = harer+1;
                }
            }
        }
        return new Integer[]{gauper, harer};
    }

    public Integer[] FinnHareTyper()
    {
        int vanlig = 0;
        int sørhare = 0;
        if (lstFangetDyr != null)
        {
            for (Dyr dyr : lstFangetDyr)
            {
                if (dyr instanceof Hare)
                {
                    if (((Hare) dyr).get_hareType().equals("Vanlig"))
                    {
                        vanlig = vanlig+1;
                    }
                    else if (((Hare) dyr).get_hareType().equals("Sørhare"))
                    {
                        sørhare = sørhare+1;
                    }
                }
            }

        }
        return new Integer[]{vanlig, sørhare};
    }

    public Object SøkEtterDyr(String søkeord)
    {
        if (søkeord.substring(0,1).toUpperCase().equals("H"))
        {
            // søk etter hare
            return SøkEtterHare(søkeord.toUpperCase());
        }
        if (søkeord.substring(0,1).toUpperCase().equals("G"))
        {
            // søk etter gaupe
            return SøkEtterGaupe(søkeord.toUpperCase());
        }
        return null;
    }

    public Hare SøkEtterHare(String søkeord)
    {
        if (lstFangetDyr != null) {
            for (Dyr item : lstFangetDyr) {
                if (item instanceof Hare) {
                    Hare hare = ((Hare) item);
                    if (hare.getDyrID().equals(søkeord)) {
                        return hare;
                    }
                }
            }
        }
        return null;

    }

    public Gaupe SøkEtterGaupe(String søkeord)
    {
        if (lstFangetDyr != null)
        {
            for (Dyr item : lstFangetDyr)
            {
                if (item instanceof Gaupe)
                {
                    Gaupe gaupe = ((Gaupe) item);
                    if (gaupe.getDyrID().equals(søkeord))
                    {
                        return gaupe;
                    }
                }
            }
        }

        return null;

    }
    public DefaultListModel UsortertRapport()
    {
        DefaultListModel lstRapport = new DefaultListModel();
        for (Dyr dyr : lstFangetDyr)
        {
            lstRapport.addElement(dyr.DyreInfo(dyr));
        }
        return lstRapport;
    }

    public DefaultListModel DyreRapport(Object o)
    {
        DefaultListModel lstRapport = new DefaultListModel();
        for (Dyr dyr : lstFangetDyr)
        {
            if (dyr.equals(o))
            {
             lstRapport.addElement(dyr.DyreInfo(dyr));
            }

        }
        return lstRapport;
    }

    public void LagreDyr()
    {
        Filhåndtering lagre = new Filhåndtering();
        lagre.LagreDyr(lstFangetDyr);
    }

    public void LeseDyr()
    {
            Filhåndtering lese = new Filhåndtering();
            lstFangetDyr = lese.LeseDyr();
        if (lstFangetDyr == null)      {
            JOptionPane.showMessageDialog(null,"OBS! Ingen tidligere data er lest inn.");
        }


    }

    // UNIT TESTING
    public void TEST_LeggTilHare()
    {
        Hare nyHare = new Hare("Hann", "Vanlig", "Hvit", "29.10.2014", "Hønefoss", 15.5, 10.2);
        lstFangetDyr.add(nyHare);
        Hare nyHare2 = new Hare("hunn", "Sørhare", "Hvit", "29.10.2014", "Hønefoss", 15.5, 10.2);
        lstFangetDyr.add(nyHare2);
    }
    public void TEST_LeggTilGaupe()
    {
        Gaupe nyGaupe = new Gaupe("Hunn", 4.32, "29.10.2014", "Hønefoss", 15.5, 10.2);
        lstFangetDyr.add(nyGaupe);
        Gaupe nyGaupe2 = new Gaupe("Hunn", 4.32, "29.10.2014", "Hønefoss", 15.5, 10.2);
        lstFangetDyr.add(nyGaupe2);
    }

    public void TEST_GjenfangstHARE()
    {
        String søkeord = "H2";
        for (Dyr item : lstFangetDyr)
        {
            if (item instanceof Hare)
            {
                Hare hare = ((Hare) item);
                if (hare.getDyrID().equals(søkeord))
                {
                    hare.LeggTilGjenfangst(hare, "30.10.2014", "Kongsberg", "Brun", 15.5, 11.3);
                }
            }
        }

    }

    public void TEST_GjenfangstGaupe()
    {
        String søkeord = "G1";
            for (Dyr item : lstFangetDyr)
            {
                if (item instanceof Gaupe)
                {
                    Gaupe gaupe = ((Gaupe) item);
                    if (gaupe.getDyrID().equals(søkeord))
                    {
                        gaupe.LeggTilGjenfangst(gaupe, "30.10.2014", "Kongsberg", 4.35, 15.5, 11.3);
                    }
                }
            }
    }

    public void TEST_FinnGjenfangDyr()
    {
        String årstall = "2014";
        int gauper = 0;
        int harer = 0;
        for (Dyr dyr : lstFangetDyr)
        {
                if (dyr.is_gjenfangst())
                {
                    if (dyr instanceof Gaupe && ((Gaupe) dyr).finnÅr(årstall))
                    {
                        gauper = gauper+1;
                    }
                    if (dyr instanceof Hare && ((Hare) dyr).finnÅr(årstall))
                    {
                        harer = harer+1;
                    }
                }
        }
    }

    public void TEST_FinnHareTyper()
    {
        int vanlig = 0;
        int sørhare = 0;
        for (Dyr dyr : lstFangetDyr)
        {
            if (dyr instanceof Hare)
            {
                if (((Hare) dyr).get_hareType().equals("Vanlig"))
                {
                    vanlig = vanlig+1;
                }
                else if (((Hare) dyr).get_hareType().equals("Sørhare"))
                {
                    sørhare = sørhare+1;
                }
            }
        }

    }
    public void TEST_UsortertRapport()
    {
        for (Dyr dyr : lstFangetDyr)
        {
            System.out.println(dyr.DyreInfo(dyr));
        }
    }

    public void TEST_Lagre()
    {
        Filhåndtering lagre = new Filhåndtering();
            lagre.LagreDyr(lstFangetDyr);
    }

    public void TEST_Lese()
    {
        Filhåndtering lese = new Filhåndtering();
        lstFangetDyr = null;
        lstFangetDyr = lese.LeseDyr();
    }

}
