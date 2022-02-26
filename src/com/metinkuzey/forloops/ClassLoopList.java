package com.metinkuzey.forloops;

import java.util.ArrayList;
import java.util.List;

public class ClassLoopList {

	public static void main(String[] args) {
	      List<String> letterList = new ArrayList<>();
	      letterList.add("M");
	      letterList.add("E");
	      letterList.add("T");
	      letterList.add("İ");
	      letterList.add("N");

	      for (String list : letterList) {
	          System.out.println(list);
	      }

	}

}
