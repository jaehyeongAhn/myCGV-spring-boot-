<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CGV</title>
<link rel="stylesheet"  href="http://localhost:9000/css/mycgv.css">
<script src="http://localhost:9000/js/jquery-3.6.0.min.js"></script>
<script src="http://localhost:9000/js/mycgv_index.js"></script>
<script>
	let login_result = '${login_result}';
	let logout_result = '${logout_result}';
	
	if(logout_result == 'ok'){
		alert("로그아웃에 성공하셨습니다.");
	}
	
	if(login_result == 'ok'){
		alert("로그인에 성공하셨습니다.");
	}else if(login_result == 'fail'){
		alert("아이디 또는 패스워드가 정확하지 않습니다. \r 로그인을 다시 진행해주세요");
		location.href = "http://localhost:9000/login";
	} 
</script>
<style>
	.notice_list li span{
		display:inline-block;
		padding:0 8px; 
	}
</style>

 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
 <!--  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script> -->
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  <style>
  /* Make the image fully responsive */
  .carousel-inner img {
    width: 100%;
    height: 100%;
  }
  </style>
</head>
<body>
	<!-- Header Include -->
	<iframe src="http://localhost:9000/header" width="100%" height="160px" scrolling="no" frameborder=0 ></iframe>
	
	
	<!---------------------------------------------->
	<!--------------- Content ----------------------->
	<!---------------------------------------------->
	<div class="carousel">
		<h1>메인-캐러셀</h1>
		
		<!-- 캐러셀 start -->
		<div id="demo" class="carousel slide" data-ride="carousel">
		 <!-- Indicators -->
		  <ul class="carousel-indicators">
		    <li data-target="#demo" data-slide-to="0" class="active"></li>
		    <li data-target="#demo" data-slide-to="1"></li>
		    <li data-target="#demo" data-slide-to="2"></li>
		    <li data-target="#demo" data-slide-to="3"></li>
		  </ul>
		  
		  <!-- The slideshow -->
		  <div class="carousel-inner">
		    <div class="carousel-item active">
		      <img src="http://localhost:9000/images/carousel_01.jpg"  >
		    </div>
		    <div class="carousel-item">
		      <img src="http://localhost:9000/images/carousel_02.jpg"  >
		    </div>
		    <div class="carousel-item">
		      <img src="http://localhost:9000/images/carousel_03.jpg"  >
		    </div>
		     <div class="carousel-item">
		      <img src="http://localhost:9000/images/carousel_04.jpg"   >
		    </div>
		  </div>
		  
		  <!-- Left and right controls -->
		  <a class="carousel-control-prev" href="#demo" data-slide="prev">
		    <span class="carousel-control-prev-icon"></span>
		  </a>
		  <a class="carousel-control-next" href="#demo" data-slide="next">
		    <span class="carousel-control-next-icon"></span>
		  </a>
		</div>
		<!-- 캐러셀  end -->
		
	</div>
	<div class="content">
		<section>
			<h1>무비차트 | 상영예정작</h1>
			<div class="s1_article">
				<article>
					<img src="http://localhost:9000/images/82120_320.jpg">
					<div>탑건-매버릭</div>
					<div>99%  | 예매율 37.1%</div>
				</article>
				<article>
					<img src="http://localhost:9000/images/82120_320.jpg">
					<div>탑건-매버릭</div>
					<div>99%  | 예매율 37.1%</div>
				</article>
				<article>
					<img src="http://localhost:9000/images/82120_320.jpg">
					<div>탑건-매버릭</div>
					<div>99%  | 예매율 37.1%</div>
				</article>
				<article>
					<img src="http://localhost:9000/images/82120_320.jpg">
					<div>탑건-매버릭</div>
					<div>99%  | 예매율 37.1%</div>
				</article>
				<article>
					<img src="http://localhost:9000/images/82120_320.jpg">
					<div>탑건-매버릭</div>
					<div>99%  | 예매율 37.1%</div>
				</article>
			</div>
		</section>
		
		<section>
			<h1>특별관</h1>
			<div class="s2_article">
				<div>
					<img src="http://localhost:9000/images/16390080561620.png">
				</div>
				<!-- Ajax + Dynamic HTML 로 생성된 공지사항 출력위치 -->
			</div>
		</section>
		
		<section>
			<ul>
				<li>
					<h3>영화관람권</h3>
					<button type="button">더보기</button>
				</li>
				<li>
					<img src="http://localhost:9000/images/16094706927780.jpg">
					<div>
						<label>CGV 영화관람권</label>
						<label>12,000원</label>
					</div>
				</li>
				<li>
					<img src="http://localhost:9000/images/16094706927780.jpg">
					<div>
						<label>CGV 영화관람권</label>
						<label>12,000원</label>
					</div>
				</li>
				<li>
					<img src="http://localhost:9000/images/16094706927780.jpg">
					<div>
						<label>CGV 영화관람권</label>
						<label>12,000원</label>
					</div>
				</li>
			</ul>
			<ul>
				<li>
					<h3>영화관람권</h3>
					<button type="button">더보기</button>
				</li>
				<li >
					<img src="http://localhost:9000/images/16094706927780.jpg">
					<div>
						<label>CGV 영화관람권</label>
						<label>12,000원</label>
					</div>
				</li>
				<li>
					<img src="http://localhost:9000/images/16094706927780.jpg">
					<div>
						<label>CGV 영화관람권</label>
						<label>12,000원</label>
					</div>
				</li>
				<li>
					<img src="http://localhost:9000/images/16094706927780.jpg">
					<div>
						<label>CGV 영화관람권</label>
						<label>12,000원</label>
					</div>
				</li>
			</ul>
			<ul>
				<li>
					<h3>영화관람권</h3>
					<button type="button">더보기</button>
				</li>
				<li >
					<img src="http://localhost:9000/images/16094706927780.jpg">
					<div>
						<label>CGV 영화관람권</label>
						<label>12,000원</label>
					</div>
				</li>
				<li>
					<img src="http://localhost:9000/images/16094706927780.jpg">
					<div>
						<label>CGV 영화관람권</label>
						<label>12,000원</label>
					</div>
				</li>
				<li>
					<img src="http://localhost:9000/images/16094706927780.jpg">
					<div>
						<label>CGV 영화관람권</label>
						<label>12,000원</label>
					</div>
				</li>
			</ul>
		</section>		
	</div>
	
	<!-- footer Include -->
	<iframe src="http://localhost:9000/footer" width="100%" height="530px" scrolling="no" frameborder=0></iframe>
	
</body>
</html>







