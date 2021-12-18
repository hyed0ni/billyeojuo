<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- JSTL c태그 사용을 위한 taglib 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 프로젝트의 시작 주소를 간단히 얻어올 수 있도록 application scope로 contextPath라는 변수를 생성함--%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!-- header include -->
<jsp:include page="admin_header.jsp"/>


  <main>
    <div class="contents">
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
          </div>
          <div class="menu">
            <h3>게시글 관리</h3>
          </div>
          <div class="menu">
            <h3>세부 관리</h3>
              <div class="sub-menu">
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

      <section class="right">
        <form action="#" method="post"  enctype="multipart/form-data" role="form" onsubmit="return spaceValidate();">
          <h2 style="text-align: center;">공간 타입등록</h2>
          
          <article class="roomTypeWrap">
            <article class="roomInfo01">
              <div class="roomWrap">
                <label for="spaceName">공간 타입 이름</label> 
                <input type="text" id="spaceName" name="spaceName" style="width: 80%; text-align: left;" required >
              </div>
              <div class="roomWrap">
                <label for="spaceSubName">가격</label> 
                <input type="text" id="spaceSubName" name="spaceSubName" required> 원
              </div>
              <div class="roomWrap">
                <label for="spaceAddr">최대 수용인원</label> 
                <input type="text" id="spaceAddr" name="spaceAddr" required > 명
              </div>

              <div class="roomWrap">
                <label for="roomOption">공간옵션</label> 
                <input type="radio" name="roomOption" class="roomRadio"> 금연
                <input type="radio" name="roomOption" class="roomRadio"> 취사가능
                <input type="radio" name="roomOption" class="roomRadio"> 금연
                <input type="radio" name="roomOption" class="roomRadio"> 금연
                <input type="radio" name="roomOption" class="roomRadio"> 금연

              </div>
            </article>

          <article article class="roomInfo02">
            <div class="roomWrap02">
              <div>
                <label for="roomBasic">공간소개</label>
              </div>
              <textarea class="roomInfoForm" id="roomBasic" name="roomBasic"></textarea>
            </div>
          </article>

            <button> + 룸 타입 추가</button>


          <article style="margin-top: 40px; margin-bottom: 40px; text-align: center;">
            <button class="btn" onclick="">등록하기</button>
            <button class="btn">취소</button>
          </article>
        </form>

        
      </section>
    </main>



</body>

</html>