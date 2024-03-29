package hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "section")
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "section_id")
    private int id;

    @Column(name = "header")
    private String header;

    @Column(name = "body")
    private String body;

    // One figure can have many sections while one section has one figure
    // Did not include CascadeType.Remove because figures can exist without sections
    // Uses the default fetching, figures connected to sections must be known
    @ManyToOne(cascade =
                    {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JoinColumn(name = "figure_id")
    private Figure figure;

    public Section() {
        // Need to have a default constructor
    }

    public Section(String header, String body)
    {
        this.header = header;
        this.body = body;
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", header='" + header + '\'' +
                ", body='" + body + '\'' +
                ", figure=" + figure +
                '}';
    }
}
