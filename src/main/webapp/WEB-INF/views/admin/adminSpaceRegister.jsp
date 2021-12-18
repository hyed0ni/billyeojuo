<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- JSTL c태그 사용을 위한 taglib 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 프로젝트의 시작 주소를 간단히 얻어올 수 있도록 application scope로 contextPath라는 변수를 생성함--%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!-- header include -->
<jsp:include page="../adminCommon/admin_header.jsp"/>


  <main>
    <div class="contents">
      <section class="right">
        <form action="#" method="post"  enctype="multipart/form-data" role="form" onsubmit="return spaceValidate();">
          <h2 style="text-align: center;">공간등록</h2>
          <div class="spaceWrap">
            <label for="spaceName">공간명</label> 
            <input type="text" id="spaceName" name="spaceName" style="width: 90%;" required >
          </div>
            
          <div class="spaceWrap">
            <label for="spaceSubName">공간부제</label> 
            <input type="text" id="spaceSubName" name="spaceSubName"  style="width: 90%;" >
          </div>
          
          <article class="spaceInfo01">
            <div class="spaceWrap">
              <label for="spaceAddr">공간주소</label> 
              <input type="text" id="spaceAddr" name="spaceAddr"  required>
            </div>

            <div class="spaceWrap">
              <label for="spacePhone">전화번호</label> 
              <input type="text" id="spacePhone" name="spacePhone" required>
            </div>

            <div class="spaceWrap">
              <label for="spaceTime">영업시간</label> 
              <input type="text" id="spaceTime" name="spaceTime" required>
            </div>

            <div class="spaceWrap">
              <label for="spaceClosedDt">휴무일</label> 
              <input type="text" id="spaceClosedDt" name="spaceClosedDt" required>
            </div>

            <div class="spaceWrap">
              <label for="spaceCategory">공간유형</label> 
              <select	 id="spaceCategory" name="spaceCategory" style="width: 150px; height: 25px;" required>
                <option>1</option>
              </select>
            </div>
          </article>

          <article class="spaceMap">
              <label for="map0">지도이미지</label>
            <div class="mapImg">
              <img>
            </div>
          </article>
          
           <label style="margin-top: 20%; clear: left;">공간이미지</label>
          <article class="spacePic">
            <div class="spaceImg">
         	  <label style="margin-top: 20%;">+이미지추가</label>
              <img>
            </div>

            <div class="spaceImg">
          	 <label style="margin-top: 20%;">+이미지추가</label>
              <img>
            </div>
          
            <div class="spaceImg">
	           <label style="margin-top: 20%;">+이미지추가</label>
              <img>
            </div>
          
            <div class="spaceImg" style="margin-right: 0px">
	           <label style="margin-top: 20%;">+이미지추가</label>
              <img>
              
            </div>
          </article>
          
          <div id="fileArea">
            <input type="file" name="map0" onchange="loadMap(this,0)"> 
            <input type="file" name="img0" onchange="loadImg(this,0)"> 
            <input type="file" name="img1" onchange="loadImg(this,1)"> 
            <input type="file" name="img2" onchange="loadImg(this,2)"> 
            <input type="file" name="img3" onchange="loadImg(this,3)"> 
          </div>
       

          <article class="spaceInfo02">
            <div class="spaceWrap02">
              <div>
                <label for="spaceBasic">공간소개</label>
              </div>
              <textarea class="infoForm" id="spaceBasic" name="spaceBasic"></textarea>
            </div>

            <div class="spaceWrap02">
              <div>
                <label for="spaceFacility">시설안내</label>
              </div>
              <textarea class="infoForm" id="spaceFacility" name="spaceFacility"></textarea>
            </div>

            <div class="spaceWrap02">
              <div>
                <label for="spaceCaution">주의사항</label>
              </div>
              <textarea class="infoForm" id="spaceCaution" name="spaceCaution"></textarea>
            </div>

            <div class="spaceWrap02">
              <div>
                <label for="spaceRefund">환불규정</label>
              </div>
              <textarea class="infoForm" id="spaceRefund" name="spaceRefund"></textarea>
            </div>
          </article>

          <article style="margin-top: 40px; margin-bottom: 40px; text-align: center;">
            <button class="btn" onclick="adminRegisterRoomtype">다음</button>
            <button class="btn" conclick="">취소</button>
          </article>
        </form>
        
      </section>
    </main>
</body>
</html>