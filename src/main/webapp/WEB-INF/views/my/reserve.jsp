<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- JSTL c태그 사용을 위한 taglib 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%-- 프로젝트의 시작 주소를 간단히 얻어올 수 있도록 application scope로 contextPath라는 변수를 생성함--%>
<c:set var="contextPath"
	value="${pageContext.servletContext.contextPath}" scope="application" />

<!-- header include -->
<jsp:include page="../common/header.jsp" />

<main>
	<section class="reserve">
		<div class="title">예약 내역 리스트</div>
		<div class="reserve_area">
			<div class="sort_area">
				<select class="selectbox">
					<option value="reserve">예약번호순정렬</option>
					<option value="used">이용일자순정렬</option>
				</select> <select class="selectbox">
					<option>전체</option>
					<option>승인대기</option>
					<option>결제완료</option>
					<option>취소환불</option>
					<option>이용완료</option>
				</select>
			</div>
			<div class="list_area">

				<c:forEach items="${resList}" var="resSpace" varStatus="vs" >
            	
	                <a href="reservation_detail">
	                    <div class="list">
	                        <div>
	                            <div class="list_img"><img src="${contextPath}/resources/images/header/defaultUser.jpg"></div>
	                            <div class="list_description">
	                                <div class="tag_area">
	                                    <span class="tag approve">${resSpace.resDt}</span>
	                                </div>
	                                <div class="title">${resSpace.space.spaceNm}, ${resSpace.space.spaceRoomNm}</div>
	                                <div class="date">${fn:split(resSpace.useDate, ' ')[0]}</div>
	                                <div class="pay"><fmt:formatNumber value="${resSpace.space.spaceRoomPrice}" pattern="#,###"/>원</div>
	                            </div>
	                        </div>
	                    </div>
	                </a>
            	
            	</c:forEach>

			</div>
		</div>
	</section>
</main>


<!-- footer include -->
<jsp:include page="../common/footer.jsp" />
