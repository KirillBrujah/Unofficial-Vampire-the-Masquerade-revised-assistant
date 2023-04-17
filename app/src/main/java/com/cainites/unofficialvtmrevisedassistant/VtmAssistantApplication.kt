package com.cainites.unofficialvtmrevisedassistant

import android.app.Application
import com.cainites.unofficialvtmrevisedassistant.database.AppDatabase

class VtmAssistantApplication: Application() {
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this)}
}