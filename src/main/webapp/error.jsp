<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Error</title>
    <link rel="stylesheet" type="text/css" href="index.css"> 
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js?ver=1.4.2"></script>
</head>
<body>


<div class="container">
        
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
           <!-- <div class="circle">
            <li><a href="#">Ru</a></li>
            </div>-->
           <!-- <li><a href="#">Link</a></li>
            <form name="val_form" action="MainServlet" method="POST" onsubmit="return validate_form ( );">
                  <input type="hidden" value="login" name="action" />
            Login:    <input type="text" name="login" /><br>
            Password: <input type="password" name="pass" />
            <input type="submit" onClick="return Formdata(this.form)" value="Log In" />--> 
            
        </nav>

        <!--<button id="myBtn" >LOG IN</button>-->

        <!--<div id="myPopUp" class="modal">

              <!--Modal content -->
              <!-- <div class="modal-content">
                <span class="close">&times;</span>
                <p>
                    <form name="val_form" action="Main" method="POST"  onsubmit="return validate_form ( );">
                        <input type ="hidden" value="login" name="action" />
                            <div class="auth1">
                                <div class="auth">
                                    <label for="l">Login:</label>
                                    <input class="popupText" from type="text" name="login" id="l" /><br>
                                </div>
                                <div class="auth">
                                    <label for="p">Password:</label>
                                    <input class="popupText" type="password" name="pass" id="p" />
                                </div>
                            </div>
                                <div class="auth_button"> <br><br><br>
                                <input type="submit" onClick="return Formdata(this.form)" value="Log In" />
                            </div>
                    </form>
                </p>
              </div>
        </div> --> 
    </header>

    <div class="main-and-sidebar-wrapper"> 
        <section class="main">
            <!--<h2>FLEW ONCE IMPRESSIONS FOREVER </h2>-->  
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
            <br>
            <br>
            <br>
            <br>
            <br>
            <div class="search_frame">
            <h3>Oops:( Something wrong...</h3>
            <a>Probably this user does not exist</a> 
                <!--<select class="from" on value="volvo">from</option>
                          <option value="saab">MOW</option>
                          <option value="mercedes">LAX</option>
                          <option value="audi">WAR</option>
                </select>
                <select class="from" on value="volvo">to</option>
                          <option value="saab">MOW</option>
                          <option value="mercedes">LAX</option>
                          <option value="audi">WAR</option>
                </select>
                <input class="search_flight_date" type="date">
                <input class="search_flight_date" type="date">
                <button class="go_search" id="go_search" >Go</button>-->
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