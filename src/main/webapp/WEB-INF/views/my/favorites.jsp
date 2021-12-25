<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- JSTL c태그 사용을 위한 taglib 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%-- 프로젝트의 시작 주소를 간단히 얻어올 수 있도록 application scope로 contextPath라는 변수를 생성함--%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!-- header include -->
<jsp:include page="../common/header.jsp"/>

<main>
    <section class="favorites">
        <div class="title">찜한 공간</div>
        <div class="favorites_area">
            <!-- <div class="non_list_area">
                <div  class="non_list">
                    <span>내가 가고 싶은 공간이 존재하지 않습니다.</span><br>
                    <span>가고 싶은 공간을 발견하면 ♥로 찜해두세요.</span>
                </div>
            </div> -->
            <div class="list_area">
                <ul>
                <c:forEach items="${likeList}" var="ll">
                    <li class="list">
                        <a href="${contextPath}/space/detail?no=${ll.spaceNo}">
                            <div><img src="${contextPath}${ll.imgPath}${ll.imgName}"></div>
                            <div class="list_title_area">
                                <div class="list_title">${ll.spaceNm}</div>
                                <div class="list_tag_area">
                                    <span>
                                        ${ll.spaceSubNm}
                                    </span>
                                </div>
                                <div class="list_price_area">
                                    <div class="price_area">
                                        <span class="purple price_font"><strong><fmt:formatNumber value="${ll.roomPrice}" pattern="#,###"/></strong></span>
                                        <span>원/박</span>
                                    </div>
                                    <div class="person">
                                        <span><img src="${contextPath}/resources/images/icon/face.svg" class="ico_person">${ll.roomFit}</span>
                                        <span><img src="${contextPath}/resources/images/icon/favorite.svg" class="ico_person">${ll.like}</span>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </li>
                  </c:forEach>

                </ul>
            </div>
        </div>
    </section>
    		<div class=pagination style="text-align: center; margin-top: 40px;">
			<c:choose>
			 <c:when test="${pagination.startPage != 1}">
				<a href="${contextPath}/space/search?sv=${param.sv}&cp=${pagination.prevPage}" class="prevPage arrow"  style="color: #6d3afb;">◀</a>
			 </c:when>
			 <c:otherwise>
			 	<span class="arrow">◁</span>
			 </c:otherwise>
			 </c:choose>
			 	
			 	<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" step="1" var="i">
				 	<c:choose>
						<c:when test="${i==pagination.currentPage}">
							<span class="num" style="color: #6d3afb; font-weight: bold;" >${pagination.currentPage}</span>
						</c:when>
						
						<c:otherwise>
							<a href="${contextPath}/space/search?sv=${param.sv}&cp=${i}" class="num">${i}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				
			<c:choose>
				<c:when test="${pagination.currentPage} != ${pagination.endPage}">
				<a href="${contextPath}/space/search?sv=${param.sv}&cp=${pagination.nextPage}" class="nextPage arrow"  style="color: #6d3afb;">▶</a>
				</c:when>
				<c:otherwise>
				<span class="arrow" >▷</span>
				</c:otherwise>
			</c:choose>
		</div>
	  <section class="space" style="height: 70px;"></section>
</main>

<!-- footer include -->
<jsp:include page="../common/footer.jsp"/>
</body>
</html>