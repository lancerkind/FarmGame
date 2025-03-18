package farm;

import farm.Map.MapObject;

public class Time {

	public String update(Map map)
	{
		for (var i = 0; i<map.show().length; i++){
			var mapObj = map.show();
			
			if("W" == (mapObj[i].toString())){
				map.changeWhatsThere(i, map.new Dirt());
			}
			if ("B"== (mapObj[i].toString())){
				map.changeWhatsThere(i, map.new Water());
			}
		}
		return map.toString();
	}
}
