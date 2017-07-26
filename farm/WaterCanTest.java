package farm;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WaterCanTest {
	
	Map map = null;
	private WaterCan waterCan;
	
	@Before
	public void setup(){
		waterCan = new WaterCan();
		map = new Map();
	}
	
	@Test public void pour()
	{
		int location = 0;
		assertPourMakesWater(waterCan, location); 		

		location = 1;
		assertPourMakesWater(waterCan, location); 	
	}

	@Test public void pourTwiceCreatesABog()
	{
		int location = 0;
		assertPourMakesWater(waterCan, location); 	
		
		waterCan.pour(location, map);
		Assert.assertEquals(map.new Bog().toString(), map.whatsThere(location)); 	
	}
	
	private void assertPourMakesWater(WaterCan waterCan, int location) {
		waterCan.pour(location, map);
		Assert.assertEquals(map.new Water().toString(), map.whatsThere(location));
	}
}
