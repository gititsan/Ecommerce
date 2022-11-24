package com.sana.authorities.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Authorities {

	@Id
	@GeneratedValue
	private int authoritiesId;

	private String authority;

	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getAuthoritiesId() {
		return authoritiesId;
	}

	public void setAuthoritiesId(int authoritiesId) {
		this.authoritiesId = authoritiesId;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
