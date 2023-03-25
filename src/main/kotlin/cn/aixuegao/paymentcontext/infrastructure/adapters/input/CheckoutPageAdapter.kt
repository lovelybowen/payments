package cn.aixuegao.paymentcontext.infrastructure.adapters.input

import cn.aixuegao.paymentcontext.application.ports.input.CheckoutUserCases
import cn.aixuegao.paymentcontext.domain.model.Currency
import cn.aixuegao.paymentcontext.domain.model.Mode
import cn.aixuegao.paymentcontext.domain.model.Money
import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView

/**
 * @author Bowen.Huang
 * @date 2023/3/22 23:12
 */
@Controller
class CheckoutPageAdapter(
    val checkoutUserCases: CheckoutUserCases
) {

    val secretKey = "love-life"

    /**
     * 收银台页面
     */
    @GetMapping("/checkout")
    fun checkoutPage(
        @RequestParam(name = "secretKey") secretKey: String,
        @RequestParam(name = "mode", defaultValue = "PAYMENT") mode: Mode
    ): ModelAndView {

        return ModelAndView("/payment/stripe/checkout", mapOf("mode" to mode.name, "secretKey" to secretKey))
    }

    /**
     * 支付成功页面
     */
    @GetMapping("/success")
    fun successPage(): String {
        return "/payment/stripe/success"
    }

    /**
     * 支付取消页面
     */
    @GetMapping("/cancel")
    fun cancelPage(): String {
        return "/payment/stripe/cancel"
    }


    /**
     * 创建支付会话
     */
    @PostMapping("/create-checkout-session")
    fun checkout(
        @RequestParam(name = "secretKey") secretKey: String,
        @RequestParam(name = "mode", defaultValue = "PAYMENT") mode: Mode,
        request: HttpServletRequest
    ): String {

        if (secretKey != this.secretKey) throw IllegalArgumentException("secretKey is not correct")

        val host = request.getHeader("host")

        //Mock payment client request parameters.
        val money = Money(Currency.USD, 20.00)
        val successCallbackUrl = "http://$host/success"
        val cancelCallbackUrl = "http://$host/cancel"
        val product = "XTV Monthly"

        var checkoutUrl = checkoutUserCases.checkout(product, money, successCallbackUrl, cancelCallbackUrl, mode)

        return "redirect:$checkoutUrl"
    }


}