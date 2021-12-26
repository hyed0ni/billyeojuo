<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- JSTL c태그 사용을 위한 taglib 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 프로젝트의 시작 주소를 간단히 얻어올 수 있도록 application scope로 contextPath라는 변수를 생성함--%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!-- header include -->
<jsp:include page="../adminCommon/admin_header.jsp"/>
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/admin_register_roomtype.css">    


  <main>
    <div class="contents">
      <section class="right">
        <form action="addRoomType?rn=${param.rn}" method="post"  enctype="multipart/form-data" role="form" onsubmit="return spaceValidate();">
          <h2 style="text-align: center;">공간 타입등록</h2>
          
          <article class="roomTypeWrap">
          	<div>
	          <article class="roomInfo01">
	          	<div class="roomWrap">
	                <label for="spaceName" >공간 타입 이름</label> 
	                <input type="text" id="spaceName" name="spaceName" required style="width: 435px;" >
	            </div>
	            
	            <div class="roomWrap">
	              <label for="spaceSubName">가격</label> 
	              <input type="text" id="spaceSubName" name="spaceSubName" required> 원
	            </div>
	              
	             <div class="roomWrap">
	                <label for="spaceAddr">이용 인원</label> 
	                <input type="text" id="spaceAddr" name="spaceAddr" required > 명
	              </div>
	
	        <input type="text" name="ttt[]" class="test" value=""></input>
	              <div class="roomWrap">
	                <label for="roomOption">공간옵션</label> 
	                <input type="radio" name="roomOption" class="roomRadio"> 금연
	                <input type="radio" name="roomOption" class="roomRadio"> 취사가능
	                <input type="radio" name="roomOption" class="roomRadio"> 금연
	                <input type="radio" name="roomOption" class="roomRadio"> 금연
	                <input type="radio" name="roomOption" class="roomRadio"> 금연
	              </div>
	            </article>
	            
	          <article class="roomMap">
	         	 <label>룸 이미지</label>
	            <div class="roomImg">
	              <img>
	            </div>
	          </article>
	         	 
	            <div id="fileArea">
	            <input type="file" name="img" onchange="loadImg(this)"> 
	            </div>
		
	          <article class="roomInfo02">
	            <div class="roomWrap02">
	              <div>
	                <label for="roomBasic">공간소개</label>
	              </div>
	              <textarea class="roomInfoForm" id="roomBasic" name="roomBasic"></textarea>
	            </div>
	          </article>
          </div>
          </article>
          
          
          
           <article style="margin-bottom: 40px; text-align: center;">
            <button type="button" id="addBtn" onclick="createRoom()">룸타입 추가</button> <br>
            <button class="btn" >등록하기</button>
            <button class="btn" onclick="">취소</button>
          </article>
        </form>

      </section> 
    </div>
  </main>
  
  <jsp:include page="../adminCommon/admin_footer.jsp"/>
  <script src="${contextPath}/resources/js/adminRoomtType.js"></script>
  
</body>
</html>