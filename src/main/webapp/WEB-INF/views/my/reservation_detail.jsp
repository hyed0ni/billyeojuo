<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- JSTL c태그 사용을 위한 taglib 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%-- 프로젝트의 시작 주소를 간단히 얻어올 수 있도록 application scope로 contextPath라는 변수를 생성함--%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!-- header include -->
<jsp:include page="../common/header.jsp"/>

<main>
  <section id="booking-wrap">
  <section class="booking-title">
    <div class="booking-img">
      <h3>공간 이름</h3><h3>결제 및 예약내역입니다.</h3>
    </div>
  </section>

    <section id="booking-info">
      <article class="booking-table">
        <div>
          <h4>예약내용</h4>
          <p class="bookingNo" style="float: right;">예약번호 : ${res.resNo}</p>
        </div>

        <div>
          <h5>결제일</h5>
          <p>${fn:split(res.payDate, ' ')[0]}</p>
        </div>

        <div>
          <h5>예약공간</h5>
          <p>${res.space.spaceNm}, ${res.space.spaceRoomNm}</p>
        </div>

        <div>
          <h5>예약일자</h5>
          <p>${fn:split(res.useDate, ' ')[0]}</p>
        </div>

        <div>
          <h5>예약인원</h5>
          <p>${res.resPersonnel}</p>
        </div>

        <div>
          <h5>요청사항</h5>
          <p>${res.resReq}</p>
        </div>

        <div>
          <h5>사용목적</h5>
          <p>${res.resPurpose}</p>
        </div>

      </article>
      <article class="booking-table">
        <div>
          <h4>예약자 정보</h4>
        </div>

        <div>
          <h5>예약자명</h5>
          <p>${res.resNm}</p>
        </div>
        <div>
          <h5>연락처</h5>
          <p>${res.resPno}</p>
        </div>
        <div>
          <h5>이메일</h5>
          <p>${res.resEmail}</p>
        </div>

      </article>
      <article class="booking-table">
        <div>
          <h4>환불규정 안내</h4>
        </div>
  
        <div>
          <h5 style="width: 90%; color: rgb(214, 0, 0); font-weight: bold;">이용당일(첫 날)에 환불 관련 사항은 호스트에게 직접 문의하셔야 합니다</h5>
          
          <c:set var="temp" value="${fn:replace(res.space.refundPolicy, '<br>', '|')}"/>
		  <c:set var="arr" value="${fn:split(temp, '|')}"/> 
          <p>
          	<c:forEach items="${arr}" var="refund" varStatus="vs">
           		<c:choose>
           			<c:when test="${vs.last}">
           				<strong class="tit" style="display:inline-block; width:100px;" >이용 당일</strong>
           				<span class="data">${refund}</span>
           			</c:when>
           			
           			<c:when test="${(fn:length(arr) - vs.count) == 1}">
           				<strong class="tit" style="display:inline-block; width:100px;">이용 전날</strong>
           				<span class="data">${refund}</span>
           			</c:when>
           			
           			<c:otherwise>
           				<strong class="tit" style="display:inline-block; width:100px;">이용 ${fn:length(arr) - vs.count}일전</strong>
           				<span class="data">${refund}</span>
           			</c:otherwise>
           		</c:choose>
           		<br>
           	</c:forEach>
          </p>
        </div>
        
      </article>
      <article class="booking-table" style="height: 760px;">
        <div style="background-color: white; ">
          <h4>예약공간 이름</h4>
        </div>
        
        <div>
          <p>
          	<span style="width: 100px; display: inline-block;">주소</span>${res.space.spaceAddr}
          </p><br>
          <p>
          	<span style="width: 102px; display: inline-block;">전화번호</span>${res.space.spacePno}
          </p>
        </div>

        <div class="map-aip">
        	<img src="${contextPath}${res.space.spaceMapPath}${res.space.spaceMapImg}" style="width: 673px; height: auto;  margin: 0;">
        </div>
        </article>
      
    </section>

    <aside id="cancel-control">
      <article class="cancel-info-box">
        <div>
          <h4>결제 금액</h4>
        </div>

        <div class="cancel-info-wrap cancel-bdPurple">
          <div>
            <h5>결제일</h5>
            <p>${fn:split(res.payDate, ' ')[0]}</p>
          </div>

          <div>
            <h5>예약일자</h5>
            <p>${fn:split(res.useDate, ' ')[0]}</p>
          </div>

          <div>
            <h5>예약인원</h5>
            <p>${res.resPersonnel}</p>
          </div>

          <div class="cancel-bdPurple" style="margin-top: 10px;">
            <h5 style="width: 100px;" >총 결제금액</h5>
            <p style="width: 200px; text-align: right;"><fmt:formatNumber value="${res.space.spaceRoomPrice}" pattern="#,###"/>원</p>
          </div>
        </div>

        <div id="cancel-btn" class="btn"> 
          <a href="">예약취소</a>
        </div>
      </article>
    </aside>

  </section>
</main>

<!-- footer include -->
<jsp:include page="../common/footer.jsp"/>

<c:if test="${!empty sessionScope.message}">
	<script>
		$(function() { 
			alert("${message}");
		})
	</script>
   <c:remove var="message" scope="session"/>
</c:if>