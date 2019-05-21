/************************************************************************************
 -> File                 : EnquiryDao.java
 -> Author Name          : Ashish Dhar
 -> Desc                 : DAO interface methods
 -> Version              : 1.0
 -> Last Modified Date   : 02-May-2019
 ************************************************************************************/

package com.cg.enquiry.dao;

import com.cg.enquiry.bean.EnquiryBean;
import com.cg.enquiry.exception.EnquiryDBException;
import com.cg.enquiry.exception.InvalidEnquiryException;

public interface EnquiryDao {
	public String addEnquiry(EnquiryBean enquiry) throws EnquiryDBException;
	public EnquiryBean getEnquiryDetails(String enquiryId) throws EnquiryDBException;
}
