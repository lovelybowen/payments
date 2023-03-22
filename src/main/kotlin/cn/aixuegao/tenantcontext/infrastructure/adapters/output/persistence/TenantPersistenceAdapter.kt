package cn.aixuegao.tenantcontext.infrastructure.adapters.output.persistence

import cn.aixuegao.tenantcontext.application.ports.output.TenantOutputPort
import cn.aixuegao.tenantcontext.domain.model.Tenant
import cn.aixuegao.tenantcontext.infrastructure.adapters.output.persistence.repository.TenantRepository

/**
 * @author Bowen.Huang
 * @date 2023/3/22 23:28
 */
class TenantPersistenceAdapter(
    private val tenantRepository: TenantRepository
) : TenantOutputPort {

    override fun getTenantById(tenantId: Long): Tenant? {
        return tenantRepository.findById(tenantId).orElse(null)
    }
}