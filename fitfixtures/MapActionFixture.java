package fitfixtures;

import farm.Map;
import farm.Map.MapObject;
import fit.ActionFixture;

public class MapActionFixture extends ActionFixture {
	private String map = null;  // This private field maintains state between calls.
	
	public void testToString(){
		map = "testToString returned " + new Map().toString();
	}
	
	public void testShow()
	{
		MapObject [] mapObjects = new Map().show();
		
		StringBuffer buildMap = new StringBuffer();
		
		for (MapObject mapObject : mapObjects) buildMap.append(mapObject.toString());
		map = "testShow returned " +buildMap.toString();
	}
	
	//*** Added to demonstrate state changes in this fixture.
	public void throwAwayMap()
	{
		map = null;
	}
	
	public String lookAtMap()
	{
		return map;
	}
}
