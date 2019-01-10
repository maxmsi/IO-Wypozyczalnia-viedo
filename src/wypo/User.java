package wypo;
import java.util.List;

public class User 
{
	private String name;
	private String surname;
	private static int uIdSeed = 1;
	private int uId;
	private String email;
	private List<Movie> filmList;
	private int age;
	private String phoneNumber;
	private String login;
	private String password;
	private Clearance clearance;
	
	public User()
	{
		uId = uIdSeed++;
	}
	
	public User(String name, String surname, int age, String login,String password ,Clearance clerance )
	{
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.login = login;
		this.password = password;
		this.clearance = clerance;
		uId = uIdSeed++;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Movie> getFilmList() {
		return filmList;
	}
	public void setFilmList(List<Movie> filmList) {
		this.filmList = filmList;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public Clearance getClearance() {
		return clearance;
	}
	public void setClearance(Clearance clearance) {
		this.clearance = clearance;
	}
	
	
}
