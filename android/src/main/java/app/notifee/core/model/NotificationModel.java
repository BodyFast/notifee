package app.notifee.core.model;

/*
 * Copyright (c) 2016-present Invertase Limited & Contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this library except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import app.notifee.core.KeepForSdk;
import java.util.Objects;

@KeepForSdk
public class NotificationModel {
  private Bundle mNotificationBundle;

  public NotificationModel(Bundle bundle) {
    mNotificationBundle = bundle;
  }

  public static NotificationModel fromBundle(@NonNull Bundle bundle) {
    return new NotificationModel(bundle);
  }

  public @NonNull Integer getHashCode() {
    return getId().hashCode();
  }

  public @NonNull String getId() {
    try {
      return Objects.requireNonNull(mNotificationBundle.getString("id"));
    } catch (Exception e) {
      return "";
    }
  }

  public @Nullable String getTitle() {
    try {
      return mNotificationBundle.getString("title");
    } catch (Exception e) {
      return null;
    }
  }

  public @Nullable String getSubTitle() {
    try {
      return mNotificationBundle.getString("subtitle");
    } catch (Exception e) {
      return null;
    }
  }

  public @Nullable String getBody() {
    try {
      return mNotificationBundle.getString("body");
    } catch (Exception e) {
      return null;
    }
  }

  public @NonNull NotificationAndroidModel getAndroid() {
    return NotificationAndroidModel.fromBundle(mNotificationBundle.getBundle("android"));
  }

  public @NonNull Bundle getData() {
    Bundle data = mNotificationBundle.getBundle("data");
    if (data != null) return (Bundle) data.clone();
    return new Bundle();
  }

  @KeepForSdk
  public Bundle toBundle() {
    return (Bundle) mNotificationBundle.clone();
  }
}
