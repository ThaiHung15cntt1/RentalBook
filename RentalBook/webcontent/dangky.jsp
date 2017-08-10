<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Dang Ky</title>
<link rel="stylesheet" type="text/css" href="css/lumen.css">
</head>
<body>
	<div class="container">
		<form class="form-horizontal" action="dangky_controller" method="post">
		<legend>Dang Ky</legend>
  <fieldset style="width: 40%">
    
    <div class="form-group">
      <label  class="col-lg-3 control-label">Ho va ten</label>
      <div class="col-lg-9">
        <input type="text" class="form-control" name="Ten" placeholder="Ho va ten">
      </div>
    </div>
    <div class="form-group">
      <label  class="col-lg-3 control-label">Ngay sinh</label>
      <div class="col-lg-9">
        <input type="text" class="form-control" name="NgaySinh" placeholder="Ngay sinh">
      </div>
    </div>
    
     <div class="form-group">
      <label  class="col-lg-3 control-label" >Dia chi</label>
      <div class="col-lg-9">
        <input type="text" class="form-control" name="DiaChi" placeholder="Dia chi">
      </div>
    </div>
 
	 <div class="form-group">
      <label  class="col-lg-3 control-label" >So dien thoai</label>
      <div class="col-lg-9">
        <input type="text" class="form-control" name="Sdt" placeholder="So dien thoai">
      </div>
    </div> 
 
 	 <div class="form-group">
      <label  class="col-lg-3 control-label">Ten dang nhap</label>
      <div class="col-lg-9">
        <input type="text" class="form-control" name="TenDangNhap" placeholder="Ten dang nhap">
      </div>
    </div>
 
 	 <div class="form-group">
      <label class="col-lg-3 control-label" >Mat khau</label>
      <div class="col-lg-9">
        <input type="password" class="form-control" name="MatKhau" placeholder="Mat khau">
      </div>
    </div>
    
    
    <h3 class="text-success">${message}</h3>
    <h3 class="text-warning">${message_warning}</h3>
    
    <div class="form-group row" style="margin-top: 5rem">
      <div class="col-lg-12 col-lg-offset-2">
      	<div>
      		<button type="submit" name="submit" value="dangky" class="btn btn-success col-sm-4">Dang ky</button>
      	</div>
        <div>
        	<button type="submit" name="submit" value="dangnhap" class="btn btn-primary col-sm-4">Dang Nhap</button>
        </div>
        
      </div>
    </div>
  </fieldset>
</form>
	</div>
	

</body>
</html>