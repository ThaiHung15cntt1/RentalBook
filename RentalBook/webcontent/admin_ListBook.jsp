<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>List Books</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>List Order</title>
</head>
<body>
<%@ include file="include/adminNAV.jsp"%>



<div class="container">
		<div class="row">
		<form action="set_adminListBookSearch" method="get">
			<div class="form-group">
				<div class="col-sm-3">
					<input type="text" class="form-control" value="" name="masach" placeholder="Ma sach">
				</div>
				<div class="col-sm-3">
					<input type="text" class="form-control" value="" name="tensach" placeholder="Ten sach">
				</div>
				<div class="col-sm-3">
					<input type="text" class="form-control" value="" name="tacgia" placeholder="Tac gia">
				</div>
				<div class="col-sm-3">
					<button type="submit" class="btn btn-success" style="width:100px">Search</button>
				</div>
			</div>		
		</form>
		</div>
	
	
	<table class="table table-striped table-hover" style="margin-top: 35px">
	  <thead>
	  <c:if test="${bit!=0}">
	    <tr  class="success">
	      <th>Hinh anh</th>
	      <th>Ma sach</th>
	      <th>Ten sach</th>
	      <th>Tac gia</th>
	      <th>Nam xuat ban</th>
	      <th>Hinh anh</th>
	      <th>Dang cho muon</th>
	      <th>So luong</th>
	      <th></th>
	      <th></th>
	    </tr>
	    </c:if>
	  </thead>
	  <tbody>
	  <c:forEach var="listbook" items="${sessionScope.listbook}">
	    <tr>
	      <td><img src="hinhanh/<c:out value="${listbook.getHinhAnh()}"></c:out>" height="130px" width="100px"></td>
	      <td><c:out value="${listbook.getMaSach()}"></c:out></td>
	      <td><c:out value="${listbook.getTenSach()}"></c:out></td>
	      <td><c:out value="${listbook.getTacGia()}"></c:out></td>
	      <td><c:out value="${listbook.getNamSB()}"></c:out></td>	      
	      <td><c:out value="${listbook.getHinhAnh()}"></c:out></td>
	      <td><c:out value="${listbook.getDuocMuon()}"></c:out></td>
	      <td><c:out value="${listbook.getSoLuong()}"></c:out></td>
	      <div>
		      <th><a href="setUpdateBook_controller?id=${listbook.getMaSach()}"><buttom type="submit" class="btn btn-primary btn-sm" style="width:70px">sua</buttom></a></th>
		      <th><a href="deleteBook_controller?id=${listbook.getMaSach()}"><buttom type="submit" class="btn btn-danger btn-sm" style="width:70px">Xoa</buttom> </a></th>
		     
	      </div>
	    </tr>
	   </c:forEach>
	  </tbody>
	</table> 
	
</div>

<div class="container">
 	<th><a href="insertBook.jsp"><buttom type="submit" class="btn btn-primary btn-xs" style="margin-top:20px;width:15rem">Them</buttom></a></th>
</div>

<div class="container">
	<table class="table table-striped table-hover" style="margin-top: 35px">
	  <thead>
	    <tr  class="info">
	      <th>Hinh anh</th>
	      <th>Ma sach</th>
	      <th>Ten sach</th>
	      <th>Tac gia</th>
	      <th>Nam xuat ban</th>
	      <th>Hinh anh</th>
	      <th>Dang cho muon</th>
	      <th>So luong</th>
	      <th></th>
	      <th></th>
	    </tr>
	  </thead>
	  <tbody>
	  <c:forEach var="list" items="${list}">
	    <tr>
	      <td><img src="hinhanh/<c:out value="${list.getHinhAnh()}"></c:out>" height="130px" width="100px"></td>
	      <td><c:out value="${list.getMaSach()}"></c:out></td>
	      <td><c:out value="${list.getTenSach()}"></c:out></td>
	      <td><c:out value="${list.getTacGia()}"></c:out></td>
	      <td><c:out value="${list.getNamSB()}"></c:out></td>	      
	      <td><c:out value="${list.getHinhAnh()}"></c:out></td>
	      <td><c:out value="${list.getDuocMuon()}"></c:out></td>
	      <td><c:out value="${list.getSoLuong()}"></c:out></td>
	      <div>
		      <th><a href="setUpdateBook_controller?id=${list.getMaSach()}"><buttom type="submit" class="btn btn-primary btn-sm" style="width:70px">sua</buttom></a></th>
		      <th><a href="deleteBook_controller?id=${list.getMaSach()}"><buttom type="submit" class="btn btn-danger btn-sm" style="width:70px">Xoa</buttom> </a></th>
		     
	      </div>
	    </tr>
	   </c:forEach>
	  </tbody>
	</table> 
</div>
</body>
</html>