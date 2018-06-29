package com.hongru.anko_demo.layouts

import android.view.View
import com.hongru.anko_demo.AnkoDialogActivity
import com.hongru.anko_demo.AnkoHomeActivity
import com.hongru.anko_demo.MainActivity
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
class LayoutMainUI : AnkoComponent<MainActivity> {
    override fun createView(ui: AnkoContext<MainActivity>): View = ui.apply {
        frameLayout {
            scrollView {
                verticalLayout {
                    button("home") {
                        onClick {
                            startActivity<AnkoHomeActivity>("data" to "hahhahaaha")
                        }
                    }
                    button("dialog"){
                        onClick {
                            startActivity<AnkoDialogActivity>("data" to "hahhahaaha")
                        }
                    }
                }
            }
        }
    }.view
}