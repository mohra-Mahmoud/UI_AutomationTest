package MainMethods;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;

public class fakedata {
    public static Name fakeName() {
        Faker fakename = new Faker();
        return fakename.name();
    }


    public static String fakeemail() {
        Faker fakeemail = new Faker();
        return fakeemail.name().firstName() + "@gamile.com";
    }

    public static String fakemobile() {
        Faker fakemobile = new Faker();
        return fakemobile.number().digits(9);
    }
    public static String fakepassword() {
        Faker fakpass = new Faker();
        return fakpass.number().digits(9);
    }
}
