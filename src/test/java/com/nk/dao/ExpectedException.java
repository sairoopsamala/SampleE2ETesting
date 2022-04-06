package com.nk.dao;

import org.testng.annotations.Test;

@Test(expectedExceptions=NumberFormatException.class)
public class ExpectedException {

	String x = "100A";
	int i = Integer.parseInt(x);
	
}
