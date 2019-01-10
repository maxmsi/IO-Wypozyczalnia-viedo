package wypo;
import java.util.ArrayList;
import java.util.List;

public class Logger 
{
	private List<User> userList = new ArrayList<>();
	
	public Logger(List<User> userList)
	{
		this.userList = userList;
		
	}
	
	public User searchForAccount(String login)
	{
		for(User user: userList)
		{
			if(user.getLogin().equals(login))
			{
				return user;
			}
		}
		return null;
	}
	
	public boolean verifyPassword(User user, String password)
	{
		if(user == null)
			return false;
		if(user.getPassword().equals(password))
		{
			return true;
		}
		else
			return false;
	}
	
	public User login(String login, String password)
	{
		User user = searchForAccount(login);
		if(user != null)
		{
			if(verifyPassword(user, password) == true)
			{
				return user;
			}
			else return null;
		}
		else
		{
			return null;
		}
	}
	
	public String getLogin()
	{
		return null;
	}
	
	public void setLogin()
	{
		
	}
	
	public String getPassword()
	{
		return null;
	}
	
	public void setPassword()
	{
		
	}
	
	public User getUser()
	{
		return null;
	}
	
	public void setUser()
	{
		
	}
}
