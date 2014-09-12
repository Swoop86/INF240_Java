/**
 * Created by fkotl_000 on 11.09.2014.
 */
import java.util.ArrayList;
import java.util.List;

public class Prosjekt {
    String _prosjektTittel;
    String _prosjektAnsvarlig;
    List<Integer> _budsjett = new ArrayList<Integer>();

    public Prosjekt(String prosjektTittel, String prosjektAnsvarlig, int budsjett) {
        this._prosjektTittel = prosjektTittel;
        this._prosjektAnsvarlig = prosjektAnsvarlig;
        _budsjett.add(budsjett);
    }

    public String getProsjektTittel() {
        return _prosjektTittel;
    }

    public String getProsjektAnsvarlig() {
        return _prosjektAnsvarlig;
    }

    public void setBudsjett(int budsjettTall)
    {
        this._budsjett.add(budsjettTall);
    }

    public void RemoveBudsjett(int budsjettTall)
    {
        this._budsjett.remove(budsjettTall);
    }

    public int getBudsjett()
    {
        for (int item : _budsjett)
        {
            return item;
        }
        return 0;
    }

}
