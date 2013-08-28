
public class Cards {
	
	
	private String numeroCarta;
	private String naipe;
	
	public Cards(String numeroCarta,String naipe)
	{
		this.naipe=naipe;
		this.numeroCarta=numeroCarta;
		
	}
	
	public String toString()
	{
		return numeroCarta+naipe;
		
	}

}
