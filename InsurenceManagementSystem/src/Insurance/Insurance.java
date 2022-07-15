package Insurance;

import java.util.Date;

public abstract class Insurance {

    private String insuranceName;
    private double insurancePrice;
    private Date startEndDateOfInsurance;

    public Insurance(String insuranceName, Date startEndDateOfInsurance) {
        this.insuranceName = insuranceName;
        this.startEndDateOfInsurance = startEndDateOfInsurance;
    }

    public abstract void calculate();
}
