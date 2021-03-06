
<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Post"%>
<%@page import="java.util.Set"%>
<html lang="en">
<head>
<title>Airbnb</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
.bs-example {
	margin: 20px;
}
</style>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<script type="application/x-javascript">
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 






































</script>
<!-- bootstrap-css -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<!--// bootstrap-css -->
<!-- css -->
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
<!--// css -->
<!-- font-awesome icons -->
<link href="css/font-awesome.css" rel="stylesheet">
<!-- //font-awesome icons -->
<!-- font -->
<link
	href="//fonts.googleapis.com/css?family=Crimson+Text:400,400i,600,600i,700,700i"
	rel="stylesheet">
<link
	href="//fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
<link
	href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,700italic,700,400italic,300italic,300'
	rel='stylesheet' type='text/css'>
<!-- //font -->
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/bootstrap.js"></script>
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
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<![endif]-->
</head>
<body>
	<!-- banner -->
	<div class="banner">
		<div class="header">
			<div class="container">
				<div class="header-left">
					<div class="w3layouts-logo">
						<h1>
							<a href="index.html"><span>re </span> AIRBNB</a>
						</h1>
					</div>
				</div>
				<div class="header-right">
					<div class="w3-header-bottom">
						<div class="top-nav">
							<nav class="navbar navbar-default">
								<div class="navbar-header">
									<button type="button" class="navbar-toggle collapsed"
										data-toggle="collapse"
										data-target="#bs-example-navbar-collapse-1">
										<span class="sr-only">Toggle navigation</span> <span
											class="icon-bar"></span> <span class="icon-bar"></span> <span
											class="icon-bar"></span>
									</button>
								</div>
								<!-- Collect the nav links, forms, and other content for toggling -->
								<div class="collapse navbar-collapse"
									id="bs-example-navbar-collapse-1">
									<ul class="nav navbar-nav">

										<div id="myOverlay" class="overlay">
											<span class="closebtn" onclick="closeSearch()"
												title="Close Overlay">�</span>
											<div class="overlay-content">
												<form action="index.html">
													<input type="text" placeholder="Search.." name="search">
													<button type="submit">
														<i class="fa fa-search"></i>
													</button>
												</form>
											</div>
										</div>
										<li><a id="openBtn" class="active" onclick="openSearch()">Search</a></li>
										<li><a href="ExploreServlet">Explore</a></li>
										<li><a href="HostPage.html">Host</a></li>
										<li><a class="hvr-bounce-to-bottom" href="login.html">Login</a></li>
										<li><a class="hvr-bounce-to-bottom" href="register.html">Register</a></li>
									</ul>
									<div class="clearfix"></div>
								</div>
							</nav>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="w3layouts-banner-slider">
			<div class="container">
				<div class="slider">
					<div class="callbacks_container"></div>
				</div>
				<%
					ArrayList<Post> allPosts = (ArrayList<Post>) request.getAttribute("posts");
					if (allPosts != null) {
						out.write("<h1>Most Recent Places to stay!</h1><br>");
						out.write("<div class=\"bs-example\">");
						out.write("<table class=\"table table-hover\">");
						out.write("<tr>");
						out.write("<th>Title</td>");
						out.write("<th>Description</td>");
						out.write("<th>Price</td>");
						out.write("</tr>");
						for (Post p : allPosts) {
							out.write("<tr >");
							out.write("<td>");
							out.write(p.getTitle());
							out.write("</td>");
							out.write("<td>");
							out.write(p.getDescription());
							out.write("</td>");
							out.write("<td>");
							out.write((int) p.getPrice());
							out.write("</td>");
							out.write("</tr>");
						}
						out.write("</table>");
						out.write("</div>");
					}
				%>
			</div>
		</div>
		<!-- //banner -->
		<!-- welcome -->
		<!-- //services -->
		<!-- copyright -->
		<!-- //copyright -->
		<script src="js/responsiveslides.min.js"></script>
		<script src="js/SmoothScroll.min.js"></script>
		<script type="text/javascript" src="js/move-top.js"></script>
		<script type="text/javascript" src="js/easing.js"></script>
		<!-- here stars scrolling icon -->
		<script type="text/javascript">
			$(document).ready(function() {
				/*
					var defaults = {
					containerID: 'toTop', // fading element id
					containerHoverID: 'toTopHover', // fading element hover id
					scrollSpeed: 1200,
					easingType: 'linear'
					};
				 */

				$().UItoTop({
					easingType : 'easeOutQuart'
				});

			});
		</script>

		<script>
			function openSearch() {
				document.getElementById("myOverlay").style.display = "block";
			}

			function closeSearch() {
				document.getElementById("myOverlay").style.display = "none";
			}
		</script>
		<!-- //here ends scrolling icon -->
		<script src="js/jarallax.js"></script>
		<script type="text/javascript">
			/* init Jarallax */
			$('.jarallax').jarallax({
				speed : 0.5,
				imgWidth : 1366,
				imgHeight : 768
			})
		</script>
		<script>
			
		</script>
</body>
</html>
