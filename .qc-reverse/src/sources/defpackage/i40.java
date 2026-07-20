package defpackage;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.lifecycle.a;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class i40 implements u70, rx0, fg1 {
    public final j30 b;
    public final eg1 c;
    public a d = null;
    public qx0 e = null;

    public i40(j30 j30Var, eg1 eg1Var) {
        this.b = j30Var;
        this.c = eg1Var;
    }

    public final void a(yf0 yf0Var) {
        this.d.d(yf0Var);
    }

    public final void b() {
        if (this.d == null) {
            this.d = new a(this);
            qx0 qx0Var = new qx0(this);
            this.e = qx0Var;
            qx0Var.b();
            tk0.f(this);
        }
    }

    @Override // defpackage.rx0
    public final e8 c() {
        b();
        return (e8) this.e.c;
    }

    @Override // defpackage.u70
    public final jm0 k() {
        Application application;
        j30 j30Var = this.b;
        Context applicationContext = j30Var.o().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        jm0 jm0Var = new jm0(0);
        LinkedHashMap linkedHashMap = (LinkedHashMap) jm0Var.a;
        if (application != null) {
            linkedHashMap.put(ix.g, application);
        }
        linkedHashMap.put(tk0.g, this);
        linkedHashMap.put(tk0.h, this);
        Bundle bundle = j30Var.h;
        if (bundle != null) {
            linkedHashMap.put(tk0.i, bundle);
        }
        return jm0Var;
    }

    @Override // defpackage.fg1
    public final eg1 m() {
        b();
        return this.c;
    }

    @Override // defpackage.gg0
    public final a p() {
        b();
        return this.d;
    }
}
