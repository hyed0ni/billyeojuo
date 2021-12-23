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
                    <li class="list">
                        <a href="#">
                            <div><img src="${contextPath}/resources/images/space_img/sadang.jpg"></div>
                            <div class="list_title_area">
                                <div class="list_title">단독홀 사당20평 할인특가 블루i</div>
                                <div class="list_tag_area">
                                    <span>
                                        사당동 
                                        <span class="bar"></span>
                                    </span>
                                    <span>#사당역3분</span>
                                    <span>#이수역</span>
                                    <span>#각종방송촬영</span>
                                    <span>#커버영상촬영</span>
                                    <span>#최대30%특가할인</span>
                                </div>
                                <div class="list_price_area">
                                    <div class="price_area">
                                        <span class="purple price_font">5,000</span>
                                        <span>원/시간</span>
                                    </div>
                                    <div class="person">
                                        <span><img src="${contextPath}/resources/images/icon/face.svg" class="ico_person">최대 30인</span>
                                        <span><img src="${contextPath}/resources/images/icon/talk.svg" class="ico_person">50</span>
                                        <span><img src="${contextPath}/resources/images/icon/favorite.svg" class="ico_person">658</span>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </li>
                    <li class="list">
                        <a href="#">
                            <div><img src="${contextPath}/resources/images/space_img/sinchon.jpg"></div>
                            <div class="list_title_area">
                                <div class="list_title">단독홀 사당20평 할인특가 블루i</div>
                                <div class="list_tag_area">
                                    <span>
                                        사당동 
                                        <span class="bar"></span>
                                    </span>
                                    <span>#사당역3분</span>
                                    <span>#이수역</span>
                                    <span>#각종방송촬영</span>
                                    <span>#커버영상촬영</span>
                                    <span>#최대30%특가할인</span>
                                </div>
                                <div class="list_price_area">
                                    <div class="price_area">
                                        <span class="purple price_font">5,000</span>
                                        <span>원/시간</span>
                                    </div>
                                    <div class="person">
                                        <span><img src="${contextPath}/resources/images/icon/face.svg" class="ico_person">최대 30인</span>
                                        <span><img src="${contextPath}/resources/images/icon/talk.svg" class="ico_person">50</span>
                                        <span><img src="${contextPath}/resources/images/icon/favorite.svg" class="ico_person">658</span>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </li>
                    <li class="list">
                        <a href="#">
                            <div><img src="${contextPath}/resources/images/space_img/sadang.jpg"></div>
                            <div class="list_title_area">
                                <div class="list_title">단독홀 사당20평 할인특가 블루i</div>
                                <div class="list_tag_area">
                                    <span>
                                        사당동 
                                        <span class="bar"></span>
                                    </span>
                                    <span>#사당역3분</span>
                                    <span>#이수역</span>
                                    <span>#각종방송촬영</span>
                                    <span>#커버영상촬영</span>
                                    <span>#최대30%특가할인</span>
                                </div>
                                <div class="list_price_area">
                                    <div class="price_area">
                                        <span class="purple price_font">5,000</span>
                                        <span>원/시간</span>
                                    </div>
                                    <div class="person">
                                        <span><img src="${contextPath}/resources/images/icon/face.svg" class="ico_person">최대 30인</span>
                                        <span><img src="${contextPath}/resources/images/icon/talk.svg" class="ico_person">50</span>
                                        <span><img src="${contextPath}/resources/images/icon/favorite.svg" class="ico_person">658</span>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </li>
                    <li class="list">
                        <a href="#">
                            <div><img src="${contextPath}/resources/images/space_img/sinchon.jpg"></div>
                            <div class="list_title_area">
                                <div class="list_title">단독홀 사당20평 할인특가 블루i</div>
                                <div class="list_tag_area">
                                    <span>
                                        사당동 
                                        <span class="bar"></span>
                                    </span>
                                    <span>#사당역3분</span>
                                    <span>#이수역</span>
                                    <span>#각종방송촬영</span>
                                    <span>#커버영상촬영</span>
                                    <span>#최대30%특가할인</span>
                                </div>
                                <div class="list_price_area">
                                    <div class="price_area">
                                        <span class="purple price_font">5,000</span>
                                        <span>원/시간</span>
                                    </div>
                                    <div class="person">
                                        <span><img src="${contextPath}/resources/images/icon/face.svg" class="ico_person">최대 30인</span>
                                        <span><img src="${contextPath}/resources/images/icon/talk.svg" class="ico_person">50</span>
                                        <span><img src="${contextPath}/resources/images/icon/favorite.svg" class="ico_person">658</span>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </section>

</main>

<!-- footer include -->
<jsp:include page="../common/footer.jsp"/>
</body>
</html>