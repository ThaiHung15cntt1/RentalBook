<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Insert title here</title>


</head>
<body>


	


	<nav class="navbar navbar-default one-edge-shadow navbar-fixed-top">
	<div class="container-fluid logo">
		<div class="container">
			<bottom class="btn btn-default">
			<p><strong>F</strong> r e e</p> 
			<p id="p"><strong>B</strong> o o k</p>
			</bottom>
		</div>
</div>
	</form>
	</div>
  
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>	
		</div>
		  <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
      	
        <li>
	        <c:if test="${sessionScope.tendangnhap != null}">
	    		<a href="set_account"><c:out value="${sessionScope.tendangnhap}"></c:out></a>
			</c:if>
			
       </li>
        <li><a href="logout_controller">
        	<c:if test="${sessionScope.tendangnhap != null}">
	    		ĐĂNG XUẤT
			</c:if>
        </a></li>
      </ul>

       <ul class="nav navbar-nav navbar-left">
        <li><a href="set_home">TRANG CHỦ</a></li>
        <li><a href="#product">SÁCH</a></li>
      </ul>
    	<form class="navbar-form navbar-left" role="search" action="set_userProductSearch" method="get">
	        <div class="form-group">
	          	<input type="text" id="text-search" name="key" value="">
	          	<button type="submit" id="btn-search">TÌM</button>
	        </div>
	        	
      </form>

    </div>
	</div>
</nav>


</body>
</html>