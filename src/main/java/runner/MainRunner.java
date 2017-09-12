package runner;

import sx.blah.discord.api.IDiscordClient;

public class MainRunner
{

    private static IDiscordClient cli;

	public static void main(String[] args)
	{

		cli = BotUtils.getBuiltDiscordClient("INSERT TOKEN HERE");

		/*
		Register a listener via the EventSubscriber annotation which allows
		for organisation and delegation of events
		*/
		cli.getDispatcher().registerListener(new MyEvents(cli));

		/*
		Only login after all events are registered otherwise some may be
		missed.
		*/
		cli.logout();
		cli.changePlayingText("!help");

		// this keeps the bot from logging in multiple times.
		if (!cli.isLoggedIn())
		{
			cli.login();
		}
		//TODO is not shown

	}
	
	public static IDiscordClient getCLI()
	{
		return cli;
	}

}
