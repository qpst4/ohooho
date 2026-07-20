package defpackage;

import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class a40 extends bg1 {
    public static final c70 i = new c70(18);
    public final boolean f;
    public final HashMap c = new HashMap();
    public final HashMap d = new HashMap();
    public final HashMap e = new HashMap();
    public boolean g = false;
    public boolean h = false;

    public a40(boolean z) {
        this.f = z;
    }

    @Override // defpackage.bg1
    public final void b() {
        if (y30.I(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.g = true;
    }

    public final void c(j30 j30Var) {
        if (this.h) {
            if (y30.I(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
                return;
            }
            return;
        }
        String str = j30Var.g;
        HashMap map = this.c;
        if (map.containsKey(str)) {
            return;
        }
        map.put(j30Var.g, j30Var);
        if (y30.I(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Added " + j30Var);
        }
    }

    public final void d(j30 j30Var) {
        if (y30.I(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + j30Var);
        }
        e(j30Var.g);
    }

    public final void e(String str) {
        HashMap map = this.d;
        a40 a40Var = (a40) map.get(str);
        if (a40Var != null) {
            a40Var.b();
            map.remove(str);
        }
        HashMap map2 = this.e;
        eg1 eg1Var = (eg1) map2.get(str);
        if (eg1Var != null) {
            eg1Var.a();
            map2.remove(str);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a40.class == obj.getClass()) {
            a40 a40Var = (a40) obj;
            if (this.c.equals(a40Var.c) && this.d.equals(a40Var.d) && this.e.equals(a40Var.e)) {
                return true;
            }
        }
        return false;
    }

    public final void f(j30 j30Var) {
        if (this.h) {
            if (y30.I(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else {
            if (this.c.remove(j30Var.g) == null || !y30.I(2)) {
                return;
            }
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + j30Var);
        }
    }

    public final int hashCode() {
        return this.e.hashCode() + ((this.d.hashCode() + (this.c.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it = this.c.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator it2 = this.d.keySet().iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it3 = this.e.keySet().iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
