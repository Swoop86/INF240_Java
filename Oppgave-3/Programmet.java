/**
 * Created by fkotl_000 on 11.09.2014.
 */
import java.util.*;

public class Programmet {

    public static void main(String[] args) {
        List<Prosjekt> lstProsjekt = new ArrayList<Prosjekt>();

        boolean fortsett = true;
        while (fortsett) {
            switch (VisMeny()) {
                case 1: NyttProsjekt(lstProsjekt);
                    break;
                case 2: VisProsjektMeny(lstProsjekt);
                break;
                case 3: VisProsjekter(lstProsjekt);
                    break;
                default:
                    fortsett = false;
            }
        }
    }

    public static int VisMeny()
    {
        Scanner sc = new Scanner(System.in);
        int valg = 0;
        System.out.println("");
        System.out.println("*** Prosjektprogrammet ***");
        System.out.println("1: Nytt prosjekt");
        System.out.println("2: Velg prosjekt");
        System.out.println("3: Vis prosjekter");
        System.out.println("4: Avslutt");

        valg = sc.nextInt();
        return valg;
    }
    public static void NyttProsjekt(List<Prosjekt> lstProsjekt)
        {
        String prosjektNavn, prosjektAnsvarlig;
        int prosjektBudsjett;

        Scanner sc = new Scanner(System.in);
        System.out.println("Skriv inn prosjektnavn");
        prosjektNavn = sc.next();
        System.out.println("Skriv inn prosjektansvarlig");
        prosjektAnsvarlig = sc.next();
        System.out.println("Skriv inn startbeløp som er påløpt");
        prosjektBudsjett = sc.nextInt();
        Prosjekt prosjekt = new Prosjekt(prosjektNavn, prosjektAnsvarlig, prosjektBudsjett);
        lstProsjekt.add(prosjekt);
    }

    public static void VisProsjekter(List<Prosjekt> Prosjekter)
    {
        if (Prosjekter == null)
        {
            System.out.println("Ingen prosjekter tilgjengelige");
        }
        else {
            for (Prosjekt element : Prosjekter)
            {
                int totalsum = 0;
                System.out.println("Prosjekt: " + element.getProsjektTittel());
                System.out.println("Ansvarlig: " + element.getProsjektAnsvarlig());
                System.out.println("Pengebeløp påløpt: ");
                for (int i = 0; i < element._budsjett.size(); i++)
                {
                    System.out.println(Integer.toString(i) + ": " + Integer.toString(element._budsjett.get(i)));
                    totalsum += element._budsjett.get(i);
                }
                System.out.println("Totalsum påløpt: " + totalsum);

            }

        }
    }


    public static void VisProsjektMeny(List<Prosjekt> prosjekt)
    {
        String valg;
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.println("Skriv prosjektnavnet du ønsker å velge: ");
        valg = sc.next();
        for (Prosjekt element : prosjekt)
        {
            if (element._prosjektTittel.equals(valg))
            {
                VelgProsjekt(element);
            }
            else
            {
                System.out.println("Finner ikke valgt prosjekt");
            }

        }

    }

    public static void VelgProsjekt(Prosjekt prosjekt)
    {
        Scanner sc = new Scanner(System.in);

            int valg;
            System.out.println("Valg for " + prosjekt._prosjektTittel);
            System.out.println("1: Legg til pengebeløp");
            System.out.println("2: Slett pengebeløp");
            valg = sc.nextInt();
            switch (valg)
            {
                case 1: ProsjektLeggTilPenger(prosjekt);
                    break;
                case 2: ProsjektSlettPenger(prosjekt);
                    break;
            }
        }


    public static void ProsjektLeggTilPenger(Prosjekt prosjekt)
    {
        int belop;
        Scanner sc = new Scanner(System.in);
        System.out.println("Skriv inn beløp:");
        belop = sc.nextInt();
        prosjekt.setBudsjett(belop);
        System.out.println("Beløpet lagt til uten feil");
    }

    public static void ProsjektSlettPenger(Prosjekt prosjekt)
    {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < prosjekt._budsjett.size(); i++)
        {
            System.out.println(Integer.toString(i) + ": " + Integer.toString(prosjekt._budsjett.get(i)));
        }
        System.out.println("Velg hvilket beløp du ønsker fjernet");
        int valg = sc.nextInt();
        prosjekt.RemoveBudsjett(valg);
        System.out.println("Beløpet ble fjernet uten feil");
    }



}
