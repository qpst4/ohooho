package defpackage;

import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class t9 implements AdapterView.OnItemClickListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ t9(int i, Object obj) {
        this.b = i;
        this.c = obj;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        int i2 = this.b;
        Object obj = this.c;
        switch (i2) {
            case 0:
                v9 v9Var = (v9) obj;
                y9 y9Var = v9Var.H;
                y9Var.setSelection(i);
                if (y9Var.getOnItemClickListener() != null) {
                    y9Var.performItemClick(view, i, v9Var.E.getItemId(i));
                }
                v9Var.dismiss();
                break;
            default:
                oj0 oj0Var = (oj0) obj;
                rh0 rh0Var = oj0Var.f;
                oj0.a(oj0Var, i < 0 ? !rh0Var.A.isShowing() ? null : rh0Var.d.getSelectedItem() : oj0Var.getAdapter().getItem(i));
                AdapterView.OnItemClickListener onItemClickListener = oj0Var.getOnItemClickListener();
                if (onItemClickListener != null) {
                    if (view == null || i < 0) {
                        view = !rh0Var.A.isShowing() ? null : rh0Var.d.getSelectedView();
                        i = !rh0Var.A.isShowing() ? -1 : rh0Var.d.getSelectedItemPosition();
                        j = !rh0Var.A.isShowing() ? Long.MIN_VALUE : rh0Var.d.getSelectedItemId();
                    }
                    onItemClickListener.onItemClick(rh0Var.d, view, i, j);
                }
                rh0Var.dismiss();
                break;
        }
    }
}
