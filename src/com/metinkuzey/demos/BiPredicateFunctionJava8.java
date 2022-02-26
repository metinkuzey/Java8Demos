package com.metinkuzey.demos;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class BiPredicateFunctionJava8 {

	public static void main(String[] args) {

		List<Domain> domains = Arrays.asList(
				new Domain("google.com", 1), 
				new Domain("linkedin.com", 10),
				new Domain("hackerrank.com", 5), 
				new Domain("microsoft.com", 2),
				new Domain("facebook.com", 0));

		BiPredicate<String, Integer> bi = (domain, score) -> {
			return (domain.equalsIgnoreCase("google.com") || score == 0);
		};

		// if google or score == 0
		List<Domain> result = filterBadDomain(domains, bi);
		System.out.println("Domain List 1");
		for(Domain domainDetails:result)
		 System.out.println("{name:'" + domainDetails.getName() + "', score:" + domainDetails.getScore() + "}"); // google.com, hackerrank.com

		// if score == 0
		List<Domain> result2 = filterBadDomain(domains, (domain, score) -> score == 5);
		System.out.println("Domain List 2");
		for(Domain domainDetails:result2)
		 System.out.println("{name:'" + domainDetails.getName() + "', score:" + domainDetails.getScore() + "}"); // hackerrank.com, microsoft.com

		// if start with i or score > 5
		List<Domain> result3 = filterBadDomain(domains, (domain, score) -> domain.startsWith("l") && score > 5);
		System.out.println("Domain List 3");
		for(Domain domainDetails:result3)
		 System.out.println("{name:'" + domainDetails.getName() + "', score:" + domainDetails.getScore() + "}"); // linkedin.com

		// chaining with or
		List<Domain> result4 = filterBadDomain(domains, bi.or((domain, x) -> domain.equalsIgnoreCase("microsoft.com")));
		System.out.println("Domain List 4");
		for(Domain domainDetails:result4)
		 System.out.println("{name:'" + domainDetails.getName() + "', score:" + domainDetails.getScore() + "}"); // google.com, hackerrank.com, microsoft.com

	}

	public static <T extends Domain> List<T> filterBadDomain(List<T> list, BiPredicate<String, Integer> biPredicate) {

		return list.stream().filter(x -> biPredicate.test(x.getName(), x.getScore())).collect(Collectors.toList());

	}
}

class Domain {

	String name;
	Integer score;

	public Domain(String name, Integer score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
	
}