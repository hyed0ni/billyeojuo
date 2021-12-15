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
                <h2 class="title">게스트 로그인</h2>
            </div>
            <div class="login-box gray">
                <div class="login-method">
                    <a href="#self">네이버로 로그인</a>
                    <a href="#self">구글로 로그인</a>
                </div>
                <div class="login-divide">또는</div>
                <div class="login-input-wrap">
                    <input type="text" placeholder="이메일" class="login-input">
                    <input type="text" placeholder="비밀번호" class="login-input">
                </div>
                <div class="login-options">
                    <label><input type="checkbox"> 로그인 기억하기</label>
                    <a href="${contextPath}/member/findPwd">비밀번호 찾기</a>
                </div>
                <a href="#self" class="login-btn">이메일로 로그인</a>
                <div class="sign-up-wrap">
                    <span>아직 빌려주오의 회원이 아니신가요?</span>
                    <a href="${contextPath}/member/signup">회원가입</a>
                </div>
            </div>
        </div>
    </div>
</main>



</body>
</html>