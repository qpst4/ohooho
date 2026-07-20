package defpackage;

import android.content.Context;
import android.os.Build;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class gk1 {
    public static final i9 i = new i9(new gj1(2), new c70(7));
    public final Context a;
    public final String b;
    public final i9 c;
    public final r41 d;
    public final w7 e;
    public final int f;
    public final ow0 g;
    public final a70 h;

    public gk1(Context context) {
        v60 v60Var = v60.b;
        xy0.e("Null context is not permitted.", context);
        i9 i9Var = i;
        xy0.e("Api must not be null.", i9Var);
        xy0.e("Settings must not be null; use Settings.DEFAULT_SETTINGS instead.", v60Var);
        Context applicationContext = context.getApplicationContext();
        xy0.e("The provided context did not have an application context.", applicationContext);
        this.a = applicationContext;
        String attributionTag = Build.VERSION.SDK_INT >= 30 ? context.getAttributionTag() : null;
        this.b = attributionTag;
        this.c = i9Var;
        this.d = r41.a;
        this.e = new w7(i9Var, attributionTag);
        a70 a70VarD = a70.d(applicationContext);
        this.h = a70VarD;
        this.f = a70VarD.h.getAndIncrement();
        this.g = v60Var.a;
        kk1 kk1Var = a70VarD.m;
        kk1Var.sendMessage(kk1Var.obtainMessage(7, this));
    }

    public final ra a() {
        ra raVar = new ra(6);
        Set set = Collections.EMPTY_SET;
        if (((mb) raVar.c) == null) {
            raVar.c = new mb(0);
        }
        ((mb) raVar.c).addAll(set);
        Context context = this.a;
        raVar.e = context.getClass().getName();
        raVar.d = context.getPackageName();
        return raVar;
    }

    public final void b(q41 q41Var) {
        tb0 tb0Var = new tb0(18, false);
        l10[] l10VarArr = {i1.m};
        tb0Var.c = new tb0(25, q41Var);
        qx0 qx0Var = new qx0(tb0Var, l10VarArr);
        l41 l41Var = new l41();
        a70 a70Var = this.h;
        a70Var.getClass();
        tj1 tj1Var = new tj1(new ck1(qx0Var, l41Var, this.g), a70Var.i.get(), this);
        kk1 kk1Var = a70Var.m;
        kk1Var.sendMessage(kk1Var.obtainMessage(4, tj1Var));
    }
}
