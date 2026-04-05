package org.telusko.model;

import jakarta.persistence.*;



@Entity
@Table(name = "StudentInformation")
public class Student {
    @Id
    @GeneratedValue(generator = "my_seq", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "my_seq", sequenceName = "my_OwnSequence", initialValue = 100,allocationSize = 1)
    @Column(name = "SID")
    private Integer sid;


    @Column(name = "SNAME")
    private String sname;



    @Column(name = "SCITY")
    private String scity;

    public Student(){
        System.out.println("Zero Param Costructor for Hibernate");
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getScity() {
        return scity;
    }

    public void setScity(String scity) {
        this.scity = scity;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", scity='" + scity + '\'' +
                '}';
    }
}
