package com.accenture.lkm.web.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.inject.Model;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.lkm.business.bean.MaterialCategoryBean;
import com.accenture.lkm.business.bean.MaterialTypeBean;
import com.accenture.lkm.business.bean.PurchaseBean;
import com.accenture.lkm.business.bean.UnitBean;
import com.accenture.lkm.business.bean.VendorBean;
import com.accenture.lkm.exceptions.MicroServiceException;
import com.accenture.lkm.service.PurchaseService;
import com.accenture.lkm.web.client.MaterialCategoryConsumer;
import com.accenture.lkm.web.client.MaterialTypeConsumer;
import com.accenture.lkm.web.client.UnitServiceConsumer;
import com.accenture.lkm.web.client.VendorServiceConsumer;

@Controller
@SessionAttributes("purchaseBean")
public class PurchaseEntryController {

	Logger logger = Logger.getLogger(PurchaseEntryController.class.getName());
	
	@Autowired
	PurchaseService service;
	
	@Autowired
	private VendorServiceConsumer vendorServiceConsumer;
	
	@Autowired
	private MaterialCategoryConsumer materialCategoryConsumer;
	
	@Autowired
	MaterialTypeConsumer materialTypeConsumer;
	
	@Autowired
	UnitServiceConsumer unitServiceConsumer;
	
	@RequestMapping(value = "purchaseEntry.html", method = RequestMethod.GET)
	public ModelAndView purchaseEntry() throws Exception {		
		ModelAndView mv = new ModelAndView();
		// prepare the model to attach with spring form modelAttribute
		logger.info("Entering Ims Controller");
		PurchaseBean purchaseBean = new PurchaseBean();
		// pass the model to the view
		mv.addObject("purchaseBean", purchaseBean);
		//set the view to display
		mv.setViewName("PurchaseEntry");
		return mv;
	}

	@RequestMapping(value = "purchaseEntry.html", method = RequestMethod.POST)
	public ModelAndView savePurchaseEntry(@Valid @ModelAttribute PurchaseBean purchaseBean, BindingResult results) throws Exception {		
		ModelAndView mv = new ModelAndView();
		String viewName = null;
		if(results.hasErrors()) {
			// set the view name
			viewName = "PurchaseEntry";
			
			
		}else {
			// set the view name to redirect to success page displaying the transaction id
			viewName = "PurchaseSuccess";
			
		}
		
		mv.setViewName(viewName);		
		return mv;
	}
	
	@RequestMapping(value="fetchMaterialTypesAndMaterialUnitsList.html")
	public ModelAndView fetchMaterialTypesAndMaterialUnitsList(PurchaseBean purchaseBean) throws MicroServiceException
	{
		ModelAndView mv=new ModelAndView();
		logger.info(purchaseBean.getMaterialCategoryId());
		List<MaterialTypeBean> mTypeList=materialTypeConsumer.hitGetTypesBasedOnCategoryId(purchaseBean.getMaterialCategoryId());
		
		List<UnitBean> uNameList=unitServiceConsumer.hitGetUnitsByCategoryId(purchaseBean.getMaterialCategoryId());
		
		mv.addObject("mTypeList",mTypeList);
		mv.addObject("uNameList",uNameList);
		mv.setViewName("PurchaseEntry");
		return(mv);
	}
	
//	@RequestMapping(@Model("successMessage"), value = "purchaseEntrySuccess.html", method = RequestMethod.POST)
//	public ModelAndView purchaseEntrySuccess() throws Exception {		
//		ModelAndView mv = new ModelAndView();
//		// prepare the model to attach with spring form modelAttribute
//		logger.info("Entering Ims Success Controller");
//		PurchaseBean purchaseBean = new PurchaseBean();
//		// pass the model to the view
//		mv.addObject("message", "Order ID : " +purchaseBean.getPurchaseId());
//		//set the view to display
//		mv.setViewName("PurchaseSuccess");
//		return mv;
//	}
	

	@ModelAttribute("vendorList")
	public List<VendorBean> getVendorDetails() throws MicroServiceException {
		logger.info("Entering Vendor Consumer");
		return vendorServiceConsumer.getVendorBeanList();
	}
	
	@ModelAttribute("materialCategoryList")
	public List<MaterialCategoryBean> getMaterialCategoryDetails() throws MicroServiceException {
		logger.info("Entering Material Category Consumer");
		return materialCategoryConsumer.getMaterialCategoryBeanList();
	}
	
	@RequestMapping("addPurchaseEntry.html")
	public ModelAndView addPurchaseEntry(@Valid @ModelAttribute("purchaseBean") PurchaseBean bean, BindingResult result) throws MicroServiceException
	{
		logger.info("Start controller");
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors())
		{
			logger.info(""+result);
			logger.info("Result has some error");
			mav.setViewName("PurchaseEntry");
		}
		else
		{
			logger.info("Entering in else..... Result is not null");
			
			bean.setMaterialCategoryName(materialCategoryConsumer.getCategoryMap().get(bean.getMaterialCategoryId()));
			bean.setMaterialTypeName(materialTypeConsumer.getCategoryTypeMap().get(bean.getMaterialCategoryId()));
			//bean.setUnitId(unitServiceConsumer.getUnitMap().get(bean.getMaterialCategoryId()));
			
			PurchaseBean purchaseBean = service.addPurchaseEntry(bean);
			if(purchaseBean != null)
			{	
				logger.info("Entered in if purchase bean not null.....");
				logger.info(purchaseBean.getMaterialCategoryName());
				logger.info(purchaseBean.getMaterialTypeName());
				logger.info(purchaseBean.getUnitName());
				logger.info(purchaseBean.getBrandName());
				logger.info(""+purchaseBean.getQuantity());
				logger.info(""+purchaseBean.getPurchaseAmount());
				logger.info(purchaseBean.getTransactionId());
				mav.addObject("id",purchaseBean.getTransactionId());
				mav.setViewName("PurchaseSuccess");
			}
			else
			{
				mav.addObject("notAdded","Error in adding details...");
				mav.setViewName("PurchaseEntry");
			}
		}
		logger.info("End controller");
		return mav;
	}
	
	@ExceptionHandler(value = MicroServiceException.class)
	public ModelAndView error(Exception ex) {		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errMsg", ex.getMessage());
		return mv;		
	}
}
