package com.balenciaga.utils

// Mapper Interface
// Contains method signatures for converting Entity objects to Domain objects and vice versa
interface EntityMapper<Entity, Domain> {
    fun mapFromEntity(entity: Entity) : Domain
    fun mapToEntity(domain: Domain) : Entity
}