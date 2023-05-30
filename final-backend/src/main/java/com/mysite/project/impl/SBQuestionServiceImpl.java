package com.mysite.project.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mysite.project.mapper.SBQuestionMapper;
import com.mysite.project.service.SBQuestionService;
import com.mysite.project.vo.SBQuestionVO;

@Service("sbquestionService")
public class SBQuestionServiceImpl implements SBQuestionService {
	
	private SBQuestionMapper mapper;
	
	public SBQuestionServiceImpl(SBQuestionMapper mapper) {
		this.mapper = mapper;
	}
	@Override
	public List<SBQuestionVO> getList(int page,int pageSize) {
		int start = (page - 1) * pageSize;
		List<SBQuestionVO> list = mapper.getSBQList(start, pageSize);
        return list;
    }
	
	@Override
	public int getNACount() {
		return mapper.getNACount();
	}

	@Override
	public int getCount() {
		int res = mapper.getCount();
		return res;
    }
	
	@Override
    public SBQuestionVO getQuestion(SBQuestionVO sbquesion) {  
		SBQuestionVO sbquesionVo = mapper.getSBQ(sbquesion);
		return sbquesionVo;
    }
	
	
	@Override
    public void insert(SBQuestionVO sbquesion) {
		mapper.insertSBQ(sbquesion);
    }
	
	@Override
    public void update(SBQuestionVO sbquesion) {
		mapper.updateSBQ(sbquesion);
    }
	@Override
    public void delete(SBQuestionVO sbquesion) {
		mapper.deleteSBQ(sbquesion);
    }
	@Override
	public SBQuestionVO getComment(SBQuestionVO sbquesion) {
		SBQuestionVO sbquesionVo = mapper.getSBA(sbquesion);
		return sbquesionVo;
	}
	@Override
	public List<SBQuestionVO> getNAList(int page, int pageSize) {
		int start = (page - 1) * pageSize;
		List<SBQuestionVO> list = mapper.getNASBQList(start, pageSize);
        return list;
	}
	@Override
	public List<SBQuestionVO> searchSubject(SBQuestionVO sbquesion) {
		return mapper.searchSubject(sbquesion);
	}
	@Override
	public List<SBQuestionVO> searchContent(SBQuestionVO sbquesion) {
		return mapper.searchContent(sbquesion);
	}
	@Override
	public List<SBQuestionVO> getAList(int page, int pageSize) {
		int start = (page - 1) * pageSize;
		List<SBQuestionVO> list = mapper.getASBQList(start, pageSize);
        return list;
	}
	@Override
	public int getACount() {
		return mapper.getACount();
	}
	

}
