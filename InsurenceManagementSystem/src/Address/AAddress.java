package Address;

public abstract class AAddress implements Address {

    private String streetName;
    private String city;
    private int blockNo;
    private String blockName;
    private int apartmentNo;
    private int postCode;
    private String country;

    public AAddress(String streetName, String city, int blockNo, String blockName, int apartmentNo, int postCode, String country) {
        this.streetName = streetName;
        this.city = city;
        this.blockNo = blockNo;
        this.blockName = blockName;
        this.apartmentNo = apartmentNo;
        this.postCode = postCode;
        this.country = country;
    }

    @Override
    public void printAddress() {
        System.out.println("printAddress tanimlanmadi!!!!!!!!!!!!!");
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getBlockNo() {
        return blockNo;
    }

    public void setBlockNo(int blockNo) {
        this.blockNo = blockNo;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public int getApartmentNo() {
        return apartmentNo;
    }

    public void setApartmentNo(int apartmentNo) {
        this.apartmentNo = apartmentNo;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
