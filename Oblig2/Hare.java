import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by fkotl_000 on 29.10.2014.
 */
public class Hare extends Dyr implements Serializable{

    private String _fangstID = "H";
    private String _hareType;
    private static AtomicInteger nextID = new AtomicInteger();

    public Hare(String _kjønn, String _hareType, String _hareFarge, String _fangstDato, String _fangstSted,
                double _lengde, double _vekt ) {
        super(_kjønn);
        this._hareType = _hareType;
        this._objektID = nextID.incrementAndGet();
        Fangstdata nyFangst = new Fangstdata(this, _fangstDato, _fangstSted, _hareFarge, _lengde, _vekt);
        lstFangstdata.add(nyFangst);
    }

    public String getDyrID() {
        return _fangstID + String.valueOf(_objektID);
    }

    public String get_hareType() {
        return _hareType;
    }

    public void LeggTilGjenfangst(Hare dyr, String _fangstDato, String _fangstSted, String _hareFarge, double _lengde,
                                  double _vekt)
    {
        if (dyr.getDyrID() == this.getDyrID())
        {
            Fangstdata gjenfangst = new Fangstdata(this, _fangstDato, _fangstSted, _hareFarge, _lengde, _vekt);
            this.set_gjenfangst(true);
            lstFangstdata.add(gjenfangst);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hare)) return false;

        Hare hare = (Hare) o;

        if (!_hareType.equals(hare._hareType)) return false;

        return true;
    }

    public String DyreInfo(Object o)
    {
        if (o instanceof Hare && o.equals(this))
        {
            // skal kun ha første fangst
            String dyrID = getDyrID();
            String fangstdato = lstFangstdata.get(0)._fangstDato;
            String fangststed = lstFangstdata.get(0)._fangstSted;
            String farge = lstFangstdata.get(0).get_farge();
            String vekt = Double.toString(lstFangstdata.get(0).get_vekt());
            String lengde = Double.toString(lstFangstdata.get(0).get_lengde());
            String kjønn = this.get_kjønn();
            String type = this.get_hareType();

            return "Hare " + dyrID + " " + type + " " + kjønn + " " + fangststed + " " + fangstdato +
                    " " + vekt + "Kg " + lengde + "CM " + farge;

        }
    return null;
    }

}
