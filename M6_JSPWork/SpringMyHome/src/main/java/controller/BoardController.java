package controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import service.BoardService;
import service.CommentService;
import service.MemberService;
import vo.BoardRecommendVO;
import vo.BoardVO;
import vo.CommentRecommendVO;
import vo.CommentVO;
import vo.MemberVO;

@Controller
public class BoardController {
	@Autowired
	ServletContext application;
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpSession session;
	
	private static final String VIEW_PATH = "/WEB-INF/views/board/";
	private BoardService boardService;
	private MemberService memberService;
	private CommentService commentService;
	
	public BoardController(BoardService boardService, MemberService memberService, CommentService commentService) {
		this.boardService = boardService;
		this.memberService = memberService;
		this.commentService = commentService;
	}
	
	@RequestMapping(value={"/", "/index"})
	public String index(Model model) {
		List<BoardVO> list = boardService.selectPopular();
		model.addAttribute("list", list);
		model.addAttribute("li_index", "current");
		return "/WEB-INF/views/myHome/index.jsp";
	} // index()
	
	@RequestMapping("/list")
	public String list(Model model) {
		int start = 0; 
		if(request.getParameter("start") != null) {
			start = Integer.parseInt(request.getParameter("start"));
		}
		List<BoardVO> list = boardService.selectList( start );
		int total = boardService.getTotal();
		int nowPage = start/5 + 1;
		
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String time = now.format(formatter);
		
		for(BoardVO vo : list) {
			String logtime = vo.getLogtime();
			if(logtime.substring(0, 10).equals(time)) {
				vo.setLogtime(logtime.substring(11));
			} else {
				vo.setLogtime(time);
			}
		}
		
		model.addAttribute("list", list);
		session.setAttribute("start", start);
		model.addAttribute("total", total);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("li_list", "current");
		return VIEW_PATH + "list.jsp";
	} // list()
	
	@RequestMapping("/write")
	public String write(Model model) {
		model.addAttribute("li_list", "current");
		return VIEW_PATH + "write.jsp";
	} // write()
	
	@RequestMapping("/boardInsert")
	public String boardInsert(BoardVO boardVO, Model model) throws IllegalStateException, IOException {
		MemberVO memberVO = memberService.selectOne((String) session.getAttribute("login"));
		boardVO.setId(memberVO.getId());
		boardVO.setName(memberVO.getName());
		String content = boardVO.getContent().replace("\n", "<br>");
		boardVO.setContent(content);
		
		
		String webPath = "/resources/upload";
		String savePath = application.getRealPath(webPath);
		
		MultipartFile photo = boardVO.getPhoto();
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
		
		boardVO.setFilename(filename);
		boardService.insert(boardVO);
		model.addAttribute("li_list", "current");
		return "redirect:list";
	} // boardInsert()
	
	@RequestMapping("/view")
	public String view(Model model) {
		int seq = Integer.parseInt(request.getParameter("seq"));
		boardService.updateHit(seq);
		BoardVO boardVO = boardService.selectOne(seq);
		List<CommentVO> list = commentService.selectList(boardVO.getSeq());
		boolean isEmpty = list.isEmpty();
		model.addAttribute("isEmpty", isEmpty);
		model.addAttribute("boardVO", boardVO);
		model.addAttribute("list", list);
		model.addAttribute("cnt", list.size());
		model.addAttribute("li_list", "current");
		return VIEW_PATH + "view.jsp";
	} // view()
	
	@RequestMapping("/fileDownload")
	public String fileDownload(Model model, HttpServletResponse response) throws IOException {
		String filename = request.getParameter("filename");
		String folder =application.getRealPath("/resources/upload");
		
		File file = new File(folder,filename);
		
		filename = "attachment;filename=" + new String(URLEncoder.encode(filename, "UTF-8")).replace("//+", " ");
		response.setHeader("Content-Disposition", filename);
		response.setHeader("Content-Length", file.length()+"");
		
		
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
		
		byte[] b = new byte[(int)file.length()];
		bis.read(b, 0, b.length);
		bos.write(b);
		
		bis.close();
		bos.close();
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		model.addAttribute("seq", seq);
		return VIEW_PATH + "view?seq=" + seq;
	} // fileDownload
	
