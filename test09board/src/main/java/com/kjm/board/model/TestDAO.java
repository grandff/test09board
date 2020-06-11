package com.kjm.board.model;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Qualifier;


@Qualifier("proxyBean")		// proxyBean 연결
public interface TestDAO {
	public int insert(RequestVO vo);
	public RequestVO selectOne(RequestVO vo);
	public ArrayList<RequestVO> selectAll();
	public int delete(RequestVO vo);
	public int update(RequestVO vo);
	public ArrayList<RequestVO> searchList(HashMap<String, String> map);
}
