<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Home</title>

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
<div class="container-fluid jumbotron"></div>
<%@ include file="include/userNAV.jsp"%>

<div class="container">
		<section id="main"  class="section main">
			<div class="container">
				<div class="row">
					<div class="col-md-7">
						<div class="lp-element">
							<h1 data-scroll-reveal="wait 0.25s, then enter top and move 40px over 1s">FREE BOOKS</h1>
                                                <div class="blackdiv"  data-scroll-reveal="wait 0.35s, then enter left and move 40px over 1s">
                                                <p class="mainp">Để nói lời có cánh với người yêu cần viện vài câu trong sách, để trả bài ông thầy cũng cần sách, đôi khi nấu ăn cũng cần sách. Chúng ta cần sách, nhưng để đọc hết sách là bất khả</p>
                                                </div>
						<p  data-scroll-reveal="wait 0.35s, then enter left and move 40px over 1s"><a class="btn btn-default" href="login.jsp" id="btn-login" role="button" data-scroll-reveal="wait 0.25s, then enter top and move 40px over 1s">Dang Nhap</a>
						 <a class="btn btn-default" id="btn-Signin" href="dangky.jsp" role="button" data-scroll-reveal="wait 0.25s, then enter left and move 40px over 1s">Dang Ky</a></p>
					</div>
				</div>
				<div class="col-md-5"></div>
			</div>
		</section>
	</div>


<div class="container-fluid product" id="product">
<h2>----------------SÁCH---------------</h2>
	<div class="container">
	
	
	<c:forEach var="list" items="${list}">
		
			<div class="col-md-3">
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


<div class="footer"></div>
</body>
</html>