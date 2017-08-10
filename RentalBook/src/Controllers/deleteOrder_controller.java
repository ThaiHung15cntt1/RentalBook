package Controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.muon;
import Model.muonDAO;
import Model.sachDAO;
import Model.userDAO;

/**
 * Servlet implementation class deleteOrder_controller
 */
@WebServlet("/deleteOrder_controller")
public class deleteOrder_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteOrder_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mamuon = request.getParameter("mamuon");
		HttpSession session = request.getSession();
		String tendangnhap = (String)session.getAttribute("tendangnhap");
		
		try {
			muon m = muonDAO.selectONE(tendangnhap);
			sachDAO.updateDuocMuonGiam(m.getMaSach());
			userDAO.updateTrangThaiKhong(tendangnhap);
			///////////////////////////////
			muonDAO.delete(mamuon);
			//////////////////////////////
			response.sendRedirect("set_account");
			
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
