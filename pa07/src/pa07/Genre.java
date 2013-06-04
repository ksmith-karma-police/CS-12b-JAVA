package pa07;
import java.util.Set;
import java.util.HashSet;

public enum Genre {
	unknown,
	Action,
	Adventure,
	Animation,
	Childrens,
	Comedy,
	Crime,
	Documentary,
	Drama,
	Fantasy,
	FilmNoir,
	Horror,
	Musical,
	Mystery,
	Romance,
	SciFi,
	Thriller,
	War,
	Western;
	

	public static void main(String[] args){
		// Here's how we specify an enum value
		Genre x = Genre.SciFi;
		System.out.println("is x a SciFi movie?");
		System.out.println(x.toString().equals("SciFi"));

		
		// Here's how to create a set of enum values
		Set<Genre> s = new HashSet<Genre>();
		s.add(Genre.SciFi);
		s.add(Genre.Horror);
		s.add(Genre.Comedy);
		System.out.println("s = "+s);

		// here's how to loop through the values
		// in the order they were declared
		Genre[] genreArray = Genre.values();
		for(int i=0; i<genreArray.length; i++){
			System.out.println("i="+i+" g[i]="+genreArray[i]);
		}
		
	}

}
