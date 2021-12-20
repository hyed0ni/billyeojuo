<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- JSTL c태그 사용을 위한 taglib 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 프로젝트의 시작 주소를 간단히 얻어올 수 있도록 application scope로 contextPath라는 변수를 생성함--%>
<c:set var="contextPath"
	value="${pageContext.servletContext.contextPath}" scope="application" />

<!-- header include -->
<jsp:include page="../common/header.jsp" />
<main>

	<div id="contents">
		<div class="box">
			<div class="top-title-wrap">
				<h2 class="title">회원가입</h2>
			</div>
			<form method="POST" action="signup" class="needs-validation"
				name="signUpForm" onsubmit="return validate();">
				<div class="login-box">
					<div class="login-method">
						<a href="#self">네이버로 로그인</a> <a href="#self">구글로 로그인</a>
					</div>
					<div class="login-divide">또는</div>
					<div class="login-input-wrap">
						<input type="text" id="name" name="name" placeholder="닉네임" class="login-input" required>
						<p id="checkName" class="chkarea"></p>
						<input type="text" id="email" name="email" placeholder="이메일" class="login-input" required>
						<p id="checkEmail" class="chkarea"></p>
						<input type="password" id="pwd1" name="pwd1" placeholder="비밀번호" class="login-input" required>
						<p id="checkPwd1" class="chkarea"></p>
						<input type="password" id="pwd2" placeholder="비밀번호 확인" class="login-input" required>
						<p id="checkPwd2" class="chkarea"></p>
					</div>
					<div class="login-options">
						<label><input type="checkbox" id="allAgree"> 아래 약관에 모두 동의합니다.</label>
					</div>
					<div class="divide"></div>
					<div class="login-options agree-terms">
						<label><input type="checkbox" class="checked chk1" id="chk1"> 서비스 이용약관 (필수)</label> <label><input
							type="checkbox" class="checked chk2" id="chk2"> 개인정보 처리 방침 (필수)</label> <label><input
							type="checkbox" class="checked" name="sms_check" value="1"> 이벤트 등 프로모션 알림 SMS 수신 (선택)</label> <label><input
							type="checkbox" class="checked" name="email_check" value="1"> 이벤트 등 프로모션 알림 메일 수신 (선택)</label>
					</div>
					<button type="submit" class="login-btn">회원가입</button>
				</div>
			</form>
		</div>
	</div>
</main>
	<script src="${contextPath}/resources/js/member.js">
		
	</script>


</body>

</html>