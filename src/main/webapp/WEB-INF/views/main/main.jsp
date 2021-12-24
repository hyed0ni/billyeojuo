<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- JSTL c태그 사용을 위한 taglib 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%-- 프로젝트의 시작 주소를 간단히 얻어올 수 있도록 application scope로 contextPath라는 변수를 생성함--%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!-- header include -->
<jsp:include page="../common/header.jsp"/>


<main>
    <section class="main-pic">
        <img src="${contextPath}/resources/images/main/mainpage_img.jpg">
    </section>

    <section id="icons">
    	<c:forEach items="${spaceTypeList}" var="spaceType">
	    	<a href="${contextPath}/space/search?sv=${spaceType.spaceTypeNm}" class="icon-a">
	            <img src="${contextPath}/resources/images/space_type/${spaceType.spaceTypeImg}.png" alt="">
	            <div class="main-icons-text">${spaceType.spaceTypeNm}</div>
	        </a>
    	</c:forEach>
    	
    </section>

    <section class="space"></section>
      <section class="space"></section>
    
    <section id="promotions">
        <h1 class="title">기획전</h1>
        <p style="margin-top: 0px; text-align: center;">지금 딱 내가 찾는 공간</p>
        <div class="promotion">
            <c:forEach items="${promotionList}" var="promotion">
	        	<a href="${contextPath}/promotion_detail?no=${promotion.exNo}" style="background-image: url(${contextPath}/resources/images/promotion/${promotion.exImg}.png)">
	                <h3 class="promotion-title">${promotion.exNm}</h3><br>
	                <p>${promotion.exSubNm}</p>
	            </a>
	        </c:forEach>

            <div class="more" >
                <a href="${contextPath}/promotion" >+ 더보기</a>
            </div>
        </div>
    </section>
    
    <section class="space"></section>

    <section id="recommends">
        <h1 class="title">추천공간</h1>
        <p style="margin-top: 0px; text-align: center;">지금 딱 내가 찾는 공간</p>
        <section>
            <c:forEach  items="${recommendList}" var="recommend">
	            <article  class="recommend-item">
	                <a href="${contextPath}/space/detail?no=${recommend.spaceNo}">
	                    <div class="img-box" style="background-image: url(${contextPath}${recommend.imgPath}${recommend.imgName})">
	                    </div>
	                    
	                    <div class="info-box">
	                        <h3>${recommend.spaceNm}</h3>
	                        <div class="tag-box">
	                            <span class="location"> ${recommend.spaceSubNm}</span>
	                        </div>
	                        <div class="price-box">
	                            <strong class="price purple"><fmt:formatNumber value="${recommend.roomPrice}" pattern="#,###"/></strong> <span>원/박</span>
	                            <div class="like-comment" >
	                              <%--   <span class="pricebox-icon icon-comment"></span>
	                                <span>${recommend.like}</span> --%>
	                                <span class="pricebox-icon icon-people"></span>
	                                <span>${recommend.roomFit}</span>
	                                <span class="pricebox-icon icon-like"></span>
	                                <span>${recommend.like}</span>
	                            </div>
	                        </div>
	                    </div>
	                </a>
	            </article>
            </c:forEach>
        </section>
    </section>

    <section class="space"></section>
    <section class="space"></section>
</main>

<!-- footer include -->
<jsp:include page="../common/footer.jsp"/>

</body>
</html>
