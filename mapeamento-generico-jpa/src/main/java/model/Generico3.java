package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Generico3 {

	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	private int inteiro1;
	private int inteiro2;
	
	private float float1;
	private float float2;
	
	private String string1;
	private String string2;
	private String string3;
	
	//MANY TO ONE//
	@ManyToOne
	@JoinColumn(name = "library_id")
	private Generico1 generico1;
    
	public int getId() {
		return id;
	}
	
	public int getInteiro1() {
		return inteiro1;
	}

	public void setInteiro1(int inteiro1) {
		this.inteiro1 = inteiro1;
	}

	public int getInteiro2() {
		return inteiro2;
	}

	public void setInteiro2(int inteiro2) {
		this.inteiro2 = inteiro2;
	}

	public float getFloat1() {
		return float1;
	}

	public void setFloat1(float float1) {
		this.float1 = float1;
	}

	public float getFloat2() {
		return float2;
	}

	public void setFloat2(float float2) {
		this.float2 = float2;
	}

	public String getString1() {
		return string1;
	}

	public void setString1(String string1) {
		this.string1 = string1;
	}

	public String getString2() {
		return string2;
	}

	public void setString2(String string2) {
		this.string2 = string2;
	}

	public String getString3() {
		return string3;
	}

	public void setString3(String string3) {
		this.string3 = string3;
	}
	
}
