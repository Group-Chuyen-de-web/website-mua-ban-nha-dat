<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thông Tin Sản Phẩm</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.css"
	rel="stylesheet" type="text/css" media="all" />
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" type="text/css" media="all" />
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons"/>
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
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.2/css/all.css" />

	
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
<script>
// Get the modal
var modal = document.getElementById("#myModal");

// Get the button that opens the modal
var btn = document.getElementById("#myBtn");

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
<style>


/* The Modal (background) */
.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  padding-top: 100px; /* Location of the box */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
  background-color: #fefefe;
  margin: auto;
  padding: 20px;
  border: 1px solid #888;
  width: 40%;
}

/* The Close Button */
.close {
  color: #aaaaaa;
  float: right;
  font-size: 28px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: #000;
  text-decoration: none;
  cursor: pointer;
}
</style>
<style>
.a1 {
	width: 80%;
	height: auto;
	margin: 0 auto;
}

.a1.a2 {
	width: 80%;
	height: auto;
	margin: 0 auto;
}

.a2 {
	width: 45%;
	height: auto;
	margin: 0 auto;
}
@font-face {
  font-family: 'Material Icons';
  font-style: normal;
  font-weight: 400;
  src: url(https://fonts.gstatic.com/s/materialicons/v54/flUhRq6tzZclQEJ-Vdg-IuiaDsNc.woff2) format('woff2');
}
.material-icons {
  font-family: 'Material Icons';
  font-weight: normal;
  font-style: normal;
  font-size: 24px;
  line-height: 1;
  letter-spacing: normal;
  text-transform: none;
  display: inline-block;
  white-space: nowrap;
  word-wrap: normal;
  direction: ltr;
  -webkit-font-feature-settings: 'liga';
  -webkit-font-smoothing: antialiased;
}
</style>
</head>
<body
	style="background:url(${pageContext.request.contextPath}/video/bann.jpg) fixed;color:white;">

	<jsp:include page="header.jsp"></jsp:include>



	<button id="myBtn"
		style=" color: #f7921d;; font-size: 15px; float: right; margin-right: 60px;">
		Feedback <i class="material-icons" style="color: red"></i>
		
	</button>
	<!-- The Modal -->
<div id="myModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <span class="close">&times;</span>
    <p>Some text in the Modal..</p>
  </div>
</div>
	<div class="a2">
		<div
			style="float: right; position: relative; margin-top: 23px; margin-right: 6px; font-size: 20px;">
			<p>
				<i style="padding-left: 53px; float: right; color: #f7921d;"
					class="far fa-calendar-alt">Ngày Đăng Bài:${post.start_day}</i>
			</p>
		</div>
		<div class="single">

			<div class="as">

				<p
					style="font-size: 28px; background-color: rgba(0, 0, 0, 0.4); border-top-right-radius: 45px; color: #f7921d">Thông
					Tin Liên Hệ
				<p>
				<div>
					<div
						style="border: 2px solid #00c6d7; border-top-right-radius: 23px; color: white;">
						<p style="padding-left: 50px; font-size: 18px;">
							<i class="far fa-caret-square-up"></i><strong
								style="color: #f7921d">Tiêu Đề</strong><span
								style="margin-left: 366px;"> ${post.title}
							</span>
						</p>
					</div>
					<div
						style="border: 2px solid #00c6d7; border-top-right-radius: 23px; color: white;">
						<p style="padding-left: 50px; font-size: 18px;">
							<i class="fab fa-accusoft"></i><strong style="color: #f7921d">Loại tin</strong><span style="margin-left: 360px;"> ${post.news_id.name}
							</span>
						</p>
					</div>
					<div
						style="border: 2px solid #00c6d7; border-top-right-radius: 15px; color: white;">
						<p style="padding-left: 50px; font-size: 18px;">
							<i class="fas fa-money-bill"></i><strong style="color: #f7921d">Giá</strong><span
								style="margin-left: 400px;">  ${post.detail.price}
								Triệu VNĐ
							</span>
						</p>
					</div>
					<div
						style="border: 2px solid #00c6d7; border-top-right-radius: 23px; color: white;">
						<p style="padding-left: 50px; font-size: 18px;">
							<i class="fab fa-laravel"></i><strong style="color: #f7921d">Diện
								Tích</strong><span style="margin-left: 350px;"> ${post.detail.area}m<sup>2</sup>
							</span>
						</p>
					</div>
					<div
						style="border: 2px solid #00c6d7; border-top-right-radius: 23px; color: white;">
						<p style="padding-left: 50px; font-size: 18px;">
							<i class="fas fa-address-book"></i><strong style="color: #f7921d">Họ
								Tên Người Đăng</strong><span style="margin-left: 272px;"> ${post.user_id.fullname}
							</span>
						</p>
					</div>
					<div
						style="border: 2px solid #00c6d7; border-top-right-radius: 23px; color: white;">
						<p style="padding-left: 50px; font-size: 18px;">
							<i class="fas fa-phone-square"></i><strong style="color: #f7921d">Số
								Điện Thoại</strong><span style="margin-left: 317px;"> ${post.detail.phone}
							</span>
						</p>
					</div>
					<div
						style="border: 2px solid #00c6d7; border-top-right-radius: 23px; height: auto; color: white;">
						<p style="padding-left: 50px; font-size: 18px;">
							<i class="fas fa-compass"></i><strong style="color: #f7921d">Vị
								Trí</strong><span style="margin-left: 385px;"> ${post.detail.address}
							</span>
						</p>
					</div>
				</div>

				<div class="top-content"
					style="float: right; position: relative; margin-top: -40px;">
					<div class="white"
						style="line-height: 17px; margin-left: 283px; margin-top: 54px;">

						<a
							href="CartServlet?command=plus&productID=<%--=p2.getProductID()--%>"
							class="hvr-shutter-in-vertical hvr-shutter-in-vertical2 ">Lưu
							Thông Tin</a>

						<div class="clearfix"></div>
					</div>
				</div>

			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<div class="a1">
		<div class="as1" style="border: 2px solid black; height: auto;">
			<p
				style="background: rgba(0, 0, 0, 0.4); color: white; font-size: 25px; padding-top: 10px; padding-bottom: 10px;">Mô
				tả chi tiết</p>
			<p
				style="padding-left: 100px; padding-right: 26px; font-size: 20px; color: white;">
				${post.detail.content}
			</p>
			<div class="clearfix"></div>
			<p
				style="background: rgba(0, 0, 0, 0.4); color: white; font-size: 25px; padding-top: 10px; padding-bottom: 10px;">Hình ảnh
</p>
			
			<c:forEach items="${post.detail.images}" var="image">

					<li><img src="getImage/<c:out value='${image.id}'/> " alt=""
						style="height: 253px"></li>
				</c:forEach>
		</div>


	</div>
	<!--end-->



	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
