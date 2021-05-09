package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDriver;
import org.apache.commons.pool.impl.GenericObjectPool;

public class DBCPInit{
	
	String className="org.postgresql.Driver";
	String url = "jdbc:postgresql://192.168.0.19:5432/jdh";
	String user = "jdh";
	String password = "P@ssw0rd";
	
	public DBCPInit(){
		super();
		try {
			setupDriver(className,url,user,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getConnection(){
		Connection con = null;
		try {
			con=DriverManager.getConnection("jdbc:apache:commons:dbcp:post12");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	

	private void setupDriver(String className, String url, String user,
			String password) throws Exception {
		// TODO Auto-generated method stub
		Class.forName(className);
		
		GenericObjectPool connectionPool= new GenericObjectPool(null);
		connectionPool.setMaxActive(20);
		connectionPool.setMaxIdle(5);
		
		ConnectionFactory connectionFactory= new DriverManagerConnectionFactory(url,user,password);
		
		new PoolableConnectionFactory(connectionFactory,connectionPool,null,null,false,true);
		
		PoolingDriver driver = new PoolingDriver();
		
		driver.registerPool("post12", connectionPool);
	}
	
	public void freeConnection(Connection con, PreparedStatement prstmt,Statement stmt, ResultSet rs){
		
		try {
			if(rs!=null)rs.close();
			if(prstmt!=null)prstmt.close();
			if(stmt!=null)stmt.close();
			freeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void freeConnection(Connection con, PreparedStatement prstmt, ResultSet rs){
		
			try {
				if(rs!=null)rs.close();
				if(prstmt!=null)prstmt.close();
				freeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void freeConnection(Connection con, Statement stmt, ResultSet rs){
		
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			freeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void freeConnection(Connection con, PreparedStatement prstmt){
		
		try {			
			if(prstmt!=null)prstmt.close();
			freeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void freeConnection(Connection con, Statement stmt){
		
		try {			
			if(stmt!=null)stmt.close();
			freeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void freeConnection(PreparedStatement prstmt){
		
		try {			
			if(prstmt!=null)prstmt.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void freeConnection(ResultSet rs){
	
		try {
			if(rs!=null)rs.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void freeConnection(Statement stmt){
	
		try {			
			if(stmt!=null)stmt.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private void freeConnection(Connection con) {
		// TODO Auto-generated method stub
		try {			
			if(con!=null)con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
