package defpackage;

import android.view.View;
import android.view.ViewTreeObserver;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class p9 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ p9(int i, Object obj) {
        this.b = i;
        this.c = obj;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int i = this.b;
        Object obj = this.c;
        switch (i) {
            case 0:
                y9 y9Var = (y9) obj;
                if (!y9Var.getInternalPopup().b()) {
                    y9Var.g.m(y9Var.getTextDirection(), y9Var.getTextAlignment());
                }
                ViewTreeObserver viewTreeObserver = y9Var.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                }
                break;
            case 1:
                v9 v9Var = (v9) obj;
                y9 y9Var2 = v9Var.H;
                if (y9Var2.isAttachedToWindow() && y9Var2.getGlobalVisibleRect(v9Var.F)) {
                    v9Var.s();
                    v9Var.d();
                } else {
                    v9Var.dismiss();
                }
                break;
            case 2:
                vi viVar = (vi) obj;
                ArrayList arrayList = viVar.i;
                if (viVar.b() && arrayList.size() > 0) {
                    int i2 = 0;
                    if (!((ui) arrayList.get(0)).a.z) {
                        View view = viVar.p;
                        if (view != null && view.isShown()) {
                            int size = arrayList.size();
                            while (i2 < size) {
                                Object obj2 = arrayList.get(i2);
                                i2++;
                                ((ui) obj2).a.d();
                            }
                        } else {
                            viVar.dismiss();
                        }
                    }
                    break;
                }
                break;
            default:
                m21 m21Var = (m21) obj;
                nl0 nl0Var = m21Var.i;
                if (m21Var.b() && !nl0Var.z) {
                    View view2 = m21Var.n;
                    if (view2 != null && view2.isShown()) {
                        nl0Var.d();
                    } else {
                        m21Var.dismiss();
                    }
                    break;
                }
                break;
        }
    }
}
