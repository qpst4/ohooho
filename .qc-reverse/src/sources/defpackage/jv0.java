package defpackage;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Build;
import androidx.lifecycle.a;
import defpackage.lv0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class jv0 {
    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Activity activity, yf0 yf0Var) {
        a aVarP;
        yf0Var.getClass();
        if (!(activity instanceof gg0) || (aVarP = ((gg0) activity).p()) == null) {
            return;
        }
        aVarP.d(yf0Var);
    }

    public static void b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 29) {
            lv0.a.Companion.getClass();
            activity.registerActivityLifecycleCallbacks(new lv0.a());
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new lv0(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }
}
