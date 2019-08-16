package br.com.jvcm.storepreference.dto;

public class ClientDTO {
    private Integer id;
    private String name;
    private int age;
    private String bornData;
    private String address;
    private String city;
    private String federationUnit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBornData() {
        return bornData;
    }

    public void setBornData(String bornData) {
        this.bornData = bornData;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFederationUnit() {
        return federationUnit;
    }

    public void setFederationUnit(String federationUnit) {
        this.federationUnit = federationUnit;
    }

    public ClientDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
