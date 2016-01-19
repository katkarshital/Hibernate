package my.collection.demo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SortedMap {
	public static void main(String[] args){
		Map<String,Integer> unsortedMap = new HashMap<String,Integer>();
		unsortedMap.put("Viraj",2);
		unsortedMap.put("Tanish",9);
		unsortedMap.put("Vikram", 39);
		unsortedMap.put("Shital", 35);
		unsortedMap.put("Shushila", 55);
		unsortedMap.put("Rajaram", 64);
		System.out.println("UnSorted Map -> ");
		printMap(unsortedMap);
		
		
		System.out.println("\nSorted Map in descending order......");
		Map<String,Integer> DescSortedMap = new TreeMap<String,Integer>(new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
			
		});
		DescSortedMap.putAll(unsortedMap);
		printMap(DescSortedMap);
		
		System.out.println("\nSorted Map in ascending order......");
		Map<String,Integer> AscSortedMap = new TreeMap<String,Integer>();			
					
			
		AscSortedMap.putAll(unsortedMap);
		printMap(AscSortedMap);

	}
	public static void printMap(Map<String, Integer> map){
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println( entry.getKey() + "   :  " + entry.getValue());
		}
	}

}
