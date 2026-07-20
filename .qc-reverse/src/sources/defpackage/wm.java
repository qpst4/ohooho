package defpackage;

import java.lang.ref.Reference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class wm {
    public static final ThreadPoolExecutor g;
    public boolean f;
    public final nc c = new nc(2, this);
    public final ArrayDeque d = new ArrayDeque();
    public final tb0 e = new tb0(14);
    public final int a = 5;
    public final long b = 300000000000L;

    static {
        SynchronousQueue synchronousQueue = new SynchronousQueue();
        byte[] bArr = be1.a;
        g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, synchronousQueue, new ae1("OkHttp ConnectionPool", true));
    }

    public final int a(it0 it0Var, long j) {
        ArrayList arrayList = it0Var.n;
        int i = 0;
        while (i < arrayList.size()) {
            Reference reference = (Reference) arrayList.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                qp0.a.m("A connection to " + it0Var.c.a.a + " was leaked. Did you forget to close a response body?", ((t21) reference).a);
                arrayList.remove(i);
                it0Var.k = true;
                if (arrayList.isEmpty()) {
                    it0Var.o = j - this.b;
                    return 0;
                }
            }
        }
        return arrayList.size();
    }
}
