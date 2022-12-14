package com.pdfinspringboot.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
	public class Intern {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String pan;
	private String pfnumber;
	private String Dateofjoining;
	private String department;
	private String degination;
	private String location;
	private String stipend;
	private String tenure;
	
	@OneToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
	@JoinColumn(name = "sid")
	private Allowance allowance;


	public void setAllowance(Allowance allowance) {
		this.allowance = allowance;
	}
	public Allowance getAllowance() {
		return allowance;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getPfnumber() {
		return pfnumber;
	}
	public void setPfnumber(String pfnumber) {
		this.pfnumber = pfnumber;
	}
	public String getDateofjoining() {
		return Dateofjoining;
	}
	public void setDateofjoining(String dateofjoining) {
		Dateofjoining = dateofjoining;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDegination() {
		return degination;
	}
	public void setDegination(String degination) {
		this.degination = degination;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStipend() {
		return stipend;
	}
	public void setStipend(String stipend) {
		this.stipend = stipend;
	}
	public String getTenure() {
		return tenure;
	}
	public void setTenure(String tenure) {
		this.tenure = tenure;
	}

	public Intern(Long id, String name, String email, String pan, String pfnumber, String dateofjoining,
			String department, String degination, String location, String stipend, String tenure, Allowance allowance) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.pan = pan;
		this.pfnumber = pfnumber;
		Dateofjoining = dateofjoining;
		this.department = department;
		this.degination = degination;
		this.location = location;
		this.stipend = stipend;
		this.tenure = tenure;
		this.allowance = allowance;
	}
	
	public Intern() {
		super();
		// TODO Auto-generated constructor stub
	}
//	public Intern(Allowance allowance) {
//		super();
//		this.allowance = allowance;
//	}
}