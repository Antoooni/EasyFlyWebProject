<%--suppress ALL --%>
<%@include file="/WEB-INF/include/root.jspf"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Baggage</title>
    <link rel="stylesheet" type="text/css" href="css/flight.css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js?ver=1.4.2"></script>
</head>
<body>


<div class="container_flights_list">
    <header>
        <nav>
            <%@include file="/WEB-INF/include/header.jspf"%>
        </nav>
        <div id="myPopUp" class="modal">
        </div>
    </header>

    <div class="main-and-sidebar-wrapper">
        <section class="main">
            <h2>Thanks for choosing us! </h2>
            <div id="text_passenger_color">
                <h3>ENJOY YOUR FLIGHT</h3>
            </div>
            <div class= "enjoy">
                <img src="img/enjoy.jpg" >
            </div>
            <div id="text_passenger_color_print">
                <form action = "Main" method="GET" id="print">
                    <input type="hidden" name="action" value="print">
                    <a href="#"  onclick="document.getElementById('print').submit(); return false;">
                        <h3>PRINT TICKET</h3>
                        <img src="img/print.png" style="width: 10%">
                </form>
            </div>
        </section>
    </div>
    <%@include file="/WEB-INF/include/footer.jspf"%>
</body>
</html>