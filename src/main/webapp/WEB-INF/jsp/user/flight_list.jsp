<%@include file="/WEB-INF/include/root.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head lang=${language}>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><fmt:message key="title.flightList" /></title>
    <link rel="stylesheet" type="text/css" href="css/flight_list.css"> 
	<script type="text/javascript" src="js/script.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js?ver=1.4.2"></script>
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
</head>
<body>


<div class="container_flights_list">
        
    <header>
       	<%@include file="/WEB-INF/include/header.jspf"%>
    </header>

    <div class="main-and-sidebar-wrapper"> 
        <section class="main">
            <h2 style="text-transform: uppercase;">
            	<fmt:message key="title.flightList" />
            </h2>
               <div class="datagrid">
                 <table>
                 <thead>
                    <tr>
                      <th>#</th>
                      <th><fmt:message key="flight.selection" /></th>
                      <th><fmt:message key="flight.airpotCode" /></th>
                      <th><fmt:message key="flight.fromCity" /></th>
                      <th><fmt:message key="flight.departureDate" /></th>
                      <th><fmt:message key="flight.departureTime" /></th>
                      <th><fmt:message key="flight.airpotCode" /></th>
                      <th><fmt:message key="flight.toCity" /></th>
                      <th><fmt:message key="flight.arrivalDate" /></th>
                      <th><fmt:message key="flight.arrivalTime" /></th>
                    </tr>
                  </thead>
                  <tfoot>
                    <tr>
                      <td colspan="10">
                      <div id="no-paging">&nbsp;</div>
                    </tr>
                  </tfoot>
                    <c:forEach items="${list_flights}" var="i">
                      <h3>
                      <tbody>
                         <tr> 
                           <td><c:out value="${list_flights.indexOf(i)}"/></td>
                           <td><!--<input type="submit" name="add_cart" value="buy" />-->
                            <div>
                              <form name="buy" action="Main" method="GET" id="buy">
                                  <input type="hidden" name="action" value="buy">
                                  <button class="button_buy" id="myBtnbuy" value="${i.getFlightId()}" name="flight_id"><fmt:message key="button.buyIt" /></button>
                              </form>
                            </div>
                           </td>
                           <td><c:out value="${i.getFromDirection().getDirectionCode()}" /></td>
                           <td><c:out value="${i.getFromDirection().getCity()}" /></td>
                           <td><c:out value="${i.getDepartureDate()}" /> </td>
                           <td><c:out value="${i.getDepartureTime()}" /></td>
                           <td><c:out value="${i.getToDirection().getDirectionCode()}" /> </td>
                           <td><c:out value="${i.getToDirection().getCity()}" /></td>
                           <td><c:out value="${i.getArrivalDate()}" /> </td>
                           <td><c:out value="${i.getArrivalTime()}" /></td>
                         </tr>
                       </tbody>
                      </h3>
                    </c:forEach>
                  </table>
                </div>
            <!--</form>-->
            <c:if test="${logged_user == false}">
              <div class="nonlogged">
                <div class="alertloggin"><fmt:message key="alert.login" />
                  <!--<c:out value="You are not logged-in yet. Please LOG IN" />-->
                </div>
              </div>
            </c:if>
        </section> 

    </div>
	    <%@include file="/WEB-INF/include/footer.jspf"%>
	</div>
	
 <!--  <script type="text/javascript"> <!--
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
   </script>-->

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