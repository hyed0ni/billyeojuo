
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="../common/header.jsp"/>
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/space-style.css">
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/jquery-ui.css">
<style>
.ui-widget.ui-widget-content{width:100%;}
</style>

<main>
    <section class="cont detail-forms">
    
        <!--------------------------------------------------------------------------------------------------------------------------->

        <section style="margin-top:120px;">
            <div class="space">
            
            	<!-- 공간 이름 -->
                <h2 class="space-name">${space.spaceNm}</h2>
            </div>

            <!-- 공간 부제 -->
            <p class="sub-desc">${space.spaceSubNm}</p>
        </section>
        <section class="detail-forms">
            <!-- height:400px;  -->

            <div class="photo-box-wrap">

                <!-- 공간 이미지 -->
                <div class="detail-box">
                    <div class="space-img" style="background-image:url('${contextPath}${spaceImg.spaceImgPath}${spaceImg.spaceImgNm}')"></div>
                </div>

                <!-- 부제-2 영역 -->
                <div class="text-box">
                    <h3 class="h-copy">${space.spaceSubNm}</h3>
                </div>

                <!-- 메뉴 탭 영역 -->
                <div class="nav-wrapper" style="background-color: white">
                    <ul class="nav-area">
                        <li><a title="s-intro">공간소개</a></li>
                        <li><a title="s-info">시설안내</a></li>
                        <li><a title="s-cautoion">유의사항</a></li>
                        <li><a title="s-refund">환불정책</a></li>
                        <li><a title="s-qna">Q&A</a></li>
                        <li><a title="s-review">이용후기</a></li>
                    </ul>
                </div>
            </div>

            <!-- 공간소개, 시설안내, 유의사항, Q&A, 이용후기 작성 부분  -->
            <div class="meetspace">

                <!-- 공간소개 -->
                <div id="s-intro" class="text-box">
                    <h4 class="h-intro">공간 소개</h4>

                    <p class="p-intro">${space.spaceIntro}</p>

                    <ul class="info-list officehours">
                        <li>
                            <span class="tit">영업시간</span>
                            <span class="data">${space.spaceTime}</span>
                        </li>
                        <li>
                            <span class="tit">휴무일</span>
                            <span class="data">${space.spaceClosedDt}</span>
                        </li>
                    </ul>
                </div>

                <!-- 시설안내 -->
                <div id="s-info" class="text-box">
                    <h4 class="h-intro">시설 안내</h4>

					<!-- spaceGuide 문자열을 <br>태그를 기준으로 배열로 쪼갬 -->
                  	<c:set var="temp" value="${fn:replace(space.spaceGuide, '<br>', '|')}"/>
					<c:set var="arr" value="${fn:split(temp, '|')}"/>
					
                    <ol class="info-list">
                    	<c:forEach items="${arr}" var="guide" varStatus="vs">
	                    	<li>
	                            <strong class="tit">${vs.count}</strong>
	                            <span class="data">${guide}</span>
	                        </li>
                    	</c:forEach>
                    </ol>
                </div>

                <!-- 유의사항 -->
                <div id="s-cautoion" class="text-box">
                    <h4 class="h-intro">예약 주의사항</h4>

					<c:set var="temp" value="${fn:replace(space.precautions, '<br>', '|')}"/>
					<c:set var="arr" value="${fn:split(temp, '|')}"/> 
					
                    <ol class="info-list">
                    	<c:forEach items="${arr}" var="precautions" varStatus="vs">
	                    	<li>
	                            <strong class="tit">${vs.count}</strong>
	                            <span class="data">${precautions}</span>
	                        </li>
                    	</c:forEach>
                    </ol>
                </div>

                <!-- 환불규정 안내 -->
                <div id="s-refund" class="text-box">
                    <h4 class="h-intro">환불규정 안내</h4>

                    <p class="txt-notice refund">
                        <em class="warn">
                            이용당일(첫 날) 이후에 환불 관련 사항은 호스트에게 직접 문의하셔야 합니다.
                        </em>
                        <br>
                        결제 후 2시간 이내에는 100% 환불이 가능합니다.(단,이용시간 전까지만 가능)
                    </p>
                    
                    <c:set var="temp" value="${fn:replace(space.refundPolicy, '<br>', '|')}"/>
					<c:set var="arr" value="${fn:split(temp, '|')}"/> 
                    
                    <ol class="info-list">
                    	<c:forEach items="${arr}" var="refund" varStatus="vs">
	                    	<li>
	                    		<c:choose>
	                    			<c:when test="${vs.last}">
	                    				<strong class="tit">이용 당일</strong>
	                    				<span class="data">${refund}</span>
	                    			</c:when>
	                    			
	                    			<c:when test="${(fn:length(arr) - vs.count) == 1}">
	                    				<strong class="tit">이용 전날</strong>
	                    				<span class="data">${refund}</span>
	                    			</c:when>
	                    			
	                    			<c:otherwise>
	                    				<strong class="tit">이용 ${fn:length(arr) - vs.count}일전</strong>
	                    				<span class="data">${refund}</span>
	                    			</c:otherwise>
	                    		</c:choose>
	                        </li>
                    	</c:forEach>
                    </ol>
                </div>

                <!-- 지도 영역 -->
                <div class="detail-box map-box">

                    <div class="host-profile">
                        <div class="inner">
                            <div class="sp-location">
                                <p class="sp-name">${space.spaceNm}</p>
                                <p class="sp-address">${space.spaceAddr}</p>
                                <p class="sp-phone">${space.spacePno}</p>
                            </div>
