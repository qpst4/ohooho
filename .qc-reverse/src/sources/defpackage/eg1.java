package defpackage;

import java.io.Closeable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class eg1 {
    public final LinkedHashMap a = new LinkedHashMap();

    public final void a() {
        for (bg1 bg1Var : this.a.values()) {
            bg1Var.getClass();
            HashMap map = bg1Var.a;
            if (map != null) {
                synchronized (map) {
                    try {
                        Iterator it = bg1Var.a.values().iterator();
                        while (it.hasNext()) {
                            bg1.a(it.next());
                        }
                    } finally {
                    }
                }
            }
            LinkedHashSet linkedHashSet = bg1Var.b;
            if (linkedHashSet != null) {
                synchronized (linkedHashSet) {
                    try {
                        Iterator it2 = bg1Var.b.iterator();
                        while (it2.hasNext()) {
                            bg1.a((Closeable) it2.next());
                        }
                    } finally {
                    }
                }
            }
            bg1Var.b();
        }
        this.a.clear();
    }
}
