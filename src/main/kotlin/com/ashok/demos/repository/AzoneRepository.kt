package com.ashok.demos.repository

import com.ashok.demos.entity.Azone
import io.quarkus.hibernate.reactive.panache.PanacheRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class AzoneRepository: PanacheRepository<Azone> {
    fun findByName(name: String) = find("name", name).firstResult<Azone>()
    fun deleteInstance(id: Long) = delete("id", id)
}