package model.user;

public class Address {
    private String street;
    private String flatNo;
    private String zipCode;
    private String city;
    private String country;

    public Address(String street, String flatNo, String zipCode, String city, String country) {
        this.street = street;
        this.flatNo = flatNo;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
    }

    public Address() {
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return street + " " + flatNo + ", " + zipCode + " " + city + ", " + country;
    }
}
