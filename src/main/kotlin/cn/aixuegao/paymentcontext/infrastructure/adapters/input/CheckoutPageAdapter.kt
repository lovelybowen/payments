package cn.aixuegao.paymentcontext.infrastructure.adapters.input

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

/**
 * @author Bowen.Huang
 * @date 2023/3/22 23:12
 */
@Controller
class CheckoutPageAdapter {

    @GetMapping("/checkout")
    fun checkoutPage(): String {
        return "/payment/stripe/checkout"
    }
}