<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%-- JSTL c태그 사용을 위한 taglib 추가 --%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

            <%-- 프로젝트의 시작 주소를 간단히 얻어올 수 있도록 application scope로 contextPath라는 변수를 생성함--%>
                <c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

                <!-- header include -->
                <jsp:include page="../common/header.jsp" />
                <script src="https://code.jquery.com/jquery-3.6.0.min.js"
                    integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

                <main>
                    <div id="contents">
                        <div class="box">
                            <div class="top-title-wrap">
                                <h2 class="title">이메일 인증</h2>
                            </div>
                            <form action="${contextPath}/member/certify" method="post">
                                <input type="hidden" name="email" value="${param.email}">
                                <div class="login-box">
                                    <div class="login-input-wrap" style="margin-bottom: 20px;"><span
                                            style="display: block; padding-bottom: 10px;">비밀번호 입력</span>
                                        <input type="text" placeholder="" class="login-input" name="certifyPwd"
                                            id="certifyPwd" style="margin-bottom: 10px;">
                                        <span id="checkPwd1"></span>
                                    </div>

                                    <button type="submit" class="login-btn certify-btn">이메일 인증</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </main>

                <jsp:include page="../common/footer.jsp" />
                    <script>

                        $(document).on('click', 'certify-btn', function(){

                            alert("이메일 인증이 완료되었습니다.");
                        });


                    </script>

                </body>

                </html>