<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- JSTL c태그 사용을 위한 taglib 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 프로젝트의 시작 주소를 간단히 얻어올 수 있도록 application scope로 contextPath라는 변수를 생성함--%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!-- header include -->
<jsp:include page="../adminCommon/admin_header.jsp"/>
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/admin_register_roomtype.css">    

<main>
    <h1>회원 목록</h1>
    <div id="contents">
        <div style="margin-top: 24px;">
            <form>
                <div>
                    <input type="text" name="search" class="search">
                    <button type="button" class="ajaxBtn">버튼</button>
                </div>
            </form>
        </div>

        <table id="memberList" class="row-border cell-border" cellspacing="0" width="100%">
            <thead>
            <tr>
                <th>날짜</th>
                <th>결제수</th>
                <th>금액합계</th>
            </tr>
            </thead>
        </table>
    </div>
</main>
  
<jsp:include page="../adminCommon/admin_footer.jsp"/>

<script>
(function () {
        // $(document).on('change', '.groupBy', function() {
        //     location.href = "/statistics/eventProduct/" + $(this).val() + "?startDate=" + $('#startDate').val() + "&endDate=" + $('#endDate').val();
        // });

        $(".ajaxBtn").on("click", function () {
            console.log("${contextPath}/admin/member/list");
            memberTable.ajax.reload();
        })

        const memberTable = $.ajax({
            url : "${contextPath}/admin/member/list",
            method : "POST",
            data : {
                page : 1,
                search : $(".search").val()
            },
            success : function (result) {
                console.log(result);

                $.each(result, function (index, member) {
				
/*                     let spaceImg = "";
                    if (qna.spaceImgNm) {
                        spaceImg = `<img class="list_img" src="${contextPath}${qna.spaceImgPath}${qna.spaceImgNm}">`;
                    } else {
                        spaceImg = `<img class="list_img" src="${contextPath}/resources/images/defaultUser.jpg">`;
                    }
                    
                    html += `
                        <div class="list">
                            <div class="img_area">
                                ${spaceImg}
                            </div>
                            <div class="content_area">
                                <div class="title">${qna.queTitle}</div>
                                <div class="content">${qna.queContent}</div>
                                <div class="date">${qna.queDt}</div>
                            </div>
                        </div>
                    `;
 */                
                });
                

            },
            error : function (req, status, error) {
                console.log("조회 실패");
                console.log(req.responseText);
	    	}
        });

    }());

</script>  
</body>
</html>