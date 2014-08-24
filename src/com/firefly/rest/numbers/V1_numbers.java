package com.firefly.rest.numbers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
					@PathParam("picks") Integer picks,
					@QueryParam("faves") String faves)
					throws Exception {

		String returnString = null;
		
		try {			
			if (faves == null) faves = "";
			returnString = Picks.GetPicks(max, picks, faves);
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
					@PathParam("pmax") Integer pmax,
					@QueryParam("faves") String faves,
					@QueryParam("pbFave") String pbFave)
					throws Exception {

		String returnString = null;
		
		try {
		
			if (faves == null) faves = "";
			returnString = Picks.GetPicks(max, picks, faves);
			
			if (pbFave == null) pbFave = "";
			returnString = returnString + ",PB:" + Picks.GetPicks(pmax, 1, pbFave);
		}
		catch( Exception ex) {
			ex.printStackTrace();
			return Response.status(500).entity("Server was not able to process yoru request").build();
		}
		
		return Response.ok(returnString).build();
	}
}
