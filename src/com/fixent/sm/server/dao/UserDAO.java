package com.fixent.sm.server.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fixent.sm.server.model.User;

public class UserDAO extends BaseDAO {

	private Connection connect = null;
	// private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public Boolean login(User user) {

		boolean status = false;
		int value = 0;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/STUDENT_MANAGEMENT?user=smuser&password=smpw");

			preparedStatement = connect
					.prepareStatement("select count(*) from user where user_name = ? and password = ?;");
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getPassword());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next())
			{
				value = resultSet != null ?resultSet.getInt(1) : 0;
			}
			
		/*	BigInteger id = new BigInteger("0");
			Session session = getSession();
			session.beginTransaction();
			Query query = session
					.createSQLQuery("select count(id) from user where user_name = ? and password = ?;");
			query.setParameter(0, user.getUserName());
			query.setParameter(1, user.getPassword());
			if (query.uniqueResult() != null) {
				id = (BigInteger) query.uniqueResult();
			}
			session.getTransaction().commit();*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value > 0 ? true : status;
	}

}
