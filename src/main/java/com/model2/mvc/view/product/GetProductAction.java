package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.domain.Product;

public class GetProductAction extends Action {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("\n* [ GetProductAction : execute() ] ");

		int prodNo = Integer.parseInt(request.getParameter("prodNo"));

		Product product = new Product();
		String menu = request.getParameter("menu");
		ProductServiceImpl service = new ProductServiceImpl();
		product = service.getProduct(prodNo);

		System.out.println("\n* menu : "+ menu);
		
		request.setAttribute("product", product);
		request.setAttribute("menu", menu);

		if (menu.equals("manage"))
			return "forward:/updateProductView.do?prodNo=" + prodNo + "&menu" + menu;
		else
			return "forward:/product/getProductDetail.jsp";
	}

}