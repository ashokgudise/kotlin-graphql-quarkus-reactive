package com.ashok.demos.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.*

@Entity
@Cacheable
@Table(schema = "sysopsdb", name="ec2")
class EC2{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ec2_id")
    var id: Long? = null

    @Column(name ="ec2_name")
    lateinit var name: String

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "subnet_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    var subnet: Subnet? = null
}