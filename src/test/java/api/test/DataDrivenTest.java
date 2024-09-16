package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataDrivenTest 
{
	@Test(priority=1,dataProvider = "AllData",dataProviderClass = DataProviders.class)
	public void testPostUser(String userId,String userName,String firstName,String lastName, String email,String pwd,String phone) 
	{
		User payload=new User();
		
		payload.setId(Integer.parseInt(userId));
		payload.setUsername(userName);
		payload.setFirstName(firstName);
		payload.setLastName(lastName);
		payload.setEmail(email);
		payload.setPassword(pwd);
		payload.setPhone(phone);
		
		Response response=UserEndPoints.createUser(payload);
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test
	public void testDeleteUserByName(String userName) 
	{
		Response response=UserEndPoints.deleteUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
