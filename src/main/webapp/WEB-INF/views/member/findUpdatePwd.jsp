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
            <form action="${contextPath}/member/findUpdatePwd" method="post" >
                <input type="hidden" name="email" value="${param.email}">
            <div class="login-box">
                <div class="login-input-wrap" style="margin-bottom: 20px;"><span style="display: block; padding-bottom: 10px;">새 비밀번호 입력</span>
                    <input type="password" placeholder="" class="login-input" name="findUpdatePwd1" id="findUpdatePwd1" style="margin-bottom: 10px;">
                    <span id="checkPwd1"></span>
                </div>
                <div class="login-iput-wrap"> <span style="display: block; padding-bottom: 10px;">새 비밀번호 확인</span>
                    <input type="password" placeholder="" class="login-input" name="findUpdatePwd2" id="findUpdatePwd2" style="margin-bottom: 10px;">
                    <span id="checkPwd2"></span>
                </div>
                <button  type="submit"  class="login-btn change-password-btn">비밀번호 변경</button>
            </div>
            </form>
        </div>
    </div>
</main>

		
</script>

<script>

var is_checked_password = true;
var is_checked_password_confirm = true;
		
    // 비밀번호 유효성 검사
// 영어 대/소문자, 숫자, 특수문자(!,@,#,-,_) 6~20글자 
$("#findUpdatePwd1").on("input", function() {

    const regExp = /^[a-zA-z\d\!\@\#\-\_]{6,20}$/;
    const findUpdatePwd1 = $(this).val();


    if (regExp.test(findUpdatePwd1)) {
        $("#checkPwd1").text("알맞은 비밀번호 형식입니다.").css("color", "green");
        $("#checkPwd1").show();
        is_checked_password = true;
    } else {
        $("#checkPwd1").text("잘못된 비밀번호 형식입니다.").css("color", "red");
        $("#checkPwd1").show();
        is_checked_password = false;

    }

});

// 비밀번호 확인 유효성 검사 
$("#findUpdatePwd1, #findUpdatePwd2").on("input", function() {
const pwd1 = document.getElementById("findUpdatePwd1").value;

const pwd2 = document.getElementById("findUpdatePwd2").value;
//const pw2 = this.value;
const checkPwd2 = document.getElementById("checkPwd2");

if (pwd2.trim().length == 0) { 
    checkPwd2.innerText = "";
    is_checked_password_confirm = false;
    $("#checkPwd2").hide();

} else if (pwd1 == pwd2) {
    checkPwd2.innerText = "일치합니다.";
    checkPwd2.style.color = "green";
    is_checked_password_confirm = true;
    $("#checkPwd2").show();
    
} else {
    checkPwd2.innerText = "일치하지 않습니다.";
    checkPwd2.style.color = "red";
    is_checked_password_confirm = false;
    $("#checkPwd2").show();
}

});

$('.change-password-btn').on('click', function() {

    var findUpdatePwd1 = $('#findUpdatePwd1').val();
    var findUpdatePwd2 = $('#findUpdatePwd2').val();

    if (findUpdatePwd1.length == 0) {
        alert("비밀번호를 입력해 주세요.");
        is_checked_password = false;
        return false;
    }

    if(is_checked_password === false || is_checked_password_confirm === false) {
        alert('비밀번호가 일치하지 않습니다.');
        return false;
    }

    if(!confirm('비밀번호를 변경하시겠습니까?')) {
        return false;
    }

    alert("비밀번호가 변경되었습니다.");
})



</script>



<jsp:include page="../common/footer.jsp"/>

</body>
</html>
