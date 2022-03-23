package com.kay.progayim.ui

import androidx.annotation.StringRes

sealed class Event(){
    class ShowToast(@StringRes val resId: Int): Event()
    object ShowLoadingToast: Event()
    object ShowFinishedLoadingToast: Event()
}