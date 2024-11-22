package com.example.ooplabtaskgui;
class Person {
    private String name;
    private String fatherName;
    private String cnic;
    private String dob;
    private String gender;
    private String city;

    public Person(String name, String fatherName, String cnic, String dob, String gender, String city) {
        this.name = name;
        this.fatherName = fatherName;
        this.cnic = cnic;
        this.dob = dob;
        this.gender = gender;
        this.city = city;
    }
    @Override
    public String toString() {
        return "Person{" +
                "Name='" + name + '\'' +
                ", FatherName='" + fatherName + '\'' +
                ", CNIC='" + cnic + '\'' +
                ", DOB='" + dob + '\'' +
                ", Gender='" + gender + '\'' +
                ", City='" + city + '\'' +
                '}';
    }
}
