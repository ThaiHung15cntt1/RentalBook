package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class chitietDAO {
	public static chitiet selectONE(String tendangnhap) throws SQLException
	{
		String sql = "select b.MaMuon,Ten,TenSach, HinhAnh, NamSB, NgayMuon, HanMuon,TacGia, TinhTrang from [khachhang] a join [muon] b on a.tendangnhap=b.tendangnhap join [sach] c on b.masach=c.masach where a.tendangnhap=? or b.mamuon=?";
		Connection cnn = connect.open();
		chitiet ct = new chitiet();
		if(cnn!=null)
		{
				PreparedStatement ps = cnn.prepareStatement(sql);
				ps.setString(1, tendangnhap);
				ps.setString(2, tendangnhap);
				
				ResultSet rs = ps.executeQuery();
				rs.next();
				
				ct.setTenSach(rs.getString("TenSach"));
				ct.setTenKhachHang(rs.getString("Ten"));
				ct.setNamSB(rs.getString("NamSB"));
				ct.setHinhAnh(rs.getString("HinhAnh"));
				ct.setHanTra(rs.getString("HanMuon"));
				ct.setNgayDat(rs.getString("NgayMuon"));
				ct.setTacGia(rs.getString("TacGia"));
				ct.setMaMuon(rs.getString("MaMuon"));
				ct.setTinhTrang(rs.getInt("TinhTrang"));
				
				return ct;
		
		}
		return ct;
	}
	
	
	public static List<chitiet> selectALL() throws SQLException
	{
		String sql = "select b.MaMuon,Ten,TenSach, HinhAnh, NgayMuon, HanMuon, diachi, sdt, b.tinhtrang from [khachhang] a join [muon] b on a.tendangnhap=b.tendangnhap join [sach] c on b.masach=c.masach";
		Connection cnn = connect.open();

		List<chitiet> list = new ArrayList<>();
	
		if(cnn!=null)
		{
				PreparedStatement ps = cnn.prepareStatement(sql);
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next())
				{
				chitiet ct = new chitiet();
					
				ct.setTenSach(rs.getString("TenSach"));
				ct.setTenKhachHang(rs.getString("Ten"));
				ct.setHinhAnh(rs.getString("HinhAnh"));
				ct.setHanTra(rs.getString("HanMuon"));
				ct.setNgayDat(rs.getString("NgayMuon"));
				ct.setMaMuon(rs.getString("MaMuon"));
				ct.setDiachi(rs.getString("diachi"));
				ct.setStd(rs.getString("sdt"));
				ct.setTinhTrang(rs.getInt("tinhtrang"));
				
				 list.add(ct);
				}
				return list;
		}
		return list;
	}
	
	public static List<chitiet> Search(String mamuon, String ten, String tensach) throws SQLException
	{
		
		Connection cnn = connect.open();
	
		List<chitiet> list = new ArrayList<>();
		if(cnn!=null)
		{		
					PreparedStatement ps;
					
					if(!mamuon.equalsIgnoreCase("") && !ten.equalsIgnoreCase("") && !tensach.equalsIgnoreCase(""))
					{
						String sql2 = "select * from [chitiet] where 1=1 and mamuon like ?";
						ps = cnn.prepareStatement(sql2);
						ps.setString(1, "%" + mamuon + "%");
						System.out.println(sql2+"   2");
					}
					else if(!mamuon.equalsIgnoreCase("") && !ten.equalsIgnoreCase(""))
					{
						String sql2 = "select * from [chitiet] where 1=1 and mamuon like ?";
						ps = cnn.prepareStatement(sql2);
						ps.setString(1, "%" + mamuon + "%");
						System.out.println(sql2+"   2");
					}
					else if(!mamuon.equalsIgnoreCase("") && !tensach.equalsIgnoreCase(""))
					{
						String sql2 = "select * from [chitiet] where 1=1 and mamuon like ?";
						ps = cnn.prepareStatement(sql2);
						ps.setString(1, "%" + mamuon + "%");
						System.out.println(sql2+"   2");
					}
					else if(!tensach.equalsIgnoreCase("") && !ten.equalsIgnoreCase(""))
					{
						String sql3 = "select * from [chitiet] where 1=1 and tensach like ? and ten like ?";
						ps = cnn.prepareStatement(sql3);
						ps.setString(1,  "%" + tensach + "%");
						ps.setString(2,  "%" + ten + "%");
						System.out.println(sql3+"   3");
					}
					else if(!mamuon.equalsIgnoreCase(""))
					{
						String sql2 = "select * from [chitiet] where 1=1 and mamuon like ?";
						ps = cnn.prepareStatement(sql2);
						ps.setString(1, "%" + mamuon + "%");
						System.out.println(sql2+"   2");
					}
					else if(!ten.equalsIgnoreCase(""))
					{
						String sql2 = "select * from [chitiet] where 1=1 and ten like ?";
						ps = cnn.prepareStatement(sql2);
						ps.setString(1, "%" + ten + "%");
						System.out.println(sql2+"   2");
					}
					else if(!tensach.equalsIgnoreCase(""))
					{
						String sql2 = "select * from [chitiet] where 1=1 and tensach like ?";
						ps = cnn.prepareStatement(sql2);
						ps.setString(1, "%" + tensach + "%");
						System.out.println(sql2+"   2");
					}					
					else
					{
						 return list;
					}
					
					ResultSet rs = ps.executeQuery();
					while(rs.next())
					{
					chitiet ct = new chitiet();
						
						ct.setTenSach(rs.getString("TenSach"));
						ct.setTenKhachHang(rs.getString("Ten"));
						ct.setHinhAnh(rs.getString("HinhAnh"));
						ct.setHanTra(rs.getString("HanMuon"));
						ct.setNgayDat(rs.getString("NgayMuon"));
						ct.setMaMuon(rs.getString("MaMuon"));
						ct.setDiachi(rs.getString("diachi"));
						ct.setStd(rs.getString("sdt"));
						ct.setTinhTrang(rs.getInt("tinhtrang"));
					
					 list.add(ct);
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
