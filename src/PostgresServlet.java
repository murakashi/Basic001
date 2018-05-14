

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostgresServlet
 */
@WebServlet("/postgres")
public class PostgresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostgresServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "jdbc:postgresql://localhost:5432/kashi";
		String user = "postgres";
		String pass = "kashi1203";
		String sql = "select * from book_table where id between ? and ? order by page_cnt";

		try {
			Class.forName("org.postgresql.Driver");
		//コネクションを生成
		java.sql.Connection con = DriverManager.getConnection(url, user, pass);

		//コネクションに対するステートメントを生成
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setObject(1, "0001");
		ps.setObject(2, "0004");

		ResultSet rs = ps.executeQuery();

		ResultSetMetaData rsm = rs.getMetaData();

		while(rs.next()) {
			for(int i=1;i<=rsm.getColumnCount();i++) {
				String columnName = rsm.getColumnName(i);
				String value = rs.getString(i);
				System.out.printf("%s[%s], ", columnName,value);
			}
			System.out.println();
		}

		ps.close();
		rs.close();
		con.close();
		}catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
