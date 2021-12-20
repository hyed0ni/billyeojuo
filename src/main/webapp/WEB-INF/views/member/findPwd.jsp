<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- JSTL c태그 사용을 위한 taglib 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 프로젝트의 시작 주소를 간단히 얻어올 수 있도록 application scope로 contextPath라는 변수를 생성함--%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!-- header include -->
<jsp:include page="../common/header.jsp"/>

<main>
    <div id="contents">
        <div class="box">
            <div class="top-title-wrap">
                <h2 class="title">비밀번호 찾기</h2>
            </div>
            <div class="login-box">
                <div class="login-input-wrap">
                    <input type="text" placeholder="이메일" class="login-input">
                </div>
                <div class="login-notify-wrap">가입 시 사용한 이메일 주소를 입력해 주시면 비밀번호 재설정 링크를 보내드립니다.
                    네이버, 구글로 가입하신 경우 비밀번호 찾기가 불가합니다.
                </div>
                <a href="#self" class="login-btn">비밀번호 재설정 링크 보내기</a>
            </div>
        </div>
    </div>
</main>


</body>
</html>
