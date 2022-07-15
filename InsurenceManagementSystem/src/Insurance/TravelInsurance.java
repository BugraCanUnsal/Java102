package Insurance;

import Insurance.Insurance;

import java.util.Date;

public class TravelInsurance extends Insurance {
    public TravelInsurance(String insuranceName, Date startEndDateOfInsurance) {
        super(insuranceName, startEndDateOfInsurance);
    }

    @Override
    public void calculate() {

    }
}
