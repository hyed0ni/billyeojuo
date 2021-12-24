<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- JSTL c태그 사용을 위한 taglib 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 프로젝트의 시작 주소를 간단히 얻어올 수 있도록 application scope로 contextPath라는 변수를 생성함--%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!-- header include -->
<jsp:include page="../common/header.jsp"/>





<main>
    <section class="my">
        <div class="title" style="letter-spacing:-.5px;">프로필 관리</div>
        <div class="my_area">
            <div class="contents">
                <div class="img_area">
                    <div>
                        <c:choose>
                            <c:when test="${empty sessionScope.loginMember.imgName}">
                                <img src="${contextPath}/resources/images/header/defaultUser.jpg" class="profile_image">
                            </c:when>
                            <c:otherwise>
                                <img src="${contextPath}${sessionScope.loginMember.imgPath}${sessionScope.loginMember.imgName}"
                                    class="profile_image">
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="contents_nickname">${sessionScope.loginMember.memberName}</div>
                </div>
            </div>
            
            <div class="my_detail">
                <div class="profile_area">
                    <div>
                       
                        
                        <c:choose>
                            <c:when test="${empty sessionScope.loginMember.imgName}">
                                <img src="${contextPath}/resources/images/header/defaultUser.jpg" class="profile_image">
                        </c:when>
                        <c:otherwise>
                            <img src="${contextPath}${sessionScope.loginMember.imgPath}${sessionScope.loginMember.imgName}" class="profile_image">
                        </c:otherwise>
                    </c:choose>
                    </div>
                    <div class="profile_nickname">${sessionScope.loginMember.memberName}</div>
                    <div>
                    	<a href="javascript:void(0)" class="input profile_change">프로필 사진 변경</a>
                        <input type="file" class="profile_file" name="profile_file" style="display: none;" onchange="changeImage(this)">
                    </div>
                </div>

                <div class="detail_area">
                    
                        <table class="detail_table">
                            <!-- <tr>
                                <th style="width:120px; text-align:left; vertical-align:top; padding:20px 0;">닉네임</th>
                                <td style="vertical-align:top; padding:20px 0; position:relative;">
                                    <div>nickname juo</div>
                                    <div>변경하기</div>
                                </td>
                            </tr> -->
                            <tr>
                                <th class="table_th">닉네임</th>
                                <td class="table_td">
                                
                                    <div class="change_nickname_wrap"><span>${sessionScope.loginMember.memberName}</span><a href="javascript:void(0)" style="padding:0 4px; height:22px; border:1px solid #656565; box-sizing:border-box; margin-left:20px;" class="change_nickname">변경하기</a></div>
                                    
                                    <div class="change_nickname_wrap_2" style="display: none;">
                                        <!-- <form action="${contextPath}/my" method="post" enctype="multipart/form-data" type="submit"> -->
                                            <input type="text" class="nickname" name="inputName">
                                            <button type="submit" style="padding:0 4px; height:22px; border:1px solid #656565; box-sizing:border-box; margin-left:20px;" class="name_change_confirm">확인</button>
                                                
                                            <a href="javascript:void(0)" style="padding:0 4px; height:22px; border:1px solid #656565; box-sizing:border-box; margin-left:20px;" class="name_change_cancle">취소하기</a>
                                            <!-- </form> -->
                                            </div>
                                    
                                </td>
                            </tr>
                            <tr>
                                <th class="table_th">이메일</th>
                                <td class="table_td">
                                    <div>${sessionScope.loginMember.memberEmail}</div>
                                    <c:choose>
                                        <c:when test="${sessionScope.loginMember.certify == 0}">
                                        <form action="${contextPath}/member/sendEmail2" method="get">
                                        <button type="submit" style="position:absolute; top:20px; right:0; padding:0 4px; height:22px; border:1px solid #704de4; box-sizing:border-box; color:#704de4" class="certify">인증하기</button>
                                        </form>
                                    </c:when>
                                    <c:otherwise>
                                        <span style="position:absolute; top:20px; right:0; padding:0 4px; height:22px; border:1px solid #704de4; box-sizing:border-box; color:#704de4" class="#">인증완료</span>
                                    </c:otherwise>
                                    </c:choose>    
                                </td>
                            </tr>
                            <tr>
                                <th class="table_th">연락처</th>
                                <td class="table_td">
                                    <div class="change_phone_wrap"><span>${sessionScope.loginMember.memberPhone}</span><a href="javascript:void(0)" style="padding:0 4px; height:22px; border:1px solid #656565; box-sizing:border-box; margin-left:20px;" class="change_phone">변경하기</a></div>
                                    <a href="javascript:void(0);" class="yellow" style="position:absolute; top:20px; right:0; padding:0 4px; height:22px; float:right;">인증완료</a>
                                    <div class="change_phone_wrap_2" style="display: none;">
                                        <!-- <form action="${contextPath}/my" method="post" enctype="multipart/form-data" type="submit"> -->
                                            <input type="text" class="phone" name="inputPhone" placeholder=" '-' 를 포함 해주세요.">
                                                <button type="submit" style="padding:0 4px; height:22px; border:1px solid #656565; box-sizing:border-box; margin-left:20px;" class="ph_change_confirm">확인</button>
                                                
                                                <a href="javascript:void(0)" style="padding:0 4px; height:22px; border:1px solid #656565; box-sizing:border-box; margin-left:20px;" class="ph_change_cancle">취소하기</a>
                                            <!-- </form> -->
                                            </div>
                                
                                </td>
                            </tr>
                            <tr>
                                <th class="table_th">비밀번호</th>
                                <td class="table_td">
                                    <div class="change_pwd_wrap"><a href="#" style="padding:0 4px; height:22px; border:1px solid #656565; box-sizing:border-box;" class="change_pwd">변경하기</a></div>
                                    <div class="change_pwd_wrap_2" style="display: none; " >
                                       <!--  <form action="${contextPath}/my" method="post" enctype="multipart/form-data" type="submit"> -->
                                        <input type="password" class="prePwd1" name="prePwd1" placeholder="현재 비밀번호" style="margin: 10px;"> <br>
                                        <input type="password" class="newPwd1" name="newPwd1" placeholder="변경할 비밀번호" style="margin: 10px;"> <br>
                                        <input type="password" class="newPwd2" name="newPwd2" placeholder="비밀번호 확인" style="margin: 10px;">
                                        <button type="submit" style="padding:0 4px; height:22px; border:1px solid #656565; left:20px;" class="pwd_change_confirm">확인</button>
                                        <a href="javascript:void(0)" style="padding:0 4px; height:22px; border:1px solid #656565; box-sizing:border-box; margin-left:20px;" class="pwd_change_cancle">취소하기</a>
                                    <!-- </form> -->
                                    </div>
                                </td>
                            </tr>
                            
                        </table>
                    
                </div>
                <form method="POST" action="member/secession" onsubmit="return secessionValidate();">
                <div class="secede" style="text-align: center;">
                    <button class="btn btn-primary btn-lg btn-block" id="btn"
						type="submit">서비스 탈퇴하기</button>
                </div>
                </form>
            </div>
        </div>
    </section>
