package cn.aixuegao.paymentcontext.infrastructure.adapters.output.event

import cn.aixuegao.paymentcontext.application.ports.output.PaymentEventPublisher
import cn.aixuegao.paymentcontext.domain.event.PaymentCreatedEvent
import org.springframework.context.ApplicationEventPublisher

/**
 * @author Bowen.Huang
 * @date 2023/3/25 18:14
 */
class PaymentEventPublisherAdapter(
    private val applicationEventPublisher: ApplicationEventPublisher
) : PaymentEventPublisher {

    override fun publishPaymentCreatedEvent(event: PaymentCreatedEvent) {
        applicationEventPublisher.publishEvent(event)
    }
}