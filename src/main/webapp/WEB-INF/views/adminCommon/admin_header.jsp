<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- JSTL c태그 사용을 위한 taglib 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 프로젝트의 시작 주소를 간단히 얻어올 수 있도록 application scope로 contextPath라는 변수를 생성함--%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title> 관리자페이지 </title>

<link rel="stylesheet" href="${contextPath}/resources/css/common.css">
<link rel="stylesheet" href="${contextPath}/resources/css/admin_common.css">
<link rel="stylesheet" href="${contextPath}/resources/css/${css}.css">

</head>

<body>

<!-- header -->
  <header>
    <div class="top-header">
      <div>
        <span class="header-title">빌려주오 관리자</span>
        <button id="logout">관리자 로그아웃</button>
      </div>
    </div>
  </header>
  
<!-- side menu -->

  <aside style="margin-top: 70px;">
    <section class="left">
      <article class="menu-wrap">
        <div class="menu">
          <h3>주요 기능</h3>
        </div>
        <div class="menu">
          <h3>회원 관리</h3>
        </div>
        <div class="menu">
          <h3>예약 관리</h3>
        </div>
        <div class="menu">
          <h3>대여장소 관리</h3>
            <!-- <div class="sub-menu">
              <h4>대여공간 등록</h4>
            </div>
            <div  class="sub-menu">
              <h4>조회 및 수정</h4>
            </div> -->

        </div>
        <div class="menu">
          <h3>게시글 관리</h3>
        </div>
        <div class="menu">
          <h3>세부 관리</h3>
            <div class="sub-menu" onclick="location.href = '${contextPath}/board/insert';">
              <h4>기획전 관리</h4>
            </div>
            <div  class="sub-menu">
              <h4>추천공간 관리</h4>
            </div>
            <div  class="sub-menu">
              <h4>문의사항 관리</h4>
            </div>
        </div>
      </article>
    </section>
  </aside>