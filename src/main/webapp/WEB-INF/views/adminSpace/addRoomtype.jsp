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
        <input type="hidden" name="roomCount" value="1">
          <h2 style="text-align: center;">공간 타입등록</h2>
          
          <article class="roomTypeWrap">
          	<div>
	          <article class="roomInfo01">
	          	<div class="roomWrap">
	                <label for="spaceName" >공간 타입 이름</label> 
	                <!-- <input type="text" id="spaceName" name="roomName" required style="width: 435px;" > -->
	                <input type="text" id="spaceName" name="roomName" required style="width: 435px;" value="A그룹(1~8명)">
	            </div>
	            
	            <div class="roomWrap">
	              <label for="spaceSubName">가격</label> 
	              <!-- <input type="text" id="spaceSubName" name="roomPrice" required> 원 -->
	              <input type="text" id="spaceSubName" name="roomPrice" required value="33000"> 원
	            </div>
	              
	             <div class="roomWrap">
	                <label for="spaceAddr">이용 인원</label> 
	                <!-- <input type="text" id="spaceAddr" name="roomFit" required > 명 -->
	                <input type="text" id="spaceAddr" name="roomFit" required value="최소 1명 ~ 최대 8명" > 명
	              </div>
	
	       
	                <label for="roomOption">공간옵션</label> 
	              <div class="roomWrap">
	       		<c:forEach items="${adSpaceOption}" var="rt"> 
	                <input type="checkbox" name="roomOption" class="roomRadio" value="${rt.adOptionNo}"> ${rt.adOptionName}
	              </c:forEach>
	              </div>
	            </article>
	            
	          <article class="roomMap">
	         	 <label>룸 이미지</label>
	            <div class="roomImg">
	              <img>
	            </div>
	          </article>
	         	 
	            <div class="fileArea">
	            <input type="file" name="img0" onchange="loadImg(this,0)"> 
	            </div>
		
	          <article class="roomInfo02">
	            <div class="roomWrap02">
	              <div>
	                <label for="roomBasic">공간소개</label>
	              </div>
	              <!-- <textarea class="roomInfoForm" id="roomBasic" name="roomDesc"></textarea> -->
	              <textarea class="roomInfoForm" id="roomBasic" name="roomDesc">
**12/4(금)~1/2(토)는 파티룸 성수기로 별도 대관료 적용합니다***
금,토 저녁6~12시까지: 30만원
금, 토 저녁6~다음날 아침8시까지: 40만원
1. 사용인원이 '8명 이하' 인 경우.
2. 기본사용시간은 3시간.
3. 금, 토, 공휴일 전날 저녁(17~24시)은 대관료가 시간당 4만원씩입니다.
4. 음식과 주류 반입시 10만원 추가 
5. 대관목적에 따라 시설보증금 5~10만원 별도. 
6. 시설보증금 환불 기준 : 공간 내부 정리 상태, 분리수거 배출,  흡연, 기물 파손 및 분실 여부, 예약인원 준수여부 확인 후 전액환불.
7. 정기대관은 할인혜택드리니 별도 문의 주세요.
	              </textarea>
	            </div>
	          </article>
          </div>
          </article>
          
           <article style="margin-bottom: 40px; text-align: center;">
            <button type="button" id="addBtn" onclick="createRoom();">룸타입 추가</button> <br>
            <button class="btn" >등록하기</button>
            <button class="btn" onclick="">취소</button>
          </article>
        </form>
        

		
      </section> 
    </div>
  </main>
  
  <jsp:include page="../adminCommon/admin_footer.jsp"/>
  <script src="${contextPath}/resources/js/adminRoomtType.js"></script>
  
   <script>
        let index = 1;
        function createRoom(){
        	
            let html = 
                      '<div>'
                    + '<article class="roomInfo01">'
                        + '<div class="roomWrap">'
                            + '<label for="spaceName" >공간 타입 이름</label>'
                            /* + '<input type="text" id="roomName" name="roomName" required style="width: 435px;" >' */
                            + '<input type="text" id="roomName" name="roomName" required style="width: 435px;" value="B그룹(9~14명)" >'
                        + '</div>'
                        
                        + '<div class="roomWrap">'
                            + '<label for="spaceSubName">가격</label>'
                            /* + '<input type="text" id="roomPrice" name="roomPrice" required> 원' */
                            + '<input type="text" id="roomPrice" name="roomPrice" required value="44000"> 원'
                        + '</div>'
                            
                        + '<div class="roomWrap">'
                            + '<label for="spaceAddr">이용 인원</label> '
                            /* + '<input type="text" id="roomFit" name="roomFit" required > 명' */
                            + '<input type="text" id="roomFit" name="roomFit" required value="최소 9명 ~ 최대 14명"> 명'
                        + '</div>'
            
                    
                        + '<label for="roomOption">공간옵션</label> '
                        + '<div class="roomWrap">'
                            <c:forEach items="${adSpaceOption}" var="rt"> 
                                + '<input type="checkbox" name="roomOption'+index+'" class="roomRadio" value="${rt.adOptionNo}"> ${rt.adOptionName}'
                            </c:forEach>
                        + '</div>'
                    + '</article>'
                       
                    + '<article class="roomMap">'
                        + '<label>룸 이미지</label>'
                            + '<div class="roomImg">'
                                + '<img>'
                            + '</div>'
                    + '</article>'
                        
                    + '<div class="fileArea">'
                        + '<input type="file" name="img' + index + '" onchange="loadImg(this,'+ index +')"> '
                    + '</div>'
              
                    + '<article class="roomInfo02">'
                        + '<div class="roomWrap02">'
                            + '<div>'
                                + '<label for="roomBasic">공간소개</label>'
                            + '</div>'
                            /* + '<textarea class="roomInfoForm" id="roomBasic" name="roomDesc"></textarea>' */
                            + '<textarea class="roomInfoForm" id="roomBasic" name="roomDesc">'
                            + '1. 사용인원이 \'9명~14명 이하\' 인 경우.\n'
                            + '2. 기본사용시간은 3시간.\n'
                            + '3. 금, 토, 공휴일 전날 17~24시는 대관료가 시간당 5만원씩입니다.\n'
                            + '4. 배달음식과 주류반입시 10만원 추가\n'
                            + '5. 대관목적에 따라 시설보증금 5~10만원 별도. \n'
                            + '6. 시설보증금 환불 기준 : 공간 내부 정리 상태, 분리수거 배출,  흡연, 기물 파손 및 분실 여부, 예약인원 준수여부 확인 후 전액환불.\n'
                            + '7. 정기대관은 할인혜택드리니 별도 문의 주세요. \n'
                            + '</textarea>'
                        + '</div>'
                    + '</article>'
                + '</div>';
                
            $(".roomTypeWrap").append(html);
     
           // 룸타입 갯수
           const roomCnt =  Number($("input[name='roomCount']").val());
           
           $("input[name='roomCount']").val(roomCnt+1);
    
           index++;
          
          }
       </script>

  
  

</body>
</html>