package Controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.khachhang;
import Model.userDAO;

/**
 * Servlet implementation class dangky_controller
 */
@WebServlet("/dangky_controller")
public class dangky_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangky_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		khachhang kh = new khachhang();
		 
		 kh.setDiaChi(request.getParameter("DiaChi").trim());
		 kh.setTen(request.getParameter("Ten").trim());
		 kh.setNgaySinh(request.getParameter("NgaySinh").trim());
		 kh.setSdt(request.getParameter("Sdt").trim());
		 kh.setMatKhau(request.getParameter("MatKhau").trim());
		 kh.setTenDangNhap(request.getParameter("TenDangNhap").trim());
		 
		 String submit = request.getParameter("submit");
		 
		 if(submit.equalsIgnoreCase("dangky"))
		 {
				 try {
					
					boolean bool = userDAO.insert(kh);
					if(bool)
					{
						String message = "Dang ky thanh cong";
						request.setAttribute("message", message);
						request.getRequestDispatcher("dangky.jsp").forward(request, response);
					}
				} catch (SQLException e) {
					String message = "Khong thanh cong: Ban nhap chua du thong tin hoac ten dang nhap da ton tai";
					request.setAttribute("message_warning", message);
					request.getRequestDispatcher("dangky.jsp").forward(request, response);
				}
			 
		 }
		 else
		 {
			 response.sendRedirect("login.jsp");
		 }
	}

}
