<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- JSTL c태그 사용을 위한 taglib 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 프로젝트의 시작 주소를 간단히 얻어올 수 있도록 application scope로 contextPath라는 변수를 생성함--%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!-- header include -->
<jsp:include page="../adminCommon/admin_header.jsp"/>

<main>
    <session class="right">
    <h2 style="text-align: center;">회원 목록</h2>
    <div id="contents">
        <div >
                <div>
                    <input type="text" name="search" class="search" placeholder="이메일 입력">
                    <button type="button" class="ajaxBtn" onclick="memberList();">버튼</button>
                </div>
        </div>

        <table id="memberList" class="row-border cell-border" cellspacing="0" width="100%"  style="margin-top: 30px; background-color: white;" >
           	<thead style="font-size: 18px; margin-bottom: 10px; ">
				<tr style="border-bottom:1px solid grey;">
					<th>회원번호</th>
					<th>회원 상태</th>
					<th>닉네임</th>
					<th>이메일</th>
					<th>가입일</th>
					<th>탈퇴일</th>
				</tr>
			</thead>
				
	         <tbody style="text-align: center;margin-top: 30px; border-bottom:1px solid grey;">
<!-- 	            <tr>
	                <td>회원번호</td>
	                <td>회원 상태 </td>
	                <td>회원이름</td>
	                <td>회원이메일 </td>
	                <td>가입일 </td>
	            </tr> -->
	         </tbody>
        </table>
    </div>
    </session>
</main>
  
<jsp:include page="../adminCommon/admin_footer.jsp"/>

<script>
function memberList() {
	   $.ajax({
	        url : "${contextPath}/admin/member/list",
	        data : { "search" : $(".search").val()},
	        method : "POST",
	        dataType : "json",
	        
	        success : function (memberList) {
	         $("tbody").html("");
	            $.each(memberList, function (index, member) {
	               console.log(member);
	               const tr = $('<tr>');
	            const tdNo = $('<td>').text(member.memberNo);
	            const tdNm = $('<td>').text(member.memberNm);
	            const tdEmail = $('<td>').text(member.memberEmail);
	            const tdRegDt = $('<td>').text(member.memberRegDt);
	            const tdSecDt = $('<td>').text(member.memberSecDt);
	            const tdSt = $('<td>').text(member.memberSt);

	            tr.append(tdNo,tdSt, tdNm, tdEmail,tdRegDt,tdSecDt );
	               
	            $("tbody").append(tr);
	            });
	            

	        },
	        error : function (req, status, error) {
	            console.log("조회 실패");
	            console.log(req.responseText);
	       }
	    });
	}

</script>  
</body>
</html>