<%--suppress ALL --%>
<%@include file="/WEB-INF/include/root.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang=${language}>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><fmt:message key="title.flight" /></title>
    <link rel="stylesheet" type="text/css" href="css/flight.css"> 
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js?ver=1.4.2"></script>
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
</head>
<body>


<div class="container_flights_list">
        
    <header>
        <nav>
        <%@include file="/WEB-INF/include/header.jspf"%>
            <li><a href="#"><h1><fmt:message key="button.home" /></h1></a></li>
        </nav>
        <div id="myPopUp" class="modal">
        </div>  
    </header>

    <div class="main-and-sidebar-wrapper"> 
        <section class="main">
            <h2><fmt:message key="purchase.header" /> </h2>
            <form name="buy_ticket" action="Main" method="POST">
              <input type="hidden" value="buy_ticket" name="action" />
               <!--Flight info-->
                  <%@include file="/WEB-INF/include/flight_info.jspf"%>
   </div>
              </section>
              <!--Check input fields-->
              <%@include file="/WEB-INF/include/alert.jspf"%>
              <!--Spoiler-->
              <details id="details_first">
                <summary class="spoiler">
                <div id="spoiler_head"><fmt:message key="purchase.passInfo" /></div>
                </summary>
                <!--Name-->
                <div id="first">
                  <div id="first_left">
                    <fmt:message key="purchase.passName" />
                  </div>
                  <div id="first_right">
                      <input id="passenger_name" type="text" name="passenger_name"  required
                             pattern="^[a-zA-Z\s]+$"
                             title="<fmt:message key="fieldPattern.LatinLetters" />"
                      >
                  </div>
                </div>
                <!--Surname-->
                <div id="first">
                  <div id="first_left">
                    <fmt:message key="purchase.passSurname" />
                  </div>
                  <div id="first_right">
                      <input id="passenger_name" type="text" name="passenger_surname"  required
                             pattern="^[a-zA-Z\s]+$"
                             title="<fmt:message key="fieldPattern.LatinLetters" />"
                      >
                  </div>
                </div>
                <!--MiddleName-->
                <div id="first">
                  <div id="first_left">
                    <fmt:message key="purchase.passMiddleName" />
                  </div>
                  <div id="first_right">
                      <input id="passenger_name" type="text" name="passenger_midname"
                             pattern="^[a-zA-Z\s]+$"
                             title="<fmt:message key="fieldPattern.LatinLetters" />"
                      >
                  </div>
                </div>
                <!--Age-->
                <div id="first">
                  <div id="first_left">
                    <fmt:message key="purchase.age" />
                  </div>
                  <div id="first_right">
                      <input id="passenger_age" type="number" size="3" min="0" max="100" value="1" name="passenger_age"
                             pattern="[0-9]{2}"
                      >
                  </div>
                </div>
                <!--Date of birth-->
                <div id="first">
                  <div id="first_left">
                    <fmt:message key="purchase.birth" />
                  </div>
                  <div id="first_right">
                      <input id="passenger_date" type="date" name="passenger_birth" required>
                  </div>
                </div>
                <!--gender-->
                <div id="first">
                  <div id="first_left">
                    <fmt:message key="purchase.sex" />
                  </div>
                  <div id="first_right">
                      <select id="passenger_sex" name="passenger_sex">
                        <option><fmt:message key="purchase.sexMale" /></option>
                        <option><fmt:message key="purchase.sexFemale" /></option>
                      </select>
                  </div>
                </div>
                <!--passport id-->
                <div id="first">
                  <div id="first_left">
                    <fmt:message key="purchase.passport" />
                  </div>
                  <div id="first_right">
                      <input id="passenger_name" type="text" name="passenger_passport_number" required
                             pattern="[A-Za-z]{2}[0-9]{7}"
                             title="<fmt:message key="fieldPattern.Passport" />"
                      >
                  </div>
                </div>
                <!--passport expiry-->
                <div id="first">
                  <div id="first_left">
                    <fmt:message key="purchase.passportExpiry" />
                  </div>
                  <div id="first_right">
                      <input id="passenger_date" type="date" name="passenger_passport_expiry" required>
                  </div>
                </div>
                  <!--Email-->
                  <div id="first">
                      <div id="first_left">
                          <fmt:message key="registration.email" />
                      </div>
                      <div id="first_right">
                          <input id="passenger_date" type="email" name="passenger_email" required >
                      </div>
                  </div>
                  <!--primary boarding-->
                <div id="first">
                  <div id="first_left">
                    <fmt:message key="purchase.boarding" />
                  </div>
                  <div id="first_right">
                      <select id="passenger_sex" name="passenger_boarding">
                        <option><fmt:message key="purchase.Yes" /></option>
                        <option><fmt:message key="purchase.No" /></option>
                      </select>
                  </div>
                </div>
                  <!--On-line check in-->
                <div id="first">
                  <div id="first_left">
                    <fmt:message key="purchase.checkIn" />
                  </div>
                  <div id="first_right">
                      <select id="passenger_sex" name="passenger_checkin">
                        <option><fmt:message key="purchase.No" /></option>
                        <option><fmt:message key="purchase.Yes" /></option>
                      </select>
                  </div>
                </div>
                <details id="details_last">
                  <summary class="spoiler">
                  	<div id="spoiler_head"><fmt:message key="purchase.baggageInfo" /></div>
                  </summary>
                  <div id="baggage_img"><IMG src="img/baggage_bg.jpg" HEIGHT="200" WIDTH="600"></div>
                  <div id="first">
                    <div id="first_left_baggage">
                      <fmt:message key="purchase.baggage" />
                    </div>
                    <div id="first_right">
                        <select id="passenger_sex" name="passenger_baggage">
                         <option value="small"><fmt:message key="purchase.baggageS" /></option>
                         <option value="medium"><fmt:message key="purchase.baggageM" /></option>
                         <option value="large"><fmt:message key="purchase.baggageL" /></option>
                      </select>
                    </div>
                  </div>
                  <div id="buy_it">
                    <div id="buy_it_button">
                      <button class="go_search" id="go_search" ><fmt:message key="button.buy" /></button>
                    </div>
                  </div>

                </details>
                
              </details>
       </form>
	<%@include file="/WEB-INF/include/footer.jspf"%>
</div>   
</body>
</html>