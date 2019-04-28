package com.capgemini.donorapplication.dao;

import java.util.List;

import com.capgemini.donorapplication.bean.DonorBean;
import com.capgemini.donorapplication.exception.DonorException;

public interface IDonorDAO 
{
	public String addDonorDetails(DonorBean donor) throws DonorException;
	public DonorBean viewDonorDetails(String donorId) throws DonorException;
	public List<DonorBean> retriveAllDetails()throws DonorException;
}
