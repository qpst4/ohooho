package defpackage;

import android.app.Activity;
import android.app.Application;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class br0 {
    public static final void a(Activity activity, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activity.getClass();
        activityLifecycleCallbacks.getClass();
        activity.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }
}
