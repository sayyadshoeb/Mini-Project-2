package in.shoebit.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="CitizenPlans")
public class CitizenPlans {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
 private Integer citizenid;
 private String name;
 private String email;
 private Long pnno;
 private String gender;
 private Long ssn;
 private String planname;
 private String planstatus;
 private LocalDate startdate;
 private LocalDate enddate;
 private LocalDate createdate;
 private LocalDate updatedate;
 
 public CitizenPlans() {
	 
 }

public CitizenPlans( String name, String email, Long pnno, String gender, Long ssn, String planname,
		String planstatus, LocalDate startdate, LocalDate enddate) {
	this.name = name;
	this.email = email;
	this.pnno = pnno;
	this.gender = gender;
	this.ssn = ssn;
	this.planname = planname;
	this.planstatus = planstatus;
	this.startdate = startdate;
	this.enddate = enddate;
	
}

public Integer getCitizenid() {
	return citizenid;
}

public void setCitizenid(Integer citizenid) {
	this.citizenid = citizenid;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public Long getPnno() {
	return pnno;
}

public void setPnno(Long pnno) {
	this.pnno = pnno;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public Long getSsn() {
	return ssn;
}

public void setSsn(Long ssn) {
	this.ssn = ssn;
}

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

public LocalDate getCreatedate() {
	return createdate;
}

public void setCreatedate(LocalDate createdate) {
	this.createdate = createdate;
}

public LocalDate getUpdatedate() {
	return updatedate;
}

public void setUpdatedate(LocalDate updatedate) {
	this.updatedate = updatedate;
}

@Override
public String toString() {
	return "CitizenPlans [citizenid=" + citizenid + ", name=" + name + ", email=" + email + ", pnno=" + pnno
			+ ", gender=" + gender + ", ssn=" + ssn + ", planname=" + planname + ", planstatus=" + planstatus
			+ ", startdate=" + startdate + ", enddate=" + enddate + ", createdate=" + createdate + ", updatedate="
			+ updatedate + "]";
}
 
 
}
