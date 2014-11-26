import java.io.Serializable;

/**
 * Created by fkotl_000 on 29.10.2014.
 */
public class Fangstdata implements Serializable {
    protected String _fangstDato;
    protected String _fangstSted;
    protected double _lengde;
    protected double _vekt;
    protected String _farge;
    protected double _lengdeØreTuster;

    public Fangstdata(Object o, String _fangstDato, String _fangstSted, String _farge, double _lengde, double _vekt)
    {
        if (o instanceof Hare)
        {
            this._fangstDato = _fangstDato;
            this._fangstSted = _fangstSted;
            this._farge = _farge;
            this._lengde = _lengde;
            this._vekt = _vekt;
        }
    }
    public Fangstdata(Object o, String _fangstDato, String _fangstSted, double _lengdeØreTuster,double _lengde, double _vekt)
    {
        if (o instanceof Gaupe)
        {
        this._fangstDato = _fangstDato;
        this._fangstSted = _fangstSted;
        this._lengdeØreTuster = _lengdeØreTuster;
        this._lengde = _lengde;
        this._vekt = _vekt;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fangstdata)) return false;

        Fangstdata that = (Fangstdata) o;

        if (!_fangstDato.equals(that._fangstDato)) return false;

        return true;
    }

    public String get_fangstDato() {
        return _fangstDato;
    }

    public String get_fangstSted() {
        return _fangstSted;
    }

    public double get_lengde() {
        return _lengde;
    }

    public double get_vekt() {
        return _vekt;
    }

    public String get_farge() {
        return _farge;
    }

    public double get_lengdeØreTuster() {
        return _lengdeØreTuster;
    }
}
