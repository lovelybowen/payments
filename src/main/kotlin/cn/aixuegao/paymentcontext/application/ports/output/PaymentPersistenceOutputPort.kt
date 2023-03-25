package cn.aixuegao.paymentcontext.application.ports.output

import cn.aixuegao.paymentcontext.domain.model.Payment

/**
 * @author Bowen.Huang
 * @date 2023/3/24 0:00
 */
interface PaymentPersistenceOutputPort {

    fun save(payment: Payment)
}