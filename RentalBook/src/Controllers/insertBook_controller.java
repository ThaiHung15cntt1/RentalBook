package Controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.khachhang;
import Model.sach;
import Model.sachDAO;
import Model.userDAO;

/**
 * Servlet implementation class insert_controller
 */
@WebServlet("/insertBook_controller")
public class insertBook_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertBook_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sach s = new sach();
		 
		 s.setMaSach(request.getParameter("MaSach").trim());
		 s.setTenSach(request.getParameter("TenSach").trim());
		 s.setNamSB(request.getParameter("NamSB").trim());
		 s.setTacGia(request.getParameter("TacGia").trim());
		 s.setHinhAnh(request.getParameter("HinhAnh").trim());
		 
		 
		 String submit = request.getParameter("submit");
		 
		 if(submit.equalsIgnoreCase("themmoi"))
		 {
			 
				 try {
					 
					 int soluong = Integer.parseInt(request.getParameter("SoLuong").trim());
					 s.setSoLuong(soluong);
					 
					boolean bool = sachDAO.insert(s);
					if(bool)
					{
						String message = "thanh cong";
						request.setAttribute("message", message);
						request.getRequestDispatcher("insertBook.jsp").forward(request, response);
					}
				} catch (SQLException | NumberFormatException e) {
					String message = "Khong thanh cong: Ban nhap chua du thong tin hoac ma sach da ton tai";
					request.setAttribute("message_warning", message);
					request.getRequestDispatcher("insertBook.jsp").forward(request, response);
				}
			 
		 }
		 else
		 {
			 response.sendRedirect("set_adminListBook");
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
