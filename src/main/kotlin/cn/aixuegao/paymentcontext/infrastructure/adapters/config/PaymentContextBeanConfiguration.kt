package cn.aixuegao.paymentcontext.infrastructure.adapters.config

import cn.aixuegao.paymentcontext.domain.service.PaymentService
import cn.aixuegao.paymentcontext.infrastructure.adapters.output.event.PaymentEventPublisherAdapter
import cn.aixuegao.paymentcontext.infrastructure.adapters.output.persistence.PaymentPersistenceAdapter
import cn.aixuegao.paymentcontext.infrastructure.adapters.output.persistence.PaymentRepository
import cn.aixuegao.paymentcontext.infrastructure.adapters.output.remote.CheckoutProviderAdapter
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * 支付领域Bean配置
 *
 * @author Bowen.Huang
 * @date 2023/3/22 23:34
 */
@Configuration
class PaymentContextBeanConfiguration {


    @Bean
    fun paymentPersistenceAdapter(paymentRepository: PaymentRepository): PaymentPersistenceAdapter {
        return PaymentPersistenceAdapter(paymentRepository)
    }

    @Bean
    fun checkoutRemoteAdapter(): CheckoutProviderAdapter {
        return CheckoutProviderAdapter()
    }

    @Bean
    fun paymentEventPublisherAdapter(applicationEventPublisher: ApplicationEventPublisher): PaymentEventPublisherAdapter {
        return PaymentEventPublisherAdapter(applicationEventPublisher)
    }

    @Bean
    fun paymentService(
        paymentPersistenceAdapter: PaymentPersistenceAdapter,
        checkoutProviderAdapter: CheckoutProviderAdapter,
        paymentEventPublisherAdapter: PaymentEventPublisherAdapter
    ): PaymentService {
        return PaymentService(paymentPersistenceAdapter, checkoutProviderAdapter, paymentEventPublisherAdapter)
    }
}