package com.accenture.lkm.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

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

import com.accenture.lkm.business.bean.PurchaseBean;
import com.accenture.lkm.business.bean.VendorBean;
import com.accenture.lkm.business.bean.VendorPurchaseReportBean;
import com.accenture.lkm.entity.PurchaseEntity;
import com.accenture.lkm.exceptions.MicroServiceException;
import com.accenture.lkm.service.ReportService;
import com.accenture.lkm.web.client.MaterialCategoryConsumer;
import com.accenture.lkm.web.client.MaterialTypeConsumer;
import com.accenture.lkm.web.client.UnitServiceConsumer;
import com.accenture.lkm.web.client.VendorServiceConsumer;

@Controller
@SessionAttributes("vendorPurchaseReportBean")
public class VendorPurchaseReportController {
	
	Logger logger = Logger.getLogger(VendorPurchaseReportController.class.getName());
	
	@Autowired
	private VendorServiceConsumer vendorServiceConsumer;
	
	@Autowired
	private MaterialCategoryConsumer materialCategoryConsumer;
	
	@Autowired
	private MaterialTypeConsumer materialTypeConsumer;
	
	@Autowired
	private UnitServiceConsumer unitServiceConsumer;
	
	@Autowired
	private ReportService reportService ;
	
	@RequestMapping(value="loadVendorWiseReport.html", method = RequestMethod.GET)
	public ModelAndView loadVendorWiseReport() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("VendorPurchaseReport");
		
		mv.addObject("vendorPurchaseReportBean", new VendorPurchaseReportBean());
		return mv;
	}
	
	@RequestMapping(value="loadVendorWiseReport.html", method = RequestMethod.POST)
	public ModelAndView vendorPurchaseReport(@Valid @ModelAttribute("vendorPurchaseReportBean")VendorPurchaseReportBean vendorPurchaseReportBean, BindingResult results) throws MicroServiceException
	{
		ModelAndView mv = new ModelAndView();
		// prepare the model to attach with spring form modelAttribute
		logger.info("Entering Ims Report Controller");
		
		PurchaseBean purchaseBean = new PurchaseBean();
		List<PurchaseBean> purchasebeans=new ArrayList<PurchaseBean>();
		logger.info(vendorPurchaseReportBean.getVendorName());
		logger.info(""+vendorPurchaseReportBean.getFromDate());
		logger.info(""+vendorPurchaseReportBean.getToDate());
		String viewName = null;
		if(results.hasErrors()) {
			// set the view name
			viewName = "VendorPurchaseReport";		
		}
		else {
			viewName = "VendorPurchaseReport";
			if(vendorPurchaseReportBean.getFromDate()!=null && vendorPurchaseReportBean.getToDate() !=null) {
				purchasebeans = reportService.findAllPurchaseDetailsWithDate(vendorPurchaseReportBean.getVendorName(), vendorPurchaseReportBean.getFromDate(), vendorPurchaseReportBean.getToDate());
				for(PurchaseBean pb : purchasebeans){
					pb.setMaterialCategoryName(materialCategoryConsumer.getCategoryMap().get(pb.getMaterialCategoryId()));
					pb.setMaterialTypeName(materialTypeConsumer.getCategoryTypeMap().get(pb.getMaterialTypeId()));
					pb.setUnitName(unitServiceConsumer.getUnitMap().get(pb.getUnitId()));
					
				}
			}
			else {
				logger.info("in controller before query in else");
				purchasebeans = reportService.findAllPurchaseDetailsWithoutDate(vendorPurchaseReportBean.getVendorName());
				for(PurchaseBean pb: purchasebeans) {
					pb.setMaterialCategoryName(materialCategoryConsumer.getCategoryMap().get(pb.getMaterialCategoryId()));
					pb.setMaterialTypeName(materialTypeConsumer.getCategoryTypeMap().get(pb.getMaterialTypeId()));
					pb.setUnitName(unitServiceConsumer.getUnitMap().get(pb.getUnitId()));

					pb.getMaterialCategoryId();
					logger.info("Controller: "  + pb);
				}
			}

		}
		// pass the model to the view
		mv.addObject("vendorPurchaseReportBeans", purchasebeans);
		//set the view to display
		//mv.setViewName("VendorPurchaseReport");
		mv.setViewName(viewName);
		return mv;
	}

	
	@ModelAttribute("vendorList")
	public List<VendorBean> getVendorDetails() throws MicroServiceException {
		logger.info("Entering Vendor Consumer");
		return vendorServiceConsumer.getVendorBeanList();
	}

	@ExceptionHandler(value = MicroServiceException.class)
	public ModelAndView error(Exception ex) {		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errMsg", ex.getMessage());
		return mv;		
	}

}
