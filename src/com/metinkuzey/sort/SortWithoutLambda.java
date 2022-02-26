package com.metinkuzey.sort;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.metinkuzey.demos.Developer;

public class SortWithoutLambda {

	public static void main(String[] args) {

		List<Developer> listDevs = getDevelopers();

		System.out.println("Before Sort");
		for (Developer developer : listDevs) {
			System.out.println("Name: " + developer.getName() + " - " +
							   "Salary: " + developer.getSalary() + " - " + 
							   "Age: " + developer.getAge());
		}
		
		//sort by age
		Collections.sort(listDevs, new Comparator<Developer>() {
			@Override
			public int compare(Developer o1, Developer o2) {
				return o1.getAge() - o2.getAge();
			}
		});
	
		System.out.println("After Sort Age");
		for (Developer developer : listDevs) {
			System.out.println("Name: " + developer.getName() + " - " +
					   "Salary: " + developer.getSalary() + " - " + 
					   "Age: " + developer.getAge());
		}
		
		//sort by name	
		Collections.sort(listDevs, new Comparator<Developer>() {
			@Override
			public int compare(Developer o1, Developer o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		System.out.println("After Sort Name");
		for (Developer developer : listDevs) {
			System.out.println("Name: " + developer.getName() + " - " +
					   "Salary: " + developer.getSalary() + " - " + 
					   "Age: " + developer.getAge());
		}
		
					
		//sort by salary
		Collections.sort(listDevs, new Comparator<Developer>() {
			@Override
			public int compare(Developer o1, Developer o2) {
				return o1.getSalary().compareTo(o2.getSalary());
			}
		});
		System.out.println("After Sort Salary");
		for (Developer developer : listDevs) {
			System.out.println("Name: " + developer.getName() + " - " +
					   "Salary: " + developer.getSalary() + " - " + 
					   "Age: " + developer.getAge());
		}
		
		
	}

	private static List<Developer> getDevelopers() {

		List<Developer> result = new ArrayList<Developer>();

		result.add( new Developer("Metin",new BigDecimal(180000),34));
		result.add(new Developer("Harry", new BigDecimal("80000"), 20));
		result.add(new Developer("Jhon", new BigDecimal("100000"), 10));
		result.add(new Developer("Jack", new BigDecimal("170000"), 55));
		
		return result;

	}

}
