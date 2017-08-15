<%@include file="/WEB-INF/include/root.jspf"%>
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
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
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
                    <!--Login-->
					<div class="item-cont">
						<input class="large" type="text" name="create_login"
							required="required"
                            pattern="[A-z0-9_-]{3,16}"
                            title="<fmt:message key="fieldPattern.Login" />"
                            placeholder="<fmt:message key="registration.login" />" />
						<!--<span class="icon-place"></span>-->
					</div>
				</div>
                <!--Password-->
				<div class="element-password">
					<label class="title"> <span class="required">*</span>
					</label>
					<div class="item-cont">
						<input class="large" type="password" name="create_password"
							value="" required="required"
                            pattern="(?=^.{6,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*"
                            title="<fmt:message key="fieldPattern.Password" />"
                            placeholder="<fmt:message key="registration.password" />" />
						<!--<span class="icon-place"></span>-->
					</div>
				</div>
                <!--Password confirmation-->
				<div class="element-password">
					<label class="title"></label>
					<div class="item-cont">
						<input class="large" type="password" name="create_password1"
							value="" required
                            pattern="(?=^.{6,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*"
                            title="<fmt:message key="fieldPattern.Password" />"
                            placeholder="<fmt:message key="registration.passwordConfirm" />" />
						<!-- <span class="icon-place"></span>-->
					</div>
				</div>
                <!--name $ surname-->
				<div class="element-name">
					<!--<label class="title"></label>-->
					<span class="nameFirst">
                        <input placeholder="<fmt:message key="registration.name" />"
						type="text" size="8"
                        pattern="^[A-Za-zА-Яа-яЁё\s]+$"
                        title="<fmt:message key="fieldPattern.AnyLetters" />"
                        name="name[first]" />
                        <span class="icon-place"></span>
					</span>
                    <span class="nameLast">
                        <input placeholder="<fmt:message key="registration.surname" />"
						type="text" size="14"
                        pattern="^[A-Za-zА-Яа-яЁё\s]+$"
                        title="<fmt:message key="fieldPattern.AnyLetters" />"
                        name="name[last]" />
                        <span class="icon-place"></span>
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

        <%@include file="/WEB-INF/include/alert.jspf"%>
        <div>
            <!-- FOOTER -->
            <%@include file="/WEB-INF/include/footer.jspf"%>
        </div>
	<script type="text/javascript"
		src="registration_files/formoid1/formoid-solid-red.js"></script>
	<!-- Stop Formoid form-->

	
</body>
</html>