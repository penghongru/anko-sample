package com.hongru.anko_demo.layouts

import android.text.InputType
import android.view.View
import android.widget.LinearLayout
import com.hongru.anko_demo.AnkoDialogActivity
import com.hongru.anko_demo.R
import kotlinx.coroutines.experimental.delay
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.Appcompat
import org.jetbrains.anko.design.longSnackbar
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.sdk25.coroutines.onClick
import java.util.concurrent.TimeUnit

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
class LayoutAnkoDialogUI : AnkoComponent<AnkoDialogActivity> {

    override fun createView(ui: AnkoContext<AnkoDialogActivity>): View = ui.apply {
        verticalLayout {
            val toast = button("toast str") {
                onClick {
                    toast("这是代码中的文本")
                }
            }
            val xmlToast = button("toast xml str") {
                onClick {
                    toast(R.string.toast_test)
                }
            }
            val longToast = button("long toast") {
                onClick {
                    longToast("这是一个长时间的toast")
                }
            }
            button("snackbar str") {
                onClick {
                    snackbar(toast, "这个代码中的文本")
                }
            }
            button("snackbar xml str") {
                onClick {
                    snackbar(xmlToast, R.string.toast_test)
                }
            }
            button("long snackbar") {
                onClick {
                    longSnackbar(longToast, "这是一个长时间的snackbar")
                }
            }
            button("normal dialog") {
                onClick {
                    alert("你好 这是标题", "这是内容信息") {
                        yesButton {
                            toast("选择了是")
                        }
                        noButton {
                            toast("选择了否")
                        }
                    }.show()
                }
            }
            button("appcompat dialog") {
                onClick {
                    alert(Appcompat, "这是一条测试文本").show()
                }
            }
            button("自定义dialog") {
                onClick {
                    alert {
                        customView {
                            verticalLayout {
                                textView("账号")
                                editText {
                                    hint = "请输入账号"
                                }
                                textView("密码")
                                editText {
                                    hint = "请输入密码"
                                    inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
                                }
                                linearLayout {
                                    orientation = LinearLayout.HORIZONTAL
                                    button("登陆") {
                                        onClick {
                                            toast("登陆账号")
                                        }
                                    }
                                    cancelButton {

                                    }
                                }
                            }
                        }
                    }.show()
                }
            }
            button("item selectors dialog") {
                onClick {
                    val items = arrayListOf("哦啦哦啦哦啦哦啦", "木大木大木大木大木大木大")
                    selector("选择一条口号", items, { dialogInterface, i ->
                        toast("选择了 ${items[i]}")
                    })
                }
            }
            button("progress dialog") {
                onClick {
                    val progressDialog = progressDialog("请稍等...", "正在获取数据")
                    repeat(100){
                        delay(1,TimeUnit.SECONDS)
                        progressDialog.progress = progressDialog.progress + 1
                    }
                }
            }
            button("progress dialog") {
                onClick {
                    val progressDialog = progressDialog("请稍等...", "正在获取数据")
                    repeat(100){
                        delay(1,TimeUnit.SECONDS)
                        progressDialog.progress = progressDialog.progress + 1
                    }
                }
            }
        }
    }.view
}