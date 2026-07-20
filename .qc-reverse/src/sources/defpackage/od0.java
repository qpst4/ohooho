package defpackage;

import java.util.Date;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class od0 implements ty {
    public static final md0 f;
    public static final md0 g;
    public final HashMap a;
    public final HashMap b;
    public final ld0 c;
    public boolean d;
    public static final ld0 e = new ld0(0);
    public static final nd0 h = new nd0();

    /* JADX WARN: Type inference failed for: r0v1, types: [md0] */
    /* JADX WARN: Type inference failed for: r0v2, types: [md0] */
    static {
        final int i = 0;
        f = new fe1() { // from class: md0
            @Override // defpackage.sy
            public final void a(Object obj, Object obj2) {
                switch (i) {
                    case 0:
                        ((ge1) obj2).b((String) obj);
                        break;
                    default:
                        ((ge1) obj2).c(((Boolean) obj).booleanValue());
                        break;
                }
            }
        };
        final int i2 = 1;
        g = new fe1() { // from class: md0
            @Override // defpackage.sy
            public final void a(Object obj, Object obj2) {
                switch (i2) {
                    case 0:
                        ((ge1) obj2).b((String) obj);
                        break;
                    default:
                        ((ge1) obj2).c(((Boolean) obj).booleanValue());
                        break;
                }
            }
        };
    }

    public od0() {
        HashMap map = new HashMap();
        this.a = map;
        HashMap map2 = new HashMap();
        this.b = map2;
        this.c = e;
        this.d = false;
        map2.put(String.class, f);
        map.remove(String.class);
        map2.put(Boolean.class, g);
        map.remove(Boolean.class);
        map2.put(Date.class, h);
        map.remove(Date.class);
    }

    public final ty a(Class cls, kn0 kn0Var) {
        this.a.put(cls, kn0Var);
        this.b.remove(cls);
        return this;
    }
}
