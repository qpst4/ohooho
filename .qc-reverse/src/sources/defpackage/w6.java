package defpackage;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController$RecycleListView;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class w6 implements AdapterView.OnItemClickListener {
    public final /* synthetic */ AlertController$RecycleListView b;
    public final /* synthetic */ a7 c;
    public final /* synthetic */ x6 d;

    public w6(x6 x6Var, AlertController$RecycleListView alertController$RecycleListView, a7 a7Var) {
        this.d = x6Var;
        this.b = alertController$RecycleListView;
        this.c = a7Var;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        x6 x6Var = this.d;
        boolean[] zArr = x6Var.v;
        AlertController$RecycleListView alertController$RecycleListView = this.b;
        if (zArr != null) {
            zArr[i] = alertController$RecycleListView.isItemChecked(i);
        }
        x6Var.z.onClick(this.c.b, i, alertController$RecycleListView.isItemChecked(i));
    }
}
