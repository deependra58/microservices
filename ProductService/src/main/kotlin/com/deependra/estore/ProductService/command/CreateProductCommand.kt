package com.deependra.estore.ProductService.command

import org.axonframework.modelling.command.TargetAggregateIdentifier
import java.math.BigDecimal
import java.util.UUID

data class CreateProductCommand (
    @TargetAggregateIdentifier
    val productId:UUID,
    val title:String,
    val price:BigDecimal,
    val quantity:Integer
    )