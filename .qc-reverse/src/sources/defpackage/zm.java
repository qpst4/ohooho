package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class zm {
    public boolean a;
    public boolean b;
    public Object c;
    public Serializable d;

    public zm(boolean z) {
        this.a = z;
    }

    public void a(jk... jkVarArr) {
        if (!this.a) {
            s1.f("no cipher suites for cleartext connections");
            return;
        }
        String[] strArr = new String[jkVarArr.length];
        for (int i = 0; i < jkVarArr.length; i++) {
            strArr[i] = jkVarArr[i].a;
        }
        b(strArr);
    }

    public void b(String... strArr) {
        if (!this.a) {
            s1.f("no cipher suites for cleartext connections");
        } else if (strArr.length != 0) {
            this.c = (String[]) strArr.clone();
        } else {
            zy.n("At least one cipher suite is required");
        }
    }

    public void c(g61... g61VarArr) {
        if (!this.a) {
            s1.f("no TLS versions for cleartext connections");
            return;
        }
        String[] strArr = new String[g61VarArr.length];
        for (int i = 0; i < g61VarArr.length; i++) {
            strArr[i] = g61VarArr[i].b;
        }
        d(strArr);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Serializable, java.lang.String[]] */
    public void d(String... strArr) {
        if (!this.a) {
            s1.f("no TLS versions for cleartext connections");
        } else if (strArr.length != 0) {
            this.d = (String[]) strArr.clone();
        } else {
            zy.n("At least one TLS version is required");
        }
    }
}
