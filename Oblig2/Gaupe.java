import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by fkotl_000 on 29.10.2014.
 */
public class Gaupe extends Dyr implements Serializable{

    private String _fangstID = "G";
    private static AtomicInteger nextID = new AtomicInteger();

    public Gaupe(String _kjønn, double _lengdeØreTuster, String _fangstDato, String _fangstSted, double _lengde,
                 double _vekt ) {
        super(_kjønn);
        this._objektID = nextID.incrementAndGet();
        Fangstdata nyFangst = new Fangstdata(this, _fangstDato, _fangstSted, _lengdeØreTuster, _lengde, _vekt);
        lstFangstdata.add(nyFangst);
    }

    public String getDyrID() {
        return _fangstID + Integer.toString(_objektID);
    }

    void LeggTilGjenfangst(Gaupe dyr, String _fangstDato, String _fangstSted, double _lengdeØreTuster, double _lengde,
                           double _vekt)
    {
            Fangstdata gjenfangst = new Fangstdata(dyr, _fangstDato, _fangstSted, _lengdeØreTuster, _lengde, _vekt);
            this.set_gjenfangst(true);
            lstFangstdata.add(gjenfangst);
    }

    public String DyreInfo(Object o)
    {
        if (o instanceof Gaupe && o.equals(this))
        {
            // skal kun ha første fangst
            String dyrID = getDyrID();
            String fangstdato = lstFangstdata.get(0)._fangstDato;
            String fangststed = lstFangstdata.get(0)._fangstSted;
            String vekt = Double.toString(lstFangstdata.get(0).get_vekt());
            String lengde = Double.toString(lstFangstdata.get(0).get_lengde());
            String kjønn = this.get_kjønn();
            String øretust = Double.toString(lstFangstdata.get(0).get_lengdeØreTuster());

            return "Gaupe " + dyrID + " " + kjønn + " " + fangststed + " " + fangstdato + " " + vekt + "Kg " + lengde + "CM " + øretust + "CM";

        }
        return null;
    }

}
