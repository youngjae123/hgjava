<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	
<div class="container px-4 px-lg-5 mt-5">
	<div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
	<c:forEach items="${list }" var="vo">
		<div class="col mb-5">
			<div class="card h-100">
				<!-- Product image-->
				<img class="card-img-top" src="resources/images/${vo.prodImage }" alt="..." />
				<!-- Product details-->
				<div class="card-body p-4">
					<div class="text-center">
						<!-- Product name-->
						<h5 class="fw-bolder">${vo.prodName }</h5>
						<!-- Product reviews-->
                                    <div class="d-flex justify-content-center small text-warning mb-2">
                                        <c:forEach var="i" begin="1" end="${vo.likeIt }">
                                        <div class="bi-star-fill"></div>
                                        </c:forEach>
                                    </div>
						<!-- Product price-->
						<span class="text-muted text-decoration-line-through">${vo.price }</span>
                                    ${vo.offPrice }
					</div>
				</div>
		<!-- Product actions-->
				<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
					<div class="text-center">
						<a class="btn btn-outline-dark mt-auto" href="productInfo.do?code=${vo.prodCode }">Add to cart</a>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
	
	</div>