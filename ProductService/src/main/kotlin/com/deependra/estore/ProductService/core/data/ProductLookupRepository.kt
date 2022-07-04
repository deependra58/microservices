package com.deependra.estore.ProductService.core.data

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ProductLookupRepository : JpaRepository<ProductLookupEntity, UUID> {
    fun findByProductIdOrTitle(productId: UUID, title: String):ProductLookupEntity;
    fun findByProductId(productId: UUID):ProductEntity;
}