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

    public Section()
    {
        // Need to have a default constructor
    }

    public Section(String header, String body)
    {
        this.header = header;
        this.body = body;
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
                '}';
    }
}
