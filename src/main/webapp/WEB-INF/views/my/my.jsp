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
                        <img src="${contextPath}/resources/images/header/defaultUser.jpg">
                    </div>
                    <div class="contents_nickname">${sessionScope.loginMember.memberName}</div>
                </div>
            </div>
            
            <div class="my_detail">
                <div class="profile_area">
                    <div>
                        <c:choose>
                            <c:when test="${sessionScope.loginMember.imgPath} == null">
                                <img src="${contextPath}/resources/images/header/defaultUser.jpg" class="profile_image">
                        </c:when>
                        <c:otherwise>
                            <img src="${contextPath}${sessionScope.loginMember.imgPath}${sessionScope.loginMember.imgName}" class="profile_image">
                        </c:otherwise>
                    </c:choose>
                    </div>
                    <div class="profile_nickname">${sessionScope.loginMember.imgPath}</div>
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
                                
                                    <div class="change_nickname_wrap">${sessionScope.loginMember.memberName}<a href="javascript:void(0)" style="padding:0 4px; height:22px; border:1px solid #656565; box-sizing:border-box; margin-left:20px;" class="change_nickname">변경하기</a></div>
                                    
                                    <div class="change_nickname_wrap_2" style="display: none;">
                                        <form action="${contextPath}/my" method="post" type="submit">
                                            <input type="text" class="nickname" name="inputName">
                                                <button type="submit" style="padding:0 4px; height:22px; border:1px solid #656565; box-sizing:border-box; margin-left:20px;" class="name_change_confirm">확인</button>
                                                
                                                <a href="javascript:void(0)" style="padding:0 4px; height:22px; border:1px solid #656565; box-sizing:border-box; margin-left:20px;" class="name_change_cancle">취소하기</a>
                                            </form>
                                            </div>
                                    
                                </td>
                            </tr>
                            <tr>
                                <th class="table_th">이메일</th>
                                <td class="table_td">
                                    <div>${sessionScope.loginMember.memberEmail}</div>
                                    <a href="#" style="position:absolute; top:20px; right:0; padding:0 4px; height:22px; border:1px solid #704de4; box-sizing:border-box; color:#704de4">인증하기</a>
                                </td>
                            </tr>
                            <tr>
                                <th class="table_th">연락처</th>
                                <td class="table_td">
                                    <div class="change_phone_wrap">${sessionScope.loginMember.memberPhone}<a href="javascript:void(0)" style="padding:0 4px; height:22px; border:1px solid #656565; box-sizing:border-box; margin-left:20px;" class="change_phone">변경하기</a></div>
                                    <a href="javascript:void(0);" class="yellow" style="position:absolute; top:20px; right:0; padding:0 4px; height:22px; float:right;">인증완료</a>
                                    <div class="change_phone_wrap_2" style="display: none;">
                                        <form action="${contextPath}/my" method="post" type="submit">
                                            <input type="text" class="phone" name="inputPhone">
                                                <button type="submit" style="padding:0 4px; height:22px; border:1px solid #656565; box-sizing:border-box; margin-left:20px;" class="ph_change_confirm">확인</button>
                                                
                                                <a href="javascript:void(0)" style="padding:0 4px; height:22px; border:1px solid #656565; box-sizing:border-box; margin-left:20px;" class="ph_change_cancle">취소하기</a>
                                            </form>
                                            </div>
                                
                                </td>
                            </tr>
                            <tr>
                                <th class="table_th">비밀번호</th>
                                <td class="table_td">
                                    <div class="change_pwd_wrap"><a href="#" style="padding:0 4px; height:22px; border:1px solid #656565; box-sizing:border-box;" class="change_pwd">변경하기</a></div>
                                    <div class="change_pwd_wrap_2" style="display: none; " >
                                        <form action="${contextPath}/my" method="post" type="submit">
                                        <input type="password" class="prePwd1" name="prePwd1" placeholder="현재 비밀번호" style="margin: 10px;"> <br>
                                        <input type="password" class="newPwd1" name="newPwd1" placeholder="변경할 비밀번호" style="margin: 10px;"> <br>
                                        <input type="password" class="newPwd2" name="newPwd2" placeholder="비밀번호 확인" style="margin: 10px;">
                                        <button type="submit" style="padding:0 4px; height:22px; border:1px solid #656565; left:20px;" class="pwd_change_confirm">확인</button>
                                        <a href="javascript:void(0)" style="padding:0 4px; height:22px; border:1px solid #656565; box-sizing:border-box; margin-left:20px;" class="pwd_change_cancle">취소하기</a>
                                    </form>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <th class="table_th">마케팅 수신동의</th>
                                <td class="table_td switch_area">
                                    <div>이메일 동의</div>
                                    <div class="switch_btn">
                                        <a href="javascript:void(0);" class="tag"></a>
                                    </div>
                                </td>
                            </tr>
                        </table>
                    
                </div>
                <div class="secede">
                    <a href="#">서비스 탈퇴하기</a>
                </div>
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
		alert("닉네임을 입력해주세요.");
		return false;
	}

    if (!regExp.test(inputNickname)) {
		alert("유효하지 않은 닉네임입니다.");
		return false;
	}

});

$(document).on('click ', '.ph_change_confirm', function(){

    const inputphone = $(this).pre().val;
    const regExp = /^[a-z0-9]{3,16]$/
    
    if(inputphone == ''){
        alert("전화번호를 입력해주세요.");
    }

    if(!regExp.test(inputphone)){
        alert("유효하지 않는 닉네임 입니다.");
    }


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
        success: function(result) {
        	cosole.log(result);
        
            if (result == 0) {
               alert("비밀번호가 틀립니다.");
               password.focus();
               return false;
                
            } else {
                
               alert("비밀번호가 맞습니다.");
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
            url : "my",
            type : "POST",
            processData : false,
            contentType : false,
            data : form,
            dataType : "JSON",
            success:function(response) {
                
                if(response.result == 1) {
                    alert(response.message);
                }else {
                    alert(response.message);
                    return false;
                }
                
            }
            ,error: function (jqXHR) 
            { 
                alert("실패햇습니다."); 
            }
    });

    console.log(file.name);


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