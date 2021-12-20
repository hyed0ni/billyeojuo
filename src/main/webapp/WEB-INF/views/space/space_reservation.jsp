<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="../common/header.jsp" />
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/space-reservation.css">

<section class="reservation-heading">
	<h2 style="margin: 0;">예약하기</h2>
</section>
<main>
	<form class="detail-forms">

		<div class="box-form">
			<div class="heading">
				<div>
					예약 공간 <span class="option"> <strong class="txt-price">\0</strong> <em class="txt-unit">/패키지</em>
					</span>
				</div>

			</div>

			<div style="padding: 30px;">
				<div class="info_photo" style="padding-left: 170px; position: relative; padding-bottom: 30px; border-bottom: 1px solid #ebebeb;">
					<h4 class="sp_name" style="font-size: 24px; margin: 0 0 20px 0; padding-bottom: 20px; border-bottom: 1px solid #ebebeb;">4명에서16명수용가능 공간-여기뿐, 프라이빗 하늘 T공간</h4>
					<span class="img" style="position: absolute; top: 0; left: 0;"> <img src="https://moplqfgeemqv2103108.cdn.ntruss.com/service/163828638_35ce7ec9141773ece66564f92828a91f.jpg?type=m&amp;w=900&amp;h=900&amp;autorotate=true&amp;quality=90" width="140" height="140" alt="프라이빗 하늘 T공간">
					</span>
					<p>해당 공간에는 테이블과 의자가 구비되어 있습니다. 음식물 섭취 가능하며, 냄새가 많이 나는 요리들은 이용불가합니다. 전면전신거을, 조명, 스피커, 의자, 책상 있습니다. S 공간과 T공간은 한 층에 있습니다. ( 같이 예약시 추가 할인해드립니다.) 문의사항은 안심번호로 "하늘 파티룸 문의드려요"라고 말씀주시면 더욱 빠른 안내가 가능합니다.</p>
				</div>

				<ul class="list_detail">
					<li><span class="tit">공간유형</span> <span class="data"> 파티룸 </span></li>
					<li><span class="tit">예약인원</span> <span class="data">최소 1명 ~ 최대 10명</span></li>
					<li><span class="tit">추가인원</span> <span class="data">5명 초과시 10,000원/인</span></li>
				</ul>

			</div>
		</div>


		<div class="box-form">
			<div class="heading">
				<div>예약정보</div>
			</div>

			<div class="meetspace-reserve-info">
				<p class="meetspace-reserve-date">
					예약날짜 <span class="meetspace-reserve-price"> 2021.12.20 (월) 13시 ~ 19시 </span>
				</p>
				<p class="meetspace-reserve-date">
					예약인원 <span class="meetspace-reserve-price">1명</span>
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
							<input id="name" name="name" type="text">
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
								<input id="phone2" name="phone" type="tel" required="required" maxlength="4" onkeyup="this.value=this.value.replace(/[^0-9]/g,'');">
							</div>
							<div class="col4">
								<input id="phone3" name="phone" type="tel" required="required" maxlength="4" onkeyup="this.value=this.value.replace(/[^0-9]/g,'');">
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
							<input id="email" name="email" type="email" placeholder="이메일 주소를 입력해 주세요.">
						</div>
					</dd>
				</dl>
				<dl class="flex_box">
					<dt class="tit">
						<label for="reservationPurpose">사용목적</label>
					</dt>
					<dd class="flex">
						<div class="input">
							<input id="reservationPurpose" name="purpose" type="text" placeholder="촬영, 파티, 모임, 수업 등 공간의 사용 목적을 입력해주세요.">
						</div>
					</dd>
				</dl>
				<dl class="flex_box" style="margin-bottom: 0">
					<dt class="tit">
						<label for="request">요청사항</label>
					</dt>
					<dd class="flex" style="height: 134px;">
						<div class="input">
							<textarea id="request" name="req_text" placeholder="남기고 싶은말을 적어주세요. (최대 500자)" maxlength="500"></textarea>
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
			<div class="list_wrap">
				<ol class="notice_list">
					<li><span class="num">1</span> 청소보증금이 50,000원 발생합니다. 청소보증금은 2일안으로 돌려드립니다. 이용 후 정리하시고 퇴실 부탁드립니다.</li>
					<li><span class="num">2</span> 시설이용시 시설파손으로 인해 생기는 문제는 원상복구를 하셔야 합니다.(음주시 평소와 다르기때문에 가끔 발생하는 문제입니다. 이용시 조심해주세요)</li>
					<li><span class="num">3</span> 해당 공간은 비싼파티룸을 대신하여 저렴하게 파티룸으로 이용하게끔 해드리고 있습니다. 높은 퀄리티는 제공드리지 못하지만 최선을 다해 필요한것에 대해 제공드리겠습니다.</li>
					<li><span class="num">4</span> 이용시에 꼭 정리정돈하여 퇴실하셔야 합니다.</li>
					<li><span class="num">5</span> 12월 예약건은 입금후 2시간 이전or 예약 31일전까지는 100% 환불이 가능하며, 그 외에는 환불규정에 따르게 됩니다.</li>
					<li><span class="num">6</span> 원하시는 시간대가 있으시면 별도문의부탁드립니다.</li>
					<li><span class="num">7</span> 궁금하신 내용은 010-7741-5257로 문의 부탁드립니다.</li>
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











		<div id="sidebar" style="position: absolute; width: 350px; height: 356px; top: 0; right: 0; background-color: #fff;">
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
									<span class="line">2021.12.31 (금)</span>
								</dd>
							</dl>
							<dl class="info_date">
								<dt>예약시간</dt>
								<dd>
									<span class="line">10시 ~ 17시, 7시간</span>
								</dd>
							</dl>
							<dl class="info_person">
								<dt>예약인원</dt>
								<dd>1명</dd>
							</dl>
							<dl class="info_price">
								<dd>
									<strong class="txt_price">\150,000</strong>
								</dd>
							</dl>
						</div>
						<div class="total_box">
							<dl class="pull_box">
								<dt class="pull_left">
									<strong class="txt_price">\</strong>
								</dt>
								<dd class="pull_right align_right">
									<strong class="txt_price">150,000</strong>
								</dd>
							</dl>
						</div>
					</div>
				</div>



				<div>
					<a href="javascript:payment();" style="width: 100%; height: 60px; line-height: 60px; text-align: center; background-color: #704de4; color: #fff; display: inline-block;">결제하기</a>
				</div>
			</div>

		</div>
		</from>
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
</script>


</html>