package fitfixtures;

import farm.Map;
import fit.ColumnFixture;

public class GuitarColumnFixture extends ColumnFixture {

	public int locationFromLeft;
	
	private Map map = new Map();
	
	public String showLand()
	{
		return map.toString();
	}
	
	public boolean isAbleToPlay()
	{
		if(map.whatsThere(locationFromLeft).equals(map.new Dirt().toString())) return true;
		return false;
	}
}
