package cn.aixuegao.paymentcontext.domain.model

import jakarta.persistence.*
import org.hibernate.annotations.Table

/**
 * 支付请求
 *
 * @author Bowen.Huang
 * @date 2023/3/23 23:01
 */
@Suppress("JpaObjectClassSignatureInspection")
@Entity
@Table(appliesTo = "payment")
class Payment(
    @Column(name = "product", length = 128) var product: String,
    @Embedded var money: Money,
    @Column(name = "success_callback_url", length = 512) var successCallbackUrl: String,
    @Column(name = "cancel_callback_url", length = 512) var cancelCallbackUrl: String,
    @Column(name = "mode", length = 32) @Enumerated(EnumType.STRING) var mode: Mode,

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null
)