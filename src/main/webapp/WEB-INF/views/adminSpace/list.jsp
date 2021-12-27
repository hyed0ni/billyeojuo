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
	<table>
	<thead>
		<tr>
			<th>공간번호</th>
			<th>공간명</th>
			<th>주소</th>
			<th>전화번호</th>
			<th>상태</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${adSpaceList}" var="space">
		${space}
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	
	</div>
</main>
<jsp:include page="../adminCommon/admin_footer.jsp"/>
</body>
</html>