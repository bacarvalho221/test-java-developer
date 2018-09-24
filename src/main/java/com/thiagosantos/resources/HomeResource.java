package com.thiagosantos.resources;

import com.thiagosantos.domain.Product;
import com.thiagosantos.services.ProductService_interface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

/*Page Home Build*/

@Controller
public class HomeResource {

    private static final int INITIAL_PAGE = 0;

    private final ProductService_interface productService;

    @Autowired
    public HomeResource(ProductService_interface productService) {
        this.productService = productService;
    }

    @GetMapping("/home")
    public ModelAndView home(Optional<Integer> page) {

        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

        Page<Product> products = productService.findAllProductsPageable(new PageRequest(evalPage, 5));
        
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("products", products);
        modelAndView.setViewName("/home");
        return modelAndView;
    }

}
