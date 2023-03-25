package cn.aixuegao.paymentcontext.domain.service

import cn.aixuegao.paymentcontext.application.ports.input.CheckoutUserCases
import cn.aixuegao.paymentcontext.application.ports.output.CheckoutProviderOutput
import cn.aixuegao.paymentcontext.application.ports.output.PaymentEventPublisher
import cn.aixuegao.paymentcontext.application.ports.output.PaymentPersistenceOutputPort
import cn.aixuegao.paymentcontext.domain.event.PaymentCreatedEvent
import cn.aixuegao.paymentcontext.domain.model.Mode
import cn.aixuegao.paymentcontext.domain.model.Money
import cn.aixuegao.paymentcontext.domain.model.Payment

/**
 * 支付领域服务
 *
 * @author Bowen.Huang
 * @date 2023/3/23 23:54
 */
class PaymentService(
    private val paymentPersistenceOutputPort: PaymentPersistenceOutputPort,
    private val checkoutProviderOutput: CheckoutProviderOutput,
    private val paymentEventPublisher: PaymentEventPublisher
) : CheckoutUserCases {

    override fun checkout(
        product: String,
        money: Money,
        successCallbackUrl: String,
        cancelCallbackUrl: String,
        mode: Mode
    ): String {

        val payment = Payment(product, money, successCallbackUrl, cancelCallbackUrl, mode)
        paymentPersistenceOutputPort.save(payment)
        payment?.id?.let { PaymentCreatedEvent(it) }?.let { paymentEventPublisher.publishPaymentCreatedEvent(it) }


        return checkoutProviderOutput.checkout(payment)
    }


}