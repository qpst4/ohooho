package defpackage;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.textfield.TextInputLayout;
import com.quickcursor.R;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class db0 {
    public ColorStateList A;
    public Typeface B;
    public final int a;
    public final int b;
    public final int c;
    public final TimeInterpolator d;
    public final TimeInterpolator e;
    public final TimeInterpolator f;
    public final Context g;
    public final TextInputLayout h;
    public LinearLayout i;
    public int j;
    public FrameLayout k;
    public AnimatorSet l;
    public final float m;
    public int n;
    public int o;
    public CharSequence p;
    public boolean q;
    public AppCompatTextView r;
    public CharSequence s;
    public int t;
    public int u;
    public ColorStateList v;
    public CharSequence w;
    public boolean x;
    public AppCompatTextView y;
    public int z;

    public db0(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.g = context;
        this.h = textInputLayout;
        this.m = context.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
        this.a = i1.T(context, R.attr.motionDurationShort4, 217);
        this.b = i1.T(context, R.attr.motionDurationMedium4, 167);
        this.c = i1.T(context, R.attr.motionDurationShort4, 167);
        this.d = i1.U(context, R.attr.motionEasingEmphasizedDecelerateInterpolator, s7.d);
        LinearInterpolator linearInterpolator = s7.a;
        this.e = i1.U(context, R.attr.motionEasingEmphasizedDecelerateInterpolator, linearInterpolator);
        this.f = i1.U(context, R.attr.motionEasingLinearInterpolator, linearInterpolator);
    }

    public final void a(AppCompatTextView appCompatTextView, int i) {
        if (this.i == null && this.k == null) {
            Context context = this.g;
            LinearLayout linearLayout = new LinearLayout(context);
            this.i = linearLayout;
            linearLayout.setOrientation(0);
            LinearLayout linearLayout2 = this.i;
            TextInputLayout textInputLayout = this.h;
            textInputLayout.addView(linearLayout2, -1, -2);
            this.k = new FrameLayout(context);
            this.i.addView(this.k, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (textInputLayout.getEditText() != null) {
                b();
            }
        }
        if (i == 0 || i == 1) {
            this.k.setVisibility(0);
            this.k.addView(appCompatTextView);
        } else {
            this.i.addView(appCompatTextView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.i.setVisibility(0);
        this.j++;
    }

    public final void b() {
        if (this.i != null) {
            TextInputLayout textInputLayout = this.h;
            if (textInputLayout.getEditText() != null) {
                EditText editText = textInputLayout.getEditText();
                Context context = this.g;
                boolean zO = yb0.o(context);
                LinearLayout linearLayout = this.i;
                WeakHashMap weakHashMap = uf1.a;
                int paddingStart = editText.getPaddingStart();
                if (zO) {
                    paddingStart = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_horizontal);
                }
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_default_padding_top);
                if (zO) {
                    dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_top);
                }
                int paddingEnd = editText.getPaddingEnd();
                if (zO) {
                    paddingEnd = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_horizontal);
                }
                linearLayout.setPaddingRelative(paddingStart, dimensionPixelSize, paddingEnd, 0);
            }
        }
    }

    public final void c() {
        AnimatorSet animatorSet = this.l;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public final void d(ArrayList arrayList, boolean z, AppCompatTextView appCompatTextView, int i, int i2, int i3) {
        if (appCompatTextView == null || !z) {
            return;
        }
        if (i == i3 || i == i2) {
            boolean z2 = i3 == i;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(appCompatTextView, (Property<AppCompatTextView, Float>) View.ALPHA, z2 ? 1.0f : 0.0f);
            int i4 = this.c;
            objectAnimatorOfFloat.setDuration(z2 ? this.b : i4);
            objectAnimatorOfFloat.setInterpolator(z2 ? this.e : this.f);
            if (i == i3 && i2 != 0) {
                objectAnimatorOfFloat.setStartDelay(i4);
            }
            arrayList.add(objectAnimatorOfFloat);
            if (i3 != i || i2 == 0) {
                return;
            }
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(appCompatTextView, (Property<AppCompatTextView, Float>) View.TRANSLATION_Y, -this.m, 0.0f);
            objectAnimatorOfFloat2.setDuration(this.a);
            objectAnimatorOfFloat2.setInterpolator(this.d);
            objectAnimatorOfFloat2.setStartDelay(i4);
            arrayList.add(objectAnimatorOfFloat2);
        }
    }

    public final TextView e(int i) {
        if (i == 1) {
            return this.r;
        }
        if (i != 2) {
            return null;
        }
        return this.y;
    }

    public final void f() {
        this.p = null;
        c();
        if (this.n == 1) {
            if (!this.x || TextUtils.isEmpty(this.w)) {
                this.o = 0;
            } else {
                this.o = 2;
            }
        }
        i(this.n, this.o, h(this.r, ""));
    }

    public final void g(AppCompatTextView appCompatTextView, int i) {
        FrameLayout frameLayout;
        LinearLayout linearLayout = this.i;
        if (linearLayout == null) {
            return;
        }
        if ((i == 0 || i == 1) && (frameLayout = this.k) != null) {
            frameLayout.removeView(appCompatTextView);
        } else {
            linearLayout.removeView(appCompatTextView);
        }
        int i2 = this.j - 1;
        this.j = i2;
        LinearLayout linearLayout2 = this.i;
        if (i2 == 0) {
            linearLayout2.setVisibility(8);
        }
    }

    public final boolean h(AppCompatTextView appCompatTextView, CharSequence charSequence) {
        WeakHashMap weakHashMap = uf1.a;
        TextInputLayout textInputLayout = this.h;
        if (textInputLayout.isLaidOut() && textInputLayout.isEnabled()) {
            return (this.o == this.n && appCompatTextView != null && TextUtils.equals(appCompatTextView.getText(), charSequence)) ? false : true;
        }
        return false;
    }

    public final void i(int i, int i2, boolean z) {
        TextView textViewE;
        TextView textViewE2;
        if (i == i2) {
            return;
        }
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.l = animatorSet;
            ArrayList arrayList = new ArrayList();
            d(arrayList, this.x, this.y, 2, i, i2);
            d(arrayList, this.q, this.r, 1, i, i2);
            xr.E(animatorSet, arrayList);
            animatorSet.addListener(new bb0(this, i2, e(i), i, e(i2)));
            animatorSet.start();
        } else if (i != i2) {
            if (i2 != 0 && (textViewE2 = e(i2)) != null) {
                textViewE2.setVisibility(0);
                textViewE2.setAlpha(1.0f);
            }
            if (i != 0 && (textViewE = e(i)) != null) {
                textViewE.setVisibility(4);
                if (i == 1) {
                    textViewE.setText((CharSequence) null);
                }
            }
            this.n = i2;
        }
        TextInputLayout textInputLayout = this.h;
        textInputLayout.r();
        textInputLayout.u(z, false);
        textInputLayout.x();
    }
}
