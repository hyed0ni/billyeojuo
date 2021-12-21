 
 <%-- JSTL c태그 사용을 위한 taglib 추가 --%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


 <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
 <!-- session 에 message 속성이 존재하는 경우 alter 창을 해당 내용 출력 -->
<c:if test="${!empty sessionScope.message }">
	<script>
		$(function(){
		alert("${message}");
		//EL 작성시 scope를 작성하지 않으면 scope를 순서대로 검색, 일치하는 속성이 있으면 출력
		})
	</script>
	
	<%--     문제 : session에 message 키 값이 유지되어있어서 정상회원임에도 값이 남아있다. 
         해결 : c:if문이 끝나기 전에 session의 message를 지운다  --%>
         
   <%-- message 1회 출력 후 session에서 제거 --%>
   <c:remove var="message" scope="session"/>
</c:if>