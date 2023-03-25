package cn.aixuegao.paymentcontext.infrastructure.adapters.output.remote

import cn.aixuegao.paymentcontext.application.ports.output.CheckoutProviderOutput
import cn.aixuegao.paymentcontext.domain.model.Mode
import cn.aixuegao.paymentcontext.domain.model.Payment
import com.stripe.Stripe
import com.stripe.model.checkout.Session
import com.stripe.param.checkout.SessionCreateParams
import java.math.BigDecimal

/**
 * @author Bowen.Huang
 * @date 2023/3/25 15:59
 */
class CheckoutProviderAdapter : CheckoutProviderOutput {

    init {
        Stripe.apiKey =
            "sk_test_51JSGVfJtxEuIXOybVeT8UcJZGnitDR0LQXlxztlg5w2njt3pYlbCDow6soIgRxVZpC6KcoYlsUQUKt1X3S4ujoJz00DA7JdtL0"
    }

    override fun checkout(payment: Payment): String =
        when (payment.mode) {
            Mode.PAYMENT -> buildSessionParams(payment) { SessionCreateParams.Mode.PAYMENT }
            Mode.SUBSCRIPTION -> buildSessionParams(payment) {
                SessionCreateParams.Mode.SUBSCRIPTION
            }

            else -> throw IllegalArgumentException("mode is not supported")
        }

    private fun buildSessionParams(
        payment: Payment,
        mode: () -> SessionCreateParams.Mode
    ): String {
        val params = SessionCreateParams.builder()
            .setMode(mode())
            .setSuccessUrl(payment.successCallbackUrl)
            .setCancelUrl(payment.cancelCallbackUrl)
            .setClientReferenceId(payment.id.toString())
            .addLineItem(buildLineItemParams(payment))
            .build()

        val session = Session.create(params)
        return session.url
    }

    private fun buildLineItemParams(payment: Payment): SessionCreateParams.LineItem {
        val priceData = SessionCreateParams.LineItem.PriceData.builder()
            .setCurrency(payment.money.currency.name.toLowerCase())
            .setUnitAmountDecimal(payment.money.amount.toBigDecimal().multiply(BigDecimal("100")))
            .setProductData(
                SessionCreateParams.LineItem.PriceData.ProductData.builder()
                    .setName(payment.product)
                    .build()
            )

        if (payment.mode == Mode.SUBSCRIPTION) {
            priceData.setRecurring(
                SessionCreateParams.LineItem.PriceData.Recurring.builder()
                    .setInterval(SessionCreateParams.LineItem.PriceData.Recurring.Interval.MONTH)
                    .build()
            )
        }

        return SessionCreateParams.LineItem.builder()
            .setQuantity(1L)
            .setPriceData(priceData.build())
            .build()
    }
}