</main>


<script>



$(document).on('click', '.change_nickname', function() {

    $('.change_nickname_wrap_2').show();
    $('.change_nickname_wrap').hide();
	
});

$(document).on('click', '.name_change_cancle', function() {

    $('.change_nickname_wrap_2').hide();
    $('.change_nickname_wrap').show();

});

$(document).on('click', '.change_phone', function() {

    $('.change_phone_wrap_2').show();
    $('.change_phone_wrap').hide();
	
});

$(document).on('click', '.ph_change_cancle', function() {

    $('.change_phone_wrap_2').hide();
    $('.change_phone_wrap').show();

});

$(document).on('click', '.change_pwd', function() {

    $('.change_pwd_wrap_2').show();
    $('.change_pwd_wrap').hide();
	
});

$(document).on('click', '.pwd_change_cancle', function() {

    $('.change_pwd_wrap_2').hide();
    $('.change_pwd_wrap').show();

});

$(document).on('click', '.name_change_confirm', function(){

    const inputNickname = $(this).prev().val(); 
	const regExp = /^[가-힣ㄱ-ㅎa-zA-Z0-9._-]{2,}\$/;

	if (inputNickname == '') {
		alert("닉네임을 입력해 주세요.");
		return false;
	}

    if (!regExp.test(inputNickname)) {
		alert("유효하지 않은 닉네임입니다.");
		return false;
	}

    $.ajax({

        url: 'my',
        data: {
            nickName: inputNickname
        },
        dataType: 'json',
        type: 'post',
        error: function() {
            alert('인터넷 연결이 원활하지 않습니다.');
        },
        success: function(data) {

            if(data.result == 1) {
                alert('닉네임 변경되었습니다.');
                $(".change_nickname_wrap_2").hide();
                $(".change_nickname_wrap").show();
                $(".change_nickname_wrap").children('span').text(inputNickname);
                $(".contents_nickname").text(inputNickname);
                $(".profile_nickname").text(inputNickname);
                $(".profile_txt .nickname").children().text(inputNickname);


            }else {
                alert('일시적인 오류가 발생했습니다.');
                return false;
            }
        }

    })

});

