### 개발환경
<p>Java 11 / SpringBoot 2.7.6 / Gradle 7.5 </p>
<p>Mybatis</p>
MVC 패턴
model - mapper  - service - web

### 구조
<ul>
	<li>base : 기본포맷</li>
	<li>cmm : 공통
	  <ul>
		  <li>ㄴ AuthGrant : 권한부여</li>
		  <li>ㄴ AuthName : 권한명</li>
		  <li>ㄴ AuthRole : 권한롤</li>
		  <li>ㄴ Code : 공통코드</li>
		  <li>ㄴ Menu : 메뉴</li>
		  <li>ㄴ User : 사용자</li>
	  </ul>
	</li>
	<li>cms : 컨텐츠 관리
	  <ul>
	  	<li>ㄴ Template : 템플릿 </li>
	  </ul>
	</li>
	<li>cntnt : 컨텐츠
	  <ul>
		  <li>ㄴ Banner : 배너 </li>
		  <li>ㄴ Board : 게시판 </li>
		  <li>ㄴ Chart : 차트 </li>
	  </ul>
	</li>
</ul>


# TODO 
1. 회원가입
2. 로그인 (Spring-security, jwt)
3. 세션유지
4. 권한