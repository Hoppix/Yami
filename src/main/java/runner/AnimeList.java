package runner;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AnimeList
{
	private static List<ProxerAnime> linkMap;
	private ProxerAnime testAnime;
	private static Random generator;

	public AnimeList() throws MalformedURLException, WrongLinkException
	{								
		generator = new Random();
		linkMap = new ArrayList<ProxerAnime>();
		linkMap.add(testAnime);

	}

	public static ProxerAnime getRandomProxerAnime()
	{
		int rndIndex = generator.nextInt(linkMap.size());				
		return linkMap.get(rndIndex);

	}

	public static void addProxerAnime(String name, String link)
	{
		try
		{
			ProxerAnime newProxerAnime = new ProxerAnime(name, link);
			linkMap.add(newProxerAnime);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void deleteProxerAnime(String name)
	{
		for (ProxerAnime proxerAnime : linkMap)
		{
			if (name.equals(proxerAnime.getLabel()))
			{
				linkMap.remove(proxerAnime);
			}
		}
	}

	public static void saveAnimeList()
	{
		//TODO save into txt file
	}

	@Deprecated
	public static int getCardinal()
	{
		return 0;
	}
}
