package com.revature.project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("DBUtils test")
public class CustomerDBUtilsTest {

	CustomerDBUtils instance;
	
	@BeforeEach
	public void beforeEachTest() {
		this.instance = new CustomerDBUtils();
	}
	
	@Tag("DB")
	@Test
	public void testwithdrawCustomer() throws Exception {
		Assertions.assertEquals(-1, this.instance.withdrawAccount(1,1201));
	}
	
	
	
}
