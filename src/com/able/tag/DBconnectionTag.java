package com.able.tag;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class DBconnectionTag extends TagSupport {
	private String driver;
	private String url;
	private String password;
	private String sql;
	private String username;
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	

	@Override
	public int doEndTag() throws JspException {
		try {
			Class.forName(this.driver);
			conn = DriverManager.getConnection(this.url,this.username,this.password);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(this.sql);
			if (rs != null) {
				while (rs.next()) {
					pageContext.getOut().print(rs.getString("cname")+"<br/>");
				}
			}
			return EVAL_PAGE;
		} catch (Exception e) {
			e.printStackTrace();
			return SKIP_PAGE;
		} finally {
				try {
					if (rs != null) {
						rs.close();
					}
					if (stmt != null) {
						stmt.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
