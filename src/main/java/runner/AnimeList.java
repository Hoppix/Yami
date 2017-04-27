package runner;

import java.net.MalformedURLException;
import java.util.HashMap;

public class AnimeList {
	@SuppressWarnings("rawtypes")
	static
	ProxerAnime[] linkMap;
	ProxerAnime testAnime;

	@SuppressWarnings("unchecked")
	public AnimeList() {
		linkMap = new HashMap();

		try
		{
			testAnime = new ProxerAnime("Absolute Duo", "https://proxer.me/info/10195#top");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("falsche URL");
		}
		linkMap.add(testAnime);

	}

	public static ProxerAnime getProxerAnime()
	{
		//TODO add parameter
		//TODO setup array

			return linkMap[0];

		}
	}

	public static addProxerAnime(String name, String link)
	{
		try
		{
			linkMap.add(new ProxerAnime(name,link));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
