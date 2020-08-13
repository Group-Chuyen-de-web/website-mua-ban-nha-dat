<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>content</title>
          <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" media="all" />
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.flexisel.js"></script>
         <script src="${pageContext.request.contextPath}/js/responsiveslides.min.js"></script>
        <script>
            $(function ()
            {
                $("#slider1").responsiveSlides
                        ({
                            auto: true,
                            speed: 200,
                            namespace: "callbacks",
                            pager: true,
                        });
            });
        </script>
        <script>
            $(document).ready(function (c)
            {
                $('.alert-close').on('click', function (c)
                {
                    $('.message').fadeOut('slow', function (c)
                    {
                        $('.message').remove();
                    });
                });
            });
        </script>
        <script>
            $(document).ready(function (c)
            {
                $('.alert-close1').on('click', function (c)
                {
                    $('.message1').fadeOut('slow', function (c)
                    {
                        $('.message1').remove();
                    });
                });
            });
        </script>
        <style>
        
            .col-md:hover
            {
                border : 1px solid #00c6d7;
                box-shadow: 2px 2px 16px 0px violet;
            }
            ul.callbacks_tabs.callbacks1_tabs
            {
                left: 45%;
            }
            .col-md{
                transition:1s all ease;
                perspective: 600px;
            }
            .col-md_img{
                overflow: hidden;
            }
            .col-md a img{
                transition: 2s all ease;
            }
            .col-md:hover{
                transform : rotate(5deg);
                box-shadow: 2px 2px 16px 0px violet!important;
            }
            .col-md:hover a img{
                transform: scale(1.2);
            }
        </style>

        <script type="text/javascript">
            $(document).ready(function ()
            {
                $("#luuthongtin").click(function ()
                {

                    $("#luuthongtin").html("Đã Lưu");
                    $("#luuthongtin").css('cursor', 'unset');
                });
            });
        </script>
    </head>
    <body>


        
       <c:forEach items="${typeAll }" var="type">
	<div class="container" style="margin-top: 60px;">
		<div class="content">
			<div class="content-top">
				<h3 class="future" style="color: white;">${type.name}</h3>
				<div class="content-top-in">

					<c:forEach items="${type.post_id}" var="post">
						<div class="col-md-3 md-col" style="margin-top: 30px">
							<div class="col-md"
								style="background: rgba(0, 0, 0, 0.4); box-shadow: 2px 2px 16px 0px black">
								<div>
									<i class="fas fa-home" style="color: white;"> <%--=p.getHinhthuc()--%>
										${post.title}
									</i><span><i style="float: right; color: white;"
										class="far fa-calendar-alt"> <%--=p.getNgaydang()--%>
											${post.start_day}
									</i></span>
								</div>

								<div class="clearfix"></div>
								<div class="col-md_img">
									<!-- Slideshow 4 -->
									<div class="banner">
									<div class="slider">
										<ul class="rslides" id="slider1">
											<c:forEach items="${post.detail.images}" var="image">

												<li><img src="getImage/<c:out value='${image.id}'/> "
													alt="" style="height: 253px"></li>
											</c:forEach>
										</ul>

									</div>
									</div>
									
								</div>

								<div class="top-content">
									<h5>
										<a style="color: white;" href="single.jsp?productID="></a>
									</h5>
									<h5 style="padding: 0px; margin-top: -9px;">
										<i class="fas fa-compass" style="color: white;">
											${post.detail.address}
										</i>
									</h5>
									<h5 style="padding: 0px; margin-top: 4px;">
										<i class="fab fa-laravel"
											style="color: white; padding: 0px; margin-top: -9px;">
											${post.detail.area}m<sup>2</sup>
										</i>
									</h5>

									<div class="white">

										<a href="CartServlet?command=plus&productID=" id="luuthongtin"
											class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">Lưu
											Thông Tin</a> <a href="showDetail?id=${post.id}" 
											style="cursor: unset; background: black;" id="xemchitiet"
											class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">Xem
											Chi Tiêt </a>

										<p class="dollar">
											<span>${post.detail.price}</span><span>Triệu</span><span class="in-dollar">VNĐ</span>
										</p>
										<div class="clearfix"></div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>

					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
	<ul class="start" style="margin-left: 564px; margin-top: 32px;">
		<li><a href="#"><i></i></a></li>
		<li><span>1</span></li>
		<li><a href="#"><i class="next"> </i></a></li>
	</ul>
	</c:forEach>

</html>
