<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Search</title>

	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://cdn.linearicons.com/free/1.0.0/svgembedder.min.js"></script>

	<link href="https://fonts.googleapis.com/css?family=Quicksand" rel="stylesheet">
	<script src="https://cdn.linearicons.com/free/1.0.0/svgembedder.min.js"></script>
	<link href="https://fonts.googleapis.com/css?family=Fira+Sans+Extra+Condensed" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Patrick+Hand" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Just+Another+Hand" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Amatic+SC|Dancing+Script" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=VT323" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Rajdhani" rel="stylesheet">

	<link rel="stylesheet" type="text/css" href="css/Rental.css">
</head>
<body>
<%@ include file="include/userNAV.jsp"%>

<div class="container-fluid product" id="product" style="margin-top: 19rem;">
	<div class="container">
	
	<c:forEach var="list" items="${list}">
		
			<div class="col-md-3" style="margin-top: -10rem;">
				<a href="set_product?masach=${list.getMaSach()}">
					<div class="polaroid container">
					  		<img src="hinhanh/<c:out value="${list.getHinhAnh()}"></c:out>" alt="Norway" style="width:100%">
					  		<div class="middle">
		   						 <div class="text">CHỌN</div>
		 				   	</div>
					    	<p>${list.getTenSach()}</p>
					    	
					</div>
				 </a>
			</div>
			
	</c:forEach>
			
		</div>
	</div>

</body>
</html>