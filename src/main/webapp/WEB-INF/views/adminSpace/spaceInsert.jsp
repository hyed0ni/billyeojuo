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
            <input type="text" id="spaceName" name="spaceName" style="width: 810px;" required value="카이 플레이스(회의,촬영,파티)" >
          </div>
            
          <div class="spaceWrap">
            <label for="spaceSubName">공간부제</label> 
            <input type="text" id="spaceSubName" name="spaceSubName"  style="width: 810px;" value="사당역에서 1분, 25평 단독대관" >
          </div>
          
          <article class="spaceInfo01">
            <div class="spaceWrap">
              <label for="spaceCategory">공간유형</label> 
              <select	 id="spaceCategory" name="spaceTypeNo" style="width: 150px; height: 25px; border: 0px;" required>
             		<c:forEach items="${adSpaceType}" var="a">
						<option value="${a.adSpaceTypeNo}">${a.adSpaceTypeName}</option>
											
					</c:forEach>
              </select>
            </div>
          
            <div class="spaceWrap">
              <label for="spaceAddr">공간주소</label> 
              <input type="text" id="spaceAddr" name="spaceAddr"  required value="서울특별시 서초구 방배2동 452-6 4층">
            </div>

            <div class="spaceWrap">
              <label for="spacePhone">전화번호</label> 
              <input type="text" id="spacePhone" name="spacePhone" placeholder=" '-'을 포함하여 작성 (ex 010-1233-1234)" required value="010-1234-1234">
            </div>

            <div class="spaceWrap">
              <label for="spaceTime">영업시간</label> 
              <input type="text" id="spaceTime" name="spaceTime" required value="0~24시">
            </div>

            <div class="spaceWrap">
              <label for="spaceClosedDt">휴무일</label> 
              <input type="text" id="spaceClosedDt" name="spaceClosedDt" required value="없음">
            </div>
          </article>

          <label style="margin-top: 20px;font-size: 17px; font-weight: bold; display: block;">지도이미지</label>
          <article class="spaceMap">
            <div class="spaceImg">
              <img>
            </div>
          </article>
          
          <label style="margin-top: 20%; clear: left;  font-size: 17px; font-weight: bold">공간이미지</label>
          <article class="spacePic">
            <div class="spaceImg">
            <label style="margin-top: 20%;" class="addImage">+이미지추가</label>
              <img >
            </div>

            <div class="spaceImg">
              <label style="margin-top: 20%;" class="addImage">+이미지추가</label>
              <img>
            </div>
          
            <div class="spaceImg">
	          <label style="margin-top: 20%;"class="addImage">+이미지추가</label>
              <img>
            </div>
          
            <div class="spaceImg" style="margin-right: 0px">
	          <label style="margin-top: 20%;"class="addImage">+이미지추가</label>
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
                <label for="spaceBasic" style="margin-top: 20px;margin-bottom: 10px; clear: left;  font-size: 17px; font-weight: bold; display: block;"" >공간소개</label>
              </div>
              <textarea class="infoForm" id="spaceIntro" name="spaceIntro">
마음까지 힐링되는 공간,카이플레이스입니다.
카이 플레이스는 다양한 모임(브라이덜샤워, 생일파티, 워크샵, 회의, 파티, 촬영)에 적합합니다.

*사당역11번 출구 90m 거리
*25평 단독대관, 최대20명
*내부 단독 화장실

#A그룹: 1~ 8명 (시간당 3만원) / A그룹종일(9~17시): 15만원
#B그룹: 9~14명 (시간당 4만원) / B그룹종일(9~17시): 20만원
#C그룹:15~20명 (시간당 5만원)/ C그룹종일(9~17시): 25만원

■금토공휴일전날 17~24시는 시간당 요금 1만원씩 추가
■올나잇 시간추가 ▶24:00~다음날7시(10만원)
■청소대행시 ▶AB그룹: 3, CD그룹:4만원
■보증금10만원별도
              </textarea>
            </div>

            <div class="spaceWrap02">
              <div>
                <label for="spaceFacility" style="margin-top: 20px; margin-bottom: 10px;  font-size: 17px; font-weight: bold; display: block;">시설안내</label>
              </div>
              <textarea class="infoForm" id="spaceGuide" name="spaceGuide">
165인치 스마트TV(5.1채널 스피커), 블루투스 스피커 (IPTV 시청가능, 노트북은 개별 지참)
2약 2700가지 오락실게임(2인) 무료 이용
35G초고속 WIFI 설치/멀티 스마트폰 충전기/천정형 냉난방기 /공기청정기/ 블루투스 마이크
4분장실 및 탈의실 구비
5냉장고(냉동가능), 전자레인지, 냉온정수기
6각종 술잔, 컵, 그릇, 식기류, 수저류
7주차 불가 - 인근 공영주차장 이용
8취사시설 없음
9전 사용자의 파손 및 분실로 인해 상기 서비스가 차질이 생길 수도 있습니다.
10보증금 구분: 5~10만원(음식반입여부, 사용시간, 사용인원 등 조건에 따라 차등)
              </textarea>
            </div>

            <div class="spaceWrap02">
              <div>
                <label for="precautions" style="margin-top: 20px; margin-bottom: 10px;  font-size: 17px; font-weight: bold; display: block;"">주의사항</label>
              </div>
              <textarea class="infoForm" id="precautions" name="precautions">
결제 전 예약 문의시 대관 목적과 사용인원을 반드시 말씀해주세요.
2카이 플레이스 시설물 보호를 위해 대관 전 보증금 10만원을 받습니다. 대관 후 시설물 체크한 뒤 문제가 없는 경우 보증금은 2-3일 내에 전액 돌려드립니다.
3기물 파손 및 분실시 구입가로 청구됩니다. 반환기준은 쓰레기 분리수거, 내부 가구 및 기구 원위치, 기물파손∙분실 없음, 계약인원 충족, 반입물품 반출 등 입니다.
4실내 전체 절대 금연입니다(전자담배 포함). 흡연 적발시 보증금 반환 불가합니다.
5침구류나 샤워시설과 같은 숙박관련 시설 및 용품이 준비되어있지 않습니다.
6개인 부주의에 의한 안전사고에 대하여 카이 플레이스에서는 어떠한 책임도 지지 않습니다.
7화재 및 범죄예방을 위해 CCTV가 설치되어 있으며 7일 뒤 자동 삭제됩니다.
8저녁 8시 이후는 미성년자 이용이 불가능합니다.
9퇴실시 조명, 냉난방기, TV전원을 꼭 꺼주시기 바랍니다.
10사용인원에 따라 대관료가 다릅니다. 최대인원 기준으로 예약해주세요.(종일상품대관시 오전8명, 오후 15명이면 C그룹) 예약인원 속이면 보증금 반환하지 않습니다.
              </textarea>
            </div>

            <div class="spaceWrap02">
              <div>
                <label for="refundPolicy"style="margin-top: 20px; margin-bottom: 10px;  font-size: 17px; font-weight: bold; display: block;">환불규정</label>
              </div>
              <textarea class="infoForm" id="refundPolicy" name="refundPolicy">
총 금액의 100% 환불
총 금액의 100% 환불
총 금액의 100% 환불
환불 불가
환불 불가
환불 불가
환불 불가
환불 불가
환불 불가
              </textarea>
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