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
import Model.sach;
import Model.sachDAO;

/**
 * Servlet implementation class set_adminListOrderSearch
 */
@WebServlet("/set_adminListOrderSearch")
public class set_adminListOrderSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public set_adminListOrderSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String madat = request.getParameter("madat");
		String ten = request.getParameter("ten");
		String tensach = request.getParameter("tensach");
		
		try
		{
			List<chitiet> listorder = chitietDAO.Search(madat,ten,tensach);	
			if(listorder.isEmpty()==true)
			{
				int bit = 0;
				request.setAttribute("bit", bit);
			}
			else
			{
				int bit = 1;
				request.setAttribute("bit", bit);
				
				HttpSession session = request.getSession();
				session.setAttribute("listorder", listorder);
			}
			List<chitiet> list = chitietDAO.selectALL();
			request.setAttribute("list", list);
			request.getRequestDispatcher("admin_ListOrder.jsp").forward(request, response);
		}
		catch(SQLException e)
		{
			//e.printStackTrace();
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
