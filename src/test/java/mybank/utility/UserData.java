package mybank.utility;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class UserData {

	@DataProvider(name = "Dataset")
	public Object[][] Logindemo1(Method m) {

		Object[][] testdata = new Object[][] {

				{ "abc@gmail.com", "1234" }
		};
		return testdata;
	}
}
