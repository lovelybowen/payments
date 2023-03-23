package cn.aixuegao.tenantcontext.infrastructure.adapters.input

import cn.aixuegao.tenantcontext.application.ports.input.GetTenantUserCase
import cn.aixuegao.tenantcontext.domain.model.Tenant
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * @author Bowen.Huang
 * @date 2023/3/22 23:12
 */
@RestController
@RequestMapping("/api/tenant")
class TenantRestAdapter(
    val getTenantUserCase: GetTenantUserCase
) {

    @GetMapping
    fun getTenant(@RequestParam id: Long): Tenant? {

        return getTenantUserCase.getTenant(id)
    }
}