package farm;

import farm.Map.MapObject;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MapTest {

	private Map map;

	@BeforeEach
	public void setup() {
		map = new Map();
	}

	@AfterEach
	public void teardown() {
		map = null;
	}

	@Test
	public void testInitializedAsDirt() {
		Map.MapObject gotTheseMapObjects[] = map.show();
		Map.Dirt dirt = map.new Dirt();

		for (MapObject actualMapObject : gotTheseMapObjects)
			assertTrue(dirt.equals(actualMapObject));
	}

	@Test
	public void testMapObjectNotEquals() {
		Map.Dirt dirt = map.new Dirt();
		Map.Water water = map.new Water();

		assertFalse(dirt.equals(water));
	}

	@Test
	public void testWaterIsWAndDirtIsX() {
		// setup
		//excercise & assert
		assertEquals("W", map.Water);
		assertEquals("X", map.Dirt);
	}

	@Test
	public void show_Dirt() {
		// setup

		// exercise
		Map.MapObject gotTheseMapObjects[] = map.show();
		Map.Dirt dirt = map.new Dirt();

		// Assert
		for (MapObject actualMapObject : gotTheseMapObjects)
			assertTrue(dirt.equals(actualMapObject));
	}

	@Test
	public void changeLocation() {
		// setup

		int arbitraryLocation = 0;
		// exercise
		map.changeWhatsThere(arbitraryLocation, map.new Water());
		// assert
		assertEquals("WXXXXXXX", map.toString());

		// exercise
		map.changeWhatsThere(arbitraryLocation, map.new Dirt());
		//assert
		assertEquals("XXXXXXXX", map.toString());

		//exercise
		map.changeWhatsThere(arbitraryLocation, map.new Bog());
		// assert
		assertEquals("BXXXXXXX", map.toString());
	}

	@Test
	public void testToString() {
		assertEquals("XXXXXXXX", map.toString());
	}

	@Test
	public void whatsThereAndNoArgConstructor() {
		int arbitraryLocation = 3;
		map.changeWhatsThere(arbitraryLocation, map.new Bog());

		assertEquals("B", map.whatsThere(arbitraryLocation));
	}

	@Test
	public void constructWithStringInput() {
		String mapThatsNotDefaultData = "WXXXXWXB";
		map = new Map(mapThatsNotDefaultData);
		assertEquals(mapThatsNotDefaultData, map.toString());
	}

	@Test
	public void constructWithTooMuchStringInput() {
		String mapThatHasTooManyXs = "XXXXXXXXXXXXXXXXX";

		assertThatThrownBy(() -> new Map(mapThatHasTooManyXs))
				.isInstanceOf(IndexOutOfBoundsException.class)
				.hasMessage("Map supports 8 locations but what was passed in was: 17");
	}

	@Test
	public void constructWithNotEnoughStringInput() {
		String mapIsTooSmall = "XX";

		assertThatThrownBy(() -> new Map(mapIsTooSmall))
				.isInstanceOf(IndexOutOfBoundsException.class);
	}

	@Test
	public void constructWithInvalidMapCharacters() {
		String mapWithInvalidCharacters = "QQXXWXXX";

		assertThatThrownBy(() -> new Map(mapWithInvalidCharacters))
				.isInstanceOf(MapCharacterNotSupported.class);
	}
}