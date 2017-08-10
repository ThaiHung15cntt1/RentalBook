<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Insert book</title>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/lumen.css">
</head>
<body>
<%@ include file="include/adminNAV.jsp"%>
	<script>
	$(function() {

		  // We can attach the `fileselect` event to all file inputs on the page
		  $(document).on('change', ':file', function() {
		    var input = $(this),
		        numFiles = input.get(0).files ? input.get(0).files.length : 1,
		        label = input.val().replace(/\\/g, '/').replace(/.*\//, '');
		    input.trigger('fileselect', [numFiles, label]);
		  });

		  // We can watch for our custom `fileselect` event like this
		  $(document).ready( function() {
		      $(':file').on('fileselect', function(event, numFiles, label) {

		          var input = $(this).parents('.input-group').find(':text'),
		              log = numFiles > 1 ? numFiles + ' files selected' : label;

		          if( input.length ) {
		              input.val(log);
		          } else {
		              if( log ) alert(log);
		          }

		      });
		  });
		  
		});
	</script>
	
	<div class="container">
		<form class="form-horizontal" action="insertBook_controller" method="post">
		<legend>Them moi sach</legend>
  <fieldset style="width: 40%">
    
    <div class="form-group">
      <label  class="col-lg-3 control-label">Ma sach</label>
      <div class="col-lg-9">
        <input type="text" class="form-control" name="MaSach" placeholder="Ma sach">
      </div>
    </div>
    <div class="form-group">
      <label  class="col-lg-3 control-label">Ten sach</label>
      <div class="col-lg-9">
        <input type="text" class="form-control" name="TenSach" placeholder="Ten sach">
      </div>
    </div>
    
     <div class="form-group">
      <label  class="col-lg-3 control-label" >Tac gia</label>
      <div class="col-lg-9">
        <input type="text" class="form-control" name="TacGia" placeholder="Tac gia">
      </div>
    </div>
 
	 <div class="form-group">
      <label  class="col-lg-3 control-label">Nam xuat ban</label>
      <div class="col-lg-9">
        <input type="text" class="form-control" name="NamSB" placeholder="Nam xuat ban">
      </div>
    </div> 
 
 
 
    <div class="form-group">
      <label class="col-lg-3 control-label">So luong</label>
      <div class="col-lg-9">
        <input type="text" class="form-control" name="SoLuong" placeholder="So luong">
      </div>
    </div>
 
 	
	     
      <div class="input-group">
      	<label class="input-group-btn">
      <span class="btn btn-primary">
        Browse&hellip; <input type="file" style="display: none;" multiple>
      </span>
      </label>
      	<input type="text" name="HinhAnh" class="form-control col-lg-7" readonly>
      </div>

    
    <h3 class="text-success">${message}</h3>
    <h3 class="text-warning">${message_warning}</h3>
    
    <div class="form-group row" style="margin-top: 5rem">
      <div class="col-lg-12 col-lg-offset-2">
      	<div>
      		<button type="submit" name="submit" value="themmoi" class="btn btn-success col-sm-4">Them moi</button>
      	</div>
        <div>
        	<button type="submit" name="submit" value="quaylai" class="btn btn-primary col-sm-4">Quay lai</button>
        </div>
        
      </div>
    </div>
  </fieldset>
</form>
	</div>
	

</body>
</html>