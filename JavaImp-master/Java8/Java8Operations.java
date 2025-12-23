package com.rk.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8Operations {
	public static void main(String[] args) {
		String s="Ramakrishna".toLowerCase();
		
		/*1)Count the occurrence of the characters in given String*/
		Map<String, Long> map = Arrays.stream(s.split(""))
				.collect(Collectors.groupingBy(Function.identity(),
						Collectors.counting()));
		System.out.println(map);
		
		/*2)find all duplicate elements in given string*/
		List<String> duplicateElements = Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
		.entrySet().stream()
		.filter(a->a.getValue()>1)
		.map(Map.Entry::getKey)
		.collect(Collectors.toList());
		System.out.println(duplicateElements);
	
		/*3)find all unique elements in given string*/
		List<String> uniqueElements = Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
		.entrySet().stream()
		.filter(a->a.getValue()==1)
		.map(Map.Entry::getKey)
		.collect(Collectors.toList());
		System.out.println(uniqueElements);

		/*4)find first occurrence of unique element in given string*/
		String first_Occurrence_Of_UniqueString = Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
		.entrySet()
		.stream()
		.filter(a->a.getValue()==1)
		.findFirst().get().getKey();
		System.out.println(first_Occurrence_Of_UniqueString);
		
		/*5)find first occurrence of Duplicate element in given string*/
		String first_Occurrence_Of_Duplicateelement = Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
		.entrySet()
		.stream()
		.filter(a->a.getValue()>1)
		.findFirst().get().getKey();
		System.out.println(first_Occurrence_Of_Duplicateelement);
		
		/*6)Find the second highest element in given array */
		int[] arr= {5,2,7,9,22,46};
		System.out.println(Arrays.stream(arr).boxed()
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toList()).get(1));
		
		/*7) another way */
		System.out.println(Arrays.stream(arr).boxed()
				.sorted(Comparator.reverseOrder())
				.skip(1)
				.findFirst()
				.get());
		
		/**8)Find the longest String in given array**/
		
		String[] StringArr= {"Java","Spring","SpringBoot","Microservices"};

		System.out.println(Arrays.stream(StringArr)
		.reduce((string1,string2)->string1.length()>string2.length()?string1:string2)
		.get());
		
		/** 9)Find the elements in the given array who starts with 1**/
		List<String> starts_with = Arrays.stream(arr)
		.boxed()
		.map(a->a+"")
		.filter(a->a.startsWith("2"))
		.collect(Collectors.toList());
		System.out.println(starts_with);
		
		/** 10) Join method in String(String.join)**/
		 List<String> list = Arrays.asList("1","2","3","4");		 
		 String joins=String.join("-",list);
		 System.out.println(joins);
		 
		 /*11)Skip and limit method*/
		 IntStream.rangeClosed(1, 10)
		 .skip(1)
		 .limit(8)
		 .forEach(System.out::println);
		/* Sort a list*/
		ArrayList<Integer> arrayList=new ArrayList<Integer>();
		arrayList.add(5);
		arrayList.add(1);
		arrayList.add(6);
		arrayList.add(3);
		arrayList.add(9);
		arrayList.add(31);
		arrayList.add(8);
		arrayList.add(4);
		

		arrayList.stream().sorted().forEach(System.out::print);
		System.out.println();
		arrayList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::print);
		System.out.println();
		
		/* Sort a Map*/
		
		
		Map<String, Integer> maps=new HashMap<>();
		maps.put("Six", 6);
		maps.put("Nine", 9);
		maps.put("Seven", 7);
		maps.put("Eight", 8);
		maps.put("Four", 4);
		
		List<Entry<String, Integer>> entries = new ArrayList<>(maps.entrySet());
		
		/*
		 * Collections.sort(entries,new Comparator<Entry<String, Integer>>() {
		 * 
		 * @Override public int compare(Entry<String,Integer> o1,Entry<String,Integer>
		 * o2) { return o1.getKey().compareTo(o2.getKey()); }; });
		 */
		
		/*ascending order*/
		Collections.sort(entries,(a,b)->a.getKey().compareTo(b.getKey()));
		for(Entry<String, Integer> entry:entries) {
			System.out.println(entry.getKey()+"  "+entry.getValue());
		}
		/*reverse order*/
		Collections.sort(entries,(a,b)->a.getKey().compareTo(b.getKey()));
		for(Entry<String, Integer> entry:entries) {
			System.out.println(entry.getKey()+"  "+entry.getValue());
		}
		
		
		/*Compare by key*/
		maps.entrySet().stream().sorted(Entry.comparingByKey()).forEach(System.out::println);
		/*In reverse order*/

		/*maps.entrySet().stream().sorted(Entry.comparingByKey()).forEach(System.out::println);*/
		System.out.println("***********************************");
		/*Compare by Value*/
		maps.entrySet().stream().sorted(Entry.comparingByValue()).forEach(System.out::println);
		/*map*/
		 /*flat map*/
		 /**/
		
	}
}
