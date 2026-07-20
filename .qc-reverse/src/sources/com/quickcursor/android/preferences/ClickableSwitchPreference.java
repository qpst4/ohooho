package com.quickcursor.android.preferences;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.preference.SwitchPreference;
import com.quickcursor.App;
import com.quickcursor.R;
import com.quickcursor.android.activities.settings.EdgeActionsSettings;
import com.quickcursor.android.preferences.ClickableSwitchPreference;
import com.quickcursor.android.views.settings.EdgeBarConstraintLayout;
import defpackage.nq0;
import defpackage.tk0;
import defpackage.uf1;
import defpackage.uw;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ClickableSwitchPreference extends SwitchPreference {
    public uw W;
    public RelativeLayout X;
    public TextView Y;

    public ClickableSwitchPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 0);
        this.F = R.layout.clickable_switch_preference;
    }

    @Override // androidx.preference.TwoStatePreference
    public final void J(boolean z) {
        super.J(z);
        RelativeLayout relativeLayout = this.X;
        if (relativeLayout != null) {
            relativeLayout.setClickable(z);
            this.X.setFocusable(z);
            TypedValue typedValue = new TypedValue();
            Context context = this.b;
            context.getTheme().resolveAttribute(android.R.attr.selectableItemBackground, typedValue, true);
            RelativeLayout relativeLayout2 = this.X;
            Drawable drawableJ = z ? tk0.j(context, typedValue.resourceId) : null;
            WeakHashMap weakHashMap = uf1.a;
            relativeLayout2.setBackground(drawableJ);
            this.Y.setTextColor(App.c.getColor(z ? R.color.preference_enabled_text_color : R.color.preference_disabled_text_color));
        }
    }

    @Override // androidx.preference.SwitchPreference, androidx.preference.Preference
    public final void o(nq0 nq0Var) {
        super.o(nq0Var);
        View view = nq0Var.a;
        view.setOnClickListener(null);
        RelativeLayout relativeLayout = (RelativeLayout) nq0Var.r(R.id.title);
        this.X = relativeLayout;
        this.Y = (TextView) relativeLayout.findViewById(android.R.id.title);
        final int i = 0;
        this.X.setOnClickListener(new View.OnClickListener(this) { // from class: tk
            public final /* synthetic */ ClickableSwitchPreference c;

            {
                this.c = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EdgeActionsSettings edgeActionsSettings;
                String str;
                EdgeBarConstraintLayout edgeBarConstraintLayout;
                EdgeActionsSettings edgeActionsSettings2;
                String str2;
                EdgeBarConstraintLayout edgeBarConstraintLayout2;
                int i2 = i;
                ClickableSwitchPreference clickableSwitchPreference = this.c;
                switch (i2) {
                    case 0:
                        uw uwVar = clickableSwitchPreference.W;
                        if (uwVar != null) {
                            edgeActionsSettings = uwVar.h0;
                            String str3 = clickableSwitchPreference.m;
                            str3.getClass();
                            switch (str3) {
                                case "rightEdgeBar":
                                    str = "right";
                                    break;
                                case "bottomEdgeBar":
                                    str = "bottom";
                                    break;
                                case "leftEdgeBar":
                                    str = "left";
                                    break;
                                case "topEdgeBar":
                                    str = "top";
                                    break;
                                default:
                                    str = null;
                                    break;
                            }
                            edgeActionsSettings.getClass();
                            str.getClass();
                            switch (str) {
                                case "bottom":
                                    edgeBarConstraintLayout = edgeActionsSettings.O;
                                    break;
                                case "top":
                                    edgeBarConstraintLayout = edgeActionsSettings.M;
                                    break;
                                case "left":
                                    edgeBarConstraintLayout = edgeActionsSettings.L;
                                    break;
                                case "right":
                                    edgeBarConstraintLayout = edgeActionsSettings.N;
                                    break;
                                default:
                                    edgeBarConstraintLayout = null;
                                    break;
                            }
                            edgeActionsSettings.M(edgeBarConstraintLayout);
                            uwVar.h0.I();
                        }
                        break;
                    default:
                        String str4 = clickableSwitchPreference.m;
                        boolean z = !clickableSwitchPreference.O;
                        if (clickableSwitchPreference.a(Boolean.valueOf(z))) {
                            clickableSwitchPreference.J(z);
                            uw uwVar2 = clickableSwitchPreference.W;
                            if (uwVar2 != null) {
                                boolean z2 = clickableSwitchPreference.O;
                                if (zq0.b.c() || clickableSwitchPreference == uwVar2.j0) {
                                    xw xwVar = xw.e;
                                    xwVar.d(str4).j(Boolean.valueOf(z2));
                                    xwVar.g();
                                    edgeActionsSettings2 = uwVar2.h0;
                                    str4.getClass();
                                    switch (str4) {
                                        case "rightEdgeBar":
                                            str2 = "right";
                                            break;
                                        case "bottomEdgeBar":
                                            str2 = "bottom";
                                            break;
                                        case "leftEdgeBar":
                                            str2 = "left";
                                            break;
                                        case "topEdgeBar":
                                            str2 = "top";
                                            break;
                                        default:
                                            str2 = null;
                                            break;
                                    }
                                    edgeActionsSettings2.getClass();
                                    str2.getClass();
                                    switch (str2) {
                                        case "bottom":
                                            edgeBarConstraintLayout2 = edgeActionsSettings2.O;
                                            break;
                                        case "top":
                                            edgeBarConstraintLayout2 = edgeActionsSettings2.M;
                                            break;
                                        case "left":
                                            edgeBarConstraintLayout2 = edgeActionsSettings2.L;
                                            break;
                                        case "right":
                                            edgeBarConstraintLayout2 = edgeActionsSettings2.N;
                                            break;
                                        default:
                                            edgeBarConstraintLayout2 = null;
                                            break;
                                    }
                                    edgeBarConstraintLayout2.q(z2, true);
                                    edgeActionsSettings2.K();
                                    edgeActionsSettings2.I();
                                    uwVar2.h0.I();
                                } else {
                                    clickableSwitchPreference.J(!z2);
                                }
                            }
                        }
                        break;
                }
            }
        });
        final int i2 = 1;
        view.findViewById(android.R.id.widget_frame).setOnClickListener(new View.OnClickListener(this) { // from class: tk
            public final /* synthetic */ ClickableSwitchPreference c;

            {
                this.c = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EdgeActionsSettings edgeActionsSettings;
                String str;
                EdgeBarConstraintLayout edgeBarConstraintLayout;
                EdgeActionsSettings edgeActionsSettings2;
                String str2;
                EdgeBarConstraintLayout edgeBarConstraintLayout2;
                int i22 = i2;
                ClickableSwitchPreference clickableSwitchPreference = this.c;
                switch (i22) {
                    case 0:
                        uw uwVar = clickableSwitchPreference.W;
                        if (uwVar != null) {
                            edgeActionsSettings = uwVar.h0;
                            String str3 = clickableSwitchPreference.m;
                            str3.getClass();
                            switch (str3) {
                                case "rightEdgeBar":
                                    str = "right";
                                    break;
                                case "bottomEdgeBar":
                                    str = "bottom";
                                    break;
                                case "leftEdgeBar":
                                    str = "left";
                                    break;
                                case "topEdgeBar":
                                    str = "top";
                                    break;
                                default:
                                    str = null;
                                    break;
                            }
                            edgeActionsSettings.getClass();
                            str.getClass();
                            switch (str) {
                                case "bottom":
                                    edgeBarConstraintLayout = edgeActionsSettings.O;
                                    break;
                                case "top":
                                    edgeBarConstraintLayout = edgeActionsSettings.M;
                                    break;
                                case "left":
                                    edgeBarConstraintLayout = edgeActionsSettings.L;
                                    break;
                                case "right":
                                    edgeBarConstraintLayout = edgeActionsSettings.N;
                                    break;
                                default:
                                    edgeBarConstraintLayout = null;
                                    break;
                            }
                            edgeActionsSettings.M(edgeBarConstraintLayout);
                            uwVar.h0.I();
                        }
                        break;
                    default:
                        String str4 = clickableSwitchPreference.m;
                        boolean z = !clickableSwitchPreference.O;
                        if (clickableSwitchPreference.a(Boolean.valueOf(z))) {
                            clickableSwitchPreference.J(z);
                            uw uwVar2 = clickableSwitchPreference.W;
                            if (uwVar2 != null) {
                                boolean z2 = clickableSwitchPreference.O;
                                if (zq0.b.c() || clickableSwitchPreference == uwVar2.j0) {
                                    xw xwVar = xw.e;
                                    xwVar.d(str4).j(Boolean.valueOf(z2));
                                    xwVar.g();
                                    edgeActionsSettings2 = uwVar2.h0;
                                    str4.getClass();
                                    switch (str4) {
                                        case "rightEdgeBar":
                                            str2 = "right";
                                            break;
                                        case "bottomEdgeBar":
                                            str2 = "bottom";
                                            break;
                                        case "leftEdgeBar":
                                            str2 = "left";
                                            break;
                                        case "topEdgeBar":
                                            str2 = "top";
                                            break;
                                        default:
                                            str2 = null;
                                            break;
                                    }
                                    edgeActionsSettings2.getClass();
                                    str2.getClass();
                                    switch (str2) {
                                        case "bottom":
                                            edgeBarConstraintLayout2 = edgeActionsSettings2.O;
                                            break;
                                        case "top":
                                            edgeBarConstraintLayout2 = edgeActionsSettings2.M;
                                            break;
                                        case "left":
                                            edgeBarConstraintLayout2 = edgeActionsSettings2.L;
                                            break;
                                        case "right":
                                            edgeBarConstraintLayout2 = edgeActionsSettings2.N;
                                            break;
                                        default:
                                            edgeBarConstraintLayout2 = null;
                                            break;
                                    }
                                    edgeBarConstraintLayout2.q(z2, true);
                                    edgeActionsSettings2.K();
                                    edgeActionsSettings2.I();
                                    uwVar2.h0.I();
                                } else {
                                    clickableSwitchPreference.J(!z2);
                                }
                            }
                        }
                        break;
                }
            }
        });
        J(this.O);
    }

    public ClickableSwitchPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.F = R.layout.clickable_switch_preference;
    }

    public ClickableSwitchPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.F = R.layout.clickable_switch_preference;
    }

    public ClickableSwitchPreference(Context context) {
        super(context, null);
        this.F = R.layout.clickable_switch_preference;
    }

    @Override // androidx.preference.TwoStatePreference, androidx.preference.Preference
    public final void p() {
    }
}
