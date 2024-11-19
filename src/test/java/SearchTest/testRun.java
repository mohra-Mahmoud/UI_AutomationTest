package SearchTest;

import SearchTest.VerifySearchFunctionality;
import org.testng.annotations.Test;

public class testRun extends VerifySearchFunctionality {
    @Test
    public void SearchForExistingItem(){
        openBrowser();
        MainPage();
        searchForProductByName();


    }

}
