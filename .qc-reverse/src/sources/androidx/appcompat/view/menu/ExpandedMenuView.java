package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import defpackage.cl0;
import defpackage.ra;
import defpackage.rl0;
import defpackage.yk0;
import defpackage.zk0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements yk0, rl0, AdapterView.OnItemClickListener {
    public static final int[] c = {R.attr.background, R.attr.divider};
    public zk0 b;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        ra raVarM = ra.M(context, attributeSet, c, R.attr.listViewStyle);
        TypedArray typedArray = (TypedArray) raVarM.c;
        if (typedArray.hasValue(0)) {
            setBackgroundDrawable(raVarM.y(0));
        }
        if (typedArray.hasValue(1)) {
            setDivider(raVarM.y(1));
        }
        raVarM.O();
    }

    @Override // defpackage.yk0
    public final boolean a(cl0 cl0Var) {
        return this.b.q(cl0Var, null, 0);
    }

    @Override // defpackage.rl0
    public final void b(zk0 zk0Var) {
        this.b = zk0Var;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        a((cl0) getAdapter().getItem(i));
    }
}
