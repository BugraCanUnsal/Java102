package Insurance;

import java.util.Date;

public class HealthInsurance extends Insurance {

    private double insurancePrice;

    public HealthInsurance(String insuranceName, Date startEndDateOfInsurance) {
        super(insuranceName, startEndDateOfInsurance);

    }

    @Override
    public void calculate() {

    }

}
