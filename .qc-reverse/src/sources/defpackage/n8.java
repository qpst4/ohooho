package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class n8 extends qg1 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ n8(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // defpackage.pg1
    public final void a() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                y8 y8Var = ((l8) obj).c;
                y8Var.v.setAlpha(1.0f);
                y8Var.y.d(null);
                y8Var.y = null;
                break;
            case 1:
                y8 y8Var2 = (y8) obj;
                y8Var2.v.setAlpha(1.0f);
                y8Var2.y.d(null);
                y8Var2.y = null;
                break;
            default:
                y8 y8Var3 = (y8) ((i9) obj).d;
                y8Var3.v.setVisibility(8);
                PopupWindow popupWindow = y8Var3.w;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (y8Var3.v.getParent() instanceof View) {
                    View view = (View) y8Var3.v.getParent();
                    WeakHashMap weakHashMap = uf1.a;
                    jf1.c(view);
                }
                y8Var3.v.e();
                y8Var3.y.d(null);
                y8Var3.y = null;
                ViewGroup viewGroup = y8Var3.A;
                WeakHashMap weakHashMap2 = uf1.a;
                jf1.c(viewGroup);
                break;
        }
    }

    @Override // defpackage.qg1, defpackage.pg1
    public void c() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                ((l8) obj).c.v.setVisibility(0);
                break;
            case 1:
                y8 y8Var = (y8) obj;
                y8Var.v.setVisibility(0);
                if (y8Var.v.getParent() instanceof View) {
                    View view = (View) y8Var.v.getParent();
                    WeakHashMap weakHashMap = uf1.a;
                    jf1.c(view);
                }
                break;
        }
    }
}
