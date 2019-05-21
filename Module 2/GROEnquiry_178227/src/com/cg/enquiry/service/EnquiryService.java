/************************************************************************************
 -> File                 : EnquiryService.java
 -> Author Name          : Ashish Dhar
 -> Desc                 : Enquiry service defines service methods
 -> Version              : 1.0
 -> Last Modified Date   : 02-May-2019
 ************************************************************************************/
package com.cg.enquiry.service;

import com.cg.enquiry.bean.EnquiryBean;
import com.cg.enquiry.exception.EnquiryDBException;
import com.cg.enquiry.exception.InvalidEnquiryException;

public interface EnquiryService {
	public String addEnquiry(EnquiryBean enquiry) throws EnquiryDBException;
	public EnquiryBean getEnquiryDetails(String enquiryId) throws EnquiryDBException;
	public boolean isValidEnquiry(EnquiryBean enquiry) throws InvalidEnquiryException;

}
