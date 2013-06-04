package pa07;
import java.util.*;

/**
* A User contains the id, age, gender, occupation, zipcode
* as specifed in the ml-100k dataset from grouplens
*/

public class User{
	
	private int id;
	private int age;
	private String gender;
	private String occupation;
	private String zipcode;
	protected ArrayList<Review> reviews;
	protected ArrayList<Review> testReviews;
	
	public User(){
		this(ML100K.users.size()+1, 20, "F", "educator", "02481");
	}
	
	/**
	 * Create a new User just by userID
	 * @param id
	 */
	public User(int id){
		this(id-1, 
				ML100K.users.get(id-1).getAge(),
				ML100K.users.get(id-1).getGender(), 
				ML100K.users.get(id-1).getOccupation(), 
				ML100K.users.get(id-1).getZipcode());
	}

  /**
	* Create a new user with a given id, age, gender, occupation, and zipcode
	* this data comes from the ml-100k dataset
	*/

	public User(int id, int age, 
							String gender, String occupation, String zipcode){
		this.id = id;
		this.age=age;
		this.gender=gender;
		this.occupation=occupation;
		this.zipcode=zipcode;
	}
	
	public User getUser(int id){
		return (ML100K.users.get(id-1));//use ArrayList or the "theUsers" array?
	}
	/**
	* Accessor for the age of the user
	* @return the user's age
	*/
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int a){
		this.age = a;
	}
	
	/**
	* Accessor for the id of the user
	* @return the user's id
	*/
	public int getId() {
		return this.id;
	}
	
	public ArrayList<Review> getTestReviews(){
		return this.testReviews;
	}
	
	public ArrayList<Review> getReviews(){
		return this.reviews;
	}

	/**
	* Accessor for the gender of the user ("M" or "F")
	* @return the user's gender
	*/
	public String getGender() {
		return this.gender;
	}
	
	public void setGender(String g){
		this.gender = g;
	}

	/**
	* Accessor for the occupation of the user
	* @return the user's occupation
	*/
	public String getOccupation() {
		return this.occupation;
	}
	
	public void setOccupation(String o){
		this.occupation = o;
	}
	
	/**
	* Accessor for the zipcode of the user
	* @return the user's zipcode
	*/
	public String getZipcode() {
		return this.zipcode;
	}
	
	public void setZipcode(String z){
		this.zipcode = z;
	}

	
	public String toString(){
		return "u"+id+":"+age+":"+gender+":"+occupation+":"+zipcode;
	}

}

