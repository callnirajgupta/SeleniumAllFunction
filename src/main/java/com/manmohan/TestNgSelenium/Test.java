package com.manmohan.TestNgSelenium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

	public static void _main(String[] args) {
		// TODO Auto-generated method stub
		 final float PIE=3.14f;
		Map<String,List<String>> map = new HashMap<>();
		
		List<String> list = new ArrayList<>();
		list.add("Manmohan");
		list.add("USA");
		map.put("niraj", list);
		
		 list = new ArrayList<>();
		 list.add("Niraj");
			list.add("Indian");
			map.put("manmohan", list);
			
		System.out.println(" print "+map.get("niraj"));
		System.out.println(" print "+map.get("manmohan"));

	}

}
