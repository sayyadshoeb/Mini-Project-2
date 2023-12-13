package in.shoebit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.shoebit.binding.SearchCriteria;
import in.shoebit.entity.CitizenPlans;
import in.shoebit.service.CitizenService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class CitizenController {
	@Autowired
	private CitizenService service;

	@GetMapping("/")
	public String index(Model model) {
		formInit(model);		
		model.addAttribute("search", new SearchCriteria());
		return "index";
	}
	private void formInit(Model model) {
		List<String> planname = service.getplanname();
		List<String> planstatus = service.getplanstatus();	
		
		
		model.addAttribute("planname", planname);
		model.addAttribute("planstatus", planstatus);
	}
	@PostMapping("/filter-data")
	public String handleSearchBtn(@ModelAttribute("search")  SearchCriteria criteria, Model model) {
		List<CitizenPlans> searchcitizens = service.searchcitizens(criteria);
		model.addAttribute("citizens",searchcitizens);
		formInit(model);		
		
		return "index";
		
	}
	
	@GetMapping("/excel")
	public void downloadExcelSheet(HttpServletResponse response) throws Exception {
		response.setContentType("application/octet-stream");
		String headKey="Content-Disposition";
		String headValue="attachment;filename=data.xls";
		response.addHeader(headKey, headValue);
		service.genrateExcel(response);
	}
	
	@GetMapping("/pdf")
	public void downloadPdf(HttpServletResponse response) throws Exception {
		response.setContentType("application/pdf");
		String headKey="Content-Disposition";
		String headValue="attachment;filename=data.pdf";
		response.addHeader(headKey, headValue);
		service.genratePdf(response);
	}
	
}
