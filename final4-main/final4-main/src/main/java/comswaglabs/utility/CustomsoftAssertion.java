package comswaglabs.utility;

import org.testng.asserts.SoftAssert;

public class CustomsoftAssertion  extends SoftAssert {

      public static CustomsoftAssertion  SoftAssertion= new CustomsoftAssertion() ;
      public static void CustomAssertAll(){
          try {

              SoftAssertion.assertAll("custom soft assertion");

          }
          catch (Exception e) {
              System.out.println("custom soft assertion failed");
          }


    }
}

