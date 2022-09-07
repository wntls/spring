package net.koreate.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import net.koreate.board.service.BoardService;
import net.koreate.board.util.Criteria;
import net.koreate.board.util.PageMaker;
import net.koreate.board.vo.BoardVO;

@Controller
@RequestMapping("/board/*")
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService bs;
	
	// @RequestMapping(value = "/register", method = RequestMethod.GET)
	@GetMapping("/register")
	public void register() throws Exception{
		// /board/register
		// WEB-INF/views/board/register.jsp
		System.out.println("게시글 작성 페이지 요청");
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, 
			//Model model, HttpSession session
			RedirectAttributes rttr
			)throws Exception{
		System.out.println(board);
		String result = bs.regist(board);
		System.out.println(result);
//		model.addAttribute("msg",result);
//		session.setAttribute("message", result);
		rttr.addFlashAttribute("result",result);
		return "redirect:/board/listAll"; // 리스트 페이지 이동
	} 
	// board/listAll.jsp
	@GetMapping("/listAll")
	public void listAll(Model model)throws Exception{
		List<BoardVO> list = bs.listAll();
		model.addAttribute("list",list);
	}
	
	@GetMapping("/read")
	public void read(@RequestParam(name="bno") int bno,
			Model model, HttpSession session) throws Exception{
		// 조회수 증가
		bs.updateCnt(bno, session);
		BoardVO boardVO = bs.read(bno);
		model.addAttribute("boardVO",boardVO);
	}
	
	@GetMapping("/modify")
	public void modify(int bno,Model model) throws Exception{
		model.addAttribute("boardVO",bs.read(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr)throws Exception{
		// 게시글 수정
		bs.modify(board);
		rttr.addAttribute("bno",board.getBno());
		return "redirect:/board/read";
		//return "redirect:/board/read?bno="+board.getBno()+"&title="+board.getTitle();
	}
	
	@GetMapping("/remove")
	public String remove(
			int bno, // 삭제 할 게시글 번호
			RedirectAttributes rttr
			)throws Exception{
		bs.remove(bno);
		rttr.addFlashAttribute("result","삭제 완료");
		return "redirect:/board/listAll";
	}
	
	/* 페이징 처리 */
	// board/list
	@GetMapping("/listPage")
	// param : 요청 page, perPageNum
	public void listPage(Criteria cri, Model model)throws Exception{
		List<BoardVO> list = bs.listCriteria(cri);
		PageMaker pm = bs.getPageMaker(cri);
		model.addAttribute("list",list);
		model.addAttribute("pm",pm);
	}
	
	@GetMapping("/readPage")
	public String readPage(int bno,Model model,@ModelAttribute("cri") Criteria cri)throws Exception{
		System.out.println(cri);
		System.out.println(bno);
//		model.addAttribute("cri",cri);
		model.addAttribute("boardVO",bs.read(bno));
		return "/board/readPage";
	}
	
	@GetMapping("/modifyPage")
	public void modifyPage(int bno,@ModelAttribute("cri") Criteria cri,Model model)throws Exception{
		model.addAttribute("boardVO",bs.read(bno));
	}
	
	@PostMapping("/modifyPage")
	public String modifyPage(BoardVO board,Criteria cri, RedirectAttributes rttr)throws Exception{
		bs.modify(board);
		/*
		rttr.addAttribute("page",cri.getPage());
		rttr.addAttribute("perPageNum",cri.getPerPageNum());
		*/
		rttr.addFlashAttribute("cri",cri);
		rttr.addAttribute("bno",board.getBno());
		return "redirect:/board/readPage";
	}
	
	@PostMapping("/removePage")
	public String remove(int bno,Criteria cri,RedirectAttributes rttr)throws Exception{
		bs.remove(bno);
		rttr.addAttribute("page",cri.getPage());
		rttr.addAttribute("perPageNum",cri.getPerPageNum());
		return "redirect:/board/listPage";
	}
	
}



















