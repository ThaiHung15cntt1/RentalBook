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

import Model.khachhang;
import Model.sach;
import Model.sachDAO;
import Model.userDAO;

/**
 * Servlet implementation class set_adminListUser
 */
@WebServlet("/set_adminListUser")
public class set_adminListUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public set_adminListUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if (session.getAttribute("lists") == null || session.getAttribute("lists").equals(""))
		{
			int bit = 0;
			request.setAttribute("bit", bit);
		}
		else if (session.getAttribute("lists") != null && session.getAttribute("lists").equals("")) 
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
			List<khachhang> list = userDAO.selectALL();
			request.setAttribute("list", list);
			request.getRequestDispatcher("admin_ListUser.jsp").forward(request, response);
		} catch (SQLException e) {
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
