<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>content</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.css"
	rel="stylesheet" type="text/css" media="all" />
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<link href="${pageContext.request.contextPath}css/style.css"
	rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.flexisel.js"></script>
<style>
.col-md:hover {
	border: 1px solid #00c6d7;
	box-shadow: 2px 2px 16px 0px violet;
}

ul.callbacks_tabs.callbacks1_tabs {
	left: 45%;
}

.col-md {
	transition: 1s all ease;
	perspective: 600px;
}

.col-md_img {
	overflow: hidden;
}

.col-md a img {
	transition: 2s all ease;
}

.col-md:hover {
	transform: rotate(5deg);
	box-shadow: 2px 2px 16px 0px violet !important;
}

.col-md:hover a img {
	transform: scale(1.2);
}
.select{
padding: 0.7em;
	width: 30%;
	background: none;
	border: 1px solid #D1D1D1;
	border-radius: 10px;
	-webkit-border-radius: 10px;
	-o-border-radius: 10px;
	-moz-border-radius: 10px;
	-ms-border-radius: 10px;
	outline: none;
	color: #464646;
	font-size: 1em;
}
</style>


</head>
<body>

	<div class="container" style="margin-top: 60px;">
		<div class="content">
			<div class="content-top">
				<h3 class="future" style="color: white;">Bộ Lọc Tìm Kiếm</h3>
				<div class="content-top-in">
					<%-- <div>
						<p class="word" style="color: white;">Loại Tin</p>
						<spring:select path="type_id.id" items="${types}" itemValue="id" itemLabel="name"
							cssClass="select" style="color:#f7921d;background: #464646" />
					</div>
					
						<div>
							<p class="word" style="color: white;">Khoảng giá</p>
							<spring:input path="detail.price" style="color:#f7921d"/>
							<spring:input path="detail.price" style="color:#f7921d"/>
						</div> --%>
					</div>
				</div>
			</div>
		</div>
		
		
</body>
</html>
