																																																																																																																																																																																																																																																																																			package com.pdfinspringboot.Service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pdfinspringboot.Entity.Allowance;
import com.pdfinspringboot.Entity.Intern;
import com.pdfinspringboot.Repository.AllowanceRepository;
import com.pdfinspringboot.Repository.InternRepository;


@Service
public class InternServiceImpl implements InternService {
	
	@Autowired
	private InternRepository internRepository;
	
	@Override
	public void addIntern(Intern intern) {
		internRepository.save(intern);


	}

	@Override
	public List<Intern> getInternList() {
		return internRepository.findAll();

	}
public List<Intern> listAll(){
	return internRepository.findAll(Sort.by("id").ascending());
}
	@Autowired
	private AllowanceRepository allowanceRepository;
	
	Allowance salaryStructure = new Allowance();
	
	//displaying all intern using id;;
	
	public Intern getById(Long id){
		
		return internRepository.findById(id).get();
	}
 
	public Allowance monthCalculator(String stipend) {
		


		Allowance awllowance = new Allowance();
		
		awllowance.setTelephoneInternetAllowance(1500);
		awllowance.setConveyence(1600);
		
		  
		return awllowance;
		
	}
	
	public Intern save(Intern intern) {
		
		
		return  internRepository.save(intern);
	}

	
	//employee details by stipend::
	
	public List<Intern> internListBystipend(String stipend){
		
		List<Intern> intern =  internRepository.findBystipend(stipend);
		
		for (Intern intern2 : intern) {
			
			System.out.println(intern2);
		}
		
		
		
		return intern;
	}
	
	//updating employee ::
	
	public Intern updateIntern(Intern intern, Long id) {
		
		
		Intern interndb = internRepository.findById(id).get();
		
		
		if(Objects.nonNull(intern.getName()) && !"".equalsIgnoreCase(intern.getName())) {
			
			 interndb.setName(intern.getName());
			
		}
		
		if(Objects.nonNull(intern.getPan()) && !"".equalsIgnoreCase(intern.getPan())) {
			
			 interndb.setPan(intern.getPan());
		}
		
		if(Objects.nonNull(intern.getStipend())) {
			
			 interndb.setStipend(intern.getStipend());
			
		}
		
		if(Objects.nonNull(intern.getEmail()) && !"".equalsIgnoreCase(intern.getEmail())) {
			 interndb.setEmail(intern.getEmail());
		}
		
		if(Objects.nonNull(intern.getPfnumber()) && !"".equalsIgnoreCase(intern.getPfnumber())) {
			 interndb.setPfnumber(intern.getPfnumber());}
		
		if(Objects.nonNull(intern.getDateofjoining()) && !"".equalsIgnoreCase(intern.getDateofjoining())) {
			 interndb.setDateofjoining(intern.getDateofjoining());
		}
		if(Objects.nonNull(intern.getDepartment()) && !"".equalsIgnoreCase(intern.getDepartment())) {
			 interndb.setDepartment(intern.getDepartment());
		}
		if(Objects.nonNull(intern.getDegination()) && !"".equalsIgnoreCase(intern.getDegination())) {
			 interndb.setDegination(intern.getDegination());
		}
		if(Objects.nonNull(intern.getLocation()) && !"".equalsIgnoreCase(intern.getLocation())) {
			 interndb.setLocation(intern.getLocation());
		}
		if(Objects.nonNull(intern.getTenure()) && !"".equalsIgnoreCase(intern.getTenure())) {
			 interndb.setTenure(intern.getTenure());
		}
		
		return internRepository.save(interndb);		
	}

}
