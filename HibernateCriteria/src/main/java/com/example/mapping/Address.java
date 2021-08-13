package com.example.mapping;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

//import com.sun.org.glassfish.gmbal.InheritedAttribute;


@Entity
@Table(name = "ADDRESS_MTM")

public class Address {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "ADDR_ID")
   private long id;

   @Column(name = "CITY")
   private String city;

   @Column(name = "STATE")
   private String state;

   @Column(name = "COUNTRY")
   private String country;

   @Column(name = "ZIP")
   private String zip;

   public Address() { }
   
   public Address(String city, String state, String country, String zip) {
      this.city = city;
      this.state = state;
      this.country = country;
      this.zip = zip;
   }

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

public String getZip() {
	return zip;
}

public void setZip(String zip) {
	this.zip = zip;
}

   
}
