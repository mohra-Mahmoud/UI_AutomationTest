package SearchTest;

import MainMethods.MainMethods;
import org.testng.annotations.Test;

import static SearchTest.searchFunctionality.searchForProductByName;

public class testRun extends MainMethods {
    @Test
    public void SearchForExistingItem(){
        openBrowser();
        searchForProductByName() ;


    }

}
