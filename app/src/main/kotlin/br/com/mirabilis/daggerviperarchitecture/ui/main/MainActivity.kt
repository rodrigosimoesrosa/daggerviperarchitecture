package br.com.mirabilis.daggerviperarchitecture.ui.main

import android.os.Bundle
import android.view.View
import br.com.mirabilis.daggerviperarchitecture.R
import br.com.mirabilis.daggerviperarchitecture.base.ui.MVPBaseActivity
import br.com.mirabilis.daggerviperarchitecture.entity.business.User
import br.com.mirabilis.daggerviperarchitecture.presenter.main.Main
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by rodrigosimoesrosa on 2019-05-27.
 * Copyright © 2019. All rights reserved.
 */
class MainActivity : MVPBaseActivity<Main.View, Main.Presenter>(), Main.View {

    override fun getLayout(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        btnLogout.setOnClickListener { presenter.logout() }
    }

    override fun onResume() {
        super.onResume()
        presenter.loadUser()
    }

    override fun showUser(user: User) {
        progressBar.visibility = View.GONE
        lblText.visibility = View.VISIBLE
        btnLogout.visibility = View.VISIBLE

        lblText.text = user.name
    }

    override fun showFailed(throwable: Throwable) {
        showToast(throwable.message)
    }

}
