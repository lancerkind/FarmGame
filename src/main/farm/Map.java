package farm;


public class Map {
	// Map Objects
	final public String Water = "W";
	final public String Dirt = "X";
	final private MapObject farmLand[];
	final private int maplocations = 8;
	
	public Map() {
		this("XXXXXXXX");
}

	public Map(String mapData) {
		if (mapData.length() != maplocations) {
			throw new IndexOutOfBoundsException("Map supports "
					+ maplocations + " locations but what was passed in was: "
					+ mapData.length());
					
		}

		farmLand = new MapObject[maplocations];
		var distanceFromLeft = 0;

		for (var mapCharacter : mapData.toCharArray()) {
			
			switch (mapCharacter) {
			case 'W':
				farmLand[distanceFromLeft++] = new Water();
				break;
			case 'X':
				farmLand[distanceFromLeft++] = new Dirt();
				break;
			case 'B':
				farmLand[distanceFromLeft++] = new Bog();
				break;
			default:
				throw new MapCharacterNotSupported();
			}
		}
	}
	
	public String toString() {
		var mapToRead = new StringBuilder();
		var stripOfFarmLand = farmLand;
		
		for (MapObject mapObject : stripOfFarmLand)
			mapToRead.append(mapObject.toString());		

		return mapToRead.toString();
	}

	public MapObject[] show() {
		return farmLand;
	}

	public String whatsThere(int fromLeft) {
		return String.valueOf((farmLand[fromLeft]));
	}

	public void changeWhatsThere(int fromLeft, MapObject mapObject) {
		farmLand[fromLeft] = mapObject;
	}

	// Map Objects
	public abstract class MapObject {
		// MapCharacter needs to call back to toString() rather than hardcode to 
		// null.  Otherwise Java superclass references
		// will not get the overridden MapCharacter.  (You can't override
		// Fields in Java, only methods, therefore you initialize fields with methods.)
		public final String MapCharacter = toString();
		
		@Override
		public boolean equals(Object right) {
			return this.toString().equals(right.toString());
		}
	}

	public class Water extends MapObject {
		public final String MapCharacter = "W";
		
		public String toString() {
			return MapCharacter;
		}
	}

	public class Dirt extends MapObject {
		public final String MapCharacter = "X";
		
		public String toString() {
			return MapCharacter;
		}
	}

	public class Bog extends MapObject {
		public final String MapCharacter = "B";
		
		public String toString() {
			return MapCharacter;
		}
	}
}