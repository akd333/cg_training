package com.cg.mps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cg.mps.bean.Mobile;
import com.cg.mps.bean.PurchaseMobile;
import com.cg.mps.exception.MobileDBException;
import com.cg.mps.util.DBUtil;

public class MobileDaoImpl implements MobileDao {
	
	Connection conn = null;
	@Override
	public long addMobile(Mobile mobile) throws MobileDBException {
		String sql = "INSERT_MOBILE_QUERY";
		mobile.setMobileId(generateMobileId());
		conn = DBUtil.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setLong(1, mobile.getMobileId());
			pst.setString(2, mobile.getMobileName());
			pst.setString(3, mobile.getMobilePrice());
			pst.setString(4, mobile.getQuantity());
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new MobileDBException("Problem in inserting product details"+e.getMessage());
		}
		return mobile.getMobileId();
	}
	private long generateMobileId() throws MobileDBException{
		long mid = 0;
		String sql = "MOBILEID_SEQUENCE_QUERY";
		conn = DBUtil.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rst  = stmt.executeQuery(sql);
			rst.next();
			mid = rst.getLong(1);
		} catch (SQLException e) {
			throw new MobileDBException("Problem in generating mobile id");
		}
		return mid;
	}
	@Override
	public List<Mobile> getAllMobiles() throws MobileDBException {
		String sql = "RETRIVE_ALL_MOBILES_QUERY";
		List<Mobile> mobileList = new ArrayList<Mobile>();
		conn = DBUtil.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rst = stmt.executeQuery(sql);
			while (rst.next()) {
				Mobile mob = new Mobile();
				mob.setMobileId(rst.getLong("mobileid"));
				mob.setMobileName(rst.getString("cname"));
				mob.setMobilePrice(rst.getString("price"));
				mob.setQuantity("quantity");
				mobileList.add(mob);
			}
		} catch (SQLException e) {
			throw new MobileDBException("Problem in fetching mobile list"+e.getMessage());
		}
		return mobileList;
	}

	@Override
	public long purchaseMobile(PurchaseMobile purchaseMobile) throws MobileDBException {
		String purchaseSql = "INSERT_PURCHASE_QUERY";
		String mobileSql = "MOBILE_UPDATE_QUORY";
		purchaseMobile.setPurchaseId(generatePurchaseId());
		conn = DBUtil.getConnection();
		try {
			PreparedStatement purchasePst = conn.prepareStatement(purchaseSql);
			purchasePst.setLong(1, purchaseMobile.getPurchaseId());
			purchasePst.setString(2, purchaseMobile.getCustomerName());
			purchasePst.setString(3, purchaseMobile.getCustomerEmail());
			purchasePst.setString(4, purchaseMobile.getCustomerNumber());
			purchasePst.setLong(5, purchaseMobile.getMobileId());
			purchasePst.executeQuery();
			
			PreparedStatement mobilePst = conn.prepareStatement(mobileSql);
			mobilePst.setLong(1, purchaseMobile.getMobileId());
			mobilePst.executeQuery();
		} catch (SQLException e) {
			throw new MobileDBException("Problem in placing order "+e.getMessage());
		}
		return purchaseMobile.getPurchaseId();
	}
	
	
	private long generatePurchaseId() throws MobileDBException{
		long pid = 0;
		String sql = "PURCHASEID_SEQUENCE_QUERY";
		conn = DBUtil.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rst  = stmt.executeQuery(sql);
			rst.next();
			pid = rst.getLong(1);
			
		} catch (SQLException e) {
			throw new MobileDBException("Problem in generating purchase id" + e.getMessage());
		}
		return pid;
	}
	
	@Override
	public long deleteMobile(long mobileId) throws MobileDBException {
		String sql = "MOBILE_DELETE_QUORY";
		conn = DBUtil.getConnection();
		try{
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setLong(1,mobileId);
			pst.executeUpdate();
		}catch(SQLException e){
			System.out.println("Problem in deleting product" + e.getMessage());
		}
		return mobileId;
	}

	@Override
	public Mobile searchMobileInPriceRange(Mobile mobile)
			throws MobileDBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mobile searchMobile(long mobileId) throws MobileDBException {
		String sql = "SELECT product_id, product_name, product_price FROM product WHERE product_id=?";
		Mobile mob = null;
		conn = DBUtil.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setLong(1, mobileId);
			ResultSet rst = pst.executeQuery();
			if(rst.next()){
				mob = new Mobile();
				mob.setMobileId(rst.getLong("mobileid"));
				mob.setMobileName(rst.getString("name"));
				mob.setMobilePrice(rst.getString("price"));
				mob.setQuantity(rst.getString("quantity"));
			}
		} catch (SQLException e) {
			throw new MobileDBException("Problem in searching mobile"+e.getMessage());
		}
		return mob;
	}

}
