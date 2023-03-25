package cn.aixuegao.paymentcontext.application.ports.output

import cn.aixuegao.paymentcontext.domain.model.Payment

/**
 * @author Bowen.Huang
 * @date 2023/3/25 15:52
 */
interface CheckoutProviderOutput {

    fun checkout(payment: Payment): String
}