package br.com.mirabilis.daggerviperarchitecture.repository.user

import android.content.SharedPreferences
import br.com.mirabilis.daggerviperarchitecture.entity.business.User
import br.com.mirabilis.daggerviperarchitecture.extension.toGson
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by rodrigosimoesrosa on 2019-06-03.
 * Copyright © 2019. All rights reserved.
 */
@Singleton
class SaveUserRepository @Inject constructor() : UserRepository.Save {

    @Inject lateinit var preference: SharedPreferences

    override fun saveUser(user: User): Boolean {
        preference.edit().putString(UserRepository.USER, user.toGson()).apply()
        return true
    }

    override fun unregister() {}

}
