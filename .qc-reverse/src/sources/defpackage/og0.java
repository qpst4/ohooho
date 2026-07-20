package defpackage;

import android.view.View;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class og0 {
    public boolean a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public List k;
    public boolean l;

    public final void a(View view) {
        int iC;
        int size = this.k.size();
        View view2 = null;
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < size; i2++) {
            View view3 = ((pu0) this.k.get(i2)).a;
            au0 au0Var = (au0) view3.getLayoutParams();
            if (view3 != view && !au0Var.a.i() && (iC = (au0Var.a.c() - this.d) * this.e) >= 0 && iC < i) {
                view2 = view3;
                if (iC == 0) {
                    break;
                } else {
                    i = iC;
                }
            }
        }
        if (view2 == null) {
            this.d = -1;
        } else {
            this.d = ((au0) view2.getLayoutParams()).a.c();
        }
    }

    public final View b(gu0 gu0Var) {
        List list = this.k;
        if (list == null) {
            View view = gu0Var.i(this.d, Long.MAX_VALUE).a;
            this.d += this.e;
            return view;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            View view2 = ((pu0) this.k.get(i)).a;
            au0 au0Var = (au0) view2.getLayoutParams();
            if (!au0Var.a.i() && this.d == au0Var.a.c()) {
                a(view2);
                return view2;
            }
        }
        return null;
    }
}
