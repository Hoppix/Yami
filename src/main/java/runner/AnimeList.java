package runner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AnimeList
{
	private static List<ProxerAnime> linkMap;
	private Random generator;
	private String fileName;

	public AnimeList()
	{
		generator = new Random();
		linkMap = new ArrayList<>();
		fileName = "ProxerList.txt";

		try
		{
			FileWriter fileWriter = new FileWriter(fileName);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		//clunky: used for creating the file at startup if it does not exist

		this.retrieveAnimeList();
	}

	public ProxerAnime getRandomProxerAnime()
	{
		int rndIndex;
		rndIndex = generator.nextInt(linkMap.size());
		return linkMap.get(rndIndex);
	}

	public void addProxerAnime(String name, String link) throws MalformedURLException, WrongLinkException
	{

		ProxerAnime newProxerAnime = new ProxerAnime(name, link);
		linkMap.add(newProxerAnime);
		this.saveAnimeList();

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
		// TODO fix laggy writing
		try
		{
			FileWriter fileWriter = new FileWriter(fileName);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			for (int i = 0; i < linkMap.size(); i++)
			{
				if (bufferedReader.readLine() == null)
				{
					System.out.println("Writing to line " + i + "..");
					bufferedWriter.write(linkMap.get(i).toSaveString());
					bufferedWriter.newLine();
					System.out.println("Writing finished");
				}

			}

			bufferedWriter.close();
			bufferedReader.close();

		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.out.println("schreibfehler");
		}
	}

	public void retrieveAnimeList()
	{
		String line = null;

		try
		{
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null)
			{
				String name;
				String link;
				String[] content;
				content = line.split(";");
				name = content[0];
				link = content[1];
				linkMap.add(new ProxerAnime(name, link));
			}

			bufferedReader.close();
			System.out.println("read txt file");
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			System.out.println("datei nicht gefunden");
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.out.println("lesefehler");
		}
		catch (WrongLinkException e)
		{
			e.printStackTrace();
			System.out.println("falscher link in logfile");
		}
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
