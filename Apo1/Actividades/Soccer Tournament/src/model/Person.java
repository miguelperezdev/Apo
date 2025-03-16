package model;

public abstract class Person {


	 protected String name;
	 protected String country;
	 protected String id; 

	 public Person(String name, String country, String id) {
	 	this.name = name;
        this.id= id;
        this.country= country;
	 }

	 public abstract void showInfo();

	 public String getName() {
	 	return name;
	 }

	 public void setName(String name) {
	 	this.name = name;
	 }

      public String getCountry() {
	 	return country;
	 }

	 public void setCountry(String country) {
	 	this.country = country;
	 }

	 public String getId() {
	 	return id;
	 }

	 public void setId(String id) {
	 	this.id = id;

	 }
	 

}