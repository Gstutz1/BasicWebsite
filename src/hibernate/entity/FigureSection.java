package hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "figure_section")
public class FigureSection {
    @Id
    @Column(name = "figure_name")
    private String figureName;

    @Id
    @Column(name = "section_id")
    private int sectionId;

    public  FigureSection()
    {
        // Need to have a default constructor
    }

    public FigureSection(String figureName, int sectionId) {
        this.figureName = figureName;
        this.sectionId = sectionId;
    }

    public String getFigureName() {
        return figureName;
    }

    public void setFigureName(String figureName) {
        this.figureName = figureName;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    @Override
    public String toString() {
        return "FigureSection{" +
                "figureName='" + figureName + '\'' +
                ", sectionId=" + sectionId +
                '}';
    }
}
