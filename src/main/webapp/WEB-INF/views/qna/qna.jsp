<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- JSTL c태그 사용을 위한 taglib 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 프로젝트의 시작 주소를 간단히 얻어올 수 있도록 application scope로 contextPath라는 변수를 생성함--%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!-- header include -->
<jsp:include page="../common/header.jsp"/>

<main>
    <section class="qna">
        <div class="title" style="letter-spacing:-.5px;">문의 관리</div>
        <div class="qna_area">
            <div style="width:100%; margin-bottom:50px;">
                <ul style="height:48px;">
                    <li><a href="#" style="width:50%; float:left; text-align:center; font-size:20px; padding:10px 0; border-top:1px solid #704de4; background-color:#ebebeb; color:#949494;">이용후기</a></li>
                    <li><a href="#" style="width:50%; float:left; text-align:center; font-size:20px; padding:10px 0; border-top:1px solid #704de4; background-color:#704de4; color:#fff;">Q&A</a></li>
                </ul>
                <div style="height:50px; margin-top:40px;">
                    <select class="selectbox" style="float:right; padding:5px;">
                        <option>전체</option>
                        <option>1:1문의</option>
                        <option>장소문의</option>
                    </select>

                </div>
            </div>

            <!-- <div class="non_list_area">
                <div  class="non_list">
                    <span>현재 등록된 문의가 없습니다.</span>
                </div>
            </div> -->
            <div class="list_area">
                <div style="box-sizing:border-box; border:1px solid black; padding:10px; width:100%; margin-bottom:10px;">
                    <div style="display:inline-block;"><img src="${contextPath}/resources/images/header/defaultUser.jpg" style="width:230px; height:150px; object-fit:cover;"></div>
                    <div style="display:inline-block; width:75%; padding:10px 20px; vertical-align:top;">
                        <div style="font-size:18px; font-weight:bold; margin-bottom:5px;">1:1 문의 입니다.</div>
                        <div style="margin-bottom:5px;">여긴 뭐하는 곳인가요??여긴 뭐하는 곳인가요??여긴 뭐하는 곳인가요??여긴 뭐하는 곳인가요??여긴 뭐하는 곳인가요??여긴 뭐하는 곳인가요??여긴 뭐하는 곳인가요??</div>
                        <div style="font-size:12px;">2021.11.27 00:35:58</div>
                        <div style="margin:10px 0 0 15px;">
                            <div style="font-size:18px; color:#704de4; margin-bottom:5px;">관리자 답글</div>
                            <div style="margin-bottom:5px;">여긴 빌려줍니다. 여긴 빌려줍니다. 여긴 빌려줍니다. 여긴 빌려줍니다. 여긴 빌려줍니다. 여긴 빌려줍니다. 여긴 빌려줍니다.</div>
                            <div style="font-size:12px;">2021.11.27 00:41:10</div>
                        </div>
                    </div>
                </div>
                <div style="box-sizing:border-box; border:1px solid black; padding:10px; width:100%; margin-bottom:10px;">
                    <div style="display:inline-block;"><img src="${contextPath}/resources/images/space_img/sinchon.jpg" style="width:230px; height:150px; object-fit:cover;"></div>
                    <div style="display:inline-block; width:75%; padding:10px 20px; vertical-align:top;">
                        <div style="font-size:18px; font-weight:bold; margin-bottom:5px;">파티살롱_촬영,회의,세미나,워크샵</div>
                        <div style="margin-bottom:5px;">사장님 정말 친절하십니다 . 그리고 장소도 정말 예쁘고 좋아요 인생사진 여러개 얻었고 진짜 편하게 잘 즐기다가 갑니다!! 담에 또 이용할께요 감사합니다~</div>
                        <div style="font-size:12px;">2021.11.27 00:35:58</div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>

<!-- footer include -->
<jsp:include page="../common/footer.jsp"/>