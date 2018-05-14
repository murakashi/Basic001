import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBAccess {

	String url = "jdbc:postgresql://localhost:5432/kashi";
	String user = "postgres";
	String pass = "kashi1203";
	String sql;

	Connection con = null;

	public DBAccess() {
		try {

		Class.forName("org.postgresql.Driver");
		//コネクションを生成
		con = DriverManager.getConnection(url, user, pass);

		//コネクションに対するステートメントを生成
		//PreparedStatement ps = con.prepareStatement(sql);

		}catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/******************社員IDでセレクトする（IDと名前だけ）******/
	public ArrayList<String[]> select1(String w){

		ArrayList<String[]> list = new ArrayList<String[]>();

		try {
			sql = "select * from syain where s_id = '"+ w +"'";

			Statement stms = con.createStatement();

			ResultSet rs = stms.executeQuery(sql);

			while (rs.next()) {
				String[] arr = new String[2];
				arr[0] = rs.getString("s_id");
				arr[1] = rs.getString("s_name");
				list.add(arr);
			}
			rs.close();
			stms.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		  }
		return list;
	}

	/******************社員IDでセレクトする（3つ全部）******/
	public ArrayList<String[]> select2(String w){

		ArrayList<String[]> list = new ArrayList<String[]>();

		try {
			sql = "select * from syain where s_id = '"+ w +"'";

			Statement stms = con.createStatement();

			ResultSet rs = stms.executeQuery(sql);

			while (rs.next()) {
				String[] arr = new String[3];
				arr[0] = rs.getString("s_id");
				arr[1] = rs.getString("s_name");
				arr[2] = rs.getString("d_id");
				list.add(arr);
			}
			rs.close();
			stms.close();
			con.close();
		} catch (Exception e) {
			e.getMessage();
		  }
		return list;
	}


}
