package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class check_user {

	public static boolean check(String matkhauInput) throws SQLException
	{
		boolean bool = false;
		List<khachhang> list = new ArrayList<>();
		try
		{
			list = userDAO.selectALL();	
			
			for(khachhang kh : list)
			{
				if(kh.getMatKhau().equalsIgnoreCase(matkhauInput))
					bool = true;
			}
		}
		catch(Exception e)
		{
			return false;
		}
		return bool;
	}
}
