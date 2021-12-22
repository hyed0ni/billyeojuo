<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- JSTL c태그 사용을 위한 taglib 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 프로젝트의 시작 주소를 간단히 얻어올 수 있도록 application scope로 contextPath라는 변수를 생성함--%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!-- header include -->
<jsp:include page="../common/header.jsp"/>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

<main>
    <div id="contents">
        <div class="box">
            <div class="top-title-wrap">
                <h2 class="title">비밀번호 변경</h2>
            </div>
            <form action="${contextPath}/member/findUpdatePwd" method="get" onsubmit="return findPwdValidate();">
            <div class="login-box">
                <div class="login-input-wrap"> 새 비밀번호 입력
                    <input type="text" placeholder="" class="login-input" name="findUpdatePwd1" id="findUpdatePwd1">
                </div>
                <div class="login-iput-wrap"> 새 비밀번호 확인
                    <input type="text" placeholder="" class="login-input" name="findUpdatePwd2" id="findUpdatePwd2">
                </div>
                <button  type="submit"  class="login-btn">비밀번호 변경</button>
            </div>
            </form>
        </div>
    </div>
</main>

		
</script>

<script>
		
    // 비밀번호 유효성 검사
// 영어 대/소문자, 숫자, 특수문자(!,@,#,-,_) 6~20글자 
$("#findUpdatePwd1").on("blur", function() {

const regExp = /^[a-zA-z\d\!\@\#\-\_]{6,20}$/;
const findUpdatePwd1 = $(this).val();

if (findUpdatePwd1.length == 0) {
    alert("비밀번호를 입력해주세요.");

    return
} else if (regExp.test(inputPwd1)) {
    $("#checkPwd1").text("알맞은 비밀번호 형식입니다.").css("color", "green");
    $("#checkPwd1").show();
   
} else {
    $("#checkPwd1").text("잘못된 비밀번호 형식입니다.").css("color", "red");
    $("#checkPwd1").show();
   
}

});

// 비밀번호 확인 유효성 검사 
$("#pwd2, #pwd1").on("input", function() {
const pwd1 = document.getElementById("pwd1").value;

const pwd2 = document.getElementById("pwd2").value;
//const pw2 = this.value;
const checkPwd2 = document.getElementById("checkPwd2");

if (pwd2.trim().length == 0) { 
    checkPwd2.innerText = "";
    $("#checkPwd2").hide();
    



} else if (pwd1 == pwd2) {
    checkPwd2.innerText = "일치합니다";
    checkPwd2.style.color = "green";
    $("#checkPwd2").show();
    
} else {
    checkPwd2.innerText = "일치하지 않습니다";
    checkPwd2.style.color = "red";
    $("#checkPwd2").show();
   
}

});



</script>



<jsp:include page="../common/footer.jsp"/>

</body>
</html>
