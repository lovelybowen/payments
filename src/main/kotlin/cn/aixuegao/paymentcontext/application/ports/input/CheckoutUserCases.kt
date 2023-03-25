package cn.aixuegao.paymentcontext.application.ports.input

import cn.aixuegao.paymentcontext.domain.model.Mode
import cn.aixuegao.paymentcontext.domain.model.Money

/**
 * @author Bowen.Huang
 * @date 2023/3/23 23:58
 */
interface CheckoutUserCases {


    fun checkout(product: String, money: Money, successCallbackUrl: String, cancelCallbackUrl: String, mode: Mode): String
}