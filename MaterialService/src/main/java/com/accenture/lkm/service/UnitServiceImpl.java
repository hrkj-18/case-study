package com.accenture.lkm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.UnitBean;
import com.accenture.lkm.dao.UnitDAO;
import com.accenture.lkm.entity.UnitEntity;

@Service
public class UnitServiceImpl implements UnitService {

	@Autowired
	UnitDAO unitDAO;

	public UnitServiceImpl() {
		super();
	}

	@Override
	public List<UnitBean> getUnits(String categoryId) {

		List<UnitEntity> unitEntityList = unitDAO.findByCategoryId(categoryId);
		List<UnitBean> unitBeanList = new ArrayList<UnitBean>();

		for (UnitEntity entity : unitEntityList) {
			UnitBean bean = new UnitBean();
			bean.setCategoryId(entity.getCategoryEntity().getCategoryId());
			BeanUtils.copyProperties(entity, bean);
			unitBeanList.add(bean);
		}

		return unitBeanList;
	}

	@Override
	public List<UnitBean> getUnits() {
		List<UnitEntity> unitEntityList = unitDAO.findAll();
		List<UnitBean> unitBeanList = new ArrayList<UnitBean>();

		for (UnitEntity entity : unitEntityList) {
			UnitBean bean = new UnitBean();
			bean.setCategoryId(entity.getCategoryEntity().getCategoryId());
			BeanUtils.copyProperties(entity, bean);
			unitBeanList.add(bean);
		}

		return unitBeanList;
	}

}
