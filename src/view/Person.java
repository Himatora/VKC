package view;

public class Person {

    private final int gender;
    private final String name;
    private final String lastName;
    private final String fatherName;
    private final String registration;
    private final String region;
    private final String term;
    private final String age;
    private final String disability;
    private final String employment;
    private final String typeEmployment;
    private final String workExperience;
    private final String city;

    public int getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getRegistration() {
        return registration;
    }

    public String getRegion() {
        return region;
    }

    public String getTerm() {
        return term;
    }

    public String getAge() {
        return age;
    }

    public String getDisability() {
        return disability;
    }

    public String getEmployment() {
        return employment;
    }

    public String getTypeEmployment() {
        return typeEmployment;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public String getCity() {
        return city;
    }

    public Person(int gender, String name, String lastName, String fatherName, String registration, String region, String term, String age, String disability, String employment, String typeEmployment, String workExperience, String city) {
        this.gender = gender;
        this.name = name;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.registration = registration;
        this.region = region;
        this.term = term;
        this.age = age;
        this.disability = disability;
        this.employment = employment;
        this.typeEmployment = typeEmployment;
        this.workExperience = workExperience;
        this.city = city;
    }
}
