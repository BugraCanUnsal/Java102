package Address;


import User.User;

public class AddressManager {

    public static void addBusinessAddress(User user, BusinessAddress businessAddress){
        user.setAddresses(businessAddress);
    }
    public static void addHomeAddress(User user, HomeAddress homeAddress){
        user.setAddresses(homeAddress);
    }

}
