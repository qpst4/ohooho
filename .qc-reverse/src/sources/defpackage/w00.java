package defpackage;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class w00 {
    public static final w00 a;

    static {
        try {
            Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
        }
        w00 w00Var = new w00();
        Map map = Collections.EMPTY_MAP;
        a = w00Var;
    }

    public static w00 a() {
        Class cls = v00.a;
        if (cls != null) {
            try {
                return (w00) cls.getMethod("getEmptyRegistry", null).invoke(null, null);
            } catch (Exception unused) {
            }
        }
        return a;
    }
}
