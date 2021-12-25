<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- JSTL c태그 사용을 위한 taglib 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<%-- 프로젝트의 시작 주소를 간단히 얻어올 수 있도록 application scope로 contextPath라는 변수를 생성함--%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!-- header include -->
<jsp:include page="../common/header.jsp"/>

<main>
  <section class="promotion-main">
    <div>
    <h1 style="font-size: 36px; line-height: 40px; margin-top: 110px;">${title.exNm}</h1>
    <p style="font-size: 18px;">${title.exSubNm}</p>
    
    </div>
    <div class="promotoin-main-img" style="background-image: url('${contextPath}/resources/images/promotion/${title.exImg}.png');"></div>
  </section>

  <section class="space"></section>

  <section ion id="promotion-wrapper">
	<c:forEach  items="${proDetailList}" var="proDetail">  
	  <article  class="promotion-space-list">
		<a href="${contextPath}/space/detail?no=${proDetail.spaceNo}">
	       <div class="img-box" style="background-image: url(${contextPath}${proDetail.imgPath}${proDetail.imgName})">
	       </div>
	       
      	   <div class="info-box">
	           <h3>${proDetail.spaceNm}</h3>
	           <div class="tag-box">
	               <span class="location"> ${proDetail.spaceSubNm}</span>
	           </div>
	           <div class="price-box">
	               <strong class="price purple"><fmt:formatNumber value="${proDetail.roomPrice}" pattern="#,###"/></strong> <span>원/박</span>
	               <div class="like-comment">
	                 <%--   <span class="pricebox-icon icon-comment"></span>
	                   <span>${recommend.like}</span> --%>
	                   <span class="pricebox-icon icon-people"></span>
	                   <span>${proDetail.roomFit}</span>
	                   <span class="pricebox-icon icon-like"></span>
	                   <span>${proDetail.like}</span>
	               </div>
	           </div>
       		</div>
  		  </a>
	 	</article>	
	</c:forEach>
  </section>
  	<!-- 주소에 쿼리스트링을 노출 시키지 않고 값 전송 -->
	
	<form action="#" method="post" name="requestForm">
		<input type="hidden" name="no" value="${param.no}">
	</form>

  <section class="space" style="height: 70px;"></section>
</main>

<!-- footer include -->
<jsp:include page="../common/footer.jsp"/>
</body>
</html>