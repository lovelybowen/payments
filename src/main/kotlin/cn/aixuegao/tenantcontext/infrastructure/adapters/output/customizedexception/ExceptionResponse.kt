package cn.aixuegao.tenantcontext.infrastructure.adapters.output.customizedexception

import java.time.LocalDateTime

/**
 * @author Bowen.Huang
 * @date 2023/3/23 0:03
 */
data class ExceptionResponse(
    val timestamp: LocalDateTime,
    val message: String?,
    val details: List<String>
)
