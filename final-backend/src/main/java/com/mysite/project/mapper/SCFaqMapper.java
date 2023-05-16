package com.mysite.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mysite.project.vo.SCFaqVO;

@Mapper
public interface SCFaqMapper {
	
	@Select("select * from scfaq order by scnum asc ")
	public List<SCFaqVO> getFAQ();
	
	
	@Insert("insert into scfaq (scquestion,scanswer,scwriter,sccreateDate) "
			+ "values ( #{scquestion}, #{scanswer}, #{scwriter},now())")
	public int insertFAQ(SCFaqVO faq);
	
	@Update("update scfaq set scquestion=#{scquestion},scanswer=#{scanswer}, sccreateDate=now() "
			+ "where scnum=#{scnum}")
	public int updateFAQ(SCFaqVO faq);
	
	@Delete("delete from scfaq where scnum=#{scnum}")
	public int deleteFAQ(SCFaqVO faq);


}
