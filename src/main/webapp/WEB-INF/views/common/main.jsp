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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" 
		integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

<link rel="stylesheet" href="${contextPath}/resources/css/common.css">

<link rel="stylesheet" href="${contextPath}/resources/css/main.css">

</head>

<body>
<!-- modal (close : layer_popup)-->
<div class="modal"></div>
    
<!-- side menu -->
<div class="side_menu">
    <div class="bg_yellow login_area">
        <div class="close_menu"><img src="${contextPath}/resources/images/header/right_arrow.png"></div>
        <a href="javascript:alert('로그인')">
            <div class="profile_area">
                <div class="profile_img">
                    <img src="${contextPath}/resources/images/header/defaultUser.jpg">
                </div>
                <div class="profile_txt">
                    <strong>로그인/회원가입</strong>
                </div>
                <!-- 로그인 시 -->
                <!-- <div class="profile_txt login">
                    <div class="nickname"><strong>닉네임</strong></div>
                    <div class="amend"><strong>프로필 관리</strong></div>
                </div>  -->
            </div>
        </a>
    </div>


    <div class="used_area">
        <div>
            <a href="javascript:alert('예약리스트')">
                <div>
                    <img src="${contextPath}/resources/images/header/ico_reservationlist.png" class="ico">
                    <div>예약 리스트</div>
                </div>
            </a>
        </div>
        <div>
            <a href="javascript:alert('예약리스트')">
                <div>
                    <img src="${contextPath}/resources/images/header/ico_manage.png" class="ico">
                    <div>
                        이용후기<br>Q&amp;A관리
                    </div>
                </div>
            </a>
        </div>
        <div>
            <a href="javascript:alert('찜한공간')">
                <div>
                    <img src="${contextPath}/resources/images/header/ico_zzim.png" class="ico">
                    <div>찜한공간</div>
                </div>
            </a>
        </div>
    </div>

    <div class="plan_area bg_purple">
        <a href="javascript:alert('기획전');"><div class="plan_txt">이달의 기획전</div></a>
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
    </div>
</div>


<!-- header랑 sidemenu는 변경 가능성이 있습니다. -->
<header>
    <div class="logo_area">빌려주오</div>
    <div class="search_area">
        <img src="${contextPath}/resources/images/header/search-gray.png" class="ico_search">
        <img src="${contextPath}/resources/images/header/search-cancel.png" class="ico_cancel">
        <input type="text" class="input search" placeholder="지역, 공간유형, 공간명으로 찾아보세요">
    </div>
    <div class="menu_area">
        <img src="${contextPath}/resources/images/header/menu.png" class="ico_menu">
    </div>
</header>

