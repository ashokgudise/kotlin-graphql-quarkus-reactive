package com.ashok.demos.resource

import com.ashok.demos.entity.*
import com.ashok.demos.service.ClusterService
import io.smallrye.mutiny.Uni
import org.eclipse.microprofile.graphql.GraphQLApi
import org.eclipse.microprofile.graphql.Mutation
import org.eclipse.microprofile.graphql.Query
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@GraphQLApi
@ApplicationScoped
class ClusterResource {

    @Inject
    lateinit var clusterService: ClusterService

    @Query("listAllEC2s")
    fun listAllEC2Instances(): Uni<List<EC2>>  = clusterService.listAllEC2Instances()

    @Query("listAllAZs")
    fun listAllAZs(): Uni<List<Azone>> = clusterService.listAllAZs()

    @Query("listAllRegions")
    fun listAllRegions(): Uni<List<Region>> = clusterService.listAllRegions()

    @Query("listAllSubnets")
    fun listAllSubnets(): Uni<List<Subnet>> = clusterService.listAllSubnets()

    @Query("listAllVPCs")
    fun listAllVPCs(): Uni<List<VPC>> = clusterService.listAllVpcs()

    @Mutation("addEC2Instance")
    fun addEC2Instance(ec2: EC2, subnetId: Long): Uni<EC2> = clusterService.saveEC2Insance(ec2, subnetId)

    @Mutation("deleteEC2Instance")
    fun deleteEC2Instance(instanceId: Long): Uni<Boolean> = clusterService.deleteEC2Instance(instanceId)
 }