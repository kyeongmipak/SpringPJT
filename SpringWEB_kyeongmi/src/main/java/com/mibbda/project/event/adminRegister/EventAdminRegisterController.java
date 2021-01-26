package com.mibbda.project.event.adminRegister;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@Controller
public class EventAdminRegisterController {
	
	@Autowired 
	private SqlSession sqlSession;

	// 이벤트 등록 페이지 이동
	@RequestMapping("insertEventView")
	public String write_view(Model model) {
		
		return "event_admin/insertEventView";
	}
		
	
	// 이벤트 등록
	@RequestMapping("insertEvent")
	public String insertEventView(HttpServletRequest request, Model model, HttpSession session) {
		
		// Event등록
		EventAdminRegisterDao dao = sqlSession.getMapper(EventAdminRegisterDao.class);
		 
		// 이미지 업로드
		String directory = request.getSession().getServletContext().getRealPath("resources/image"); 
		System.out.println("경로 : " +directory);
		int maxSize = 300 * 300 * 10;
		String encoding = "UTF-8";
		String now = new SimpleDateFormat("yyyyMMddHmsS").format(new Date()); //현재시간
		MultipartRequest multi = null;
		
	try {
		
		multi = new MultipartRequest(request, directory, maxSize, encoding, new DefaultFileRenamePolicy());
		
		
		 String filename = "";
		 String rfile = multi.getFilesystemName("eFilename");
		 String f_ext = "";
		
		 String eTitle = multi.getParameter("eTitle");
		 String eContent = multi.getParameter("eContent");
		 String startDate = multi.getParameter("startDate");
		 String endDate = multi.getParameter("endDate");
		 
		 
		 if(rfile != null){
		     File file_copy = new File(directory + "/" + rfile);
		     	if(file_copy.exists()) {
		     		f_ext = rfile.substring(rfile.length()-3,rfile.length());
		     		File file1 = new File(directory+"/"+now+"."+f_ext);
		      
		     		file_copy.renameTo(file1);
		     		filename = file1.getName();
		     		System.out.println("파일 : " + filename);
		     		session.setAttribute("eFilename", filename);
		     	}
		 }
		 
		 System.out.println("tite : " + eTitle);
		 
	
		dao.registerDao(eTitle, eContent, filename, startDate, endDate);
		
//		EventAdminRegisterDao dao = sqlSession.getMapper(EventAdminRegisterDao.class);
//		dao.registerDao((String)request.getAttribute("eTitle"), (String)request.getAttribute("eContent"),
//				(String)request.getAttribute("eFilename"), (String)request.getAttribute("startDate"), (String)request.getAttribute("endDate"));
		
		 
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("오류발생");
	}
		
		
		return "redirect:eventListAdmin";
	}
	
	
}
