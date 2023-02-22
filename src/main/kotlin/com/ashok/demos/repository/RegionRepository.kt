package com.ashok.demos.repository

import com.ashok.demos.entity.Region
import io.quarkus.hibernate.reactive.panache.PanacheRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class RegionRepository: PanacheRepository<Region> {
    fun findByName(name: String) = find("name", name).firstResult<Region>()
    fun deleteInstance(id: Long) = delete("id", id)
}