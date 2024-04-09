package com.ezen.bada.inquire;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ezen.bada.member.MemberDTO;
import com.ezen.bada.review.AllBoardDTO;

@Controller
public class InquireController {
	
	
	@Autowired
	SqlSession sqlsession;
	   
	
	String imagepath="C:\\이젠디지털12\\spring\\bada\\src\\main\\webapp\\resources\\image_user";
	String origin_img;
	
	
	
	@RequestMapping(value = "/inquire_input")
	public String inquireinput(HttpServletRequest request, Model mo, HttpServletResponse response) throws IOException {
	      
		Service ss = sqlsession.getMapper(Service.class);
		HttpSession hs = request.getSession();
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if (hs.getAttribute("loginstate") == null) {
		    out.print("<script type='text/javascript'> alert('로그인이 필요합니다.');");
		    out.print("window.location.href='login';");
		    out.print("</script>");
		    out.flush();
		    
		    return null;
		}
		else {
			
			boolean loginstate = (boolean) hs.getAttribute("loginstate");
			
			if(loginstate) {
				
				String loginid = (String) hs.getAttribute("loginid");
				MemberDTO dto = ss.input_info(loginid);
				    
				mo.addAttribute("dto", dto);
				
				return "inquire_input";
				
			}
			
			else {
			
				out.println("<script>alert('로그인한 회원만 이용 가능합니다.'); location.href='login';</script>");
			    out.flush();
			    
			    return null;
				
			}
	     
	    }

	}
	
	
	@RequestMapping(value = "/inquire_save", method = RequestMethod.POST)
	public String inquiresave(MultipartHttpServletRequest mul) throws IOException {
	    
	    String title = mul.getParameter("title");
	    String category = mul.getParameter("category");
	    String name = mul.getParameter("name");
	    String id = mul.getParameter("id");
	    // 작성 일자는 DB에서 지정
	    String pic1=null, pic2=null, pic3=null, pic4=null, pic5=null;
		String content = mul.getParameter("content");
		String secret = mul.getParameter("secret");
		String secret_pw = mul.getParameter("secret_pw");
		
		MultipartFile mf1=mul.getFile("pic1");
		System.out.println("널이어야 하는데?"+mf1);
		if(mf1 != null && !mf1.isEmpty()) {
			pic1=mf1.getOriginalFilename();
			pic1=filesave1(pic1, mf1.getBytes());
			}
		else {pic1="nope";}
		
		MultipartFile mf2=mul.getFile("pic2");
		if(mf2 != null && !mf2.isEmpty()) {
			pic2=mf2.getOriginalFilename();
			pic2=filesave2(pic2, mf2.getBytes());
			}
		else {pic2="nope";}
		
		MultipartFile mf3=mul.getFile("pic3");
		if(mf3 != null && !mf3.isEmpty()) {
			pic3=mf3.getOriginalFilename();
			pic3=filesave3(pic3, mf3.getBytes());
			}
		else {pic3="nope";}
		
		MultipartFile mf4=mul.getFile("pic4");
		if(mf4 != null && !mf4.isEmpty()) {
			pic4=mf4.getOriginalFilename();
			pic4=filesave4(pic4, mf4.getBytes());
			}
		else {pic4="nope";}
		
		MultipartFile mf5=mul.getFile("pic5");
		if(mf5 != null && !mf5.isEmpty()) {
			pic5=mf5.getOriginalFilename();
			pic5=filesave5(pic5, mf5.getBytes());
			}
		else {pic5="nope";}
	    
		System.out.println("각종 정보: "+title+category+name+id+content+secret+secret_pw);
	    System.out.println("첫 번째 사진:" + pic1);
	    System.out.println("두 번째 사진:" + pic2);
	    System.out.println("세 번째 사진:" + pic3);
	    System.out.println("네 번째 사진:" + pic4);
	    System.out.println("다섯 번째 사진:" + pic5);
	    
	    if(secret.equals("n")) {secret_pw="free";}

	    Service ss = sqlsession.getMapper(Service.class);
	    ss.inquire_save(title, category, name, id, pic1, pic2, pic3, pic4, pic5, content, secret, secret_pw);

	    return "main";
	}
	private String filesave5(String pic5, byte[] bytes) throws IOException {
		UUID ud=UUID.randomUUID();
		String what5=ud.toString()+"_"+pic5;
		File filename=new File(imagepath+"\\"+what5);
		FileCopyUtils.copy(bytes, filename);
		
		return what5;
	}
	private String filesave4(String pic4, byte[] bytes) throws IOException {
		UUID ud=UUID.randomUUID();
		String what4=ud.toString()+"_"+pic4;
		File filename=new File(imagepath+"\\"+what4);
		FileCopyUtils.copy(bytes, filename);
		
		return what4;
	}
	private String filesave3(String pic3, byte[] bytes) throws IOException {
		UUID ud=UUID.randomUUID();
		String what3=ud.toString()+"_"+pic3;
		File filename=new File(imagepath+"\\"+what3);
		FileCopyUtils.copy(bytes, filename);
		
		return what3;
	}
	private String filesave2(String pic2, byte[] bytes) throws IOException {
		UUID ud=UUID.randomUUID();
		String what2=ud.toString()+"_"+pic2;
		File filename=new File(imagepath+"\\"+what2);
		FileCopyUtils.copy(bytes, filename);
		
		return what2;
	}
	private String filesave1(String pic1, byte[] bytes) throws IOException {
		UUID ud=UUID.randomUUID();
		String what1=ud.toString()+"_"+pic1;
		File filename=new File(imagepath+"\\"+what1);
		FileCopyUtils.copy(bytes, filename);
		
		return what1;
	}


