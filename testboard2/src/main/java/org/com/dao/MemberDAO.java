package org.com.dao;

import java.util.List;

import org.com.vo.BoardVO;
import org.com.vo.MemberVo;

public interface MemberDAO {
public void insertMemeber(MemberVo vo);
public void create(BoardVO vo)throws Exception;
public BoardVO read(Integer bno)throws Exception;
public void update(BoardVO vo)throws Exception;
public void delete(Integer bno)throws Exception;
public List<BoardVO> listAll() throws Exception;
public void seqreset() throws Exception;
}
