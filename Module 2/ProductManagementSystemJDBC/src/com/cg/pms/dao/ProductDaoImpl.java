package com.cg.pms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.cg.pms.beans.Order;
import com.cg.pms.beans.Product;
import com.cg.pms.exception.ProductDBException;
import com.cg.pms.util.DBUtil;

public class ProductDaoImpl implements ProductDao {
	
	Connection conn = null;
	@Override
	public List<Product> getAllProduct() throws ProductDBException {
		String sql = "SELECT product_id, product_name, product_price FROM product";
		List<Product> plist = new ArrayList<Product>();
		conn = DBUtil.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rst = stmt.executeQuery(sql);
			while (rst.next()) {
				Product p = new Product();
				p.setProductId(rst.getLong("product_id"));
				p.setProductName(rst.getString("product_name"));
				p.setProductPrice(rst.getLong("product_price"));
				plist.add(p);
			}
		} catch (SQLException e) {
			throw new ProductDBException("Problem in fetching product"+e.getMessage());
		}
		return plist;
	}

	@Override
	public Product searchProduct(long productId) throws ProductDBException {
		String sql = "SELECT product_id, product_name, product_price FROM product WHERE product_id=?";
		Product p = null;
		conn = DBUtil.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setLong(1, productId);
			ResultSet rst = pst.executeQuery();
			if(rst.next()){
				p = new Product();
				p.setProductId(rst.getLong("product_id"));
				p.setProductName(rst.getString("product_name"));
				p.setProductPrice(rst.getLong("product_price"));
			}
		} catch (SQLException e) {
			throw new ProductDBException("Problem in searching product"+e.getMessage());
		}
		return p;
	}

	@Override
	public long addProduct(Product product) throws ProductDBException {
		String sql = "INSERT INTO product VALUES(?,?,?)";
		product.setProductId(generateProductId());
		conn = DBUtil.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setLong(1, product.getProductId());
			pst.setString(2, product.getProductName());
			pst.setDouble(3, product.getProductPrice());
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new ProductDBException("Problem in inserting product details"+e.getMessage());
		}
		return product.getProductId();
	}
	private long generateProductId() throws ProductDBException{
		long pid = 0;
		String sql = "SELECT product_seq.NEXTVAL FROM dual";
		conn = DBUtil.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rst  = stmt.executeQuery(sql);
			rst.next();
			pid = rst.getLong(1);
		} catch (SQLException e) {
			throw new ProductDBException("Problem in generating product id");
		}
		return pid;
	}
	
	@Override
	public long addOrder(Order order) throws ProductDBException {
		String sql = "INSERT INTO product_order values(?,?,?,?,?)";
		order.setOrderId(generateOrderId());
		conn = DBUtil.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setLong(1, order.getOrderId());
			pst.setLong(2, order.getProductId());
			pst.setInt(3, order.getQuantity());
			pst.setDouble(4, order.getTotalAmount());
			pst.setDate(5, Date.valueOf(order.getOrderDate()));
			pst.executeQuery();
		} catch (SQLException e) {
			throw new ProductDBException("Problem in placing order "+e.getMessage());
		}
		return order.getOrderId();
	}
	
	private long generateOrderId() throws ProductDBException{
		long oid = 0;
		String sql = "SELECT  order_seq.NEXTVAL FROM dual";
		conn = DBUtil.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rst  = stmt.executeQuery(sql);
			rst.next();
			oid = rst.getLong(1);
			
		} catch (SQLException e) {
			throw new ProductDBException("Problem in generating order id" + e.getMessage());
		}
		return oid;
	}
	
	@Override
	public long deleteProduct(long productId) throws ProductDBException {
		String sql = "DELETE FROM product WHERE product_id=?";
		conn = DBUtil.getConnection();
		try{
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setLong(1, productId);
			pst.executeUpdate();
		}catch(SQLException e){
			System.out.println("Problem in deleting product" + e.getMessage());
		}
		return productId;
		
	}

}
