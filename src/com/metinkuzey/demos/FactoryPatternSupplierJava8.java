package com.metinkuzey.demos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.function.Supplier;

public class FactoryPatternSupplierJava8 {

	public static void main(String[] args) {

	        Developer obj = factory(() -> new Developer("Metin Kuzey",new BigDecimal(100000)));
	        System.out.println("{Name:" + obj.getName() + ", Salary:" + obj.getSalary() + ", StartDate: " + obj.getStartDate() + "}");

	}
	
	public static Developer factory(Supplier<? extends Developer> s) {

        Developer developer = s.get();
        if (developer.getName() == null || "".equals(developer.getName())) {
            developer.setName("default");
        }
        developer.setSalary(developer.getSalary());
        developer.setStartDate(LocalDate.of(2012, 1, 2));

        return developer;

    }

}
