package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ICompanyDao;
import com.dao.IEmploymentDao;
import com.dao.IResumeDao;
import com.pojo.Company;
import com.pojo.Employment;
import com.pojo.Resume;
import com.service.IOfferService;

@Service("offerService")
@Transactional
public class OfferServiceImpl implements IOfferService {
	@Resource
	private ICompanyDao companyDao;
	@Resource
	private IEmploymentDao employmentDao;
	@Resource 
	private IResumeDao resumeDao;
	
	@Override
	public List<Company> getAllCompanys() {
		// TODO Auto-generated method stub
		return companyDao.selectAllCompanys();
	}

	@Override
	public int signOffer(Employment record) {
		// TODO Auto-generated method stub
		return employmentDao.insert(record);
	}

	@Override
	public int uploadResume(Resume record) {
		// TODO Auto-generated method stub
		return resumeDao.insert(record);
	}

}
