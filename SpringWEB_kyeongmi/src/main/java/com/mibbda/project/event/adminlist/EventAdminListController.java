package com.mibbda.project.event.adminlist;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EventAdminListController {
	
	
	@Autowired 
	private SqlSession sqlSession;
	
	
	// 관리자화면_이벤트 목록
	@RequestMapping("eventListAdmin")
	public String eventListAdmin(HttpServletRequest request, Model model, HttpSession session) {
		
		/////////////////////////////////
		// ID 수정 필요
		/////////////////////////////////
		
		session = request.getSession();
		session.setAttribute("userId", "admin");
		String userId = (String) session.getAttribute("userId");
		
		//한 페이지당보여줄 글 갯수
		final int pageSize=12;
		
		int currentPage = 1; 
		if(request.getParameter("page")!=null){ 
		currentPage = Integer.parseInt(request.getParameter("page")); //현재 페이지
		}
		
		int startNum=((currentPage-1)*pageSize);
		
		// Event 목록 불러오기
		EventAdminListDao dao = sqlSession.getMapper(EventAdminListDao.class);
		model.addAttribute("eventList", dao.listDao(startNum, pageSize));
		
		//전체 글 갯수 구하기
		int totalRow = dao.getBoardCount();
		//전체 페이지 갯수       (전체글 개수-1)/페이지당 글 수+1   
		int totalPage = (totalRow-1)/pageSize+1;  
		
		//페이지 그룹화  [1][2][3] [4][5][6] [7][8][9]  =>3페이지가 한그룹
		int pagePerGroup = 3;
		//시작페이지	((현재페이지-1)/그룹당 보여줄 페이지)*그룹당 보여줄 페이지+1   [1] [4] [7]
		int startPage = ((currentPage-1)/pagePerGroup)*pagePerGroup+1;
		//끝페이지		시작페이지+그룹당 보여줄 페이지-1  [3] [6] [9]
		int endPage = startPage+pagePerGroup-1;
		
		//★만약 endPage가 totalPage보다 크면 endPage에 totalPage를 넣어준다.
		if(endPage>totalPage){endPage=totalPage;}
		
		//request에 setAttribute를 사용하여 모든 정보를 붙여 보낸다.
		model.addAttribute("currentPage",currentPage); 
		model.addAttribute("totalRow",new Integer(totalRow));   //총 글 갯수 생략 가능성
		model.addAttribute("totalPage",new Integer(totalPage)); 
		model.addAttribute("startPage",new Integer(startPage)); 
		model.addAttribute("endPage",new Integer(endPage)); 
	
		
		return "event_admin/manageEventList";
	}

}