<main >
    <section class="main-pic">
        <img src="${contextPath}/resources/images/main_body/mainpage_img.jpg">
    </section>

    <section id="icons">
        <a href="#" class="icon-a">
            <img src="${contextPath}/resources/images/main_icon/broadcasting.png" alt="">
        </a>

        <a href="#" class="icon-a">
            <img src="${contextPath}/resources/images/main_icon/cafe.png" alt="">
        </a>

        <a href="#" class="icon-a">
            <img src="${contextPath}/resources/images/main_icon/gathering.png" alt="">
        </a>

        <a href="#" class="icon-a">
            <img src="${contextPath}/resources/images/main_icon/instrumental_room.png" alt="">
        </a>

        <a href="#" class="icon-a">
            <img src="${contextPath}/resources/images/main_icon/outdoor.png" alt="">
        </a>

        <a href="#" class="icon-a">
            <img src="${contextPath}/resources/images/main_icon/performance.png" alt="">
        </a>

        <a href="#" class="icon-a">
            <img src="${contextPath}/resources/images/main_icon/workingout.png" alt="">
        </a>

        <a href="#" class="icon-a">
            <img src="${contextPath}/resources/images/main_icon/workingout.png" alt="">
        </a>

    </section>

    <section class="space"></section>
    <section id="promotions">
        <h1 class="title">기획전</h1>
        <p style="margin-top: 0px; text-align: center;">지금 딱 내가 찾는 공간</p>
            <div class="promotion">
                <a href="#">
                    <h3 class="promotion-title">원테이블 레스토랑은 이곳에,<br>오늘은 내가 일일 쉐프</h3><br>
                    <p>노잼도시를 구하라</p>
                </a>

                <a href="#">
                    <h3 class="promotion-title">원테이블 레스토랑은 이곳에,<br>오늘은 내가 일일 쉐프</h3><br>
                    <p>노잼도시를 구하라</p>
                </a>

                <a href="#">
                    <h3 class="promotion-title">원테이블 레스토랑은 이곳에,<br>오늘은 내가 일일 쉐프</h3><br>
                    <p>노잼도시를 구하라</p>
                </a>

                <a href="#">
                    <h3 class="promotion-title">원테이블 레스토랑은 이곳에,<br>오늘은 내가 일일 쉐프</h3><br>
                    <p>노잼도시를 구하라</p>
                </a>

                <div class="more" >
                    <a href="promotion.html" >+ 더보기</a>
                </div>
            </div>

    </section>
    <section class="space"></section>

    <section id="recommends">
        <h1 class="title">추천공간</h1>
        <p style="margin-top: 0px; text-align: center;">지금 딱 내가 찾는 공간</p>
        <section>
            <article  class="recommend-item">
                <a href="#">
                    <div class="img-box">
                        <span></span>
                        <button type="button" class="button-left"></button>
                        <button type="button" class="button-right"></button>
                    </div>
                    <div class="info-box">
                        <h3>육공스튜디오(60Studio)</h3>
                        <div class="tag-box">
                            <span class="location">소하동 </span> <span> |</span>
                            <span class="tag">#스튜디오대여</span>
                            <span class="tag">#셀프스튜디오</span>
                            <span class="tag">#쇼핑몰촬영</span>
                        </div>
                        <div class="price-box">
                            <strong class="price purple">10,000</strong> <span>원/패키지</span>
                            <div class="like-comment">
                                <span class="pricebox-icon icon-comment"></span>
                                <span>최대3인</span>
                                <span class="pricebox-icon icon-people"></span>
                                <span>0</span>
                                <span class="pricebox-icon icon-like"></span>
                                <span>6</span>
                            </div>
                        </div>
                    </div>
                </a>
            </article>
            <article  class="recommend-item">
                <a href="#">
                    <div class="img-box">
                        <span></span>
                    </div>
                    <div class="info-box">
                        <h3>육공스튜디오(60Studio)</h3>
                        <div class="tag-box">
                            <span class="location">소하동 </span> <span> |</span>
                            <span class="tag">#스튜디오대여</span>
                            <span class="tag">#셀프스튜디오</span>
                            <span class="tag">#쇼핑몰촬영</span>
                        </div>
                        <div class="price-box">
                            <strong class="price purple">10,000</strong> <span>원/패키지</span>
                            <div class="like-comment">
                                <span class="pricebox-icon icon-comment"></span>
                                <span>최대3인</span>
                                <span class="pricebox-icon icon-people"></span>
                                <span>0</span>
                                <span class="pricebox-icon icon-like"></span>
                                <span>6</span>
                            </div>
                        </div>
                    </div>
                </a>
            </article>            <article  class="recommend-item">
                <a href="#">
                    <div class="img-box">
                        <span></span>
                    </div>
                    <div class="info-box">
                        <h3>육공스튜디오(60Studio)</h3>
                        <div class="tag-box">
                            <span class="location">소하동 </span> <span> |</span>
                            <span class="tag">#스튜디오대여</span>
                            <span class="tag">#셀프스튜디오</span>
                            <span class="tag">#쇼핑몰촬영</span>
                        </div>
                        <div class="price-box">
                            <strong class="price purple">10,000</strong> <span>원/패키지</span>
                            <div class="like-comment">
                                <span class="pricebox-icon icon-comment"></span>
                                <span>최대3인</span>
                                <span class="pricebox-icon icon-people"></span>
                                <span>0</span>
                                <span class="pricebox-icon icon-like"></span>
                                <span>6</span>
                            </div>
                        </div>
                    </div>
                </a>
            </article>            <article  class="recommend-item">
                <a href="#">
                    <div class="img-box">
                        <span></span>
                    </div>
                    <div class="info-box">
                        <h3>육공스튜디오(60Studio)</h3>
                        <div class="tag-box">
                            <span class="location">소하동 </span> <span> |</span>
                            <span class="tag">#스튜디오대여</span>
                            <span class="tag">#셀프스튜디오</span>
                            <span class="tag">#쇼핑몰촬영</span>
                        </div>
                        <div class="price-box">
                            <strong class="price purple">10,000</strong> <span>원/패키지</span>
                            <div class="like-comment">
                                <span class="pricebox-icon icon-comment"></span>
                                <span>최대3인</span>
                                <span class="pricebox-icon icon-people"></span>
                                <span>0</span>
                                <span class="pricebox-icon icon-like"></span>
                                <span>6</span>
                            </div>
                        </div>
                    </div>
                </a>
            </article>            <article  class="recommend-item">
                <a href="#">
                    <div class="img-box">
                        <span></span>
                    </div>
                    <div class="info-box">
                        <h3>육공스튜디오(60Studio)</h3>
                        <div class="tag-box">
                            <span class="location">소하동 </span> <span> |</span>
                            <span class="tag">#스튜디오대여</span>
                            <span class="tag">#셀프스튜디오</span>
                            <span class="tag">#쇼핑몰촬영</span>
                        </div>
                        <div class="price-box">
                            <strong class="price purple">10,000</strong> <span>원/패키지</span>
                            <div class="like-comment">
                                <span class="pricebox-icon icon-comment"></span>
                                <span>최대3인</span>
                                <span class="pricebox-icon icon-people"></span>
                                <span>0</span>
                                <span class="pricebox-icon icon-like"></span>
                                <span>6</span>
                            </div>
                        </div>
                    </div>
                </a>
            </article>            <article  class="recommend-item">
                <a href="#">
                    <div class="img-box">
                        <span></span>
                    </div>
                    <div class="info-box">
                        <h3>육공스튜디오(60Studio)</h3>
                        <div class="tag-box">
                            <span class="location">소하동 </span> <span> |</span>
                            <span class="tag">#스튜디오대여</span>
                            <span class="tag">#셀프스튜디오</span>
                            <span class="tag">#쇼핑몰촬영</span>
                        </div>
                        <div class="price-box">
                            <strong class="price purple">10,000</strong> <span>원/패키지</span>
                            <div class="like-comment">
                                <span class="pricebox-icon icon-comment"></span>
                                <span>최대3인</span>
                                <span class="pricebox-icon icon-people"></span>
                                <span>0</span>
                                <span class="pricebox-icon icon-like"></span>
                                <span>6</span>
                            </div>
                        </div>
                    </div>
                </a>
            </article>            <article  class="recommend-item">
                <a href="#">
                    <div class="img-box">
                        <span></span>
                    </div>
                    <div class="info-box">
                        <h3>육공스튜디오(60Studio)</h3>
                        <div class="tag-box">
                            <span class="location">소하동 </span> <span> |</span>
                            <span class="tag">#스튜디오대여</span>
                            <span class="tag">#셀프스튜디오</span>
                            <span class="tag">#쇼핑몰촬영</span>
                        </div>
                        <div class="price-box">
                            <strong class="price purple">10,000</strong> <span>원/패키지</span>
                            <div class="like-comment">
                                <span class="pricebox-icon icon-comment"></span>
                                <span>최대3인</span>
                                <span class="pricebox-icon icon-people"></span>
                                <span>0</span>
                                <span class="pricebox-icon icon-like"></span>
                                <span>6</span>
                            </div>
                        </div>
                    </div>
                </a>
            </article>            <article  class="recommend-item">
                <a href="#">
                    <div class="img-box">
                        <span></span>
                    </div>
                    <div class="info-box">
                        <h3>육공스튜디오(60Studio)</h3>
                        <div class="tag-box">
                            <span class="location">소하동 </span> <span> |</span>
                            <span class="tag">#스튜디오대여</span>
                            <span class="tag">#셀프스튜디오</span>
                            <span class="tag">#쇼핑몰촬영</span>
                        </div>
                        <div class="price-box">
                            <strong class="price purple">10,000</strong> <span>원/패키지</span>
                            <div class="like-comment">
                                <span class="pricebox-icon icon-comment"></span>
                                <span>최대3인</span>
                                <span class="pricebox-icon icon-people"></span>
                                <span>0</span>
                                <span class="pricebox-icon icon-like"></span>
                                <span>6</span>
                            </div>
                        </div>
                    </div>
                </a>
            </article>
            <article  class="recommend-item">
                <a href="#">
                    <div class="img-box">
                        <span></span>
                    </div>
                    <div class="info-box">
                        <h3>육공스튜디오(60Studio)</h3>
                        <div class="tag-box">
                            <span class="location">소하동 </span> <span> |</span>
                            <span class="tag">#스튜디오대여</span>
                            <span class="tag">#셀프스튜디오</span>
                            <span class="tag">#쇼핑몰촬영</span>
                        </div>
                        <div class="price-box">
                            <strong class="price purple">10,000</strong> <span>원/패키지</span>
                            <div class="like-comment">
                                <span class="pricebox-icon icon-comment"></span>
                                <span>최대3인</span>
                                <span class="pricebox-icon icon-people"></span>
                                <span>0</span>
                                <span class="pricebox-icon icon-like"></span>
                                <span>6</span>
                            </div>
                        </div>
                    </div>
                </a>
            </article>
        </section>
    </section>

    <section class="space"></section>
    <section class="space"></section>
