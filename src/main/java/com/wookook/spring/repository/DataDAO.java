package com.wookook.spring.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.wookook.spring.vo.BookVO;

@Repository
public class DataDAO {
	private Connection getConnection() throws SQLException {
	    Connection conn = null;

	    try {
	        Class.forName("com.mysql.jdbc.Driver");

	        String url = "jdbc:mysql://localhost/db_test";
	        conn = DriverManager.getConnection(url, "root", "1234");
	    }
	    catch (ClassNotFoundException e) {
	        System.out.println(e);
	    }

	    return conn;
	}

	public List<BookVO> getList(){
	    List<BookVO> list = new ArrayList<BookVO>();
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    try {
	        conn = getConnection();

	        String sql = "select * from book";

	        pstmt = conn.prepareStatement(sql);
	        rs = pstmt.executeQuery();

	        while(rs.next()) {
	        	BookVO bvo = new BookVO();
	        	bvo.setBookid(rs.getInt("bookid"));
	        	bvo.setBookname(rs.getString("bookname"));
	        	bvo.setPublisher(rs.getString("publisher"));
	        	bvo.setPrice(rs.getInt("price"));
	        	list.add(bvo);
	        }	       
	    }
	    catch (SQLException e) {
	    }
	    finally {	    	
		    try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		    try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
	    return list;
	}
	
	public boolean insertList(BookVO Bvo){
	    boolean result = false;
	    Connection conn = null;
	    PreparedStatement pstmt = null;

	    try {
	        conn = getConnection();

	        String sql = "insert into book values(?,?,?,?)";
	        pstmt = conn.prepareStatement(sql);
	      
			pstmt.setInt(1, Bvo.getBookid());
			pstmt.setString(2, Bvo.getBookname());
			pstmt.setString(3, Bvo.getPublisher());
			pstmt.setInt(4, Bvo.getPrice());
			int resultcount = pstmt.executeUpdate();
			
	        if(resultcount > 0) {
	        	result = true;
	        }
	    }
	    catch (SQLException e) {
	    }
	    finally {
	    	try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    	try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
	    return result;
	}

	public boolean deleteList(int bookid) {
	    boolean result = false;
	    Connection conn = null;
	    PreparedStatement pstmt = null;

	    try {
	        conn = getConnection();

	        String sql = "delete from book where bookid=?";
	        pstmt = conn.prepareStatement(sql);
	      
			pstmt.setInt(1, bookid);
			int resultcount = pstmt.executeUpdate();
			
	        if(resultcount > 0) {
	        	result = true;
	        }
	    }
	    catch (SQLException e) {
	    }
	    finally {
	    	try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    	try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
	    return result;
	}

}
