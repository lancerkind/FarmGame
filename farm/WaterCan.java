package farm;

public class WaterCan {
	public void pour(int location, Map map){	
		if (map.whatsThere(location).equals(map.new Water().toString())){
			map.changeWhatsThere(location, map.new Bog());
		}else map.changeWhatsThere(location, map.new Water());
	}

}
