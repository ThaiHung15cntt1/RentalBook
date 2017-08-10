<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Update</title>
<link rel="stylesheet" type="text/css" href="css/lumen.css">
</head>
<body>
<%@ include file="include/adminNAV.jsp"%>

	
	
	<div class="container">
		<form class="form-horizontal" action="updateUser_controller" method="get">
		<legend>Can nhat</legend>
  <fieldset style="width: 40%">
  
    <c:set var="kh" value="${kh}"></c:set>
    
    <div class="form-group">
      <label  class="col-lg-3 control-label">Ho va ten</label>
      <div class="col-lg-9">
        <input type="text" class="form-control"  value='<c:out value="${kh.getTen()}"></c:out>' name="Ten" placeholder="Ho va ten">
      </div>
    </div>
    <div class="form-group">
      <label  class="col-lg-3 control-label">Ngay sinh</label>
      <div class="col-lg-9">
        <input type="text" class="form-control"  value='<c:out value="${kh.getNgaySinh()}"></c:out>' name="NgaySinh" placeholder="Ngay sinh">
      </div>
    </div>
    
     <div class="form-group">
      <label  class="col-lg-3 control-label" >Dia chi</label>
      <div class="col-lg-9">
        <input type="text" class="form-control" " value='<c:out value="${kh.getDiaChi()}"></c:out>' name="DiaChi" placeholder="Dia chi">
      </div>
    </div>
 
	 <div class="form-group">
      <label  class="col-lg-3 control-label" >So dien thoai</label>
      <div class="col-lg-9">
        <input type="text" class="form-control"   value='<c:out value="${kh.getSdt()}"></c:out>' name="Sdt" placeholder="So dien thoai">
      </div>
    </div> 
 
 	 <div class="form-group">
      <label  class="col-lg-3 control-label">Ten dang nhap</label>
      <div class="col-lg-9">
        <input type="text" class="form-control" value='<c:out value="${kh.getTenDangNhap()}"></c:out>' name="TenDangNhap" placeholder="Ten dang nhap">
      </div>
    </div>
 
 	 <div class="form-group">
      <label class="col-lg-3 control-label">Mat khau</label>
      <div class="col-lg-9">
        <input type="text" class="form-control" value='<c:out value="${kh.getMatKhau()}"></c:out>' name="MatKhau" placeholder="Mat khau">
      </div>
    </div>
    
    <h3 class="text-success">${message}</h3>
    <h3 class="text-warning">${message_warning}</h3>
  
    <div class="form-group row" style="margin-top: 5rem">
      <div class="col-lg-12 col-lg-offset-2">
      	<div>
      		<button type="submit" value="capnhat" name="submit" class="btn btn-success col-sm-4">Sua</button>
      		<script>
				function goBack() {
				    window.history.back();
				}
			</script>
      		<button onclick="goBack()" type="submit" value="quaylai" name="submit" class="btn btn-primary col-sm-4">Quay lai</button>
      	</div>
      </div>
    </div>
  </fieldset>
</form>
	</div>
	
</body>
</html>