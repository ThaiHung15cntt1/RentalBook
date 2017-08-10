<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>sanpham</title>

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


	<link href="https://fonts.googleapis.com/css?family=Open+Sans+Condensed:300" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Gudea|Open+Sans+Condensed:300" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=BenchNine" rel="stylesheet">>


	<link rel="stylesheet" type="text/css" href="css/Rental.css">
	<link rel="stylesheet" type="text/css" href="css/detail.css">

</head>
<body>

<%@ include file="include/userNAV.jsp"%>

<div class="container detail">
	<div class="row">
		<div class="col-sm-4">
			<img class="imgdetail" src="hinhanh/<c:out value="${s.getHinhAnh()}"></c:out>">
		</div>
		<div class="textdetail col-sm-8">
			<h3>${s.getTenSach()}</h3>
			<hr>
			<p>Tác giả: ${s.getTacGia()}</p>
			<p>Năm xuất bản: ${s.getNamSB()}</p>
			<br>
			<div class="row dat">
				<div class="form-group btn-detail col-sm-5">
					<a href="set_order?masach=${s.getMaSach()}">
						<span class="lnr lnr-cart"></span>
						<button type="submit" class="btn-chon">Đặt</button>
					</a>
				</div>
				
			</div>
			<div class="row">
				<div class="col-sm-6">
					<p class="text-warning">${message}</p>
				</div>
				<div class="col-sm-6"></div>
			</div>
		</div>
	</div>
</div>

</body>
</html>