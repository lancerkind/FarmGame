package farm.ui;

import org.junit.Assert;

import org.junit.Test;

public class CommandProcessorTest {


	private CommandProcessor processor = new CommandProcessor();
	
	@Test
	public void pullEmptiesPreviousMessage()
	{
		String [] output = processor.pullOutput();
		Assert.assertEquals("Welcome to your farm. Now get to work!", output[0]);
		Assert.assertEquals(1, output.length);
		
		output = processor.pullOutput();
		Assert.assertEquals(0, output.length);
	}
	
	@Test
	public void askForHelp()
	{
		emptyPreviousMessages();
		processor.sendInput("help");
		String [] output = processor.pullOutput();
		Assert.assertEquals(2, output.length);
		Assert.assertEquals("Commands:", output[0]);
		Assert.assertEquals("Map - gives you a look at your farm.", output[1]);
	}
	
	private void emptyPreviousMessages()
	{
		processor.pullOutput();
	}
}
