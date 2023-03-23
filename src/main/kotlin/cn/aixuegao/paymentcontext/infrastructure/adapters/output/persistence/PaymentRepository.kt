package cn.aixuegao.paymentcontext.infrastructure.adapters.output.persistence

import cn.aixuegao.paymentcontext.domain.model.Payment
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

/**
 * @author Bowen.Huang
 * @date 2023/3/22 23:29
 */
@Repository
interface PaymentRepository: CrudRepository<Payment, Long>