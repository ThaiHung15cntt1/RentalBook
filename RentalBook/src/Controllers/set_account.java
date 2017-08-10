package Controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.chitiet;
import Model.chitietDAO;
import Model.khachhang;
import Model.muon;
import Model.muonDAO;
import Model.sach;
import Model.sachDAO;
import Model.userDAO;

/**
 * Servlet implementation class set_account
 */
@WebServlet("/set_account")
public class set_account extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public set_account() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String tendangnhap = (String) session.getAttribute("tendangnhap");
		
		try {
			chitiet ct = chitietDAO.selectONE(tendangnhap);
			
			request.setAttribute("ct", ct);
			request.getRequestDispatcher("order.jsp").forward(request, response);
			
		} catch (SQLException e) {
				
				String message = "Không có đơn đặt hàng nào";
				request.setAttribute("message", message);
				
				request.getRequestDispatcher("order.jsp").forward(request, response);
			
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
