package controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.ProductService;
import vo.ProductVO;

@Controller
public class ProductController {
	public static final String VIEW_PATH = "/WEB-INF/views/product/";
	private ProductService service;
	
	public void setService(ProductService service) {
		this.service = service;
	}
	
	@RequestMapping(value = {"/", "list"})
	public String list(Model model) {
		
		Map map = service.selectList();
		model.addAttribute("map",map);
		
		return VIEW_PATH + "product_list.jsp";
	} // list()
	
	@RequestMapping("/insert_in")
	public String insert_in(ProductVO vo) {
		try {
			int res = service.insert_in(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:list";
	} // insert_in()
	
	@RequestMapping("/insert_out")
	public String insert_out(ProductVO vo, Model model) {
		try {
			int res = service.insert_out(vo);
		} catch (Exception e) {
			e.printStackTrace();
			String msg = e.getMessage();
			
			if(msg.contains("remain_not")) {
				model.addAttribute("error", "remain_not");
			}
			
			if(msg.contains("remain_lack")) {
				model.addAttribute("error", "remain_lack");
			}
			
			// redirect:list를 해뒀기때문에
			// list?error=remain_not과 같이 파라미터로 넘어간다.
		}
		return "redirect:list";
	} // insert_out()
}
