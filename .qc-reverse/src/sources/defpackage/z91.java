package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class z91 {
    public static final List a;
    public static final ArrayList b;
    public static final h91 c;
    public static final h91 d;
    public static final int e;
    public static final int f;
    public static final int g;

    static {
        n3 n3Var = n3.grabCursor;
        i3 i3Var = i3.instant;
        Object[] objArr = {new h91(1, n3Var, null, i3Var)};
        ArrayList arrayList = new ArrayList(1);
        Object obj = objArr[0];
        Objects.requireNonNull(obj);
        arrayList.add(obj);
        a = Collections.unmodifiableList(arrayList);
        b = new ArrayList();
        c = new h91(1, n3.triggerTap, null, i3Var);
        d = new h91(1, n3Var, null, i3Var);
        e = ey0.a(20);
        f = ey0.a(400);
        g = ey0.a(60);
    }

    public static boolean a(m91 m91Var) {
        if (m91Var.s()) {
            return false;
        }
        return m91Var.o();
    }
}
