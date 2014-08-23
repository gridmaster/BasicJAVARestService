package com.firefly.rest.symbols;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;

import com.firefly.dao.Schema101Club;

@Path("/v2/symbols")
public class V2_symbols {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnSymbolByName(
			@QueryParam("symbol") String symbol)
					throws Exception {

		String returnString = null;
		JSONArray json = new JSONArray();
		
		try {
			
			if(symbol == null) {
				return Response.status(400).entity("Error: please specify a symbol name for this search").build();
			}
			
			Schema101Club dao = new Schema101Club();
			
			json = dao.queryReturnSymbolName(symbol);
			returnString = json.toString();
		}
		catch( Exception ex) {
			ex.printStackTrace();
			return Response.status(500).entity("Server was not able to process yoru request").build();
		}
		
		return Response.ok(returnString).build();
	}
	
	@Path("/{symbol}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnSymbol(
			@PathParam("symbol") String symbol)
					throws Exception {

		String returnString = null;
		JSONArray json = new JSONArray();
		
		try {
			
			if(symbol == null) {
				return Response.status(400).entity("Error: please specify a symbol name for this search").build();
			}
			
			Schema101Club dao = new Schema101Club();
			
			json = dao.queryReturnSymbolName(symbol);
			returnString = json.toString();
		}
		catch( Exception ex) {
			ex.printStackTrace();
			return Response.status(500).entity("Server was not able to process yoru request").build();
		}
		
		return Response.ok(returnString).build();
	}

	/*
	@Path("/{max}/{picks}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnSymbol(
			@PathParam("max") int max,
			@PathParam("picks") int picks)
					throws Exception {

		String returnString = null;
		JSONArray json = new JSONArray();
		
		try {
						
			json = dao.queryReturnSymbolName(symbol);
			returnString = json.toString();
		}
		catch( Exception ex) {
			ex.printStackTrace();
			return Response.status(500).entity("Server was not able to process yoru request").build();
		}
		
		return Response.ok(returnString).build();
	}
	*/
	/*
	Random r = new Random();
	int i = r.nextInt()
*/
}
