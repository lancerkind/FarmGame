package farm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaterCanTest {
	Map map;
	private WaterCan waterCan;

	@BeforeEach
	void setup() {
		waterCan = new WaterCan();
		map = new Map();
	}

	@Test
	void pour() {
		assertAll("Pouring water at different locations should result in Water",
				() -> assertPourMakesWater(waterCan, 0),
				() -> assertPourMakesWater(waterCan, 1)
		);
	}

	@Test
	void pourTwiceCreatesABog() {
		var location = 0;
		assertPourMakesWater(waterCan, location);

		waterCan.pour(location, map);
		assertEquals(map.new Bog().toString(), map.whatsThere(location),
				"After pouring twice, location should contain a Bog");
	}

	private void assertPourMakesWater(WaterCan waterCan, int location) {
		waterCan.pour(location, map);
		assertEquals(map.new Water().toString(), map.whatsThere(location),
				"After pouring once, location should contain Water");
	}
}