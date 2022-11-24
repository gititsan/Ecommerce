package com.sana.authorities.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sana.authorities.model.Authorities;

 

@Repository
public interface AuthoritiesRepository extends JpaRepository<Authorities, Integer>{

}
