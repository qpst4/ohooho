package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class wk0 extends BaseAdapter {
    public final zk0 a;
    public int b = -1;
    public boolean c;
    public final boolean d;
    public final LayoutInflater e;
    public final int f;

    public wk0(zk0 zk0Var, LayoutInflater layoutInflater, boolean z, int i) {
        this.d = z;
        this.e = layoutInflater;
        this.a = zk0Var;
        this.f = i;
        a();
    }

    public final void a() {
        zk0 zk0Var = this.a;
        cl0 cl0Var = zk0Var.v;
        if (cl0Var != null) {
            zk0Var.i();
            ArrayList arrayList = zk0Var.j;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (((cl0) arrayList.get(i)) == cl0Var) {
                    this.b = i;
                    return;
                }
            }
        }
        this.b = -1;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final cl0 getItem(int i) {
        ArrayList arrayListL;
        boolean z = this.d;
        zk0 zk0Var = this.a;
        if (z) {
            zk0Var.i();
            arrayListL = zk0Var.j;
        } else {
            arrayListL = zk0Var.l();
        }
        int i2 = this.b;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return (cl0) arrayListL.get(i);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList arrayListL;
        boolean z = this.d;
        zk0 zk0Var = this.a;
        if (z) {
            zk0Var.i();
            arrayListL = zk0Var.j;
        } else {
            arrayListL = zk0Var.l();
        }
        return this.b < 0 ? arrayListL.size() : arrayListL.size() - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        boolean z = false;
        if (view == null) {
            view = this.e.inflate(this.f, viewGroup, false);
        }
        int i2 = getItem(i).b;
        int i3 = i - 1;
        int i4 = i3 >= 0 ? getItem(i3).b : i2;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (this.a.m() && i2 != i4) {
            z = true;
        }
        listMenuItemView.setGroupDividerEnabled(z);
        ql0 ql0Var = (ql0) view;
        if (this.c) {
            listMenuItemView.setForceShowIcon(true);
        }
        ql0Var.c(getItem(i));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
