package com.kjm.board.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.kjm.board.controller.HomeController;

public class RequestVO {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	public RequestVO() {
		//logger.info("requestVO on");
	}
	
	private int num;
	private String name = "";
	private String title;
	private String content;
	private String writer;
	private String regDate;
	private String fileName;	
	
	private String searchKey = "";
	private String searchWord = "";
	
	private String imgName = "";
	private MultipartFile multipartFile = null;
	
	

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public MultipartFile getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	
	
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	@Override
	public String toString() {
		return "RequestVO [num=" + num + ", name=" + name + ", title=" + title + ", content=" + content + ", writer="
				+ writer + ", regDate=" + regDate + ", fileName=" + fileName + ", searchKey=" + searchKey
				+ ", searchWord=" + searchWord + ", imgName=" + imgName + ", multipartFile=" + multipartFile + "]";
	}	
	
}
