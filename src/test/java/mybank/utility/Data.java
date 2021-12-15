package mybank.utility;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class Data {

	@DataProvider(name = "Dataset")
	public Object[][] Logindemo1(Method m) {

		Object[][] testdata = new Object[][] {

				{ "admin@gmail.com", "admin123" },
				{" "," "}

		};
		return testdata;
	}
}
