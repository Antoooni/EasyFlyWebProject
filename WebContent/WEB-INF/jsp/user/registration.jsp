<%@include file="/WEB-INF/include/root.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang=${language}>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title><fmt:message key="title.registration" /></title>
	
	<link rel="stylesheet" type="text/css" href="css/registration.css" />
	<style>
	@import url(css/registration_files/formoid1/formoid-solid-red.css);
	</style>
	<!--<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js?ver=1.4.2"></script>-->
</head>
<body class="blurBg-false" style="background-color: #EBEBEB">


	<div class="container_flights_list">
		<header>
			<%@include file="/WEB-INF/include/header.jspf"%>
		</header>

		<div class="main-and-sidebar-wrapper">

			<!-- Start Formoid form-->
			<!--<link rel="stylesheet" href="formoid_files/formoid1/formoid-solid-red.css" type="text/css" />-->
			<script type="text/javascript"
				src="registration_files/formoid1/jquery.min.js"></script>
			<form class="formoid-solid-red"
				style="background-color: #FFFFFF; font-size: 15px; font-family: 'Roboto', Arial, Helvetica, sans-serif; color: #34495E; max-width: 480px; min-width: 150px"
				method="GET" action="Main" id="create_user">
				<input type="hidden" name="action" value="create_user">
				<div class="title">
					<h2><fmt:message key="registration.registration" /></h2>
				</div>
				<div class="element-input">
					<label class="title"> <span class="required">*</span>
					</label>
                    <!--login-->
					<div class="item-cont">
						<input class="large" type="text" name="create_login"
                               pattern="[a-zA-Z0-9]+" title=" <fmt:message key="fieldPattern.LetterNumber"/>"
							required="required" placeholder="<fmt:message key="registration.login" />" />
						<!--<span class="icon-place"></span>-->
					</div>
				</div>
				<div class="element-password">
					<label class="title"> <span class="required">*</span>
					</label>
                    <!--password-->
					<div class="item-cont">
						<input class="large" type="password" name="create_password"
							value="" required="required" placeholder="<fmt:message key="registration.password" />" />
						<!--<span class="icon-place"></span>-->
					</div>
				</div>
				<div class="element-password">
					<label class="title"></label>
                    <!--password confirm-->
					<div class="item-cont">
						<input class="large" type="password" name="create_password1"
							value="" placeholder="<fmt:message key="registration.passwordConfirm" />" />
						<!-- <span class="icon-place"></span>-->
					</div>
				</div>
				<div class="element-name">
                    <!--name-->
					<span class="nameFirst">
                        <input placeholder="<fmt:message key="registration.name" />"
						type="text" size="8" name="name[first]" pattern="[А-Яа-яЁё]" title=" <fmt:message key="fieldPattern.AnyLetters"/>" />
                        <span
						class="icon-place"></span>
					</span>
                    <!--surname-->
                    <span class="nameLast">
                        <input placeholder="<fmt:message key="registration.surname" />"
						type="text" size="14" name="name[last]" pattern="[А-Яа-яЁё]" title=" <fmt:message key="fieldPattern.AnyLetters"/>" />
                        <span
						class="icon-place"></span>
					</span>
				</div>
				<div class="element-email">
					<label class="title"> <span class="required">*</span>
					</label>
					<div class="item-cont">
						<input class="large" type="email" name="create_email" value=""
							required="required" placeholder="<fmt:message key="registration.email" />" />
						<!--<span class="icon-place"></span>-->
					</div>
				</div>
				<div class="submit">
					<input type="submit" value="<fmt:message key="registration.register" />" />
				</div>
			</form>
		</div>
		<div>
			<!-- FOOTER -->
			<%@include file="/WEB-INF/include/footer.jspf"%>
	</div>
	<c:if test="${user_exist == true}">
		<div class="message_registartion">
			<c:out value="This user is already exists!" />
		</div>
	</c:if>
	<c:if test="${email_exist == true}">
		<div class="message_registartion">
			<c:out value="This email is already busy!!!" />
		</div>
	</c:if>
	<c:if test="${success != null}">
		<div class="message_registartion_success">
			<c:out value="User created successfully" />
		</div>
	</c:if>
	<p class="frmd">
		<a href="http://formoid.com/v29.php">html form</a> Formoid.com 2.9
	</p>
	<script type="text/javascript"
		src="registration_files/formoid1/formoid-solid-red.js"></script>
	<!-- Stop Formoid form-->

	
</body>
</html>