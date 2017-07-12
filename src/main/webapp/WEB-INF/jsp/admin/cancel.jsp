<%@include file="/WEB-INF/include/root.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><fmt:message key="title.cancellation" /></title>
    <link rel="stylesheet" type="text/css" href="css/cancel.css"> 
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js?ver=1.4.2"></script>
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
</head>
<body>

<div class="container_flights_list">    
    <header>
    	<%@include file="/WEB-INF/include/header.jspf"%>
            <!-- <li><a href="#"><h1>Home</h1></a></li>-->
        <div id="myPopUp" class="modal">
        </div>  
    </header>

    <div class="main-and-sidebar-wrapper"> 
        <section class="main">
            <h2><fmt:message key="title.cancellation" /></h2>
            <!--Flight info-->
                  <%@include file="/WEB-INF/include/flight_info.jspf"%>
   </div>
        </section> 
        <!--Spoiler-->
        <details id="details_first">
          <summary class="spoiler">
          <div id="spoiler_head"><fmt:message key="cancel.changeData" /></div>
          </summary>
          <form name="change_flight_data" action="Main" method="GET" id="change_flight_data">
	      <input type="hidden" name="action" value="change_flight_data">
	          <!--Date of birth-->
	          <div id="first">
	            <div id="first_left">
	              <fmt:message key="cancel.depDate" />
	            </div>
	            <div id="first_right">
	                <input id="passenger_date" type="date" name="change_dept_date" required>
	            </div>
	          </div>
	
	          <div id="first">
	            <div id="first_left">
	              <fmt:message key="cancel.depTime" />
	            </div>
	            <div id="first_right">
	                <input id="passenger_date" type="time" name="change_dept_time" required>
	            </div>
	          </div>
	          <!--passport expiry-->
	          <div id="first">
	            <div id="first_left">
	              <fmt:message key="cancel.arrDate" />
	            </div>
	            <div id="first_right">
	                <input id="passenger_date" type="date" name="change_arr_date" required>
	            </div>
	          </div>
	          <div id="first">
	            <div id="first_left">
	              <fmt:message key="cancel.arrTime" />
	            </div>
	            <div id="first_right">
	                <input id="passenger_date" type="time" name="change_arr_time" required>
	            </div>
	          </div>
	          <c:if test="${empty_data == true}">
	          <div class="empty_data">
                <div class="alert_empty_data"><fmt:message key="alert.cancellation" />
                </div>
              </div>
	          </c:if>
	          <div id="buy_it">
		           <div id="buy_it_button">
		          	 <button class="go_search" id="go_search" name="change_date"><fmt:message key="button.changeData" /></button>
		           </div>
	          </div>
          </form>
        </details>

          <details id="details_last">
            <summary class="spoiler">
            <div id="spoiler_head" style="text-transform: uppercase;"><fmt:message key="cancel.cancel" /></div>
            </summary>
            <div id="baggage_img"><IMG src="img/cancel.jpg" HEIGHT="200" WIDTH="600">
            </div>
            <form name="cancel_flight" action="Main" method="GET" id="cancel_flight">
              <input type="hidden" name="action" value="cancel_flight">
              <div id="buy_it">
                <div id="buy_it_button">
                  <button class="go_search" id="cancel_flight" name="cancel_flight"><fmt:message key="button.cancel" /></button>
                </div>
              </div>
            </form>

          </details>
	    <%@include file="/WEB-INF/include/footer.jspf"%>
    </div>
</body>
</html>