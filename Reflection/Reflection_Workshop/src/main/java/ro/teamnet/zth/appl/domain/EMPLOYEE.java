package ro.teamnet.zth.appl.domain;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;

import java.util.Date;

/**
 * Created by user on 7/7/2016.
 */
public class EMPLOYEE {
    @Id(name = "emplooyee_id")
    private Long id;
    @Column(name = "first_name")
    private String  first_name;
    @Column(name = "last_name")
    private String  last_name;
    @Column(name = "email")
    private String  email;
    @Column(name = "phone_number")
    private String  phone_number;
    @Column(name = "hire_date")
    private Date    hire_date;
    @Column(name = "salary")
    private Long    salary;
    @Column(name = "commission_pct")
    private Long    commission_pct;
    @Column(name = "manager_id")
    private Long    manager_id;
    @Column(name = "deparment_id")
    private Long    deparment_id;

    public Long getDeparment_id() {
        return deparment_id;
    }

    public void setDeparment_id(Long deparment_id) {
        this.deparment_id = deparment_id;
    }

    public Long getManager_id() {
        return manager_id;
    }

    public void setManager_id(Long manager_id) {
        this.manager_id = manager_id;
    }

    public Long getCommission_pct() {
        return commission_pct;
    }

    public void setCommission_pct(Long commission_pct) {
        this.commission_pct = commission_pct;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "EMPLOYEE{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", hire_date=" + hire_date +
                ", salary=" + salary +
                ", commission_pct=" + commission_pct +
                ", manager_id=" + manager_id +
                ", deparment_id=" + deparment_id +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

