package getonFast.hj.semi.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JDBCTemplate {
	/* DB 연결, JDBC 자원 반환 등의 JDBC관련 공통 내용을 모아둔 클래스
	 * getConnection() : 커넥션을 반환하는 메소드
	 * close(stmt | pstmt | rs | conn) : 자원 반환 메소드
	 * commit() / rollback() : 트랜잭션 처리용 메소드
	 * */
	
	private static Connection conn = null;
	
	// DB 연결을 위한 커넥션 반환 메소드
	public static Connection getConnection() {
		
		try {
			if (conn == null || conn.isClosed()) {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:thin:@115.90.212.22:9000:xe";
				String userName = "rent";
				String password = "rent1234!";
				
				conn = DriverManager.getConnection(url, userName, password);
				
				conn.setAutoCommit(false);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
	// Connection 반환 메소드
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				// conn이 참조하는 Connection 객체가 있고
				// 그 객체가 반환되지 않았을 때 
				conn.close();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	// Statement 반환 메소드 + (다형성을 이용하여 PreparedStatement도 같이 반환 가능)
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// ResultSet 반환 메소드 
	public static void close(ResultSet rs) {
		try {
			if(rs != null && !rs.isClosed()) {
				rs.close();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	// commit용 메소드
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				// conn이 참조하는 Connection 객체가 있고
				// 그 객체가 반환되지 않았을 때 
				conn.commit();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// rollback용 메소드
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				// conn이 참조하는 Connection 객체가 있고
				// 그 객체가 반환되지 않았을 때 
				conn.rollback();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
