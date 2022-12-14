package com.pdfinspringboot.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Allowance {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sid;
	private double telephoneInternetAllowance;
	private double conveyence;
	public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}
	public double getTelephoneInternetAllowance() {
		return telephoneInternetAllowance;
	}
	public void setTelephoneInternetAllowance(double telephoneInternetAllowance) {
		this.telephoneInternetAllowance = telephoneInternetAllowance;
	}
	public double getConveyence() {
		return conveyence;
	}
	public void setConveyence(double conveyence) {
		this.conveyence = conveyence;
	}
	@Override
	public String toString() {
		return "Allowance [sid=" + sid + ", telephoneInternetAllowance=" + telephoneInternetAllowance + ", conveyence="
				+ conveyence + "]";
	}

	
}
