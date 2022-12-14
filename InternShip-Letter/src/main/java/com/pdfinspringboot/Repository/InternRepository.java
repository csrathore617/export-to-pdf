package com.pdfinspringboot.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pdfinspringboot.Entity.Intern;


public interface InternRepository extends JpaRepository<Intern, Long> {
	public List<Intern> findBystipend(String stipend);
	
}