package com.quickcursor.android.views.settings;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.quickcursor.R;
import com.quickcursor.android.activities.settings.EdgeActionsSettings;
import com.quickcursor.android.views.settings.EdgeBarConstraintLayout;
import defpackage.dx;
import defpackage.fx;
import defpackage.kn;
import defpackage.lc1;
import defpackage.lw;
import defpackage.nw;
import defpackage.rc;
import defpackage.x81;
import defpackage.xr;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class EdgeBarConstraintLayout extends ConstraintLayout {
    public boolean A;
    public boolean B;
    public FloatingActionButton C;
    public FloatingActionButton D;
    public EdgeBarLinearLayout E;
    public EdgeActionsSettings F;
    public final int r;
    public final int s;
    public final int t;
    public final int u;
    public dx v;
    public String w;
    public boolean x;
    public boolean y;
    public boolean z;

    public EdgeBarConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.r = lc1.z(R.dimen.edge_bar_fab_margin_when_hidden);
        this.s = lc1.z(R.dimen.edge_bar_fab_margin_when_shown);
        this.t = lc1.z(R.dimen.edge_settings_edge_bar_margin_hide);
        this.u = lc1.z(R.dimen.edge_settings_edge_bar_margin_show);
    }

    private String getLocationFromId() {
        if (this.x) {
            return "left";
        }
        if (this.y) {
            return "right";
        }
        if (this.z) {
            return "top";
        }
        if (this.A) {
            return "bottom";
        }
        return null;
    }

    public static void p(View view, float f) {
        view.setAlpha(f);
        view.setFocusable(f != 0.0f);
        view.setClickable(f != 0.0f);
    }

    private void setFabButtonConstraint(FloatingActionButton floatingActionButton) {
        kn knVar = (kn) floatingActionButton.getLayoutParams();
        if (this.x) {
            knVar.h = -1;
            return;
        }
        if (this.y) {
            knVar.e = -1;
        } else if (this.z) {
            knVar.l = -1;
        } else if (this.A) {
            knVar.i = -1;
        }
    }

    private void setFabHideButtonSrc(FloatingActionButton floatingActionButton) {
        if (this.x) {
            floatingActionButton.setImageResource(R.drawable.icon_edge_bar_hide_left);
            return;
        }
        if (this.y) {
            floatingActionButton.setImageResource(R.drawable.icon_edge_bar_hide_right);
        } else if (this.z) {
            floatingActionButton.setImageResource(R.drawable.icon_edge_bar_hide_top);
        } else if (this.A) {
            floatingActionButton.setImageResource(R.drawable.icon_edge_bar_hide_bottom);
        }
    }

    public dx getEdgeBar() {
        return this.v;
    }

    public String getLocation() {
        return this.w;
    }

    @Override // android.view.View
    public final boolean isEnabled() {
        return this.v.g().booleanValue();
    }

    public final void m(nw nwVar) {
        EdgeBarLinearLayout edgeBarLinearLayout = this.E;
        for (int i = 0; i < edgeBarLinearLayout.getChildCount(); i++) {
            nw nwVar2 = (nw) edgeBarLinearLayout.getChildAt(i);
            if (nwVar2 != nwVar) {
                nwVar2.b(false);
            }
        }
    }

    public final void n(dx dxVar) {
        this.F = (EdgeActionsSettings) getContext();
        final int i = 0;
        this.B = false;
        this.v = dxVar;
        View.inflate(getContext(), R.layout.edge_bar_constraint_layout, this);
        final int i2 = 1;
        this.x = getId() == R.id.leftEdgeBarLayout;
        this.y = getId() == R.id.rightEdgeBarLayout;
        this.z = getId() == R.id.topEdgeBarLayout;
        this.A = getId() == R.id.bottomEdgeBarLayout;
        if (!this.x) {
            boolean z = this.y;
        }
        this.w = getLocationFromId();
        this.E = (EdgeBarLinearLayout) findViewById(R.id.edgeBarLinearLayout);
        this.C = (FloatingActionButton) findViewById(R.id.fabOpenButton);
        this.D = (FloatingActionButton) findViewById(R.id.fabHideButton);
        this.C.setOnClickListener(new View.OnClickListener(this) { // from class: ex
            public final /* synthetic */ EdgeBarConstraintLayout c;

            {
                this.c = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3 = i;
                EdgeBarConstraintLayout edgeBarConstraintLayout = this.c;
                switch (i3) {
                    case 0:
                        edgeBarConstraintLayout.F.M(edgeBarConstraintLayout);
                        break;
                    default:
                        edgeBarConstraintLayout.F.H();
                        break;
                }
            }
        });
        this.D.setOnClickListener(new View.OnClickListener(this) { // from class: ex
            public final /* synthetic */ EdgeBarConstraintLayout c;

            {
                this.c = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3 = i2;
                EdgeBarConstraintLayout edgeBarConstraintLayout = this.c;
                switch (i3) {
                    case 0:
                        edgeBarConstraintLayout.F.M(edgeBarConstraintLayout);
                        break;
                    default:
                        edgeBarConstraintLayout.F.H();
                        break;
                }
            }
        });
        FloatingActionButton floatingActionButton = this.C;
        int i3 = this.r;
        r(floatingActionButton, i3);
        setFabButtonConstraint(this.C);
        r(this.D, i3);
        setFabButtonConstraint(this.D);
        setFabHideButtonSrc(this.D);
        p(this.D, 0.0f);
        p(this.C, 1.0f);
        EdgeBarLinearLayout edgeBarLinearLayout = this.E;
        String str = this.w;
        edgeBarLinearLayout.d = this.v;
        edgeBarLinearLayout.e = str;
        edgeBarLinearLayout.f = str.equals("left");
        edgeBarLinearLayout.g = edgeBarLinearLayout.e.equals("right");
        edgeBarLinearLayout.h = edgeBarLinearLayout.e.equals("top");
        edgeBarLinearLayout.i = edgeBarLinearLayout.e.equals("bottom");
        edgeBarLinearLayout.j = edgeBarLinearLayout.f || edgeBarLinearLayout.g;
        int i4 = edgeBarLinearLayout.b;
        kn knVar = (kn) edgeBarLinearLayout.getLayoutParams();
        if (edgeBarLinearLayout.j) {
            if (edgeBarLinearLayout.f) {
                knVar.h = -1;
            } else if (edgeBarLinearLayout.g) {
                knVar.e = -1;
            }
            ((ViewGroup.MarginLayoutParams) knVar).width = i4;
            ((ViewGroup.MarginLayoutParams) knVar).height = -1;
            edgeBarLinearLayout.setOrientation(1);
            edgeBarLinearLayout.setDividerDrawable(edgeBarLinearLayout.getResources().getDrawable(R.drawable.edge_bar_vertical_divider, null));
        } else {
            if (edgeBarLinearLayout.h) {
                knVar.l = -1;
            } else if (edgeBarLinearLayout.i) {
                knVar.i = -1;
            }
            ((ViewGroup.MarginLayoutParams) knVar).width = -1;
            ((ViewGroup.MarginLayoutParams) knVar).height = i4;
            int i5 = i4 - edgeBarLinearLayout.c;
            ((ViewGroup.MarginLayoutParams) knVar).leftMargin = i5;
            ((ViewGroup.MarginLayoutParams) knVar).rightMargin = i5;
            edgeBarLinearLayout.setOrientation(0);
            edgeBarLinearLayout.setDividerDrawable(edgeBarLinearLayout.getResources().getDrawable(R.drawable.edge_bar_horizontal_divider, null));
        }
        edgeBarLinearLayout.removeAllViews();
        Iterator it = edgeBarLinearLayout.d.d().iterator();
        while (it.hasNext()) {
            edgeBarLinearLayout.addView(new nw(edgeBarLinearLayout.getContext(), (lw) it.next(), Boolean.valueOf(edgeBarLinearLayout.j)));
        }
        edgeBarLinearLayout.setWeightSum(edgeBarLinearLayout.d.e());
        q(this.v.g().booleanValue(), false);
        setClickable(false);
        setFocusable(false);
    }

    public final void o(Boolean bool, EdgeBarConstraintLayout edgeBarConstraintLayout) {
        ViewGroup viewGroup = (ViewGroup) getRootView().findViewById(R.id.edgeActionsSettingsRootView);
        rc rcVar = new rc();
        ArrayList arrayList = rcVar.h;
        Integer numValueOf = Integer.valueOf(R.id.settings);
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        if (!arrayList.contains(numValueOf)) {
            arrayList.add(numValueOf);
        }
        rcVar.h = arrayList;
        x81.a(viewGroup, rcVar);
        int i = bool.booleanValue() ? this.u : this.t;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
        if (this.x) {
            layoutParams.leftMargin = i;
        } else if (this.y) {
            layoutParams.rightMargin = i;
        } else if (this.z) {
            layoutParams.topMargin = i;
        } else if (this.A) {
            layoutParams.bottomMargin = i;
        }
        if (this.z || this.A) {
            EdgeBarLinearLayout edgeBarLinearLayout = this.E;
            boolean z = false;
            boolean z2 = edgeBarConstraintLayout != null && edgeBarConstraintLayout.x;
            if (edgeBarConstraintLayout != null && edgeBarConstraintLayout.y) {
                z = true;
            }
            int i2 = edgeBarLinearLayout.b;
            int i3 = edgeBarLinearLayout.c;
            kn knVar = (kn) edgeBarLinearLayout.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) knVar).leftMargin = z2 ? i3 : i2 - i3;
            if (!z) {
                i3 = i2 - i3;
            }
            ((ViewGroup.MarginLayoutParams) knVar).rightMargin = i3;
        }
        FloatingActionButton floatingActionButton = this.C;
        boolean zBooleanValue = bool.booleanValue();
        int i4 = this.r;
        int i5 = this.s;
        r(floatingActionButton, zBooleanValue ? i5 : i4);
        FloatingActionButton floatingActionButton2 = this.D;
        if (bool.booleanValue()) {
            i4 = i5;
        }
        r(floatingActionButton2, i4);
        p(bool.booleanValue() ? this.C : this.D, 0.0f);
        p(bool.booleanValue() ? this.D : this.C, bool.booleanValue() ? 0.7f : 1.0f);
        this.C.requestLayout();
        this.D.requestLayout();
        this.B = bool.booleanValue();
        if (bool.booleanValue()) {
            return;
        }
        m(null);
    }

    public final void q(boolean z, boolean z2) {
        super.setEnabled(z);
        this.v.j(Boolean.valueOf(z));
        setClickable(false);
        setFocusable(false);
        if (z) {
            setVisibility(0);
        }
        if (z2) {
            animate().alpha(z ? 1.0f : 0.0f).setListener(new fx(this, z));
            return;
        }
        setAlpha(z ? 1.0f : 0.0f);
        xr.I(this, z);
        if (z) {
            return;
        }
        setVisibility(8);
    }

    public final void r(FloatingActionButton floatingActionButton, int i) {
        kn knVar = (kn) floatingActionButton.getLayoutParams();
        if (this.x) {
            ((ViewGroup.MarginLayoutParams) knVar).leftMargin = i;
            return;
        }
        if (this.y) {
            ((ViewGroup.MarginLayoutParams) knVar).rightMargin = i;
        } else if (this.z) {
            ((ViewGroup.MarginLayoutParams) knVar).topMargin = i;
        } else if (this.A) {
            ((ViewGroup.MarginLayoutParams) knVar).bottomMargin = i;
        }
    }
}
