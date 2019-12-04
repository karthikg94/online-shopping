<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@include file="../shared/flows-header.jsp" %>
  	<div class="container">
		<div class="row">
			<div class="offset-md-2 col-md-8">
			<div class="card card-primary">
				<div class="card-header">
					<div class="offset-md-4">
						<h4>Personal Details</h4>
					</div>
				</div>
				<br>
				<div class="card-block offset-md-1 col-md-10">
					<sf:form modelAttribute="user"
						method="POST">
						<div class="form-group row">
							<label class="col-form-label col-md-4" for="name">Enter
								First Name </label>
							<div class="col-md-8">
								<sf:input type="text" id="firstName" path="firstName"
									placeholder="First Name" class="form-control" />
							</div>
						</div>
						<div class="form-group row">
							<label class="col-form-label col-md-4" for="brand">Enter
								Last Name </label>
							<div class="col-md-8">
								<sf:input type="text" id="lastName" path="lastName"
									placeholder="Last Name" class="form-control" />
							</div>
						</div>
						
						<div class="form-group row">
							<label class="col-form-label col-md-4" for="unit_price">Enter
								Email </label>
							<div class="col-md-8">
								<sf:input type="text" id="email" path="email"
									class="form-control" />
							</div>
						</div>
						
						<div class="form-group row">
							<label class="col-form-label col-md-4" for="quantity">
								Password </label>
							<div class="col-md-8">
								<sf:input type="password" id="password" path="password"
									class="form-control" />
							</div>
						</div>
						<div class="form-group row">
							<label class="col-form-label col-md-4" for="quantity">
								Contact Number </label>
							<div class="col-md-8">
								<sf:input type="text" id="contactNumber" path="contactNumber"
									class="form-control" />
							</div>
						</div>
						<div class="form-group row">
							<label class="col-form-label col-md-4" for="quantity">
								Select Role </label>
							<div class="col-md-8">
								<label class="radio-inline">
      								<sf:radiobutton path="role" value="user" checked="checked"/>User
    							</label>
    							<label class="radio-inline">
      								<sf:radiobutton path="role" value="supplier"/>Supplier
    							</label>
							</div>
						</div>
						<button type="submit" class="btn btn-primary" name="_eventId_billing" id="billing"> Next</button>
					</sf:form>
					<br>
				</div>
			</div>
		</div>
		</div>
	</div>
<%@include file="../shared/flows-footer.jsp" %>
  

