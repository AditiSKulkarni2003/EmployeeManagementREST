package com.employee.details.model;

import javax.persistence.*;



public class Address {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
    private int addressId;
  //  @Column(name = "building_name")
    private String buildingName;
 //   @Column(name = "city")
    private String city;
//    @Column(name = "pin_code")
    private String pinCode;
 //   @Column(name = "mob_no")
    private String mobNo;

    public Address() {}


    public Address(int addressId, String buildingName, String city, String pinCode, String mobNo) {
        this.addressId = addressId;
        this.buildingName = buildingName;
        this.city = city;
        this.pinCode = pinCode;
        this.mobNo = mobNo;
    }


    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getMobNo() {
        return mobNo;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", buildingName='" + buildingName + '\'' +
                ", city='" + city + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", mobNo='" + mobNo + '\'' +
                '}';
    }



}
