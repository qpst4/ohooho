package defpackage;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class a4 implements Application.ActivityLifecycleCallbacks {
    public Object b;
    public Activity c;
    public final int d;
    public boolean e = false;
    public boolean f = false;
    public boolean g = false;

    public a4(Activity activity) {
        this.c = activity;
        this.d = activity.hashCode();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        if (this.c == activity) {
            this.c = null;
            this.f = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        if (!this.f || this.g || this.e) {
            return;
        }
        Object obj = this.b;
        try {
            Object obj2 = b4.c.get(activity);
            if (obj2 == obj && activity.hashCode() == this.d) {
                b4.g.postAtFrontOfQueue(new vn1(b4.b.get(activity), 4, obj2));
                this.g = true;
                this.b = null;
            }
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        if (this.c == activity) {
            this.e = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
