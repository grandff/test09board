package com.kjm.board.controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.kjm.board.model.RequestVO;
import com.kjm.board.service.TestService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class RequestController {	
	private static final Logger logger = LoggerFactory.getLogger(RequestController.class);

	@Autowired
	private TestService ts;	
	
	@Autowired
	ServletContext sContext;
	
	// 등록 페이지 이동
	@RequestMapping(value = "/insert.do", method = RequestMethod.GET)
	public String insertPage(@ModelAttribute("searchVO")  RequestVO vo, Model model) {
		
		logger.info("insert on {}", vo.getNum());
		
		if(vo.getNum() > 0) {
			RequestVO requestVO = ts.selectOne(vo);
			requestVO.setSearchKey(vo.getSearchKey());
			requestVO.setSearchWord(vo.getSearchWord());
			model.addAttribute("searchVO", requestVO);		
			model.addAttribute("mode", "update");
		}else {
			model.addAttribute("mode", "insert");
		}
						
		return "/jsp/form";
	}
	
	// 등록 액션
	@SuppressWarnings("finally")
	@RequestMapping(value = "/insertOK.do", method = RequestMethod.POST)		
	public String insertOK(@ModelAttribute("searchVO") RequestVO vo) {			// 바로 vo를 입력해줌
		logger.info("insertOK on");
		
		MultipartFile multipartFile = vo.getMultipartFile();
		String imgName = "";
		String realPath = "";

		int result = 0;						
		try {
			if(multipartFile != null) {
				imgName = multipartFile.getOriginalFilename();
				vo.setImgName(imgName);
				vo.setFileName(imgName);				
				
				// 해당 폴더의 실제 경로 획득(서버가 인식하는 경로)
				realPath = sContext.getRealPath("resources/uploadimg");
				
				// 폴더경로 + 파일명
				File origin_img = new File(realPath + "\\" + imgName);
				multipartFile.transferTo(origin_img);
				
				// 썸네일 이미지 저장
				BufferedImage original_buffer_img = ImageIO.read(origin_img);
				BufferedImage thumb_buffer_img = new BufferedImage(100, 100, BufferedImage.TYPE_3BYTE_BGR);

				Graphics2D graphic = thumb_buffer_img.createGraphics();
				graphic.drawImage(original_buffer_img, 0, 0, 100, 100, null);

				File thumb_file = new File(realPath + "/thumb_" + imgName);
				ImageIO.write(thumb_buffer_img, "jpg", thumb_file);
			}	
			
			result = ts.insert(vo);			
		}catch(NullPointerException e) {
			
		}catch(IndexOutOfBoundsException e) {
			
		}catch(IllegalStateException e) {
			
		}catch(IOException e) {
			
		}catch(Exception e) {
			logger.info(e.toString());
			e.printStackTrace();
		}finally {
			if(result == 1) return "redirect:selectAll.do";
			else return "redirect:insert.do";
		}	
	}
	
	// 목록 페이지 이동
	@RequestMapping(value = "/selectAll.do", method = RequestMethod.GET)
	public String selectPage(@ModelAttribute("searchVO")  RequestVO vo, Model model) {
		logger.info("select on");
		
		try {
			ArrayList<RequestVO> list = ts.selectAll();
			model.addAttribute("list", list);
		}catch(Exception e) {
			logger.info("test !! " + e.toString());
		}
		
						
		return "/jsp/list";
	}
	
	// 상세보기
	@RequestMapping(value = "/selectOne.do", method = RequestMethod.POST)
	public String selectOne(@ModelAttribute("searchVO")  RequestVO vo, Model model) {						
						
		RequestVO requestVO = ts.selectOne(vo);
		requestVO.setSearchKey(vo.getSearchKey());
		requestVO.setSearchWord(vo.getSearchWord());
		requestVO.setContent(requestVO.getContent().replaceAll("\r\n", "<br>"));
		
		try {												
			model.addAttribute("model", requestVO);			
		}catch(NullPointerException e1) {
			
		}catch(Exception e) {
			
		}				
						
		return "/jsp/view";		
	}
	
	@RequestMapping(value = "/search.do", method = RequestMethod.POST)
	public String search(Model model, RequestVO vo, String searchKey, String searchWord) {
		logger.info("select on");
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("searchKey", vo.getSearchKey());
		map.put("searchWord", vo.getSearchWord());
		
		ArrayList<RequestVO> list = ts.searchList(map);
		logger.info("select on !!!! {} " , list.size());
		model.addAttribute("list", list);
						
		return "/jsp/list";
	}
	
	@RequestMapping(value = "/deleteOK.do", method = RequestMethod.GET)		
	public String deleteOK(RequestVO vo) {			
		logger.info("deleteOK on");
		
		int result = ts.delete(vo);						
		try {						
						
		}catch(NullPointerException e) {
			
		}catch(IndexOutOfBoundsException e) {
			
		}catch(Exception e) {
			
		}finally {
			
		}	
		
		if(result == 1) return "redirect:selectAll.do";
		else return "redirect:insert.do";
	}
	
	@RequestMapping(value = "/updateOK.do", method = RequestMethod.POST)		
	public String updateOK(@ModelAttribute("searchVO") RequestVO vo) {			
		logger.info("updateOK on");
		logger.info("vo :: {}", vo);					
		int result = 0;						
		MultipartFile multipartFile = vo.getMultipartFile();
		String imgName = "";
		String realPath = "";
		try {		
			
			if(vo.getFileName() != null) {
				imgName = multipartFile.getOriginalFilename();
				vo.setImgName(imgName);
				vo.setFileName(imgName);				
				
				// 해당 폴더의 실제 경로 획득(서버가 인식하는 경로)
				realPath = sContext.getRealPath("resources/uploadimg");
				
				// 폴더경로 + 파일명
				File origin_img = new File(realPath + "\\" + imgName);
				multipartFile.transferTo(origin_img);
				
				// 썸네일 이미지 저장
				BufferedImage original_buffer_img = ImageIO.read(origin_img);
				BufferedImage thumb_buffer_img = new BufferedImage(100, 100, BufferedImage.TYPE_3BYTE_BGR);

				Graphics2D graphic = thumb_buffer_img.createGraphics();
				graphic.drawImage(original_buffer_img, 0, 0, 100, 100, null);

				File thumb_file = new File(realPath + "/thumb_" + imgName);
				ImageIO.write(thumb_buffer_img, "jpg", thumb_file);
			}
			
			result = ts.update(vo);
			
		}catch(NullPointerException e) {
			
		}catch(IndexOutOfBoundsException e) {
			
		}catch(Exception e) {
			
		}finally {
			
		}	
		
		if(result == 1) return "redirect:selectAll.do";
		else return "redirect:insert.do";
	}
	
}
