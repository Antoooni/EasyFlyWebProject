<%@include file="/WEB-INF/include/root.jspf"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang=${language}>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title><fmt:message key="title.index" /></title>
	<link rel="stylesheet" type="text/css" href="css/index.css">
	<script type="text/javascript" src="js/script.js"></script>
	<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
<!--<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js?ver=1.4.2"></script>-->
</head>
<body>
	<div class="container">
		<header>
			<%@include file="/WEB-INF/include/header.jspf"%>
		</header>

		<div class="main-and-sidebar-wrapper">
			<section class="main"> <!--<h2>FLEW ONCE IMPRESSIONS FOREVER </h2>-->
				<div class="name_company">
					<h2>Easy Fly</h2>
				</div>
				<div class="search_frame">
					<form name="go_search" action="Main" method="GET" id="go">
						<input type="hidden" name="action" value="go_search">
						<select class="from" on value="direction_from" name="direction_from" required>from</option>
							<option selected disabled hidden><fmt:message key="search.departure" /></option>
							<c:forEach var="item" items="${list_directions}">
								<option class="from">
									<c:out value="${item.getDirectionCity()}" />
								</option>
							</c:forEach>
						</select> <select class="from" on value="direction_to" name="direction_to" required>to</option>
							<option selected disabled hidden><fmt:message key="search.arrival" /></option>
							<c:forEach var="item" items="${list_directions}">
								<option class="from">
									<c:out value="${item.getDirectionCity()}" />
								</option>
							</c:forEach>
						</select>
						<input class="search_flight_date" type="date" name="departure_date" id="departure_date" onclick="calendar('departure_date')">
						<input class="search_flight_date" type="date" name="arrival_date" id="arrival_date" onclick="calendar_arrival('arrival_date')">
						<button class="go_search" id="go_search"><fmt:message key="search.go" /></button>
					</form>
				</div>
			</section>
		</div>
		<!-- FOOTER -->
		<%@include file="/WEB-INF/include/footer.jspf"%>
		</div>

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