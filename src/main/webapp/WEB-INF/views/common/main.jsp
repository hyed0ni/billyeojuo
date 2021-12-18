<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- JSTL c태그 사용을 위한 taglib 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 프로젝트의 시작 주소를 간단히 얻어올 수 있도록 application scope로 contextPath라는 변수를 생성함--%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}" scope="application" />

<!-- header include -->
<jsp:include page="header.jsp"/>


<main>
    <section class="main-pic">
        <img src="${contextPath}/resources/images/main/mainpage_img.jpg">
    </section>

    <section id="icons">
    	<c:forEach items="${spaceTypeList}" var="spaceType">
	    	<a href="#" class="icon-a">
	            <img src="${contextPath}/resources/images/space_type/${spaceType.spaceTypeImg}.png" alt="">
	            <div class="main-icons-text">${spaceType.spaceTypeNm}</div>
	        </a>
    	</c:forEach>
    </section>

    <section class="space"></section>
    
    <section id="promotions">
        <h1 class="title">기획전</h1>
        <p style="margin-top: 0px; text-align: center;">지금 딱 내가 찾는 공간</p>
        <div class="promotion">
            <a href="#">
                <h3 class="promotion-title">원테이블 레스토랑은 이곳에,<br>오늘은 내가 일일 쉐프</h3><br>
                <p>노잼도시를 구하라</p>
            </a>

            <a href="#">
                <h3 class="promotion-title">원테이블 레스토랑은 이곳에,<br>오늘은 내가 일일 쉐프</h3><br>
                <p>노잼도시를 구하라</p>
            </a>

            <a href="#">
                <h3 class="promotion-title">원테이블 레스토랑은 이곳에,<br>오늘은 내가 일일 쉐프</h3><br>
                <p>노잼도시를 구하라</p>
            </a>

            <a href="#">
                <h3 class="promotion-title">원테이블 레스토랑은 이곳에,<br>오늘은 내가 일일 쉐프</h3><br>
                <p>노잼도시를 구하라</p>
            </a>

            <div class="more" >
                <a href="${contextPath}/promotion" >+ 더보기</a>
            </div>
        </div>
    </section>
    
    <section class="space"></section>

    <section id="recommends">
        <h1 class="title">추천공간</h1>
        <p style="margin-top: 0px; text-align: center;">지금 딱 내가 찾는 공간</p>
        <section>
            <article  class="recommend-item">
                <a href="#">
                    <div class="img-box">
                        <span></span>
                        <button type="button" class="button-left"></button>
                        <button type="button" class="button-right"></button>
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
            <article  class="recommend-item">
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
            <article  class="recommend-item">
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
            <article  class="recommend-item">
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
            <article  class="recommend-item">
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
            <article  class="recommend-item">
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
            <article  class="recommend-item">
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
    </section>

    <section class="space"></section>
    <section class="space"></section>
</main>

<!-- footer include -->
<jsp:include page="footer.jsp"/>