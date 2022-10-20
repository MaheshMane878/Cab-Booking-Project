package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.GeneratorType;

import lombok.Data;

@Data
@Entity
public class Document {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int docid;
	
	private int cust_id;
	
	@Lob
	private byte[] addrproof;
	
	@Lob
	private byte[] adhharcard;
	
	@Lob
	private byte[] pancard;
	
	@Lob
	private byte[] photo;
	
	@Lob
	private byte[] sign;
	
	
	
	
	
	

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public int getDocid() {
		return docid;
	}

	public void setDocid(int docid) {
		this.docid = docid;
	}

	public byte[] getAddrproof() {
		return addrproof;
	}

	public void setAddrproof(byte[] addrproof) {
		this.addrproof = addrproof;
	}

	public byte[] getAdhharcard() {
		return adhharcard;
	}

	public void setAdhharcard(byte[] adhharcard) {
		this.adhharcard = adhharcard;
	}

	public byte[] getPancard() {
		return pancard;
	}

	public void setPancard(byte[] pancard) {
		this.pancard = pancard;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public byte[] getSign() {
		return sign;
	}

	public void setSign(byte[] sign) {
		this.sign = sign;
	}
	
	
	
	

	
}
