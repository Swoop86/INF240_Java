import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Filip on 30.10.2014.
 */
public class Filhåndtering {

    private final String DYRELISTE = "dyr.dat";

    public ObjectOutputStream getSkriveForbindelse(String filnavn) {
        try {
            FileOutputStream utstrøm = new FileOutputStream(filnavn);
            return new ObjectOutputStream(utstrøm);
        }catch(IOException e){return null;}
    } //metode

    public ObjectInputStream getLeseForbindelse(String filnavn) {
        try{
            FileInputStream innstrøm = new FileInputStream(filnavn);
            return new ObjectInputStream(innstrøm);
        }catch(IOException e){return null;}
    } //metode

    public void LagreDyr(List<Dyr> o) {
        try{
            ObjectOutputStream utfil = null;
            utfil = getSkriveForbindelse(DYRELISTE);
            utfil.writeObject(o);
            utfil.close();
        }catch(Exception e){e.printStackTrace();}
    }

    public List<Dyr> LeseDyr() {
        try{
            ObjectInputStream innfil = getLeseForbindelse(DYRELISTE);
            List<Dyr> lstDyr = (ArrayList<Dyr>)innfil.readObject();
            innfil.close();
            return  lstDyr;
            }catch(Exception e){e.printStackTrace(); return null;}
    }
}


