package defpackage;

import android.R;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Scroller;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.datepicker.c;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class zj0<S> extends op0 {
    public int Z;
    public fi a0;
    public yl0 b0;
    public int c0;
    public i9 d0;
    public RecyclerView e0;
    public RecyclerView f0;
    public View g0;
    public View h0;
    public View i0;
    public View j0;

    @Override // defpackage.j30
    public final void J(Bundle bundle) {
        super.J(bundle);
        if (bundle == null) {
            bundle = this.h;
        }
        this.Z = bundle.getInt("THEME_RES_ID_KEY");
        if (bundle.getParcelable("GRID_SELECTOR_KEY") != null) {
            s1.d();
            return;
        }
        this.a0 = (fi) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        if (bundle.getParcelable("DAY_VIEW_DECORATOR_KEY") == null) {
            this.b0 = (yl0) bundle.getParcelable("CURRENT_MONTH_KEY");
        } else {
            s1.d();
        }
    }

    @Override // defpackage.j30
    public final View K(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        int i;
        int i2;
        zo0 zo0Var;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(u(), this.Z);
        this.d0 = new i9(contextThemeWrapper);
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        yl0 yl0Var = this.a0.b;
        int i3 = 0;
        int i4 = 1;
        if (fk0.m0(contextThemeWrapper, R.attr.windowFullscreen)) {
            i = com.quickcursor.R.layout.mtrl_calendar_vertical;
            i2 = 1;
        } else {
            i = com.quickcursor.R.layout.mtrl_calendar_horizontal;
            i2 = 0;
        }
        View viewInflate = layoutInflaterCloneInContext.inflate(i, viewGroup, false);
        Resources resources = o().getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(com.quickcursor.R.dimen.mtrl_calendar_navigation_bottom_padding) + resources.getDimensionPixelOffset(com.quickcursor.R.dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelSize(com.quickcursor.R.dimen.mtrl_calendar_navigation_height);
        int dimensionPixelSize = resources.getDimensionPixelSize(com.quickcursor.R.dimen.mtrl_calendar_days_of_week_height);
        int i5 = zl0.d;
        viewInflate.setMinimumHeight(dimensionPixelOffset + dimensionPixelSize + (resources.getDimensionPixelOffset(com.quickcursor.R.dimen.mtrl_calendar_month_vertical_padding) * (i5 - 1)) + (resources.getDimensionPixelSize(com.quickcursor.R.dimen.mtrl_calendar_day_height) * i5) + resources.getDimensionPixelOffset(com.quickcursor.R.dimen.mtrl_calendar_bottom_padding));
        GridView gridView = (GridView) viewInflate.findViewById(com.quickcursor.R.id.mtrl_calendar_days_of_week);
        uf1.n(gridView, new vj0(0));
        int i6 = this.a0.f;
        gridView.setAdapter((ListAdapter) (i6 > 0 ? new qr(i6) : new qr()));
        gridView.setNumColumns(yl0Var.e);
        gridView.setEnabled(false);
        this.f0 = (RecyclerView) viewInflate.findViewById(com.quickcursor.R.id.mtrl_calendar_months);
        this.f0.setLayoutManager(new wj0(this, i2, i2));
        this.f0.setTag("MONTHS_VIEW_GROUP_TAG");
        c cVar = new c(contextThemeWrapper, this.a0, new tb0(7, this));
        this.f0.setAdapter(cVar);
        int integer = contextThemeWrapper.getResources().getInteger(com.quickcursor.R.integer.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView3 = (RecyclerView) viewInflate.findViewById(com.quickcursor.R.id.mtrl_calendar_year_selector_frame);
        this.e0 = recyclerView3;
        if (recyclerView3 != null) {
            recyclerView3.setHasFixedSize(true);
            this.e0.setLayoutManager(new GridLayoutManager(integer));
            this.e0.setAdapter(new fj1(this));
            RecyclerView recyclerView4 = this.e0;
            xj0 xj0Var = new xj0();
            wd1.c(null);
            wd1.c(null);
            recyclerView4.g(xj0Var);
        }
        if (viewInflate.findViewById(com.quickcursor.R.id.month_navigation_fragment_toggle) != null) {
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(com.quickcursor.R.id.month_navigation_fragment_toggle);
            materialButton.setTag("SELECTOR_TOGGLE_TAG");
            uf1.n(materialButton, new xj(2, this));
            View viewFindViewById = viewInflate.findViewById(com.quickcursor.R.id.month_navigation_previous);
            this.g0 = viewFindViewById;
            viewFindViewById.setTag("NAVIGATION_PREV_TAG");
            View viewFindViewById2 = viewInflate.findViewById(com.quickcursor.R.id.month_navigation_next);
            this.h0 = viewFindViewById2;
            viewFindViewById2.setTag("NAVIGATION_NEXT_TAG");
            this.i0 = viewInflate.findViewById(com.quickcursor.R.id.mtrl_calendar_year_selector_frame);
            this.j0 = viewInflate.findViewById(com.quickcursor.R.id.mtrl_calendar_day_selector_frame);
            i0(1);
            materialButton.setText(this.b0.c());
            this.f0.h(new yj0(this, cVar, materialButton));
            materialButton.setOnClickListener(new l1(3, this));
            this.h0.setOnClickListener(new uj0(this, cVar, i4));
            this.g0.setOnClickListener(new uj0(this, cVar, i3));
        }
        if (!fk0.m0(contextThemeWrapper, R.attr.windowFullscreen) && (recyclerView2 = (zo0Var = new zo0()).a) != (recyclerView = this.f0)) {
            i11 i11Var = zo0Var.b;
            if (recyclerView2 != null) {
                ArrayList arrayList = recyclerView2.i0;
                if (arrayList != null) {
                    arrayList.remove(i11Var);
                }
                zo0Var.a.setOnFlingListener(null);
            }
            zo0Var.a = recyclerView;
            if (recyclerView != null) {
                if (recyclerView.getOnFlingListener() != null) {
                    s1.f("An instance of OnFlingListener already set.");
                    return null;
                }
                zo0Var.a.h(i11Var);
                zo0Var.a.setOnFlingListener(zo0Var);
                new Scroller(zo0Var.a.getContext(), new DecelerateInterpolator());
                zo0Var.f();
            }
        }
        this.f0.d0(cVar.c.b.d(this.b0));
        uf1.n(this.f0, new vj0(1));
        return viewInflate;
    }

    @Override // defpackage.j30
    public final void S(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.Z);
        bundle.putParcelable("GRID_SELECTOR_KEY", null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.a0);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", null);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.b0);
    }

    public final void h0(yl0 yl0Var) {
        c cVar = (c) this.f0.getAdapter();
        int iD = cVar.c.b.d(yl0Var);
        int iD2 = iD - cVar.c.b.d(this.b0);
        boolean z = Math.abs(iD2) > 3;
        boolean z2 = iD2 > 0;
        this.b0 = yl0Var;
        int i = 2;
        if (z && z2) {
            this.f0.d0(iD - 3);
            this.f0.post(new hi(iD, i, this));
            return;
        }
        RecyclerView recyclerView = this.f0;
        if (!z) {
            recyclerView.post(new hi(iD, i, this));
        } else {
            recyclerView.d0(iD + 3);
            this.f0.post(new hi(iD, i, this));
        }
    }

    public final void i0(int i) {
        this.c0 = i;
        if (i == 2) {
            this.e0.getLayoutManager().r0(this.b0.d - ((fj1) this.e0.getAdapter()).c.a0.b.d);
            this.i0.setVisibility(0);
            this.j0.setVisibility(8);
            this.g0.setVisibility(8);
            this.h0.setVisibility(8);
            return;
        }
        if (i == 1) {
            this.i0.setVisibility(8);
            this.j0.setVisibility(0);
            this.g0.setVisibility(0);
            this.h0.setVisibility(0);
            h0(this.b0);
        }
    }
}
