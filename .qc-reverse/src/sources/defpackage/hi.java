package defpackage;

import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class hi implements Runnable {
    public final /* synthetic */ int b;
    public final int c;
    public final Object d;

    public hi(List list, int i, Throwable th) {
        this.b = 1;
        f01.k("initCallbacks cannot be null", list);
        this.d = new ArrayList(list);
        this.c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        int i2 = this.c;
        Object obj = this.d;
        switch (i) {
            case 0:
                i1 i1Var = (i1) ((tb0) obj).c;
                if (i1Var != null) {
                    i1Var.G(i2);
                }
                break;
            case 1:
                ArrayList arrayList = (ArrayList) obj;
                int size = arrayList.size();
                int i3 = 0;
                if (i2 == 1) {
                    while (i3 < size) {
                        ((qx) arrayList.get(i3)).b();
                        i3++;
                    }
                } else {
                    while (i3 < size) {
                        ((qx) arrayList.get(i3)).a();
                        i3++;
                    }
                }
                break;
            case 2:
                RecyclerView recyclerView = ((zj0) obj).f0;
                if (!recyclerView.w) {
                    zt0 zt0Var = recyclerView.n;
                    if (zt0Var != null) {
                        zt0Var.B0(recyclerView, i2);
                    } else {
                        Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
                    }
                    break;
                }
                break;
            default:
                ((mj1) obj).i(i2);
                break;
        }
    }

    public /* synthetic */ hi(int i, int i2, Object obj) {
        this.b = i2;
        this.d = obj;
        this.c = i;
    }
}
