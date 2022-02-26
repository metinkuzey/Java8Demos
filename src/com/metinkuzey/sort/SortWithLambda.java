package com.metinkuzey.sort;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.metinkuzey.demos.Developer;

public class SortWithLambda {

	public static void main(String[] args) {

		List<Developer> listDevs = getDevelopers();

		System.out.println("Before Sort");
		for (Developer developer : listDevs) {
			System.out.println("Name: " + developer.getName() + " - " +
							   "Salary: " + developer.getSalary() + " - " + 
							   "Age: " + developer.getAge());
		}
		
		System.out.println("After Sort Age");
		listDevs.sort((Developer o1, Developer o2)-> o1.getAge()- o2.getAge());
		listDevs.forEach((developer)->System.out.println("Name: " + developer.getName() + " - " +
				   "Salary: " + developer.getSalary() + " - " + 
				   "Age: " + developer.getAge()));
		System.out.println("After Sort Name");
		listDevs.sort((Developer o1, Developer o2)-> o1.getName().compareTo(o2.getName()));
		listDevs.forEach((developer)->System.out.println("Name: " + developer.getName() + " - " +
				   "Salary: " + developer.getSalary() + " - " + 
				   "Age: " + developer.getAge()));
		System.out.println("After Sort Salary 1");
		listDevs.sort((Developer o1, Developer o2)-> o1.getSalary().compareTo(o2.getSalary()));
		listDevs.forEach((developer)->System.out.println("Name: " + developer.getName() + " - " +
				   "Salary: " + developer.getSalary() + " - " + 
				   "Age: " + developer.getAge()));
		System.out.println("After Sort Salary 2");
		Comparator<Developer> salaryComparator = (o1, o2)->o1.getSalary().compareTo(o2.getSalary());
		listDevs.sort(salaryComparator);
		listDevs.forEach((developer)->System.out.println("Name: " + developer.getName() + " - " +
				   "Salary: " + developer.getSalary() + " - " + 
				   "Age: " + developer.getAge()));
		
		System.out.println("After Sort Salary 3 - Reversed Sort");
		Comparator<Developer> reversedSalaryComparator = (o1, o2)->o1.getSalary().compareTo(o2.getSalary());
		listDevs.sort(reversedSalaryComparator.reversed());
		listDevs.forEach((developer)->System.out.println("Name: " + developer.getName() + " - " +
				   "Salary: " + developer.getSalary() + " - " + 
				   "Age: " + developer.getAge()));
		
		
	}

	private static List<Developer> getDevelopers() {

		List<Developer> result = new ArrayList<Developer>();

		result.add( new Developer("Metin",new BigDecimal(180000),34));
		result.add(new Developer("James", new BigDecimal("80000"), 20));
		result.add(new Developer("Jhon", new BigDecimal("100000"), 10));
		result.add(new Developer("Jack", new BigDecimal("170000"), 55));
		
		return result;

	}

}