	@RequestMapping(value="/inquire_listout")
    public String page(HttpServletRequest request, Model mo) {
		// 맨 처음 아웃 페이지를 들어갔을 때, 
		// 사용자 화면에 떠야 할 1) 현재 페이지 위치와 2) 페이지 당 들어가는 레코드 수 설정 -> 눌 값일 때마다 적절한 초기화 해주기
	    String nowPage=request.getParameter("nowPage");
	    String cntPerPage=request.getParameter("cntPerPage");
	  /* String 클래스는 객체이기 때문에 == null을 사용 가능하지만, int같은 기본 자료형은 불가하므로,
	   * if문에서 null 확인을 위해 위에서는 String으로 받고, 인수로 넣기 직전에 intger로 변환해줘야 한다.
	   */ 
	    if(nowPage==null && cntPerPage == null) {
	       nowPage="1";
	       cntPerPage="5";
	    }
	    else if(nowPage==null) {        nowPage="1";
	    }
	    else if(cntPerPage==null) {
	       cntPerPage="5";
	    }      
	    System.out.println("현재 페이지 : "+nowPage); // 어디에 있냐에 따라 다름
	    System.out.println("페이지 당 레코드 수 : "+cntPerPage); // 5개
	    
	    // 3) 전체 게시글 수 DB에서 구해오기
	    Service ss = sqlsession.getMapper(Service.class);
	    int total=ss.inquire_list_total();
	    System.out.println("총 레코드의 개수 : "+total);
	     
	    // 생성자로 나머지 페이지 처리에 필요한 필드값들도 모두 계산
	    // 3가지 인수 넣어주기
	    PageDTO dto=new PageDTO(total,Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
	    mo.addAttribute("paging",dto);
	    // 리스트 안에 특정 페이지마다 출력될 5개 묶음의 레코드 모음 저장
	    mo.addAttribute("list",ss.page_inquire_listout(dto));
	    return "inquire_listout";
    }
	
	
	
	@RequestMapping(value="/inquire_search")
    public String inquire_search(HttpServletRequest request, Model mo) {
		
		String keyword=request.getParameter("search_keyword");
		String value=request.getParameter("search_value");
		String category=request.getParameter("category");
		String i_date=request.getParameter("i_date");
		System.out.println("서치 키워드: "+keyword+"  서치값: "+value+"   카테고리: "+category+"   날짜: "+i_date);
		Service ss = sqlsession.getMapper(Service.class);
		ArrayList<InquireDTO> list;
	      
	         if(category.equals("") && i_date.equals("")) { //카테고리와 날짜를 모두 입력하지 않은 경우
	            list=ss.inquire_search_out1(keyword, value);
	         }//내부 if문 끝
	         else if(category.equals("")) { //카테고리는 입력하지 않고 날짜는 입력한 경우
	            list=ss.inquire_search_out2(keyword, value, i_date);
	         }//내부 else if문 끝
	         else if(i_date.equals("")) { //카테고리는 입력하고 날짜는 입력하지 않은 경우
	            list=ss.inquire_search_out3(keyword, value, category);
	         }//내부 else if문2 끝
	         else { //카테고리와 날짜를 모두 입력한 경우
	            list=ss.inquire_search_out4(keyword, value, category, i_date);
	         }//내부 else문 끝
	      
	      System.out.println(list);
	      
	    mo.addAttribute("list", list);
	    
	    return "inquire_search_view";
    }
	
	
	@RequestMapping(value = "/inquire_secret_yn")
	public String inquire_secret_yn(HttpServletRequest request, Model mo) {
		int inquire_num=Integer.parseInt(request.getParameter("inquire_num"));
		String secret=request.getParameter("secret");
		
		Service ss=sqlsession.getMapper(Service.class);
		InquireDTO dto=ss.inquire_detail(inquire_num);
		mo.addAttribute("dto", dto);
		
		if(secret.equals("y")) {return "inquire_secret_yn";}
		else {return "redirect:/to_inquire_detail?inquire_num=" + inquire_num;}
		
	}
	
	
	@RequestMapping(value = "/to_inquire_detail")
	public String inquire_detail(HttpServletRequest request,Model mo) {
		int inquire_num=Integer.parseInt(request.getParameter("inquire_num"));
		
		Service ss=sqlsession.getMapper(Service.class);
		ss.inquire_updatecnt(inquire_num);
		InquireDTO dto=ss.inquire_detail(inquire_num);
		mo.addAttribute("dto", dto);
		
		//댓글 출력
		ArrayList<Inquire_reply_DTO> list=ss.inquire_reply_out(inquire_num);
		mo.addAttribute("list", list);
		System.out.println("디티오 확인"+list);
		
		return "inquire_detail";
	}
	
	
	@RequestMapping(value = "/inquire_recommand")
	public String inquire_recommand(HttpServletRequest request, Model mo, HttpServletResponse response) throws IOException, ServletException {
		int inquire_num=Integer.parseInt(request.getParameter("inquire_num"));
		String loginid=request.getParameter("loginid");
		
		Service ss=sqlsession.getMapper(Service.class);
		int rec_id_co=ss.inquire_rec_id(inquire_num, loginid);
		
		if(rec_id_co==0) {
		ss.inquire_recommand(loginid, inquire_num);
		InquireDTO dto=ss.inquire_detail(inquire_num);
		mo.addAttribute("dto", dto);
		}
		
		else {
	        InquireDTO dto=ss.inquire_detail(inquire_num);
			mo.addAttribute("dto", dto);
		}
		
		return "inquire_detail";
		}
		
	
	@RequestMapping(value = "/inquire_report_view")
	public String inquire_report_view(HttpServletRequest request,Model mo) {
		int inquire_num=Integer.parseInt(request.getParameter("inquire_num"));
		String loginid=request.getParameter("loginid");
		
		Service ss=sqlsession.getMapper(Service.class);
		
		MemberDTO mdto = ss.input_info(loginid);
		mo.addAttribute("mdto", mdto);
		
		InquireDTO idto=ss.inquire_detail(inquire_num);
		mo.addAttribute("idto", idto);
		
		return "inquire_report_view";
	}
	

	  @ResponseBody
	  @RequestMapping(value = "/inquire_ban_check", method = RequestMethod.POST)
	   public String inquire_ban_check(HttpServletRequest request) throws IOException {
	      
	        String id = request.getParameter("id");
	        int ban_inquire_num=Integer.parseInt(request.getParameter("ban_inquire_num"));
	        String category = request.getParameter("category");
	        String content = request.getParameter("content");
	        
	        System.out.println("체크 1: "+id);
	        System.out.println("체크 2: "+ban_inquire_num);
	        System.out.println("체크 3: "+category);
	        System.out.println("체크 4: "+content);
	
	        Service ss=sqlsession.getMapper(Service.class);
	        String inquire_check="";
	        String result="";
	        inquire_check=ss.inquire_ban_check(id, ban_inquire_num, category, content); //동일한 사람이 동일한 글을 동일한 사유로 여러번 신고할 수 없도록 중복 방지
	        System.out.println("가져온 신고글 제목: "+inquire_check);
	        if (inquire_check==null) {result="ok";}
	        else {result="nope";}
	        System.out.println("결과 "+result);
	        
	      return result;
	   }
	  
	  @RequestMapping(value = "/inquire_ban_save", method = RequestMethod.POST)
	   public String inquire_ban_save(HttpServletRequest request, Model mo) throws IOException {
	      
	      	String title = request.getParameter("title");
	        String name = request.getParameter("name");
	        String id = request.getParameter("id");
	        int ban_inquire_num=Integer.parseInt(request.getParameter("ban_inquire_num"));
	        String ban_name = request.getParameter("ban_name");
	        String ban_id = request.getParameter("ban_id");
	        String category = request.getParameter("category");
	        String content = request.getParameter("content");
	
	        Service ss=sqlsession.getMapper(Service.class);
	        ss.inquire_ban_save(title, name, id, ban_inquire_num, ban_name, ban_id, category, content);
	        
	        InquireDTO dto=ss.inquire_detail(ban_inquire_num);
			mo.addAttribute("dto", dto);
	    
	      return "inquire_detail";
	   }
	  
	  
	  @RequestMapping(value = "/inquire_reply_save", method = RequestMethod.POST)
	   public String inquire_reply_save(HttpServletRequest request, Model mo) throws IOException {
	      
		int inquire_num=Integer.parseInt(request.getParameter("inquire_num"));
		String content=request.getParameter("content");
		Service ss=sqlsession.getMapper(Service.class);
		
		System.out.println("확인용: "+inquire_num+content);
		  
		//댓글 저장
		ss.inquire_reply_save(inquire_num, content, inquire_num);
			
		//댓글 출력
		ArrayList<Inquire_reply_DTO> list=ss.inquire_reply_out(inquire_num);
		mo.addAttribute("list", list);
		System.out.println("디티오 확인"+list);
		
		//해당 글에 답 여부(댓글 갯수) 수정
		int reply_count=0;
		reply_count= ss.inquire_reply_count(inquire_num);
		if(reply_count==0) {System.out.println("답이 없네");} //답 갯수가 0인 경우
		else {ss.inquire_reply_check(inquire_num);} //
			
		//디테일에 가져가는 정보
		ss.inquire_updatecnt(inquire_num);
		InquireDTO dto=ss.inquire_detail(inquire_num);
		mo.addAttribute("dto", dto);
		
		return "inquire_detail";
	   }
	   
	
	  
	  @RequestMapping(value = "inquire_delete")
	   public String inquire_delete(HttpServletRequest request) {

		     int inquire_num = Integer.parseInt(request.getParameter("inquire_num"));
		     Service ss = sqlsession.getMapper(Service.class);
		     InquireDTO idto = ss.all_photo(inquire_num);
		     
		     List<String> photoPaths = Arrays.asList(idto.getPic1(), idto.getPic2(), 
										    		 idto.getPic3(), idto.getPic4(), 
										    		 idto.getPic5());
			for(String pics : photoPaths) {
				
				if(pics != null && !pics.equals("nope")) 
				{File file = new File(imagepath+"\\"+pics);
					
					if(file.exists()) {file.delete();}
				}
			}
		     ss.inquire_delete(inquire_num);

	      return "redirect:/inquire_listout";
	   }
	
	  
	  
	  @RequestMapping(value = "inquire_modify")
	   public String inquire_modify(HttpServletRequest request, Model mo) {

		     int inquire_num = Integer.parseInt(request.getParameter("inquire_num"));
		     System.out.println("문의 수정 확인 : "+inquire_num);
		     Service ss = sqlsession.getMapper(Service.class);
		     
		     InquireDTO dto = ss.inquire_modify_view(inquire_num);
		     List<String> photoList = Arrays.asList(dto.getPic1(), dto.getPic2(), dto.getPic3(), dto.getPic4(), dto.getPic5());
		     mo.addAttribute("dto", dto);
		     mo.addAttribute("photoList", photoList);

	      return "inquire_modify_view";
	   }
	  
	  
	  
	  
	  
	  @RequestMapping(value = "inquire_modify_save", method = RequestMethod.POST)
	   public String inquire_modify_save(MultipartHttpServletRequest mul, Model mo) throws IllegalStateException, IOException {
		  
		Service ss = sqlsession.getMapper(Service.class);
		  
		int inquire_num = Integer.parseInt(mul.getParameter("inquire_num"));
		String title=mul.getParameter("title");
		String category = mul.getParameter("category");
		String content = mul.getParameter("content");
		String secret = mul.getParameter("secret");
		String secret_pw = mul.getParameter("secret_pw");
		
		boolean new_photos = false;
	    for (int i = 1; i <= 5; i++) {
	        MultipartFile file = mul.getFile("pic" + i);
	        if (file != null && !file.isEmpty()) {
	        	new_photos = true;
	            break; // 새로운 파일이 하나라도 있으면 반복 종료
	        }
	    }
	    if (new_photos) {
	    	
	    	InquireDTO idto = ss.all_photo(inquire_num);
		    List<String> photoPaths = Arrays.asList(idto.getPic1(), idto.getPic2(), 
										    		 idto.getPic3(), idto.getPic4(), 
										    		 idto.getPic5());
			for(String pics : photoPaths) {
				
				if(pics != null && !pics.equals("nope"))
				{File file = new File(imagepath+"\\"+pics);
					
					if(file.exists()) {file.delete();}
				}
			}
	    
	        modi_photos(mul, inquire_num, ss);
	    }
		ss.inquire_modify_save(title, category, content, secret, secret_pw, inquire_num);
		
		//디테일에 가져가는 정보
				ss.inquire_updatecnt(inquire_num);
				InquireDTO dto=ss.inquire_detail(inquire_num);
				mo.addAttribute("dto", dto);
				
				return "inquire_detail";
}

	private void modi_photos(MultipartHttpServletRequest mul, int inquire_num, Service ss) throws IllegalStateException, IOException {
		
		String[] change_photo = new String[5];
	    for (int i = 1; i <= 5; i++) {
	        MultipartFile file = mul.getFile("pic" + i);
	        if (file != null && !file.isEmpty()) {
	            UUID ud = UUID.randomUUID();
	            String fileName = ud.toString() + "_" + file.getOriginalFilename();
	            File newFile = new File(imagepath + "\\" + fileName);
	            file.transferTo(newFile);
	            change_photo[i - 1] = fileName; 
	        } else {
	        	change_photo[i - 1] = "nope";
	        }
	    }
	    
	    Map<String, Object> params = new HashMap<>();
	    params.put("inquire_num", inquire_num);
	    params.put("change_photo", change_photo);
	    ss.update_photo(params);
		
	}
	
	
	  @RequestMapping(value = "inquire_reply_delete")
	   public String inquire_reply_delete(HttpServletRequest request, Model mo) {

			int inquire_reply_num = Integer.parseInt(request.getParameter("inquire_reply_num"));
			int inquire_num = Integer.parseInt(request.getParameter("inquire_num"));
			 
			Service ss = sqlsession.getMapper(Service.class);
			 
			ss.inquire_reply_delete(inquire_reply_num);
			 
			ArrayList<Inquire_reply_DTO> list=ss.inquire_reply_out(inquire_num);
			mo.addAttribute("list", list);
			System.out.println("디티오 확인"+list);
		     
		   //해당 글에 답 여부(댓글 갯수) 수정
			int reply_count=0;
			reply_count= ss.inquire_reply_count(inquire_num);
			if(reply_count==0) {System.out.println("답이 없네");} //답 갯수가 0인 경우
			else {ss.inquire_reply_check(inquire_num);} //
				
			//디테일에 가져가는 정보
			ss.inquire_updatecnt(inquire_num);
			InquireDTO dto=ss.inquire_detail(inquire_num);
			mo.addAttribute("dto", dto);
			
			return "inquire_detail";
	   }
	
	
	
	
}
