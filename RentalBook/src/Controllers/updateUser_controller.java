package Controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.khachhang;
import Model.userDAO;

/**
 * Servlet implementation class updateUser_controller
 */
@WebServlet("/updateUser_controller")
public class updateUser_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateUser_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		khachhang kh = new khachhang();
		 
		 kh.setDiaChi(request.getParameter("DiaChi").trim());
		 kh.setTen(request.getParameter("Ten").trim());
		 kh.setNgaySinh(request.getParameter("NgaySinh").trim());
		 kh.setSdt(request.getParameter("Sdt").trim());
		 kh.setMatKhau(request.getParameter("MatKhau").trim());
		 kh.setTenDangNhap(request.getParameter("TenDangNhap").trim());
		
		 String submit = request.getParameter("submit");
		 
		 if(submit.equalsIgnoreCase("capnhat"))
		 {
			 try 
			 {	
					boolean bool = userDAO.update(kh);
					if(bool)
					{
						kh = userDAO.selectONE( kh.getTenDangNhap());
						request.setAttribute("kh",kh);
						String message = "Cap nhat thanh cong";
						request.setAttribute("message", message);
					
						RequestDispatcher dispatcher = request.getRequestDispatcher("updateUser.jsp");
						dispatcher.forward(request, response);
					
					}
					else
					{
						kh = userDAO.selectONE( kh.getTenDangNhap());
						request.setAttribute("kh",kh);
						String message = "khong thanh cong";
						request.setAttribute("message-warning", message);
					
						RequestDispatcher dispatcher = request.getRequestDispatcher("updateUser.jsp");
						dispatcher.forward(request, response);
					}
			 } 
			 catch (SQLException e) 
			 {
				 	
					request.setAttribute("kh",kh);
					String message = "Ban nhap chua du thong tin";
					request.setAttribute("message_warning", message);
				
					RequestDispatcher dispatcher = request.getRequestDispatcher("updateUser.jsp");
					dispatcher.forward(request, response);
			 } 
		 }
		 else
		 {
			 response.sendRedirect("set_adminListUser");
		 }
	}
		 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	
}
