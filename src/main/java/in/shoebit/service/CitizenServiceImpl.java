package in.shoebit.service;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfCell;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;

import in.shoebit.binding.SearchCriteria;
import in.shoebit.entity.CitizenPlans;
import in.shoebit.repo.CitizenRepo;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CitizenServiceImpl implements CitizenService {
	@Autowired
 private CitizenRepo repo;
	@Override
	public List<String> getplanname() {
		return repo.getplanname();
		
	}

	@Override
	public List<String> getplanstatus() {
		return repo.getplanstatus();
		
	}

	@Override
	public List<CitizenPlans> searchcitizens(SearchCriteria criteria) {
		CitizenPlans entity= new CitizenPlans();
		
		if(StringUtils.isNotBlank(criteria.getPlanname())) {
			entity.setPlanname(criteria.getPlanname());
		}
		
		if(StringUtils.isNotBlank(criteria.getPlanstatus())) {
			entity.setPlanstatus(criteria.getPlanstatus());
		}
		if(StringUtils.isNotBlank(criteria.getGender())) {
			entity.setGender(criteria.getGender());
		}
		if(null!=criteria.getStartdate()) {
			entity.setStartdate(criteria.getStartdate());
		}
		if(null!=criteria.getEnddate()) {
			entity.setEnddate(criteria.getEnddate());
		}
		Example<CitizenPlans> of = Example.of(entity);
		return repo.findAll(of);
	}

	@Override
	public void genrateExcel(HttpServletResponse response) throws Exception {
		List<CitizenPlans> list = repo.findAll();
		HSSFWorkbook workbook=new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		HSSFRow Headerrow = sheet.createRow(0);
		Headerrow.createCell(0).setCellValue("Name");
		Headerrow.createCell(1).setCellValue("Email");
		Headerrow.createCell(2).setCellValue("Gender");
		Headerrow.createCell(3).setCellValue("SSN");
		Headerrow.createCell(4).setCellValue("PlanName");
		Headerrow.createCell(5).setCellValue("PlanStatus");
		
		int RowIndex=1;
		for(CitizenPlans record : list){
			HSSFRow DataRow = sheet.createRow(RowIndex);
			
			DataRow.createCell(0).setCellValue(record.getName());
			DataRow.createCell(1).setCellValue(record.getEmail());
			DataRow.createCell(2).setCellValue(record.getGender());
			DataRow.createCell(3).setCellValue(record.getSsn());
			DataRow.createCell(4).setCellValue(record.getPlanname());
			DataRow.createCell(5).setCellValue(record.getPlanstatus());

			RowIndex++;
			
		}
		
		ServletOutputStream outputStream= response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();

	}

	@Override
	public void genratePdf(HttpServletResponse response) throws Exception {
		//List<CitizenPlans> records = repo.findAll(); //all thr records avlbl in the table
		
		Document d =new Document(PageSize.A4);
				
		ServletOutputStream outputStream=response.getOutputStream();
		PdfWriter.getInstance(d, outputStream);
		d.open();
		
		Font fontTitle =FontFactory.getFont(FontFactory.TIMES_BOLDITALIC);
		fontTitle.setSize(20);
		
		
		Paragraph p=new Paragraph("Citizens Plan Info ", fontTitle);
		p.setAlignment(Paragraph.ALIGN_CENTER);
		d.add(p);
		
		PdfPTable table= new PdfPTable(6);
		table.setWidthPercentage(100);
		table.setWidths(new int[] {3,3,3,3,3,3});
		
		PdfPCell cell=new PdfPCell();
		cell.setBackgroundColor(CMYKColor.GRAY);
		cell.setPadding(5);
		Font font =FontFactory.getFont(FontFactory.TIMES_ROMAN);
		font.setColor(CMYKColor.WHITE);
		
		cell.setPhrase(new Phrase("Name",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Email",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Gender",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("SSN",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("PlanName",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("PlanStatus",font));
		table.addCell(cell);

		List<CitizenPlans> records=repo.findAll();
		
		for(CitizenPlans record : records) {
			table.addCell(record.getName());
			table.addCell(record.getEmail());
			table.addCell(record.getGender());
			table.addCell(String.valueOf(record.getSsn()));
			table.addCell(record.getPlanname());
			table.addCell(record.getPlanstatus());

		}
		d.add(table);
		d.close();
		outputStream.close(); 
		
		
	}

}
