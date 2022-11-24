package com.sana.authorities.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sana.authorities.model.Authorities;
import com.sana.authorities.repository.AuthoritiesRepository;

@Service
public class AuthoritiesServiceImp implements AuthoritiesService {

	@Autowired
	private AuthoritiesRepository authoritiesRepository;

	public List<Authorities> getListAuthoritiess() {

		return authoritiesRepository.findAll();
	}

	@Override
	public void saveAndUpdate(Authorities authorities) {
		authoritiesRepository.save(authorities);
		
	}

	@Override
	public void deleteAuthorities(int id) {
		authoritiesRepository.deleteById(id);
		
	}

	@Override
	public Authorities getAuthoritiesById(int id) {
		return authoritiesRepository.findById(id).get();
				
	}
}
