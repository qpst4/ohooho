package com.google.android.material.datepicker;

import android.view.View;
import android.widget.AdapterView;
import defpackage.zj0;
import defpackage.zl0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements AdapterView.OnItemClickListener {
    public final /* synthetic */ MaterialCalendarGridView b;
    public final /* synthetic */ c c;

    public a(c cVar, MaterialCalendarGridView materialCalendarGridView) {
        this.c = cVar;
        this.b = materialCalendarGridView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        MaterialCalendarGridView materialCalendarGridView = this.b;
        zl0 zl0VarA = materialCalendarGridView.a();
        if (i < zl0VarA.a() || i > zl0VarA.c()) {
            return;
        }
        if (materialCalendarGridView.a().getItem(i).longValue() >= ((zj0) this.c.d.c).a0.d.b) {
            throw null;
        }
    }
}
