package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.quickcursor.R;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class fh0 extends BaseAdapter {
    public int a = -1;
    public final /* synthetic */ gh0 b;

    public fh0(gh0 gh0Var) {
        this.b = gh0Var;
        a();
    }

    public final void a() {
        zk0 zk0Var = this.b.d;
        cl0 cl0Var = zk0Var.v;
        if (cl0Var != null) {
            zk0Var.i();
            ArrayList arrayList = zk0Var.j;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (((cl0) arrayList.get(i)) == cl0Var) {
                    this.a = i;
                    return;
                }
            }
        }
        this.a = -1;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final cl0 getItem(int i) {
        gh0 gh0Var = this.b;
        zk0 zk0Var = gh0Var.d;
        zk0Var.i();
        ArrayList arrayList = zk0Var.j;
        gh0Var.getClass();
        int i2 = this.a;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return (cl0) arrayList.get(i);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        gh0 gh0Var = this.b;
        zk0 zk0Var = gh0Var.d;
        zk0Var.i();
        int size = zk0Var.j.size();
        gh0Var.getClass();
        return this.a < 0 ? size : size - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.b.c.inflate(R.layout.abc_list_menu_item_layout, viewGroup, false);
        }
        ((ql0) view).c(getItem(i));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
