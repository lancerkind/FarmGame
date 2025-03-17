package farm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TimeTest {
	@Test
	public void update_OfDirtIsDirt()
	{
		// test setup
		Map map = new Map("XXXXXXXX");
		Time time = new Time();
		// exercise unit under test
		String newMap = time.update(map);
		// Assertion 
		assertEquals("XXXXXXXX", newMap);
	}
	@Test
	public void update_WaterDriesToDirt(){
		// Setup
		Map map = new Map("WXXXXXXX");
		Time time = new Time();
		// execute
		String mapString = time.update(map);
		//assert
		assertEquals("XXXXXXXX",mapString);
		
	}
	@Test
	public void update_BogDriesToWater(){
		// setup
		Map map = new Map("WXBXXXXX");
		Time time = new Time();
		
		// exercise unit under test
		String mapString = time.update(map);
		
		// Assertion
		assertEquals("XXWXXXXX",mapString);
	}
	
	@Test
	public void updateBogXXX() {
		// setup
		Map map = new Map("WXBBXXXX");
		Time time = new Time();
		
		// exercise unit under test
		String mapString = time.update(map);
		
		// Assertion
		assertEquals("XXWWXXXX",mapString);
	}
	@Test
	public void update_EveryLocationWaterToDirt(){
		Map map = new Map("WWWWWWWW");
		Time time = new Time();
		String mapString = time.update(map);
		assertEquals("XXXXXXXX",mapString);
	}
}
