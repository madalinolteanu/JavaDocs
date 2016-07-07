package ro.teamnet.zth.appl.domain;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;

/**
 * Created by user on 7/7/2016.
 */
public class JOB {
    @Id(name = "job_id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "min_salary")
    private Long min_salary;
    @Column(name = "max_salary")
    private Long max_salary;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMin_salary() {
        return min_salary;
    }

    public void setMin_salary(Long min_salary) {
        this.min_salary = min_salary;
    }

    public Long getMax_salary() {
        return max_salary;
    }

    public void setMax_salary(Long max_salary) {
        this.max_salary = max_salary;
    }

    @Override
    public String toString() {
        return "JOB{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", min_salary=" + min_salary +
                ", max_salary=" + max_salary +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
