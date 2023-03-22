package cn.aixuegao.tenantcontext.domain.service

import cn.aixuegao.tenantcontext.application.ports.input.GetTenantUserCase
import cn.aixuegao.tenantcontext.application.ports.output.TenantOutputPort
import cn.aixuegao.tenantcontext.domain.model.Tenant

/**
 * @author Bowen.Huang
 * @date 2023/3/19 23:18
 */
class TenantService(private val tenantOutputPort: TenantOutputPort) : GetTenantUserCase {

    override fun getTenant(tenantId: Long): Tenant? {
        return tenantOutputPort.getTenantById(tenantId)
    }
}