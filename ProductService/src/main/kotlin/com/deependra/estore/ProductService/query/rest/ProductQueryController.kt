package com.deependra.estore.ProductService.query.rest

import com.deependra.estore.ProductService.query.FindProductQuery
import org.axonframework.messaging.responsetypes.ResponseTypes
import org.axonframework.queryhandling.QueryGateway
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductQueryController(var queryGateway: QueryGateway) {

    @GetMapping
    fun getProducts(): MutableList<ProductRestModel>? {
        var findProductQuery = FindProductQuery();
        var products = queryGateway.query(findProductQuery, ResponseTypes.multipleInstancesOf(ProductRestModel::class.java)).get();
        return products
    }
}