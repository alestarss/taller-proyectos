package socialtoilet.android.utils;

public class Settings
{

	private static Settings instance;
	
	private boolean sessionOn;
	private String user;
	private String password;
	private int initialRadiusInMeters;
	private boolean servicesDebugMode;
	
	private Settings()
	{
		sessionOn = false;
		user = "";
		password = "";
		initialRadiusInMeters = 10000;
		servicesDebugMode = true;
	}
	
	public static Settings getInstance()
	{
		if( null == instance )
		{
			instance = new Settings();
		}
		return instance;
	}
	
	public boolean isSessionOn()
	{
		return sessionOn;
	}
	
	public String getUser()
	{
		return user;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public int getInitialRadiusInMeters()
	{
		return initialRadiusInMeters;
	}

	public boolean isServicesDebugMode()
	{
		return servicesDebugMode;
	}
	
	public void retrieveUser()
	{
		// TODO encontrar una manera para guardar el usuario y contraseņa y recuperarlo
		sessionOn = true;
		user = "mservetto";
		password = "password";
	}
}
