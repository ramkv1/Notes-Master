package com.rk;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Streams {
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i = 50; i < 150; i++) {
			al.add(i);
		}

		System.out.println(al.stream().reduce(0, (a, b) -> a + b));

		System.out.println(al.stream().filter(a -> a > 100).filter(a -> a % 2 != 0).collect(Collectors.toList()));

		System.out.println(al.stream().map(a -> a + 5).collect(Collectors.toList()));

		ArrayList<String> chara = new ArrayList<String>();
		chara.add("a");
		chara.add("b");
		chara.add(null);

		chara.stream()
		.filter(Objects::nonNull)
		.map(String::toUpperCase)
		.collect(Collectors.toList())
				.forEach(System.out::println);
		
		String getusername="Ramakrishna";
		
		
		Optional.ofNullable(getusername).map(String::toUpperCase).ifPresent(System.out::println);

	}
}
