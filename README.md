# Algorithm

## 파일 명명 규칙

[사이트 이름][문제 번호]_[문제 이름]

ex. SWEA1208_Flatten

* 사이트 별 약어
  * BOJ : 백준 온라인 저지
  * SWEA : SW Expert Academy
  * JO : 정올
  * PROG : 프로그래머스
  
## 커밋 메시지 규칙

문제푼날짜 사이트이름 문제번호 문제이름[난이도]

ex. 200802 SWEA 1208 Flatten[D3]

## 파일 경로
Algorithm / '알고리뷰날짜' / '자기 브랜치 이름 or 알아서' / 알고리즘 java 파일들

ex. Algorithm / 200817 / Dawoon / BOJ_2178_미로탐색

알고리즘 리뷰날짜 전까지 다 풀고 commit & push & merge 까지!!

## 명령어 정보

* 커밋할 때
	```vim
    git add .  or git add 파일이름
    git commit -m "커밋메세지"
    git push
	```
 
* 브랜치 생성
	```vim
    git branch 브랜치 이름
	```
 
* 브랜치로 이동 or 마스터로 이동
	```vim
    git checkout 브랜치 이름  or git checkout master
	
	브랜치를 생성하고 생성한 브랜치로 이동(-b 옵션 사용)
	git checkout -b 브랜치 이름
	```
	
* 브랜치 삭제

    git branch -d 브랜치 이름
 
* master에 머지

	```vim
    git checkout master 한 뒤에 
    git merge 브랜치 이름
	```
 
* 또 새로운 주 알고리즘 풀이를 시작하면 
	1. `git checkout 브랜치` 로 내 브랜치로 이동한 다음
	2. `git pull origin master` 로 내 브랜치와 master 브랜치 동기화
	3. 작업 시작
 
