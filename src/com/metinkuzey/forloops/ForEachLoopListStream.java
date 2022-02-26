package com.metinkuzey.forloops;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ForEachLoopListStream {

	public static void main(String[] args) {
	      List<String> letterList = new ArrayList<>();
	      letterList.add("M");
	      letterList.add(null);
	      letterList.add("T");
	      letterList.add(null);
	      letterList.add("N");
	      
	      System.out.println("************* Printing not null values in List ***************");
	      letterList.stream()
	      			.filter(Objects::nonNull)
	      			.forEach(System.out::println);
	}

}
