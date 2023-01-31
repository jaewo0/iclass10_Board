-- 다른 기능들 SQL : dao 메소드, mapper XML(community.xml)의 id 이름 동일하게 정해보겠습니다.
-- 참고 count(*) 함수의 SQL문 resultType은 int형

-- 전체 글의 갯수 : *count*
SELECT count(*) FROM COMMUNITY ;

-- 메인글 idx (3번)의 글
SELECT * FROM community f WHERE idx=3;
-- *comments*
SELECT * FROM communityComments c WHERE mref=3;		-- 메인 3번글의 댓글 목록

-- *setReadCount*
UPDATE COMMUNITY 
SET readcount = readcount +1
WHERE idx =3;		--조회수 업데이트(증가)

-- 메인글 idx (3번의) 댓글 갯수 : *commentsCount*
SELECT count(*) FROM COMMUNITYCOMMENTS c WHERE mref=3;

-- 댓글 개수 업데이트(댓글 추가, 삭제 할때 모두 필요함) : *setCommentCount*
UPDATE COMMUNITY 
SET COMMENTCOUNT  =
	(SELECT count(*) FROM COMMUNITYCOMMENTS c WHERE mref=3)
WHERE idx = 3;

-- 댓글 idx의 삭제
DELETE FROM COMMUNITYCOMMENTS c WHERE idx=2;
