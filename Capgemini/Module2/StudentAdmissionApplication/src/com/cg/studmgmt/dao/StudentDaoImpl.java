package com.cg.studmgmt.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cg.studmgmt.dto.Department;
import com.cg.studmgmt.dto.Student;
import com.cg.studmgmt.exception.AdmissionException;
import com.cg.studmgmt.util.DatabaseConnection;

public class StudentDaoImpl implements IStudentDao{

	private static Logger lg= Logger.getLogger("LoggerForDaoClass");
	Connection con;
	public StudentDaoImpl() {
		con=DatabaseConnection.getConnection();
	}
	
	int generateRollNo(){
		int rollno=0;
		String sql="select rollno_seq.nextval from dual";
		try {
			Statement st= con.createStatement();
			ResultSet rs= st.executeQuery(sql);
			if(rs.next())
				rollno= rs.getInt(1);
		} catch (SQLException e) {
			lg.error(e.getMessage());
			e.printStackTrace();
		}
		return rollno;
	}
	@Override
	public int addStudent(Student student) throws AdmissionException {
	
	String sql ="insert into student_details "
			+ " values(?,?,?,?,?)";	
	try {
		PreparedStatement ps= con.prepareStatement(sql);
		int rollno= generateRollNo();
		ps.setInt(1, rollno);
		ps.setString(2, student.getName());
		ps.setString(3, student.getAddress());
		ps.setInt(4, student.getDeptNo());
		ps.setDate(5, Date.valueOf(student.getAdmissionDate()));
		int r=ps.executeUpdate();
		lg.info("Record inserted in DB ");
		if(r==1)
		return rollno;	
	} catch (SQLException e) {
		lg.error(e.getMessage());
		throw new AdmissionException(e.getMessage());
	}
	return 0;	
	}

	@Override
	public ArrayList<Department> getDepartments() throws AdmissionException{
			ArrayList<Department> list= new ArrayList<>();
		try {
			Statement st= con.createStatement();
			ResultSet rs=st.executeQuery("select dept_no ,dept_name from dept_details" );
			while(rs.next()){
				Department dept= new Department();
				dept.setDeptNo(rs.getInt(1));
				dept.setDeptName(rs.getString(2));
				list.add(dept);
			}
		} catch (SQLException e) {
			lg.error(e.getMessage());
			throw new AdmissionException(e.getMessage());
		}
		
		return list;

	}

	@Override
	public int updateAddress(String address, int rollno)
			throws AdmissionException {

String	sql="update student_details set address=? where roll_no=?";
try {
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setString(1, address);
	ps.setInt(2, rollno);
		int r=ps.executeUpdate();
		lg.info("Record updated : "+ rollno );
		return r;
} catch (SQLException e) {
	lg.error(e.getMessage());
	throw new AdmissionException(e.getMessage());
}
}

	public boolean CheckDeptCode(int deptno) throws AdmissionException{
		try {
			String sql1="select count(*) from dept_details where dept_no=?";
			PreparedStatement ps= con.prepareStatement(sql1);
			ps.setInt(1, deptno);
			ResultSet rs1= ps.executeQuery();
			rs1.next();
			if(rs1.getInt(1)==0){
				lg.error("Dept code does not exist ...");
				throw new AdmissionException("Dept code does not exist ...");
			
			}
		} catch (SQLException e) {
			lg.error(e.getMessage());
			throw new AdmissionException(e.getMessage());
		} catch (AdmissionException e) {
				lg.error(e.getMessage());
			throw e;
		}
		
		return true;
	}
	@Override
	public ArrayList<Student> getStudentList(int deptno) throws AdmissionException {
		ArrayList<Student> list=new ArrayList<>();
		
		try {
			if(CheckDeptCode(deptno)==true){
			String sql="select * from student_details where dept_no=?";
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setInt(1, deptno);
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				Student s= new Student();
				s.setRollNo(rs.getInt("roll_no"));
				s.setName(rs.getString("stud_name"));
				s.setAddress(rs.getString("address"));
				s.setDeptNo(rs.getInt("dept_no"));
				LocalDate dt= rs.getDate("adm_date").toLocalDate();
				s.setAdmissionDate(dt);
				list.add(s);
			}
			}
		} catch (SQLException e) {
			lg.error(e.getMessage());
			throw new AdmissionException(e.getMessage());
		}
		return list;
		
	}
}
