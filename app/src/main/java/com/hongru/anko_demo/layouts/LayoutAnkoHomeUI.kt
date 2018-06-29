package com.hongru.anko_demo.layouts

import android.view.View
import com.hongru.anko_demo.AnkoHomeActivity
import com.yanzhenjie.permission.AndPermission
import com.yanzhenjie.permission.Permission
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

//<pre>
//                       _oo0oo_
//                      o8888888o
//                      88" . "88
//                      (| -_- |)
//                      0\  =  /0
//                    ___/`---'\___
//                  .' \\|     |// '.
//                 / \\|||  :  |||// \
//                / _||||| -:- |||||- \
//               |   | \\\  -  /// |   |
//               | \_|  ''\---/''  |_/ |
//               \  .-\__  '-'  ___/-. /
//             ___'. .'  /--.--\  `. .'___
//          ."" '<  `.___\_<|>_/___.' >' "".
//         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
//         \  \ `_.   \_ __\ /__ _/   .-` /  /
//     =====`-.____`.___ \_____/___.-`___.-'=====
//                       `=---='
//
//
//     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//
//               佛祖保佑         永无BUG
//</pre>


/**
 *@author 彭鸿儒
 * @date 2018/6/29
 * 邮箱:peng_hongru@163.com
 */
class LayoutAnkoHomeUI : AnkoComponent<AnkoHomeActivity> {
    override fun createView(ui: AnkoContext<AnkoHomeActivity>): View = ui.apply {
        verticalLayout {
            button("make a call") {
                onClick {
                    AndPermission.with(ui.ctx)
                            .runtime()
                            .permission(Permission.CALL_PHONE)
                            .onGranted {
                                makeCall("15338739039")
                            }.start()
                }
            }
            button("send a text") {
                onClick {
                    val sendSMS = sendSMS("15338739039", "这是一条测试短信")
                    AnkoLogger("测试").info {
                        //很多手机型号并没有结果返回
                        if (sendSMS) "短信发送成功".toInt() else "短信发送失败".toInt()
                    }
                }
            }
            button("browse the web") {
                onClick {
                    browse("http://m.baidu.com")
                }
            }
            button("share some text") {
                onClick {
                    share("这是一条分享文本", "这是文本标题")
                }
            }
            button("send a email") {
                onClick {
                    email("574027047@qq.com", "这是邮件标题", "这是邮件内容")
                }
            }
        }
    }.view
}