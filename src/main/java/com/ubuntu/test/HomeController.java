package com.ubuntu.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import jdbc.DBCPInit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//import org.postgresql.*;


import com.ubuntu.data.Member;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
//	String className="org.postgresql.Driver";
//	String url = "jdbc:postgresql://192.168.0.19:5432/jdh";
//	String user = "jdh";
//	String password = "P@ssw0rd";
	DBCPInit dbcp = new DBCPInit();
	Connection con = null;
	String sql = "SELECT * FROM MEMBER;";
	String insertSql = "INSERT INTO MEMBER(m_user_id,m_user_name,m_user_pw,m_user_role) values(?,?,?,?);";
	Statement stmt = null;
	PreparedStatement prstmt= null;
	ResultSet rs = null;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value="/second", method=RequestMethod.POST)
	public String second(Member member, Model model){
		logger.info("{}",member);
//		logger.info("Sum num1*num2 = {}",num1*num2);
//		model.addAttribute("multi",num1*num2);		
		
		System.out.println();
		try {
//			Class.forName(className);
//			logger.info("Driver Loading Success");
//			Connection con = DriverManager.getConnection(url, user, password);
//			logger.info("Connection Success");	
			con=dbcp.getConnection();
			stmt=con.createStatement();
			prstmt=con.prepareStatement(insertSql);
			prstmt.setString(1, member.getM_user_id());
			prstmt.setString(2, member.getM_user_name());
			prstmt.setString(3, member.getM_user_pw());
			prstmt.setString(4, member.getM_user_role());
			prstmt.executeUpdate();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				String id = rs.getString("m_user_id");
				String name = rs.getString("m_user_name");
				String pw = rs.getString("m_user_pw");
				String role = rs.getString("m_user_role");
				System.out.println("m_user_id: "+id+", m_user_name: "+name+", m_user_pw: "+pw+", m_user_role: "+role);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dbcp.freeConnection(con,prstmt,stmt,rs);
		}
		
		return "second";
	}
	
}
