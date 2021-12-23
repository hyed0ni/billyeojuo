<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- JSTL c태그 사용을 위한 taglib 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 프로젝트의 시작 주소를 간단히 얻어올 수 있도록 application scope로 contextPath라는 변수를 생성함--%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!-- header include -->
<jsp:include page="../common/header.jsp"/>

<main>
    <section class="reserve">
        <div class="title">예약 내역 리스트</div>
        <div class="reserve_area">
            <div class="sort_area">
                <select class="selectbox">
                    <option value="reserve">예약번호순정렬</option>
                    <option value="used">이용일자순정렬</option>
                </select>
    
                <select class="selectbox">
                    <option>전체</option>
                    <option>승인대기</option>
                    <option>결제완료</option>
                    <option>취소환불</option>
                    <option>이용완료</option>
                </select>
            </div>
            <div class="list_area">
                <a href="reservation_detail">
                    <div class="list">
                        <div>
                            <div class="list_img"><img src="${contextPath}/resources/images/header/defaultUser.jpg"></div>
                            <div class="list_description">
                                <div class="tag_area">
                                    <span class="tag approve">승인대기</span>
                                </div>
                                <div class="title">삼양청년회관</div>
                                <div class="date">2021.12.18(토) 3관</div>
                                <div class="pay">6,000원</div>
                            </div>
                        </div>
                    </div>
                </a>
                <a href="reservation_detail">
                    <div class="list">
                        <div>
                            <div class="list_img"><img src="${contextPath}/resources/images/header/defaultUser.jpg"></div>
                            <div class="list_description">
                                <div class="tag_area">
                                    <span class="tag payment">결제완료</span>
                                </div>
                                <div class="title">삼양청년회관</div>
                                <div class="date">2021.12.18(토) 3관</div>
                                <div class="pay">6,000원</div>
                            </div>
                        </div>
                    </div>
                </a>
                <a href="reservation_detail">
                    <div class="list">
                        <div>
                            <div class="list_img"><img src="${contextPath}/resources/images/header/defaultUser.jpg"></div>
                            <div class="list_description">
                                <div class="tag_area">
                                    <span class="tag cancel">취소환불</span>
                                </div>
                                <div class="title">삼양청년회관</div>
                                <div class="date">2021.12.18(토) 3관</div>
                                <div class="pay">6,000원</div>
                            </div>
                        </div>
                    </div>
                </a>
                <a href="reservation_detail">
                    <div class="list">
                        <div>
                            <div class="list_img"><img src="${contextPath}/resources/images/header/defaultUser.jpg"></div>
                            <div class="list_description">
                                <div class="tag_area">
                                    <span class="tag used">이용완료</span>
                                </div>
                                <div class="title">삼양청년회관</div>
                                <div class="date">2021.12.18(토) 3관</div>
                                <div class="pay">6,000원</div>
                            </div>
                        </div>
                    </div>
                </a>
            </div>
        </div>
    </section>
</main>


<!-- footer include -->
<jsp:include page="../common/footer.jsp"/>

</body>
</html>
