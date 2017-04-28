package runner;

import java.net.MalformedURLException;
import java.net.URL;

public class ProxerAnime
{
	public String label;
	public URL url;
	public int key;

	public ProxerAnime(String name, String link) throws WrongLinkException, MalformedURLException
	{
		if (link.contains("proxer"))
		{			
			//TODO map keyID
			key = 0;
			label = name;
			url = new URL(link);
		}
		else
		{
			throw new WrongLinkException();
		}

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
		return label + ":  " + url.toString();
	}
}
