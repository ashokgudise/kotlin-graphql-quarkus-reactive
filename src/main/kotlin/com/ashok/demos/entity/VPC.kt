package com.ashok.demos.entity

import javax.persistence.*


@Entity
@Cacheable
@Table(schema ="sysopsdb", name = "vpc")
class VPC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="vpc_id")
    var id: Long? = null

    @Column(name ="vpc_name")
    lateinit var name: String

}