package defpackage;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class gs0 {
    public em1 a;

    public gs0 a() {
        if (this.a == null) {
            zy.n("Product list must be set to a non empty list.");
            return null;
        }
        gs0 gs0Var = new gs0();
        gs0Var.a = this.a;
        return gs0Var;
    }

    public void b(List list) {
        if (list == null || list.isEmpty()) {
            zy.n("Product list cannot be empty.");
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            hs0 hs0Var = (hs0) it.next();
            if (!"play_pass_subs".equals(hs0Var.b)) {
                hashSet.add(hs0Var.b);
            }
        }
        if (hashSet.size() <= 1) {
            this.a = em1.k(list);
        } else {
            zy.n("All products should be of the same product type.");
        }
    }
}
