package in.shoebit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.shoebit.entity.CitizenPlans;


public interface CitizenRepo extends JpaRepository<CitizenPlans, Integer>{
	
	@Query("select distinct(planname) from CitizenPlans")
	public List<String> getplanname();
	@Query("select distinct(planstatus) from CitizenPlans")
	public List<String> getplanstatus();

}
