package springxml.beans;

public class Section {
    private int id;
    private String header;
    private String body;

    public Section() {
        id = 0;
        header = "";
        body = "";
    }

    public int getId() {
        return id;
    }

    public String getHeader() {
        return header;
    }

    public String getBody() {
        return body;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
