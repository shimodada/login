package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.AccountBeans;

public class AccountRegisterDAO {
	final String URL = "jdbc:mysql://localhost:3306/login";
	final String USER = "root";
	final String PASS = "Yuki0419";
	
	public AccountRegisterDAO(AccountBeans ab) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into user values(0,?,?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(URL,USER,PASS);
			ps = con.prepareStatement(sql);
			ps.setString(1, ab.getLoginId());
			ps.setString(2, ab.getName());
			ps.setString(3, ab.getPass());
			ps.setInt(4, ab.getRole());
			ps.executeUpdate();
			System.out.println("新規登録成功です");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("接続に失敗しました");
		} finally {
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
	}
}
