## 🏠 빌려주오 ([스페이스클라우드](https://www.spacecloud.kr/) 클론 코딩)
소비자의 조건에 맞는 다양한 공간을 쉽게 검색하고 예약할 수 있는 공간 대여 서비스 플랫폼입니다.

![빌려주오 001](https://user-images.githubusercontent.com/110330040/184215180-ab8df568-7f11-435b-9299-fbf4e0ab6cfc.png)

<br>

## ⌛ 제작 기간
2021년 10월 28일 ~ 2021년 12월 28일 (9주)

<br>

## ⚒️ 개발 환경 및 사용 기술
**[사용 기술]**
<p>
  <img src="https://img.shields.io/badge/java-007396?style=flat-square&logo=java&logoColor=white">
  <img src="https://img.shields.io/badge/Oracle-F80000?style=flat-square&logo=Oracle&logoColor=white">
  <img src="https://img.shields.io/badge/HTML5-E34F26?style=flat-square&logo=HTML5&logoColor=white">
  <img src="https://img.shields.io/badge/CSS3-1572B6?style=flat-square&logo=CSS3&logoColor=white">
  <img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=flat-square&logo=JavaScript&logoColor=black">
  <img src="https://img.shields.io/badge/jQuery-0769AD?style=flat-square&logo=jQuery&logoColor=white">
</p>

**[개발 환경]**
<p>
  <img src="https://img.shields.io/badge/Visual Studio Code-007ACC?style=flat-square&logo=Visual Studio Code&logoColor=white">
  <img src="https://img.shields.io/badge/Eclipse IDE-2C2255?style=flat-square&logo=Eclipse IDE&logoColor=white">
  <img src="https://img.shields.io/badge/Apache Tomcat-F8DC75?style=flat-square&logo=Apache Tomcat&logoColor=black">
</p>

**[협업 툴]**
<p>
  <img src="https://img.shields.io/badge/Trello-0052CC?style=flat-square&logo=Trello&logoColor=white">
  <img src="https://img.shields.io/badge/Slack-4A154B?style=flat-square&logo=Slack&logoColor=white">
  <img src="https://img.shields.io/badge/Figma-F24E1E?style=flat-square&logo=Figma&logoColor=white">
  <img src="https://img.shields.io/badge/Sourcetree-0052CC?style=flat-square&logo=Sourcetree&logoColor=white">
  <img src="https://img.shields.io/badge/GitHub-181717?style=flat-square&logo=GitHub&logoColor=white">
</p>

<br>

##  🌱 맡은 역할

### **📣 ROLE**
- 프로젝트 리더
- 트렐로, 구글 시트, 슬랙 관리
- ERD 설계 총괄

### **🎨 UI**
- 찜한 공간, 기획전 목록, 대여 장소, 예약 신청 및 결제</s> 페이지 목업 제작
- 공간 상세 페이지 UI 구현

### **⚙️ 기능 구현**
- **공간 상세 조회**
  - 공간 이미지 및 상세 정보 조회
  - 공간 찜 등록, 삭제

- **공간 예약**
  - 세부 공간, 날짜, 인원 등 선택
  - 예약자 정보 입력

- **예약 내역 리스트 조회**
  - 예약번호순, 이용일자순 정렬
  - 결제 완료, 취소 환불, 이용 완료 구분

- **예약 상세 조회**
  - 결제 취소

<br>

## ⛓️ ERD
![HYEJIN_BUS ERD(논리,물리)](https://user-images.githubusercontent.com/110330040/186585005-2d553bfe-ea70-4365-acf1-c1311414e244.png)

<br>

## 📂 폴더 구조
```
📦 billyeojuo
├── 📁 src/main
│   ├── 📁 java/getonFast/hj/semi
│   │   ├── 📁 admin
│   │   ├── 📁 common
│   │   ├── 📁 favorites
│   │   ├── 📁 filter
│   │   ├── 📁 main
│   │   ├── 📁 member
│   │   ├── 📁 my
│   │   ├── 📁 promotion
│   │   ├── 📁 res
│   │   ├── 📁 review
│   │   ├── 📁 space
│   │   ├── 📁 sql
│   │   └── 📁 wrapper
│   └── 📁 webapp
│       ├── 📁 resources
│       │   ├── 📁 css
│       │   ├── 📁 images
│       │   └── 📁 js
│       └── 📁 WEB-INF
│           ├── 📁 lib
│           ├── 📁 views
│           │   ├── 📁 admin
│           │   ├── 📁 adminAnswer
│           │   ├── 📁 adminCommon
│           │   ├── 📁 adminSpace
│           │   ├── 📁 common
│           │   ├── 📁 main
│           │   ├── 📁 member
│           │   ├── 📁 my
│           │   ├── 📁 promotion
│           │   ├── 📁 qna
│           │   ├── 📁 review
│           │   └── 📁 space
│           └── index.jsp
└── README.md
```
