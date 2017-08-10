package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class traDAO {
	public static void insert(tra t) throws SQLException
	{
		Connection cnn = connect.open();
		
		if(cnn!=null)
		{
			String sql ="insert into [tra] values(?,?,dateadd(dd,7,convert(date, getdate())),?)";
			
			PreparedStatement ps = cnn.prepareStatement(sql);
			
				//String uniqueID = UUID.randomUUID().toString();
			
				ps.setString(1, t.getMatra());
				ps.setString(2, t.getMasach());
				ps.setString(3, t.getTendangnhap());
			
				ps.executeUpdate();
		}
		
	}
	
	public static List<chitiettra> selectALL() throws SQLException
	{
		String sql = "select b.MaTra,Ten,a.tendangnhap,TenSach, NgayTra, diachi, sdt from [khachhang] a join [tra] b on a.tendangnhap=b.tendangnhap join [sach] c on b.masach=c.masach";
		Connection cnn = connect.open();
		
		List<chitiettra> list = new ArrayList<>();
	
		if(cnn!=null)
		{
				PreparedStatement ps = cnn.prepareStatement(sql);
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next())
				{
				chitiettra ctt = new chitiettra();
					
				ctt.setTensach(rs.getString("TenSach"));
				ctt.setTenkhachhang(rs.getString("Ten"));
				ctt.setTendangnhap(rs.getString("tendangnhap"));
				ctt.setNgaytra(rs.getString("NgayTra"));
				ctt.setMatra(rs.getString("MaTra"));
				ctt.setDiachi(rs.getString("diachi"));
				ctt.setSdt(rs.getString("sdt"));
				
				list.add(ctt);
				}
				return list;
		}
		return list;
	}
	
	public static List<chitiettra> Search(String mamuon, String ten, String tensach) throws SQLException
	{
		Connection cnn = connect.open();
	
		List<chitiettra> list = new ArrayList<>();
		if(cnn!=null)
		{		
					PreparedStatement ps;
					
					if(!mamuon.equalsIgnoreCase("") && !ten.equalsIgnoreCase("") && !tensach.equalsIgnoreCase(""))
					{
						String sql2 = "select * from [chitiettra] where 1=1 and matra like ?";
						ps = cnn.prepareStatement(sql2);
						ps.setString(1, "%" + mamuon + "%");
					}
					else if(!mamuon.equalsIgnoreCase("") && !ten.equalsIgnoreCase(""))
					{
						String sql2 = "select * from [chitiettra] where 1=1 and matra like ?";
						ps = cnn.prepareStatement(sql2);
						ps.setString(1, "%" + mamuon + "%");
					}
					else if(!mamuon.equalsIgnoreCase("") && !tensach.equalsIgnoreCase(""))
					{
						String sql2 = "select * from [chitiettra] where 1=1 and matra like ?";
						ps = cnn.prepareStatement(sql2);
						ps.setString(1, "%" + mamuon + "%");
					}
					else if(!tensach.equalsIgnoreCase("") && !ten.equalsIgnoreCase(""))
					{
						String sql3 = "select * from [chitiettra] where 1=1 and tensach like ? and ten like ?";
						ps = cnn.prepareStatement(sql3);
						ps.setString(1,  "%" + tensach + "%");
						ps.setString(2,  "%" + ten + "%");
					}
					else if(!mamuon.equalsIgnoreCase(""))
					{
						String sql2 = "select * from [chitiettra] where 1=1 and matra like ?";
						ps = cnn.prepareStatement(sql2);
						ps.setString(1, "%" + mamuon + "%");
					}
					else if(!ten.equalsIgnoreCase(""))
					{
						String sql2 = "select * from [chitiettra] where 1=1 and ten like ?";
						ps = cnn.prepareStatement(sql2);
						ps.setString(1, "%" + ten + "%");
					}
					else if(!tensach.equalsIgnoreCase(""))
					{
						String sql2 = "select * from [chitiettra] where 1=1 and tensach like ?";
						ps = cnn.prepareStatement(sql2);
						ps.setString(1, "%" + tensach + "%");
					}					
					else
					{
						 return list;
					}
					
					ResultSet rs = ps.executeQuery();
					while(rs.next())
					{
					chitiettra ctt = new chitiettra();
							
						ctt.setTensach(rs.getString("TenSach"));
						ctt.setTenkhachhang(rs.getString("Ten"));
						ctt.setTendangnhap(rs.getString("tendangnhap"));
						ctt.setNgaytra(rs.getString("NgayTra"));
						ctt.setMatra(rs.getString("MaTra"));
						ctt.setDiachi(rs.getString("diachi"));
						ctt.setSdt(rs.getString("sdt"));
						
					list.add(ctt);
					}
				
		}
		return list;
	}
	
	public static void main(String[] args) throws SQLException
	{
		List<chitiettra> list = traDAO.Search("f","ten1","");
		
		for(chitiettra ct : list)
		{
			System.out.println(ct.getMatra());
		}
			
		
	}
}