<!--                             <div class="row">
                                <div class="col">
                                    <a class="btn btn-rounded btn-call">
                                        <span class="btn_inner">전화걸기</span>
                                    </a>
                                </div>
                                <div class="col">
                                    <a href="#" target="_blank" class="btn btn-rounded btn-way">
                                        <span class="btn_inner way">길찾기</span>
                                    </a>
                                </div>
                            </div> -->
                        </div>
                    </div>

                    <!-- 지도 -->
                    <div class="map">
                    	<img src="${contextPath}${space.spaceMapPath}${space.spaceMapImg}" width="100%" height="100%">
                        <%-- <div id="map">${contextPath}${space.spaceMapPath}${space.spaceMapImg}</div> --%>
                    </div>
                </div>

                <!-- Q&A  -->
                <div>
                    <div id="s-qna" class="text-box">
                        <h4 class="h-intro">Q&A <strong class="txt-primary"><em style="font-style: initial;">16</em>개</strong></h4>
                        <a class="btn-qna-write"><span class="sp-icon icon-write"></span> <span>질문 작성하기</span></a>
                    </div>

                    <div class="review_box">
                        <ul class="review_list">
                            <li class="rlist">

                                <!-- 게스트 문의 -->
                                <div class="rbox-mine">

                                    <!-- 프로필 이미지 -->
                                    <span class="pf-img"
                                        style="background-image: url('https://kr.object.ncloudstorage.com/scloud-service/service/163854526_f97d3d748b273f6b8f062d90a949e0c6.jpeg');"></span>
                                    <strong class="guest-name">la16</strong>
                                    <p class="p-review">
                                        12/13 올나잇 결제 중에 취소됐는데 예약 안되는건가요?
                                    </p>
                                    <div class="rbox-info-base">
                                        <span class="time-info">2021.12.04 00:29:38</span>
                                    </div>
                                </div>

                                <!-- 호스트 답글 -->
                                <div class="rbox-reply">
                                    <p class="p-tit-reply"><em>호스트</em>의 답글</p>
                                    <p class="p-review">
                                        저희 예약은 현재 정상적으로 진행되고 있는 것으로 알고 있습니다 혹시 계속 예약에 문제가 있으시면 오전중에 전화로 연락 주세요 저희가
                                        확인해 보겠습니다
                                    </p>
                                    <!---->
                                    <div class="rbox-info-base">
                                        <p class="time-info">2021.12.04 01:21:10 </p>
                                    </div>
                                </div>
                            </li>

                            <!-- 삭제된 게스트 문의 -->
                            <li class="rlist del-review">
                                <div class="rbox-mine">
                                    <strong class="guest-name">Latte1210</strong>
                                    <p class="p-review">
                                        게스트에 의해 삭제된 문의입니다.
                                    </p>
                                    <div class="rbox-info-base"></div>
                                </div>
                            </li>

                            <li class="rlist">
                                <div class="rbox-mine">
                                    <span class="pf-img"
                                        style="background-image: url('https://kr.object.ncloudstorage.com/scloud-service/service/163800592_0e26daccee248a36bc0f7e30b10dca7f.jpeg');"></span>
                                    <strong class="guest-name">다소니</strong>
                                    <p class="p-review">
                                        보증금에 대한 것은 호스트분께서 따로 연락 주시나요?̊̈
                                    </p>
                                    <div class="rbox-info-base">
                                        <span class="time-info">2021.11.27 18:37:56</span>
                                    </div>
                                </div>

                                <div class="rbox-reply">
                                    <p class="p-tit-reply"><em>호스트</em>의 답글</p>
                                    <p class="p-review">
                                        네 하루전 쯤 따로 연락드리고 있습니다
                                    </p>
                                    <div class="rbox-info-base">
                                        <p class="time-info"> 2021.11.27 18:38:52</p>
                                    </div>
                                </div>
                            </li>
                        </ul>

                        <!-- Q&A 페이징 -->
                        <!-- 화살표 이미지 찾아야됨 -->
                        <div class="paging">
                            <a class="btn btn_prev_list_end"> &lt;&lt; </a>
                            <a class="btn btn_prev_list"> &lt; </a>
                            <a class="num active">1</a>
                            <a class="num">2</a>
                            <a class="num">3</a>
                            <a class="num">4</a>
                            <a class="num">5</a>
                            <a class="btn btn_next_list active"> &gt; </a>
                            <a class="btn btn_next_list_end active"> &gt;&gt; </a>
                        </div>
                    </div>
                </div>

                <!-- 리뷰  -->
                <div>
                    <div id="s-review" class="text-box">
                        <h4 class="h-intro">
                            이용 후기<strong class="txt-primary"><em>6</em>개</strong>
                        </h4>

                    </div>
                    <div class="review_box">
                        <ul class="review_list">
                            <li class="rlist">

                                <!-- 리뷰 -->
                                <div class="rbox-mine">

                                    <!-- 프로필 이미지 -->
                                    <span class="pf-img"
                                        style="background-image: url('https://kr.object.ncloudstorage.com/scloud-service/service/163854526_f97d3d748b273f6b8f062d90a949e0c6.jpeg');"></span>
                                    <strong class="guest-name">달려라방탄</strong>
                                   
                                    <p class="p-review">
                                        음. 이걸 뭐라고 할까요. 공간은 진짜 좋았는데 인터넷이 완전 똥망입니다 온라인 콘 보려고 일부러 홍대에 티비로 볼 수 있는 공간 찾아서 예약했는데 정말 WTF 🤯🤬😡인터넷때문에 4K로도 볼 수 없었어요 깨끗한 공간을 찾으시는 분에겐 정말 딱인데요 온라인콘이나 안정적인 인터넷을 원하시는 분은 비추입니다
                                    </p>

                                    <div class="rbox-info-base">
                                        <span class="time-info">2021.12.04 00:29:38</span>
                                    </div>
                                </div>

                                <!-- 호스트 답글 -->
                                <div class="rbox-reply">
                                    <p class="p-tit-reply"><em>호스트</em>의 답글</p>
                                    <p class="p-review">
                                        우선 후기에 감사드립니다. 인터넷 상태 때문에 즐거우셨어야 할 소중한 시간에 불편함을 드려 정말 죄송하다는 말씀 드립니다. 파티 공간을 운영함에 있어서, 미처 온라인 콘서트와 같은 빠른 인터넷이 필요한 상황을 인지하지 못하여 사전에 관련된 정보를 드리지 못한 점도 죄송하게 생각하고 있습니다. 개선해야 할 상황에 대하여 짚어 주신 것에 감사합니다. 고객님께서 지적해주신 부분에 대하여 같은 문제가 발생하지 않도록 더욱 노력하는 드라마티코가 되도록 하겠습니다.
                                    </p>
                                    <!---->
                                    <div class="rbox-info-base">
                                        <p class="time-info">2021.12.04 01:21:10 </p>
                                    </div>
                                </div>
                            </li>

                        </ul>

                        <!-- Q&A 페이징 -->
                        <!-- 화살표 이미지 찾아야됨 -->
                        <div class="paging">
                            <a class="btn btn_prev_list_end"> &lt;&lt; </a>
                            <a class="btn btn_prev_list"> &lt; </a>
                            <a class="num active">1</a>
                            <a class="num">2</a>
                            <a class="num">3</a>
                            <a class="num">4</a>
                            <a class="num">5</a>
                            <a class="btn btn_next_list active"> &gt; </a>
                            <a class="btn btn_next_list_end active"> &gt;&gt; </a>
                        </div>
                    </div>
                </div>
                
                <!--------------------------------------------------------------------------------------------------------------------------->

                <form action="reservation" method="post" style="position:absolute; width:350px; height:400px; top:0; right:0;">
					<input type="text" class="space_room_no" name="space_room_no">
					<input type="text" class="selected_dt" name="use_date">
                    <div
                        style="height:40px; line-height:38px; font-weight:bold; color:#000; border-bottom:3px solid #704de4; background-color:#f6f6f6;">
                        <div>세부공간 선택</div>
                        <div style="position:absolute; top:0; right:5px;">
                            <img id="heart" src="${contextPath}/resources/images/icon/favorite_border.svg" style="vertical-align:middle;">
                        </div>
                    </div>

                    <div style="background-color: white;">
                    
                    	<c:forEach items="${spaceRoomList}" var="spaceRoom" varStatus="vs" >
                    	
	                        <div class="space_btn" style="padding:20px 10px;">
	                            <div style="position:relative; display:flex;">
	                                <input type="radio" name="spaceRoomNo" id="a-${vs.count}" value="${spaceRoom.spaceRoomNo}"
	                                    style="position:absolute; height:100%;">
	                                    
	                                <!-- 공간룸 이름 -->
	                                <label for="a-${vs.count}"
	                                    style="padding-left:25px; display:inline-block; width:170px;">${spaceRoom.spaceRoomNm}</label>
	                                <div style="width:135px; display:flex; align-items:center; justify-content:end;">
	                                
	                                	<!-- 공간룸 가격 -->
	                                    <strong style="font-size:20px;">\ <fmt:formatNumber value="${spaceRoom.spaceRoomPrice}" pattern="#,###"/></strong> 
	                                    <span style="font-size:11px; margin-left:5px;"> / 일</span>
	                                </div>
	                            </div>
	                        </div>
	                        
	                        <div class="space_detail space-a group_${vs.index}" style="width:100%; border:1px solid #704de4; box-sizing:border-box;">
	                            <div style="position:relative; text-align:center; margin-bottom:20px;">
	                            
	                            	<!-- 공간 이미지 -->
	                                <img src="${contextPath}${spaceImg.spaceImgPath}${spaceImg.spaceImgNm}"
	                                    style="width:320px; height:200px; margin:20px auto;">
	                            </div>
	                            
	                            <!-- 공간룸 설명 -->
	                            <div style="width:320px; margin:20px auto;">
	                                ${spaceRoom.spaceRoomDesc}
	                            </div>
	                            
	                            <div style="width:320px; margin:20px auto;">
	                                <ul>
	                                
	                                	<!-- 공간유형 이름 -->
	                                    <li style="border-bottom: 1px solid #ebebeb; padding: 10px;">
	                                        <span class="room-info">공간유형</span>
	                                        <span>${spaceType.spaceTypeNm}</span>
	                                    </li>
	                                    
	                                    <!-- 공간룸 수용인원 -->
	                                    <li style="padding: 10px;">
	                                        <span class="room-info">수용인원</span>
	                                        <span>${spaceRoom.spaceRoomFit}</span>
	                                    </li>
	                                </ul>
	                            </div>
	
								<!-- 공간옵션 -->
	                            <div style="width:320px; margin:20px auto;">
	                                <ul style="display:table-cell;">
	                                
