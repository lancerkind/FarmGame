package farm.ui;

import java.util.List;
import java.util.Vector;

public class CommandProcessor {

	 List<String> list = new Vector<String>();
	 
	public CommandProcessor()
	{
		list.add("Welcome to your farm. Now get to work!");
	}

	public String[] pullOutput() {
		String [] output = list.toArray(new String[0]);
		list.clear();
		return output;
	}

	public void sendInput(String string) {
		if (string.equals("help")) printHelp();
	}
	
	private void printHelp(){
		list.add("Commands:");
		list.add("Map - gives you a look at your farm.");
	}

}
