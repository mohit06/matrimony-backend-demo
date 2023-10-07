package com.matchmaker.pojo;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
@Entity
@Component
public class ComplexPojo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	@Column(unique = true)
	String a;
	String b;
	List<String> c;
	@OneToOne( cascade = CascadeType.ALL)
	Address d;
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	public List<String> getC() {
		return c;
	}
	public void setC(List<String> c) {
		this.c = c;
	}
	public Address getD() {
		return d;
	}
	public void setD(Address d) {
		this.d = d;
	}
	@Override
	public String toString() {
		return "ComplexPojo [id=" + id + ", a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + "]";
	}
	
	public ComplexPojo() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public ComplexPojo(long id, String a, String b, List<String> c, Address d) {
		super();
		this.id = id;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	
	

}
