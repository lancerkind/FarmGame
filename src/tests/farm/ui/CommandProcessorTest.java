package farm.ui;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class CommandProcessorTest {
	private CommandProcessor processor = new CommandProcessor();
	
	@Test
	public void pullEmptiesPreviousMessage()
	{
		String [] output = processor.pullOutput();
		assertThat(output[0]).isEqualTo("Welcome to your farm. Now get to work!");
		assertThat(output.length).isEqualTo(1);
		
		output = processor.pullOutput();
		assertThat(output.length).isEqualTo(0);
	}
	
	@Test
	public void askForHelp()
	{
		emptyPreviousMessages();
		processor.sendInput("help");
		String [] output = processor.pullOutput();
		assertThat(output.length).isEqualTo(2);
		assertThat(output[0]).isEqualTo("Commands:");
		assertThat(output[1]).isEqualTo("Map - gives you a look at your farm.");
	}
	
	private void emptyPreviousMessages()
	{
		processor.pullOutput();
	}
}