package v1o.utils;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Json常用
 * 
 * ===================主方法=================
 * 方法1：集合转化为json
 * 方法2：json转化为集合list
 * ===================主方法=================
 * @author v1onway
 */
public class JsonUtil {

	//===================主方法=================
	//方法1：集合转化为json
	public static String ToJsonArray(List<Integer> resList) {
		JSONArray jsonArray = new JSONArray();
		
		for(int result : resList) {
			jsonArray.put(result);
		}
		
		return jsonArray.toString();
	}
	
	//方法2：json转化为集合list
	public static List<Integer> JsonToList(String jsonStr) {
		List<Integer> results = new ArrayList<Integer>();

		try {
			JSONArray jsonArray = new JSONArray(jsonStr);
			for(int i=0; i<jsonArray.length(); i++) {
				int result = (Integer) jsonArray.get(i);
				if(result > 0) {
					results.add(result);
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return results;
	}
	//===================主方法=================
	
}
