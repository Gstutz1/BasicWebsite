package hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "figure")
public class Figure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "figure_id")
    private int id;

    @Column(name = "figure_nm")
    private String name;

    @Column(name = "info")
    private String info;

    @OneToMany(mappedBy = "figure", cascade = CascadeType.ALL)
    private List<Section> sections;

    public Figure() {
        // Need to have a default constructor
    }

    public Figure(String name, String info) {
        this.name = name;
        this.info = info;
    }

    public void addSection(Section section) {
        if (sections == null) {
            sections = new ArrayList<>();
        }
        sections.add(section);
        section.setFigure(this);
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Figure{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
