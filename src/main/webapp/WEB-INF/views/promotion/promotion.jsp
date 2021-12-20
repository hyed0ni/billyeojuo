<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- JSTL c태그 사용을 위한 taglib 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 프로젝트의 시작 주소를 간단히 얻어올 수 있도록 application scope로 contextPath라는 변수를 생성함--%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!-- header include -->
<jsp:include page="../common/header.jsp"/>

<main>
  <section class="space"></section>

  <section id="promotion-page">
    <h1>기획전</h1>
    <p>스클 MD가 큐레이션한 기획전 입니다</p>
    <section id="promotion-list">
      <div class="promotion-list-wrap">
      
	      <c:forEach items="${promotionList}" var="promotion">
	      	<article class="box-size">
	          <div class="list-img" style="background-image: url('${contextPath}/resources/images/promotion/${promotion.exImg}.png')">
	            <a href="promotion_detail?no=${promotion.exNo}">
	              <h3>${promotion.exNm}</h3>
	              <p>${promotion.exSubNm}</p>
	            </a>  
	          </div>
	        </article>
	      </c:forEach>

      </div>
    </section>
  </section>

</main>

<!-- footer include -->
<jsp:include page="../common/footer.jsp"/>

