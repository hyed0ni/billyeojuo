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
                    <div class="contents_nickname">닉네임</div>
                </div>
            </div>
            
            <div class="my_detail">
                <div class="profile_area">
                    <div>
                        <img src="${contextPath}/resources/images/header/defaultUser.jpg">
                    </div>
                    <div class="profile_nickname">닉네임</div>
                    <div>
                    	<input type="button" class="input profile_change" value="프로필 사진 변경">
                    </div>
                </div>

                <div class="detail_area">
                    <form>
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
                                    <div>nickname juo<a href="#" style="padding:0 4px; height:22px; border:1px solid #656565; box-sizing:border-box; margin-left:20px;">변경하기</a></div>
                                    
                                </td>
                            </tr>
                            <tr>
                                <th class="table_th">이메일</th>
                                <td class="table_td">
                                    <div>stage107@naver.com</div>
                                    <a href="#" style="position:absolute; top:20px; right:0; padding:0 4px; height:22px; border:1px solid #704de4; box-sizing:border-box; color:#704de4">인증하기</a>
                                </td>
                            </tr>
                            <tr>
                                <th class="table_th">연락처</th>
                                <td class="table_td">
                                    <div>010-1234-1234<a href="#" style="padding:0 4px; height:22px; border:1px solid #656565; box-sizing:border-box; margin-left:20px;">변경하기</a></div>
                                    <a href="javascript:void(0);" class="yellow" style="position:absolute; top:20px; right:0; padding:0 4px; height:22px; float:right;">인증완료</a>
                                </td>
                            </tr>
                            <tr>
                                <th class="table_th">비밀번호</th>
                                <td class="table_td">
                                    <div><a href="#" style="padding:0 4px; height:22px; border:1px solid #656565; box-sizing:border-box;">변경하기</a></div>
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
                    </form>
                </div>
                <div class="secede">
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