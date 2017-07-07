<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head lang="en">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Index loged</title>
        <link rel="stylesheet" type="text/css" href="index.css"> 
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js?ver=1.4.2"></script>
    </head>
<body>
<div class="container">
        
    <header>
        <nav><!--
            <li><a href="#"><h1>Header</h1></a></li>-->
            <form action = "Main" method="GET" id="home">
              <input type="hidden" name="action" value="go_home">
              <!--<input type="submit" value="Home"/>-->
              <div class ="text_order_color" >
                <a href="#"  onclick="document.getElementById('home').submit(); return false;">
                  <h2>Home</h2>
                </a>
              </div>
            </form>
            
           <!-- <li><a href="#">Link</a></li>
            <form name="val_form" action="MainServlet" method="POST" onsubmit="return validate_form ( );">
                  <input type="hidden" value="login" name="action" />
            Login:    <input type="text" name="login" /><br>
            Password: <input type="password" name="pass" />
            <input type="submit" onClick="return Formdata(this.form)" value="Log In" />--> 
            
        </nav>
        <div class="greeting">
                    Welcome <c:out value="${user_data}" />
        </div>

        <form name="val_form" action="Main" method="GET" >
                  <input type="hidden" value="logout" name="action" />
                  <!--<input type="submit" onClick="return Formdata(this.form)" value="Log out" /> -->
                  <button class="go_search" onClick="return Formdata(this.form)" id="logout" >logout</button>
        </form>
    </header>

    <div class="main-and-sidebar-wrapper"> 
        <section class="main">
            <!--<h2>FLEW ONCE IMPRESSIONS FOREVER </h2>-->  
            
            <h2>Easy Fly </h2>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <div class="search_frame">
            <form name="go_search" action="Main" method="GET" id="go">
                <input type="hidden" name="action" value="go_search">
                    <select class="from" on value="direction_from" name="direction_from" required>from</option>
                                <option selected disabled hidden>from...</option>
                                <c:forEach var="item" items="${list_directions}">
                                    <option class="from">
                                    <c:out value="${item.getDirectionCity()}"/>
                                    </option>
                                </c:forEach>
                    </select>
                    <select class="from" on value="direction_to" name="direction_to" required>to</option>
                                <option selected disabled hidden>to...</option>
                                <c:forEach var="item" items="${list_directions}">
                                    <option class="from">
                                        <c:out value="${item.getDirectionCity()}"/>
                                    </option>
                                </c:forEach>
                    </select>
                <input class="search_flight_date" type="date" name="departure_date" id="departure_date">
                <input class="search_flight_date" type="date" name="arrival_date" id="arrival_date">
                <button class="go_search" id="go_search" >Go</button>
            </form>
            </div>
            <br>
            <br>
        </section> 

    </div>
	    <footer>
	        <h3>Contact us</h3>
	        <p>Copyright 2017 © mazets_anton@tut.by</p>
	    </footer>
	</div>
	


   <script type="text/javascript"> <!--
        function validate_form() {
            valid = true;
            if (document.val_form.login.value == "") {
                alert("Пожалуйста заполните поле 'Login'.");
                valid = false;
                return valid;
            }
            if (document.val_form.pass.value == "") {
                alert("Пожалуйста заполните поле 'Password'.");
                valid = false;
            return valid;
            }
        }
   </script>

    <script>
        // Get the modal
        var modal = document.getElementById('myPopUp');

        // Get the button that opens the modal
        var btn = document.getElementById("myBtn");

        // Get the <span> element that closes the modal
        var span = document.getElementsByClassName("close")[0];

        // When the user clicks the button, open the modal 
        btn.onclick = function() {
            modal.style.display = "block";
        }

        // When the user clicks on <span> (x), close the modal
        span.onclick = function() {
            modal.style.display = "none";
        }

        // When the user clicks anywhere outside of the modal, close it
        window.onclick = function(event) {
            if (event.target == modal) {
                modal.style.display = "none";
            }
        }
    </script>
</body>
</html>