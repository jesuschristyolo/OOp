package seminar4.model;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)

public class Teacher extends User implements Comparable<Teacher> {
    private String subject;
    private String department; //кафедра
    private Double salary;
    public boolean distribution;

    public Teacher(Long id, String status, String fullName, Integer age, String phoneNumber) {

        super(id);
        super.status =status;
        super.fullName=fullName;
        super.age=age;
        super.phoneNumber=phoneNumber;
        this.distribution=false;
    }

    @Override
    public int compareTo(Teacher o) {
        return getFullName().compareTo(o.getFullName());
    }

    @Override
    public String toString() {
        return String.format("%s\t%s\t%s\t%s\t%s\t%s\t", getId(), getFullName(), getAge(), getPhoneNumber(),
                isDistribution(), getStatus());
    }
}
