package defpackage;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class og1 {
    public Interpolator c;
    public pg1 d;
    public boolean e;
    public long b = -1;
    public final a71 f = new a71(this);
    public final ArrayList a = new ArrayList();

    public final void a() {
        if (this.e) {
            ArrayList arrayList = this.a;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((ng1) obj).b();
            }
            this.e = false;
        }
    }

    public final void b() {
        View view;
        if (this.e) {
            return;
        }
        ArrayList arrayList = this.a;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ng1 ng1Var = (ng1) obj;
            long j = this.b;
            if (j >= 0) {
                ng1Var.c(j);
            }
            Interpolator interpolator = this.c;
            if (interpolator != null && (view = (View) ng1Var.a.get()) != null) {
                view.animate().setInterpolator(interpolator);
            }
            if (this.d != null) {
                ng1Var.d(this.f);
            }
            View view2 = (View) ng1Var.a.get();
            if (view2 != null) {
                view2.animate().start();
            }
        }
        this.e = true;
    }
}
