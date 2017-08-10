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
import Model.sach;
import Model.sachDAO;
import Model.traDAO;

/**
 * Servlet implementation class set_adminListOrderComSearch
 */
@WebServlet("/set_adminListOrderComSearch")
public class set_adminListOrderComSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public set_adminListOrderComSearch() {
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
			List<chitiettra> listordercom = traDAO.Search(madat,ten,tensach);	
			if(listordercom.isEmpty()==true)
			{
				int bit = 0;
				request.setAttribute("bit", bit);
			}
			else
			{
				int bit = 1;
				request.setAttribute("bit", bit);
				
				HttpSession session = request.getSession();
				session.setAttribute("listordercom", listordercom);
			}
			
			List<chitiettra> list = traDAO.selectALL();
			request.setAttribute("list", list);
			request.getRequestDispatcher("admin_ListOrderCom.jsp").forward(request, response);
		}
		catch(SQLException e)
		{
			
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
