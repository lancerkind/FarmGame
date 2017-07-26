package fitfixtures;

import farm.Map;
import fit.*;

public class MapRowFixture extends RowFixture {

	@Override
	//*** Tell FitNesse what target class we'll be returning to it.
	public Class<Map.MapObject> getTargetClass() {
		return Map.MapObject.class;
	}

	@Override
	/*** This method is implemented by all RowFixtures to execute the query which returns
	 an array of the above class.
	*/
	public Object[] query() throws Exception {
		Map map = new Map();
		
		//*** You can uncomment the below to send debug data to FitNesse.
//		System.out.println(map.toString());
		return map.show();
	}
}