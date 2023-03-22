package cn.aixuegao.tenantcontext.infrastructure.adapters.output.customizedexception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.LocalDateTime


/**
 * @author Bowen.Huang
 * @date 2023/3/23 0:01
 */
@ControllerAdvice
@RestController
class CustomizedExceptionAdapter: ResponseEntityExceptionHandler() {


    @ExceptionHandler(Exception::class)
    fun handleAllExceptions(ex: Exception, request: WebRequest): ResponseEntity<Any?> {
        val exceptionResponse =
            ExceptionResponse(LocalDateTime.now(), ex.message, arrayListOf(request.getDescription(false)))
        return ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}