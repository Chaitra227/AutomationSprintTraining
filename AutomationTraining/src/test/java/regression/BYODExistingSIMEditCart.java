package regression;

import org.testng.annotations.Test;

import base.InitializeBrowser;
import pages.BYODEditCartPage;
import pages.BYODPage;
import pages.CartPage;
import pages.LoginPage;
import pages.NumberSetupPage;
import pages.PaymentPage;
import pages.PhonePage;
import pages.PlanPage;
import pages.ProtectionPage;

public class BYODExistingSIMEditCart extends InitializeBrowser {
	
	@Test(dataProvider="jumpUpgradeData")
	public void editCartBYOD(String uname, String pwd, String PTN, String cardname, String cardnumber, String Expdate, String CVV) {
		LoginPage login=new LoginPage(driver);
		login.signClick();
		login.login(uname,pwd);
		
		PhonePage phone=new PhonePage(driver);
		phone.selectBYOD();
		
		BYODPage byod=new BYODPage(driver);
		byod.closePopup();
		byod.passESN();
		byod.existingSIMSelected();
		byod.clickContinueBtn();
		
		ProtectionPage protect=new ProtectionPage(driver);
		protect.BYODContinueButton();
		
		PlanPage plan=new PlanPage(driver) ;
		plan.planSelection();
		plan.addtoCartBYOD();
		
		CartPage cart=new CartPage(driver);
		cart.cartTitleCheck();
		
		BYODEditCartPage editCart=new BYODEditCartPage(driver);
		editCart.editCart();
		editCart.planSelect();
		editCart.updatePlan();
		
		}

}
