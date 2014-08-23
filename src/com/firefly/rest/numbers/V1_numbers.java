package com.firefly.rest.numbers;

import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.firefly.util.Picks;

@Path("/v1/numbers")
public class V1_numbers {

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnNumbers() throws Exception {
		return "<p>gotta love it don'cha</p>";
	}
	
	@Path("/{max}/{picks}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnNumbers(
					@PathParam("max") Integer max ,
					@PathParam("picks") Integer picks)
					throws Exception {

		JsonObject returnJson = null;
		String returnString = null;
		
		try {
		
			returnString = Picks.GetPicks(max, picks);
			
			//returnString = returnJson.toString();
		}
		catch( Exception ex) {
			ex.printStackTrace();
			return Response.status(500).entity("Server was not able to process yoru request").build();
		}
		
		return Response.ok(returnString).build();
	}
	
	@Path("/{max}/{picks}/{pmax}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnPBNumbers(
					@PathParam("max") Integer max ,
					@PathParam("picks") Integer picks,
					@PathParam("pmax") Integer pmax)
					throws Exception {

		JsonObject returnJson = null;
		String returnString = null;
		
		try {
		
			returnString = Picks.GetPicks(max, picks);
			
			returnString = returnString + ",PB:" + Picks.GetPicks(pmax, 1);
		}
		catch( Exception ex) {
			ex.printStackTrace();
			return Response.status(500).entity("Server was not able to process yoru request").build();
		}
		
		return Response.ok(returnString).build();
	}
}