<%-- 	                                	<c:forEach items="${spaceOptionMap}" var="roomOption" varStatus="vs2">
	                                		<c:if test="${spaceRoom.spaceRoomNo == roomOption.key}">
	                                		
		                                		<c:forEach items="${roomOption.value}" var="option" varStatus="vs3">
		                                			${option.optionNm} / ${option.optionIcon}<br>
		                                		</c:forEach>
	                                		
	                                		</c:if>
	                                	</c:forEach> --%>
	                                
	                                    <li style="width:100px; height:50px; float:left;">
	                                        <div
	                                            style="width:100px; display:flex; align-items:center; justify-content:end;">
	                                            
	                                            <c:forEach items="${spaceOptionMap}" var="roomOption" varStatus="vs2">
			                                		<c:if test="${spaceRoom.spaceRoomNo == roomOption.key}">
			                                		
				                                		<c:forEach items="${roomOption.value}" var="option" varStatus="vs3">
				                                            <span
				                                                style="background: url(${contextPath}/resources/images/icon/${option.optionIcon}.svg) no-repeat; background-size:contain; width:34px; height:34px; display:inline-block;"></span>
				                                            <span
				                                                style="font-size:12px; width:45px; margin:0 5px 0 15px;">${option.optionNm}</span>
				                                			<%-- ${option.optionNm} / ${option.optionIcon}<br> --%>
				                                		</c:forEach>
			                                		
			                                		</c:if>
			                                	</c:forEach>
			                                	
	                                        </div>
	                                    </li>
	                                </ul>
	                            </div>

	                            <div style="width:320px; margin:20px auto;">
	                                <div
	                                    style="height:34px; border-bottom:3px solid #704de4; margin-bottom:10px; color:#000; font-size:18px; font-weight:bold;">
	                                    날짜 선택
	                                    <span id="selectedDateText" class="purple"
	                                        style="float:right; display:inline-block; letter-spacing:-0.5px;"></span>
	                                </div>
	                                <div>
	                                    <div class="datepicker"></div>
	                                </div>
	                            </div>
	                        </div>
                    	
                    	</c:forEach>

                        <div>
                            <button style="width:100%; height:60px; line-height:60px; text-align:center; background-color:#704de4; color:#fff; display:inline-block;">예약하기</button>
                        </div>
                    </div>
                </form>
			</div>
        </section>
    </section>
