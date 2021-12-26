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
	                <input type="text" id="spaceName" name="roomName" required style="width: 435px;" >
	            </div>
	            
	            <div class="roomWrap">
	              <label for="spaceSubName">가격</label> 
	              <input type="text" id="spaceSubName" name="roomPrice" required> 원
	            </div>
	              
	             <div class="roomWrap">
	                <label for="spaceAddr">이용 인원</label> 
	                <input type="text" id="spaceAddr" name="roomFit" required > 명
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
	         	 
	            <div id="fileArea">
	            <input type="file" name="img0" onchange="loadImg(this,0)"> 
	            </div>
		
	          <article class="roomInfo02">
	            <div class="roomWrap02">
	              <div>
	                <label for="roomBasic">공간소개</label>
	              </div>
	              <textarea class="roomInfoForm" id="roomBasic" name="roomDesc"></textarea>
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

  
  
 <script>
   function createRoom(){
       let index = 0;
       let html = `
            <div>
                <article class="roomInfo01">
                   <div class="roomWrap">
                      <label for="spaceName" >공간 타입 이름</label> 
                      <input type="text" id="roomName" name="roomName" required style="width: 435px;" >
                  </div>
                  
                  <div class="roomWrap">
                    <label for="spaceSubName">가격</label> 
                    <input type="text" id="roomPrice" name="roomPrice" required> 원
                  </div>
                    
                   <div class="roomWrap">
                      <label for="spaceAddr">이용 인원</label> 
                      <input type="text" id="roomFit" name="roomFit" required > 명
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
                   
                  <div id="fileArea">
                  <input type="file" name="img' + index + ' onchange="loadImg(this,'+ (index++) +'')"> 
                  </div>
         
                <article class="roomInfo02">
                  <div class="roomWrap02">
                    <div>
                      <label for="roomBasic">공간소개</label>
                    </div>
                    <textarea class="roomInfoForm" id="roomBasic" name="roomDesc"></textarea>
                  </div>
                </article>
             </div>
       `;
       $(".roomTypeWrap").append(html);

      // 룸타입 갯수
      const roomCnt =  Number($("input[name='roomCount']").val());
      
      $("input[name='roomCount']").val(roomCnt+1);

      index++;
     }
  </script>
  
  
  <script src="${contextPath}/resources/js/adminRoomtType.js"></script>
</body>
</html>