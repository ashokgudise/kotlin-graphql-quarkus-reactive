package com.ashok.demos.service

import com.ashok.demos.entity.*
import com.ashok.demos.repository.*
import io.smallrye.mutiny.Uni
import org.slf4j.LoggerFactory
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import javax.transaction.Transactional

@ApplicationScoped
class ClusterService {

    @Inject
    lateinit var ec2Instance: EC2Repository

    @Inject
    lateinit var azRepository: AzoneRepository

    @Inject
    lateinit var regionRepository: RegionRepository

    @Inject
    lateinit var subnetRepository: SubnetRepository

    @Inject
    lateinit var vpcRepository: VPCRepository

    fun listAllEC2Instances(): Uni<List<EC2>> =  ec2Instance.listAll()

    fun listAllAZs(): Uni<List<Azone>> = azRepository.listAll()

    fun listAllRegions(): Uni<List<Region>> = regionRepository.listAll()

    fun listAllSubnets(): Uni<List<Subnet>> = subnetRepository.listAll()

    fun listAllVpcs(): Uni<List<VPC>> = vpcRepository.listAll()

    @Transactional
    fun saveEC2Insance(newEC2: EC2, subnetId: Long):Uni<EC2> {

        return subnetRepository.findById(subnetId)
            .onItem().ifNull().failWith(IllegalArgumentException("Invalid subnet id"))
            .onItem().transformToUni { subnet -> newEC2.subnet = subnet; Uni.createFrom().item(newEC2) }
            .onItem().transformToUni { it -> ec2Instance.persistAndFlush(it) }
            .onItem().invoke { it ->
                LoggerFactory.getLogger(javaClass).info("EC2 instance with id ${it.id} created")
            }

    }

    @Transactional
    fun deleteEC2Instance(id: Long): Uni<Boolean> {

        return ec2Instance.deleteById(id)
            .onItem().invoke { it ->
                LoggerFactory.getLogger(javaClass).info("EC2 instance with id $id deleted")
            }
            .onItem().transform { true }
    }

}