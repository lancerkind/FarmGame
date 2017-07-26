package fitfixtures;

import farm.ui.CommandProcessor;
import fit.ActionFixture;


public class UIActionFixture extends ActionFixture {

	private String [] linesOfOutput = null;
	private CommandProcessor commandProcessor = new CommandProcessor();

	public String[] output()
	{
	
		linesOfOutput = commandProcessor.pullOutput();
		return linesOfOutput;
	}
	
	public void input(String commandLine)
	{
		commandProcessor.sendInput(commandLine);
	}
}
