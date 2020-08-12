package com.db.basic;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

public class Mysqlconn {
	public static void main(String[] args) throws ClassNotFoundException {
		Connection connection =null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/shopping?characterEncoding=utf-8", "root", "123456");
			String sql = "select * from items where id =?";

			 preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, 1);
			 resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println("½á¹û" + resultSet.getString("name"));
			}
			/*if (resultSet != null)
				resultSet.close();
			if (preparedStatement != null)
				preparedStatement.close();
			if (connection != null)
				connection.close();*/
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null)
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		if (preparedStatement != null)
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (connection != null)
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
