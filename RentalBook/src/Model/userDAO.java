package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.security.SecureRandom;
import java.math.BigInteger;

public class userDAO {
	
	public static khachhang selectONE(String tendangnhap) throws SQLException
	{
		String sql = "select * from	 [khachhang] where tendangnhap=?";
		Connection cnn = connect.open();
		khachhang kh = new khachhang();
		if(cnn!=null)
		{
				PreparedStatement ps = cnn.prepareStatement(sql);
				ps.setString(1, tendangnhap);
				
				ResultSet rs = ps.executeQuery();
				rs.next();
				
				kh.setTenDangNhap(rs.getString("tendangnhap"));
				kh.setMatKhau(rs.getString("matkhau"));
				kh.setQuyen(rs.getString("quyen"));
				kh.setTen(rs.getString("ten"));
				kh.setSdt(rs.getString("sdt"));
				kh.setTrangThai(rs.getString("trangthai"));
				kh.setNgaySinh(rs.getString("ngaysinh"));
				kh.setDiaChi(rs.getString("diachi"));
				
				return kh;
		
		}
		return kh;
	}
	
	
	
	public static boolean insert(khachhang kh) throws SQLException
	{
		Connection cnn = connect.open();
		
		if(cnn!=null)
		{
			String sql ="insert into [khachhang] values(?,?,?,?,?,?,?,?)";
			
			PreparedStatement ps = cnn.prepareStatement(sql);
//			String uniqueID = UUID.randomUUID().toString();
//			
			if(kh.getTenDangNhap().equalsIgnoreCase("") || kh.getTen().equalsIgnoreCase("") || kh.getMatKhau().equalsIgnoreCase(""))
			{
				ps.setString(1, null);
				ps.setString(2, null);
				ps.setString(7, null);
			}
			else
			{
				ps.setString(1, kh.getTenDangNhap());
				ps.setString(2, kh.getTen());
				ps.setString(7, kh.getMatKhau());
			}
			ps.setString(3, kh.getNgaySinh());
			ps.setString(4, kh.getDiaChi());
			ps.setString(5,kh.getSdt());
			ps.setString(6,"user");
			//ps.setString(7, kh.getMatKhau());
			ps.setString(8, "khong");
			
			boolean bool = ps.executeUpdate() > 0;
			return bool;
		}
		else
			return false;
	}
	
	
	public static List<khachhang> selectALL() throws SQLException
	{
		String sql = "select * from	 [khachhang]";
		Connection cnn = connect.open();
	
		List<khachhang> list = new ArrayList<>();
		if(cnn!=null)
		{		
				PreparedStatement ps = cnn.prepareStatement(sql);
				
				ResultSet rs = ps.executeQuery();
				while(rs.next())
				{
					khachhang kh = new khachhang();
					
					kh.setTenDangNhap(rs.getString("tendangnhap"));
					kh.setMatKhau(rs.getString("matkhau"));
					kh.setDiaChi(rs.getString("diachi"));
					kh.setQuyen(rs.getString("quyen"));
					kh.setSdt(rs.getString("sdt"));
					kh.setTen(rs.getString("ten"));
					kh.setNgaySinh(rs.getString("ngaysinh"));
					kh.setTrangThai(rs.getString("trangthai"));
					
					list.add(kh);
				}
		}
		return list;
	}
	
	public static boolean delete(String tendangnhap) throws SQLException
	{
		Connection cnn = connect.open();
		
		if(cnn!=null)
		{
			
			String sqlt = "delete [tra] from [tra] a join [khachhang] b on a.tendangnhap=b.tendangnhap where a.tendangnhap=? and trangthai='khong'";
			String sql = "delete from [khachhang] where tendangnhap=? and trangthai='khong'";
			
			PreparedStatement pst = cnn.prepareStatement(sqlt);
			PreparedStatement ps = cnn.prepareStatement(sql);
			
			ps.setString(1, tendangnhap);
			pst.setString(1, tendangnhap);
			
			pst.executeUpdate();
			boolean bool = ps.executeUpdate()>0;
			
			return bool;
		}
		else
			return false;
	}
	
