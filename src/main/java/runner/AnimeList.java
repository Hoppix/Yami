package runner;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AnimeList
{
	private static List<ProxerAnime> linkMap;
	private Random generator;

	public AnimeList()
	{
		generator = new Random();
		linkMap = new ArrayList<ProxerAnime>();

	}

	public ProxerAnime getRandomProxerAnime()
	{
		int rndIndex;
		rndIndex = 0;
		rndIndex = generator.nextInt(linkMap.size());
		return linkMap.get(rndIndex);

	}

	public void addProxerAnime(String name, String link) throws MalformedURLException, WrongLinkException
	{

		ProxerAnime newProxerAnime = new ProxerAnime(name, link);
		linkMap.add(newProxerAnime);

	}
	
	public void deleteProxerAnime(String name)
	{
		for (ProxerAnime proxerAnime : linkMap)
		{
			if (name.equals(proxerAnime.getLabel()))
			{
				linkMap.remove(proxerAnime);
			}
		}
	}

	public void saveAnimeList()
	{
		//TODO LOGGING to txt
	}
	
	public List<ProxerAnime> getAnimeList()
	{
		return linkMap;
	}

	@Deprecated
	public int getCardinal()
	{
		return 0;
	}
}
