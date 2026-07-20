package defpackage;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class v6 implements AdapterView.OnItemClickListener {
    public final /* synthetic */ a7 b;
    public final /* synthetic */ x6 c;

    public v6(x6 x6Var, a7 a7Var) {
        this.c = x6Var;
        this.b = a7Var;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        x6 x6Var = this.c;
        DialogInterface.OnClickListener onClickListener = x6Var.t;
        a7 a7Var = this.b;
        onClickListener.onClick(a7Var.b, i);
        if (x6Var.x) {
            return;
        }
        a7Var.b.dismiss();
    }
}
