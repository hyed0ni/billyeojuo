
$(function () {
    // menu toggle
    $(".ico_menu").on("click", function () {
        if ($(".side_menu").hasClass("active")) {
            $(".side_menu").removeClass("active");
            
            $(".modal").hide();
        } else {
            $(".side_menu").addClass("active");
            $(".modal").show();
        }
    });

    // modal close
    $(".modal").on("click", function () {
        $(".side_menu").removeClass("active");
        $(".modal").hide();
        $(".layerPop").hide();
    });

    // menu close
    $(".close_menu").on("click", function () {
        $(".side_menu").removeClass("active");
        $(".modal").hide();
    });

    // service toggle
    $("#notice > ul > li").on("click", function () {
        const url = $(this).data("url");
        if (url == "service") {
            if ($(".service_sub").hasClass("active")) {
                $(".service_sub").removeClass("active");
            } else {
                $(".service_sub").addClass("active");
            }

        } else {
			if (url == "home") {
				location.href = contextPath;
			} else if (url == "qna") {
				layerPop(0);
				
			} else {
				
            alert(url);
			}
        }
    });

    // service location href
    $("#notice > ul > li .service_sub > li").on("click", function () {
        const url = $(this).data("url");
		alert(url);
    });

	
});

function layerPop(layerValue) {
	const html = `
		<div class="popup_wrap">
			<div class="pop_header">질문 작성하기</div>
			<div class="pop_container reviews">
				<article class="reserve_price">
					<div class="box_form">
						<div class="tit">
							<label for="reason_cancel">질문</label>
						</div>
						<span class="option">
							<span class="txt_count">
								<em>0</em>자/<em>200</em>자
							</span>
						</span>
						<div class="input">
							<input type="hidden" name="spaceNo" value="${layerValue}">
							<textarea maxlength="200" id="queContent" placeholder="질문을 남겨 주세요."></textarea>
						</div>
					</div>
				</article>
				<p class="p_guide">
					<i class="sp_icon ico_alert"></i>
			    	질문은 공개 상태로만 등록하실 수 있습니다.
				</p>
				<div class="btns">
					<a class="btn btn_full cancel btn_negative">취소</a>
					<a class="btn btn_full submit btn_default" id="sub">등록</a>
				</div>
			</div>
			<a title="레이어팝업 닫힘" class="btn_pop_close">
				<img src="` + contextPath + `/resources/images/common/close_white_18.svg" />
			</a>
		</div>
	`;
	
	$(".side_menu").removeClass("active");
	$(".modal").show();
	
	if ($(".layerPop").children().length == 0) {
		$(".layerPop").html(html);
		
	} else {
		$(".layerPop").show();
	}
}

$(".btn_pop_close").on("click", function  () {
	
});

$(document).on("click", ".btn_pop_close, .btn.cancel", function(){
	$(".modal").hide();
    $(".layerPop").hide();
});

$(document).on("click", ".btn.submit", function(){
	console.log(contextPath + "/my/qna/insert");
	$.ajax({
		url : contextPath + "/my/qna/insert",
		method : "post",
		data : {
			spaceNo : $("input[name='spaceNo']").val(),
			queContent : $("#queContent").val()
		},
		success : function (result) {
			alert("등록되었습니다. : " + result);
		},
		error : function (req, status, error) {
			console.log("등록 실패");
			console.log(req.responseText);
		}
		
	});
});

