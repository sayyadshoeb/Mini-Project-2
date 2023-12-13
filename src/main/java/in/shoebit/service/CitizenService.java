package in.shoebit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.shoebit.binding.SearchCriteria;
import in.shoebit.entity.CitizenPlans;
import jakarta.servlet.http.HttpServletResponse;


public interface CitizenService {
	public List<String> getplanname();
	public List<String> getplanstatus();
	public List<CitizenPlans> searchcitizens(SearchCriteria criteria);
	public void genrateExcel(HttpServletResponse response) throws Exception;
	public void genratePdf(HttpServletResponse response) throws Exception;

}
