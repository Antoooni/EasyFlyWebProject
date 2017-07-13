<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Registration</title>

    <link rel="stylesheet" type="text/css" href="registration.css" />
    <style>
        @import url(registration_files/formoid1/formoid-solid-red.css);
    </style>
    <!--<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js?ver=1.4.2"></script>-->
</head>
<body class="blurBg-false" style="background-color:#EBEBEB">


<div class="container_flights_list">
    <header>
        <nav>
        <form action = "Main" method="GET" id="home">
              <input type="hidden" name="action" value="go_home">
              <!--<input type="submit" value="Home"/>-->
              <div class ="text_order_color" >
                <a href="#"  onclick="document.getElementById('home').submit(); return false;">
                  <h2>Home</h2>
                </a>
              </div>
          </form>
        </nav>
    </header>

    <div class="main-and-sidebar-wrapper"> 
<!-- Start Formoid form-->
      <!--<link rel="stylesheet" href="formoid_files/formoid1/formoid-solid-red.css" type="text/css" />-->
      
          <h2>Registration success!</h2>
        

	    <footer>
	        <h3>Contact us</h3>
	        <p>Copyright 2017 © mazets_anton@tut.by</p>
	    </footer>
	</div>
</body>
</html>