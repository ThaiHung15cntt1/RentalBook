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
import Model.userDAO;

/**
 * Servlet implementation class set_adminListUserSearch
 */
@WebServlet("/set_adminListUserSearch")
public class set_adminListUserSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public set_adminListUserSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tendangnhap = request.getParameter("tendangnhap");
		String ten = request.getParameter("ten");
		
		try
		{
			List<khachhang> lists = userDAO.Search(tendangnhap, ten);		
			if(lists.isEmpty()==true)
			{
				int bit = 0;
				request.setAttribute("bit", bit);
			}
			else
			{
				int bit = 1;
				request.setAttribute("bit", bit);
				
				HttpSession session = request.getSession();
				session.setAttribute("lists", lists);
			}
			
			
			List<khachhang> list = userDAO.selectALL();
			request.setAttribute("list", list);
			request.getRequestDispatcher("admin_ListUser.jsp").forward(request, response);
		}
		catch(SQLException e)
		{
//			String message = "khong co bang ghi nao";
//			request.setAttribute("message", message);
//			
//			request.getRequestDispatcher("admin_ListUser.jsp").forward(request, response);
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
