package cn.aixuegao.paymentcontext.domain.event

/**
 * @author Bowen.Huang
 * @date 2023/3/25 17:51
 */
class PaymentCreatedEvent(val id: Long) {

    private val timestamp: Long = System.currentTimeMillis()

    override fun toString(): String {
        return "PaymentCreatedEvent(id=$id, timestamp=$timestamp)"
    }

}