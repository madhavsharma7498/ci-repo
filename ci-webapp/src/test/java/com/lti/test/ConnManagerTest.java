package com.lti.test;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.junit.Test;

import com.lti.dao.util.ConnManager;

public class ConnManagerTest {
	
	@Test
	public void testConn() {
		Connection conn = ConnManager.connect();
		assertNotNull(conn);
	}
}
