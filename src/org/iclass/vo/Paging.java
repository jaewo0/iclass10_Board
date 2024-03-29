package org.iclass.vo;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Paging {
	private int currentPage;		//현재 페이지
	private int totalCount;			//글의 전체 갯수
	private int pageSize;			//한개페이지에 보여줄 글 갯수
	
	private int totalPage;			//전체 페이지 갯수

	private int startNo;			//화면에 보인는 글목록의 시작 rownum
	private int endNo;				//화면에 보인는 글목록의 마지막 rownum

	private int startPage;			//화면에 보이는 페이지목록의 시작페이지	
	private int endPage;			//화면에 보이는 페이지목록의 마지막페이지	. 
	
	//생성자에서 3가지 값을 받아 나머지 필드값을 계산합니다.
	public Paging(int currentPage, int totalCount, int pageSize) {   //외부(비지니스로직)에서 결정하고 전달되는값.
		this.totalCount=totalCount;
		this.pageSize=pageSize;
		
		//예시
		//totalCount = 367개이다. 그러면, pageSize=20 일 떄 totalPage =19  , pageSize=10 일 떄 totalPage =37
		//totalCount = 7개이다. 그러면, pageSize=20 일 떄 totalPage =1 , pageSize=10 일 떄 totalPage =1
		//totalCount = 200개이다. 그러면, pageSize=20 일 떄 totalPage =10 ,  pageSize=10 일 떄 totalPage =20
		totalPage = (int)Math.ceil((double)totalCount/pageSize); //ceil 은 올림입니다.
		//현재페이지 범위(1~totalPage) 의 유효성을 체크 
		this.currentPage= (currentPage > totalPage)? totalPage:currentPage;
		this.currentPage= (currentPage < 1)? 1:this.currentPage;
		
		//이 부분이 제일 복잡합니다. 현재 페이지 currentPage 를 1,2,3,4,5 ... 등등으로 대입해서 계산해보세요.
		startNo=(this.currentPage-1)*pageSize+1;
		endNo = startNo + (pageSize-1);
		
		//아래 예시값을 대입해 보세요.
		startPage = (this.currentPage-1)/10*10+1;		 //페이지번호 리스트 10개씩 
		//현재 페이지가 57 , startPage =51
		//현재 페이지가 7 , startPage =1
		//현재 페이지가 156 , startPage =151
		//현재 페이지가 160 , startPage =151
		endPage = startPage+9;
		endPage = endPage > totalPage ? totalPage:endPage;   //totalPage 보다 큰값에 대한 제한.
	}
}