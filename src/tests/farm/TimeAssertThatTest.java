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
		Map map = new Map("XXXXXXXX");
		Time time = new Time();
		// exercise unit under test
		String newMap = time.update(map);
		// Assertion 
		assertThat(newMap).isEqualTo("XXXXXXXX");
	}

	@Test
	public void update_WaterDriesToDirt(){
		// Setup
		Map map = new Map("WXXXXXXX");
		Time time = new Time();
		// executea
		String mapString = time.update(map);
		//assert
		assertThat(mapString).isEqualTo("XXXXXXXX");
	}
	@Test
	public void update_BogDriesToWater(){
		// setup
		Map map = new Map("WXBXXXXX");
		Time time = new Time();
		// exercise unit under test
		String mapString = time.update(map);
		// Assertion
		assertThat(mapString).isEqualTo("XXWXXXXX");
	}
	
	@Test
	public void updateBogXXX() {
		// setup
		Map map = new Map("WXBBXXXX");
		Time time = new Time();
		// exercise unit under test
		String mapString = time.update(map);
		// Assertion
		assertThat(mapString).isEqualTo("XXWWXXXX");
	}
	
	@Test
	public void update_EveryLocationWaterToDirt(){
		
		Map map = new Map("WWWWWWWW");
		Time time = new Time();
		String mapString = time.update(map);
		assertThat(mapString).isEqualTo("XXXXXXXX");
	}
}