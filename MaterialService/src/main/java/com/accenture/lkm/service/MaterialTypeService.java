package com.accenture.lkm.service;

import java.util.List;

import com.accenture.lkm.business.bean.MaterialTypeBean;

public interface MaterialTypeService {

	public List<MaterialTypeBean> getMaterialTypes(String categoryId);

	public List<MaterialTypeBean> getMaterialTypes();

}
