package com.accenture.lkm.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.MaterialTypeBean;
import com.accenture.lkm.dao.MaterialTypeDAO;
import com.accenture.lkm.entity.MaterialTypeEntity;

@Service
public class MaterialTypeServiceImpl implements MaterialTypeService {

	Logger logger = Logger.getLogger(MaterialTypeServiceImpl.class.getName());

	@Autowired
	MaterialTypeDAO materialTypeDAO;

	@Override
	public List<MaterialTypeBean> getMaterialTypes(String categoryId) {
		List<MaterialTypeEntity> entityList = new ArrayList<>();
		entityList = materialTypeDAO.findByCategoryId(categoryId);
		List<MaterialTypeBean> beanList = new ArrayList<>();
		for (MaterialTypeEntity e : entityList) {
			MaterialTypeBean bean = new MaterialTypeBean();
			BeanUtils.copyProperties(e, bean);
			logger.info(bean);
			bean.setCategoryId(e.getCategoryEntity().getCategoryId());
			beanList.add(bean);
		}
		return beanList;
	}

	@Override
	public List<MaterialTypeBean> getMaterialTypes() {
		List<MaterialTypeEntity> entityList = materialTypeDAO.findAll();
		List<MaterialTypeBean> beanList = new ArrayList<MaterialTypeBean>();

		for (MaterialTypeEntity e : entityList) {
			MaterialTypeBean bean = new MaterialTypeBean();
			bean.setCategoryId(e.getCategoryEntity().getCategoryId());
			BeanUtils.copyProperties(e, bean);
			beanList.add(bean);
		}
		return beanList;
	}

}
