<div class="container">
	<div class="row">
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp" %>
		</div>
		<div class="col-md-9">
			<div class="row">
				<div class="col-md-12">
				<c:if test='${userClickAllProducts == true}'>
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
						<li class="breadcrumb-item active">All Products</li>
					</ol>
				</c:if>
				<c:if test='${userClickCategoryProducts == true}'>
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
						<li class="breadcrumb-item active">category</li>
						<li class="breadcrumb-item active">${category.name}</li>
					</ol>
				</c:if>
				<div class="col-xs-12">
					<table id="productListTable" class="table table-border table-stripped">
						<thead>
							<tr>
								<th>Name</th>
								<th>ID</th>
							</tr>
						</thead>
					</table>
				</div>
				</div>	
			</div>
		</div>
	</div>
</div>