package com.pdfinspringboot.util;

import java.io.IOException;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.pdfinspringboot.Entity.Intern;

public class PdfGenerator {

  public void generate(List < Intern > internList, HttpServletResponse response) throws DocumentException, IOException {


	    Document document = new Document(PageSize.A3);

	    // Getting instance of PdfWriter

	    PdfWriter.getInstance(document, response.getOutputStream());

	    // Opening the created document to change it

	    document.open();

	    // Creating font

	    // Setting font style and size

	    Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);

	    fontTiltle.setSize(20);

	    // Creating paragraph

	    Paragraph paragraph1 = new Paragraph("List of the Interns", fontTiltle);

	    // Aligning the paragraph in the document

	    paragraph1.setAlignment(Paragraph.ALIGN_CENTER);

	    // Adding the created paragraph in the document

	    document.add(paragraph1);

	    // Creating a table of the 14 columns

	    PdfPTable table = new PdfPTable(12);

	    // Setting width of the table, its columns and spacing

	    table.setWidthPercentage(100f);

	    table.setWidths(new int[] {1,1,1,1,1,1,1,1,1,1,1,1});

	    table.setSpacingBefore(2);

	    // Create Table Cells for the table header

	    PdfPCell cell = new PdfPCell();

	    // Setting the background color and padding of the table cell

	    cell.setBackgroundColor(CMYKColor.BLUE);

	    cell.setPadding(3);

	    // Creating font

	    // Setting font style and size

	    Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);

	    font.setColor(CMYKColor.WHITE);

	    // Adding headings in the created table cell or  header

	    // Adding Cell to table

	  
	    cell.setPhrase(new Phrase("ID", font));

	    table.addCell(cell);
	    
	    cell.setPhrase(new Phrase("NAME", font));

	    table.addCell(cell);
	    
	    cell.setPhrase(new Phrase("Email", font));

	    table.addCell(cell);

	    cell.setPhrase(new Phrase("Pan", font));

	    table.addCell(cell);
	    
	    cell.setPhrase(new Phrase("Pfnumber", font));

	    table.addCell(cell);
	    
	    cell.setPhrase(new Phrase("Dateofjoining", font));

	    table.addCell(cell);
	    
	    cell.setPhrase(new Phrase("Department", font));

	    table.addCell(cell);
	    
	    cell.setPhrase(new Phrase("Degination", font));

	    table.addCell(cell);
	    
	    cell.setPhrase(new Phrase("Location", font));

	    table.addCell(cell);
	    
	    cell.setPhrase(new Phrase("Stipend", font));

	    table.addCell(cell);
	    
	    cell.setPhrase(new Phrase("Tenure", font));

	    table.addCell(cell);
	    
	    cell.setPhrase(new Phrase("Allowance", font));

	    table.addCell(cell);
//	    
//	    cell.setPhrase(new Phrase("telephoneInternetAllowance", font));
//
//	    table.addCell(cell);
//	    
//	    cell.setPhrase(new Phrase("conveyence", font));
//
//	    table.addCell(cell);

	    // Iterating the list of intern

	    for (Intern intern: internList) {


	    
	      table.addCell(String.valueOf(intern.getId()));

	  
	      table.addCell(intern.getName());
	      

	      table.addCell(intern.getEmail());

	    
	      table.addCell(intern.getPan());
	      
	      table.addCell(intern.getPfnumber());

	      table.addCell(intern.getDateofjoining());
	      
	      table.addCell(intern.getDepartment());
	      
	      table.addCell(intern.getDegination());
	      
	      table.addCell(intern.getLocation());
	      
	      table.addCell(intern.getStipend().toString());   
	      
	      table.addCell(intern.getTenure());
	           
	      
	     table.addCell(intern.getAllowance().toString());
	    }

	    // Adding the created table to the document

	    document.add(table);

	    // Closing the document

	    document.close();

	  }


}