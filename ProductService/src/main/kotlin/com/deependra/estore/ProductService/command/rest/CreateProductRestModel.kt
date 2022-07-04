package com.deependra.estore.ProductService.command.rest

import java.math.BigDecimal
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

open class CreateProductRestModel {

    @NotBlank(message="Product title is required field.")
    lateinit var title:String;
    @Min(value=1, message = "Product price cannot be less than 1.")
    lateinit var price:BigDecimal;
    @Min(value=1, message = "Quantity cannot be less than 1.")
    @Max(value = 5, message = "Quantity cannot be larger than 5")
    lateinit var quantity:Integer;
}