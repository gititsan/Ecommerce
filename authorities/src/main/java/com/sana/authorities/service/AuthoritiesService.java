package com.sana.authorities.service;

import java.util.List;

import com.sana.authorities.model.Authorities;

public interface AuthoritiesService {
	public List<Authorities> getListAuthoritiess();
	public void saveAndUpdate( Authorities authorities );
	public void deleteAuthorities( int id );
	public Authorities getAuthoritiesById( int id );
}
