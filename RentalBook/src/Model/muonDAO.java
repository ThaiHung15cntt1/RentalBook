package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class muonDAO {
	public static muon selectONE(String mamuon) throws SQLException
	{
		String sql = "select * from	 [muon] where tendangnhap=?";
		Connection cnn = connect.open();
		muon m = new muon();
		if(cnn!=null)
		{
				PreparedStatement ps = cnn.prepareStatement(sql);
				ps.setString(1, mamuon);
			
				
				ResultSet rs = ps.executeQuery();
				rs.next();
				
				m.setMaMuon(rs.getString("mamuon"));
				m.setMaSach(rs.getString("masach"));			
				m.setTenDangNhap(rs.getString("tendangnhap"));
				m.setNgayMuon(rs.getString("ngaymuon"));
				m.setHanMuon(rs.getString("hanmuon"));
				m.setTinhTrang(rs.getInt("tinhtrang"));
				
				return m;
		
		}
		return m;
	}
	
	
	public static muon selectONEad(String mamuon) throws SQLException
	{
		String sql = "select * from	 [muon] where mamuon=?";
		Connection cnn = connect.open();
		muon m = new muon();
		if(cnn!=null)
		{
				PreparedStatement ps = cnn.prepareStatement(sql);
				ps.setString(1, mamuon);
				
				ResultSet rs = ps.executeQuery();
				rs.next();
				
				m.setMaMuon(rs.getString("mamuon"));
				m.setMaSach(rs.getString("masach"));			
				m.setTenDangNhap(rs.getString("tendangnhap"));
				m.setNgayMuon(rs.getString("ngaymuon"));
				m.setHanMuon(rs.getString("hanmuon"));
				m.setTinhTrang(rs.getInt("tinhtrang"));
				
				return m;
		
		}
		return m;
	}
	
	
	
	public static void insert(muon m) throws SQLException
	{
		Connection cnn = connect.open();
		
		if(cnn!=null)
		{
			String sql ="insert into [muon] values(?,?,?,convert(date, getdate()),dateadd(dd,7,convert(date, getdate())),0)";
			
			PreparedStatement ps = cnn.prepareStatement(sql);
			
				//String uniqueID = UUID.randomUUID().toString();
			
				ps.setString(1, m.getHanMuon());
				ps.setString(2, m.getTenDangNhap());
				ps.setString(3, m.getMaSach());
			
				ps.executeUpdate();
		}
		
	}
	
	
	
	public static void delete(String mamuon) throws SQLException
	{
		Connection cnn = connect.open();
		
		if(cnn!=null)
		{
			String sql = "delete from [muon] where mamuon=?";
			
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.setString(1, mamuon);
			
		    ps.executeUpdate();

		}
	}
	
	
	public static void updateTinhTrangNhan(String mamuon) throws SQLException
	{
		Connection cnn = connect.open();
		
		if(cnn!=null)
		{
			String sql ="update [muon] set tinhtrang=1, ngaymuon=convert(date, getdate()), hanmuon=dateadd(dd,7,convert(date, getdate())) where mamuon=?";
			
			PreparedStatement ps = cnn.prepareStatement(sql);
			
				ps.setString(1,mamuon);
				ps.executeUpdate();
		}
		
	}
	

}
