package farm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TimeTest {
	@Test
	public void update_OfDirtIsDirt()
	{
		// test setup
		var map = new Map("XXXXXXXX");
		var time = new Time();
		// exercise unit under test
		var newMap = time.update(map);
		// Assertion 
		assertEquals("XXXXXXXX", newMap);
	}

	@Test
	public void update_WaterDriesToDirt(){
		// Setup
		var map = new Map("WXXXXXXX");
		var time = new Time();
		// execute
		var mapString = time.update(map);
		//assert
		assertEquals("XXXXXXXX",mapString);
	}

	@Test
	public void update_BogDriesToWater(){
		// setup
		var map = new Map("WXBXXXXX");
		var time = new Time();
		
		// exercise unit under test
		var mapString = time.update(map);
		
		// Assertion
		assertEquals("XXWXXXXX",mapString);
	}
	
	@Test
	public void updateBogXXX() {
		// setup
		var map = new Map("WXBBXXXX");
		var time = new Time();
		
		// exercise unit under test
		var mapString = time.update(map);
		
		// Assertion
		assertEquals("XXWWXXXX",mapString);
	}

	@Test
	public void update_EveryLocationWaterToDirt(){
		var map = new Map("WWWWWWWW");
		var time = new Time();
		var mapString = time.update(map);
		assertEquals("XXXXXXXX",mapString);
	}
}