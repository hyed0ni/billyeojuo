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
                <form class="form-signin" method="POST" action="${contextPath}/member/login" onsubmit="return loginValidate()">
                <div class="login-input-wrap">
                    <input type="text" placeholder="이메일" class="login-input" name="email" id="email" value="${ cookie.saveId.value }">
                    <input type="password" placeholder="비밀번호" class="login-input" name="pwd1" id="pwd1">
                </div>
                <div class="login-options">
                    <c:if test="${!empty cookie.saveId.value}">
                        <c:set var="chk" value="checked" />
                        
                     </c:if>
                    <label><input type="checkbox" name="save" ${chk} > 로그인 기억하기</label>
                    <a href="${contextPath}/member/findPwd">비밀번호 찾기</a>
                </div>
                <button type="submit" class="login-btn">이메일로 로그인</button>
                </form>
                <div class="sign-up-wrap">
                    <span style="font-size: 13px;">아직 빌려주오의 회원이 아니신가요?</span>
                    <a href="${contextPath}/member/signup">회원가입</a>
                </div>
            </div>
        </div>
    </div>
</main>

	<script src="${contextPath}/resources/js/memberLogin.js">
		
	</script>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>