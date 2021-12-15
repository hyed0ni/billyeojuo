<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- JSTL c태그 사용을 위한 taglib 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 프로젝트의 시작 주소를 간단히 얻어올 수 있도록 application scope로 contextPath라는 변수를 생성함--%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!-- header include -->
<jsp:include page="../common/header.jsp"/>

<style>
.review > .review_area > .review_header{width:100%; margin-bottom:50px;}
.review > .review_area > .review_header > .header_tab_area{height:48px;}
.review > .review_area > .review_header > .header_tab_area .header_tab{width:50%; float:left; text-align:center; font-size:20px; padding:10px 0; border-top:1px solid #704de4; background-color:#ebebeb; color:#949494;}
.review > .review_area > .review_header > .header_tab_area .header_tab.active{border-top:1px solid #704de4; background-color:#704de4; color:#fff;}

.review > .review_area > .review_header > .search_area{box-sizing:border-box; border:3px solid #704de4; height:100px; margin-top:40px;}
.review > .review_area > .review_header > .search_area > .search_title{width:15%; float:left; line-height:94px; text-align:center; font-weight:bold;}
.review > .review_area > .review_header > .search_area > .input_area{width:70%; float:left; line-height:94px; text-align:center;}
.review > .review_area > .review_header > .search_area > .input_area > .search_input{height:46px; width:96%; padding:0 2%; font-size:16px;}
.review > .review_area > .review_header > .search_area > .btn_area{width:15%; float:left; line-height:94px; text-align:center;}
.review > .review_area > .review_header > .search_area > .btn_area > .search_btn{width:120px; height:48px; line-height:46px; vertical-align:middle; background-color:#704de4; color:#fff; font-size:20px; border:0; cursor:pointer;}

.review > .review_area > .list_area > .list{box-sizing:border-box; border:1px solid black; padding:10px; width:100%; margin-bottom:10px;}
.review > .review_area > .list_area > .list > .img_area{display:inline-block;}

.review > .review_area > .list_area > .list > .img_area > .list_img{width:230px; height:150px; object-fit:cover;}
.review > .review_area > .list_area > .list > .content_area{display:inline-block; width:75%; padding:10px 20px; vertical-align:top;}
.review > .review_area > .list_area > .list > .content_area .title{font-size:18px; font-weight:bold; margin-bottom:5px;}
.review > .review_area > .list_area > .list > .content_area .content{margin-bottom:5px;}
.review > .review_area > .list_area > .list > .content_area .date{font-size:12px;}

.review > .review_area > .list_area > .list > .content_area > .comment_area{margin:10px 0 0 15px;}
.review > .review_area > .list_area > .list > .content_area > .comment_area > .comment_title{font-size:18px; color:#704de4; margin-bottom:5px;}


</style>

<main>
    <section class="review">
        <div class="title" style="letter-spacing:-.5px;">이용 후기 관리</div>
        <div class="review_area">
            <div class="review_header">
                <ul class="header_tab_area">
                    <li><a href="#" class="header_tab active">이용후기</a></li>
                    <li><a href="#" class="header_tab">Q&A</a></li>
                </ul>
                <div class="search_area">
                    <div class="search_title">예약 정보 검색</div>
                    <div class="input_area">
                        <input type="text" class="input search_input" placeholder="예약번호">
                    </div>
                    <div class="btn_area">
                        <input type="button" class="btn search_btn" value="검색">
                    </div>
                </div>
            </div>

            <!-- <div class="non_list_area">
                <div  class="non_list">
                    <span>현재 등록된 이용후기가 없습니다.</span>
                </div>
            </div> -->
            <div class="list_area">
            	<c:forEach items="${reviewList}" var="review">
	            	<div class="list">
	                    <div class="img_area"><img class="list_img" src="${contextPath}/resources/images/space_img/sadang.jpg"></div>
	                    <div class="content_area">
	                        <div class="title">${review.revNo} 파티살롱_촬영,회의,세미나,워크샵</div>
	                        <div class="content">${review.revContent}</div>
	                        <div class="date">${review.revDt}</div>
	                        <%--
	                        <div class="comment_area">
	                            <div class="comment_title">관리자 답글</div>
	                            <div class="content">후기 감사드립니다 :) 인생사진 저도 보고 싶어요! ㅎㅎㅎ 즐거운 시간 되셨다니 제가 더 감사드립니다~ 다음에 다시 찾아주세요♡</div>
	                            <div class="date">2021.11.27 00:41:10</div>
	                        </div>
	                        --%>
	                    </div>
	                </div>
            	</c:forEach>
            </div>
        </div>
    </section>
</main>


<!-- footer include -->
<jsp:include page="../common/footer.jsp"/>