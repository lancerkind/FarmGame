package farm;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

/***
 * Demonstrates using assertThat rather than Junit's trad. assertions.
 */
public class TimeAssertThatTest {
	@Test
	public void update_OfDirtIsDirt(){
		// test setup
		var map = new Map("XXXXXXXX");
		var time = new Time();
		// exercise unit under test
		var newMap = time.update(map);
		// Assertion 
		assertThat(newMap).isEqualTo("XXXXXXXX");
	}

	@Test
	public void update_WaterDriesToDirt(){
		// Setup
		var map = new Map("WXXXXXXX");
		var time = new Time();
		// executea
		var mapString = time.update(map);
		//assert
		assertThat(mapString).isEqualTo("XXXXXXXX");
	}
	@Test
	public void update_BogDriesToWater(){
		// setup
		var map = new Map("WXBXXXXX");
		var time = new Time();
		// exercise unit under test
		var mapString = time.update(map);
		// Assertion
		assertThat(mapString).isEqualTo("XXWXXXXX");
	}
	
	@Test
	public void updateBogXXX() {
		// setup
		var map = new Map("WXBBXXXX");
		var time = new Time();
		// exercise unit under test
		var mapString = time.update(map);
		// Assertion
		assertThat(mapString).isEqualTo("XXWWXXXX");
	}
	
	@Test
	public void update_EveryLocationWaterToDirt(){
		
		var map = new Map("WWWWWWWW");
		var time = new Time();
		var mapString = time.update(map);
		assertThat(mapString).isEqualTo("XXXXXXXX");
	}
}