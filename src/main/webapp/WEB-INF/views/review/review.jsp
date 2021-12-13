<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- JSTL c태그 사용을 위한 taglib 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 프로젝트의 시작 주소를 간단히 얻어올 수 있도록 application scope로 contextPath라는 변수를 생성함--%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!-- header include -->
<jsp:include page="../common/header.jsp"/>


<main>
    <section class="review">
        <div class="title" style="letter-spacing:-.5px;">이용 후기 관리</div>
        <div class="review_area">
            <div style="width:100%; margin-bottom:50px;">
                <ul style="height:48px;">
                    <li><a href="#" style="width:50%; float:left; text-align:center; font-size:20px; padding:10px 0; border-top:1px solid #704de4; background-color:#704de4; color:#fff;">이용후기</a></li>
                    <li><a href="#" style="width:50%; float:left; text-align:center; font-size:20px; padding:10px 0; border-top:1px solid #704de4; background-color:#ebebeb; color:#949494;">Q&A</a></li>
                </ul>
                <div style="box-sizing:border-box; border:3px solid #704de4; height:100px; margin-top:40px;">
                    <div style="width:15%; float:left; line-height:94px; text-align:center; font-weight:bold;">예약 정보 검색</div>
                    <div style="width:70%; float:left; line-height:94px; text-align:center;">
                        <input type="text" class="input" style="height:46px; width:96%; padding:0 2%; font-size:16px;" placeholder="예약번호">
                    </div>
                    <div style="width:15%; float:left; line-height:94px; text-align:center;">
                        <input type="button" value="검색" style="width:120px; height:48px; line-height:46px; vertical-align:middle; background-color:#704de4; color:#fff; font-size:20px; border:0; cursor:pointer;">
                    </div>
                </div>
            </div>

            <!-- <div class="non_list_area">
                <div  class="non_list">
                    <span>현재 등록된 이용후기가 없습니다.</span>
                </div>
            </div> -->
            <div class="list_area">
                <div style="box-sizing:border-box; border:1px solid black; padding:10px; width:100%; margin-bottom:10px;">
                    <div style="display:inline-block;"><img src="${contextPath}/resources/images/space_img/sadang.jpg" style="width:230px; height:150px; object-fit:cover;"></div>
                    <div style="display:inline-block; width:75%; padding:10px 20px; vertical-align:top;">
                        <div style="font-size:18px; font-weight:bold; margin-bottom:5px;">파티살롱_촬영,회의,세미나,워크샵</div>
                        <div style="margin-bottom:5px;">사장님 정말 친절하십니다 . 그리고 장소도 정말 예쁘고 좋아요 인생사진 여러개 얻었고 진짜 편하게 잘 즐기다가 갑니다!! 담에 또 이용할께요 감사합니다~</div>
                        <div style="font-size:12px;">2021.11.27 00:35:58</div>
                        <div style="margin:10px 0 0 15px;">
                            <div style="font-size:18px; color:#704de4; margin-bottom:5px;">관리자 답글</div>
                            <div style="margin-bottom:5px;">후기 감사드립니다 :) 인생사진 저도 보고 싶어요! ㅎㅎㅎ 즐거운 시간 되셨다니 제가 더 감사드립니다~ 다음에 다시 찾아주세요♡</div>
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