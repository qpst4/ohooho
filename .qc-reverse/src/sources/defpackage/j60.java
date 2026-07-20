package defpackage;

import android.accessibilityservice.GestureDescription;
import android.os.Build;
import com.quickcursor.android.drawables.globals.EdgeActionsDrawable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class j60 {
    public static final int e;
    public static final int f;
    public final CopyOnWriteArrayList a;
    public final ScheduledFuture b;
    public long c;
    public t51 d;

    static {
        int i = Build.VERSION.SDK_INT;
        e = i >= 26 ? 25 : 100;
        f = i >= 26 ? 200 : Math.max(5, Math.min(GestureDescription.getMaxStrokeCount(), 50));
    }

    public j60(int i, int i2) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.a = copyOnWriteArrayList;
        a(new t51(i, i2, 0L));
        a(new t51(i, i2, 1L));
        this.d = (t51) copyOnWriteArrayList.get(1);
        this.c = System.currentTimeMillis();
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        c cVar = new c(26, this);
        long j = e;
        this.b = scheduledThreadPoolExecutor.scheduleAtFixedRate(cVar, j, j, TimeUnit.MILLISECONDS);
        bk bkVar = r60.a;
        r60.l = new b60(copyOnWriteArrayList, r60.i.g());
        r60.i.n();
        EdgeActionsDrawable edgeActionsDrawable = r60.n;
        if (edgeActionsDrawable != null) {
            edgeActionsDrawable.k = edgeActionsDrawable.j;
        }
        r60.c.invalidate();
    }

    public final void a(t51 t51Var) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.a;
        copyOnWriteArrayList.add(t51Var);
        this.d = t51Var;
        this.c = System.currentTimeMillis();
        if (copyOnWriteArrayList.size() > f) {
            copyOnWriteArrayList.remove(0);
            ((t51) copyOnWriteArrayList.get(0)).c = 0L;
        }
    }
}
