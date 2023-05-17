package com.baladroid.baseapp.domain.model

import androidx.annotation.StringRes
import com.baladroid.baseapp.R

enum class ValidationErrorType(@StringRes val resourceId: Int) {

    TECHNICAL_ISSUE(R.string.technical_issue)

}


enum class SuccessMessageType(@StringRes val resourceId: Int) {

    LOGIN_SUCCESS(R.string.login_success)

}