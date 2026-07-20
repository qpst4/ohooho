package defpackage;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class mv0 {
    public final ga0 a;
    public final String b;
    public final w70 c;
    public final Map d;
    public volatile ci e;

    public mv0(g7 g7Var) {
        this.a = (ga0) g7Var.c;
        this.b = (String) g7Var.b;
        jj jjVar = (jj) g7Var.d;
        jjVar.getClass();
        this.c = new w70(jjVar);
        Map map = (Map) g7Var.e;
        byte[] bArr = be1.a;
        this.d = map.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    public final g7 a() {
        g7 g7Var = new g7();
        Object linkedHashMap = Collections.EMPTY_MAP;
        g7Var.e = linkedHashMap;
        g7Var.c = this.a;
        g7Var.b = this.b;
        Map map = this.d;
        if (!map.isEmpty()) {
            linkedHashMap = new LinkedHashMap(map);
        }
        g7Var.e = linkedHashMap;
        g7Var.d = this.c.c();
        return g7Var;
    }

    public final String toString() {
        return "Request{method=" + this.b + ", url=" + this.a + ", tags=" + this.d + '}';
    }
}
