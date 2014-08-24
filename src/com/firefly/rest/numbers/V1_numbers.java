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
					@QueryParam("faves") String faves,
					@QueryParam("tix") Integer tix)
					throws Exception {

		String returnString = "";
		
		try {
			if (tix == null ) tix = 1;
			if (faves == null) faves = "";
			
			while( tix-- > 0 ) {
				returnString += Picks.GetPicks(max, picks, faves) + "\n";
			}
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
					@QueryParam("pbFave") String pbFave,
					@QueryParam("tix") Integer tix)
					throws Exception {

		String returnString = "";
		
		try {
		
			if (tix == null ) tix = 1;
			if (faves == null) faves = "";
			if (pbFave == null) pbFave = "";
			
			while( tix-- > 0 ) {
				returnString += Picks.GetPicks(max, picks, faves);
				returnString += ",PB:" + Picks.GetPicks(pmax, 1, pbFave) + "\n";
			}
		}
		catch( Exception ex) {
			ex.printStackTrace();
			return Response.status(500).entity("Server was not able to process yoru request").build();
		}
		
		return Response.ok(returnString).build();
	}
}
