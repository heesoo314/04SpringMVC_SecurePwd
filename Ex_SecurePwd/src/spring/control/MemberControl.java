package spring.control;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mybatis.dao.MemberDAO;
import mybatis.vo.MemberVO;
import spring.util.SaltUtil;


@Controller
public class MemberControl {
	
	@Autowired
	private MemberDAO dao;	
	
	@Autowired
	private HttpSession session;
	
	/*	
	@Autowired
	private HttpServletRequest request;
	*/
	
	
	// 회원가입창
	@RequestMapping("/index.al")
	public String register(){
		return "/index";
	}
	
	
	// 로그인창
	@RequestMapping("/index2.al")
	public String login(){
		return "/index2";
	}
	
	
	////////////////////////////////// 회원가입 //////////////////////////////////
		
	// 아이디 중복체크
	@RequestMapping("/checkId.al")
	public ModelAndView searchId(String id) throws Exception {
	
	//	String id = request.getParameter("id");
		
		MemberVO vo = dao.searchId(id);
		
		ModelAndView mv = new ModelAndView();
		
		if(vo != null){
			mv.addObject("chk", false);
			mv.addObject("msg", "사용불가");
			
		} else { 
			mv.addObject("chk", true);
			mv.addObject("msg", "사용가능!");		
			
		}	
		
		mv.setViewName("/member/search_id");
		
		return mv;
		
	}
	
	
	// 비밀번호 암호화
	@RequestMapping("/register.al")
	public ModelAndView reg(MemberVO vo) throws Exception{
		
		System.out.println(vo.getId());
		
		String salt = SaltUtil.generateSalt();	// 회원 고유의 쏠트 생성
		String secure_pwd = SaltUtil.getEncrypt(vo.getPwd(), salt);	// 쏠트를 사용하여 암호화
		
		vo.setSalt(salt);
		vo.setPwd(secure_pwd);
		
		
		ModelAndView mv = new ModelAndView();
		
		// 데이터 삽입
		if(dao.add(vo))
			mv.addObject("msg", "저장성공");
		else 
			mv.addObject("msg", "저장실패");
		
		
		mv.setViewName("/member/register_ok");
		
		return mv;
		
	}
	
	
	
	////////////////////////////////// 로그인 ////////////////////////////////// 
	
	// 로그인 시 암호화된 비밀번호 비교
	@RequestMapping("/login.al")
	public ModelAndView login(String id, String pwd) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		MemberVO vo = dao.searchId(id);
		
		// 입력한 비밀번호를 쏠트값으로 암호화하여 DB에 저장된 비밀번호와 비교!!!!
		String p = SaltUtil.getEncrypt(pwd, vo.getSalt());
		
		if(vo.getPwd().equals(p)){
			mv.addObject("msg", "로그인 성공");
		
			// 세션지정
			session.setAttribute("login_ss", vo);
			
		} else
			mv.addObject("msg", "로그인 실패");
		
		mv.setViewName("/member/login_ok");
		return mv;
		
		
	}
	
	
}
