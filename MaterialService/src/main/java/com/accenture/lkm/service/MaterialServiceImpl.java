package com.accenture.lkm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.MaterialCategoryBean;
import com.accenture.lkm.dao.MaterialCategoryDAO;
import com.accenture.lkm.entity.MaterialCategoryEntity;

@Service
public class MaterialServiceImpl implements MaterialService {

	@Autowired
	MaterialCategoryDAO mDao;

	@Override
	public MaterialCategoryBean getMaterialCategoryById(String categoryId) {

		MaterialCategoryBean materialCategoryBean = new MaterialCategoryBean();

		MaterialCategoryEntity materialCategoryEntity = mDao.findOne(categoryId);
		if (materialCategoryEntity != null) {
			BeanUtils.copyProperties(materialCategoryEntity, materialCategoryBean);
		}

		return materialCategoryBean;
	}

	@Override
	public List<MaterialCategoryBean> getMaterialCategories() {

		List<MaterialCategoryBean> materialCategoryBeans = new ArrayList<MaterialCategoryBean>();

		List<MaterialCategoryEntity> categoryEntities = mDao.findAll();
		if (!(categoryEntities.isEmpty())) {
			for (MaterialCategoryEntity entity : categoryEntities) {
				MaterialCategoryBean categoryBean = new MaterialCategoryBean();
				BeanUtils.copyProperties(entity, categoryBean);
				materialCategoryBeans.add(categoryBean);
			}
		}

		return materialCategoryBeans;
	}

}
