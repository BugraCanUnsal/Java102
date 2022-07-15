package Insurance;

import Insurance.Insurance;

import java.util.Date;

public class ResidenceInsurance extends Insurance {

    public ResidenceInsurance(String insuranceName, Date startEndDateOfInsurance) {
        super(insuranceName, startEndDateOfInsurance);
    }

    @Override
    public void calculate() {

    }
}
