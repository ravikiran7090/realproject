package PRACTICE;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.generalUtility.BaseClass;
import com.crm.comcast.objectrepositionlib.Home;
@Listeners(com.comcast.generalUtility.ListImp.class)
public class Sampletest1 extends BaseClass {
	@Test()
	public void Org(){
	/* step3: navigate to org*/
	Home hp=new Home(driver);
	hp.getOrganizationLink().click();
	Assert.assertEquals("a", "b");
	}

}
