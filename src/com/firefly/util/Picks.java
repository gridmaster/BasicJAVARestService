package com.firefly.util;

import java.util.ArrayList;
import java.util.Random;

public class Picks {
	
    private static Random random = new Random();

    public static String GetPicks(Integer max, Integer picks, String faves) {
    	ArrayList<Integer> myPix = new ArrayList<Integer>();
    	
    	String[] favorites = faves.split(",");
    	Integer numFaves = 0;
    	
    	if(!faves.equals("")) {
    		for(Integer i=0; i< favorites.length; i++ ) {
    			myPix.add(Integer.parseInt(favorites[i]));
    		}
    		numFaves = favorites.length;
    	}    		
    	
    	for(Integer i=numFaves; i<picks; i++) {
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
}
