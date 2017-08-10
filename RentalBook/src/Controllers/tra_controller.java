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

import Model.muon;
import Model.muonDAO;
import Model.sachDAO;
import Model.tra;
import Model.traDAO;
import Model.userDAO;

/**
 * Servlet implementation class tra_controller
 */
@WebServlet("/tra_controller")
public class tra_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tra_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mamuon = request.getParameter("mamuon");
		
		try {
			muon m = muonDAO.selectONEad(mamuon);
			sachDAO.updateDuocMuonGiam(m.getMaSach());
			userDAO.updateTrangThaiKhong(m.getTenDangNhap());
			///////////////////////////////
			HttpSession session = request.getSession();
			session.removeAttribute("listorder");
			//////////////////////////////
			tra t = new tra();
			t.setTendangnhap(m.getTenDangNhap());
			t.setMasach(m.getMaSach());
			t.setMatra(m.getMaMuon());
			
			traDAO.insert(t);
			///////////////////////////////
			muonDAO.delete(mamuon);
			//////////////////////////////
			response.sendRedirect("set_adminListOrderComplete");
			
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
