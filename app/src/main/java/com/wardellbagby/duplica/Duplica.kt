package com.wardellbagby.duplica

import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.simplematters.ditto.model.NotificationCategory
import com.simplematters.ditto.model.NotificationCategory.NOTIFICATION_TYPE_CALENDAR
import com.simplematters.ditto.model.NotificationCategory.NOTIFICATION_TYPE_EMAIL
import com.simplematters.ditto.model.NotificationCategory.NOTIFICATION_TYPE_GENERAL_TIMER
import com.simplematters.ditto.model.NotificationCategory.NOTIFICATION_TYPE_TETHER
import com.simplematters.ditto.model.NotificationCategory.NOTIFICATION_TYPE_TEXT

class Duplica : BroadcastReceiver() {

  companion object {
    private const val DITTO_INTENT_ACTION_NOTIFICATION_RECEIVED =
      "INTENT_ACTION_NOTIFICATION_RECEIVED"
    private const val DITTO_EXTRA_INTENT_NOTIFICATION_TYPE = "EXTRA_INTENT_NOTIFICATION_TYPE"
    private const val DITTO_EXTRA_INTENT_NOTIFICATION_BUNDLE =
      "EXTRA_INTENT_NOTIFICATION_BUNDLE"

    private const val NOTIFICATION_INTENT_ACTION = "com.wardellbagby.DUPLICA"
    private const val EXTRA_INTENT_VIBRATION_COUNT = "VIBRATION_COUNT"
    private const val DEFAULT_VIBRATION_COUNT = 2
    private const val DITTO_PACKAGE = "com.simplematters.wearditto"
    private const val DITTO_SERVICE_CLASS = "com.simplematters.ditto.service.DittoService"
  }

  override fun onReceive(
    context: Context,
    intent: Intent?
  ) {
    if (intent == null || intent.action != NOTIFICATION_INTENT_ACTION) return

    val vibrationCount = intent.getIntExtra(EXTRA_INTENT_VIBRATION_COUNT, DEFAULT_VIBRATION_COUNT)

    Intent(DITTO_INTENT_ACTION_NOTIFICATION_RECEIVED)
        .putExtra(
            DITTO_EXTRA_INTENT_NOTIFICATION_TYPE,
            getNotificationTypeForVibrationCount(vibrationCount)
        )
        .putExtra(DITTO_EXTRA_INTENT_NOTIFICATION_BUNDLE, Bundle.EMPTY)
        .setComponent(ComponentName(DITTO_PACKAGE, DITTO_SERVICE_CLASS))
        .run { context.startService(this) }
  }

  private fun getNotificationTypeForVibrationCount(count: Int): NotificationCategory {
    return when (count) {
      1 -> NOTIFICATION_TYPE_EMAIL
      3 -> NOTIFICATION_TYPE_CALENDAR
      4 -> NOTIFICATION_TYPE_TETHER
      5 -> NOTIFICATION_TYPE_GENERAL_TIMER
      else -> NOTIFICATION_TYPE_TEXT
    }
  }
}