</main>

<footer class="footer">
  <div class="footer-contents">
    <div class="footer-contents-1">
      <div id="footer-logo">
        빌려주오
      </div>
      <div id="footer-blog">
        <ul>
          <li><a href="#">블로그</a></li>
          <li><a href="#">이용약관</a></li>
          <li><a href="#">개인정보처리방침</a></li>
          <li><a href="#">운영정책</a></li>
          <li><a href="#">고객문의</a></li>
        </ul>
      </div>
    </div>
    <div class="footer-contents-2">
      <ul>
        <li>상호명: <a href="#">주식회사앤스페이스</a></li>
        <li>대표:정수현</li>
        <li>사업자등록번호: 230-81-03117</li>
        <li>통신판매업신고번호: 2018-서울강남-04590</li>
        <li><a href="#">사업자등록정보</a></li>
        <li>영업소재지: 서울특별시 강남구 삼성로 414</li>
        <li>이메일<a href="#">office@spacecloud.kr </a></li>
        <li>대표전화: 1599-4312(평일 오후 2시 ~ 오후 6시)</li>
        <li><a href="#">1:1 온라인문의 바로가기</a>(평일 오전 10시 ~ 오후 6시)</li>
      </ul>
    </div>
    <div class="footer-contents-3">
      <span>스페이스클라우드는 통신판매중개자이며 통신판매의 당사자가 아닙니다. <br>따라서 스페이스클라우드는 공간 거래정보 및 거래에 대해 책임지지 않습니다.</span>
      <span>Copyright NSPACE Corp. All Rights Reserved.</span>
    </div>
  </div>
</footer>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="${contextPath}/resources/js/common.js"></script>

<!-- header include -->
<%-- <jsp:include page="header.jsp"/> --%>
<%-- include할 jsp 파일 경로 작성 --%>

<!-- 메인 화면 이미지 -->


<!-- footer include -->
<%-- <jsp:include page="footer.jsp"/> --%>
	
</body>
</html>