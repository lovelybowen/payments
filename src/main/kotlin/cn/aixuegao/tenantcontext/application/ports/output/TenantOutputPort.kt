package cn.aixuegao.tenantcontext.application.ports.output

import cn.aixuegao.tenantcontext.domain.model.Tenant

/**
 * @author Bowen.Huang
 * @date 2023/3/22 23:20
 */
interface TenantOutputPort {

    open fun getTenantById(tenantId: Long): Tenant?
}