$(function () {
	$(".btn.write").on("click", function () {
		layerPopQna(0);
	});
});

$("#qna_sort").on("change", function () {
	qnaListRoad($(this).val());
});

function qnaListRoad(sortValue) {
	$.ajax({
		url : contextPath + "/my/qna/sort",
		data : {
			sort : sortValue
		},
		dataType : "json",
		success : function (result) {
			$(".l_area").empty();
			
			let html = "";
			$.each(result, function (index, qna) {
				
				let spaceImg = "";
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
			
			});
			
			$(".l_area").html(html);

		},
		error : function (req, status, error) {
			console.log("오류가 발생했습니다.");
			console.log(req.responseText);
		}
	});
}