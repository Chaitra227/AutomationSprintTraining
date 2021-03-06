package regression;

import org.testng.annotations.Test;

import base.InitializeBrowser;
import pages.CartPage;
import pages.ContractTerminationPage;
import pages.DeliveryPage;
import pages.LoginPage;
import pages.PTNSelectorPage;
import pages.PaymentPage;
import pages.PhoneDetailPage;
import pages.PhonePage;
import pages.ProtectionPage;
import utility.Test_POJO;

public class JodUpgradeTurnIn extends InitializeBrowser {
	
	@Test(dataProvider="dataFile")
	public void jodUpgradeTurn(Test_POJO test) {
		LoginPage login=new LoginPage(driver);
		login.signClick();
		login.login(test.getUsername(), test.getPassword());
		
		PhonePage phone=new PhonePage(driver);
		phone.selectUPG();
		
		PTNSelectorPage ptnselector=new PTNSelectorPage(driver);
		ptnselector.pageTitleCheck();
		ptnselector.sendPTNInSearchBar(test.getPTN());
		phone.selectiPh12Pro();
		
		ContractTerminationPage closeoutOption=new ContractTerminationPage(driver);
		closeoutOption.selectLeaseTurnIn();
		closeoutOption.acceptTurnInTerms();
		
		PhoneDetailPage pdp=new PhoneDetailPage(driver);
		pdp.selectIBContract();
		pdp.clickButtonInPDP();
		
		ProtectionPage protect=new ProtectionPage(driver);
		protect.UPGAddtoCartBtn();
		
		CartPage cart=new CartPage(driver);
//		cart.cartTitleCheck();
		cart.checkoutClick();
		
		DeliveryPage delivery=new DeliveryPage(driver);
		delivery.overnightShipping();
		
		PaymentPage payment=new PaymentPage(driver);		
		payment.acceptTermswithDeviceAgree();
		payment.acceptTurnInTerms();
		payment.cardDetails(test.getcardName(), test.getcardNumber(), test.getexpDate(), test.getCVV());

}

}
