package com.metinkuzey.demos;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateObject {
    public static void main(String[] args) {

        Hosting h1 = new Hosting(1, "amazon", "aws.amazon.com");
        Hosting h2 = new Hosting(2, "linode", "linode.com");
        Hosting h3 = new Hosting(3, "liquidweb", "liquidweb.com");
        Hosting h4 = new Hosting(4, "google", "google.com");
        Hosting h5 = new Hosting(5, "googleuk", "googleuk.com");

        List<Hosting> list = Arrays.asList(new Hosting[]{h1, h2, h3, h4,h5});

        List<Hosting> result = HostingRepository.filterHosting(list, x -> x.getName().startsWith("g"));
        for(Hosting list2:result) 
        	System.out.println("result : [Hosting{Id=" + list2.getId() + 
					", name=" + list2.getName() + 
					", url=" + list2.getUrl() + "}]");  // google
        
        		

        List<Hosting> result2 = HostingRepository.filterHosting(list, isDeveloperFriendly());
        for(Hosting list3:result2) 
        	System.out.println("result2 : [Hosting{Id=" + list3.getId() + 
        						", name=" + list3.getName() + 
        						", url=" + list3.getUrl()+ "}]");  // google
        

    }

    public static Predicate<Hosting> isDeveloperFriendly() {
        return n -> n.getName().equals("linode");
    }
}
