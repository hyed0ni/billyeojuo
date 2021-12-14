<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- JSTL c태그 사용을 위한 taglib 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 프로젝트의 시작 주소를 간단히 얻어올 수 있도록 application scope로 contextPath라는 변수를 생성함--%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!-- header include -->
<jsp:include page="../common/header.jsp"/>

<main>
  <section class="space"></section>

  <section id="promotion-page">
    <h1>기획전</h1>
    <p>스클 MD가 큐레이션한 기획전 입니다</p>
    <section id="promotion-list">
      <div class="promotion-list-wrap">
        <article class="box-size">
          <div class="list-img" style="background-image: url('${contextPath}/resources/images/main_body/promotion_list_01.png')">
            <a href="">
              <h3>따뜻하고 특별한 <br> 프라이빗 데이트 공간</h3>
              <p>노잼도시를 구하라 WEEK5</p>
            </a>  
          </div>
        </article>

        <article class="box-size">
          <div class="list-img" style="background-image:url('${contextPath}/resources/images/main_body/promotion_pic_03')">
            <a href="">
              <h3>최애직관은 못참아!<br>안방1열 온라인 콘서트 공간</h3>
              <p>노잼도시를 구하라 WEEK4</p>
            </a>
          </div>
        </article>

        <article class="box-size">
          <div class="list-img" style="background-image:url('${contextPath}/resources/images/main_body/promotion_pic_02')">
            <a href="">
              <h3>댕댕이와 함께라면! <br>반려동물 동반 공간 기획전</h3>
              <p>노잼도시를 구하라 WEEK3</p>
            </a>  
          </div>
        </article>

        <article class="box-size">
          <div class="list-img" style="background-image:url('${contextPath}/resources/images/main_body/promotion_pic_01')">
            <a href="">
              <h3>원테이블 레스토랑은 이곳에,<br>오늘은 내가 일일 쉐프</h3>
              <p>노잼도시를 구하라 WEEK2</p>
            </a>  
          </div>
        </article>
        

        <article class="box-size">
          <div class="list-img" style="background-image:url('${contextPath}/resources/images/main_body/promotion_pic_05')">
            <a href="">
              <h3>연말에 추천하는 공간<br>BEST</h3>
              <p>2021 연말을 위한 공간</p>
            </a>  
          </div>
        </article>
        

        <article class="box-size">
          <div class="list-img" style="background-image:url('${contextPath}/resources/images/main_body/promotion_pic_06')">
            <a href="">
              <h3>내안에 부캐 만나기!<br>도심 속 이색 파티룸</h3>
              <p>노잼도시를 구하라 WEEK1</p>
            </a>  
          </div>
        </article>

      </div>
    </section>
  </section>

</main>

<!-- footer include -->
<jsp:include page="../common/footer.jsp"/>

