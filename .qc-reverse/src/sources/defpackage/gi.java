package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class gi implements be0, Serializable {
    public transient be0 b;
    public final Object c;
    public final Class d;
    public final String e;
    public final String f;
    public final boolean g;

    public gi(Object obj, Class cls, String str, String str2, boolean z) {
        this.c = obj;
        this.d = cls;
        this.e = str;
        this.f = str2;
        this.g = z;
    }

    public abstract be0 c();

    public final kk d() {
        Class cls = this.d;
        if (cls == null) {
            return null;
        }
        if (this.g) {
            tu0.a.getClass();
            return new wo0(cls);
        }
        tu0.a.getClass();
        return new lk(cls);
    }
}
