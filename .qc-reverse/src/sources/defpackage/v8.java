package defpackage;

import android.content.Context;
import android.content.IntentFilter;
import android.view.MenuItem;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class v8 {
    public Object a;
    public Object b;

    public v8(v11 v11Var, oi oiVar) {
        this.a = v11Var;
        this.b = oiVar;
    }

    public void c() {
        u8 u8Var = (u8) this.a;
        if (u8Var != null) {
            try {
                ((y8) this.b).l.unregisterReceiver(u8Var);
            } catch (IllegalArgumentException unused) {
            }
            this.a = null;
        }
    }

    public void d() {
        v11 v11Var = (v11) this.a;
        oi oiVar = (oi) this.b;
        HashSet hashSet = v11Var.e;
        if (hashSet.remove(oiVar) && hashSet.isEmpty()) {
            v11Var.b();
        }
    }

    public abstract IntentFilter e();

    public abstract int f();

    public MenuItem g(MenuItem menuItem) {
        if (!(menuItem instanceof n31)) {
            return menuItem;
        }
        n31 n31Var = (n31) menuItem;
        if (((t01) this.b) == null) {
            this.b = new t01(0);
        }
        MenuItem menuItem2 = (MenuItem) ((t01) this.b).get(n31Var);
        if (menuItem2 != null) {
            return menuItem2;
        }
        gl0 gl0Var = new gl0((Context) this.a, n31Var);
        ((t01) this.b).put(n31Var, gl0Var);
        return gl0Var;
    }

    public abstract void h();

    public void i() {
        c();
        IntentFilter intentFilterE = e();
        if (intentFilterE.countActions() == 0) {
            return;
        }
        if (((u8) this.a) == null) {
            this.a = new u8(this);
        }
        ((y8) this.b).l.registerReceiver((u8) this.a, intentFilterE);
    }

    public v8(Context context) {
        this.a = context;
    }

    public v8(y8 y8Var) {
        this.b = y8Var;
    }
}
