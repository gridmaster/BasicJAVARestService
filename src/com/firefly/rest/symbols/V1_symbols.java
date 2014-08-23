package com.firefly.rest.symbols;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;

import com.firefly.dao.MS101Club;
import com.firefly.util.*;

@Path("/v1/symbols")
public class V1_symbols {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnAllSymbols() throws Exception {
		
		PreparedStatement query = null;
		Connection conn = null;
		String returnString = null;
		Response rb = null;
		
		try {
			conn = MS101Club.MSSQL101ClubConn().getConnection();
			query = conn.prepareStatement("select top 5 * from TickerSymbols");
			
			ResultSet rs = query.executeQuery();
			
			ToJSON converter = new ToJSON();
			JSONArray json = new JSONArray();
			
			json = converter.toJSONArray(rs);
			query.close();
			
			returnString = json.toString();
			rb = Response.ok(returnString).build();
		}
		catch( Exception ex) {
			ex.printStackTrace();
		}
		finally {
			if( conn != null) conn.close();
		}
		
		return rb;
	}
}
