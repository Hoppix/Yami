package runner;

import sx.blah.discord.api.IDiscordClient;

public class MainRunner
{

    private static IDiscordClient cli;

	public static void main(String[] args)
	{

		cli = BotUtils.getBuiltDiscordClient("MzA2NDA3MjU1NDU5MjMzNzky.C-DTiQ.ByLgE38pRYAG7n6TET7i2d9Ef0k");
		//TODO change bot token

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

		// this keeps the bot from logging in multiple times.
		if (!cli.isLoggedIn())
		{
			cli.login();
		}
		cli.changePlayingText("!help");
		//TODO is not shown

	}
	
	public static IDiscordClient getCLI()
	{
		return cli;
	}

}
