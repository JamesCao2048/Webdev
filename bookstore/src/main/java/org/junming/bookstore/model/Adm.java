package org.junming.bookstore.model;

public class Adm extends User {
	public String getAdmId() {
		return this.getId();
	}

	public void setAdmId(String Id){
		this.setId(Id);
	}
	
	public String getAdmPassword() {
		return this.getPassword();
	}
	
	public void setAdmPassword(String Id){
		this.setPassword(Id);
	}
	
}