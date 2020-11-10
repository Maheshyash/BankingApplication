package com.safeBank.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.*;
public class Model{
	private String name;
	private String custid;
	private int accno;
	private String pwd;
	private int bal;
	private String email;
	private Long num;
	private int raccno;
	private int OTP;
	static int gotp;
	public int getOTP() {
		return OTP;
	}
	public void setOTP(int oTP) {
		OTP = oTP;
	}

	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public ArrayList al = new ArrayList();
	public ArrayList sal = new ArrayList();
	public ArrayList ral = new ArrayList();

	
	public int getRaccno() {
		return raccno;
	}
	public void setRaccno(int raccno) {
		this.raccno = raccno;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getBal() {
		return bal;
	}
	public void setBal(int bal) {
		this.bal = bal;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}
	
	public Model() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapi","root","Maheshyash@18");
		System.out.println("");
	}
	public boolean register() throws SQLException {
		String s = "insert into safebank values(?,?,?,?,?,?,?)";
		pst = con.prepareStatement(s);
		pst.setString(1, name);
		pst.setString(2, custid);
		pst.setInt(3, accno);
		pst.setString(4, pwd);
		pst.setInt(5, bal);
		pst.setString(6, email);
		pst.setLong(7, num);
		
		int x = pst.executeUpdate();
		if(x>0) {
			return true;
		}
		return false;
	}
	public boolean login() throws SQLException {
		String s = "select * from safebank where custid=? and password=?";
		pst=con.prepareStatement(s);
		pst.setString(1, custid);
		pst.setString(2, pwd);
		
		rs = pst.executeQuery();
		
		while(rs.next()==true) {
			accno=rs.getInt("accno");
			return true;
		}
		return false;
	}
	public boolean checkBalance() throws SQLException {
		String s = "Select balance from safebank where accno=?";
		pst = con.prepareStatement(s);
		pst.setInt(1, accno);
		rs = pst.executeQuery();
		
		while (rs.next()==true) {
			bal =rs.getInt("balance");
			return true;
			
		}
		return false;
	}
	public boolean changePwd() throws SQLException {
		String s = "update safebank set password =? where accno=?";
		pst = con.prepareStatement(s);
		pst.setString(1, pwd);
		pst.setInt(2, accno);
		int x = pst.executeUpdate();
		
		if(x>0) {
			return true;
		}
		return false;
	}
	public boolean transfer() throws SQLException {
		String s1 ="select * from safebank where accno = ?";
		pst = con.prepareStatement(s1);
		pst.setInt(1, raccno);
		 rs = pst.executeQuery();
		while(rs.next()==true) {
			String  s2="update  safebank set balance=balance-? where accno=?";
			pst=con.prepareStatement(s2);
			pst.setInt(1, bal);
			pst.setInt(2, accno);
			int y1 = pst.executeUpdate();
			if (y1>0){
				int x = rs.getInt("balance");
				if(x>0) {
					String s3 = "Update safebank set balance = balance +? where accno=?";
					pst = con.prepareStatement(s3);
					pst.setInt(1, bal);
					pst.setInt(2, raccno);
					int y2 = pst.executeUpdate();
					if(y2>0) {
						String s4 = "insert into GetStatement values(?,?,?)";
						pst = con.prepareStatement(s4);
						pst.setInt(1, accno);
						pst.setInt(2, raccno);
						pst.setInt(3, bal);
						int y = pst.executeUpdate();
						if(y>0) {
							return true; 
						}
						else {
							return false;
						}
					}
					
				}
				else {
					return false;
				}
				
			}
			
		}
		return false;
	}
	public ArrayList getStatement() throws SQLException {
		String s = "select * from GetStatement where accno=?";
		pst = con.prepareStatement(s);
		pst.setInt(1, accno);
		rs =pst.executeQuery();
		
		while(rs.next()==true) {
			sal.add(rs.getInt("accno"));
			ral.add(rs.getInt("raccno"));
			al.add(rs.getInt("balance"));
		
		}
		return al;
		
	}
	public boolean applyLoan() throws SQLException {
		String s = "Select * from safebank where accno=?";
		pst = con.prepareStatement(s);
		pst.setInt(1, accno);
		rs = pst.executeQuery();
		while(rs.next()==true) {
			name = rs.getString("name");
			email = rs.getString("email");
			return true;
			
		}
		return false;
	}
	public boolean getOtp() throws SQLException {
		String s = "Select * from safeBank where accno=? and phone_Number=?";
		pst = con.prepareStatement(s);
		pst.setInt(1, accno);
		pst.setLong(2, num);
		rs = pst.executeQuery();
		while(rs.next()==true) {
			String otp2 = OTPGenerator.otp();
			 gotp= Integer.parseInt(otp2);
			System.out.println("generate otp"+gotp);
			return true;
		}
		return false;
	}
	
	public boolean checking() {
		String phone_Number = num+"";
				String result = SendOtp.sendSms1(phone_Number);
				System.out.println(result);
				if(gotp==OTP) {
					return true;
				}
				return false;
		
	}
}











