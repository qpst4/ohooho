package defpackage;

import android.os.Build;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ox extends yb0 {
    public final /* synthetic */ ze s;

    public ox(ze zeVar) {
        this.s = zeVar;
    }

    @Override // defpackage.yb0
    public final void q(Throwable th) {
        ((sx) this.s.a).d(th);
    }

    @Override // defpackage.yb0
    public final void r(g7 g7Var) {
        ze zeVar = this.s;
        zeVar.c = g7Var;
        g7 g7Var2 = (g7) zeVar.c;
        sx sxVar = (sx) zeVar.a;
        zeVar.b = new ra(g7Var2, sxVar.g, sxVar.i, Build.VERSION.SDK_INT >= 34 ? wx.a() : fc0.u());
        sx sxVar2 = (sx) zeVar.a;
        ArrayList arrayList = new ArrayList();
        sxVar2.a.writeLock().lock();
        try {
            sxVar2.c = 1;
            arrayList.addAll(sxVar2.b);
            sxVar2.b.clear();
            sxVar2.a.writeLock().unlock();
            sxVar2.d.post(new hi(arrayList, sxVar2.c, (Throwable) null));
        } catch (Throwable th) {
            sxVar2.a.writeLock().unlock();
            throw th;
        }
    }
}
