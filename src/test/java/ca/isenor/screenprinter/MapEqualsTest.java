package ca.isenor.screenprinter;

import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

import com.google.common.collect.Maps;

public class MapEqualsTest {

	@Ignore
	@Test
	public void test() {
		Map<String, String> map1 = Maps.newHashMap();
		map1.put("mom", "gayle");
		map1.put("dad", "fenton");
		
		
		Map<String, String> map2 = Maps.newHashMap();
		map2.put("mom", "gayle");
		map2.put("dad", "fenton");
		
		
		System.out.println(map1.equals(map2));
	}

}