// 이메일 인증
 $(document).on('click', '.certify', function(){

    alert("이메일을 전송했습니다.")



 });


$(document).on('click ', '.ph_change_confirm', function(){

    const inputphone = $(this).prev().val();
    const regExp = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;

    console.log(inputphone);
    
    if(inputphone == ''){
        alert("전화번호를 입력해주세요.");
    }

    if(!regExp.test(inputphone)){
        alert("유효하지 않는 전화번호 입니다.");
        return false;
    }

    $.ajax({

        url: 'my',
        data: {
            inputPhone: inputphone
        },
        dataType: 'json',
        type: 'post',
        error: function() {
            alert('error');
        },
        success: function(data) {

            if(data.result == 1) {
                alert('전화번호가 변경되었습니다.');
                $(".change_phone_wrap_2").hide();
                $(".change_phone_wrap").show();
                $(".change_phone_wrap").children('span').text(inputphone);
            

            }else {
                alert('error2');
                return false;
            }
        }

})


});

$(document).on('click', '.pwd_change_confirm', function(){

    const prepassword = $('.prePwd1');
    const newPwd1 = $(".newPwd1");
    const newPwd2 = $(".newPwd2");


    if(prepassword.val().trim().length == 0){
        alert("현재 비밀번호를 입력해주세요.");
        prepassword.focus();
        return false;
    }

    if(newPwd1.val().trim().length == 0){
        alert("새 비밀번호를 입력해주세요.");
        newPwd1.focus();
        return false;
    }
    
    if(newPwd2.val().trim().length == 0){
        alert("새 비밀번호 확인을 입력해주세요.");
        newPwd2.focus();
        return false;
    }
    
    if(newPwd1.val() != newPwd2.val()) {
    	alert("새 비밀번호와 새 비밀번호 확인이 일치하지 않습니다.");
        return false;
    }

    
    // 현재 비밀번호(데이터) == 입력한 비밀번호
    $.ajax({

        url: "my",
        type: "POST",
        data: { "prepassword": prepassword.val(), "newPwd1" : newPwd1.val() },
        dataType : "JSON",
        success: function(data) {
        
            if (data.result == 0) {
               alert("비밀번호가 틀립니다.");
               password.focus();
               return false;
                
            } else {
                
               alert("비밀번호가 변경되었습니다.");
               $(".change_pwd_wrap_2").hide();
                $(".change_pwd_wrap").show();
               

            }
        },
        error: function(request, status, error) {
            
            if (request.status == 404) {
                console.log("ajax 요청주소가 올바르지 않습니다.");
            } else if (request.status == 500) {
                console.log("서버 내부 에러");
                console.log(request.responseText);
            }
        }

    });



});

$(document).on('click', '.profile_change', function() {

    $('.profile_file').click();

})

function changeImage(input) {

    var reader = new FileReader();
    var file = input.files[0];
    reader.onload = function(e) {
        $('.profile_image').attr('src', e.target.result); 
    }
    reader.readAsDataURL(file);


    var form = new FormData();

    form.append("mode", "change_profile");
    form.append("profile_image", file);
    
        $.ajax({
            url : "profile",
            type : "POST",
            processData : false,
            contentType : false,
            data : form,
            dataType : "JSON",
            success:function(data) {
                
                if(data.result > 0) {
                    alert("프로필사진을 변경했습니다.");
                }else {
                    alert("일시적인 오류가 발생했습니다.");
                    return false;
                }
                
            }
            ,error: function( request , status , error){
                alert("인터넷 연결이 원활하지 않습니다.");
           },
    });

    console.log(file.name);


}

// 회원탈퇴
function secessionValidate() {

    return confirm("정말로 탈퇴하시겠습니까?");

}

$(".switch_btn").on("click", function () {
    if ($(".switch_btn .tag").hasClass("active")) {
        $(".switch_btn .tag").removeClass("active");
    } else {
        $(".switch_btn .tag").addClass("active");
    }
});

</script>

<!-- footer include -->
<jsp:include page="../common/footer.jsp"/>
</body>
</html>