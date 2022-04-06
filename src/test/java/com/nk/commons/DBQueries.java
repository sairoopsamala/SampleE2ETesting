package com.nk.commons;

public class DBQueries {
	
	public static final String CREATE_LOCATIONS = "create table locations (LOCATION_ID decimal(4,0), STREET_ADDRESS varchar(40), POSTAL_CODE varchar(12),CITY varchar(30), COUNTRY_ID varchar(2))";
	public static final String INSERT_LOCATIONS = "insert into locations values('\"+locId+\"', '\"+streatAdd+\"', '\"+postalCode+\"', '\"+city+\"', '\"+countryId+\"')";

}
