package farm;

import org.junit.Assert;

import org.junit.*;

import farm.Map.MapObject;

public class MapTest {

	private Map map;

	@Before
	public void setup() {
		map = new Map();
	}
	
	@After 
	public void teardown(){
		map=null;
	}

	@Test
	public void testInitializedAsDirt() {
		Map.MapObject gotTheseMapObjects[] = map.show();
		Map.Dirt dirt = map.new Dirt();
		
		for (MapObject actualMapObject : gotTheseMapObjects) 
			Assert.assertTrue(dirt.equals(actualMapObject));
	}
	
	@Test
	public void testMapObjectNotEquals() {
		Map.Dirt dirt = map.new Dirt();
		Map.Water water = map.new Water();
		
		Assert.assertFalse(dirt.equals(water));
	}
	
	@Test
	public void testWaterIsWAndDirtIsX() {
		// setup
		//excercise & assert
		Assert.assertEquals("W",map.Water);
		Assert.assertEquals("X",map.Dirt);
	}
	
	@Test
	public void show_Dirt() {
		// setup
		
		// exercise
		Map.MapObject gotTheseMapObjects[] = map.show();
		Map.Dirt dirt = map.new Dirt();
		
		// Assert
		for (MapObject actualMapObject : gotTheseMapObjects) 
		    Assert.assertTrue(dirt.equals(actualMapObject));
	}

	@Test
	public void changeLocation() {
		// setup
		
		int arbitraryLocation = 0;
		// exercise
		map.changeWhatsThere(arbitraryLocation, map.new Water());
		// assert
		Assert.assertEquals("WXXXXXXX", map.toString());

		// exercise
		map.changeWhatsThere(arbitraryLocation, map.new Dirt());
		//assert
		Assert.assertEquals("XXXXXXXX", map.toString());
		
		//exercise
		map.changeWhatsThere(arbitraryLocation, map.new Bog());
		// assert
		Assert.assertEquals("BXXXXXXX", map.toString());
	}

	@Test
	public void testToString() {
		Assert.assertEquals("XXXXXXXX", map.toString());
	}

	@Test
	public void whatsThereAndNoArgConstructor() {
		int arbitraryLocation = 3;
		map.changeWhatsThere(arbitraryLocation, map.new Bog());

		Assert.assertEquals("B", map.whatsThere(arbitraryLocation));
	}

	@Test
	public void constructWithStringInput() {
		String mapThatsNotDefaultData = "WXXXXWXB";
		map = new Map(mapThatsNotDefaultData);
		Assert.assertEquals(mapThatsNotDefaultData, map.toString());
	}


	@Test()
	public void constructWithTooMuchStringInput() {
		String mapThatHasTooManyXs = "XXXXXXXXXXXXXXXXX";
		try{
		map = new Map(mapThatHasTooManyXs);
		}
		catch (IndexOutOfBoundsException x)
		{
			Assert.assertEquals("Map supports 8 locations but what was passed in was: 17", x.getMessage());
		}	
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void constructWithNotEnoughStringInput() {
		String mapIsTooSmall = "XX";
		map = new Map(mapIsTooSmall);
	}

	@Test(expected = MapCharacterNotSupported.class)
	public void constructWithInvalidMapCharacters() {
		String mapWithInvalidCharacters = "QQXXWXXX";
		map = new Map(mapWithInvalidCharacters);
	}
}
