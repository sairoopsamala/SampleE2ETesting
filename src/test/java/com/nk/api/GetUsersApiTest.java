package com.nk.api;

import org.testng.annotations.Test;

import com.nk.service.ApiUtils;

public class GetUsersApiTest {

	@Test
	public static void validateUsersDetails() {
		ApiUtils.verifyUsersApi();
	}
	
}
