package com.offcn.pojo;

import java.io.Serializable;

public class Student implements Serializable {

    private int sid ;
    private String sname;

    private String sage

            ;

    public Student(int sid, String sname, String sage) {
        this.sid = sid;
        this.sname = sname;
        this.sage = sage;
    }

    public Student() {
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSage() {
        return sage;
    }

    public void setSage(String sage) {
        this.sage = sage;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", sage='" + sage + '\'' +
                '}';
    }
}
