package mybatis.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import mybatis.vo.MemberVO;

public class MemberDAO {

	@Autowired
	private SqlSessionTemplate template;
	
	
	// /////////////////// 비즈니스 로직 ////////////////////////
	
	public MemberVO searchId(String id){		
		return template.selectOne("member.search_id", id);		
	}
	
	public boolean add(MemberVO vo){	
		
		boolean result = false;
		int cnt = template.insert("member.add", vo);
		
		if(cnt == 1)
			result = true;
		
		return result;
	}
	
}
