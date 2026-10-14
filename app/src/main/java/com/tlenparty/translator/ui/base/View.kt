package com.tlenparty.translator.ui.base

import com.tlenparty.translator.model.data.AppState

// Нижний уровень. View знает о контексте и фреймворке
interface View {
    // метод, в который приходит некое состояние приложения
    fun renderData(appState: AppState)
}