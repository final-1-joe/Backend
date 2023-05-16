package com.mysite.project.service;

import com.mysite.project.vo.FretagVO;

public interface FretagService {
	public FretagVO getFT(FretagVO fretag);
	public void insertFT(FretagVO fretag);
	public void updateFT(FretagVO fretag);
}
