package Controllers;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.check_user;
import Model.khachhang;
import Model.userDAO;

/**
 * Servlet implementation class Login_controller
 */
@WebServlet("/login_controller")
public class login_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login_controller() {
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
		
		String submit = request.getParameter("submit");
					
		if(submit.equalsIgnoreCase("dangnhap"))
		{
			String tendangnhap = request.getParameter("TenDangNhap").trim();
			String matkhau = request.getParameter("MatKhau").trim();
			
			khachhang kh = new khachhang();

			try 
			{
				if(tendangnhap.equalsIgnoreCase("") || matkhau.equalsIgnoreCase(""))
				{
					String message = "Ban chua nhap du thong tin";
					request.setAttribute("message", message);
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
				
				else if(!(tendangnhap.equalsIgnoreCase("") && matkhau.equalsIgnoreCase("")))
				{	
					if(tendangnhap.equalsIgnoreCase("admin") && matkhau.equalsIgnoreCase("1234"))
					{
						response.sendRedirect("set_adminListUser");
					}
					else if(check_user.check(matkhau))
					{
						
									
						kh = userDAO.selectONE(tendangnhap);
						String quyen = kh.getQuyen();
						
						
						if(quyen.equalsIgnoreCase("user"))
						{
							HttpSession session = request.getSession();
							session.setAttribute("tendangnhap", tendangnhap);
							response.sendRedirect("set_home");
						}
					}
				    else
				    {
				    	String message = "ten dang nhap hoac mat khau khong dung";
						request.setAttribute("message", message);
						request.getRequestDispatcher("login.jsp").forward(request, response);
				    }
					
				}
				
				
			} 
			catch (SQLException e) {
					e.printStackTrace();
			}
		}
		else if(submit.equalsIgnoreCase("dangky"))
		{
			response.sendRedirect("dangky.jsp");
		}
	}
	

}
