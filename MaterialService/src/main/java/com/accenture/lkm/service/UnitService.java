package com.accenture.lkm.service;

import java.util.List;

import com.accenture.lkm.business.bean.UnitBean;

public interface UnitService {
	public List<UnitBean> getUnits(String unitId);

	public List<UnitBean> getUnits();
}
