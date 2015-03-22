package com.example.bddtest;

import java.io.Serializable;

public class SuperHeroe implements Serializable{
	
	private static final long serialVersionUID = -1651643305546082732L;
	
	private String name;
	private String home;
	private String powers;
	private String img;
	
	public SuperHeroe(String name, String home, String powers, String img) {
		setName(name);
		setHome(home);
		setPowers(powers);
		setImg(img);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getPowers() {
		return powers;
	}

	public void setPowers(String powers) {
		this.powers = powers;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
}
