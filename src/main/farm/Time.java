package farm;

import farm.Map.MapObject;

public class Time {

	public String update(Map map)
	{
		for (int i=0;i<map.show().length;i++){
			MapObject[] mapObj = map.show();
			
			if("W" ==(mapObj[i].toString())){
				map.changeWhatsThere(i, map.new Dirt());
			}
			if ("B"==(mapObj[i].toString())){
				map.changeWhatsThere(i, map.new Water());
			}
		}
		return map.toString();
	}
}
