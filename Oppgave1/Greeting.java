public class Greeting {
	
	String _hilsen = null;
	String _navn = null;
	
	
	public void SetHilsen(String newValue)
	{		
		_hilsen = newValue;
		
	}	
	public String GetHilsen(int option)
	{
		if (option == 0) {return _hilsen; }
		else if (option == 1)
		{
			String uttekst = "Din hilsen er: " + "\n" + _hilsen;
			return uttekst;
		}
		else {
			return null;
		}
	}	
	public void SetNavn(String newValue)
	{
		_navn = newValue;
	}
	public String GetNavn(int option)
	{
		if (option == 0) {return _navn; }
		else if (option == 1)
		{
			String uttekst = "Hallo " + _navn;
			return uttekst;
		}
		else {
			return null;
		}
	}
		
}