</main>

<jsp:include page="../common/footer.jsp"/>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script>

    $(function () {
        sticky(); // 페이지 로딩 시 sticky 함수 호출
        $(window).scroll(sticky); // 페이지 내에서 스크롤 시 sticky함수 호출하는 이벤트

    });
    
    // 스크롤 내리다가 메뉴 내용을 만나게 되면 체크 - 준비
    const arr = [];

    $(".nav-area  a").each(function(index, item){
    	const id = $(item).attr("title");
        arr.push($("#"+id).offset().top);
    });
    
    // 메뉴 스크롤 시 붙이기
    const nav = document.getElementsByClassName("nav-wrapper");
    const standard = nav[0].offsetTop +180;
    
    function sticky() {
        //console.log(window.pageYOffset +" / " +standard )
        
        if(window.pageYOffset > standard)
        	nav[0].classList.add("nav-fixed");
        
        else
        	nav[0].classList.remove("nav-fixed");


        // 스크롤 내리다가 메뉴 내용을 만나게 되면 체크 - 동작
        if( window.pageYOffset < arr[0]-140){
             $(".nav-area  a").parent().removeClass("selected");
             
        }else{

            for(let i=0; i<arr.length-1 ; i++){
                if(window.pageYOffset >= arr[i]-140 &&  window.pageYOffset < arr[i+1]-140){
                    $(".nav-area  a").parent().removeClass("selected");
                    $(".nav-area  a").eq(i).parent().addClass("selected");       
                }
            }

            if(window.pageYOffset > arr[arr.length-1]-140){
                $(".nav-area  a").parent().removeClass("selected");
                $(".nav-area  a").eq(arr.length-1).parent().addClass("selected");       
            }
        }

    }
    
    // 메뉴 클릭 시 이동
    $(".nav-area  a").on("click", function(){
       
        // 클릭 배경색 변경
        //$(".nav-area  a").parent().removeClass("selected");
        //$(this).parent().addClass("selected");       
       
        // 해당 메뉴 내용 위치로 이동
        const id = $(this).attr("title");
        $(window).scrollTop($("#"+id).offset().top - 120)
       
    })
    
    // 세부공간 선택 라디오 버튼 클릭 시 이벤트
    $("[name=spaceRoomNo]").on("change", function(){
    	const index = $("[name=spaceRoomNo]").index($(this));
    	
    	$(".space_detail").css("display", "none");
    	$(".space_detail").eq(index).css("display", "block");
    	
    	$(".space_room_no").val($(this).val());
    });
    
    // 찜하기 버튼
    $("#heart").on("click", function() {
    	if ("" != "${loginMember}") {
    		
	    	$.ajax({
	    		url : "heart",
	    		data : {"spaceNo" : ${param.no}},
	    		success : function(spaceHeart) {
					
	    			if (spaceHeart > 0) {
	    				// 찜한공간 등록 상태 (favorite)
	    				if ($("#heart").hasClass("fill-heart")) {
	    					$("#heart").removeClass("fill-heart");
	    					$("#heart").attr("src", "${contextPath}/resources/images/icon/favorite_border.svg");
	    					
	    				} else { // 찜한공간 미등록 상태 (favorite-border)
	    					$("#heart").addClass("fill-heart");
	    					$("#heart").attr("src", "${contextPath}/resources/images/icon/favorite.svg");
	    				}
	    			}
	    		}
	    	}); 
	    	
    	} else 
    		location.href = "${contextPath}/member/login";
    });
    
    
    (function() {
    	if ("" != "${loginMember}") {
    		
	    	$.ajax({
	    		url : "selectHeart",
	    		data : {"spaceNo" : ${param.no}},
	    		success : function(result) {
	    			
	    			if (result > 0) {
	   					$("#heart").addClass("fill-heart");
	   					$("#heart").attr("src", "${contextPath}/resources/images/icon/favorite.svg");
	    			}
	    		}
	    	});  
    	}
    })();
    
</script>

<!-- datepicker -->
<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>
<script>
$( function() {
	const minDate = new Date();
	
	$(".datepicker").each(function(idx) {
		
		$(this).datepicker({
	        // 다음날 부터 선택 가능
	        minDate : 1,
	        dateFormat : 'yy-mm-dd',
	        onSelect: function (selectedDt, inst) {
	            $(".selected_dt").val(selectedDt);
	        }
		});
		
	});

} );
</script>


</body>
</html>