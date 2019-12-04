<%@include file="../shared/flows-header.jsp"%>
<div class="container">
	<div class="row">
		<div class="col-md-6">
			<div class="card card-primary">
				<div class="card-header">
					<div class="offset-md-4">
						<h4>Personal Details</h4>
					</div>
					<div class="card-body">
						<div class="text-center">
							<h4>FirstName - ${registerModel.user.firstName}</h4>
							<h4>LastName - ${registerModel.user.lastName}</h4>
							<h4>Email - ${registerModel.user.email}</h4>
							<h4>Contact Number - ${registerModel.user.contactNumber}</h4>
						</div>
					</div>
					<div class="card-footer">
						<a href="${flowExecutionUrl}&_eventId_personal" class="btn btn-primary">Edit</a>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-6">
			<div class="card card-primary">
				<div class="card-header">
					<div class="offset-md-4">
						<h4>Billing Details</h4>
					</div>
					<div class="card-body">
						<div class="text-center">
							<h4>Address1 - ${registerModel.billing.addressLine1}</h4>
							<h4>Address2 - ${registerModel.billing.addressLine2}</h4>
							<h4>City : ${registerModel.billing.city} - Postal Code : ${registerModel.billing.postalCode}</h4>
							<h4>State : ${registerModel.billing.state} - Country : ${registerModel.billing.country}</h4>
						</div>
					</div>
					<div class="card-footer">
						<a href="${flowExecutionUrl}&_eventId_confirm" class="btn btn-primary">Edit</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6">
			<div class="card-footer">
						<a href="${flowExecutionUrl}&_eventId_success" class="btn btn-primary">Save</a>
			</div>
		</div>
	</div>
</div>
<%@include file="../shared/flows-footer.jsp"%>