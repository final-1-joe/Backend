package com.mysite.project.impl;

import org.springframework.stereotype.Service;

import com.mysite.project.mapper.clitagMapper;
import com.mysite.project.service.ClitagService;
import com.mysite.project.vo.ClitagVO;
@Service("clitagService")
public class ClitagServiceImpl implements ClitagService {
	private clitagMapper ctmapper;
	
	public ClitagServiceImpl(clitagMapper ctmapper) {
		this.ctmapper = ctmapper;
	}

	@Override
	public ClitagVO getCT(ClitagVO clitag) {
		return ctmapper.getCT(clitag);
	}

	@Override
	public void insertCT(ClitagVO clitag) {
		ctmapper.insertCT(clitag);
	}

	@Override
	public void updateCT(ClitagVO clitag) {
		ctmapper.updateCT(clitag);
	}

}
