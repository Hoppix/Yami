package runner;

public class WrongLinkException extends Exception
{
  public WrongLinkException()
  {
    System.out.println("Must be a Proxer-Link!");
  }
}
