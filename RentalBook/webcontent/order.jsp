<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	<script src="https://cdn.linearicons.com/free/1.0.0/svgembedder.min.js"></script>
	<link rel="stylesheet" href="https://cdn.linearicons.com/free/1.0.0/icon-font.min.css">

	<link href="https://fonts.googleapis.com/css?family=Quicksand" rel="stylesheet">
	<script src="https://cdn.linearicons.com/free/1.0.0/svgembedder.min.js"></script>
	<link href="https://fonts.googleapis.com/css?family=Fira+Sans+Extra+Condensed" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Patrick+Hand" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Just+Another+Hand" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Amatic+SC|Dancing+Script" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=VT323" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro" rel="stylesheet">
	
	<link rel="stylesheet" type="text/css" href="css/Rental.css">
	
	<style>
		.order{
			margin-top: 20rem;
		}
	</style>
</head>
<body>

<%@ include file="include/userNAV.jsp"%>

<div class="container order">
	<table class="table table-striped table-hover" style="margin-top: 35px">
	  <thead>
	  <c:if test="${ct.getMaMuon()!=null}">
	    <tr  class="info">
	      <th>Sách</th>
	      <th>Mã Đặt</th>
	      <th>Tên Sách</th>
	      <th>Tác Giả</th>
	      <th>Năm Xuất Bản</th>
	      <th>Ngày Đặt</th>
	      <th>Hạn Nhận</th>
	      <c:if test="${ct.getTinhTrang()==0}">
	      <th></th>
	      </c:if>
	         
	    </tr>
	  </thead>
	  <tbody>
	
	    <tr>
	      <td><img src="hinhanh/<c:out value="${ct.getHinhAnh()}"></c:out>" class="imgo"></td>
	      <td><p>${ct.getMaMuon()}<p></p></td>
	      <td>${ct.getTenSach()}</td>
	      <td>${ct.getTacGia()}</td>
	      <td>${ct.getNamSB()}</td>	      
	      <td>${ct.getNgayDat()}</td>
	      <td>${ct.getHanTra()}</td>
	     
	     <c:if test="${ct.getTinhTrang()==0}">
	      <div>
		      <th><a href="deleteOrder_controller?mamuon=${ct.getMaMuon()}"><buttom type="submit" class="btn btn-danger btn-sm" style="width:70px">Hủy</buttom> </a></th>
	      </div>
	      </c:if>
	      
	    </tr>
	   </c:if>
	   <c:if test="${ct.getMaMuon()==null}">
	   		<h3>${message}</h3>
	   </c:if>
	  </tbody>
	</table> 
</div>
</body>
</html>