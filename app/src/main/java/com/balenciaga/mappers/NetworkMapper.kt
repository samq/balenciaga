package com.balenciaga.mappers

import com.balenciaga.domains.Product
import com.balenciaga.network.NetworkProduct
import com.balenciaga.utils.EntityMapper
import javax.inject.Inject

// Converts Network Objects into Domain Objects and vice versa
class NetworkMapper @Inject constructor() : EntityMapper<NetworkProduct, Product> {
    override fun mapFromEntity(entity: NetworkProduct): Product {
        return Product(
            id = entity.id,
            name = entity.name,
            price = entity.price,
            description = entity.description,
            colors = entity.colors.split(",").map { it.trim() },
            sizes = entity.sizes.split(",").map { it.trim() },
            dimensions = entity.dimensions,
            composition = entity.composition,
            details = entity.details.split(",").map { it.trim() }
        )
    }

    override fun mapToEntity(domain: Product): NetworkProduct {
        return NetworkProduct(
            id = domain.id,
            name = domain.name,
            price = domain.price,
            description = domain.description,
            colors = domain.colors.joinToString(),
            sizes = domain.sizes.joinToString(),
            dimensions = domain.dimensions,
            composition = domain.composition,
            details = domain.details.joinToString()
        )
    }

    fun mapFromEntityList(entities: List<NetworkProduct>) : List<Product> {
        return entities.map { mapFromEntity(it) }
    }
}