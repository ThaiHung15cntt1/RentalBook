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
 * Servlet implementation class set_adminListBookSearch
 */
@WebServlet("/set_adminListBookSearch")
public class set_adminListBookSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public set_adminListBookSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String masach = request.getParameter("masach");
		String tensach = request.getParameter("tensach");
		String tacgia = request.getParameter("tacgia");
		
		try
		{
			List<sach> listbook = sachDAO.Search(masach,tensach,tacgia);	
			if(listbook.isEmpty()==true)
			{
				int bit = 0;
				request.setAttribute("bit", bit);
			}
			else
			{
				int bit = 1;
				request.setAttribute("bit", bit);
				
				HttpSession session = request.getSession();
				session.setAttribute("listbook", listbook);
			}
			
			List<sach> list = sachDAO.selectALL();
			request.setAttribute("list", list);
			request.getRequestDispatcher("admin_ListBook.jsp").forward(request, response);
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
