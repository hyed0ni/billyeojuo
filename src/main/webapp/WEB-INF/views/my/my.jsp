<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- JSTL c태그 사용을 위한 taglib 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 프로젝트의 시작 주소를 간단히 얻어올 수 있도록 application scope로 contextPath라는 변수를 생성함--%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!-- header include -->
<jsp:include page="../common/header.jsp"/>

<main>
    <section class="my" style="width:980px; margin:auto;">
        <div class="title" style="letter-spacing:-.5px;">프로필 관리</div>
        <div class="my_area">
            <div style="width:300px; display:inline-block; background-color:#fff; text-align:center; position:relative; vertical-align:top;">
                <div style="padding:20px;">
                    <div>
                        <img src="${contextPath}/resources/images/header/defaultUser.jpg" style="width:150px; height:150px; margin:10px;">
                    </div>
                    <div style="font-weight:bold; height:30px; line-height:28px; margin-bottom:30px; padding:10px; border-bottom:1px solid #ccc;">닉네임</div>
                </div>
            </div>
            
            <div style="background-color: bisque; width:610px; padding:20px; display:inline-block; background-color:#fff; position:relative; margin-left:24px;">
                <div style="text-align:center; margin-bottom:30px;">
                    <div>
                        <img src="${contextPath}/resources/images/header/defaultUser.jpg" style="width:100px; height:100px; margin:10px;">
                    </div>
                    <div style="font-weight:bold; height:30px; line-height:28px;">닉네임</div>
                    <div><input type="button" class="input" value="프로필 사진 변경" style="color:#656565; font-size:12px; height:26px; padding:0 10px;">
                    </div>
                </div>

                <div style="border-top:1px solid #ccc; border-bottom:1px solid #ccc; padding:20px 0; margin-bottom:30px;">
                    <form>
                        <table style="width:100%; font-size:14px;">
                            <!-- <tr>
                                <th style="width:120px; text-align:left; vertical-align:top; padding:20px 0;">닉네임</th>
                                <td style="vertical-align:top; padding:20px 0; position:relative;">
                                    <div>nickname juo</div>
                                    <div>변경하기</div>
                                </td>
                            </tr> -->
                            <tr>
                                <th style="width:120px; text-align:left; vertical-align:top; padding:20px 0;">닉네임</th>
                                <td style="vertical-align:top; padding:20px 0; position:relative;">
                                    <div>nickname juo<a href="#" style="padding:0 4px; height:22px; border:1px solid #656565; box-sizing:border-box; margin-left:20px;">변경하기</a></div>
                                    
                                </td>
                            </tr>
                            <tr>
                                <th style="width:120px; text-align:left; vertical-align:top; padding:20px 0;">이메일</th>
                                <td style="vertical-align:top; padding:20px 0; position:relative;">
                                    <div>stage107@naver.com</div>
                                    <a href="#" style="position:absolute; top:20px; right:0; padding:0 4px; height:22px; border:1px solid #704de4; box-sizing:border-box; color:#704de4">인증하기</a>
                                </td>
                            </tr>
                            <tr>
                                <th style="width:120px; text-align:left; vertical-align:top; padding:20px 0;">연락처</th>
                                <td style="vertical-align:top; padding:20px 0; position:relative;">
                                    <div>010-1234-1234<a href="#" style="padding:0 4px; height:22px; border:1px solid #656565; box-sizing:border-box; margin-left:20px;">변경하기</a></div>
                                    <a href="javascript:void(0);" class="yellow" style="position:absolute; top:20px; right:0; padding:0 4px; height:22px; float:right;">인증완료</a>
                                </td>
                            </tr>
                            <tr>
                                <th style="width:120px; text-align:left; vertical-align:top; padding:20px 0;">비밀번호</th>
                                <td style="vertical-align:top; padding:20px 0; position:relative;">
                                    <div><a href="#" style="padding:0 4px; height:22px; border:1px solid #656565; box-sizing:border-box;">변경하기</a></div>
                                </td>
                            </tr>
                            <tr>
                                <th style="width:120px; text-align:left; vertical-align:top; padding:20px 0;">마케팅 수신동의</th>
                                <td style="vertical-align:top; padding:20px 0; position:relative;" class="switch_area">
                                    <div>이메일</div>
                                    <div class="switch_btn" style="position:absolute; z-index:3; top:20px; right:0; padding:0 4px; width:40px; border-radius:25px; background-color:#ebebeb; height:22px; border:1px solid #ebebeb; box-sizing:border-box; cursor:pointer;">
                                        <a href="javascript:void(0);" class="tag"></a>
                                    </div>
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>
                <div style="text-align:center;">
                    <a href="#">서비스 탈퇴하기</a>
                </div>
            </div>
        </div>
    </section>
</main>

<!-- footer include -->
<jsp:include page="../common/footer.jsp"/>
<script>
    $(".switch_btn").on("click", function () {
        if ($(".switch_btn .tag").hasClass("active")) {
            $(".switch_btn .tag").removeClass("active");
        } else {
            $(".switch_btn .tag").addClass("active");
        }
    })
</script>