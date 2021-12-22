// 로그인 시 유효성 검사
function loginValidate() {

  const memberId = document.getElementById("email");
  const memberPw = document.querySelector("#pwd1");

  // 아이디가 입력되지 않은 경우
  // "아이디를 입력해주세요." 경고창 출력 후 아이디 input으로 focus 이동
  if (memberId.value.trim().length == 0) {
    alert("아이디를 입력해주세요.");
    memberId.focus();
    return false;
  }

  // 비밀번호가 입력되지 않은 경우
  if (memberPw.value.trim().length == 0) {
    alert("비밀번호를 입력해주세요.");
    memberPw.focus();
    return false;
  }

}

function findPwdValidate() {
  const email = document.getElementById("login-input").value;

  if (email.trim().length == 0) {

    alert("이메일을 입력해주세요.");
    
    email.focus();

    return false;

  }else{

    alert("이메일 전송이 완료되었습니다.");

  }
}


