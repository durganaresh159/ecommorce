<!-- Breadcrum -->
<div class="container">
	<div class="row">
		<div class="col-xs-12">
			<ol class="breadcrumb">
				<li><a href="${contextRoot}/home">Home</a></li>
				<li><a href="${contextRoot}/show/all/products">Home</a></li>
				<li class="active">${product.name}</li>
			</ol>
		</div>
	</div>
</div>

<!-- Display Image -->

<div class="col-xs-12 col-sm-4">
	<div class="thumbnail">
		<img src="${images}/${product.code}.jpg" class="img img-responsive" />
	</div>
</div>

<!-- Image Description -->
<div class="col-xs-12 col-sm-8">
	<h3>${product.name}</h3>
	<hr />
	<h3>${product.description}</h3>
	<hr />
	<h4>
		Price:<strong> &#8377;${product.unitPrice}</strong>
	</h4>
	<hr />
	<c:choose>
		<c:when test="${product.quantity<1}">
			<h6>
				Qty.Available :<span id="tagcolor">Out of stock!</span>
			</h6>
		</c:when>
		<c:otherwise>
			<h6>Qty.Available :${product.quantity}</h6>
		</c:otherwise>
	</c:choose>

	<c:choose>
		<c:when test="${product.quantity<1}">
			<h6>
				<a href="javascript:void(0)"
					class="btn btn-success disabled"><strike><span
						class="glyphicon glyphicon-shopping-cart"></span>Add to Cart</strike></a> <a
					href="${contextRoot}/show/all/products" class="btn btn-success">Back</a>
			</h6>
		</c:when>
		<c:otherwise>
			<a href="${contextRoot}/cart/add/${product.id}/product"
				class="btn btn-success"><span
				class="glyphicon glyphicon-shopping-cart"></span>Add to Cart</a>
			<a href="${contextRoot}/show/all/products" class="btn btn-success">Back</a>
		</c:otherwise>
	</c:choose>



</div>
