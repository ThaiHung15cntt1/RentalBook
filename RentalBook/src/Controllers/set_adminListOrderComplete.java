package Controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.chitiettra;
import Model.traDAO;

/**
 * Servlet implementation class set_adminListOrderComplete
 */
@WebServlet("/set_adminListOrderComplete")
public class set_adminListOrderComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public set_adminListOrderComplete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session = request.getSession();
		
		if (session.getAttribute("listordercom") == null || session.getAttribute("listordercom").equals(""))
		{
			int bit = 0;
			request.setAttribute("bit", bit);
		}
		else if (session.getAttribute("listordercom") != null && session.getAttribute("listordercom").equals("")) 
		{
			int bit = 0;
			request.setAttribute("bit", bit);
		}
		else
		{
			int bit = 1;
			request.setAttribute("bit", bit);
		}
		
		try {
			List<chitiettra> list = traDAO.selectALL();
			
			request.setAttribute("list", list);
			request.getRequestDispatcher("admin_ListOrderCom.jsp").forward(request, response);;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
