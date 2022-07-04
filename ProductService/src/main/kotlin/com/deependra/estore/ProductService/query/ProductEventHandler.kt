package com.deependra.estore.ProductService.query

import com.deependra.estore.ProductService.core.data.ProductEntity
import com.deependra.estore.ProductService.core.events.ProductCreatedEvent
import com.deependra.estore.ProductService.core.data.ProductRepository
import org.axonframework.config.ProcessingGroup
import org.axonframework.eventhandling.EventHandler
import org.springframework.beans.BeanUtils
import org.springframework.stereotype.Component

@Component
@ProcessingGroup("product-group")
class ProductEventHandler(
    var productsRepository: ProductRepository
) {

    @EventHandler
    fun on(event: ProductCreatedEvent){

        var product=ProductEntity();
//        product.productId=event.productId
//        product.price=event.price
//        product.title=event.title
//        product.quantity=event.quantity
        BeanUtils.copyProperties(event,product)
        productsRepository.saveAndFlush(product);
    }
}