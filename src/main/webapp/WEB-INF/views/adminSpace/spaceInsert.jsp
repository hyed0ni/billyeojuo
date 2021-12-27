<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- JSTL c태그 사용을 위한 taglib 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 프로젝트의 시작 주소를 간단히 얻어올 수 있도록 application scope로 contextPath라는 변수를 생성함--%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!-- header include -->
<jsp:include page="../adminCommon/admin_header.jsp"/>
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/admin_register.css">    


  <main>
    <div class="contents">
      <section class="right">
        <form action="insert" method="post"  enctype="multipart/form-data" role="form" onsubmit="return spaceValidate();">
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
              <label for="spaceCategory">공간유형</label> 
              <select	 id="spaceCategory" name="spaceTypeNo" style="width: 150px; height: 25px;" required>
             		<c:forEach items="${adSpaceType}" var="a">
						<option value="${a.adSpaceTypeNo}">${a.adSpaceTypeName}</option>
											
					</c:forEach>
              </select>
            </div>
          
            <div class="spaceWrap">
              <label for="spaceAddr">공간주소</label> 
              <input type="text" id="spaceAddr" name="spaceAddr"  required>
            </div>

            <div class="spaceWrap">
              <label for="spacePhone">전화번호</label> 
              <input type="text" id="spacePhone" name="spacePhone" placeholder=" '-'을 포함하여 작성 (ex 010-1233-1234)" required>
            </div>

            <div class="spaceWrap">
              <label for="spaceTime">영업시간</label> 
              <input type="text" id="spaceTime" name="spaceTime" required>
            </div>

            <div class="spaceWrap">
              <label for="spaceClosedDt">휴무일</label> 
              <input type="text" id="spaceClosedDt" name="spaceClosedDt" required>
            </div>
          </article>

          <label style="margin-top: 20%;">지도이미지</label>
          <article class="spaceMap">
            <div class="spaceImg">
              <img>
            </div>
          </article>
          
          <label style="margin-top: 20%; clear: left;">공간이미지</label>
          <article class="spacePic">
            <div class="spaceImg">
            <label style="margin-top: 20%;">+이미지추가</label>
              <img >
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
            <input type="file" name="img0" onchange="loadImg(this,0)"> 
            <input type="file" name="img1" onchange="loadImg(this,1)"> 
            <input type="file" name="img2" onchange="loadImg(this,2)"> 
            <input type="file" name="img3" onchange="loadImg(this,3)"> 
            <input type="file" name="img4" onchange="loadImg(this,4)"> 
          </div>

          <article class="spaceInfo02">
            <div class="spaceWrap02">
              <div>
                <label for="spaceBasic">공간소개</label>
              </div>
              <textarea class="infoForm" id="spaceIntro" name="spaceIntro"></textarea>
            </div>

            <div class="spaceWrap02">
              <div>
                <label for="spaceFacility">시설안내</label>
              </div>
              <textarea class="infoForm" id="spaceGuide" name="spaceGuide"></textarea>
            </div>

            <div class="spaceWrap02">
              <div>
                <label for="precautions">주의사항</label>
              </div>
              <textarea class="infoForm" id="precautions" name="precautions"></textarea>
            </div>

            <div class="spaceWrap02">
              <div>
                <label for="refundPolicy">환불규정</label>
              </div>
              <textarea class="infoForm" id="refundPolicy" name="refundPolicy"></textarea>
            </div>
          </article>

       
<%--           <h2 style="text-align: center;">공간 타입등록</h2>
          
          <article class="roomInfo01">
            <div class="roomWrap">
              <label for="roomName">공간 타입 이름</label> 
              <input type="text" id="roomName" name="roomName" style="width: 80%; text-align: left;" required >
            </div>

            <div class="roomWrap">
              <label for="roomPrice">가격</label> 
              <input type="text" id="roomPrice" name="roomPrice" required> 원
            </div>

            <div class="roomWrap">
              <label for="roomFit">수용인원</label> 
              <input type="text" id="roomFit" name="roomFit" required > 명
            </div>

            <div class="roomWrap">
              <label for="roomOption">공간옵션</label> 
                	<c:forEach items="${adSpaceOption}" var="o">
						<input type="checkbox" name="roomOption" class="roomRadio" style="width: 20px;"value="${o.adOptionNo}"> ${o.adOptionName}
					</c:forEach>

            </div>
          </article>



          <article class="roomInfo02">
            <div class="roomWrap02">
              <div>
                <label for="roomDesc">공간소개</label>
              </div>
              <textarea class="roomInfoForm" id="roomDesc" name="roomDesc" style="width: 100%; height: 150px;"></textarea>
            </div>
          </article> --%>
          
          <article style="margin-top: 40px; margin-bottom: 40px; text-align: center;">
            <button class="btn">다음</button>
            <button class="btn" onclick="list" >취소</button>
          </article>

        </form>
      </section>
    </div>
  </main>
    
  <jsp:include page="../adminCommon/admin_footer.jsp"/>
  <script src="${contextPath}/resources/js/adminSpaceRegister.js"></script>


</body>
</html>