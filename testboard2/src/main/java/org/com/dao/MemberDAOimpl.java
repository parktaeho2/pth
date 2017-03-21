package org.com.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.com.vo.BoardVO;
import org.com.vo.MemberVo;
import org.springframework.stereotype.Repository;


@Repository
public class MemberDAOimpl implements MemberDAO {
	
	@Inject
	private SqlSession sqlSession;


	

	@Override
	public void insertMemeber(MemberVo vo) {
		
	}



	@Override
	public void seqreset() throws Exception {
		this.sqlSession.insert("Member.seqprocedure");
	}



	@Override
	public void create(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}



	@Override
	public BoardVO read(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void update(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void delete(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		
	}



	@Override
	public List<BoardVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
		
		
	}
	
	
	
	
	
	
	
	

}
