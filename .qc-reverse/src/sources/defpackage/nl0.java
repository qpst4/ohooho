package defpackage;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class nl0 extends rh0 implements bl0 {
    public static final Method E;
    public sp1 D;

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                E = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    @Override // defpackage.bl0
    public final void f(zk0 zk0Var, MenuItem menuItem) {
        sp1 sp1Var = this.D;
        if (sp1Var != null) {
            sp1Var.f(zk0Var, menuItem);
        }
    }

    @Override // defpackage.bl0
    public final void i(zk0 zk0Var, cl0 cl0Var) {
        sp1 sp1Var = this.D;
        if (sp1Var != null) {
            sp1Var.i(zk0Var, cl0Var);
        }
    }

    @Override // defpackage.rh0
    public final bv q(Context context, boolean z) {
        ml0 ml0Var = new ml0(context, z);
        ml0Var.setHoverListener(this);
        return ml0Var;
    }
}
