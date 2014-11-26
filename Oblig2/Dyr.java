import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fkotl_000 on 29.10.2014.
 */
public abstract class Dyr implements Serializable {
    protected String _kjønn;
    protected boolean _gjenfangst = false;
    protected int _objektID;
    protected List<Fangstdata> lstFangstdata = new ArrayList<Fangstdata>();

    protected Dyr(String _kjønn) {
        this._kjønn = _kjønn;
    }

    public String get_kjønn() {
        return _kjønn;
    }

    public boolean is_gjenfangst() {
        return _gjenfangst;
    }

    public void set_gjenfangst(boolean _gjenfangst) {
        this._gjenfangst = _gjenfangst;
    }

    public boolean finnÅr(String søkeinput)
    {
        for (Fangstdata item : lstFangstdata)
        {
            String år = (item._fangstDato.substring(item._fangstDato.lastIndexOf('.') + 1));
            if (år.equals(søkeinput))
            {
                return true;
            }
        }
        return false;
    }

    abstract String DyreInfo(Object o);
}
