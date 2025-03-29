package com.example.levin.thread.learning;


public class Staff {
	
	private String name;
	private double salary;
	private String designition;
	
	public Staff() {
	}
	
	public Staff(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	
	
	public Staff(String name, String designition) {
		super();
		this.name = name;
		this.designition = designition;
	}

	public String getDesignition() {
		return designition;
	}

	public void setDesignition(String designition) {
		this.designition = designition;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Staff [name=" + name + ", salary=" + salary + ", designition=" + designition + "]";
	}

}
