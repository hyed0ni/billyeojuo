$(function () {
	$(".btn.write").on("click", function () {
		layerPopQna(0);
	});
});

$("#qna_sort").on("change", function () {
	qnaListRoad($(this).val());
});

