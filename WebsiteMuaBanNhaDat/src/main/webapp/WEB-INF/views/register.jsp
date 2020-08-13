<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng Ký</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" media="all" />
<meta name="viewport"
	content="width=device-width,height=device-height,user-scalable=yes, initial-scale=1, minimum-scale=1.0, maximum-scale=3.0">
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<link
	href='http://fonts.googleapis.com/css?family=Exo:100,200,300,400,500,600,700,800,900'
	rel='stylesheet' type='text/css'>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easing.js"></script>

<style>
#tb:hover {
	animation: swing 1s ease;
	border-color: #00c6d7;
	box-shadow: 0 10px 6px -6px #777;
	color: #00c6d7;
}
</style>
 <style>
.error_message {
	color: red;
	font-size: 90%;
	font-style: italic;
}
</style> 
</head>
<body style="background: url(${pageContext.request.contextPath}/video/bann.jpg) fixed">
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container" style="border: 3px solid black;">
		<%request.setCharacterEncoding("UTF-8");%>
		<%
			response.setContentType("text/html; charset=UTF-8");
		%>
		<div class="container">
			<div class="account">
				<h2 class="account-in" style="color: white;">Đăng Ký Tài Khoản</h2>
				<spring:form method="POST" action="saveUser" modelAttribute="userModel">
					<div>
						<span class="mail" style="color: white;">Họ Và Tên:*</span> 
						<span>
							<spring:input path="fullname" 
								style="margin-left: 34px;padding-left: 23px;color:#f7921d" id="fullname"
								name="fullname" placeholder="Điền họ và tên..." /> </span>
								<div class="error_message"> <spring:errors
									path="fullname" ></spring:errors></div>
					</div>
					<div>
						<span class="mail" style="color: white;">Email/Gmail:*</span> 
						<span>
							<spring:input path="email"
								style="margin-left: 17px;padding-left: 23px;color:#f7921d" id="email"
								name="email" placeholder="Điền email..." /></span>
									<div class="error_message"> <spring:errors
									path="email" ></spring:errors></div>
						
					</div>
					<div>
					<span class="word" style="color: white;">Tên đăng nhập:*</span> 
						<span>
							<spring:input path="username" 
								style="margin-left: 34px;padding-left: 23px;color:#f7921d" id="username"
								name="username" placeholder="Điền tên đăng nhập..." /> </span>
								<div class="error_message"> <spring:errors
									path="username" ></spring:errors></div>
					</div>
					<div>
						<span class="word" style="color: white;">Mật khẩu:*</span> <span>
							<spring:password path="pass"
								style="margin-left: 68px;padding-left: 23px; color:#f7921d"  id="pass"
								name="pass" placeholder="Điền mật khẩu..." /> </span>
								<div class="error_message"> <spring:errors
									path="pass" ></spring:errors></div>
					</div>
					<div>
						<span class="word" style="color: white;">Nhập lại mật khẩu:*</span>
							 <span> <spring:password path="re_pass"
								style="padding-left: 23px;color:#f7921d" id="re_pass" name="re_pass"
								placeholder="Điền lại mật khẩu..." /> </span>
									<div class="error_message"> <spring:errors
									path="re_pass" ></spring:errors></div>
					</div>
					<div>
						<span class="word" style="color: white;">Địa chỉ:*</span> 
						<span>
							<spring:input path="address"
								style="margin-left: 84px;padding-left: 23px;color:#f7921d" id="address"
								name="address" placeholder="Điền địa chỉ..." /> </span>
									<div class="error_message"> <spring:errors
									path="address" ></spring:errors></div>
						
					</div>
					<div>
						<span class="word" style="color: white;">Ngày sinh:*</span>
						 <span><spring:input path="birthday" style="margin-left: 60px;padding-left: 23px;color:#f7921d"
								id="birthday" name="birthday"
								placeholder="Điền ngày tháng năm sinh..." /></span>
								 	<div class="error_message"> <spring:errors
									path="birthday" ></spring:errors></div>
					</div>

					<div>
						<span class="word" style="color: white;">Số điện thoại:*</span> <span><spring:input
								path="phone" style="margin-left: 40px;padding-left: 23px;color:#f7921d"
								id="phone" name="phone" placeholder="Điền số điện thoại..." /></span>
							<div class="error_message"> <spring:errors
									path="phone" ></spring:errors></div>
					</div>
						<div class="form-submit">
								<spring:button style=" background: #329e5e;color:#f7921d;  width: 100px; height: 50px;">Đăng ký</spring:button>
							</div>
				</spring:form>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
