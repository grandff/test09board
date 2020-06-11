package com.kjm.board.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kjm.board.model.RequestVO;
import com.kjm.board.model.TestDAO;

//@Component
@Service			// TestService는 연결 역할을 하므로 service로 어노테이션을 선언하는게 좋음
public class TestService {

	@Autowired	
	private TestDAO dao;
	
	public int insert(RequestVO vo) {
		return dao.insert(vo);
	}
	
	public RequestVO selectOne(RequestVO vo) {
		return dao.selectOne(vo);
	}
	
	public ArrayList<RequestVO> selectAll(){
		return dao.selectAll();
	}
	
	public ArrayList<RequestVO> searchList(HashMap<String, String> map){
		return dao.searchList(map);
	}

	public int delete(RequestVO vo) {
		return dao.delete(vo);
	}

	public int update(RequestVO vo) {
		return dao.update(vo);
	}

}
