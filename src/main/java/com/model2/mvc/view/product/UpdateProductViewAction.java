package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.domain.Product;

public class UpdateProductViewAction extends Action {


	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("\n* [ UpdateProductViewAction : execute() ] ");

		int prodNo = Integer.parseInt(request.getParameter("prodNo"));
		String menu = request.getParameter("menu");
		System.out.println("\n* menu : "+ menu);
		
		ProductService service = new ProductServiceImpl();
		Product product = service.getProduct(prodNo);

		request.setAttribute("product", product);

		return "forward:/product/updateProduct.jsp?menu=" + menu;
	}
}