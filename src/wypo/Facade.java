package wypo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Facade 
{
	public List<User> userList;
	public List<Movie> movieList;
	public List<Title> titleList;
	public User mainUser;
	
	public Facade(List<User> userList)
	{
		this.userList = userList;
		movieList = new ArrayList<>();
		titleList = new ArrayList<>();
		
		titleList.add(new Title("Batman","C. Nolan",new Date(),"Warner Bros"));
		titleList.add(new Title("Superman","B. Dolan",new Date(),"Warner Bros"));
		titleList.add(new Title("IronMan","K. Foidge",new Date(),"MCU"));
                titleList.add(new Title("Aquaman","J. Wan",new Date(),"Warner Bros"));
                titleList.add(new Title("Shazam!","D. Lemke",new Date(),"DC Comics"));
                titleList.add(new Title("Titanic","J. Cameron",new Date(),"20th Century Fox"));
                
                
		
		movieList.add(new Movie(titleList.get(0), Status.NOTRENTED, Form.VHS));
		movieList.add(new Movie(titleList.get(1), Status.NOTRENTED, Form.DVD));
		movieList.add(new Movie(titleList.get(2), Status.NOTRENTED, Form.VHS));
                movieList.add(new Movie(titleList.get(3), Status.NOTRENTED, Form.DVD));
		movieList.add(new Movie(titleList.get(4), Status.NOTRENTED, Form.DVD));
		movieList.add(new Movie(titleList.get(5), Status.NOTRENTED, Form.DVD));
		
		
	}
	
	public String rentMovie(Movie movie, User user)
	{
		Movie movieToRent = findMovie(movie);
		if(movieToRent == null)
		{
			return "No such movie";
		}
		else
		{
			Status status = checkStatus(movieToRent);
			switch(status)
			{
				case RESERVED:
				{
					if(movieToRent.getUserId() != 0)
					{
						movieToRent.setStatus(Status.RENTED);
						movie.setUserId(user.getuId());
						addToHistory();
					}
					else
					{
						return "Movie rented by someone else";
					}
				}
				case RENTED:
				{
					return "Movie rented";
				}
				case NOTRENTED:
				{
					movieToRent.setStatus(Status.RENTED);
					movie.setUserId(user.getuId());
					addToHistory();
					return "Movie rented successfully";
				}
				default:
				{
					System.out.println("Error");
				}
			}
		}
		
		return "Error";
	}
	
	public boolean reserveMovie(User user, Movie movie)
	{
		Movie movieFound = findMovie(movie);
		if(movieFound != null && movieFound.getStatus()!=Status.RESERVED)
		{       
			movieFound.setUserId(user.getuId());
			changeMovieStatus(movieFound, Status.RESERVED);
			return true;
		}
		else
			return false;
	}
	
	public boolean returnMovie(User user, Movie movie)
	{
		Movie movieFound = findMovie(movie);
		if(movieFound != null)
		{
			movieFound.setUserId(0);
			changeMovieStatus(movieFound, Status.NOTRENTED);
			return true;
		}
		else
			return false;
	}
	
	public void checkHistory()
	{
		
	}
	
	public void modifyMovie()
	{
		
	}
	
	public void addMovie(Movie movie)
	{
		movieList.add(movie);
	}
	
	public void deleteMovie(Movie movie)
	{
		Movie movieFound = findMovie(movie);
		if(movieFound != null)
		{
			int indexOfMovie = movieList.indexOf(movieFound);
			movieList.remove(indexOfMovie);
		}
	}
	
	public void changeMovieStatus(Movie movie, Status status)
	{
		movie.setStatus(status);
	}
	
	public void addToHistory()
	{
		
	}
	
	public Status checkStatus(Movie movie)
	{
		 return movie.getStatus();
	}
	
	public Movie findMovie(Movie movie)
	{
		for(Movie temp: movieList)
		{
			if(temp.equals(movie))
			{
				return temp;
			}
		}
		return null;
	}
	
	public void addTitle()
	{
		
	}
	
	public User getMainUser()
	{
		return mainUser;
	}
	
	public void setMainUser(User mainUser)
	{
		mainUser = this.mainUser;
	}
	
	public void createNewUser()
	{
		
	}
	
	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public List<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

	public List<Title> getTitleList() {
		return titleList;
	}

	public void setTitleList(List<Title> titleList) {
		this.titleList = titleList;
	}
	
	
}
