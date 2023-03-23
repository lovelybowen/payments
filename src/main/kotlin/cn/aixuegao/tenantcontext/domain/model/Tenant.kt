package cn.aixuegao.tenantcontext.domain.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.hibernate.annotations.Table

/**
 * @author Bowen.Huang
 * @date 2023/3/19 23:18
 */
@Suppress("JpaObjectClassSignatureInspection")
@Entity
@Table(appliesTo = "tenant")
class Tenant(
    var name: String,
    var secretKey: String,
    var notificationUrl: String,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
)