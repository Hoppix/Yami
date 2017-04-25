package runner;

import java.net.MalformedURLException;
import java.net.URL;

public class ProxerAnime 
{
	public String label;
	public URL url;
	public int key;
	
	public ProxerAnime(String name, String link) throws  MalformedURLException
	{
		label = name;
		url = new URL(link);
		//url.getHost();
		String keyString = link.replaceAll("\\D+","");
		key = Integer.parseInt(keyString);
	}
	
	public int getKey()
	{
		return key;
	}
	
	public String getLabel()
	{
		return label;
	}
	
	public URL getURL()
	{
		return url;
	}
	
	public String toString()
	{
		return label + ": " + url.toString();
	}
}
