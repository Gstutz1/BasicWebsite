package jdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "jdbc.SearchServlet", urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    private final String PATH = "/WEB-INF/lib/norse";
    private final String USER = "gabe";
    private final String PW = "gabe";
    private final String DRIVER = "jdbc:derby:";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        try {
            String searchTerm = request.getParameter("searchTerm");

            // Load the driver
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            // Find the absolute path of the database folder
            String absPath = getServletContext().getRealPath(PATH);

            StringBuilder sql = new StringBuilder("SELECT figure.figure_nm, figure.info, section.header, section.body");
            sql.append(" FROM figure_section, figure, section");
            sql.append(" WHERE figure_section.figure_nm = figure.figure_nm");
            sql.append(" AND figure_section.section_id = section.section_id");
            sql.append(" AND figure.figure_nm = ?");
            sql.append(" ORDER BY figure.figure_nm");

            conn = DriverManager.getConnection(DRIVER + absPath, USER, PW);

            pstmt = conn.prepareStatement(sql.toString());

            pstmt.setString(1, searchTerm);

            rset = pstmt.executeQuery();

            StringBuilder output = new StringBuilder();

            output.append("<html><body><ul>");

            while (rset.next()) {
                String name = rset.getString(1);
                String info = rset.getString(2);
                String header = rset.getString(3);
                String body = rset.getString(4);

                output.append("<p>").append(name + "<br>" + info + "<br>" + header + "<br>" + body).append("</p>");
            }

            output.append("</ul></body></html>");


            response.getWriter().print(output.toString());

        }
        catch (SQLException | ClassNotFoundException e) {
            response.getWriter().print(e.getMessage());
            e.printStackTrace();
        }
        finally {
            if (rset != null) {
                try {
                    rset.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
