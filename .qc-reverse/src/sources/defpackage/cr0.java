package defpackage;

import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class cr0 extends ly {
    final /* synthetic */ dr0 this$0;

    /* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
    public static final class a extends ly {
        final /* synthetic */ dr0 this$0;

        public a(dr0 dr0Var) {
            this.this$0 = dr0Var;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            activity.getClass();
            this.this$0.a();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            activity.getClass();
            dr0 dr0Var = this.this$0;
            int i = dr0Var.b + 1;
            dr0Var.b = i;
            if (i == 1 && dr0Var.e) {
                dr0Var.g.d(yf0.ON_START);
                dr0Var.e = false;
            }
        }
    }

    public cr0(dr0 dr0Var) {
        this.this$0 = dr0Var;
    }

    @Override // defpackage.ly, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        activity.getClass();
        if (Build.VERSION.SDK_INT < 29) {
            int i = lv0.c;
            Fragment fragmentFindFragmentByTag = activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
            fragmentFindFragmentByTag.getClass();
            ((lv0) fragmentFindFragmentByTag).b = this.this$0.i;
        }
    }

    @Override // defpackage.ly, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        activity.getClass();
        dr0 dr0Var = this.this$0;
        int i = dr0Var.c - 1;
        dr0Var.c = i;
        if (i == 0) {
            Handler handler = dr0Var.f;
            handler.getClass();
            handler.postDelayed(dr0Var.h, 700L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        activity.getClass();
        br0.a(activity, new a(this.this$0));
    }

    @Override // defpackage.ly, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        activity.getClass();
        dr0 dr0Var = this.this$0;
        int i = dr0Var.b - 1;
        dr0Var.b = i;
        if (i == 0 && dr0Var.d) {
            dr0Var.g.d(yf0.ON_STOP);
            dr0Var.e = true;
        }
    }
}
