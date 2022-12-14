package com.pdfinspringboot.Service;

import java.util.List;

import com.pdfinspringboot.Entity.Intern;



public interface InternService {
	
	void addIntern(Intern intern);
	List<Intern> getInternList();
	
	
}


