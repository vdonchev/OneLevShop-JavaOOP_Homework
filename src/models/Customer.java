package models;

public class Customer {
    private String name;
    private int age;
    private double ballance;

    public Customer(String name, int age, double ballance) {
        this.setName(name);
        this.setAge(age);
        this.setBallance(ballance);
    }

    public double getBallance() {
        return ballance;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        if(name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name can't be blank");
        }

        this.name = name;
    }

    public void setAge(int age) {
        if(age <= 0 || age > 120) {
            throw new IllegalArgumentException("Age should be in range [1..120]");
        }

        this.age = age;
    }

    public void setBallance(double ballance) {
        if(ballance < 0) {
            throw new IllegalArgumentException("Ballance should be positiove floating point number");
        }

        this.ballance = ballance;
    }
}