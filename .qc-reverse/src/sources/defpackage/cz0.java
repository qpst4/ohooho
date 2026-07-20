package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class cz0 extends dz0 {
    public static List e0(bz0 bz0Var) {
        Iterator it = bz0Var.iterator();
        if (!it.hasNext()) {
            return oy.b;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return lc1.V(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
