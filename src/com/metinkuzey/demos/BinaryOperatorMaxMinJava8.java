package com.metinkuzey.demos;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;

public class BinaryOperatorMaxMinJava8 {

	public static void main(String[] args) {
        Developer dev1 = new Developer("Jack", BigDecimal.valueOf(9999));
        Developer dev2 = new Developer("Jhon", BigDecimal.valueOf(8888));
        Developer dev3 = new Developer("Ahmet", BigDecimal.valueOf(1999));
        Developer dev4 = new Developer("Ali", BigDecimal.valueOf(2000));
        Developer dev5 = new Developer("Metin", BigDecimal.valueOf(10000));

        List<Developer> list = Arrays.asList(dev1, dev2, dev3, dev4, dev5);

        // 1. Create a Comparator
        Comparator<Developer> comparing = Comparator.comparing(Developer::getSalary);

        // 2. BinaryOperator with a custom Comparator
        BinaryOperator<Developer> bo = BinaryOperator.maxBy(comparing);

        Developer result = find(list, bo);

        System.out.println("Name: " + result.name + " Salary: " + result.salary );     // Developer{name='Metin', salary=10000}

        // one line

        // find developer with highest pay
        Developer developer = find(list, BinaryOperator.maxBy(Comparator.comparing(Developer::getSalary)));
        System.out.println("Name: " + developer.name + " Salary: " + developer.salary);  // Developer{name='Metin', salary=10000}

        // find developer with lowest pay
        Developer developer2 = find(list, BinaryOperator.minBy(Comparator.comparing(Developer::getSalary)));
        System.out.println("Name: " + developer2.name + " Salary: " + developer2.salary); // Developer{name='Ahmet', salary=1999}

	}
	
    public static Developer find(List<Developer> list, BinaryOperator<Developer> accumulator) {
        Developer result = null;
        for (Developer t : list) {
            if (result == null) {
                result = t;
            } else {
                result = accumulator.apply(result, t);
            }
        }
        return result;
    }

}
