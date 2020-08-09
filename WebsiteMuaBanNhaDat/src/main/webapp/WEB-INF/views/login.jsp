<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dang Nhap</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src='https://www.google.com/recaptcha/api.js'></script>
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" type="text/css" media="all" />
<meta name="viewport"
	content="width=device-width,height=device-height,user-scalable=yes, initial-scale=1, minimum-scale=1.0, maximum-scale=3.0">
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<link
	href='http://fonts.googleapis.com/css?family=Exo:100,200,300,400,500,600,700,800,900'
	rel='stylesheet' type='text/css'>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 1000);
		});
	});
</script>
<!--slider-script-->
<script
	src="${pageContext.request.contextPath}/js/responsiveslides.min.js"></script>
<script>
	$(function() {
		$("#slider1").responsiveSlides({
			auto : true,
			speed : 100,
			namespace : "callbacks",
			pager : true,
		});
	});
</script>
<!--//slider-script-->
<script>
	$(document).ready(function(c) {
		$('.alert-close').on('click', function(c) {
			$('.message').fadeOut('slow', function(c) {
				$('.message').remove();
			});
		});
	});
</script>
<script>
	$(document).ready(function(c) {
		$('.alert-close1').on('click', function(c) {
			$('.message1').fadeOut('slow', function(c) {
				$('.message1').remove();
			});
		});
	});
</script>
<style>
#tb:hover {
	animation: swing 1s ease;
	border-color: #00c6d7;
	box-shadow: 0 10px 6px -6px #777;
	color: #00c6d7;
}
</style>
</head>
<body
	style="background:url(${pageContext.request.contextPath}/video/bann.jpg) fixed">

	<jsp:include page="header.jsp"></jsp:include>
	<div class="container" style="border: 3px solid black;">
		<div class="container">
			<div class="account">
				<h2 class="account-in" style="color: white;">Đăng Nhập Tài
					Khoản</h2>

				<c:if test="${param.incorrectAccount != null}">
					<div class="alert alert-danger">Username or password
						incorrect</div>
				</c:if>
				<c:if test="${param.accessDenied != null}">
					<div class="alert alert-danger">you Not authorize</div>
				</c:if>

				<form action="j_spring_security_check" id="formLogin" method="POST">
					<div>
						<span class="word" style="color: white; margin-right: 33px;">Tên
							đăng nhập </span> <input style="background-color: silver;" type="text"
							name="username" id="userName">
					</div>
					<div>
						<span class="mail" style="color: white; margin-right: 33px;">Mật
							Khẩu </span> <input style="background-color: silver;" type="password"
							name="pass" id="password" >
					</div>
<!-- 					<div class="g-recaptcha"
						data-sitekey="6LelZAsTAAAAAAv1ADYDnq8AzbmPmbMvjh-xhfgB"></div>
 -->					<input id="tb" type="submit" value="Đăng Nhập"
						style="background: rgba(0, 0, 0, 0.4); border: 1px solid black; margin-top: 55px;">

					<!-- <script>
						grecaptcha.ready(function() {
							grecaptcha.execute(
									'6Ldy2YMUAAAAAG2CYNQEAeWH3iVAMPKALvw2enf1',
									{
										action : 'action_name'
									}).then(function(token) {
								// Verify the token on the server.
							});
						});
					</script> -->
				</form>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
