package cn.aixuegao.tenantcontext.domain.exception

/**
 * @author Bowen.Huang
 * @date 2023/3/22 23:25
 */
class TenantNotFoundException(name: String): RuntimeException() {
    override val message: String = "Tenant $name not found"
}