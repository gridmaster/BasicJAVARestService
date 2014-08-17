package com.firefly.dao;

import javax.naming.*;
import javax.sql.*;

public class MS101Club {

	private static DataSource MSSql101Club = null;
	private static Context context = null;
	
	public static DataSource MSSQL101ClubConn() throws Exception {
		
		if( MSSql101Club != null )
			return MSSql101Club;
		
		try {
			if( context == null) {
				context = new InitialContext();
			}
			
			MSSql101Club = (DataSource) context.lookup("MSMStrategy");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return MSSql101Club;
		
	}
}
