<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- JSTL c태그 사용을 위한 taglib 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 프로젝트의 시작 주소를 간단히 얻어올 수 있도록 application scope로 contextPath라는 변수를 생성함--%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!-- header include -->
<jsp:include page="../common/header.jsp"/>

<main>
  <section class="promotion-main">
    <div>
    <h1 style="font-size: 36px; line-height: 40px; margin-top: 110px;">"최애 직관은 못 참아!" <br> 안방 1열 온라인 콘서트 공간"</h1>
    <p style="font-size: 18px;">노잼도시를 구하라 WEEK4</p>
    <a href="#">지도로 보기</a>
    </div>
    <div class="promotoin-main-img" style="background-image: url('${contextPath}/resources/images/main_body/promotion_pic_03.png');"></div>
  </section>

  <section class="space"></section>

  <section ion id="promotion-wrapper">

  <article  class="promotion-space-list">
    <a href="#">
      <div class="img-box">
      </div>
      <div class="info-box">
          <h3>[강남, 신사, 압구정] 바나나홀</h3>
        <div class="tag-box">
          <span class="location">소하동 </span> <span> |</span>
          <span class="tag">#스튜디오대여</span>
          <span class="tag">#셀프스튜디오</span>
          <span class="tag">#쇼핑몰촬영</span>
        </div>
        <div class="price-box">
          <strong class="price purple">10,000</strong> <span>원/패키지</span>
            <div class="like-comment">
              <span class="pricebox-icon icon-comment"></span>
              <span>최대3인</span>
              <span class="pricebox-icon icon-people"></span>
              <span>0</span>
              <span class="pricebox-icon icon-like"></span>
              <span>6</span>
            </div>
        </div>
      </div>
    </a>
  </article>

  <article  class="promotion-space-list">
    <a href="#">
      <div class="img-box">
        <span style="background-image: url('${contextPath}/resources/images/main_body/recommend_img_01.jpeg');"></span>
      </div>
      <div class="info-box">
          <h3>육공스튜디오(60Studio)</h3>
        <div class="tag-box">
          <span class="location">소하동 </span> <span> |</span>
          <span class="tag">#스튜디오대여</span>
          <span class="tag">#셀프스튜디오</span>
          <span class="tag">#쇼핑몰촬영</span>
        </div>
        <div class="price-box">
          <strong class="price purple">10,000</strong> <span>원/패키지</span>
            <div class="like-comment">
              <span class="pricebox-icon icon-comment"></span>
              <span>최대3인</span>
              <span class="pricebox-icon icon-people"></span>
              <span>0</span>
              <span class="pricebox-icon icon-like"></span>
              <span>6</span>
            </div>
        </div>
      </div>
    </a>
  </article>

  <article  class="promotion-space-list">
    <a href="#">
      <div class="img-box">
        <span></span>
      </div>
      <div class="info-box">
          <h3>육공스튜디오(60Studio)</h3>
        <div class="tag-box">
          <span class="location">소하동 </span> <span> |</span>
          <span class="tag">#스튜디오대여</span>
          <span class="tag">#셀프스튜디오</span>
          <span class="tag">#쇼핑몰촬영</span>
        </div>
        <div class="price-box">
          <strong class="price purple">10,000</strong> <span>원/패키지</span>
            <div class="like-comment">
              <span class="pricebox-icon icon-comment"></span>
              <span>최대3인</span>
              <span class="pricebox-icon icon-people"></span>
              <span>0</span>
              <span class="pricebox-icon icon-like"></span>
              <span>6</span>
            </div>
        </div>
      </div>
    </a>
  </article>

  
  <article  class="promotion-space-list">
    <a href="#">
      <div class="img-box">
        <span></span>
      </div>
      <div class="info-box">
          <h3>육공스튜디오(60Studio)</h3>
        <div class="tag-box">
          <span class="location">소하동 </span> <span> |</span>
          <span class="tag">#스튜디오대여</span>
          <span class="tag">#셀프스튜디오</span>
          <span class="tag">#쇼핑몰촬영</span>
        </div>
        <div class="price-box">
          <strong class="price purple">10,000</strong> <span>원/패키지</span>
            <div class="like-comment">
              <span class="pricebox-icon icon-comment"></span>
              <span>최대3인</span>
              <span class="pricebox-icon icon-people"></span>
              <span>0</span>
              <span class="pricebox-icon icon-like"></span>
              <span>6</span>
            </div>
        </div>
      </div>
    </a>
  </article>

  <article  class="promotion-space-list">
    <a href="#">
      <div class="img-box">
        <span></span>
      </div>
      <div class="info-box">
          <h3>육공스튜디오(60Studio)</h3>
        <div class="tag-box">
          <span class="location">소하동 </span> <span> |</span>
          <span class="tag">#스튜디오대여</span>
          <span class="tag">#셀프스튜디오</span>
          <span class="tag">#쇼핑몰촬영</span>
        </div>
        <div class="price-box">
          <strong class="price purple">10,000</strong> <span>원/패키지</span>
            <div class="like-comment">
              <span class="pricebox-icon icon-comment"></span>
              <span>최대3인</span>
              <span class="pricebox-icon icon-people"></span>
              <span>0</span>
              <span class="pricebox-icon icon-like"></span>
              <span>6</span>
            </div>
        </div>
      </div>
    </a>
  </article>

  <article  class="promotion-space-list">
    <a href="#">
      <div class="img-box">
        <span></span>
      </div>
      <div class="info-box">
          <h3>육공스튜디오(60Studio)</h3>
        <div class="tag-box">
          <span class="location">소하동 </span> <span> |</span>
          <span class="tag">#스튜디오대여</span>
          <span class="tag">#셀프스튜디오</span>
          <span class="tag">#쇼핑몰촬영</span>
        </div>
        <div class="price-box">
          <strong class="price purple">10,000</strong> <span>원/패키지</span>
            <div class="like-comment">
              <span class="pricebox-icon icon-comment"></span>
              <span>최대3인</span>
              <span class="pricebox-icon icon-people"></span>
              <span>0</span>
              <span class="pricebox-icon icon-like"></span>
              <span>6</span>
            </div>
        </div>
      </div>
    </a>
  </article>
  
  </section>

  <section class="space" style="height: 70px;"></section>
</main>

<!-- footer include -->
<jsp:include page="../common/footer.jsp"/>
