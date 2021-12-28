

// 각 입력 값의 유효성 검사 결과를 담는 객체
const signUpCheckObj = {

	"name": false,
	"email": false,
	"pwd1": false,
	"pwd2": false

};

function validate() {  // 회원가입 버튼 클릭 시 유효성 검사여부 판단

	

	for (key in signUpCheckObj) {

		
		if (!signUpCheckObj[key]) {

			let message;

			
			switch (key) {

				case "name": message = "이름 형식이 맞지 않습니다."; break;
				case "email": message = "올바른 이메일 형식이 아닙니다."; break;
				case "pwd1": message = "올바른 비밀번호 형식이 아닙니다."; break;
				case "pwd2": message = "올바른 비밀번호 형식이 아닙니다."; break;

            }


			alert(message);

           
            document.getElementById(key).focus();



			
			return false;

		}

	}
	

};

// 닉네임 유효성 검사
// 한글(자음 + 모음[+ 받침]), 2~8글자
$("#name").on("input", function() {

	const inputName = $(this).val();  
	const regExp = /^[가-힣]{2,5}$/;

	if (inputName.length == 0) {
		$("#checkName").text("");
		$("#checkName").hide();
		signUpCheckObj.name = false;
	} else if (regExp.test(inputName)) {
		$("#checkName").text("유효한 이름 값입니다.").css("color", "green");
		$("#checkName").show();
		signUpCheckObj.name = true;
	} else if (!regExp.test(inputName)) {
		$("#checkName").show();
		$("#checkName").text("유효하지 않은 이름 값입니다.").css("color", "red");
		signUpCheckObj.name = false;
	}

});

// 이메일 유효성 검사
// 아이디가 4글자 이상인 이메일 주소 형식
$("#email").on("input", function() {

	const regExp = /^[\w]{4,}@[\w]+(\.[\w]+){1,3}$/;
	const inputEmail = $(this).val();


	if (inputEmail.length == 0) {
		$("#checkEmail").text("");
		$("#checkEmail").hide();
		signUpCheckObj.email = false;
	} else if (regExp.test(inputEmail)) {
		
		$.ajax({

			url: "emailDupCheck", 
			type: "GET",
			data: { "inputEmail": inputEmail }, 
			success: function(result) {
				if (result == 0) {
					$("#checkEmail").text("사용가능한 이메일입니다.").css("color", "green");
					$("#checkEmail").show();
					signUpCheckObj.email = true;
				} else {
					$("#checkEmail").text("이메일이 중복됩니다.").css("color", "red");
					$("#checkEmail").show();
					signUpCheckObj.email = false;
				}
			},
			error: function(request, status, error) {
				
				if (request.status == 404) {
					console.log("ajax 요청주소가 올바르지 않습니다.");
				} else if (request.status == 500) {
					console.log("서버 내부 에러");
					console.log(request.responseText);
				}
			},
			complite: function() {

			}
		});



	} else {
		$("#checkEmail").text("잘못된 이메일 형식입니다.").css("color", "red");
		$("#checkEmail").show();
		signUpCheckObj.email = false;
	}

});

// 비밀번호 유효성 검사
// 영어 대/소문자, 숫자, 특수문자(!,@,#,-,_) 6~20글자 
$("#pwd1").on("input", function() {

	const regExp = /^[a-zA-z\d\!\@\#\-\_]{6,20}$/;
	const inputPwd1 = $(this).val();

	if (inputPwd1.length == 0) {
		$("#checkPwd1").text("");
		$("#checkPwd1").hide();
		signUpCheckObj.pwd1 = false;
	} else if (regExp.test(inputPwd1)) {
		$("#checkPwd1").text("알맞은 비밀번호 형식입니다.").css("color", "green");
		$("#checkPwd1").show();
		signUpCheckObj.pwd1 = true;
	} else {
		$("#checkPwd1").text("잘못된 비밀번호 형식입니다.").css("color", "red");
		$("#checkPwd1").show();
		signUpCheckObj.pwd1 = false;
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
		signUpCheckObj.pwd2 = false;



	} else if (pwd1 == pwd2) {
		checkPwd2.innerText = "일치합니다";
		checkPwd2.style.color = "green";
		$("#checkPwd2").show();
		signUpCheckObj.pwd2 = true;
	} else {
		checkPwd2.innerText = "일치하지 않습니다";
		checkPwd2.style.color = "red";
		$("#checkPwd2").show();
		signUpCheckObj.pwd2 = false;
	}

});

    // SMS 수신 유효성 검사

    $("#allAgree").on("change", function(){
        const all = $("#allAgree").prop("checked");

        if(all == true){
            $(".checked").prop("checked", true);
        }else{
            $(".checked").prop("checked", false);
        }
   
    });

    $(".checked").on("change", function(){
        if(!$(this).prop("checked")){
            $("#allAgree").prop("checked", false);
        }
        if( $(".checked:checked").length == $(".checked").length ){
            $("#allAgree").prop("checked", true);
        }

    });

    $('form').submit(function() {

        var chk1 = $('#chk1').prop('checked');
        var chk2 = $('#chk2').prop('checked');

        if(!chk1) {
            alert('서비스이용동의에 체크해 주세요.');
            return false;
        }
        if(!chk2) {
            alert('개인정보동의에 체크해 주세요.');
            return false;
        }
    })



