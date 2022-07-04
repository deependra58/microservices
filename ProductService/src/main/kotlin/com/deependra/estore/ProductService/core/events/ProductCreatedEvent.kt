package com.deependra.estore.ProductService.core.events

import java.math.BigDecimal
import java.util.UUID

class ProductCreatedEvent(var productId: UUID, var title: String, var price: BigDecimal, var quantity: Integer)