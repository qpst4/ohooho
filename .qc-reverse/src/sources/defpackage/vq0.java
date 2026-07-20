package defpackage;

import android.util.SparseArray;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class vq0 {
    public static final SparseArray a = new SparseArray();
    public static final HashMap b;

    static {
        HashMap map = new HashMap();
        b = map;
        map.put(tq0.b, 0);
        map.put(tq0.c, 1);
        map.put(tq0.d, 2);
        for (tq0 tq0Var : map.keySet()) {
            a.append(((Integer) b.get(tq0Var)).intValue(), tq0Var);
        }
    }

    public static int a(tq0 tq0Var) {
        Integer num = (Integer) b.get(tq0Var);
        if (num != null) {
            return num.intValue();
        }
        zy.s("PriorityMapping is missing known Priority value ", tq0Var);
        return 0;
    }

    public static tq0 b(int i) {
        tq0 tq0Var = (tq0) a.get(i);
        if (tq0Var != null) {
            return tq0Var;
        }
        zy.n(qq0.i("Unknown Priority for value ", i));
        return null;
    }
}
