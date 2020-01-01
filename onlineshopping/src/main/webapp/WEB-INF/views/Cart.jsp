<div class="container">
	<c:choose>
		<c:when test="${not empty cartLine}">
			<table id="cart" class="table table-hover table-condensed">
				<thead>
					<tr>
						<th style="width: 50%">Product</th>
						<th style="width: 10%">Price</th>
						<th style="width: 8%">Quantity</th>
						<th style="width: 22%" class="text-center">Subtotal</th>
						<th style="width: 10%"></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${cartLine}" var="cartLine">
					<tr>
						<td data-th="Product">
							<div class="row">
								<div class="col-sm-3 hidden-xs">
									<img src="${images}/${cartLine.product.code}.jpg" alt="${cartLine.product.name}"
										class="img-responsive img_size_cart" />
								</div>
								<div class="col-sm-9">
									<h4 class="nomargin">${cartLine.product.name}</h4>
 										<c:if test="${cartLine.avaliable == false}"> 
 											<strong class="unavaliable">(Not Avaliable)</strong> 
 										</c:if> 
									<p>Brand - ${cartLine.product.brand}</p>
									<p>Description - ${cartLine.product.description}</p>
								</div>
							</div>
						</td>
						<td data-th="Price">${cartLine.buyingPrice}</td>
						<td data-th="Quantity"><input type="number"
							class="form-control text-center" value="${cartLine.productCount}"></td>
						<td data-th="Subtotal" class="text-center">${cartLine.total}</td>
						<td class="actions" data-th="">
							<button class="btn btn-info btn-sm">
								<i class="fa fa-refresh"></i>
							</button>
							<button class="btn btn-danger btn-sm">
								<i class="fa fa-trash-o"></i>
							</button>
						</td>
					</tr>
				</c:forEach>
				</tbody>
				<tfoot>
<!-- 					<tr class="visible-xs"> -->
<%-- 						<td class="text-center"><strong>${userModel.cart.grandTotal}</strong></td> --%>
<!-- 					</tr> -->
					<tr>
						<td><a href="#" class="btn btn-warning"><i
								class="fa fa-angle-left"></i> Continue Shopping</a></td>
						<td colspan="2" class="hidden-xs"></td>
						<td class="hidden-xs text-center"><strong>Total
								${userModel.cart.grandTotal}</strong></td>
						<td><a href="#" class="btn btn-success btn-block">Checkout
<!-- 								<i class="fa fa-angle-right"></i> -->
						</a></td>
					</tr>
				</tfoot>
			</table>
		</c:when>
		<c:otherwise>
			<div class="jumbotron">
				<div class="text-center">
					<h1>Your Cart is Empty</h1>
				</div>
			</div>
		</c:otherwise>
	</c:choose>
</div>