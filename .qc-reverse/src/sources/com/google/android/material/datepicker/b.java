package com.google.android.material.datepicker;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.quickcursor.R;
import defpackage.hf1;
import defpackage.pu0;
import defpackage.uf1;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends pu0 {
    public final TextView t;
    public final MaterialCalendarGridView u;

    public b(LinearLayout linearLayout, boolean z) {
        super(linearLayout);
        TextView textView = (TextView) linearLayout.findViewById(R.id.month_title);
        this.t = textView;
        WeakHashMap weakHashMap = uf1.a;
        new hf1(R.id.tag_accessibility_heading, Boolean.class, 0, 28, 3).d(textView, Boolean.TRUE);
        this.u = (MaterialCalendarGridView) linearLayout.findViewById(R.id.month_grid);
        if (z) {
            return;
        }
        textView.setVisibility(8);
    }
}
