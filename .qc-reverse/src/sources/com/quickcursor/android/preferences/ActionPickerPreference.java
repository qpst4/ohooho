package com.quickcursor.android.preferences;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.preference.Preference;
import com.quickcursor.App;
import com.quickcursor.R;
import com.quickcursor.android.preferences.ActionPickerPreference;
import defpackage.b61;
import defpackage.j;
import defpackage.lc1;
import defpackage.m3;
import defpackage.ms0;
import defpackage.nq0;
import defpackage.r51;
import defpackage.s2;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ActionPickerPreference extends Preference {
    public j O;
    public m3 P;
    public View Q;
    public View R;
    public final Drawable S;
    public Runnable T;
    public AppCompatImageView U;
    public View V;
    public final r51 W;

    public ActionPickerPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i = 1;
        this.W = new r51(50L, true);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, ms0.a, 0, 0);
        try {
            this.S = lc1.A(App.c, typedArrayObtainStyledAttributes.getResourceId(0, 0));
        } catch (Exception unused) {
            this.S = null;
        }
        typedArrayObtainStyledAttributes.recycle();
        this.F = R.layout.preference_action_chooser;
        b61.b(new s2(this, i), 25L);
    }

    public final void J() {
        this.W.a(new s2(this, 0));
    }

    public final void K(j jVar) {
        this.O = jVar;
        J();
    }

    @Override // androidx.preference.Preference
    public final void o(nq0 nq0Var) {
        super.o(nq0Var);
        View view = nq0Var.a;
        this.R = view.findViewById(R.id.edit_separator);
        View viewFindViewById = view.findViewById(R.id.edit_button);
        this.Q = viewFindViewById;
        viewFindViewById.setOnClickListener(new View.OnClickListener(this) { // from class: t2
            public final /* synthetic */ ActionPickerPreference c;

            {
                this.c = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int i = i;
                ActionPickerPreference actionPickerPreference = this.c;
                switch (i) {
                    case 0:
                        actionPickerPreference.O.b().actionTypePickedInterceptor.c(actionPickerPreference.P, actionPickerPreference.O.b(), true, actionPickerPreference.O.c());
                        break;
                    default:
                        Runnable runnable = actionPickerPreference.T;
                        if (runnable != null) {
                            runnable.run();
                        }
                        break;
                }
            }
        });
        this.V = view.findViewById(R.id.custom_separator);
        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R.id.custom_button);
        this.U = appCompatImageView;
        final int i = 1;
        appCompatImageView.setOnClickListener(new View.OnClickListener(this) { // from class: t2
            public final /* synthetic */ ActionPickerPreference c;

            {
                this.c = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int i2 = i;
                ActionPickerPreference actionPickerPreference = this.c;
                switch (i2) {
                    case 0:
                        actionPickerPreference.O.b().actionTypePickedInterceptor.c(actionPickerPreference.P, actionPickerPreference.O.b(), true, actionPickerPreference.O.c());
                        break;
                    default:
                        Runnable runnable = actionPickerPreference.T;
                        if (runnable != null) {
                            runnable.run();
                        }
                        break;
                }
            }
        });
        b61.b(new s2(this, i), 25L);
        AppCompatImageView appCompatImageView2 = this.U;
        if (appCompatImageView2 != null) {
            Drawable drawable = this.S;
            i = drawable == null ? 8 : 0;
            appCompatImageView2.setVisibility(i);
            this.V.setVisibility(i);
            this.U.setImageDrawable(drawable);
            this.U.setAlpha(j() ? 1.0f : 0.3f);
            this.U.setEnabled(j());
        }
    }
}
