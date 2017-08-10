<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Insert title here</title>

<link rel="stylesheet" href="css/lumen.css">

</head>
<body>
	<div class="container"
		style="width: 400px; height: auto; text-align: center; margin-top: 50px">
		<form class="form-horizontal" name="form_dangki" action="login_controller" method="post">
			<fieldset>
				<legend>Dang Nhap</legend>
				<div class="form-group">
					<label for="inputEmail" class="col-lg-4 control-label"><strong>Ten dang nhap</strong></label>
					<div class="col-lg-8">
						<input type="text" class="form-control" value="" name="TenDangNhap" placeholder="Ten dang nhap">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword" class="col-lg-4 control-label"><strong>Mat khau</strong></label>
					<div class="col-lg-8">
						<input type="password" class="form-control" value="" name="MatKhau" placeholder="Mat khau">
					</div>
				</div>
			
				<h3 class="text-danger">${message}</h3>
				
				<div class="form-group">
					<div class="col-lg-12">
						<button type="submit" name="submit" value="dangnhap" class="btn btn-primary">Dang Nhap</button>
						<button type="submit" name="submit" value="dangky" class="btn btn-default">Dang Ky</button>
					</div>
				</div>
			</fieldset>
		</form>
		<div class="login"></div>
</body>
</html>