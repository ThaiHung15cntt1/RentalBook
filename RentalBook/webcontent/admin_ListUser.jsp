<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>List User</title>
<link rel="stylesheet" type="text/css" href="css/lumen.css">
</head>
<body>
<%@ include file="include/adminNAV.jsp"%>

<div class="container">

	<div margin-top: 20px">
		<div class="row">
		<form action="set_adminListUserSearch" method="get">
			<div class="form-group">
				<div class="col-sm-3">
					<input type="text" class="form-control" value="" name="tendangnhap" placeholder="Ten dang nhap">
				</div>
				<div class="col-sm-3">
					<input type="text" class="form-control" value="" name="ten" placeholder="Ten">
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
	    <tr  class="success">
	      <th>Ten dang nhap</th>
	      <th>Ten</th>
	      <th>Ngay sinh</th>
	      <th>Dia chi</th>
	      <th>sdt</th>
	      <th>Trang thai</th>
	      <th></th>
	      <th></th>
	    </tr>
	   </c:if>
	    
	  </thead>
	  <tbody>
	  <c:forEach var="list" items="${sessionScope.lists}">
	    <tr>
	      <td><c:out value="${list.getTenDangNhap()}"></c:out></td>
	      <td><c:out value="${list.getTen()}"></c:out></td>
	      <td><c:out value="${list.getNgaySinh()}"></c:out></td>
	      <td><c:out value="${list.getDiaChi()}"></c:out></td>	      
	      <td><c:out value="${list.getSdt()}"></c:out></td>
	      <td><c:out value="${list.getTrangThai()}"></c:out></td>
	      <div>
		      <th><a href="setUpdateUser_controller?id=${list.getTenDangNhap()}"><buttom type="submit" class="btn btn-primary btn-sm" style="width:70px">sua</buttom></a></th>
		      <th><a href="deleteUser_controller?id=${list.getTenDangNhap()}"><buttom type="submit" class="btn btn-danger btn-sm" style="width:70px">xoa</buttom></a></th>
	      </div>
	    </tr>
	   </c:forEach>
	  </tbody>
	</table> 
	
</div>



<div class="container">
	<table class="table table-striped table-hover" style="margin-top: 35px">
	  <thead>
	    <tr  class="info">
	      <th>Ten dang nhap</th>
	      <th>Ten</th>
	      <th>Ngay sinh</th>
	      <th>Dia chi</th>
	      <th>sdt</th>
	      <th>Trang thai</th>
	      <th></th>
	      <th></th>
	    </tr>
	  </thead>
	  <tbody>
	  <c:forEach var="list" items="${list}">
	    <tr>
	      <td><c:out value="${list.getTenDangNhap()}"></c:out></td>
	      <td><c:out value="${list.getTen()}"></c:out></td>
	      <td><c:out value="${list.getNgaySinh()}"></c:out></td>
	      <td><c:out value="${list.getDiaChi()}"></c:out></td>	      
	      <td><c:out value="${list.getSdt()}"></c:out></td>
	      <td><c:out value="${list.getTrangThai()}"></c:out></td>
	      <div>
		      <th><a href="setUpdateUser_controller?id=${list.getTenDangNhap()}"><buttom type="submit" class="btn btn-primary btn-sm" style="width:70px">sua</buttom></a></th>
		      <th><a href="deleteUser_controller?id=${list.getTenDangNhap()}"><buttom type="submit" class="btn btn-danger btn-sm" style="width:70px">xoa</buttom></a></th>
	      </div>
	    </tr>
	   </c:forEach>
	  </tbody>
	</table> 
</div>
</body>
</html>