package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.data.rest.core.annotation.RestResource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Generico1 {

	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	private int inteiro1;
	private int inteiro2;
	
	private float float1;
	private float float2;
	
	private String string1;
	private String string2;
	private String string3;
	
	//ONE TO ONE// 
	//RESTO EM GENERICO 2//
	@OneToOne
    @JoinColumn(name = "generico2")
    @RestResource(path = "generico2", rel="generico2")
    private Generico2 generico2;
	
	//ONE TO MANY//
	//MANY TO ONE EM GENERICO 3//
	 @OneToMany(mappedBy = "generico3")
	 private List<Generico3> generico3s;
	
	 //MANY TO MANY
	 //RESTO EM GENERICO 4//
	 @ManyToMany(cascade = CascadeType.ALL)
	 @JoinTable(name = "generico4", 
      joinColumns = @JoinColumn(name = "generico4_id", referencedColumnName = "id"), 
      inverseJoinColumns = @JoinColumn(name = "generico4_id", 
      referencedColumnName = "id"))
    private List<Generico4> generico4s;
	 
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
