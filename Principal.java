import java.util.EmptyStackException;
import java.util.Stack;


public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	    int nCont=0;
	    String concatena="";
		Stack pilha_todas = new Stack();
		
		//metodo carregar o deck
		CarreaDeck(pilha_todas);
		
		//embaralha deck
		embaralha(pilha_todas);

		System.out.println("\n");

		System.out.println("Embaralhando Deck\n");

		
		try
		{
		
			Cards c;
			//Cards removeOject=null;
			while(true)
			{
				c = (Cards)pilha_todas.peek();
				
				if(c.toString().equals("8P"))
				{
					System.out.println("achou");
					//removeOject=pilha_todas.pop();
					
					
				}
				
				if(nCont==12)
				{
					 concatena=concatena+" "+"\n"+c.toString();
					
				  nCont=0;
				  
				}else{
				 concatena=concatena+" "+c.toString();
					
				}
				
				nCont+=1;
			}
			
			System.out.println(concatena);
			
			System.out.println("\n");
			
			//pilha_todas.equals(arg0)
			
			
			concatena="";
			nCont=0;
			for(int i=0;i<52;i++)
			{
				c = (Cards)pilha_todas.pop();
				
				if(nCont==12)
				{
				    //System.out.println(pilha_todas.pop());
					 concatena=concatena+" "+"\n"+c.toString();
				    nCont=0;
					  
				}else{
				 concatena=concatena+" "+c.toString();
					
				}
				
				nCont+=1;   
				
			}
			System.out.println(concatena);
		}
		catch(EmptyStackException emptyStackException)
		{
			//EmptyStackException.printStackTrace();
			
			
		}
		
		
		

	}
	
	//carrega o deck
	public static void CarreaDeck(Stack p)
	{
		String[] faces={"1","2","3","4","5","6","7","8","9","X","J","Q","J"};
		String[] suits={"P","O","C","S"};
		int nCont=0;
		String concatena="";
		
		Cards[] deck = new Cards[52];
		
		
		System.out.println("Carregando Deck\n");
			
		for(int i=0;i<52;i++)
		{
			if (nCont==12)
			{
				concatena=concatena+"\n"+" "+faces[i%13]+suits[i/13];
				nCont=0;
				
			}else{
			  concatena=concatena+" "+faces[i%13]+suits[i/13];     
			}
		
			deck[i]=new Cards(faces[i%13],suits[i/13]);
			
			p.push(deck[i]);
			
			nCont+=1;
			
		}
		System.out.println(concatena);
		
		
	}
	
	///embaralha as cartas
	
	public static void embaralha(Stack p)
	{
		Cards c;
		Stack aux1 = new Stack();
		Stack aux2 = new Stack();
		for(int k = 0; k < 100 ; k++)
		{
			while( !p.empty() )
			{
				int num1 = ((int)(Math.random()*1000) % 52);
				for(int i = 0; i < num1 && !p.empty(); i++)
				{
					c = (Cards)p.pop();
					aux1.push( c );
				}
				int num2 = ((int)(Math.random()*1000) % 52);
				for(int j = 0; j < num2 && !p.empty(); j++)
				{
				c = (Cards)p.pop();
				aux2.push( c );
				}
			}
			for(int i = 0; !aux1.empty() ; i++)
			{
				c = (Cards)aux1.pop();
				p.push( c );
			}
			for(int j = 0; !aux2.empty() ; j++)
			{
				c = (Cards)aux2.pop();
				p.push( c );
			}
		}
		
	}
	
	
	

}
