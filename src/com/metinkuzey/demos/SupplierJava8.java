package com.metinkuzey.demos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SupplierJava8 {

	private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	
	public static void main(String[] args) {
        Supplier<LocalDateTime> s = () -> LocalDateTime.now();
        LocalDateTime time = s.get();

        System.out.println(time);

        Supplier<String> s1 = () -> dtf.format(LocalDateTime.now());
        String time2 = s1.get();

        System.out.println(time2);
        

	}
	


}
