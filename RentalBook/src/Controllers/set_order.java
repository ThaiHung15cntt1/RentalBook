package Controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

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
 * Servlet implementation class set_order
 */
@WebServlet("/set_order")
public class set_order extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public set_order() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String tendangnhap = (String)session.getAttribute("tendangnhap");
		String masach = request.getParameter("masach");
		String uniqueID = UUID.randomUUID().toString();
		
		
		 
		if(tendangnhap !=null)
		{
		try {
			sachDAO.updateDuocMuon(masach);
			userDAO.updateTrangThai(tendangnhap);
			/////////////////////////////////////////
			muon m1 = new muon();
			
			m1.setMaSach(masach);
			m1.setTenDangNhap(tendangnhap);
			m1.setHanMuon(uniqueID);
			
			muonDAO.insert(m1);
			///////////////////////////////////////////
			response.sendRedirect("set_account");
			
		} catch (SQLException e) {
			try {
				sach s = sachDAO.selectONE(masach);
				
				String message = "Bạn chỉ được mượn 1 quyển sách";
				request.setAttribute("message", message);
				request.setAttribute("s", s);
				request.getRequestDispatcher("product.jsp").forward(request, response);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		}
		else
		{
					
			try {
				String message = "Bạn chưa đăng nhập";
				request.setAttribute("message", message);
				
				sach s = sachDAO.selectONE(masach);
				request.setAttribute("s", s);
				request.getRequestDispatcher("product.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
