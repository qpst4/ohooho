package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.internal.CheckableImageButton;
import com.quickcursor.R;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class fk0<S> extends wt {
    public int A0;
    public CharSequence B0;
    public int C0;
    public CharSequence D0;
    public int E0;
    public CharSequence F0;
    public TextView G0;
    public CheckableImageButton H0;
    public ik0 I0;
    public boolean J0;
    public CharSequence K0;
    public CharSequence L0;
    public final LinkedHashSet o0;
    public final LinkedHashSet p0;
    public int q0;
    public op0 r0;
    public fi s0;
    public zj0 t0;
    public int u0;
    public CharSequence v0;
    public boolean w0;
    public int x0;
    public int y0;
    public CharSequence z0;

    public fk0() {
        new LinkedHashSet();
        new LinkedHashSet();
        this.o0 = new LinkedHashSet();
        this.p0 = new LinkedHashSet();
    }

    public static int l0(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_content_padding);
        Calendar calendarB = wd1.b();
        calendarB.set(5, 1);
        Calendar calendarA = wd1.a(calendarB);
        calendarA.get(2);
        calendarA.get(1);
        int maximum = calendarA.getMaximum(7);
        calendarA.getActualMaximum(5);
        calendarA.getTimeInMillis();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_width) * maximum;
        return ((maximum - 1) * resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_horizontal_padding)) + dimensionPixelSize + (dimensionPixelOffset * 2);
    }

    public static boolean m0(Context context, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i1.V(R.attr.materialCalendarStyle, context, zj0.class.getCanonicalName()).data, new int[]{i});
        boolean z = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z;
    }

    @Override // defpackage.wt, defpackage.j30
    public final void J(Bundle bundle) {
        super.J(bundle);
        if (bundle == null) {
            bundle = this.h;
        }
        this.q0 = bundle.getInt("OVERRIDE_THEME_RES_ID");
        if (bundle.getParcelable("DATE_SELECTOR_KEY") != null) {
            s1.d();
            return;
        }
        this.s0 = (fi) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        if (bundle.getParcelable("DAY_VIEW_DECORATOR_KEY") != null) {
            s1.d();
            return;
        }
        this.u0 = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.v0 = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.x0 = bundle.getInt("INPUT_MODE_KEY");
        this.y0 = bundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.z0 = bundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.A0 = bundle.getInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.B0 = bundle.getCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        this.C0 = bundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.D0 = bundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
        this.E0 = bundle.getInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.F0 = bundle.getCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        CharSequence text = this.v0;
        if (text == null) {
            text = o().getResources().getText(this.u0);
        }
        this.K0 = text;
        if (text != null) {
            CharSequence[] charSequenceArrSplit = TextUtils.split(String.valueOf(text), "\n");
            if (charSequenceArrSplit.length > 1) {
                text = charSequenceArrSplit[0];
            }
        } else {
            text = null;
        }
        this.L0 = text;
    }

    @Override // defpackage.j30
    public final View K(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(this.w0 ? R.layout.mtrl_picker_fullscreen : R.layout.mtrl_picker_dialog, viewGroup);
        Context context = viewInflate.getContext();
        if (this.w0) {
            viewInflate.findViewById(R.id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(l0(context), -2));
        } else {
            viewInflate.findViewById(R.id.mtrl_calendar_main_pane).setLayoutParams(new LinearLayout.LayoutParams(l0(context), -1));
        }
        TextView textView = (TextView) viewInflate.findViewById(R.id.mtrl_picker_header_selection_text);
        WeakHashMap weakHashMap = uf1.a;
        textView.setAccessibilityLiveRegion(1);
        this.H0 = (CheckableImageButton) viewInflate.findViewById(R.id.mtrl_picker_header_toggle);
        this.G0 = (TextView) viewInflate.findViewById(R.id.mtrl_picker_title_text);
        this.H0.setTag("TOGGLE_BUTTON_TAG");
        CheckableImageButton checkableImageButton = this.H0;
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_checked}, tk0.j(context, R.drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], tk0.j(context, R.drawable.material_ic_edit_black_24dp));
        checkableImageButton.setImageDrawable(stateListDrawable);
        this.H0.setChecked(this.x0 != 0);
        uf1.n(this.H0, null);
        CheckableImageButton checkableImageButton2 = this.H0;
        this.H0.setContentDescription(this.x0 == 1 ? checkableImageButton2.getContext().getString(R.string.mtrl_picker_toggle_to_calendar_input_mode) : checkableImageButton2.getContext().getString(R.string.mtrl_picker_toggle_to_text_input_mode));
        this.H0.setOnClickListener(new a3(11, this));
        k0();
        throw null;
    }

    @Override // defpackage.wt, defpackage.j30
    public final void S(Bundle bundle) {
        super.S(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.q0);
        bundle.putParcelable("DATE_SELECTOR_KEY", null);
        fi fiVar = this.s0;
        ei eiVar = new ei();
        long j = fiVar.b.g;
        long j2 = fiVar.c.g;
        eiVar.a = Long.valueOf(fiVar.e.g);
        int i = fiVar.f;
        pr prVar = fiVar.d;
        zj0 zj0Var = this.t0;
        yl0 yl0Var = zj0Var == null ? null : zj0Var.b0;
        if (yl0Var != null) {
            eiVar.a = Long.valueOf(yl0Var.g);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("DEEP_COPY_VALIDATOR_KEY", prVar);
        yl0 yl0VarB = yl0.b(j);
        yl0 yl0VarB2 = yl0.b(j2);
        pr prVar2 = (pr) bundle2.getParcelable("DEEP_COPY_VALIDATOR_KEY");
        Long l = eiVar.a;
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", new fi(yl0VarB, yl0VarB2, prVar2, l == null ? null : yl0.b(l.longValue()), i));
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", null);
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.u0);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.v0);
        bundle.putInt("INPUT_MODE_KEY", this.x0);
        bundle.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.y0);
        bundle.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.z0);
        bundle.putInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.A0);
        bundle.putCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.B0);
        bundle.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.C0);
        bundle.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.D0);
        bundle.putInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.E0);
        bundle.putCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.F0);
    }

    @Override // defpackage.wt, defpackage.j30
    public final void T() {
        xy0 yi1Var;
        xy0 yi1Var2;
        super.T();
        Dialog dialog = this.j0;
        if (dialog == null) {
            throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
        }
        Window window = dialog.getWindow();
        if (this.w0) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.I0);
            if (!this.J0) {
                View viewFindViewById = a0().findViewById(R.id.fullscreen_header);
                ColorStateList colorStateListX = lc1.x(viewFindViewById.getBackground());
                Integer numValueOf = colorStateListX != null ? Integer.valueOf(colorStateListX.getDefaultColor()) : null;
                boolean z = numValueOf == null || numValueOf.intValue() == 0;
                int iK = xr.k(window.getContext(), android.R.attr.colorBackground, -16777216);
                if (z) {
                    numValueOf = Integer.valueOf(iK);
                }
                int i = Build.VERSION.SDK_INT;
                if (i >= 35) {
                    i0.e(window, false);
                } else if (i >= 30) {
                    i0.d(window, false);
                } else {
                    View decorView = window.getDecorView();
                    decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 1792);
                }
                window.getContext();
                int iF = i < 27 ? wl.f(xr.k(window.getContext(), android.R.attr.navigationBarColor, -16777216), 128) : 0;
                window.setStatusBarColor(0);
                window.setNavigationBarColor(iF);
                int iIntValue = numValueOf.intValue();
                boolean z2 = iIntValue != 0 && wl.c(iIntValue) > 0.5d;
                c70 c70Var = new c70(window.getDecorView());
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 35) {
                    aj1 aj1Var = new aj1(window.getInsetsController(), c70Var);
                    aj1Var.m = window;
                    yi1Var = aj1Var;
                } else if (i2 >= 30) {
                    zi1 zi1Var = new zi1(window.getInsetsController(), c70Var);
                    zi1Var.m = window;
                    yi1Var = zi1Var;
                } else {
                    yi1Var = i2 >= 26 ? new yi1(window, c70Var) : new xi1(window, c70Var);
                }
                yi1Var.E(z2);
                boolean z3 = (iF != 0 && wl.c(iF) > 0.5d) || (iF == 0 && (iK != 0 && (wl.c(iK) > 0.5d ? 1 : (wl.c(iK) == 0.5d ? 0 : -1)) > 0));
                c70 c70Var2 = new c70(window.getDecorView());
                int i3 = Build.VERSION.SDK_INT;
                if (i3 >= 35) {
                    aj1 aj1Var2 = new aj1(window.getInsetsController(), c70Var2);
                    aj1Var2.m = window;
                    yi1Var2 = aj1Var2;
                } else if (i3 >= 30) {
                    zi1 zi1Var2 = new zi1(window.getInsetsController(), c70Var2);
                    zi1Var2.m = window;
                    yi1Var2 = zi1Var2;
                } else {
                    yi1Var2 = i3 >= 26 ? new yi1(window, c70Var2) : new xi1(window, c70Var2);
                }
                yi1Var2.D(z3);
                ek0 ek0Var = new ek0(viewFindViewById, viewFindViewById.getLayoutParams().height, viewFindViewById.getPaddingTop());
                WeakHashMap weakHashMap = uf1.a;
                lf1.l(viewFindViewById, ek0Var);
                this.J0 = true;
            }
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = y().getDimensionPixelOffset(R.dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.I0, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            View decorView2 = window.getDecorView();
            Dialog dialog2 = this.j0;
            if (dialog2 == null) {
                throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
            }
            decorView2.setOnTouchListener(new wb0(dialog2, rect));
        }
        o();
        int i4 = this.q0;
        if (i4 == 0) {
            k0();
            throw null;
        }
        k0();
        fi fiVar = this.s0;
        zj0 zj0Var = new zj0();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i4);
        bundle.putParcelable("GRID_SELECTOR_KEY", null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", fiVar);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", null);
        bundle.putParcelable("CURRENT_MONTH_KEY", fiVar.e);
        zj0Var.c0(bundle);
        this.t0 = zj0Var;
        op0 op0Var = zj0Var;
        if (this.x0 == 1) {
            k0();
            fi fiVar2 = this.s0;
            jk0 jk0Var = new jk0();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("THEME_RES_ID_KEY", i4);
            bundle2.putParcelable("DATE_SELECTOR_KEY", null);
            bundle2.putParcelable("CALENDAR_CONSTRAINTS_KEY", fiVar2);
            jk0Var.c0(bundle2);
            op0Var = jk0Var;
        }
        this.r0 = op0Var;
        this.G0.setText((this.x0 == 1 && y().getConfiguration().orientation == 2) ? this.L0 : this.K0);
        k0();
        throw null;
    }

    @Override // defpackage.wt, defpackage.j30
    public final void U() {
        this.r0.Y.clear();
        super.U();
    }

    @Override // defpackage.wt
    public final Dialog i0() {
        Context contextO = o();
        o();
        int i = this.q0;
        if (i == 0) {
            k0();
            throw null;
        }
        Dialog dialog = new Dialog(contextO, i);
        Context context = dialog.getContext();
        this.w0 = m0(context, android.R.attr.windowFullscreen);
        this.I0 = new ik0(context, null, R.attr.materialCalendarStyle, R.style.Widget_MaterialComponents_MaterialCalendar);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, ys0.p, R.attr.materialCalendarStyle, R.style.Widget_MaterialComponents_MaterialCalendar);
        int color = typedArrayObtainStyledAttributes.getColor(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.I0.i(context);
        this.I0.k(ColorStateList.valueOf(color));
        ik0 ik0Var = this.I0;
        View decorView = dialog.getWindow().getDecorView();
        WeakHashMap weakHashMap = uf1.a;
        ik0Var.j(lf1.e(decorView));
        return dialog;
    }

    public final void k0() {
        if (this.h.getParcelable("DATE_SELECTOR_KEY") == null) {
            return;
        }
        s1.d();
    }

    @Override // defpackage.wt, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator it = this.o0.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnCancelListener) it.next()).onCancel(dialogInterface);
        }
    }

    @Override // defpackage.wt, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator it = this.p0.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnDismissListener) it.next()).onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) this.H;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }
}
