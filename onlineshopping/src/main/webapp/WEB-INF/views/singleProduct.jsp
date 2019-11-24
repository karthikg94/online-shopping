<div class="container">
	<div class="row">
		<div class="col-md-12">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
				<li class="breadcrumb-item"><a href="${contextRoot}/show/all/products">All Products</a></li>
				<li class="breadcrumb-item active">${product.name}</li>
			</ol>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-12 col-sm-4">
			<div class="thumbnail">
				<img alt="" src="${images}/${product.code}.jpg">
			</div>
		</div>
		<div class="col-xs-12 col-sm-8">
				<h4>${product.name}</h4><br></hr>
				<p>${product.description}</p><br></hr>
				<h3>Price : ${product.unit_price}</h3><br></hr>
				<c:choose>
					<c:when test="${product.quantity < 1}">
						<p>Quantity Avaliable : <span style="color:red">Out of stock</span></p><br></hr>
						<a  href ="javascript:void(0)" class="btn btn-success disabled"><strike><span class="glyphicon glyphicon-shopping-cart">Add to cart</strike></span></a>
					</c:when>
					<c:otherwise>
						<p>Quantity Avaliable : ${product.quantity}</p><br></hr>
						<a  href ="${contextRoot}/cart/add/${product.id}/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart">Add to cart</span></a>
					</c:otherwise>
				</c:choose>
				<a  href ="${contextRoot}/show/all/products" class="btn btn-primary">Back</a>
		</div>
	</div>

</div>