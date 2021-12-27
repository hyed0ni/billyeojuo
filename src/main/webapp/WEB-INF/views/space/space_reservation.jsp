<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="../common/header.jsp" />
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/space-reservation.css">

<section class="reservation-heading">
	<h2 style="margin: 0;">예약하기</h2>
</section>
<main>
	<form class="detail-forms" action="${contextPath}/res/insertRes" method="post" onsubmit="return validate();">

		<div class="box-form">
			<div class="heading">
				<div>
					예약 공간 <span class="option"> 
					
					<!-- 공간룸 가격 -->
					<strong class="txt-price">\ <fmt:formatNumber value="${spaceRoom.spaceRoomPrice}" pattern="#,###"/></strong> 
					
					<em class="txt-unit">/ 일</em>
					</span>
				</div>

			</div>

			<div style="padding: 30px;">
				<div class="info_photo" style="padding-left: 170px; position: relative; padding-bottom: 30px; border-bottom: 1px solid #ebebeb;">
				
					<!-- 공간 이름 + 공간룸 이름 -->
					<h4 class="sp_name" style="font-size: 24px; margin: 0 0 20px 0; padding-bottom: 20px; border-bottom: 1px solid #ebebeb;">${space.spaceNm}, ${spaceRoom.spaceRoomNm}</h4>
					<span class="img" style="position: absolute; top: 0; left: 0;">
						<img src="${contextPath}${spaceImg.spaceImgPath}${spaceImg.spaceImgNm}" width="140" height="140">
					</span>
					
					<!-- 공간룸 설명 -->
					<p style="min-height: 65px;">${spaceRoom.spaceRoomDesc}</p>
				</div>

				<ul class="list_detail">
				
					<!-- 공간유형 이름 -->
					<li><span class="tit">공간유형</span><span class="data">${spaceType.spaceTypeNm}</span></li>
					
					<!-- 공간룸 수용인원 -->
					<li><span class="tit">예약인원</span><span class="data">${spaceRoom.spaceRoomFit}</span></li>
				</ul>
				<input type="hidden" name="resPersonnel" value="${param.res_personnel}">

			</div>
		</div>

		<div class="box-form">
			<div class="heading">
				<div>예약정보</div>
			</div>

			<div class="meetspace-reserve-info">
				<p class="meetspace-reserve-date">
					예약날짜 <span class="meetspace-reserve-price">${param.use_date}</span>
				</p>
				<p class="meetspace-reserve-date">
					예약인원 <span class="meetspace-reserve-price">${param.res_personnel}</span>
				</p>
			</div>

			<p class="meetspace-reserve-help">호스트 확인 후 예약이 가능합니다.</p>
		</div>

		<div class="box-form">
			<div class="heading">
				<div>
					예약자 정보 <span class="option"> <strong class="txt-required">* 필수입력</strong>
					</span>
				</div>
			</div>

			<div class="reserve_person_wrap">
				<dl class="flex_box">
					<dt class="tit">
						<label for="name">예약자</label> <span class="ico_required">*</span>
					</dt>
					<dd class="flex">
						<div class="input">
							<input id="name" name="resNm" type="text" value="${loginMember.memberName}" required>
						</div>
					</dd>
				</dl>
				<dl class="flex_box">
					<dt class="tit">
						<label for="phone1">연락처</label> <span class="ico_required">*</span>
					</dt>
					<dd class="flex mobile">
						<div class="row">
							<div class="col4">
								<div class="select">
									<select id="phone1" name="phone"><option value="010">010</option>
										<option value="011">011</option>
										<option value="016">016</option>
										<option value="017">017</option>
										<option value="018">018</option>
										<option value="019">019</option></select>
								</div>
							</div>
							<div class="col4">
								<input id="phone2" name="phone" type="tel" required maxlength="4" onkeyup="this.value=this.value.replace(/[^0-9]/g,'');">
							</div>
							<div class="col4">
								<input id="phone3" name="phone" type="tel" required maxlength="4" onkeyup="this.value=this.value.replace(/[^0-9]/g,'');">
							</div>
						</div>
					</dd>
				</dl>
				<dl class="flex_box">
					<dt class="tit">
						<label for="email">이메일</label> <span class="ico_required">*</span>
					</dt>
					<dd class="flex">
						<div class="input">
							<input id="email" name="resEmail" type="email" placeholder="이메일 주소를 입력해 주세요." value="${loginMember.memberEmail}" required>
						</div>
					</dd>
				</dl>
				<dl class="flex_box">
					<dt class="tit">
						<label for="reservationPurpose">사용목적</label>
					</dt>
					<dd class="flex">
						<div class="input">
							<input id="reservationPurpose" name="resPurpose" type="text" placeholder="촬영, 파티, 모임, 수업 등 공간의 사용 목적을 입력해주세요.">
						</div>
					</dd>
				</dl>
				<dl class="flex_box" style="margin-bottom: 0">
					<dt class="tit">
						<label for="request">요청사항</label>
					</dt>
					<dd class="flex" style="height: 134px;">
						<div class="input">
							<textarea id="request" name="resReq" placeholder="남기고 싶은말을 적어주세요. (최대 500자)" maxlength="500"></textarea>
						</div>
					</dd>
				</dl>
			</div>
			<p class="p_guide normal">
				<i class="sp_icon ico_alert"></i> 예약자 정보로 알림톡과 이메일이 발송됩니다. 정확한 정보인지 확인해주세요.
			</p>
		</div>

		<article class="box_form box_notice">
			<div class="heading">
				<h3>예약시 주의사항</h3>
			</div>
			
			<!-- 예약시 주의사항 -->
			<div class="list_wrap">
			
				<c:set var="temp" value="${fn:replace(space.precautions, '<br>', '|')}"/>
				<c:set var="arr" value="${fn:split(temp, '|')}"/> 
					
				<ol class="notice_list">
					<c:forEach items="${arr}" var="precautions" varStatus="vs">
						<li><span class="num">${vs.count}</span>${precautions}</li>
					</c:forEach>
				</ol>
			</div>
		</article>

		<p class="p_guide warn" style="display: block;">
			<i class="sp_icon ico_alert"></i> 계좌이체의 경우, 모바일에서는 네이버페이 계좌 간편결제만 가능합니다!(일반 계좌이체는 PC에서만 지원)
		</p>

		<article class="box_form box_notice">
			<div class="heading" style="position: relative;">
				<h3>서비스 동의</h3>
				<span class="option"> <input id="terms_agree" type="checkbox" class="checkbox"> <label for="terms_agree">전체 동의</label>
				</span>
			</div>

			<div class="list_wrap terms_wrap">
				<ul class="notice_list">
					<li><input id="term1" type="checkbox" class="checkbox"> <label for="term1"> 위 공간의 예약조건 확인 및 결제진행 동의 <span class="txt_required">(필수)</span></label></li>
					<li class=""><div class="confirm_box">
							<input id="term3" type="checkbox" class="checkbox"> <label for="term3"> 개인정보 제3자 제공 동의 <span class="txt_required">(필수)</span></label> <a class="btn_view_terms"><span class="sp_icon ico_view_terms"><em class="blind">내용보기</em></span></a>
						</div>
						<div tabindex="0" class="scroll_box">
							<div class="terms">
								<ol>
									<li>1. 개인정보를 제공받는 자: 해당 공간의 호스트</li>
									<li>2. 제공하는 개인정보 항목
										<ul>
											<li>- 필수항목: 네이버 아이디, 이름, 연락처, 결제정보(결제방식 및 결제금액)</li>
											<li>- 선택항목: 이메일 주소</li>
										</ul>
									</li>
									<li>3. 개인정보의 제공목적: 공간예약 및 이용 서비스 제공, 환불처리</li>
									<li>4. 개인정보의 제공기간: 서비스 제공기간(단, 관계법령의 규정에 의하여 보존할 필요가 있는 경우 및 사전 동의를 득한 경우에는 해당 기간 동안 보관합니다.)</li>
									<li>5. 개인정보의 제공을 거부할 권리: 개인정보 주체는 개인정보의 제공을 거부할 권리가 있으나, 공간 예약을 위해 반드시 필요한 개인정보의 제공으로서 이를 거부할 시 공간 예약이 어려울 수 있습니다.</li>
								</ol>
							</div>
						</div></li>
					<li><div class="confirm_box">
							<input id="term4" type="checkbox" name="terms" class="checkbox"> <label for="term4"> 개인정보 수집 및 이용 동의 <span class="txt_required">(필수)</span></label> <a class="btn_view_terms"><span class="sp_icon ico_view_terms"><em class="blind">내용보기</em></span></a>
						</div>
						<div tabindex="0" class="scroll_box">
							<div class="terms">
								<ol>
									<li>1. 수집하는 개인정보의 항목
										<p class="sub_term">
											<em>-</em> 예약정보(성명, 이메일주소, 휴대전화번호), 결제정보(신용카드 번호 및 은행계좌정보 일부 등)
										</p>
									</li>
									<li>2. 개인정보의 이용목적
										<p class="sub_term">
											<em>-</em> 공간 예약 및 이용
										</p>
									</li>
									<li>3. 개인정보의 보관기간
										<p class="sub_term">
											<em>-</em> 예약 완료 후 관련 법령에 따라 5년간 개인정보를 보관합니다.
										</p>
									</li>
									<li>4. 개인정보의 수집 및 이용을 거부할 권리
										<p class="sub_term">
											<em>-</em> 개인정보 주체는 개인정보의 수집 및 이용을 거부할 권리가 있으나, 공간 예약을 위한 최소한의 개인정보 수집으로서 이를 거부할 시 공간 예약이 어려울 수 있습니다.
										</p>
									</li>
								</ol>
							</div>
						</div></li>
				</ul>
			</div>
		</article>

		<p class="p_guide warn" style="display: block;">
			<i class="sp_icon ico_alert"></i> 서비스 이용약관 동의는 필수입니다.
		</p>

		<div id="sidebar" style="position: absolute; width: 350px; height: 300px; top: 0; right: 0; background-color: #fff;">
			<div style="height: 40px; line-height: 38px; font-weight: bold; color: #000; border-bottom: 3px solid #704de4; background-color: #f6f6f6;">
				<div>결제 예정금액</div>
			</div>

			<div>
				<div class="scroll_box">
					<div class="reserve_price_wrap">
						<div class="basic_box">
							<dl class="info_date">
								<dt>예약날짜</dt>
								<dd>
									<span class="line">${param.use_date}</span>
								</dd>
							</dl>
							
							<dl class="info_person" style="border-top: 1px solid #ebebeb;">
								<dt>예약인원</dt>
								<dd>${param.res_personnel}</dd>
							</dl>
							
						</div>
						<div class="total_box">
							<dl class="pull_box">
								<dt class="pull_left">
									<strong class="txt_price">\</strong>
								</dt>
								<dd class="pull_right align_right">
									<strong class="txt_price"><fmt:formatNumber value="${spaceRoom.spaceRoomPrice}" pattern="#,###"/></strong>
								</dd>
							</dl>
						</div>
					</div>
				</div>

				<div>
					<!-- <a href="../my/reservation_detail" style="width: 100%; height: 60px; line-height: 60px; text-align: center; background-color: #704de4; color: #fff; display: inline-block;">결제하기</a> -->
					<button style="width: 100%; height: 60px; line-height: 60px; text-align: center; background-color: #704de4; color: #fff; display: inline-block;">결제하기</button>
				</div>
			</div>

		</div>
		<input type="hidden" name="spaceRoomNo" value="${param.space_room_no}">
		<input type="hidden" name="useDate" value="${param.use_date}">
		
		</form>
