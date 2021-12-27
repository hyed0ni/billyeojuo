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

                            <input type="hidden" name="email" value="${param.email}">
                            <div class="login-box">
                                <div class="login-input-wrap" style="margin-bottom: 20px;"><span
                                        style="display: block; padding-bottom: 10px;">비밀번호 입력</span>
                                    <input type="password" placeholder="" class="login-input" name="certifyPwd"
                                        id="certifyPwd" style="margin-bottom: 10px;">
                                    <span id="checkPwd1"></span>
                                </div>

                                <button type="submit" class="login-btn certify-btn">이메일 인증</button>
                            </div>
                        </div>
                    </div>
                </main>

                <jsp:include page="../common/footer.jsp" />
                    <script>

                        $(document).on('click', '.certify-btn', function(){

                                                        
                            var certifyPwd = $("#certifyPwd").val();
                            var email = $("input[name=email]").val();

            
                            if (certifyPwd.trim().length == 0) {
                                alert("비밀번호를 입력해 주세요.");
                                return false;
                            }

                            $.ajax({

                                url : "certify",
                                data : {"certifyPwd" : certifyPwd, "email": email},
                                type : "post",
                                dataType : "json",
                                success : function(data){
                                    
                                    if(data.result == 0) {
                                        alert('비밀번호가 일치하지 않습니다.');
                                        return false;
                                    }else if(data.result == 1) {
                                        alert('이메일 인증이 완료되었습니다.');
                                        location.href = '${contextPath}';
                                    }else {
                                        alert('일시적인 오류가 발생했습니다.');
                                        return false;
                                    }

                                },
                                error: function() {
                                    alert("인터넷 연결이 원활하지 않습니다.");
                                }

                            });

                        });


                    </script>

                </body>

                </html>