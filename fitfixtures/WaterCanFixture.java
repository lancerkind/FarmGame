package fitfixtures;

import farm.WaterCan;
import fit.ColumnFixture;

public class WaterCanFixture extends ColumnFixture {
	public int wateringLocation;

	private farm.Map map = new farm.Map();

	public String farmLand() {
		WaterCan waterCan = new WaterCan();
		waterCan.pour(wateringLocation, map);
		return map.toString();
	}
}
