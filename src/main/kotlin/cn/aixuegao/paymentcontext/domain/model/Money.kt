package cn.aixuegao.paymentcontext.domain.model

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated

/**
 * 金额
 *
 * @author Bowen.Huang
 * @date 2023/3/23 23:10
 */
@Suppress("JpaObjectClassSignatureInspection")
@Embeddable
class Money(
    @Column(name = "currency", nullable = false, length = 16) @Enumerated(EnumType.STRING) var currency: Currency,
    @Column(name = "amount", nullable = false) var amount: Double
)