</main>

<jsp:include page="../common/footer.jsp" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script>
	// common.js
	$(function() {
		$(".menuIcon").on("click", function() {
			if ($(".sideMenu").hasClass("active")) {
				$(".sideMenu").removeClass("active");

				$(".modal").hide();
			} else {
				$(".sideMenu").addClass("active");
				$(".modal").show();
			}
		});

		$(".modal").on("click", function() {
			$(".sideMenu").removeClass("active");
			$(".modal").hide();
		});

		$(".closeMenu").on("click", function() {
			$(".sideMenu").removeClass("active");
			$(".modal").hide();
		});

		$("#notice > ul > li").on("click", function() {
			const url = $(this).data("url");
			if (url == "service") {
				if ($(".service_sub").hasClass("active")) {
					$(".service_sub").removeClass("active");
				} else {
					$(".service_sub").addClass("active");
				}

			} else {
				alert(url);
			}
		})

		$("#notice > ul > li .service_sub > li").on("click", function() {
			const url = $(this).data("url");
			alert(url);
		})

	});

	// 내용보기 효과
	$(".blind").on("click", function() {
		const index = $(".blind").index(this);

		const scrollBox = $(".scroll_box").eq(index);

		if (scrollBox.css("display") == "none")
			scrollBox.show();
		else
			scrollBox.hide();

	});
	
   //사이드바 스크롤
   $(function(){
      const scrollHeight = 180;
      function sidebar(){
         
         // 화면 스크롤이 footer 위쪽 550px 위치 아래로 내려간 경우
         if( $(window).scrollTop() > $(".footer").offset().top - 550  ) {
            
            // 아이디가 sidebar인 요소의 top 속성을 변경
            document.getElementById('sidebar').style.top = $(".footer").offset().top - 700+'px';
         }
         
         // 화면 스크롤이 상단에서 180px 위치 아래로 내려간 경우
         else if($(window).scrollTop() > scrollHeight){
            let top = $(window).scrollTop() - scrollHeight + 20;
            document.getElementById('sidebar').style.top = top+'px';
            
         // 화면 스크롤이 움직이는 경우
         }else{
            document.getElementById('sidebar').style.top = 0+'px';
            
         }
      }

      // 화면 로딩 시 sidebar 함수 호출
      sidebar();

      // 화면 스크롤이 움직일 때 마다 sidebar 함수 호출
      $(window).scroll(()=>{
         sidebar();
      });

   });
   
   // 전체 동의 체크박스 값 변경 시
   $("#terms_agree").on("change", function(){
	   
      // 체크된 경우
      if ($(this).prop("checked"))
         $(".notice_list [type=checkbox]").prop("checked", true);

      else // 해제된 경우
         $(".notice_list [type=checkbox]").prop("checked", false);
   })

   // 서비스 동의 체크박스 값 변경 시
   $(".notice_list [type=checkbox]").on("change", function(){
	   
      // 모두 체크된 경우
      if ($(".notice_list [type=checkbox]").length == $(".notice_list [type=checkbox]:checked").length)
    	  $("#terms_agree").prop("checked", true);
      
      else
    	  $("#terms_agree").prop("checked", false);

   });
   
   // 서비스 동의 전체 동의 선택이 되지 않은 경우
   function validate() {
	   if (!$('#terms_agree').prop("checked")) {
		   alert("서비스 이용약관 동의는 필수입니다.");
		   $('#terms_agree').focus();
		   return false;
	   }
	   
	   if (!confirm("결제하시겠습니까?")) return false;
   }
   
</script>
</html>