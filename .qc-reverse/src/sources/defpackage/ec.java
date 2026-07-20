package defpackage;

import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ec implements kn0 {
    public static final ec a = new ec();
    public static final o10 b;
    public static final o10 c;
    public static final o10 d;
    public static final o10 e;

    static {
        wb wbVar = new wb(1);
        HashMap map = new HashMap();
        map.put(rr0.class, wbVar);
        b = new o10("window", Collections.unmodifiableMap(new HashMap(map)));
        wb wbVar2 = new wb(2);
        HashMap map2 = new HashMap();
        map2.put(rr0.class, wbVar2);
        c = new o10("logSourceMetrics", Collections.unmodifiableMap(new HashMap(map2)));
        wb wbVar3 = new wb(3);
        HashMap map3 = new HashMap();
        map3.put(rr0.class, wbVar3);
        d = new o10("globalMetrics", Collections.unmodifiableMap(new HashMap(map3)));
        wb wbVar4 = new wb(4);
        HashMap map4 = new HashMap();
        map4.put(rr0.class, wbVar4);
        e = new o10("appNamespace", Collections.unmodifiableMap(new HashMap(map4)));
    }

    @Override // defpackage.sy
    public final void a(Object obj, Object obj2) {
        wk wkVar = (wk) obj;
        ln0 ln0Var = (ln0) obj2;
        ln0Var.a(b, wkVar.a);
        ln0Var.a(c, wkVar.b);
        ln0Var.a(d, wkVar.c);
        ln0Var.a(e, wkVar.d);
    }
}
