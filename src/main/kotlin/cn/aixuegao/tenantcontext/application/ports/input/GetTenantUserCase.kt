package cn.aixuegao.tenantcontext.application.ports.input

import cn.aixuegao.tenantcontext.domain.model.Tenant

/**
 * @author Bowen.Huang
 * @date 2023/3/22 23:16
 */
interface GetTenantUserCase {

    fun getTenant(tenantId: Long): Tenant?
}