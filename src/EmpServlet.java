

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpServlet
 */
@WebServlet("/emp")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String [][] emp = {{"1","佐藤","システム部","11年"},
						   {"2","伊藤","営業部","10年"},
						   {"3","田中","総務部","13年"},
						   {"4","斎藤","経理部","8年"},
						   {"5","鈴木","営業部","11年"},
						   {"6","山田","システム部","9年"},
						   {"7","川田","管理部","10年"}};

		String str = request.getParameter("no");

		ArrayList<String[]> list = new ArrayList<String[]>();

		String[] arr = new String[4];

		//社員番号未入力の場合
		if(str.equals("")) {
			for(int i=0;i<emp.length;i++) {
				arr = new String[4];
				for(int j=0;j<4;j++) {
					arr[j] = emp[i][j];
				}
				list.add(arr);
			}
		}else {
			int no = Integer.parseInt(str);
			no = no-1;
			for(int i=0;i<4;i++) {
				arr[i] = emp[no][i];
			}
			list.add(arr);
		}

		request.setAttribute("list", list);

		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
	}
}
