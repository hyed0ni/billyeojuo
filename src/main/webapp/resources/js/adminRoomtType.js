  
  // 영역 클릭시 file 클릭 
  $(function() {
    $(".roomImg" ).on("click", function() {
      $("[type=file]").click();
    });
	});
  
//파일을 첨부 했을 경우 미리 보기가 가능하도록 하는 함수
  function loadImg(value) {
      var reader = new FileReader();
      // 자바스크립트 FileReader
      // 웹 애플리케이션이 비동기적으로 데이터를 읽기 위하여 읽을 파일을 가리키는 File 혹은 Blob객체를 이용해 파일의 내용을 읽고 사용자의 컴퓨터에 저장하는 것을 가능하게 해주는 객체

      // 파일이 선택된 경우 true 선택된 파일 읽기 
      reader.readAsDataURL(value.files[0]);
      // FileReader.readAsDataURL()
      // 지정된 내용을 읽기 시작합니다. Blob완료되면 result속성 data:에 파일 데이터를 나타내는 URL이 포함 됩니다.

      // FileReader.onload : 파일 로드가 완료 되면 
      // load 이벤트의 핸들러. 이 이벤트는 읽기 동작이 성공적으로 완료 되었을 때마다 발생합니다.
      reader.onload = function(e) {
        //console.log(e.target.result);
        // e.target.result
        // -> 파일 읽기 동작을 성공한 객체에(fileTag) 올라간 결과(이미지 또는 파일)

        $(".roomImg").children("img").attr("src", e.target.result);
        $(".roomImg").children("label").empty()
      }
    }
	
	function createRoom() {
		
	}
	