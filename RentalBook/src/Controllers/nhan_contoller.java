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
import Model.muonDAO;

/**
 * Servlet implementation class nhan_contoller
 */
@WebServlet("/nhan_contoller")
public class nhan_contoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public nhan_contoller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mamuon = request.getParameter("mamuon");
		
		try {
			muonDAO.updateTinhTrangNhan(mamuon);
			//////////////////////////////////
			HttpSession session = request.getSession();
			if (session.getAttribute("listorder") != null)
			{
				session.removeAttribute("listorder");
				chitiet ct = chitietDAO.selectONE(mamuon);
				List<chitiet> listorder = chitietDAO.Search(mamuon,ct.getTenKhachHang(),ct.getTenSach());	
				session.setAttribute("listorder", listorder);
			}
			else if (session.getAttribute("listorder") != null && session.getAttribute("listorder").equals("")) 
			{
				session.removeAttribute("listorder");
				chitiet ct = chitietDAO.selectONE(mamuon);
				List<chitiet> listorder = chitietDAO.Search(mamuon,ct.getTenKhachHang(),ct.getTenSach());
				session.setAttribute("listorder", listorder);
			}
						
			response.sendRedirect("set_adminListOrder");
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
