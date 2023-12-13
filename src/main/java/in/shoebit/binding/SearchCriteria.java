package in.shoebit.binding;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class SearchCriteria {
	private String planname;
	private String planstatus;
	private String gender;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate startdate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate enddate;
	public String getPlanname() {
		return planname;
	}
	public void setPlanname(String planname) {
		this.planname = planname;
	}
	public String getPlanstatus() {
		return planstatus;
	}
	public void setPlanstatus(String planstatus) {
		this.planstatus = planstatus;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDate getStartdate() {
		return startdate;
	}
	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}
	public LocalDate getEnddate() {
		return enddate;
	}
	public void setEnddate(LocalDate enddate) {
		this.enddate = enddate;
	}
	@Override
	public String toString() {
		return "SearchCriteria [planname=" + planname + ", planstatus=" + planstatus + ", gender=" + gender
				+ ", startdate=" + startdate + ", enddate=" + enddate + "]";
	}
	
	
}
