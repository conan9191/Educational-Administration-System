package com.service;

import java.util.List;

import com.pojo.Company;
import com.pojo.Employment;
import com.pojo.Resume;

public interface IOfferService {
	public List<Company> getAllCompanys();
	public int signOffer(Employment record);
	public int uploadResume(Resume record);
	
}