	@RequestMapping("/boardModify")
	public String boardModify(Model model) {
		BoardVO boardVO = boardService.selectOne(Integer.parseInt(request.getParameter("seq")));
		model.addAttribute("boardVO", boardVO);
		model.addAttribute("li_list", "current");
		return VIEW_PATH + "modify.jsp";
	} // boardModify()
	
	@RequestMapping("/boardUpdate")
	public String update(Model model, BoardVO boardVO) throws IllegalStateException, IOException {
		
		String webPath = "/resources/upload";
		String savePath = application.getRealPath(webPath);
		
		MultipartFile photo = boardVO.getPhoto();
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
		boardVO.setFilename(filename);
		int res = boardService.update(boardVO);
		String url = "";
		String msg = "";
		boolean check = true;
		if(res > 0) {
			url = "list";
			msg = "게시글이 수정되었습니다.";
		} else {
			msg = "게시글 수정에 실패했습니다.";
			check = false;
		}
		model.addAttribute("url", url);
		model.addAttribute("msg", msg);
		model.addAttribute("check", check);
		model.addAttribute("li_list", "current");
		return "/WEB-INF/views/myHome/result.jsp";
	} // boardUpdate()
	
	@RequestMapping("/boardIdentification")
	public String identification(int seq, Model model) {
		model.addAttribute("seq", seq);
		model.addAttribute("li_list", "current");
		return VIEW_PATH + "identification.jsp";
	} // identification()
	
	@RequestMapping("/boardDelete")
	public String boardDelete(int seq, Model model) {
		int res = boardService.delete(seq);
		String url = "";
		String msg = "";
		boolean check = true;
		if(res > 0) {
			url = "list";
			msg = "게시글이 삭제되었습니다.";
		} else {
			msg = "게시글 삭제에 실패했습니다.";
			check = false;
		}
		model.addAttribute("url", url);
		model.addAttribute("msg", msg);
		model.addAttribute("check", check);
		model.addAttribute("li_list", "current");
		return "/WEB-INF/views/myHome/result.jsp";
	} // boardDelete()
	
	public static String getResult(int res) {
		String result = "no";
		
		if(res != 0) {
			result = "yes";
		} 
		return result;
	}
	
	@RequestMapping("/writeComment")
	@ResponseBody
	public String writeComment(CommentVO commentVO) {
		int res = commentService.insert(commentVO);
		if(res>0) boardService.updatePlusComment(commentVO.getBoard_no());
		return getResult(res);
	}
	
	@RequestMapping("/deleteComment")
	@ResponseBody
	public String deleteComment(int seq, int board_no) {
		int res = commentService.delete(seq);
		if(res>0) boardService.updateMinusComment(board_no);
		return getResult(res);
	}
	
	public static String getMsg(int up_down) {
		if(up_down == 1) {
			return "up";
		} else {
			return "down";
		}
	}
	
	@RequestMapping(value = {"/recommend", "/decommend"})
	@ResponseBody
	public String recommend(int seq, String id, int up_down) {
		CommentRecommendVO vo = new CommentRecommendVO();
		vo.setId(id);
		vo.setComment_no(seq);
		CommentRecommendVO resultVO = null;
		
		if(up_down == 1) resultVO = commentService.checkRecomment(vo);
		else resultVO = commentService.checkRecomment(vo);
		
		if(resultVO == null) {
			int res = commentService.recommend(seq);
			vo.setUp_down(up_down);
			commentService.recommentInsert(vo);
			return getResult(res);
		} else {
			return getMsg(resultVO.getUp_down());
		}
	}
	
	@RequestMapping(value = {"/recommendBoard" , "/decommendBoard"})
	@ResponseBody
	public String recommendBoard(int seq, String id, int up_down) {
		BoardRecommendVO boardRecommendVO = new BoardRecommendVO();
		boardRecommendVO.setId(id);
		boardRecommendVO.setBoard_no(seq);
		
		BoardRecommendVO resultVO = null;
		if(up_down == 1) resultVO = boardService.checkRecomment(boardRecommendVO);
		else resultVO = boardService.checkRecomment(boardRecommendVO);
		
		if(resultVO == null) {
			int res;
			if(up_down == 1) res = boardService.updateRecomment(seq);
			else res = boardService.updateDecomment(seq);
			boardRecommendVO.setUp_down(up_down);
			boardService.insertRecomment(boardRecommendVO);
			return getResult(res);
		} else {
			return getMsg(resultVO.getUp_down());
		}
	}
	
}






















