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
					<sf:form modelAttribute="billing"
						method="POST">
						<div class="form-group row">
							<label class="col-form-label col-md-4" for="name">
								Address Line 1 </label>
							<div class="col-md-8">
								<sf:input type="text" id="addressLine1" path="addressLine1"
									placeholder="Address Line 1" class="form-control" />
								<sf:errors path="addressLine1" cssClass="form-text" element="em"></sf:errors>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-form-label col-md-4" for="brand">
								Address Line 2 </label>
							<div class="col-md-8">
								<sf:input type="text" id="addressLine2" path="addressLine2"
									placeholder="Address Line 2" class="form-control" />
								<sf:errors path="addressLine2" cssClass="form-text" element="em"></sf:errors>
							</div>
						</div>
						
						<div class="form-group row">
							<label class="col-form-label col-md-4" for="unit_price">City </label>
							<div class="col-md-8">
								<sf:input type="text" id="city" path="city"
									class="form-control" />
								<sf:errors path="city" cssClass="form-text" element="em"></sf:errors>
							</div>
						</div>
						
						<div class="form-group row">
							<label class="col-form-label col-md-4" for="quantity">State </label>
							<div class="col-md-8">
								<sf:input type="text" id="state" path="state"
									class="form-control" />
								<sf:errors path="state" cssClass="form-text" element="em"></sf:errors>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-form-label col-md-4" for="quantity">
								Country </label>
							<div class="col-md-8">
								<sf:input type="text" id="country" path="country"
									class="form-control" />
								<sf:errors path="country" cssClass="form-text" element="em"></sf:errors>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-form-label col-md-4" for="quantity">
								Postal Code </label>
							<div class="col-md-8">
								<sf:input type="text" id="postalCode" path="postalCode"
									class="form-control" />
								<sf:errors path="postalCode" cssClass="form-text" element="em"></sf:errors>
							</div>
						</div>
						<button type="submit" class="btn btn-primary" name="_eventId_personal"> Previous - Personal</button>
						<button type="submit" class="btn btn-primary" name="_eventId_confirm"> Next - Confirm</button>
					</sf:form>
					<br>
				</div>
			</div>
		</div>
		</div>
	</div>
<%@include file="../shared/flows-footer.jsp" %>
  

