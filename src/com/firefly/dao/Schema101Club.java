package com.firefly.dao;

import java.sql.*;
import org.codehaus.jettison.json.JSONArray;
import com.firefly.util.ToJSON;

public class Schema101Club extends MS101Club {
	
	public JSONArray queryReturnSymbolName(String symbol) throws Exception {
		
		PreparedStatement query = null;
		Connection conn = null;
		
		ToJSON converter = new ToJSON();
		JSONArray json = new JSONArray();
				
		try {
			conn = MSSQLSymbolConnection();
			query = conn.prepareStatement("SELECT Id, Symbol, Name, ExchangeId, ExchangeName, "
					+ "Industry, Sector, Date, TimeStamp, Deleted, ValidData, KeyStat " 
					+ "FROM TickerSymbols "
					+ "WHERE UPPER(Symbol) = ?");
			
			query.setString(1, symbol.toUpperCase());
			ResultSet rs = query.executeQuery();
			
			json = converter.toJSONArray(rs);
			query.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return json;
		}
		finally {
			if( conn != null) conn.close();
		}
		
		return json;
	}
}
