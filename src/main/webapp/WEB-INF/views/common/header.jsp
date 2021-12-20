<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- JSTL c태그 사용을 위한 taglib 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 프로젝트의 시작 주소를 간단히 얻어올 수 있도록 application scope로 contextPath라는 변수를 생성함--%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Semi Project</title>

<!-- Bootstrap4 CSS -->
<!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous"> -->

<link rel="stylesheet" href="${contextPath}/resources/css/common.css">
<link rel="stylesheet" href="${contextPath}/resources/css/${css}.css">

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>

<body>
<!-- modal (close : layer_popup)-->
<div class="modal"></div>
    
<!-- side menu -->
<div class="side_menu">
    <div class="bg_yellow login_area">
        <div class="close_menu"><img src="${contextPath}/resources/images/header/right_arrow.svg"></div>
        <a href="${contextPath}/member/login">
            <div class="profile_area">
				<c:choose>
					<c:when test="${empty sessionScope.loginMember}">
						<div class="profile_img">
						    <img src="${contextPath}/resources/images/header/defaultUser.jpg">
						</div>
						<div class="profile_txt">
						    <strong>로그인/회원가입</strong>
						</div>
					</c:when>
					<c:otherwise>
						<div class="profile_img">
						    <img src="${contextPath}/resources/images/header/defaultUser.jpg">
						</div>
						<div class="profile_txt login">
						    <div class="nickname"><strong>${sessionScope.loginMember.memberName}</strong></div>
						    <div class="amend"><strong>프로필 관리</strong></div>
						    
						</div>
					</c:otherwise>
				</c:choose>

            </div>
        </a>
    </div>

    <div class="used_area">
        <div>
            <a href="${contextPath}/my/reserve">
                <div>
                    <img src="${contextPath}/resources/images/header/ico_reservationlist.png" class="ico">
                    <div>예약 리스트</div>
                </div>
            </a>
        </div>
        <div>
            <a href="${contextPath}/my/review">
                <div>
                    <img src="${contextPath}/resources/images/header/ico_manage.png" class="ico">
                    <div>
                        이용후기<br>Q&amp;A관리
                    </div>
                </div>
            </a>
        </div>
        <div>
            <a href="${contextPath}/my/favorites">
                <div>
                    <img src="${contextPath}/resources/images/header/ico_zzim.png" class="ico">
                    <div>찜한공간</div>
                </div>
            </a>
        </div>
    </div>

    <div class="plan_area bg_purple">
        <a href="${contextPath}/promotion"><div class="plan_txt">이달의 기획전</div></a>
    </div>

    <div class="notice_area" id="notice">
        <ul>
            <li data-url="home">
                스페이드클라우드 홈
            </li>
            <li data-url="공지사항">
                공지사항
            </li>
            <li data-url="도움말">
                도움말
            </li>
            <li data-url="1:1문의">
                1:1문의
            </li>
            <li data-url="service">
                서비스 정보
                <ul class="service_sub">
                    <li data-url="introduction"> - 서비스 소개</li>
                    <li data-url="terms"> - 이용약관</li>
                    <li data-url="privacy"> - 개인정보처리방침</li>
                    <li data-url="operate"> - 운영정책</li>
                </ul>
            </li>
        </ul>
	    <div class="logout-wrapper">
	    	<c:choose>
				<c:when test="${empty sessionScope.loginMember}">
					<a href="${contextPath}/member/login">로그인</a>
				</c:when>
				<c:otherwise>
					<a href="${contextPath}/member/logout">로그 아웃</a>
				</c:otherwise>
			</c:choose>
    	
	    	<p class="copyright" style="margin-top: 17px; font-size: 13px;">designed by © SpaceCloud.</p>
	    </div>
    </div>
</div>

<!-- header랑 side_menu는 변경 가능성이 있습니다. -->
<header>
    <div class="logo_area"><a href="${contextPath}">빌려주오</a></div>
    <div class="search_area">
        <img src="${contextPath}/resources/images/header/search-gray.png" class="ico_search">
        <img src="${contextPath}/resources/images/header/search-cancel.png" class="ico_cancel">
        <input type="text" class="input search" placeholder="지역, 공간유형, 공간명으로 찾아보세요">
    </div>
    <div class="menu_area">
        <img src="${contextPath}/resources/images/header/menu.png" class="ico_menu">
    </div>
