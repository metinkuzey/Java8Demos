package com.metinkuzey.demos;

public class Hosting {

    private int Id;
    private String name;
    private String url;

    public Hosting(int id, String name, String url) {
        Id = id;
        this.name = name;
        this.url = url;
    }

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name.toString();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url.toString();
	}

	public void setUrl(String url) {
		this.url = url;
	}


}