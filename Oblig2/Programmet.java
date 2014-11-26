import javax.swing.*;

/**
 * Created by fkotl_000 on 29.10.2014.
 */
public class Programmet {
    public static void main(String[] args) {
        Kontroll.getInstance().TEST_LeggTilHare();
        Kontroll.getInstance().TEST_LeggTilGaupe();

        GUI gui = new GUI();
        gui.VisHovedMeny();
        Kontroll.getInstance().LeseDyr();




//        Kontroll.getInstance().TEST_GjenfangstGaupe();
//        Kontroll.getInstance().TEST_FinnGjenfangDyr();
//        Kontroll.getInstance().TEST_FinnHareTyper();
//        Kontroll.getInstance().TEST_UsortertRapport();
//        Kontroll.getInstance().TEST_Lagre();
//        Kontroll.getInstance().TEST_Lese();


    }
}
