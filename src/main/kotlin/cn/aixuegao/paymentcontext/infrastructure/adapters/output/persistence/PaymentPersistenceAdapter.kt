package cn.aixuegao.paymentcontext.infrastructure.adapters.output.persistence

import cn.aixuegao.paymentcontext.application.ports.output.PaymentPersistenceOutputPort
import cn.aixuegao.paymentcontext.domain.model.Payment

/**
 * @author Bowen.Huang
 * @date 2023/3/24 0:05
 */
class PaymentPersistenceAdapter(
    private val paymentRepository: PaymentRepository
) : PaymentPersistenceOutputPort {


    override fun save(payment: Payment) {
        paymentRepository.save(payment)
    }


}