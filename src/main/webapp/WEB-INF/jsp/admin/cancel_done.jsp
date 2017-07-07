<%@include file="/WEB-INF/include/root.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><fmt:message key="title.cancelDone" /></title>
    <link rel="stylesheet" type="text/css" href="css/done.css"> 
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js?ver=1.4.2"></script>
</head>
<body>


<div class="container_flights_list">
        
    <header>
        <nav>
          <!-- <form action = "Main" method="GET" id="home">
              <input type="hidden" name="action" value="go_home">
              <div class ="text_order_color" >
                <a href="#"  onclick="document.getElementById('home').submit(); return false;">
                  <h2>Home</h2>
                  <h2><c:out value="${user_exist}" /></h2>
                </a>
              </div>
          </form>
        </nav>-->
        <%@include file="/WEB-INF/include/header.jspf"%>
        <div id="myPopUp" class="modal">
        </div>  
    </header>

    <div class="main-and-sidebar-wrapper"> 
        <section class="main">
            <h2><fmt:message key="cancel.apply" /></h2>
              <div class="text_passenger_color">
              	<h3><fmt:message key="cancel.cancel" /></h3>
              </div>
          <div class= "baggage_img">
          	<img src="img/flight_cancelled.jpg" width="50%" >
          </div>
        </section> 
    </div>
    <%@include file="/WEB-INF/include/footer.jspf"%>
	</div>    
</body>
</html>