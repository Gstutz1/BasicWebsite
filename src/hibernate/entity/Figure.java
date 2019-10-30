package hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "figure")
public class Figure {
    @Id
    @Column(name = "figure_nm")
    private String name;

    @Column(name = "info")
    private String info;

    public Figure()
    {
        // Need to have a default constructor
    }

    public Figure(String name, String info) {
        this.name = name;
        this.info = info;
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
                "name='" + name + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
