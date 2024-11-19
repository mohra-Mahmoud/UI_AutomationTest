package CartFunctionality;

import org.testng.annotations.Test;

public class CartTestResult extends CartTestImpelementation {
    @Test
    public void testcaseone() throws InterruptedException {
        ADDSearchedProductToCart();
        VerifyThatProductAddedToCart();



}}
