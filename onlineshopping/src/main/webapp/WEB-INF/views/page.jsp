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
  <meta name="_csrf" content="${_csrf.token}"/>
  <meta name="_csrf_header" content="${_csrf.headerName}"/>
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
  <link href="${css}/shop-homepage.css" rel="stylesheet">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  
</head>

<body>
	
  <%@include file="./shared/navigation.jsp" %>
  <c:if test="${userClickHome == true }">
  	<%@include file="home.jsp" %>
  </c:if>
  <c:if test="${userClickAbout == true }">
  	<%@include file="about.jsp" %>
  </c:if>
  <c:if test="${userClickContact == true }">
  	<%@include file="contact.jsp" %>
  </c:if>
  <c:if test="${userClickAllProducts == true }">
  	<%@include file="listProducts.jsp" %>
  </c:if>
  <c:if test="${userClickCategoryProducts == true }">
  	<%@include file="listProducts.jsp" %>
  </c:if>
  <c:if test="${userClickSingleProductView == true }">
  	<%@include file="singleProduct.jsp" %>
  </c:if>
  <c:if test="${userClickedManageProduct == true }">
  	<%@include file="manageProduct.jsp" %>
  </c:if>
  <c:if test="${userClickedShowCart == true }">
  	<%@include file="Cart.jsp" %>
  </c:if>
  
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
