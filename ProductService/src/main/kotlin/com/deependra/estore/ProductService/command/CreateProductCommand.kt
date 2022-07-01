package com.deependra.estore.ProductService.command

import org.axonframework.modelling.command.TargetAggregateIdentifier
import java.math.BigDecimal

class CreateProductCommand (
    @TargetAggregateIdentifier
    var productId:String,
    var title:String,
    var price:BigDecimal,
    var quantity:Integer
    )