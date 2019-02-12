package com.mobile.fieldx.mainsrc

import javax.inject.Inject

class Login_Response @Inject constructor(private var login_Repository: Login_Repository) {
    fun backToView() = login_Repository.getLoginResponse()
}