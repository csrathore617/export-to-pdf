package com.pdfinspringboot.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.Entity;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lowagie.text.DocumentException;
import com.pdfinspringboot.Entity.Allowance;
import com.pdfinspringboot.Entity.Intern;
import com.pdfinspringboot.Repository.InternRepository;
import com.pdfinspringboot.Service.InternService;
import com.pdfinspringboot.Service.InternServiceImpl;
import com.pdfinspringboot.util.PdfGenerator;

@Controller
public class InternController {

  @Autowired

  private InternServiceImpl internService;
  
  @Autowired
	private InternRepository internRepository;
	

  @RequestMapping("/intern")
  public String getIntern(Entity entity){
      entity.notifyAll();
      return "intern";
  }

  public InternController(InternRepository internRepository) {
      this.internRepository = internRepository;
  }

@GetMapping("/intern/{id}")
public ResponseEntity<Intern> get(@PathVariable Long id) {

	try {

		Intern intern = internService.getById(id);

		return new ResponseEntity<Intern>(intern, HttpStatus.OK);

	} catch (NoSuchElementException e) {

		return new ResponseEntity<Intern>(HttpStatus.NOT_FOUND);

	}

}

@GetMapping("/{stipend}")
public List<Intern> ListOfAll(@PathVariable("stipend") String stipend){
	
	return internService.internListBystipend(stipend);
}

@PostMapping("/step")
@ResponseBody
public Intern addIntern(@RequestBody Intern intern) {
	
	String stipend =  intern.getStipend();
	
	Allowance allowance = new Allowance();
	
	
	allowance =  internService.monthCalculator(stipend);
	
//SalaryStructure salaryStructure1 = employeeService.saveSalary(salaryStructure);
	
	intern.setAllowance(allowance);
	intern = internService.save(intern); 
	
	return intern;
}

@PutMapping("/intern/{id}")
public Intern updateintern(@RequestBody Intern intern,@PathVariable("id") Long id) {
	
	
	return internService.updateIntern(intern, id);
	
}

  @GetMapping("/export-to-pdf")

  public void generatePdfFile(HttpServletResponse response) throws DocumentException, IOException {

    response.setContentType("application/pdf");

    DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");

    String currentDateTime = dateFormat.format(new Date());

    String headerkey = "Content-Disposition";

    String headervalue = "attachment; filename=intern" + currentDateTime + ".pdf";

    response.setHeader(headerkey, headervalue);

    List<Intern> listofInterns = internService.getInternList();

    PdfGenerator generator = new PdfGenerator();

    generator.generate(listofInterns, response);

  }

}