package in.shoebit.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.shoebit.entity.CitizenPlans;
import in.shoebit.repo.CitizenRepo;

@Component
public class DataLoader implements ApplicationRunner{
	@Autowired
 private CitizenRepo citizenRepo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		citizenRepo.deleteAll();
		
		CitizenPlans p1=new CitizenPlans("Ranbeer","Ranbeer@gmail.com",9921298l,"male",123456l,"cash","Approved",LocalDate.now(),LocalDate.now().plusMonths(6));
		CitizenPlans p2=new CitizenPlans("shoeb","shoeb@gmail.com",39343l,"male",12121l,"cash","Denied",null,null); 
		
		CitizenPlans p3=new CitizenPlans("Srk","Srk@gmail.com",777879l,"male",797877l,"food","Approved",LocalDate.now(),LocalDate.now().plusMonths(6));
		CitizenPlans p4=new CitizenPlans("dipika","dipika@gmail.com",17043405l,"female",134521l,"food","Denied",null,null); 
		
		CitizenPlans p5=new CitizenPlans("Alia","Alia@gmail.com",765439l,"female",732457l,"medical","Approved",LocalDate.now(),LocalDate.now().plusMonths(6));
		CitizenPlans p6=new CitizenPlans("Seed","Seed@gmail.com",109805l,"male",149571l,"medical","Denied",null,null); 

		List<CitizenPlans> asList = Arrays.asList(p1,p2,p3,p4,p5,p6);
        citizenRepo.saveAll(asList);

		
	}
	
}
