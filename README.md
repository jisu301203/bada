
### <a href="https://docs.google.com/presentation/d/1hgCvguZBQZwNIgWdQMeYLFomf8ff3Kij/edit?usp=sharing&ouid=115614281961147788111&rtpof=true&sd=true">**프레젠테이션 보러가기(click)**</a>





   

<img src="https://github.com/doh3e/bada/assets/151860111/ce83434a-1a6f-4d18-9ad8-578b1cc8112a" width="800px">




　

# 🌊 바다 여행할 땐, <바라는 바다!>

　

<바라는 바다!>는 Spring framework와 Java를 기반으로 제작된 프로젝트입니다.

이 플랫폼에서는 전국 각 지역의 유명 해수욕장 정보를 DB화 하고 기상청 API와 카카오지도 API를 활용하여

바다 여행을 가고자 하는 사람들이 쉽게 해수욕장 정보와 기상 정보를 얻을 수 있으며,

바다에 다녀온 사람들이 후기와 댓글을 남기며 소통할 수 있습니다.

또 BBTI(바다성향 테스트)를 통해 유저 맞춤형 바다를 추천받을 수 있습니다.

　

## <바라는 바다!> 소개

　

![KakaoTalk_20240530_094957256](https://github.com/doh3e/bada/assets/151860111/1e0a880f-65cf-4c41-8037-12e3bde9bf46)


　
 
## 프로젝트 기간

　

2024.03.21. ~ 2024.04.19. 총 30일.

　

## 팀원 소개

　

|   Name   | 정지은 👑                         | 한지수                                            | 정지수                             | 홍문선                                                       |
| :------: | ------------------------------------ | ------------------------------------------------- | ---------------------------------- | ------------------------------------------------------------ |
| Profile  |<p align="center"><img src = "https://github.com/doh3e/bada/assets/151860111/232142ac-9b04-4d54-8869-409d1a584d4f" width="127px" height="160px"></p>|<p align="center"><img src = "https://github.com/doh3e/bada/assets/151860111/3d5623ad-9984-4889-adc3-794e9c411330" width="127px" height="160px"></p>|<p align="center"><img src = "https://github.com/doh3e/bada/assets/151860111/535117e8-d2fb-42f9-95de-d0678debf770" width="127px" height="160px" ></p>|<p align="center"><img src = "https://github.com/doh3e/bada/assets/151860111/f8115a50-ab00-47fd-9cd8-f49a794020c9" width="127px" height="160px"></p>| 
| Position | Front/Backend Develop  | Front/Backend Develop                                  | Front/Backend Develop                   | Front/Backend Develop                              |
|   Git    | [@doh3e](https://github.com/doh3e) | [@jisuhaan](https://github.com/jisuhaan)            | [@jisu301203](https://github.com/jisu301203) | [@annesolHong](https://github.com/annesolHong)                 |
|   E-mail    | wldms3333@gmail.com| haanjisu@gmail.com| jisu301203@naver.com| seizemyred@gmail.com|

　

### 세부 역할

　

`정지은(팀장)`

UI/UX 설계 / 전체 로직 설계 / 유스케이스 다이어그램 제작 / 메인화면(검색, 회원별 바다추천, 이벤트 배너, 베스트리뷰 슬라이드) / 추천, 바다(지도 선택 페이지, 결과 페이지 해수욕장 정보 및 지도) / 리뷰,바다(싸이월드 스타일의 레트로&도트 디자인, 개별 리뷰 페이지 CSS 작업) / BBTI(바다성향테스트) 로직 및 이미지 제작 / 전체 페이지 CSS 제작 관리 / 전반적인 코드 관리 / 깃허브 관리 담당

 
`한지수(부팀장)`

추천 바다(날씨 요약 및 상세 페이지 총괄, 로직 설계, 기상 데이터 수집 및 가공, 데이터 최적화) / 순위 바다(순위 페이지 로직 설계, 데이터 소스 통합), 회원 관리(회원 가입 프로세스 보완, 중복 방지 유효성 검사, 보안성과 사용자 경험 개선) / javascript 데이터 가공 전반 (클라이언트 측 데이터 계산 로직, 실시간 데이터 가공 및 연동) / api 통합 및 데이터 처리 담당
　

`정지수`

회원 관리(회원 가입, 회원 목록, 회원 탈퇴, 회원 검색) / 문의,바다(문의게시판 내 공지사항, 문의게시판 CRUD, 문의 검색, 추천 및 최신&추천순 정렬, 관리자 문의 답변, 1:1 문의 기능 및 이메일 전송 등 기능 전체), 리뷰, 바다(리뷰게시판 내 공지사항, 나도 한마디 메뉴 CSS, 지역별 실시간 채팅 CRUD, 채팅 신고 기능 등) 담당

 
`홍문선` 

DB 설계 및 ERD 제작 및 관리 / 리뷰,바다(리뷰 게시판 CRUD 및 추천&신고&댓글 기능, 리뷰 작성시 해시태그 드롭다운 및 별점 구현) / 문의,바다(공지이벤트 게시판 UI/UX 디자인 및 기능 이미지 작업) / 로그인(로그인 로직 및 CSS, 시도 횟수 별 반응 설계, 아이디&비밀번호 찾기 페이지 로직 및 CSS) / 마이페이지(북마크, 나의 리뷰 및 문의 보기, 전반적인 기능 및 CSS) 담당

　

# 📝 프로젝트 설계 및 구성

　

## 기획

　

**여행**은 시대를 막론하고 사람들에게 인기 있는 키워드입니다. 특히나 경쟁과 과제에 지친 한국의 현대인들에게 국내 바다 여행은 비교적 쉽게 이룰 수 있는 로망이죠. 팬데믹 이후 여행과 이동이 자유로워지면서, 답답함에 지친 사람들의 여행에 대한 수요가 급증하기도 했고요.

>**"아, 힘든데 바다에 가고 싶다!"**

<바라는 바다!>는 모두가 한 번쯤 느낄 법한 이런 생각에서 출발했습니다. 하지만 바다에 가기 위해 `일기예보`나 `바다 상태`, 해수욕장에 있는 `편의시설` 유무, 사람들의 `리뷰` 등을 일일이 검색해서 찾는 건 제법 불편한 일이죠. 기상정보, 해수욕장 샤워실이 무료인지, 근처에 캠핑장은 있는지를 확인하고 바다에 실제로 다녀온 사람들의 리뷰를 함께 읽을 수 있는 복합 플랫폼이 있다면 얼마나 좋을까요?

그래서 저희는 바다 여행을 계획할 때 유용한 정보를 한 번에 모아 볼 수 있는 웹사이트를 기획하게 되었습니다. <바라는 바다!>는 다양한 곳에서 단편적으로 제공되는 API 정보를 모아 한 번에 제공하는 정보 제공처이자, 동시에 유저 간에 소통을 중계하는 SNS입니다.

　

## 유스케이스 다이어그램

　

![bada_유스케이스다이어그램](https://github.com/doh3e/bada/assets/151860111/ce08a401-c4b9-47c5-8ff8-d76fa08886ea)

　

## 데이터베이스 ERD

　

![ERD](https://github.com/doh3e/bada/assets/151860111/66375dc5-89d8-4140-ab48-783594ef4470)

　

## 사용 기술

　

<div align=left> 

<img src="https://img.shields.io/badge/Java-3766AB?style=flat-square&logo=Java&logoColor=white"/>
<img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=flat-square&logo=javascript&logoColor=black"/>
<img src="https://img.shields.io/badge/Spring-6DB33F?style=flat-square&logo=Spring&logoColor=white"/>
<img src="https://img.shields.io/badge/HTML5-E34F26?style=flat-square&logo=html5&logoColor=white"/>
<img src="https://img.shields.io/badge/CSS3-1572B6?style=flat-square&logo=css3&logoColor=white"/>
<img src="https://img.shields.io/badge/Python-3776AB?style=flat-square&logo=Python&logoColor=white"/>
<img src="https://img.shields.io/badge/jQuery-0769AD?style=flat-square&logo=jQuery&logoColor=white"/>
<img src="https://img.shields.io/badge/JSON-000000?style=flat-square&logo=json&logoColor=white"/>
<img src="https://img.shields.io/badge/ORACLE-F80000?style=flat-square&logo=oracle&logoColor=white"/>
<img src="https://img.shields.io/badge/Apache Tomcat-F8DC75?style=flat-square&logo=apachetomcat&logoColor=black"/>
<img src="https://img.shields.io/badge/Git-F05032?style=flat-square&logo=git&logoColor=white"/>
<img src="https://img.shields.io/badge/GitHub-181717?style=flat-square&logo=GitHub&logoColor=white"/>

</div>
　

<details>
<summary><b> 백엔드</b></summary>
<ul>
  <li>JAVA 11</li>
  <li>Python</li>
  <li>Spring MVC</li>
  <li>JSP</li>
  <li>MyBatis</li>
  <li>AJAX</li>
  <li>JSON</li>
</ul>
</details>

<details>
<summary><b> 프론트엔드</b></summary>
<ul>
  <li>HTML</li>
  <li>CSS</li>
  <li>JavaScript</li>
  <li>JQuery</li>
</ul>
</details>

<details>
<summary><b> DB & WAS</b></summary>
<ul>
  <li>Oracle(Oracle Database 11g Express Edition Release 11.2.0.2.0)</li>
  <li>Tomcat 9(9.0.85)</li>
</ul>
</details>

<details>
<summary><b> API & OpenData</b></summary>
<ul>
  <li><a href="https://www.data.go.kr/data/15084084/openapi.do">기상청_단기예보 ((구)_동네예보) 조회서비스</a></li>
  <li><a href="https://www.data.go.kr/data/15012688/openapi.do)">한국 천문 연구원 출몰시각</a></li>
  <li><a href="https://www.data.go.kr/data/15102239/openapi.do)">기상청 전국 해수욕장 날씨조회 서비스</a></li>
  <li><a href="https://www.data.go.kr/data/15059093/openapi.do">기상청_지상(종관, ASOS) 일자료 조회서비스</a></li>
  <li><a href="https://apis.map.kakao.com">카카오 지도 API</a></li>
  <li><a href="https://developers.google.com/gmail/api/guides?hl=ko">Gmail API</a></li>
</ul>
</details>

<details>
<summary><b> Environment & Tool</b></summary>
<ul>
  <li>Windows 11</li>
  <li>STS(3.9.18)</li>
  <li>Git</li>
  <li>GitHub</li>
  <li>Oracle SQL Developer</li>
</ul>
</details>
　

# 💻 <바라는 바다!> 주요 기능 소개

　

## 메인페이지

　

https://github.com/doh3e/bada/assets/151860111/b9fe01f2-c777-4f97-a768-30ceffe58cc6

　

메인화면에서 `지역 검색`, `유저 맞춤형 바다추천`, `이벤트 배너`, `베스트 리뷰`를 확인할 수 있어요!

　

<div style="display:flex;">
<img src="https://github.com/doh3e/bada/assets/151860111/f97f3cc8-8c5f-42a0-99f8-fefed4e5b036" height="400px">
<img src="https://github.com/doh3e/bada/assets/151860111/3a388067-f89e-4f90-8247-04f00826867c" height="400px">
</div>

　

유저들이 남긴 리뷰의 평균 별점을 바탕으로 기본 추천이 이루어집니다. `위치추천`을 누르면 직선거리로 가장 가까운 바다를 찾을 수도 있어요.

`회원가입`을 한 뒤 BBTI(바다성향 테스트) 를 하면 자신에게 맞는 바다를 추천해준답니다!

　
 
## 회원가입 프로세스

　
### 회원가입

　

회원이 되길 원하시나요? 그렇다면 회원가입을 해보세요!

　

<details>
<summary><b> 회원가입 로직</b></summary>

　

<img src="https://github.com/doh3e/bada/assets/151860111/5e75529d-ab92-491f-acfe-2cf4745c9ce8" width="300px">

　

</details>
　

회원이 되고나면 자신의 바다 여행 성향을 체크하는 BBTI(바다성향테스트)를 할 수 있습니다.

BBTI 테스트는 회원가입 직후의 알림창, 마이페이지, 그리고 이벤트 배너를 통해 하러갈 수 있어요.

회원가입을 완료하면 언제든 로그인해서 자유롭게 사이트를 이용할 수 있습니다.

회원 기능 중 하나인 `마이페이지`를 맛보기로 볼까요?

　

![마이페이지-min](https://github.com/doh3e/bada/assets/151860111/b6c183d5-ecf7-41c2-9ac8-99afd713ceb2)

　

![북마크min](https://github.com/doh3e/bada/assets/151860111/c54b70d3-2c48-4ce2-9ec8-cae72c01409c)

　

`추천,바다!`, `순위,바바!` 페이지나 `리뷰 게시글 보기`, `문의 게시글 보기`, `1:1문의`는 비회원으로도 이용 가능하지만,

리뷰를 작성하거나 댓글을 다는 등 유저와의 상호작용이 필요한 기능은 회원만 이용할 수 있으니 꼭! 가입해주세요!

　

### BBTI(바다성향 테스트)

　

![바라는-바다-발표-PPT_복사본-045](https://github.com/doh3e/bada/assets/151860111/10acd184-8d60-4552-92ba-ac230d880803)

　

BBTI 테스트는 총 9가지의 질문으로 구성되어있고, 이를 통해 8가지의 결과를 도출합니다. 결과지를 보고 선택하고 싶다면 직접 고를수도, 성향이 바뀌면 다시 선택할 수도 있어요.

여러분에게 맞는 성향을 골라 맞춤형 바다 추천을 받아보세요!

　

## 추천, 바다!

　

### 해수욕장 정보 확인

　

원하는 지역의 해수욕장을 추천받고, 해수욕장 정보와 날씨를 확인해보세요!

　

![바다리절트](https://github.com/doh3e/bada/assets/151860111/a9e16973-a670-4bf9-bae2-05ac1db9c173)

　

지역을 선택하면 인기 있는 해수욕장 리스트가 나오고, 클릭 시 결과 화면으로 이동합니다.

결과 화면에서는 `해수욕장 정보`, `편의시설`, `주변 특징`, `현재 시간의 기상정보`를 볼 수 있습니다.

`자세히 보기`를 누르면 기상 정보에 대해 좀 더 자세히 알 수 있답니다.

　

![날씨_정보_상세_페이지](https://github.com/doh3e/bada/assets/151860111/9815162f-a4e2-44a8-9592-4f0aa03781a9)


　
 
## 순위, 바바!

　

사람들이 많이 찾은 바다, 별점이 높은 바다 등을 확인해보고 싶다면, `순위,바바!` 페이지를 확인해보세요.

바다 이미지를 클릭하면 해당 바다의 정보를 보러 이동합니다.

　

![순위_바다_gif](https://github.com/doh3e/bada/assets/151860111/b253def5-8c8c-417b-9c82-3d5d59469eff)

　
 
## 리뷰, 바다!

　

리뷰 페이지에서 사람들이 남긴 리뷰를 확인해보고 바다 여행을 계획하세요!

다녀온 바다의 리뷰를 작성하거나 `나도 한마디`에서 실시간으로 바다가 어떤지를 이야기하며 다른 사람들에게 도움을 줄 수도 있습니다.

　

![바라는 바다 _ 바다리뷰 페이지 - Chrome 2024-05-28 11-25-27 (online-video-cutter com)-min](https://github.com/doh3e/bada/assets/151860111/cadbffae-f251-4651-bb9b-4121f54ce9a7)

　

![정지수2](https://github.com/doh3e/bada/assets/151860111/f86ffab3-92db-4108-aab9-9c91ece67ce5)

　
 
## 문의, 바다!

　

관리자에게 전할 사항, 바다 추가 건의, 버그 리포트 등은 `문의 게시판`을 활용해보세요.

문의를 남기면 관리자가 확인 후 답변을 남겨드려요. 공개 문의는 사람들의 추천을 받을 수도, 신고를 받을 수도 있습니다.

　

![정지수7(문의추천,신고)_저화질](https://github.com/doh3e/bada/assets/151860111/b6ea5206-941d-4d36-a0e6-513e74f7dbe6)


　

혹시 개인정보와 같은 민감한 문제를 문의해야하나요? 그렇다면 `1:1 문의`를 통해 관리자에게 메일을 남길 수 있습니다.

로그인이 안되더라도 입력해둔 메일로 답변이 발송되니 걱정하지 마세요!

　
　
![정지수9(1대1문의남기기)](https://github.com/doh3e/bada/assets/151860111/8db28988-3209-4b79-9a2d-5fc3d77feafa)

　

## 관리자 모드

　

`관리자`는 admin이라는 아이디와 관리자라는 고유의 역할을 가집니다.

관리자가 할 수 있는 건 아래와 같아요.

　

<details>
<summary><b> 회원관리</b></summary>

　

회원 정보를 직접 입력하거나, 회원 목록에서 회원 정보 상세 보기, 수정 및 삭제를 할 수 있습니다.

　

![정지수12](https://github.com/doh3e/bada/assets/151860111/018f28b5-f93f-487f-9b0d-746d0cf2b3b9)

　

</details>

<details>
<summary><b> 문의관리</b></summary>

　

문의게시판에서 답변을 입력할 수 있고, 신고 들어온 내역을 확인할 수 있습니다.

　

![정지수8](https://github.com/doh3e/bada/assets/151860111/324950f2-d219-4ac1-8293-e890fb4a68f9)

　

1:1문의의 답변을 사이트 내 혹은 메일에서 할 수 있습니다.

　

![정지수10](https://github.com/doh3e/bada/assets/151860111/3f6222f4-036f-408f-93ad-6cf75af6368e)

　

</details>

<details>
<summary><b> 신고관리</b></summary>

　

관리자 로그인 시 리뷰/문의 드롭다운에 각각 `신고 내역 확인` 메뉴가 생성됩니다.

신고 내용 확인 후, 제재가 필요한 회원을 회원목록에서 삭제, 수정하는 등의 조치를 취할 수 있습니다.

　

</details>

　

# 🔎 좀 더 자세히 보고 싶으신가요?

　

<a href="https://docs.google.com/presentation/d/12K6poj45OPdaOykqcQhr6_QJjT9HOxp4/edit?usp=sharing&ouid=115614281961147788111&rtpof=true&sd=true">이곳을 클릭하시면 프레젠테이션을 열람하고 다운로드 할 수 있습니다!</a>




  
