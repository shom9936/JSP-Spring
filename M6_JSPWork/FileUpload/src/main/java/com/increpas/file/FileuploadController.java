package com.increpas.file;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import vo.PhotoVO;
import vo.PhotoVO2;

@Controller
public class FileuploadController {
	public static final String VIEW_PATH = "/WEB-INF/views/";
	
	// Aurowired - 자동 주입
	// - 파라미터로 객체를 받을 필요 없이 자동으로 주입시켜주는 기능
	@Autowired
	ServletContext application;
	
	// 폼 띄우기
	@RequestMapping(value= {"/","/form"})
	public String form() {
		return VIEW_PATH + "form2.jsp";
	}
	
	@RequestMapping("/upload")
	public String upload(PhotoVO vo, Model model) {
		String webPath = "/resources/upload/";// 저장시킬 경로
		
		//절대 경로
		String savePath = application.getRealPath(webPath);
		System.out.println(savePath);
		
		MultipartFile photo = vo.getPhoto();
		
		String filename = "no File";
		
		// 업로드 된 파일이 있으면
		if(!photo.isEmpty()) {
			// 업로드 된 실제 파일 명
			filename = photo.getOriginalFilename();
			
			File saveFile = new File(savePath, filename);
			
			if(!saveFile.exists()) {
				saveFile.mkdirs();
			} else {
				// 동일한 파일 명이 존재하면, 업로드된 시간을 붙여서 중복 방지
				filename = String.format("%d_%s", System.currentTimeMillis(),filename);
				saveFile = new File(savePath, filename);
			}
			
			// 업로드된 파일은 MultipartResolver가 지정한 임시 저장소에 있다.
			// 임시 저장소에 있는 파일은 일정 시간이 지나면 사라진다.
			// 내가 지정한 경로로 복사를 해주어야 된다.
			
			try {
				photo.transferTo(saveFile);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		vo.setFilename(filename);
		model.addAttribute("vo", vo);
		
		return VIEW_PATH + "result.jsp";
	}
	
	@RequestMapping("/upload2")
	public String upload2(PhotoVO2 vo, Model model) throws IllegalStateException, IOException {
		
		String webPath = "/resources/upload";
		String savePath = application.getRealPath(webPath);
		
		MultipartFile[] photo_array = vo.getPhoto();
		
		for(int i = 0; i<photo_array.length; i++) {
			MultipartFile photo = photo_array[i];
			
			String filename="no_file";
			
			if(!photo.isEmpty()) {
				filename = photo.getOriginalFilename();
				
				File saveFile = new File(savePath, filename);
				
				if(!saveFile.exists()) {
					saveFile.mkdirs();
				} else {
					filename = String.format("%d_%s", System.currentTimeMillis(), filename);
					saveFile = new File(savePath, filename);
				}
				
				photo.transferTo(saveFile);
			}
			
			if(i==0) {
				vo.setFilename1(filename);
			} else if(i==1) {
				vo.setFilename2(filename);
			}
		}
		
		model.addAttribute("vo", vo);
		
		return VIEW_PATH + "result2.jsp";
	}
	
}
