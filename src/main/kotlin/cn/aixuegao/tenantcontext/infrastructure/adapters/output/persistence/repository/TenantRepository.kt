package cn.aixuegao.tenantcontext.infrastructure.adapters.output.persistence.repository

import cn.aixuegao.tenantcontext.domain.model.Tenant
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

/**
 * @author Bowen.Huang
 * @date 2023/3/22 23:29
 */
@Repository
interface TenantRepository: CrudRepository<Tenant, Long>