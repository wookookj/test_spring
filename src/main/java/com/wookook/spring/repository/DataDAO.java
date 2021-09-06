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

	public List<BookVO> getList() throws SQLException{
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
	        System.out.println( e);
	    }
	    finally {	    	
		    rs.close();
		    pstmt.close();
			conn.close();
	    }
	    return list;
	}

}
