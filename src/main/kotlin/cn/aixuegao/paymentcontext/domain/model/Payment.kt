package cn.aixuegao.paymentcontext.domain.model

import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.hibernate.annotations.Table

/**
 * @author Bowen.Huang
 * @date 2023/3/23 23:01
 */
@Suppress("JpaObjectClassSignatureInspection")
@Entity
@Table(appliesTo = "payment")
class Payment(
    @Embedded var money: Money,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null
)