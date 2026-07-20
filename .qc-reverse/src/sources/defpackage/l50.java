package defpackage;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class l50 {
    public int a;
    public int b;
    public int[] c;
    public int d;

    public final void a(int i, int i2) {
        if (i < 0) {
            zy.n("Layout positions must be non-negative");
            return;
        }
        if (i2 < 0) {
            zy.n("Pixel distance must be non-negative");
            return;
        }
        int i3 = this.d;
        int i4 = i3 * 2;
        int[] iArr = this.c;
        if (iArr == null) {
            int[] iArr2 = new int[4];
            this.c = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i4 >= iArr.length) {
            int[] iArr3 = new int[i3 * 4];
            this.c = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
        }
        int[] iArr4 = this.c;
        iArr4[i4] = i;
        iArr4[i4 + 1] = i2;
        this.d++;
    }

    public final void b(RecyclerView recyclerView, boolean z) {
        this.d = 0;
        int[] iArr = this.c;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        zt0 zt0Var = recyclerView.n;
        if (recyclerView.m == null || zt0Var == null || !zt0Var.i) {
            return;
        }
        if (z) {
            if (!recyclerView.e.j()) {
                zt0Var.i(recyclerView.m.a(), this);
            }
        } else if (!recyclerView.M()) {
            zt0Var.h(this.a, this.b, recyclerView.g0, this);
        }
        int i = this.d;
        if (i > zt0Var.j) {
            zt0Var.j = i;
            zt0Var.k = z;
            recyclerView.c.k();
        }
    }
}
