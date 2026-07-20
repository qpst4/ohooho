package defpackage;

import android.os.Trace;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class n50 implements Runnable {
    public static final ThreadLocal f = new ThreadLocal();
    public static final ik g = new ik(2);
    public ArrayList b;
    public long c;
    public long d;
    public ArrayList e;

    public static pu0 c(RecyclerView recyclerView, int i, long j) {
        int iF = recyclerView.f.F();
        for (int i2 = 0; i2 < iF; i2++) {
            pu0 pu0VarJ = RecyclerView.J(recyclerView.f.E(i2));
            if (pu0VarJ.c == i && !pu0VarJ.g()) {
                return null;
            }
        }
        gu0 gu0Var = recyclerView.c;
        try {
            recyclerView.R();
            pu0 pu0VarI = gu0Var.i(i, j);
            if (pu0VarI != null) {
                if (!pu0VarI.f() || pu0VarI.g()) {
                    gu0Var.a(pu0VarI, false);
                } else {
                    gu0Var.f(pu0VarI.a);
                }
            }
            recyclerView.S(false);
            return pu0VarI;
        } catch (Throwable th) {
            recyclerView.S(false);
            throw th;
        }
    }

    public final void a(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.r && this.c == 0) {
            this.c = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        l50 l50Var = recyclerView.f0;
        l50Var.a = i;
        l50Var.b = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(long r15) {
        /*
            Method dump skipped, instruction units count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.n50.b(long):void");
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList = this.b;
        try {
            int i = h71.a;
            Trace.beginSection("RV Prefetch");
            if (!arrayList.isEmpty()) {
                int size = arrayList.size();
                long jMax = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    RecyclerView recyclerView = (RecyclerView) arrayList.get(i2);
                    if (recyclerView.getWindowVisibility() == 0) {
                        jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    b(TimeUnit.MILLISECONDS.toNanos(jMax) + this.d);
                }
            }
            this.c = 0L;
            Trace.endSection();
        } catch (Throwable th) {
            this.c = 0L;
            int i3 = h71.a;
            Trace.endSection();
            throw th;
        }
    }
}
