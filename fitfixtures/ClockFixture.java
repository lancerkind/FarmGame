package fitfixtures;

import farm.Map;
import farm.Time;
import fit.ColumnFixture;

public class ClockFixture extends ColumnFixture {

	public String currentMap;

	public String timePasses()
	{
		Map oldMap = new Map(currentMap);
		Time time = new Time();
		return time.update(oldMap);
		
	}

	private String update(Map map) {
		
		
		return map.toString();
	}
}