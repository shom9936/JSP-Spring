package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import service.VisitService;
import vo.VisitVO;

@Controller
public class VisitController {
	
	@Autowired
	ServletContext application;
	@Autowired
	HttpServletRequest request;
	
	public static final String VIEW_PATH = "/WEB-INF/views/visit/";
	private VisitService visitService;
	
	public VisitController(VisitService visitService) {
		this.visitService = visitService;
	}
	
	@RequestMapping(value={"/","/list"})
	public String home(Model model) {
		List<VisitVO> list = visitService.selectList();
		model.addAttribute("list", list);
		return VIEW_PATH + "visitHome.jsp";
	}
	
	@RequestMapping("/writeForm")
	public String writeForm() {
		return VIEW_PATH + "visitWriteForm.jsp";
	}
	
	@RequestMapping("/write")
	public String write(VisitVO vo) {
		
		String ip = request.getRemoteAddr();
		String content = vo.getContent().replaceAll("\n", "<br>");
		
		vo.setContent(content);
		vo.setIp(ip);
		
		String webPath = "/resources/upload";
		String savePath = application.getRealPath(webPath);
		
		MultipartFile[] photo_array = vo.getPhoto();
		
		for(int i=0; i<photo_array.length; i++) {
			MultipartFile photo = photo_array[i];
			String filename = "no_file";
			if(!photo.isEmpty()) {
				
				filename = photo.getOriginalFilename();
				File saveFile = new File(savePath, filename);
				
				if(!saveFile.exists()) {
					saveFile.mkdirs();
				} else {
					filename = String.format("%d_%s", System.currentTimeMillis(),filename);
					saveFile = new File(savePath, filename);
				}
				
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
			if(i==0) {
				vo.setFilename1(filename);
			} else if(i==1) {
				vo.setFilename2(filename);
			}
		}
		
		int num = visitService.insert(vo);
		
		if(num != 0 ) {
			return "redirect:list";
		} else {
			return VIEW_PATH + "visitWriteForm.jsp";
		}
			
	} // write()
	
	@RequestMapping("/modifyForm")
	public String modifyForm(int idx, String pwd, Model model) {
		VisitVO vo = visitService.selectOne(idx);
		String content = vo.getContent().replaceAll("<br>", "\n");
		vo.setContent(content);
		model.addAttribute("vo", vo);
		return VIEW_PATH + "visitModifyForm.jsp";
	}
	
	@RequestMapping("/modify")
	public String modify(VisitVO vo) throws IllegalStateException, IOException {
		
		String ip = request.getRemoteAddr();
		String content = vo.getContent().replaceAll("\n", "<br>");
		vo.setContent(content);
		vo.setIp(ip);
		
		String webPath = "/resources/upload";
		String savePath = application.getRealPath(webPath);
		
		MultipartFile[] photo_array = vo.getPhoto();
		
		for(int i=0; i<photo_array.length; i++) {
			MultipartFile photo = photo_array[i];
			String filename = "no_file";
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
		
		visitService.update(vo);
		
		return "redirect:list";
	}// modify()
	
	@RequestMapping("/delete")
	public String delete(VisitVO vo) {
		System.out.println(vo.getIdx());
		visitService.delete(vo.getIdx());
		return "redirect:list";
	}
	
	@RequestMapping("/deleteAjax")
	@ResponseBody // return 값을 view로 인식하지말고 바로 클라이언트로 응답하라. Ajax를 위한 작업
	public String deleteAjax(int idx) {
		return visitService.deleteAjax(idx);
	}
	
	@RequestMapping("/modifyAjax")
	@ResponseBody
	public String modifyAjax(VisitVO vo) {
		vo.setIp(request.getRemoteAddr());
		String content = vo.getContent().replaceAll("\n", "<br>");
		vo.setContent(content);
		
		return visitService.updateAjax(vo);
	}
}
















