package cn.aixuegao.paymentcontext.application.ports.output

import cn.aixuegao.paymentcontext.domain.event.PaymentCreatedEvent

/**
 * @author Bowen.Huang
 * @date 2023/3/25 18:12
 */
interface PaymentEventPublisher {

    /**
     * 发布 创建支付账单事件
     *
     * @param event
     */
    fun publishPaymentCreatedEvent(event: PaymentCreatedEvent)
}