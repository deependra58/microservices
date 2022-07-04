package com.deependra.estore.ProductService.query

import com.deependra.estore.ProductService.core.data.ProductRepository
import com.deependra.estore.ProductService.query.rest.ProductRestModel
import org.axonframework.queryhandling.QueryHandler
import org.springframework.beans.BeanUtils
import org.springframework.stereotype.Component

@Component
class ProductQueryHandler(var productEntityRepository: ProductRepository) {

    @QueryHandler
    fun findProducts(query:FindProductQuery): List<ProductRestModel>{
        var productList=ArrayList<ProductRestModel>();
        var productEntityList=productEntityRepository.findAll();
        productEntityList.forEach { item->
            var productRestModel= ProductRestModel();
            BeanUtils.copyProperties(item,productRestModel);
            productList.add(productRestModel);
        }
        return productList
    }
}