package cn.aixuegao.paymentcontext.domain.model

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated

/**
 * @author Bowen.Huang
 * @date 2023/3/23 23:10
 */
@Embeddable
class Money(
    @Column(name = "currency") @Enumerated(EnumType.STRING) var currency: Currency,
    @Column(name = "amount") var amount: Double
)