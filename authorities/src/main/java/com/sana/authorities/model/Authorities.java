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

   /* @OneToOne
    @JoinColumn(name = "ID")
    private User user;

      
    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	} */

	private String authority;

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
} // The End of Class;
