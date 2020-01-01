<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="#">Online Shopping</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active" id="home">
            <a class="nav-link" href="${contextRoot}/home">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item" id="about">
            <a class="nav-link" href="${contextRoot}/about">About</a>
          </li>
          <li class="nav-item" id="listProducts">
            <a class="nav-link" href="${contextRoot}/show/all/products">View Products</a>
          </li>
          <security:authorize access="hasAuthority('admin')">
	          <li class="nav-item" id="manageProducts">
	            <a class="nav-link" href="${contextRoot}/manage/products">Manage Products</a>
	          </li>
          </security:authorize>
          <li class="nav-item" id="contact">
            <a class="nav-link" href="${contextRoot}/contact">Contact</a>
          </li>
          <security:authorize access="isAnonymous()">
	          <li class="nav-item" id="register">
	            <a class="nav-link" href="${contextRoot}/register">Sign Up</a>
	          </li>
	          <li class="nav-item" id="login">
	            <a class="nav-link" href="${contextRoot}/login">Login In</a>
	          </li>
          </security:authorize>
          <security:authorize access="isAuthenticated()">
	          <li class="dropdown nav-item" id="userCart">
	          	 	<a href="javascript:void(0)" class="btn btn-default dropdown-toggle nav-link" id="dropdownMenu1" data-toggle="dropdown">
	          	 		${userModel.fullName}
	          	 		<span class="caret"></span>
	          	 	</a>
	          	 	<ul class="dropdown-menu">
	          	 		<security:authorize access="hasAuthority('user')">
		          	 		<li style="position:relative;left:20px">
		          	 			<a href="${contextRoot}/cart/show">
		          	 				<span>Cart(${userModel.cart.cartLine})</span>
		          	 				- &#8377; ${userModel.cart.grandTotal}
		          	 			</a>
		          	 		</li>
	          	 		</security:authorize>
	          	 		<li class="divider" role="separator"></li>
	          	 		<li style="position:relative;left:20px">
	          	 			<a href="${contextRoot}/logout">Logout</a>
	          	 		</li>
	          	 	</ul>
	          </li>
          </security:authorize>
        </ul>
      </div>
    </div>
  </nav>
  	<!-- ends -->
</body>
<script type="text/javascript">
	window.userRole = '${userModel.role}';
</script>
</html>