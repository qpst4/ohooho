package defpackage;

import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class fc implements kn0 {
    public static final fc a = new fc();
    public static final o10 b;

    static {
        wb wbVar = new wb(1);
        HashMap map = new HashMap();
        map.put(rr0.class, wbVar);
        b = new o10("storageMetrics", Collections.unmodifiableMap(new HashMap(map)));
    }

    @Override // defpackage.sy
    public final void a(Object obj, Object obj2) {
        ((ln0) obj2).a(b, ((t60) obj).a);
    }
}
