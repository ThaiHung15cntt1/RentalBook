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

import Model.chitiet;
import Model.chitietDAO;
import Model.muon;
import Model.muonDAO;

/**
 * Servlet implementation class set_adminListOrder
 */
@WebServlet("/set_adminListOrder")
public class set_adminListOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public set_adminListOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if (session.getAttribute("listorder") == null || session.getAttribute("listorder").equals(""))
		{
			int bit = 0;
			request.setAttribute("bit", bit);
		}
		else if (session.getAttribute("listorder") != null && session.getAttribute("listorder").equals("")) 
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
			List<chitiet> list = chitietDAO.selectALL();
			request.setAttribute("list", list);
			request.getRequestDispatcher("admin_ListOrder.jsp").forward(request, response);
		} catch (SQLException e) {
			
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
