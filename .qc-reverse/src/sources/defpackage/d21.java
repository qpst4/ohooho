package defpackage;

import defpackage.a21;
import defpackage.z11;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d21 {
    public static final boolean a;
    public static final z11.a b;
    public static final a21.a c;
    public static final b21 d;

    static {
        boolean z;
        try {
            Class.forName("java.sql.Date");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        a = z;
        if (z) {
            b = z11.b;
            c = a21.b;
            d = c21.b;
        } else {
            b = null;
            c = null;
            d = null;
        }
    }
}
