package com.quickcursor.android.views.settings;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.quickcursor.R;
import defpackage.dx;
import defpackage.ey0;
import defpackage.lc1;
import defpackage.nw;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class EdgeBarLinearLayout extends LinearLayout {
    public final int b;
    public final int c;
    public dx d;
    public String e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;

    public EdgeBarLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = lc1.z(R.dimen.edge_bar_linear_layout_size);
        this.c = ey0.a(8);
    }

    public final int a(nw nwVar) {
        for (int i = 0; i < getChildCount(); i++) {
            if (nwVar == getChildAt(i)) {
                return i;
            }
        }
        return -1;
    }
}
