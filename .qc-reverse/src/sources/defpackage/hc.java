package defpackage;

import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class hc implements kn0 {
    public static final hc a = new hc();
    public static final o10 b;
    public static final o10 c;

    static {
        wb wbVar = new wb(1);
        HashMap map = new HashMap();
        map.put(rr0.class, wbVar);
        b = new o10("logSource", Collections.unmodifiableMap(new HashMap(map)));
        wb wbVar2 = new wb(2);
        HashMap map2 = new HashMap();
        map2.put(rr0.class, wbVar2);
        c = new o10("logEventDropped", Collections.unmodifiableMap(new HashMap(map2)));
    }

    @Override // defpackage.sy
    public final void a(Object obj, Object obj2) {
        ti0 ti0Var = (ti0) obj;
        ln0 ln0Var = (ln0) obj2;
        ln0Var.a(b, ti0Var.a);
        ln0Var.a(c, ti0Var.b);
    }
}
