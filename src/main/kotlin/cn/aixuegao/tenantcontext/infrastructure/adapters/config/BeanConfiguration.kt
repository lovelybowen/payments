package cn.aixuegao.tenantcontext.infrastructure.adapters.config

import cn.aixuegao.tenantcontext.domain.service.TenantService
import cn.aixuegao.tenantcontext.infrastructure.adapters.output.persistence.TenantPersistenceAdapter
import cn.aixuegao.tenantcontext.infrastructure.adapters.output.persistence.repository.TenantRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * @author Bowen.Huang
 * @date 2023/3/22 23:34
 */
@Configuration
class BeanConfiguration {


    @Bean
    fun tenantPersistenceAdapter(tenantRepository: TenantRepository): TenantPersistenceAdapter {
        return TenantPersistenceAdapter(tenantRepository)
    }

    @Bean
    fun tenantService(tenantPersistenceAdapter: TenantPersistenceAdapter): TenantService {
        return TenantService(tenantPersistenceAdapter)
    }
}