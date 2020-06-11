package com.kjm.board.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//@Component
@Repository		// imple안에 주요 기능들이 있으므로 Repository 어노테이션을 사용하는게 더 좋음
public class TestDAOimpl implements TestDAO {
	private static final Logger logger = LoggerFactory.getLogger(TestDAOimpl.class);
	
	@Autowired
	SqlSession sqlsession;
	
	public TestDAOimpl() {
	
	}
	
	@Override
	public int insert(RequestVO vo) {
		logger.info("insert() ... vo : {} ", vo);
		
		int result = 0;
		result = sqlsession.insert("insert", vo);							
		
		return result;
	}

	@Override
	public RequestVO selectOne(RequestVO vo) {
		logger.info("selectOne() ... vo : {} ", vo);
		
		RequestVO reqVO = sqlsession.selectOne("searchOne", vo);				
		
		return reqVO;
	}

	@Override
	public ArrayList<RequestVO> selectAll() {
		logger.info("selectAll() ... ");
		
		List<RequestVO> list = null;
		
		try {
			list = sqlsession.selectList("selectAll");
		}catch(Exception e) {
			logger.info("select all error :: " + e.toString());
		}
				
		
		return (ArrayList<RequestVO>) list;
	}

	@Override
	public int delete(RequestVO vo) {
		logger.info("delete() ... vo : {} ", vo);
		int result = sqlsession.delete("delete", vo);		
		
		return result;
	}

	@Override
	public int update(RequestVO vo) {
		logger.info("update() ... vo : {} ", vo);
		
		int result = sqlsession.update("update", vo);
		
		return result;
	}


	@Override
	public ArrayList<RequestVO> searchList(HashMap<String, String> map) {
		logger.info("searchList amp() ... vo ");
		logger.info("test 1 ::  " + map.get("searchKey"));
		logger.info("test 2 ::  " + map.get("searchWord"));
		
		List<RequestVO> list = sqlsession.selectList("searchList", map);
		logger.info("111 {}", list );
		
		return (ArrayList<RequestVO>) list;
	}

}
