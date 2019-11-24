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
	
  <!-- Bootstrap core CSS -->
  <link href="${css}/bootstrap.min.css" rel="stylesheet">
  <link href="${css}/bootstrap-theme.css" rel="stylesheet">
  
  <link href="${css}/jquery.dataTables.min.css" rel="stylesheet">
  <link href="${css}/dataTables.bootstrap.css" rel="stylesheet">
  <!-- Custom styles for this template -->
  <link href="${css}/shop-homepage.css" rel="stylesheet">
</head>

<body>

  <div class="wrapper">
  	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
  		<div class="container">
  			<div class="navbar-header">
  				<a class="navbar-brand" href="${contextRoot}/home">Home</a>
  			</div>
  		</div>
  	</nav>
  	<div class="content">
  		<div class="container">
  			<div class="row">
  				<div class="col-md-12">
  					<div class="jumbotron">
  						<h1>${errorTitle}</h1>
  						<hr/>
  						<blockquote>
  							${errorDescription}
  						</blockquote>
  					</div>
  				</div>
  			</div>
  		</div>
  	</div>
  </div>
  
  <%@include file="./shared/footer.jsp" %>>

  <!-- Bootstrap core JavaScript -->
  <script src="${js}/jquery.min.js"></script>
  <script src="${js}/bootstrap.bundle.min.js"></script>
  <script src="${js}/jquery.dataTables.js"></script>
  <script src="${js}/dataTables.bootstrap.js"></script>
  <script src="${js}/jquery.dataTables.min.js"></script>
  <script src="${js}/myapp.js"></script>

</body>

</html>
