package com.firefly.util;

import java.util.ArrayList;
import java.util.Random;

import javax.json.Json;
import javax.json.JsonObject;

public class Picks {
	
    private static Random random = new Random();

    public static String GetPicks(Integer max, Integer picks) {
    	ArrayList<Integer> myPix = new ArrayList<Integer>();
    	
    	for(Integer i=0; i<picks; i++) {
    		Integer nInt = nextInt(1, max);
    		if ( myPix.indexOf(nInt) > -1)
    			i--;
    		else
    			myPix.add(nInt);
    	}
    	
    	String json = myPix.toString();
    	
    	return json;
    }
    
    private static int nextInt(int min, int max) {
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        return random.nextInt((max - min) + 1) + min;
    }
    
    public static JsonObject GetPicksxxx(Integer max, Integer picks) {
    	ArrayList<Integer> myPix = new ArrayList<Integer>();
    	
    	picks = 6;
    	
    	for(Integer i=0; i<picks; i++) {
    		Integer nInt = nextInt(1, max);
    		if ( myPix.indexOf(nInt) > -1)
    			i--;
    		else
    			myPix.add(nInt);
    	}
    	
    	JsonObject jo = Json.createObjectBuilder()
    			  .add("picks", Json.createArrayBuilder()
    			    .add(Json.createObjectBuilder()
    			      .add("first", myPix.get(0).toString())
    			      .add("second", myPix.get(1).toString())
    			      .add("third", myPix.get(2).toString())
    			      .add("forth", myPix.get(3).toString())
    			      .add("fifth", myPix.get(4).toString())
    			      .add("sixth", myPix.get(5).toString())))
    			  .build();
    	
    	return jo;
    }
    
}
