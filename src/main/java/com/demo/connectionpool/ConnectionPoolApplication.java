package com.demo.connectionpool;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConnectionPoolApplication {

	public static void main(String[] args) throws SQLException {

		ConnectionPool pool = new ConnectionPool("jdbc:mysql://localhost/cplatform", "root", "root");
		Connection con1 = pool.getConnection();
		Connection con2 = pool.getConnection();
		System.out.println("Available connections: " + pool.getFreeConnectionCount());
		Connection con3 = pool.getConnection();
		Connection con4 = pool.getConnection();
		Connection con5 = pool.getConnection();
		Connection con6 = pool.getConnection();
		System.out.println("Available connections: " + pool.getFreeConnectionCount());
		pool.releaseConnection(con1);
		pool.releaseConnection(con2);
		pool.releaseConnection(con4);
		System.out.println("Available connections: " + pool.getFreeConnectionCount());
	}

}
