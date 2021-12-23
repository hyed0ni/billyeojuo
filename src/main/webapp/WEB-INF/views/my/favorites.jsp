<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- JSTL c태그 사용을 위한 taglib 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                                        <span class="purple price_font">${ll.roomPrice}</span>
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

</main>

<!-- footer include -->
<jsp:include page="../common/footer.jsp"/>
</body>
</html>