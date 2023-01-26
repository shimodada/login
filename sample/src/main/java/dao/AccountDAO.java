package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.AccountBeans;

public class AccountDAO {
	final String URL = "jdbc:mysql://localhost:3306/login";
	final String USER = "root";
	final String PASS = "Yuki0419";
	
	public AccountBeans findAccount(AccountBeans ab) {
		AccountBeans returnAb = new AccountBeans();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(URL,USER,PASS);
			
			String sql = "select loginId,pass,neme,roleId from user where loginId=? and pass=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, ab.getLoginId());
			ps.setString(2, ab.getPass());
			
			rs = ps.executeQuery();
			System.out.println("接続成功");
			if (rs.next()) {
				//見つかったアカウント情報を戻り値にセット
				returnAb.setLoginId(rs.getString("loginId"));
				returnAb.setPass(rs.getString("pass"));
				returnAb.setName(rs.getString("neme"));
				returnAb.setRole(rs.getInt("roleId"));
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("接続失敗");
			return null;
		} finally {
			if (rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			if (ps!=null)
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			if (con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
		}
		return returnAb;
	}
}