</header>

<style>
.popup_wrap{width:470px; position:relative; display:inline-block; vertical-align:middle; box-sizing:border-box; top:300px;}
.popup_wrap > .pop_header{text-align:left; font-size:18px; padding:20px 25px; border-radius:12px 12px 0 0; background:#704de4; color:#fff; font:inherit;}
.popup_wrap > .pop_container{border-radius:0 0 12px 12px; background:#fff; padding:24px 26px 26px;}
.popup_wrap > .pop_container > .reserve_price{margin-top:0; border-top:0; background:#fff; text-align:left; padding:0;}

.popup_wrap > .pop_container > .reserve_price > .box_form{margin-top:0; background:#fff; position:relative;}
.popup_wrap > .pop_container > .reserve_price > .box_form > .tit{font-size:16px; line-height:44px; color:#000; font-weight:bold;}
.popup_wrap > .pop_container > .reserve_price > .box_form > .tit > label{cursor:pointer;}

.popup_wrap > .pop_container > .reserve_price > .box_form > .option{top:15px; font-size:14px; position:absolute; line-height:14px; color:#704de4; right:0;}
.popup_wrap > .pop_container > .reserve_price > .box_form > .option > .txt_count{color:#656565; vertical-align:top;}
.popup_wrap > .pop_container > .reserve_price > .box_form > .option > .txt_count > em{vertical-align:top;}




.popup_wrap > .pop_container > .reserve_price > .box_form > .input{position:relative; box-sizing:border-box;}
.popup_wrap > .pop_container > .reserve_price > .box_form > .input > textarea{height:115px; font-size:14px; display:inline-block; position:relative; width:100%; background-color:#fff; padding:15px 16px; vertical-align:top; border-radius:0; color:#000; border:1px solid #e0e0e0; box-sizing:border-box; font:inherit;}

.popup_wrap > .pop_container > .p_guide{display:block; margin-left:0; font-size:14px; line-height:18px; padding-left:23px; color:#ff3a48; position:relative; margin:20px 1px 0;}

.popup_wrap > .pop_container > .btns{margin-top:49px; vertical-align:middle; font:inherit;}
.popup_wrap > .pop_container > .btns > .btn{border-radius:6px; height:56px; line-height:56px; font-size:20px; width:49%; text-align:center; color:#fff;}
.popup_wrap > .pop_container > .btns > .btn:first-child{float:left;}
.popup_wrap > .pop_container > .btns > .btn:last-child{float:right;}

.popup_wrap > .pop_container > .btns:after{display:block; content:""; clear:both;}
.popup_wrap > .btn_pop_close{position:absolute; right:16px; top:10px; padding:10px; vertical-align:top; cursor:pointer;}
.popup_wrap > .btn_pop_close > img{width:18px; height:18px;}


.btn_negative{background:#4d4d4d;}
.btn_default{background:#704de4;}
</style>
<div class="popup_wrap">
	<div class="pop_header">질문 작성하기</div>
	<div class="pop_container reviews">
		<article class="reserve_price">
			<div class="box_form">
				<div class="tit">
					<label for="reason_cancel">질문</label>
				</div>
				<span class="option">
					<span class="txt_count">
						<em>0</em>자/<em>200</em>자
					</span>
				</span>
				<div class="input">
					<textarea maxlength="200" id="reason_cancel" placeholder="질문을 남겨 주세요."></textarea>
				</div>
			</div>
		</article>
		<p class="p_guide">
			<i class="sp_icon ico_alert"></i>
	    	질문은 공개 상태로만 등록하실 수 있습니다.
		</p>
		<div class="btns">
			<a class="btn btn_full btn_negative">취소</a>
			<a class="btn btn_full btn_default">등록</a>
		</div>
	</div>
	<a title="레이어팝업 닫힘" class="btn_pop_close">
		<img src="${contextPath}/resources/images/main_body/icon_like.svg" />
	</a>
</div>