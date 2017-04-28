package runner;

public class WrongLinkException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2801461719295505600L;

	public WrongLinkException()
	{
		System.out.println("Must be a Proxer-Link!");
	}
}
