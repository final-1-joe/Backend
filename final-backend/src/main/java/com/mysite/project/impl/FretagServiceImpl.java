package com.mysite.project.impl;

import org.springframework.stereotype.Service;

import com.mysite.project.mapper.FretagMapper;
import com.mysite.project.service.FretagService;
import com.mysite.project.vo.FretagVO;

@Service("fretagService")
public class FretagServiceImpl implements FretagService {
	
	private FretagMapper ftmapper;
	
	public FretagServiceImpl(FretagMapper ftmapper) {
		this.ftmapper = ftmapper;
	}

	@Override
	public FretagVO getFT(FretagVO fretag) {
		return ftmapper.getFT(fretag);
	}

	@Override
	public void insertFT(FretagVO fretag) {
		ftmapper.insertFT(fretag);
	}

	@Override
	public void updateFT(FretagVO fretag) {
		ftmapper.updateFT(fretag);
	}

}
