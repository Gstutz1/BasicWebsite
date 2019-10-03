package springxml.beans;

import springxml.services.DataVerification;

import java.util.*;

public class Figure {
    private String name;
    private String info;
    private DataVerification dataVerification;

    private List<Section> sections;

    public Figure() {
        name = "";
        info = "";
        sections = new ArrayList<>();
        dataVerification = null;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public List<Section> getSections() {
        return sections;
    }

    public DataVerification getDataVerification() {
        return dataVerification;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public void setDataVerification(DataVerification dataVerification) {
        this.dataVerification = dataVerification;
    }
}
