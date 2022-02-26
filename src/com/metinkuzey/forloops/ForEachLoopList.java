package com.metinkuzey.forloops;

import java.util.ArrayList;
import java.util.List;

public class ForEachLoopList {

	public static void main(String[] args) {
	      List<String> letterList = new ArrayList<>();
	      letterList.add("M");
	      letterList.add("E");
	      letterList.add("T");
	      letterList.add("İ");
	      letterList.add("N");
	      System.out.println("************* Normal ForEach ***************");
	      letterList.forEach(System.out::println);
	      System.out.println("************* Lambda ForEach ***************");
	      letterList.forEach(x -> System.out.println(x));

	}

}
