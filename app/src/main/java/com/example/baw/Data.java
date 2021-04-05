package com.example.baw;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class Data {
    int srNo;
    String name, id;
    float marks;
    FileReader fr;
    BufferedReader br;
    final String FILENAME = "data.txt";

    public Data() {

    }

    public Data(int srNo, String name, String id, float marks, FileReader fr, BufferedReader br) {
        this.srNo = srNo;
        this.name = name;
        this.id = id;
        this.marks = marks;
        this.fr = fr;
        this.br = br;
    }

    public int getSrNo() {
        return srNo;
    }

    public void setSrNo(int srNo) {
        this.srNo = srNo;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMarks() {
        return marks;
    }

    public void setMarks(float marks) {
        this.marks = marks;
    }

    public FileReader getFr() {
        return fr;
    }

    public void setFr(FileReader fr) {
        this.fr = fr;
    }

    public BufferedReader getBr() {
        return br;
    }

    public void setBr(BufferedReader br) {
        this.br = br;
    }

    public String getFILENAME() {
        return FILENAME;
    }

    @Override
    public String toString() {
        return "Data{" +
                "srNo=" + srNo +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                ", fr=" + fr +
                ", br=" + br +
                ", FILENAME='" + FILENAME + '\'' +
                '}';
    }

    public void openForReading() throws FileNotFoundException {
        fr = new FileReader(FILENAME);
        br = new BufferedReader(fr);
    }
    public void closedForReading() throws IOException {
        fr.close();
        br.close();
    }
}
