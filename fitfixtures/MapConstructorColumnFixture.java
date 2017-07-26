package fitfixtures;

import farm.Map;
import fit.ColumnFixture;

public class MapConstructorColumnFixture extends ColumnFixture {
	public String initialMap;
	
	public String constructedState()
	{
		Map map = new Map(initialMap);
		return map.toString();
		
	}
}
