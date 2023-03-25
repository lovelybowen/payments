package cn.aixuegao.paymentcontext.application.ports.input

import cn.aixuegao.paymentcontext.domain.event.PaymentCreatedEvent
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

/**
 * 支付事件监听
 *
 * @author Bowen.Huang
 * @date 2023/3/25 18:24
 */
@Component
class EventListener {

    @TransactionalEventListener(
        phase = TransactionPhase.AFTER_COMMIT,
        fallbackExecution = true,
        classes = [PaymentCreatedEvent::class]
    )
    fun onPaymentCreatedEvent(event: PaymentCreatedEvent) {
        println("Received paymentCreatedEvent: $event")
    }
}