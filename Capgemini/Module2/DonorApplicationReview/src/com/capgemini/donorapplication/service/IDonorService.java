package com.capgemini.donorapplication.service;

import java.util.List;

import com.capgemini.donorapplication.bean.DonorBean;
import com.capgemini.donorapplication.exception.DonorException;

public interface IDonorService 
{
	public String addDonorDetails(DonorBean donor) throws DonorException;
	public DonorBean viewDonorDetails(String donorId) throws DonorException;
	public List<DonorBean> retriveAll()throws DonorException;
}
