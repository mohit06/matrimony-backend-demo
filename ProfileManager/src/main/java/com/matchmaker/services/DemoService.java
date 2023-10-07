package com.matchmaker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matchmaker.pojo.ComplexPojo;
import com.matchmaker.repositories.DemoRepo;

@Service
public class DemoService {
	
	@Autowired
	DemoRepo dr;
	


	public void saveIntoDb(ComplexPojo cp) {
		// TODO Auto-generated method stub
		//Address d = cp.getD();
		//System.out.println(d.getCity());
//		ComplexPojo cpo = new ComplexPojo();
//		Address d = new Address();
//		
//		d.setCity(cp.getD().getCity());
//		d.setCountry(cp.getD().getCountry());
//		d.setState(cp.getD().getCountry());
//	  //  d.setAdd(cp);
//	    System.out.println("D: "+d.toString());
//		
//        cpo.setA(cp.getA());
//        cpo.setB(cp.getB());
//        cpo.setC(cp.getC());
//        cpo.setD(d);
		ComplexPojo c =dr.save(cp);
		System.out.println("C: "+c);
		
	}

	
	
	
}
