package User;

import Insurance.Insurance;

import java.util.ArrayList;

public class Account {

    private User user;

    private ArrayList<Insurance> insuranceList = new ArrayList<>();

    public Account(User user) {
        this.user = user;
    }

    public final void showUserInfo(){
        System.out.println("Kullanici bilgileri bastirildi...");
    }

    public ArrayList<Insurance> getInsuranceList() {
        return insuranceList;
    }

    public void setInsuranceList(ArrayList<Insurance> insuranceList) {
        this.insuranceList = insuranceList;
    }
}
