<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>ListOrderComplete </title>
</head>
<body>
<%@ include file="include/adminNAV.jsp"%>


<div class="container">
		<div class="row">
		<form action="set_adminListOrderComSearch" method="get">
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
	
	<table class="table table-striped table-hover" style="margin-top: 35px">
	  <thead>
	  <c:if test="${bit!=0}">
	    <tr  class="success">
	      <th>Mã Đơn Hàng</th>
	      <th>Tên sách</th>
	      <th>Tên Đăng Nhâp</th>
	      <th>Tên Khách Hàng</th>
	      <th>Dịa Chỉ</th>
	      <th>SĐT</th>
	      <th>Ngày Trả</th>
	    </tr>
	    </c:if>
	  </thead>
	  <tbody>
	  <c:forEach var="listordercom" items="${sessionScope.listordercom}">
	    <tr>
	      <td><c:out value="${listordercom.getMatra()}"></c:out></td>
	      <td><c:out value="${listordercom.getTensach()}"></c:out></td>      
	      <td><c:out value="${listordercom.getTendangnhap()}"></c:out></td>
	      <td><c:out value="${listordercom.getTenkhachhang()}"></c:out></td>
	      <td><c:out value="${listordercom.getDiachi()}"></c:out></td>
	      <td><c:out value="${listordercom.getSdt()}"></c:out></td>
	      <td><c:out value="${listordercom.getNgaytra()}"></c:out></td>
	    </tr>
	   </c:forEach>
	  </tbody>
	</table> 
	
</div>

<div class="container">
	<table class="table table-striped table-hover" style="margin-top: 35px">
	  <thead>
	    <tr  class="info">
	      <th>Mã Đơn Hàng</th>
	      <th>Tên sách</th>
	      <th>Tên Đăng Nhâp</th>
	      <th>Tên Khách Hàng</th>
	      <th>Dịa Chỉ</th>
	      <th>SĐT</th>
	      <th>Ngày Trả</th>
	    </tr>
	  </thead>
	  <tbody>
	  <c:forEach var="list" items="${list}">
	    <tr>
	      <td><c:out value="${list.getMatra()}"></c:out></td>
	      <td><c:out value="${list.getTensach()}"></c:out></td>      
	      <td><c:out value="${list.getTendangnhap()}"></c:out></td>
	      <td><c:out value="${list.getTenkhachhang()}"></c:out></td>
	      <td><c:out value="${list.getDiachi()}"></c:out></td>
	      <td><c:out value="${list.getSdt()}"></c:out></td>
	      <td><c:out value="${list.getNgaytra()}"></c:out></td>
	    </tr>
	   </c:forEach>
	  </tbody>
	</table> 
</div>
</body>
</html>