	public static boolean update(khachhang kh) throws SQLException
	{
		Connection cnn = connect.open();
		
		if(cnn!=null)
		{
			String sql="update [khachhang] set ten=?, ngaysinh=?, diachi=?, sdt=?, matkhau=?, trangthai=? where tendangnhap=?";
			
			PreparedStatement ps = cnn.prepareStatement(sql);
			
			if(kh.getTen().equalsIgnoreCase("") || kh.getNgaySinh().equalsIgnoreCase("") || kh.getMatKhau().equals("") || kh.getTenDangNhap().equalsIgnoreCase(""))
			{
				ps.setString(1, null);
				ps.setString(2, null);
				ps.setString(5, null);
				ps.setString(7, null);
			}
			else
			{
				ps.setString(1, kh.getTen());
				ps.setString(2, kh.getNgaySinh());
				ps.setString(5, kh.getMatKhau());
				ps.setString(7, kh.getTenDangNhap());
			}
			ps.setString(3, kh.getDiaChi());
			ps.setString(4, kh.getSdt());		
			ps.setString(6, kh.getTrangThai());
			
			
			boolean bool = ps.executeUpdate() > 0;
			return bool;
		}
		return false;
	}
	
	
	public static void updateTrangThai(String tendangnhap) throws SQLException
	{
		Connection cnn = connect.open();
		
		if(cnn!=null)
		{
			String sql="update [khachhang] set trangthai='co' where tendangnhap=?";
			
			PreparedStatement ps = cnn.prepareStatement(sql);
			
			ps.setString(1, tendangnhap);
			ps.executeUpdate();
		}
	}
	
	public static void updateTrangThaiKhong(String tendangnhap) throws SQLException
	{
		Connection cnn = connect.open();
		
		if(cnn!=null)
		{
			String sql="update [khachhang] set trangthai='khong' where tendangnhap=?";
			
			PreparedStatement ps = cnn.prepareStatement(sql);
			
			ps.setString(1, tendangnhap);
			ps.executeUpdate();
		}
	}
	
	public static List<khachhang> Search(String tendangnhap, String ten) throws SQLException
	{
		
		Connection cnn = connect.open();
	
		List<khachhang> list = new ArrayList<>();
		if(cnn!=null)
		{		
					PreparedStatement ps;
					
					if(!tendangnhap.equalsIgnoreCase("") && !ten.equalsIgnoreCase(""))
					{
						String sql1 = "select * from [khachhang] where 1=1 and tendangnhap=?";
						ps = cnn.prepareStatement(sql1);
						ps.setString(1, tendangnhap);
					}
					else if(!tendangnhap.equalsIgnoreCase("") && ten.equalsIgnoreCase(""))
					{
						String sql2 = "select * from [khachhang] where 1=1 and tendangnhap=?";
						ps = cnn.prepareStatement(sql2);
						ps.setString(1, tendangnhap);
					}
				
					else if(!ten.equalsIgnoreCase("") && tendangnhap.equalsIgnoreCase(""))
					{
						String sql3 = "select * from [khachhang] where 1=1 and ten=?";
						ps = cnn.prepareStatement(sql3);
						ps.setString(1, ten);
					}
					else
					{
						 return list;
					}
					
					ResultSet rs = ps.executeQuery();
					while(rs.next())
					{
						khachhang kh = new khachhang();
						
						kh.setTenDangNhap(rs.getString("tendangnhap"));
						kh.setMatKhau(rs.getString("matkhau"));
						kh.setDiaChi(rs.getString("diachi"));
						kh.setQuyen(rs.getString("quyen"));
						kh.setSdt(rs.getString("sdt"));
						kh.setTen(rs.getString("ten"));
						kh.setNgaySinh(rs.getString("ngaysinh"));
						kh.setTrangThai(rs.getString("trangthai"));
						
						list.add(kh);
					}
				
		}
		return list;
	}
	
	
	
//	public static void main(String[] args) throws SQLException
//	{
//		List<khachhang> list = userDAO.Search("","");
//	
//		
//		try
//		{
//			System.out.println(list.size());
//		}
//		catch(Exception e)
//		{
//			
//		}
//	}
	
	
}
