package com.example.mymemo;

import java.io.Serializable;

public class Memo implements Serializable {
    String maintext;//메모
    String subtext;//날짜
    int isdone;//완료
    //int seq;

    /*public Memo(int seq,String maintext,String subtext,int isdone){
        this.seq=seq;
        this.maintext=maintext;
        this.subtext=subtext;
        this.isdone=isdone;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }
*/
    public Memo(String maintext, String subtext, int isdone){
        this.maintext=maintext;
        this.subtext=subtext;
        this.isdone=isdone;
    }

    public int getIsdone() {
        return isdone;
    }

    public void setIsdone(int isdone) {
        this.isdone = isdone;
    }

    public String getMaintext() {
        return maintext;
    }

    public void setMaintext(String maintext) {
        this.maintext = maintext;
    }

    public String getSubtext() {
        return subtext;
    }

    public void setSubtext(String subtext) {
        this.subtext = subtext;
    }

}
