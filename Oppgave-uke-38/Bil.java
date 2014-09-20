/**
 * Created by Filip on 19.09.2014.
 */
public class Bil implements Comparable {
    String _Modell;
    String _Type;
    int _RegNr;

    public Bil(String _Modell, String _Type, int _RegNr) {
        this._Modell = _Modell;
        this._Type = _Type;
        this._RegNr = _RegNr;
    }

    public String getModell() {
        return _Modell;
    }

    public void setModell(String _Modell) {
        this._Modell = _Modell;
    }

    public String getType() {
        return _Type;
    }

    public void setType(String _Type) {
        this._Type = _Type;
    }

    public int getRegNr() {
        return _RegNr;
    }

    public void setRegNr(int _RegNr) {
        this._RegNr = _RegNr;
    }


    public int compareTo(Object o)
    {
        if (this._RegNr == ((Bil) o)._RegNr)
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }

}
