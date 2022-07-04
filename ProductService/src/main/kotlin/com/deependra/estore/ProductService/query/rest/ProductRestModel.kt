package com.deependra.estore.ProductService.query.rest

import java.math.BigDecimal
import java.util.UUID

class ProductRestModel {

    lateinit var productId: UUID
    lateinit var title: String
    lateinit var price: BigDecimal
    lateinit var quantity: Integer
}