package com.springboot.mycgv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.mycgv.dto.BoardDto;
import com.springboot.mycgv.dto.PageDto;
import com.springboot.mycgv.service.BoardService;
import com.springboot.mycgv.service.FileService;
import com.springboot.mycgv.service.PageService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private PageService pageService;
	
	@Autowired
	private FileService fileService;
	
	/**
	 * board_list 
	 */
	@GetMapping("/board_list/{rpage}")
	public String board_list(@PathVariable String rpage, Model model) {
		
		PageDto pageDto = pageService.getPageCount(rpage);
		model.addAttribute("list", boardService.getList(pageDto));
		model.addAttribute("page", pageDto);
		
		return "/board/board_list";
	}
	
	/**
	 * 게시글 화면
	 */
	@GetMapping("/board_write")
	public String board_write_get() {
		return "/board/board_write";
	}
	 
	@PostMapping("/board_write")
	public String boardWritePost(BoardDto boardDto) throws Exception {
		
		if(fileService.fileCheck(boardDto.getFile1())) {
			//파일 존재
			boardDto = fileService.init(boardDto);
			int result = boardService.getWrite(boardDto);
			if(result == 1) fileService.saveFile(boardDto);
		}else {
			//파일 존재 X
			boardDto.setBfile(""); // 마이바티스에서 널값을 인식못해서 (mapper에서) 그래서 미리 널값을 지정해 둔다.
			boardDto.setBsfile("");
			boardService.getWrite(boardDto);
		}
		return "redirect:/board_list/1";
	}
	
	/**
	 * board_content 
	 */
	@GetMapping("/board_content/{bid}")
	public String boardContent(@PathVariable String bid, Model model) {
		
		model.addAttribute("board",boardService.getContent(bid));
		
		return "/board/board_content";
	}
	
	/**
	 * board_update 
	 */
	@GetMapping("/board_update/{bid}")
	public String boardUpdate(@PathVariable String bid, Model model) {
		
		model.addAttribute("board",boardService.getContent(bid));
		
		return "/board/board_update";
	}
	
	@PostMapping("/board_update")
	public String boardUpdatePost(BoardDto boardDto) throws Exception {
		if(fileService.fileCheck(boardDto.getFile1())) {
			String oldFile = boardDto.getBsfile();
			boardDto = fileService.init(boardDto);
			int result = boardService.getUpdate(boardDto);
			if(result ==1 ) {
				fileService.saveFile(boardDto);
				fileService.deleteFile(oldFile);
			}
		}else {
			boardService.getUpdate(boardDto);
		}
		return "redirect:/board_list/1";
	}
	
	
	/**
	 * board_delete 
	 */
	@RequestMapping(value = {"/board_delete/{bid}","/board_delete/{bid}/{bsfile}"})
	public String board_delete(@PathVariable(value="bid") String bid,@PathVariable(value = "bsfile", required = false) String bsfile,  Model model) {
		
		if(bsfile == null) bsfile="none";
		System.out.println("bsfile==>>" + bsfile);
		return "/board/board_delete";
	}
	 
	
	@PostMapping("/board_delete")
	public String boardDeletePost(BoardDto boardDto) throws Exception {
		
		int result = boardService.getDelete(boardDto);
		if(result == 1) {
			if(!boardDto.getBsfile().equals("none"))
			fileService.deleteFile(boardDto.getBsfile());
		}
		
		return "redirect:/board_list/1";
	}
	
	
	
	
	
//	
//	/**
//	 * board_delete_check.do : �Խ��� ���� ó��
//	 */
//	@RequestMapping(value="/board_delete_check.do", method=RequestMethod.POST)
//	public ModelAndView board_delete_check(String bid, HttpServletRequest request) throws Exception {
//		ModelAndView mv = new ModelAndView();
//		
//		
//		//������ bid �࿡ bsfile�� �̸��� �������� ���� dao.select(bid) �޼ҵ� ȣ��--> upload������ ���� ���� Ȯ��
//		CgvBoardVO vo = boardService.getContent(bid); //dao.select(bid) �޼ҵ�� delete �޼ҵ� ȣ�� ���� ����Ǿ����!! 
//		int result = boardService.getDelete(bid);
//		
//		if(result == 1){
//			//�Խñ� ������ upload ������ �����ϴ� ������ �ִٸ� �����ϱ�
//			fileService.fileDelete(vo, request);
//			mv.setViewName("redirect:/board_list.do");
//		}else{
//			mv.setViewName("error_page");
//		}
//		
//		return mv;
//	}
//	
//	/**
//	 * board_update_check.do : �Խ��� ���� ó��
//	 */
//	@RequestMapping(value="/board_update_check.do", method=RequestMethod.POST)
//	public ModelAndView board_update_check(CgvBoardVO vo, HttpServletRequest request) throws Exception {
//		ModelAndView mv = new ModelAndView();
//		
//		//���� ������ �����ϴ� ��� �̸��� ������ ����
//		String old_filename = vo.getBsfile();
//		
//		//������ ���ο� ������ �����ߴ��� Ȯ��
//		vo = fileService.update_fileCheck(vo); 
//		int result = boardService.getUpdate(vo);
//		
//		if(result == 1){
//			//���ο� ������ upload ������ ����
//			fileService.update_filesave(vo, request, old_filename);
//			mv.setViewName("redirect:/board_list.do");
//		}else{
//			mv.setViewName("error_page");
//		}
//		
//		return mv;
//	}
//	
	
	
//	/**
//	 * board_write_check.do : �Խ��� �۾��� ó��
//	 */
//	@RequestMapping(value="/board_write_check.do", method=RequestMethod.POST)
//	public ModelAndView board_write_check(CgvBoardVO vo, HttpServletRequest request) throws Exception {
//		ModelAndView mv = new ModelAndView();
//		
//		//1. ����üũ �� bfile, bsfile�� ����Ǵ� �̸� ����
//		vo = fileService.fileCheck(vo);
//		int result = boardService.getWriteResult(vo);
//		
//		if(result == 1){
//			
//			//2. upload ������ bsfile ������ ���� ���� ���ε� ó��
//			fileService.fileSave(vo, request);
//			
//			//mv.setViewName("/board/board_list"); //����X, �ƹ��� �Խñ� ��µ��� X
//			mv.setViewName("redirect:/board_list.do"); //DB������ Controller���� �����ϹǷ�, ���ο� ������ ����!!
//		}else{
//			mv.setViewName("error_page");
//		}
//		
//		return mv;
//	}
	
	 
 
	 
	
	 
	
	 
}

 