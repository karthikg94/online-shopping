<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<div class="container">
	<div class="row">
		<c:if test='${not empty message}'>
			<div
				class="alert alert-success alert-dismissible fade show col-md-12"
				role="alert">
				${message}
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>
		<div class="offset-md-2 col-md-8">
			<div class="card card-primary">
				<div class="card-header">
					<div class="offset-md-4">
						<h4>Product Management</h4>
					</div>
				</div>
				<br>
				<div class="card-block offset-md-1 col-md-10">
					<sf:form modelAttribute="product"
						action="${contextRoot}/manage/products" method="POST"
						enctype="multipart/form-data">
						<div class="form-group row">
							<label class="col-form-label col-md-4" for="name">Enter
								Product Name </label>
							<div class="col-md-8">
								<sf:input type="text" id="name" path="name"
									placeholder="Product Name" class="form-control" />
								<sf:errors path="name" cssClass="form-text" element="em"></sf:errors>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-form-label col-md-4" for="brand">Enter
								Brand Name </label>
							<div class="col-md-8">
								<sf:input type="text" id="brand" path="brand"
									placeholder="Brand Name" class="form-control" />
								<sf:errors path="brand" cssClass="form-text" element="em"></sf:errors>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-form-label col-md-4" for="description">Product
								Description </label>
							<div class="col-md-8">
								<sf:textarea id="description" path="description"
									class="form-control" />
								<sf:errors path="description" cssClass="form-text" element="em"></sf:errors>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-form-label col-md-4" for="unit_price">Enter
								Unit Price </label>
							<div class="col-md-8">
								<sf:input type="text" id="unit_price" path="unit_price"
									class="form-control" />
								<sf:errors path="unit_price" cssClass="form-text" element="em"></sf:errors>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-form-label col-md-4" for="file">Upload
								a Image </label>
							<div class="col-md-8">
								<sf:input type="file" id="file" path="file" class="form-control" />
								<sf:errors path="file" cssClass="form-text" element="em"></sf:errors>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-form-label col-md-4" for="quantity">Quantity
								Avaliable </label>
							<div class="col-md-8">
								<sf:input type="number" id="quantity" path="quantity"
									class="form-control" />
							</div>
						</div>
						<div class="form-group row">
							<label class="col-form-label col-md-4" for="category_id">Select
								Category </label>
							<div class="col-md-8">
								<sf:select class="form-control" id="category_id"
									path="category_id" items="${categories}" itemLabel="name"
									itemValue="id">
								</sf:select>
							</div>
						</div>
						<c:if test='${product.id == null}'>
							<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addCategory">
	  							Add New Category
							</button>
						</c:if>
						<button type="submit" class="btn btn-primary">Submit</button>
						<sf:hidden path="id" />
						<sf:hidden path="code" />
						<sf:hidden path="is_active" />
						<sf:hidden path="supplier_id" />
						<sf:hidden path="purchases" />
						<sf:hidden path="views" />
					</sf:form>
					<br>
				</div>
			</div>
		</div>
	</div>
	<br><div class="row">
		<div class="col-md-12">
			<span><h3>Avaliable Products</h3></span>
		</div>
		<div class="col-md-12">
			<table id="adminProductList" class="table table-stripped table-border ">
				<thead>
					<tr>
						<th>Id</th>
						<th>Image</th>
						<th>Name</th>
						<th>Unit_Price</th>
						<th>Quantity</th>
						<th>Active</th>
						<th>Edit</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
	<div class="modal fade" id="addCategory" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	  <div class="modal-dialog modal-dialog-centered" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLongTitle">ADD NEW CATEGORY</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <sf:form modelAttribute="category" action="${contextRoot}/manage/add/category" method="POST" id="categoryFormId">
	      	<div class="modal-body">
						<div class="form-group row">
							<label class="col-form-label col-md-4" for="name">Category Name </label>
							<div class="col-md-8">
								<sf:input type="text" id="cname" path="name" placeholder="Category Name" class="form-control" />
							</div>
						</div>
						<div class="form-group row">
							<label class="col-form-label col-md-4" for="name">Category Description </label>
							<div class="col-md-8">
								<sf:input type="text" id="cdesc" path="desc" placeholder="Category Description" class="form-control" />
							</div>
						</div>
	      	</div>
	       	<div class="modal-footer">
        		<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        		<button type="submit" class="btn btn-primary">Save changes</button>
      		</div>
      		</sf:form>
	    </div>
	  </div>
</div>
</div>