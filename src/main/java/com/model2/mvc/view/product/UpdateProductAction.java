package com.model2.mvc.view.product;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.domain.Product;

public class UpdateProductAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("\n* [ UpdateProductAction : execute() ] ");

		Product product = new Product();		
			
		int prodNo = Integer.parseInt(request.getParameter("prodNo"));
		product.setProdNo(prodNo);
		
		String menu = request.getParameter("menu");
		System.out.println("\n* menu : "+ menu);
		
		product.setProdName(request.getParameter("prodName"));
		product.setProdDetail(request.getParameter("prodDetail"));

		String manuDate = (String) request.getParameter("manuDate");
		product.setManuDate(manuDate);

		product.setPrice(Integer.parseInt(request.getParameter("price")));
		product.setFileName(request.getParameter("fileName"));

		ProductService service = new ProductServiceImpl();
		service.updateProduct(product);

		Date regDate = service.getProduct(prodNo).getRegDate();
		request.setAttribute("regDate", regDate);
		request.setAttribute("product", product);
		request.setAttribute("menu", menu);
		
		
		return "redirect:/getProduct.do?prodNo=" + prodNo + "&menu=ok";
	}
}
