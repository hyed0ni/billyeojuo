<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- JSTL c태그 사용을 위한 taglib 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%-- 프로젝트의 시작 주소를 간단히 얻어올 수 있도록 application scope로 contextPath라는 변수를 생성함--%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!-- header include -->
<jsp:include page="../common/header.jsp" />


<section class="search-wrapper">
	<div class="center_wrap">
		<a href="">${param.sv}</a>(으)로 <span class="txt_result">검색한 결과입니다.</span>
	</div>
</section>
<main>
	<section id="space-wrapper">
		<c:forEach items="${searchList}" var="sl">
		<article class="space-space-list">
			<a href="${contextPath}/space/detail?no=${sl.spaceNo}">
				<div class="img-box"  style="background-image: url(${contextPath}${sl.imgPath}${sl.imgName})"></div>
				<div class="info-box">
					<h3>${sl.spaceNm}</h3>
					<div class="tag-box">
						<span class="location">${sl.spaceSubNm}
					</div>
					<div class="price-box">
						<strong class="price purple"><fmt:formatNumber value="${sl.roomPrice}" pattern="#,###"/></strong> <span>원/박</span>
						<div class="like-comment">
							<span class="pricebox-icon icon-people"></span> <span>${sl.roomFit}</span> <span class="pricebox-icon icon-like"></span> <span>${sl.like}</span>
						</div>
					</div>
				</div>
			</a>
		</article>
</c:forEach>	
		
	</section>

	<section class="space" style="height: 70px;"></section>
	
</main>

<!-- footer include -->
<jsp:include page="../common/footer.jsp" />
