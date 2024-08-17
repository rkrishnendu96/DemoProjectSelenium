package dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name="invalidUserCredentials")  // make it parameterized
	public Object[][] verifyUserCredentialData() {
		Object[][] data=new Object[3][2]; // create object array
		data[0][0]="rkrishnendu96@gmail.com";
		data[0][1]="12488#58";
		
		data[1][0]="rkrishgj@fgm.com";
		data[1][1]="123456789";
		
		data[2][0]="rkrishgj@fgm.com";
		data[2][1]="12587666";
		return data; // using in other files so returns
	}

}
