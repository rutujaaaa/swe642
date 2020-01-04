//AUTHOR: Srivedaa Chinthalapani
//getters and setters of student db

package com.example.swe642;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {

    @Id
    private String stdid;
    private String stdname;
    private String stdadd;
    private String stdcity;
    private String stdstate;
    private String stdzip;
    private String stddate;
    private String stdtel;
    private String stdemail;
    private String stdurl;
    private String stdmonth;
    private String stdyear;
    private String stdradio;
    private String stdlike;
    private String stddata;
    
    public String getStdid() {
        return stdid;
    }

    public void setStdid(String stdid) {
        this.stdid = stdid;
    }

    public String getStdname() {
        return stdname;
    }

    public void setStdname(String stdname) {
        this.stdname = stdname;
    }
    
    public String getStdcity() {
        return stdcity;
    }

    public void setStdcity(String stdcity) {
        this.stdcity = stdcity;
    }
    public String getStdstate() {
        return stdstate;
    }

    public void setStdstate(String stdstate) {
        this.stdstate = stdstate;
    }
    public String getStdadd() {
        return stdadd;
    }

    public void setStdadd(String stdadd) {
        this.stdadd = stdadd;
    }
    public String getStdzip() {
        return stdzip;
    }

    public void setStdzip(String stdzip) {
        this.stdzip = stdzip;
    }
    public String getStdtel() {
        return stdtel;
    }

    public void setStdtel(String stdtel) {
        this.stdtel = stdtel;
    }
    public String getStddate() {
        return stddate;
    }

    public void setStddate(String stddate) {
        this.stddate = stddate;
    }
    public String getStdemail() {
        return stdemail;
    }

    public void setStdemail(String stdemail) {
        this.stdemail = stdemail;
    }
    public String getStdurl() {
        return stdurl;
    }

    public void setStdurl(String stdurl) {
        this.stdurl = stdurl;
    }
    public String getStdmonth() {
        return stdmonth;
    }

    public void setStdmonth(String stdmonth) {
        this.stdmonth = stdmonth;
    }
    public String getStdyear() {
        return stdyear;
    }

    public void setStdyear(String stdyear) {
        this.stdyear = stdyear;
    }
    
    public String getStdradio() {
        return stdradio;
    }

    public void setStdradio(String stdradio) {
        this.stdradio = stdradio;
    }
    
    public String getStdlike() {
        return stdlike;
    }

    public void setStdlike(String stdlike) {
        this.stdlike = stdlike;
    }
 
    
    public String getStddata() {
        return stddata;
    }

    public void setStddata(String stddata) {
        this.stddata = stddata;
    }

}