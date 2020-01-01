<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>
<spring:url var="js" value="/resources/js"></spring:url>
<spring:url var="css" value="/resources/css"></spring:url>
<spring:url var="images" value="/resources/Images"></spring:url>
<!DOCTYPE html>
<html lang="en">

<head>
	
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Online Shopping - ${title}</title>
	
  <script type="text/javascript">
  	window.menu = '${title}';
  	window.contextRoot = '${contextRoot}';
  </script>
  <!-- Bootstrap core CSS -->
  <link href="${css}/bootstrap.min.css" rel="stylesheet">
  <link href="${css}/bootstrap-theme.css" rel="stylesheet">
  
  <link href="${css}/jquery.dataTables.min.css" rel="stylesheet">
  <link href="${css}/dataTables.bootstrap.css" rel="stylesheet">
  <!-- Custom styles for this template -->
  <link href="${css}/login.css" rel="stylesheet">
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active" id="home">
						<span class="navbar-brand">Online Shopping</span>
					</li>
				</ul>
			</div>
		</div>
	</nav>
  <div class="wrapper fadeInDown">
  
  <div id="formContent">
    <br><br>
    <c:if test="${not empty errorMsg}">
  		<div class="form-text">
  			${errorMsg}
  		</div>
  		<br><br>
  	</c:if>
  	
    <!-- Login Form -->
    <form action="${contextRoot}/login" method="POST" id="loginForm">
      <input type="text" id="username" class="fadeIn second" name="username" placeholder="username">
      <input type="password" id="password" class="fadeIn third" name="password" placeholder="password">
      <input type="submit" class="fadeIn fourth" value="Log In">
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>

    <!-- Remind Passowrd -->
    <div id="formFooter">
      <a class="underlineHover" href="#">Forgot Password?</a>
    </div>

  </div>
</div>
  
  <%@include file="./shared/footer.jsp" %>

  <!-- Bootstrap core JavaScript -->
  <script src="${js}/jquery.min.js"></script>
  <script src="${js}/bootstrap.bundle.min.js"></script>
  <script src="${js}/jquery.dataTables.js"></script>
  <script src="${js}/dataTables.bootstrap.js"></script>
  <script src="${js}/jquery.dataTables.min.js"></script>
  <script src="${js}/bootbox.min.js"></script>
  <script src="${js}/jquery.validate.js"></script>
  <script src="${js}/myapp.js"></script>

</body>

</html>
