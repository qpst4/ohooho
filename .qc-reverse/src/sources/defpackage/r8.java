package defpackage;

import android.app.Activity;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class r8 {
    public static OnBackInvokedDispatcher a(Activity activity) {
        return activity.getOnBackInvokedDispatcher();
    }

    public static OnBackInvokedCallback b(Object obj, y8 y8Var) {
        Objects.requireNonNull(y8Var);
        q8 q8Var = new q8(0, y8Var);
        g0.i(obj).registerOnBackInvokedCallback(1000000, q8Var);
        return q8Var;
    }

    public static void c(Object obj, Object obj2) {
        g0.i(obj).unregisterOnBackInvokedCallback(g0.f(obj2));
    }
}
