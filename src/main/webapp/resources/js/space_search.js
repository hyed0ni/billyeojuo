function infiniteScroll(){

  const pagination = document.querySelector('.pagination')
  const fullContent = document.querySelector('.spcae-wrapper')
  const screenHeight = screen.height //화면 크기 
  
  let oneTime = false
  //바닥에 닿고 나서 madBow를 한번만 호출하기 위해 사용

  document.addEventListener('scroll', onscroll, {passive:true})

  function onscroll(){
    //이벤트 스크롤 함수 
    const fullHeight = fullContent.clientHeight;

    const scrollPosition = scrollY

    if(fullHeight-screenHeight/2 <= scrollPosition && !oneTime){
      oneTime = true
      //true로 바꾸어 여러번 호출 방지 
      
      const nextLink = pagination.querySelector('.nextPage'); //다음페이지 버튼 
      const nextURL = nextLink.getAttribute('href');

      madBox(){
        const xhr = new XMLHttpRequest();
      
        xhr.onreadystatechange = function(){
          if(xhr.readyState) == 200 || xhr.status ===201){
            const data = xhr.response;
      
            const addList = data.querySelector('.space-space-list')
      
            fullContent.appendChild(addList);
      
            on
      
          }
        }
      
      
      }
    }
  }
}


