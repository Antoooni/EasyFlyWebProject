<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Passenger</title>
    <link rel="stylesheet" type="text/css" href="passenger.css"> 
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js?ver=1.4.2"></script>
</head>
<body>


<div class="container_flights_list">
        
    <header>
        <nav>
            <li><a href="#"><h1>Home</h1></a></li>
            
            
           <!-- <li><a href="#">Link</a></li>
            <form name="val_form" action="MainServlet" method="POST" onsubmit="return validate_form ( );">
                  <input type="hidden" value="login" name="action" />
            Login:    <input type="text" name="login" /><br>
            Password: <input type="password" name="pass" />
            <input type="submit" onClick="return Formdata(this.form)" value="Log In" />--> 
            
        </nav>

        

        <div id="myPopUp" class="modal">

              
              
              
        </div>  
    </header>

    <div class="main-and-sidebar-wrapper"> 
        <section class="main">
            <h2>Passenger data </h2>
                <input type="hidden" name="action" value="create_order">
                    <div class="main1">
                      <div class="input_field">
                        <style>#field { text-align: right; }</style>
                        <div class="field" id="field">
                          <label for="name">First name</label>
                            <input class="edit" type="text" name ="first_name" placeholder="first_name" id="first_name"/>
                        </div>
                      </div>

                      <div class="input_field">
                        <style>#field { text-align: right; }</style>
                        <div class="field" id="field">
                          <label for="surname">Surname</label>
                          <input class="edit" type="text" name ="surname" placeholder="surname" id="surname"/>
                        </div>
                      </div>

                      <div class="input_field">
                        <style>#field { text-align: right; }</style>
                        <div class="field" id="field">
                          <label for="middle_name">Middle name</label>
                          <input class="edit" type="text" name ="middle_name" placeholder="middle_name" id="middle_name"/>
                        </div>
                      </div>

                      <div class="input_field">
                        <style>#field { text-align: right; }</style>
                        <div class="field" id="field">
                          <label for="age">Age </label>
                          <input class="edit" type="text" name ="age" placeholder="age" id="age"/>
                        </div>
                      </div>

                      <style>#field { text-align: right; }</style>
                      <div class="field" id="field">
                        <label for="birth_date">Date of birth</label>
                        <input class="edit" type="Date" name ="birth_date" placeholder="birth_date" id="birth_date"/>
                      </div>

                      <div class="input_field">
                        <style>#field { text-align: right; }</style>
                        <div class="field" id="field">
                          <label for="gender">Gender</label>
                          <input class="edit" type="text" name ="gender" placeholder="gender" id="gender"/>
                        </div>
                      </div>

                      <div class="input_field">
                        <style>#field { text-align: right; }</style>
                        <div class="field" id="field">
                          <label for="passport">Passport id</label>
                          <input class="edit" type="text" name ="passport" placeholder="passport" id="passport"/>
                        </div>
                      </div>

                      <div class="input_field">
                        <style>#field { text-align: right; }</style>
                        <div class="field" id="field">
                          <label for="expiry">Passport expiry</label>
                          <input class="edit" type="date" name ="expiry" placeholder="expiry" id="expiry"/>
                        </div>
                      </div>
            
                     <form name="add_passenger" action="Main" method="GET" id="buy_it">
                     
                        <div class="text_passenger_color">
                  				<a href="#"
                  					onclick="document.getElementById('add_passen').submit(); return false;">
                              
                              <h3>Buy it</h3>
                  				</a>
                  		  </div>
                    </form>
                  </div>
          <div class= "main">
                      <img src="passenger.jpg" >
                    </div>
        </section> 

    </div>
	    <footer>
	        <h3>Contact us</h3>
	        <p>Copyright 2017 © mazets_anton@tut.by</p>
	    </footer>
	</div>
	


   

    
</body>
</html>