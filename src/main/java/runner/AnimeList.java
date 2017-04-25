package runner;

import java.net.MalformedURLException;
import java.util.HashMap;

public class AnimeList {
	@SuppressWarnings("rawtypes")
	static
	HashMap linkMap;
	ProxerAnime testAnime;

	@SuppressWarnings("unchecked")
	public AnimeList() {
		linkMap = new HashMap();

		try {
			testAnime = new ProxerAnime("Absolute Duo", "https://proxer.me/info/10195#top");
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.out.println("falsche URL");
		}
		
		linkMap.put(testAnime.getKey(), testAnime);
	}
	
	public static ProxerAnime getProxerAnime()
	{
		//TODO add parameter
		//TODO setup array
		try {
			return new ProxerAnime("Absolute Duo", "https://proxer.me/info/10195#top");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			
		}
	}
}
