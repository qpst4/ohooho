package com.google.android.material.datepicker;

import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.quickcursor.R;
import defpackage.au0;
import defpackage.fi;
import defpackage.fk0;
import defpackage.pu0;
import defpackage.qt0;
import defpackage.tb0;
import defpackage.wd1;
import defpackage.yl0;
import defpackage.zl0;
import defpackage.zy;
import java.util.Calendar;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends qt0 {
    public final fi c;
    public final tb0 d;
    public final int e;

    public c(ContextThemeWrapper contextThemeWrapper, fi fiVar, tb0 tb0Var) {
        yl0 yl0Var = fiVar.b;
        yl0 yl0Var2 = fiVar.c;
        yl0 yl0Var3 = fiVar.e;
        if (yl0Var.b.compareTo(yl0Var3.b) > 0) {
            zy.n("firstPage cannot be after currentPage");
            throw null;
        }
        if (yl0Var3.b.compareTo(yl0Var2.b) > 0) {
            zy.n("currentPage cannot be after lastPage");
            throw null;
        }
        this.e = (contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) * zl0.d) + (fk0.m0(contextThemeWrapper, android.R.attr.windowFullscreen) ? contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) : 0);
        this.c = fiVar;
        this.d = tb0Var;
        g(true);
    }

    @Override // defpackage.qt0
    public final int a() {
        return this.c.h;
    }

    @Override // defpackage.qt0
    public final long b(int i) {
        Calendar calendarA = wd1.a(this.c.b.b);
        calendarA.add(2, i);
        calendarA.set(5, 1);
        Calendar calendarA2 = wd1.a(calendarA);
        calendarA2.get(2);
        calendarA2.get(1);
        calendarA2.getMaximum(7);
        calendarA2.getActualMaximum(5);
        calendarA2.getTimeInMillis();
        return calendarA2.getTimeInMillis();
    }

    @Override // defpackage.qt0
    public final void e(pu0 pu0Var, int i) {
        b bVar = (b) pu0Var;
        fi fiVar = this.c;
        Calendar calendarA = wd1.a(fiVar.b.b);
        calendarA.add(2, i);
        yl0 yl0Var = new yl0(calendarA);
        bVar.t.setText(yl0Var.c());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) bVar.u.findViewById(R.id.month_grid);
        if (materialCalendarGridView.a() == null || !yl0Var.equals(materialCalendarGridView.a().a)) {
            new zl0(yl0Var, fiVar);
            throw null;
        }
        materialCalendarGridView.invalidate();
        materialCalendarGridView.a().getClass();
        throw null;
    }

    @Override // defpackage.qt0
    public final pu0 f(ViewGroup viewGroup, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!fk0.m0(viewGroup.getContext(), android.R.attr.windowFullscreen)) {
            return new b(linearLayout, false);
        }
        linearLayout.setLayoutParams(new au0(-1, this.e));
        return new b(linearLayout, true);
    }
}
