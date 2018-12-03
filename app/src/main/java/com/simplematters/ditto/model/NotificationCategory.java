package com.simplematters.ditto.model;

/**
 * Copy of the NotificationCategory that exists in the Wear Ditto app. We copy this as the Ditto
 * app serializes these enum values in their intents.
 *
 * Serialized data, as it turns out, is super difficult to mock outside of manually implementing the
 * serialization spec. Since we don't want to do that, instead of we copy this class file (and put
 * it in the exact same package, very important) and the serialization logic for enums will
 * serialize this in the same way it would the real enum.
 *
 * However, because of how the serialization works, none of these values will be used in the Ditto
 * app. That is to say, if we were to override the default vibration type for a CALL, it wouldn't
 * be sent to the Ditto app. This is because enum serialization simply is the package and enum class
 * name along with the result of calling .name() on the enum value itself. However, this should
 * still work so long as the enum in the Ditto app isn't renamed or moved. Added or removed fields
 * should be fine.
 */
public enum NotificationCategory {
  NOTIFICATION_TYPE_TEXT,
  NOTIFICATION_TYPE_EMAIL,
  NOTIFICATION_TYPE_TETHER,
  NOTIFICATION_TYPE_CALENDAR,
  NOTIFICATION_TYPE_GENERAL_TIMER,
}
