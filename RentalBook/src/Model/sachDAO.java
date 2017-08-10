package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class sachDAO {
	public static List<sach> selectALL() throws SQLException
	{
		String sql = "select * from	 [sach]";
		Connection cnn = connect.open();
	
		List<sach> list = new ArrayList<>();
		if(cnn!=null)
		{		
				PreparedStatement ps = cnn.prepareStatement(sql);
				
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
					sach s = new sach();
					
					s.setMaSach(rs.getString("masach"));
					s.setTenSach(rs.getString("tensach"));
					s.setNamSB(rs.getString("namsb"));
					s.setTacGia(rs.getString("tacgia"));
					s.setSoLuong(rs.getInt("soluong"));
					s.setHinhAnh(rs.getString("hinhanh"));
					s.setDuocMuon(rs.getInt("duocmuon"));
					
					list.add(s);
				}
		}
		return list;
	}
	
	public static boolean delete(String masach) throws SQLException
	{
		Connection cnn = connect.open();
		
		if(cnn!=null)
		{
			String sqls = "delete [tra] from [tra] a join [sach] b on a.masach=b.masach where a.masach=? and DuocMuon=0";
			String sql = "delete from [sach] where masach=? and DuocMuon=0";
			
			PreparedStatement pss = cnn.prepareStatement(sqls);
			PreparedStatement ps = cnn.prepareStatement(sql);
			
			pss.setString(1, masach);
			ps.setString(1, masach);
			
			pss.executeUpdate();
			boolean bool =  ps.executeUpdate()>0;
			
			return bool;
		}
		else
			return false;
	}
	
	public static sach selectONE(String masach) throws SQLException
	{
		String sql = "select * from	 [sach] where masach=?";
		Connection cnn = connect.open();
		sach s = new sach();
		if(cnn!=null)
		{
				PreparedStatement ps = cnn.prepareStatement(sql);
				ps.setString(1, masach);
				
				ResultSet rs = ps.executeQuery();
				rs.next();
				
				s.setMaSach(rs.getString("masach"));
				s.setTenSach(rs.getString("tensach"));
				s.setNamSB(rs.getString("namsb"));
				s.setTacGia(rs.getString("tacgia"));
				s.setSoLuong(rs.getInt("soluong"));
				s.setHinhAnh(rs.getString("hinhanh"));
				s.setDuocMuon(rs.getInt("duocmuon"));
				
				return s;
		
		}
		return s;
	}
	

	public static boolean insert(sach s) throws SQLException
	{
		Connection cnn = connect.open();
		
		if(cnn!=null)
		{
			String sql ="insert into [sach] values(?,?,?,?,?,?,?)";
			
			PreparedStatement ps = cnn.prepareStatement(sql);
			
			if(s.getMaSach().equalsIgnoreCase("") || s.getTenSach().equalsIgnoreCase("") || s.getHinhAnh().equalsIgnoreCase("") || s.getTacGia().equalsIgnoreCase("")
				||	s.getNamSB().equalsIgnoreCase("") || s.getSoLuong()==0)
			{
				ps.setString(1, null);
				ps.setString(2, null);
				ps.setString(3, null);
				ps.setString(4, null);
				ps.setString(5, null);
				ps.setString(7, null);
			}
			else
			{
				ps.setString(1, s.getMaSach());
				ps.setString(2, s.getTenSach());
				ps.setString(3, s.getTacGia());
				ps.setString(4, s.getNamSB());
				ps.setString(5, s.getHinhAnh());
				ps.setInt(7, s.getSoLuong());
			}
			ps.setInt(6,0);
			
			boolean bool = ps.executeUpdate() > 0;
			return bool;
		}
		else
			return false;
	}
	
	public static boolean update(sach s) throws SQLException
	{
		Connection cnn = connect.open();
		
		if(cnn!=null)
		{
			String sql ="update [sach] set tensach=?, tacgia=?, namsb=?, soluong=?, hinhanh=? where masach=?";
			
			PreparedStatement ps = cnn.prepareStatement(sql);
			
			if(s.getTenSach().equalsIgnoreCase("") || s.getHinhAnh().equalsIgnoreCase("") || s.getTacGia().equalsIgnoreCase("")
				||	s.getNamSB().equalsIgnoreCase("") || s.getSoLuong()==0)
			{
				ps.setString(1, null);
				ps.setString(2, null);
				ps.setString(3, null);
				ps.setString(4, null);
				ps.setString(5, null);
				ps.setString(6, null);
			}
			else
			{
				ps.setString(1, s.getTenSach());
				ps.setString(2, s.getTacGia());
				ps.setString(3, s.getNamSB());
				ps.setInt(4, s.getSoLuong());
				ps.setString(5, s.getHinhAnh());
				ps.setString(6, s.getMaSach());
			}
			
			boolean bool = ps.executeUpdate() > 0;
			return bool;
		}
		else
			return false;
	}
	
	public static void updateDuocMuon(String masach) throws SQLException
	{
		Connection cnn = connect.open();
		
		if(cnn!=null)
		{
			String sql ="update [sach] set duocmuon=duocmuon+1 where masach=?";
			
			PreparedStatement ps = cnn.prepareStatement(sql);
			
				ps.setString(1,masach);
				ps.executeUpdate();
		}
		
	}
	
	public static void updateDuocMuonGiam(String masach) throws SQLException
	{
		Connection cnn = connect.open();
		
		if(cnn!=null)
		{
			String sql ="update [sach] set duocmuon=duocmuon-1 where masach=?";
			
			PreparedStatement ps = cnn.prepareStatement(sql);
			
			ps.setString(1,masach);
			ps.executeUpdate();
		}
		
	}
	
	public static List<sach> Search(String masach, String tensach, String tacgia) throws SQLException
	{
		
		Connection cnn = connect.open();
	
		List<sach> list = new ArrayList<>();
		if(cnn!=null)
		{		
					PreparedStatement ps;
					
					if(!masach.equalsIgnoreCase("") && !masach.equalsIgnoreCase("") && !tensach.equalsIgnoreCase(""))
					{
						String sql2 = "select * from [sach] where 1=1 and masach=?";
						ps = cnn.prepareStatement(sql2);
						ps.setString(1, masach);
					}
					else if(!masach.equalsIgnoreCase("") && !tensach.equalsIgnoreCase(""))
					{
						String sql2 = "select * from [sach] where 1=1 and masach=?";
						ps = cnn.prepareStatement(sql2);
						ps.setString(1, masach);
					}
					else if(!masach.equalsIgnoreCase("") && !tacgia.equalsIgnoreCase(""))
					{
						String sql2 = "select * from [sach] where 1=1 and masach=?";
						ps = cnn.prepareStatement(sql2);
						ps.setString(1, masach);
					}
					else if(!tensach.equalsIgnoreCase("") && !tacgia.equalsIgnoreCase(""))
					{
						String sql3 = "select * from [sach] where 1=1 and tensach=? and tacgia=?";
						ps = cnn.prepareStatement(sql3);
						ps.setString(1, tensach);
						ps.setString(2, tacgia);
					}
					else if(!masach.equalsIgnoreCase(""))
					{
						String sql2 = "select * from [sach] where 1=1 and masach=?";
						ps = cnn.prepareStatement(sql2);
						ps.setString(1, masach);
					}
					else if(!tensach.equalsIgnoreCase(""))
					{
						String sql2 = "select * from [sach] where 1=1 and tensach=?";
						ps = cnn.prepareStatement(sql2);
						ps.setString(1, tensach);
					}
					else if(!tacgia.equalsIgnoreCase(""))
					{
						String sql2 = "select * from [sach] where 1=1 and tacgia=?";
						ps = cnn.prepareStatement(sql2);
						ps.setString(1, tacgia);
					}					
					
					else
					{
						 return list;
					}
					
					ResultSet rs = ps.executeQuery();
					while(rs.next())
					{
						sach s = new sach();
						
						s.setMaSach(rs.getString("masach"));
						s.setTenSach(rs.getString("tensach"));
						s.setNamSB(rs.getString("namsb"));
						s.setTacGia(rs.getString("tacgia"));
						s.setSoLuong(rs.getInt("soluong"));
						s.setHinhAnh(rs.getString("hinhanh"));
						s.setDuocMuon(rs.getInt("duocmuon"));
						
						list.add(s);
					}
				
		}
		return list;
	}
	
	public static List<sach> UserProductSearch(String key) throws SQLException
	{
		Connection cnn = connect.open();
		
		List<sach> list = new ArrayList<>();
		if(cnn!=null)
		{		
				PreparedStatement ps;
				
				if(!key.equalsIgnoreCase(""))
				{
					String sql = "select * from [sach] where tensach like ? or tacgia like ?";
					
					ps = cnn.prepareStatement(sql);
					ps.setString(1, "%" + key + "%");
					ps.setString(2, "%" + key + "%");
				}
				else
				{
					 return list;
				}
				
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
					sach s = new sach();
					
					s.setMaSach(rs.getString("masach"));
					s.setTenSach(rs.getString("tensach"));
					s.setNamSB(rs.getString("namsb"));
					s.setTacGia(rs.getString("tacgia"));
					s.setSoLuong(rs.getInt("soluong"));
					s.setHinhAnh(rs.getString("hinhanh"));
					s.setDuocMuon(rs.getInt("duocmuon"));
					
					list.add(s);
				}
		}
		return list;
	}
	
//	public static void main(String[] args) throws SQLException
//	{
//		List<chitiet> list = chitietDAO.Search("","ten1","");
//		
//		for(chitiet ct : list)
//		{
//			System.out.println(ct.getMaMuon());
//		}
//			
//		
//	}
	
}
