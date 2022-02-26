package com.metinkuzey.demos;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Developer {

    String name;
    int age;
    BigDecimal salary;
    LocalDate startDate;

    public Developer(String name, BigDecimal salary, LocalDate startDate) {
        this.name = name;
        this.salary = salary;
        this.startDate = startDate;
    }
    
    public Developer(String name, BigDecimal salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }
    
    public Developer(String name, BigDecimal salary) {
        this.name = name;
        this.salary = salary;
    }
    
    public Developer() {
    }
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public BigDecimal getSalary() {
		return this.salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

}

