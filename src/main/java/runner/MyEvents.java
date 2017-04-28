package runner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.ReadyEvent;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.impl.events.guild.member.UserJoinEvent;
import sx.blah.discord.util.EmbedBuilder;

public class MyEvents
{

	// generate stuff
	LocalDateTime time = LocalDateTime.now();

	@EventSubscriber
	public void onMessageReceived(MessageReceivedEvent event)
	{

		// message split
		String[] argArray = event.getMessage().getContent().split(" ");

		if (argArray.length == 0)
		{
			return;
		}

		if (!argArray[0].startsWith(BotUtils.BOT_PREFIX))
		{
			return;
		}

		String commandStr = argArray[0].substring(1);

		// konvertieren zur Arraylist
		List<String> argsList = new ArrayList<>(Arrays.asList(argArray));
		argsList.remove(0); // Remove the command

		switch (commandStr)
		{

			case "test":
				testCommand(event, argsList);
			break;
			case "help":
				sendBuild(event, argsList);
			break;
			case "giveAnime":
				giveAnime(event, argsList);

		}

	}

	@EventSubscriber
	public void isReady(ReadyEvent event)
	{
		BotUtils.sendMessage(event.getClient().getChannels().get(0), "Yami is ready");
	}

	@EventSubscriber
	public void welcome(UserJoinEvent event)
	{
		LocalDateTime time = event.getJoinTime();
		BotUtils.sendMessage(event.getClient().getChannels().get(0),
		        event.getUser().getName() + " joined at: " + time.toString() + ". Welcome!");
	}

	private void testCommand(MessageReceivedEvent event, List<String> args)
	{

		BotUtils.sendMessage(event.getChannel(), "You ran the test command with args: " + args);

	}

	private void sendBuild(MessageReceivedEvent event, List<String> args)
	{
		BotUtils.sendMessage(event.getChannel(), " Yami build soon(tm)");

		EmbedBuilder builder = new EmbedBuilder();

		builder.withTitle("Commands");
		builder.appendField("!help:", "shows this message", true);
		builder.appendField("!test", "gives command arguments(debugging", true);
		builder.appendField("Author: Hoppix#6723", "[@Github](https://github.com/Hoppix)", false);
		builder.withColor(255, 0, 0);
		builder.withTitle("Yami-Bot");
		builder.withTimestamp(time);
		BotUtils.sendBuild(event.getChannel(), builder);
	}

	private void giveAnime(MessageReceivedEvent event, List<String> args)
	{
		AnimeList.addProxerAnime("test", "proxer.me");
		String anime = AnimeList.getRandomProxerAnime().toString();
		BotUtils.sendMessage(event.getChannel(), anime);
		
		if(anime.equals(""))
		{
			BotUtils.sendMessage(event.getChannel(), "empty String");
		}

	}

}
