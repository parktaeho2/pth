package org.com.web;

import java.util.List;

import javax.inject.Inject;

import org.com.dao.BoardDAO;
import org.com.vo.BoardVO;
import org.com.vo.Criteria;
import org.com.vo.SearchCriteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.mysql.jdbc.log.Log;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberDaoTest {
	
	@Inject
	//private MemberDAO dao;
	private BoardDAO boarddao;
	
	@Test
	public void testTime() throws Exception{
	}
	
	@Test
	public void testInsertMember() throws Exception{
	/*	BoardVO board= new BoardVO();
		board.setTitle("새로운글을 넣습니다.");
		board.setContent("새로운 글을 넣습니다.");
		board.setWriter("user00");
		boarddao.create(board);*/
		
	/*	MemberVo vo =new MemberVo();
		vo.setUserid("user16");
		vo.setUserpw("user00");
		vo.setUsername("USER00");
		vo.setEmail("인천광역시 동구 숭의2동 295-1 (동일종동합목재동)");
		dao.insertMemeber(vo);*/
		//dao.seqreset();
		
		/*Criteria criteria=new Criteria();
		criteria.setPage(2);
		criteria.setPerPageNum(20);
		List<BoardVO> list =boarddao.listCriteria(criteria);
		
		for(BoardVO boardVO : list){
			System.out.println(boardVO.getBno());
		}*/
		
/*		UriComponents uriComponets=l
				UriComponentsBuilder.newInstance()
				.path("/board/read")
				.queryParam("bno",12)
				.queryParam("perPageNum", 20)
				.build();
		System.out.println("/board/read?bno=12&perPageNum=20");
		System.out.println(uriComponets.toString());*/
		
		
		SearchCriteria cri=new SearchCriteria();
		cri.setPage(1);
		cri.setKeyword("글이다");
		cri.setSearchType("t");
		
		System.out.println("=======================");
		List<BoardVO> list= boarddao.listSearch(cri);
		
		for(BoardVO boardvo : list){
			System.out.println(boardvo.getBno() + ":" + boardvo.getTitle());
		}
		
		System.out.println("===================");
		System.out.println("count:" + boarddao.listSearchCount(cri));
	}

}
