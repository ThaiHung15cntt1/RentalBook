<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>List Order</title>
<link rel="stylesheet" type="text/css" href="css/lumen.css">

</head>
<body>

<%@ include file="include/adminNAV.jsp"%>

<div class="container">
	<div>
		<div class="row">
		<form action="set_adminListOrderSearch" method="get">
			<div class="form-group">
				<div class="col-sm-3">
					<input type="text" class="form-control" value="" name="madat" placeholder="Ma dat hang">
				</div>
				<div class="col-sm-3">
					<input type="text" class="form-control" value="" name="ten" placeholder="Ten khach hang">
				</div>
				<div class="col-sm-3">
					<input type="text" class="form-control" value="" name="tensach" placeholder="Ten sach">
				</div>
				<div class="col-sm-3">
					<button type="submit" class="btn btn-success" style="width:100px">Search</button>
				</div>
			</div>
		</form>
		</div>
	</div>
	
	<table class="table table-striped table-hover" style="margin-top: 35px">
	  <thead>
	  <c:if test="${bit!=0}">
	    <tr class="success">
	      <th>Sách</th>
	      <th>Mã Đặt</th>
	      <th>Tên Sách</th>
	      <th>Tên Khách Hàng</th>
	      <th>Dịa Chỉ</th>
	      <th>Sđt</th>
	      <th>Ngày Đặt</th>
	      <th>Hạn Trả</th>
	      <th></th>
	    </tr>
	   </c:if>
	  </thead>
	  <tbody>
		 <c:forEach var="listorder" items="${sessionScope.listorder}">
	    <tr>
	     <td><img src="hinhanh/<c:out value="${listorder.getHinhAnh()}"></c:out>"  height="130px" width="100px"></td>
	      <td><c:out value="${listorder.getMaMuon()}"></c:out></td>
	      <td><c:out value="${listorder.getTenSach()}"></c:out></td>      
	      <td><c:out value="${listorder.getTenKhachHang()}"></c:out></td>
	      <td><c:out value="${listorder.getDiaChi()}"></c:out></td>
	      <td><c:out value="${listorder.getSdt()}"></c:out></td>
	      <td><c:out value="${listorder.getNgayDat()}"></c:out></td>
	      <td><c:out value="${listorder.getHanTra()}"></c:out></td>
	     
	     <c:if test="${listorder.getTinhTrang()==0}">
	      <div>
		      <th><a href="nhan_contoller?mamuon=${listorder.getMaMuon()}"><buttom type="submit" class="btn btn-danger btn-sm" style="width:70px">Nhận</buttom> </a></th>
	      </div>
	      </c:if>
	      <c:if test="${listorder.getTinhTrang()==1}">
	      <div>
		      <th><a href="tra_controller?mamuon=${listorder.getMaMuon()}"><buttom type="submit" class="btn btn-danger btn-sm" style="width:70px">Trả</buttom> </a></th>
	      </div>
	      </c:if>
	      
	    </tr>
	     </c:forEach>
	  </tbody>
	</table> 
</div>	
	

<div class="container order">

	<table class="table table-striped table-hover" style="margin-top: 35px">
	  <thead>
	    <tr  class="info">
	      <th>Sách</th>
	       <th>Mã Đặt</th>
	      <th>Tên Sách</th>
	      <th>Tên Khách Hàng</th>
	      <th>Dịa Chỉ</th>
	      <th>Sđt</th>
	      <th>Ngày Đặt</th>
	      <th>Hạn Trả</th>
	      <th></th>
	      
	    </tr>
	  </thead>
	  <tbody>
		 <c:forEach var="list" items="${list}">
	    <tr>
	     <td><img src="hinhanh/<c:out value="${list.getHinhAnh()}"></c:out>"  height="130px" width="100px"></td>
	      <td>${list.getMaMuon()}</td>
	      <td>${list.getTenSach()}</td>      
	      <td>${list.getTenKhachHang()}</td>
	      <td>${list.getDiaChi()}</td>
	      <td>${list.getSdt()}</td>
	      <td>${list.getNgayDat()}</td>
	      <td>${list.getHanTra()}</td>
	     
	     <c:if test="${list.getTinhTrang()==0}">
	      <div>
		      <th><a href="nhan_contoller?mamuon=${list.getMaMuon()}"><buttom type="submit" class="btn btn-danger btn-sm" style="width:70px">Nhận</buttom> </a></th>
	      </div>
	      </c:if>
	      <c:if test="${list.getTinhTrang()==1}">
	      <div>
		      <th><a href="tra_controller?mamuon=${list.getMaMuon()}"><buttom type="submit" class="btn btn-danger btn-sm" style="width:70px">Trả</buttom> </a></th>
	      </div>
	      </c:if>
	    </tr>
	     </c:forEach>
	  </tbody>
	</table> 
	  
</div>
</body>
</html>