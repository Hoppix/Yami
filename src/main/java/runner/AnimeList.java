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
	private FileWriter fileWriter;
	private FileReader fileReader;
	private BufferedWriter bufferedWriter;
	private BufferedReader bufferedReader;

	public AnimeList()
	{
		generator = new Random();
		linkMap = new ArrayList<ProxerAnime>();
		fileName = "C:\\Users\\khopf\\Desktop\\savelist.txt";
		//debugging

		try
		{
			fileWriter = new FileWriter(fileName);
			bufferedWriter = new BufferedWriter(fileWriter);
			fileReader = new FileReader(fileName);
			bufferedReader = new BufferedReader(fileReader);
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.out.println("fehler beim erstellen reader/writer");
		}

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
		//TODO fix file writing(seperate writer/reader)
		try
		{
			for (int i = 0; i < linkMap.size(); i++)
			{
				if (bufferedReader.readLine() == null)
				{
					System.out.println("Writing to line " + i + "..");
					BotUtils.sendMessage(MainRunner.getCLI().getChannels().get(3), "Writing to line " + i + "..");
					bufferedWriter.write(linkMap.get(i).toSaveString());
					bufferedWriter.newLine();
					System.out.println("Writing finished");
					BotUtils.sendMessage(MainRunner.getCLI().getChannels().get(3), "Writing finished");			
				}
				
			}
			// was buggy
			// fileWriter.close();
			// bufferedWriter.close();

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
