package defpackage;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.ActivityManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextSwitcher;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heinrichreimersoftware.materialintro.view.FadeableViewPager;
import com.quickcursor.R;
import com.quickcursor.android.activities.AccessibilityStoppedActivity;
import com.quickcursor.android.activities.materialintro.FixedInkPageIndicator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class es0 extends hc0 {
    public static final AccelerateDecelerateInterpolator n0 = new AccelerateDecelerateInterpolator();
    public ConstraintLayout T;
    public FadeableViewPager U;
    public FixedInkPageIndicator V;
    public TextSwitcher W;
    public ImageButton X;
    public ImageButton Y;
    public e11 a0;
    public Interpolator l0;
    public long m0;
    public boolean R = false;
    public boolean S = false;
    public final ArgbEvaluator Z = new ArgbEvaluator();
    public final gc0 b0 = new gc0(this, 1);
    public int c0 = 0;
    public float d0 = 0.0f;
    public boolean e0 = false;
    public boolean f0 = false;
    public final int g0 = 2;
    public int h0 = 2;
    public int i0 = 1;
    public AccessibilityStoppedActivity j0 = null;
    public final ArrayList k0 = new ArrayList();

    public es0() {
        new Handler();
    }

    @Override // defpackage.hc0
    public final int E(int i) {
        return ((d11) this.a0.g.get(i)).a();
    }

    @Override // defpackage.hc0
    public final int F(int i) {
        return ((d11) this.a0.g.get(i)).d();
    }

    @Override // defpackage.hc0
    public final int H() {
        e11 e11Var = this.a0;
        if (e11Var == null) {
            return 0;
        }
        return e11Var.g.size();
    }

    @Override // defpackage.hc0
    public final d11 I(int i) {
        return (d11) this.a0.g.get(i);
    }

    @Override // defpackage.hc0
    public boolean J(int i) {
        int i2;
        boolean z;
        int currentItem = this.U.getCurrentItem();
        if (currentItem >= this.a0.g.size()) {
            U();
        }
        int i3 = 0;
        int iMax = Math.max(0, Math.min(i, H()));
        if (iMax > currentItem) {
            i2 = currentItem;
            while (i2 < iMax && S(i2, true)) {
                i2++;
            }
        } else {
            if (iMax >= currentItem) {
                return true;
            }
            i2 = currentItem;
            while (i2 > iMax && R(i2, true)) {
                i2--;
            }
        }
        if (i2 != iMax) {
            if (iMax > currentItem) {
                this.Y.startAnimation(AnimationUtils.loadAnimation((AccessibilityStoppedActivity) this, R.anim.mi_shake));
            } else if (iMax < currentItem) {
                this.X.startAnimation(AnimationUtils.loadAnimation((AccessibilityStoppedActivity) this, R.anim.mi_shake));
            }
            z = true;
        } else {
            z = false;
        }
        try {
            if (!this.U.N) {
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(r0.getCurrentItem(), i2);
                valueAnimatorOfFloat.addListener(new ds0((AccessibilityStoppedActivity) this, i2, i3));
                valueAnimatorOfFloat.addUpdateListener(new wg(5, (AccessibilityStoppedActivity) this));
                int iAbs = Math.abs(i2 - this.U.getCurrentItem());
                valueAnimatorOfFloat.setInterpolator(this.l0);
                double d = iAbs;
                valueAnimatorOfFloat.setDuration(Math.round(((Math.sqrt(d) + d) * this.m0) / 2.0d));
                valueAnimatorOfFloat.start();
            }
        } catch (Exception unused) {
            T();
        }
        return !z;
    }

    @Override // defpackage.hc0
    public final void K() {
        if (this.c0 < H()) {
            this.U.setSwipeLeftEnabled(S(this.c0, false));
            this.U.setSwipeRightEnabled(R(this.c0, false));
        }
    }

    public final void Q(d11 d11Var) {
        boolean zAdd;
        e11 e11Var = this.a0;
        ArrayList arrayList = e11Var.g;
        if (arrayList.contains(d11Var)) {
            zAdd = false;
        } else {
            zAdd = arrayList.add(d11Var);
            if (zAdd) {
                e11Var.i();
            }
        }
        if (zAdd) {
            try {
                if (this.R) {
                    int i = this.c0;
                    this.U.setAdapter(this.a0);
                    this.U.setCurrentItem(i);
                    if (U()) {
                        return;
                    }
                    e0();
                    Y();
                    b0();
                    d0();
                    K();
                }
            } catch (IllegalStateException unused) {
                yb0.y(R.string.general_error_toast, 0);
            }
        }
    }

    public final boolean R(int i, boolean z) {
        if (i <= 0) {
            return false;
        }
        if (i >= H()) {
            return true;
        }
        boolean zH = I(i).h();
        if (!zH && z) {
            Iterator it = this.k0.iterator();
            if (it.hasNext()) {
                throw l11.h(it);
            }
        }
        return zH;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean S(int r5, boolean r6) {
        /*
            r4 = this;
            int r0 = r4.H()
            r1 = 0
            if (r5 < r0) goto L8
            goto L17
        L8:
            r0 = 1
            if (r5 >= 0) goto Lc
            return r0
        Lc:
            int r2 = r4.g0
            if (r2 != r0) goto L18
            int r2 = r4.H()
            int r2 = r2 - r0
            if (r5 < r2) goto L18
        L17:
            return r1
        L18:
            com.quickcursor.android.activities.AccessibilityStoppedActivity r2 = r4.j0
            if (r2 == 0) goto L2e
            int r3 = r2.q0
            if (r5 != r3) goto L25
            boolean r2 = com.quickcursor.android.services.CursorAccessibilityService.g()
            goto L2c
        L25:
            int r2 = r2.r0
            if (r5 != r2) goto L2b
            r2 = r1
            goto L2c
        L2b:
            r2 = r0
        L2c:
            if (r2 == 0) goto L39
        L2e:
            d11 r5 = r4.I(r5)
            boolean r5 = r5.e()
            if (r5 == 0) goto L39
            r1 = r0
        L39:
            if (r1 != 0) goto L4f
            if (r6 == 0) goto L4f
            java.util.ArrayList r4 = r4.k0
            java.util.Iterator r4 = r4.iterator()
            boolean r5 = r4.hasNext()
            if (r5 != 0) goto L4a
            goto L4f
        L4a:
            java.lang.ClassCastException r4 = defpackage.l11.h(r4)
            throw r4
        L4f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.es0.S(int, boolean):boolean");
    }

    public final void T() {
        if (!this.S) {
            this.S = true;
            yb0.y(R.string.tutorial_possible_error, 1);
        }
        try {
            this.U.d();
            this.U.j();
        } catch (Exception unused) {
        }
    }

    public final boolean U() {
        if (this.d0 != 0.0f || this.c0 != this.a0.g.size()) {
            return false;
        }
        setResult(-1);
        finish();
        overridePendingTransition(0, 0);
        return true;
    }

    public final cp0 V(int i) {
        if (i < H() && (I(i) instanceof sh)) {
            sh shVar = (sh) I(i);
            if (shVar.i() != null && (shVar.f() != null || shVar.c() != 0)) {
                return shVar.f() != null ? new cp0(shVar.f(), shVar.i()) : new cp0(getString(shVar.c()), shVar.i());
            }
        }
        if (!this.f0) {
            return null;
        }
        int i2 = 5;
        return !TextUtils.isEmpty(null) ? new cp0(null, new l1(i2, this)) : new cp0(getString(R.string.mi_label_button_cta), new l1(i2, this));
    }

    public final void W() {
        J(this.U.getCurrentItem() + 1);
    }

    public final void X(int i) {
        this.h0 = i;
        if (i == 1) {
            this.X.setOnLongClickListener(new uj(R.string.mi_content_description_back));
        } else if (i == 2) {
            this.X.setOnLongClickListener(new uj(R.string.mi_content_description_skip));
        }
        Y();
        Z();
    }

    public final void Y() {
        int i = this.h0;
        ImageButton imageButton = this.X;
        if (i == 2) {
            imageButton.setImageResource(R.drawable.mi_ic_skip);
        } else {
            imageButton.setImageResource(R.drawable.mi_ic_previous);
        }
    }

    public final void Z() {
        float f = this.c0 + this.d0;
        float dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.mi_y_offset);
        if (f < 1.0f && this.h0 == 1) {
            this.X.setTranslationY((1.0f - this.d0) * dimensionPixelSize);
            return;
        }
        if (f < this.a0.g.size() - 2) {
            this.X.setTranslationY(0.0f);
            this.X.setTranslationX(0.0f);
            return;
        }
        float size = this.a0.g.size() - 1;
        int i = this.h0;
        if (f < size) {
            if (i == 2) {
                this.X.setTranslationX(this.d0 * (getResources().getConfiguration().getLayoutDirection() == 1 ? 1 : -1) * this.U.getWidth());
                return;
            } else {
                this.X.setTranslationX(0.0f);
                return;
            }
        }
        if (i != 2) {
            this.X.setTranslationY(this.d0 * dimensionPixelSize);
        } else {
            this.X.setTranslationX(this.U.getWidth() * (getResources().getConfiguration().getLayoutDirection() == 1 ? 1 : -1));
        }
    }

    public final void a0() {
        float f = this.c0 + this.d0;
        float dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.mi_y_offset);
        if (f < this.a0.g.size()) {
            cp0 cp0VarV = V(this.c0);
            cp0 cp0VarV2 = this.d0 == 0.0f ? null : V(this.c0 + 1);
            AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = n0;
            if (cp0VarV == null) {
                TextSwitcher textSwitcher = this.W;
                if (cp0VarV2 == null) {
                    textSwitcher.setVisibility(8);
                } else {
                    Object obj = cp0VarV2.b;
                    Object obj2 = cp0VarV2.a;
                    textSwitcher.setVisibility(0);
                    if (!((Button) this.W.getCurrentView()).getText().equals(obj2)) {
                        this.W.setText((CharSequence) obj2);
                    }
                    View.OnClickListener onClickListener = (View.OnClickListener) obj;
                    this.W.getChildAt(0).setOnClickListener(onClickListener);
                    this.W.getChildAt(1).setOnClickListener(onClickListener);
                    this.W.setAlpha(this.d0);
                    this.W.setScaleX(this.d0);
                    this.W.setScaleY(this.d0);
                    ViewGroup.LayoutParams layoutParams = this.W.getLayoutParams();
                    layoutParams.height = Math.round(accelerateDecelerateInterpolator.getInterpolation(this.d0) * getResources().getDimensionPixelSize(R.dimen.mi_button_cta_height));
                    this.W.setLayoutParams(layoutParams);
                }
            } else {
                Object obj3 = cp0VarV.b;
                Object obj4 = cp0VarV.a;
                TextSwitcher textSwitcher2 = this.W;
                if (cp0VarV2 == null) {
                    textSwitcher2.setVisibility(0);
                    if (!((Button) this.W.getCurrentView()).getText().equals(obj4)) {
                        this.W.setText((CharSequence) obj4);
                    }
                    View.OnClickListener onClickListener2 = (View.OnClickListener) obj3;
                    this.W.getChildAt(0).setOnClickListener(onClickListener2);
                    this.W.getChildAt(1).setOnClickListener(onClickListener2);
                    this.W.setAlpha(1.0f - this.d0);
                    this.W.setScaleX(1.0f - this.d0);
                    this.W.setScaleY(1.0f - this.d0);
                    ViewGroup.LayoutParams layoutParams2 = this.W.getLayoutParams();
                    layoutParams2.height = Math.round(accelerateDecelerateInterpolator.getInterpolation(1.0f - this.d0) * getResources().getDimensionPixelSize(R.dimen.mi_button_cta_height));
                    this.W.setLayoutParams(layoutParams2);
                } else {
                    Object obj5 = cp0VarV2.b;
                    Object obj6 = cp0VarV2.a;
                    textSwitcher2.setVisibility(0);
                    ViewGroup.LayoutParams layoutParams3 = this.W.getLayoutParams();
                    layoutParams3.height = getResources().getDimensionPixelSize(R.dimen.mi_button_cta_height);
                    this.W.setLayoutParams(layoutParams3);
                    float f2 = this.d0;
                    TextSwitcher textSwitcher3 = this.W;
                    if (f2 >= 0.5f) {
                        if (!((Button) textSwitcher3.getCurrentView()).getText().equals(obj6)) {
                            this.W.setText((CharSequence) obj6);
                        }
                        View.OnClickListener onClickListener3 = (View.OnClickListener) obj5;
                        this.W.getChildAt(0).setOnClickListener(onClickListener3);
                        this.W.getChildAt(1).setOnClickListener(onClickListener3);
                    } else {
                        if (!((Button) textSwitcher3.getCurrentView()).getText().equals(obj4)) {
                            this.W.setText((CharSequence) obj4);
                        }
                        View.OnClickListener onClickListener4 = (View.OnClickListener) obj3;
                        this.W.getChildAt(0).setOnClickListener(onClickListener4);
                        this.W.getChildAt(1).setOnClickListener(onClickListener4);
                    }
                }
            }
        }
        float size = this.a0.g.size() - 1;
        TextSwitcher textSwitcher4 = this.W;
        if (f < size) {
            textSwitcher4.setTranslationY(0.0f);
        } else {
            textSwitcher4.setTranslationY(this.d0 * dimensionPixelSize);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b0() {
        /*
            r7 = this;
            int r0 = r7.c0
            float r0 = (float) r0
            float r1 = r7.d0
            float r0 = r0 + r1
            r1 = 1065353216(0x3f800000, float:1.0)
            r2 = 1
            r3 = 0
            int r4 = r7.g0
            r5 = 2
            if (r4 != r5) goto L30
            e11 r4 = r7.a0
            java.util.ArrayList r4 = r4.g
            int r4 = r4.size()
            int r4 = r4 - r2
            float r4 = (float) r4
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 < 0) goto L1f
            r0 = r1
            goto L31
        L1f:
            e11 r4 = r7.a0
            java.util.ArrayList r4 = r4.g
            int r4 = r4.size()
            int r4 = r4 - r5
            float r4 = (float) r4
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 < 0) goto L30
            float r0 = r7.d0
            goto L31
        L30:
            r0 = r3
        L31:
            int r4 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            android.widget.ImageButton r5 = r7.Y
            r6 = 2131231159(0x7f0801b7, float:1.8078391E38)
            if (r4 > 0) goto L49
            r5.setImageResource(r6)
            android.widget.ImageButton r7 = r7.Y
            android.graphics.drawable.Drawable r7 = r7.getDrawable()
            r0 = 255(0xff, float:3.57E-43)
            r7.setAlpha(r0)
            return
        L49:
            r4 = 2131231160(0x7f0801b8, float:1.8078393E38)
            r5.setImageResource(r4)
            android.widget.ImageButton r4 = r7.Y
            android.graphics.drawable.Drawable r4 = r4.getDrawable()
            if (r4 == 0) goto L80
            android.widget.ImageButton r4 = r7.Y
            android.graphics.drawable.Drawable r4 = r4.getDrawable()
            boolean r4 = r4 instanceof android.graphics.drawable.LayerDrawable
            if (r4 == 0) goto L80
            android.widget.ImageButton r7 = r7.Y
            android.graphics.drawable.Drawable r7 = r7.getDrawable()
            android.graphics.drawable.LayerDrawable r7 = (android.graphics.drawable.LayerDrawable) r7
            r3 = 0
            android.graphics.drawable.Drawable r3 = r7.getDrawable(r3)
            float r1 = r1 - r0
            r4 = 1132396544(0x437f0000, float:255.0)
            float r1 = r1 * r4
            int r1 = (int) r1
            r3.setAlpha(r1)
            android.graphics.drawable.Drawable r7 = r7.getDrawable(r2)
            float r0 = r0 * r4
            int r0 = (int) r0
            r7.setAlpha(r0)
            return
        L80:
            android.widget.ImageButton r7 = r7.Y
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L89
            r6 = 2131231158(0x7f0801b6, float:1.807839E38)
        L89:
            r7.setImageResource(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.es0.b0():void");
    }

    public final void c0() {
        if (this.a0 != null && this.c0 + this.d0 > r0.g.size() - 1) {
            getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() & (-4101));
            return;
        }
        boolean z = this.e0;
        int systemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
        getWindow().getDecorView().setSystemUiVisibility(z ? systemUiVisibility | 4100 : systemUiVisibility & (-4101));
    }

    public final void d0() {
        int iF;
        int iF2;
        int color;
        int color2;
        if (this.c0 == H()) {
            iF = 0;
            iF2 = 0;
            color2 = 0;
            color = 0;
        } else {
            int color3 = getColor(E(this.c0));
            int color4 = getColor(E(Math.min(this.c0 + 1, H() - 1)));
            iF = wl.f(color3, 255);
            iF2 = wl.f(color4, 255);
            try {
                color = getColor(F(this.c0));
            } catch (Resources.NotFoundException unused) {
                color = getColor(R.color.mi_status_bar_background);
            }
            try {
                color2 = getColor(F(Math.min(this.c0 + 1, H() - 1)));
            } catch (Resources.NotFoundException unused2) {
                color2 = getColor(R.color.mi_status_bar_background);
            }
        }
        if (this.c0 + this.d0 >= this.a0.g.size() - 1) {
            iF2 = wl.f(iF, 0);
            color2 = wl.f(color, 0);
        }
        float f = this.d0;
        Integer numValueOf = Integer.valueOf(iF);
        Integer numValueOf2 = Integer.valueOf(iF2);
        ArgbEvaluator argbEvaluator = this.Z;
        int iIntValue = ((Integer) argbEvaluator.evaluate(f, numValueOf, numValueOf2)).intValue();
        int iIntValue2 = ((Integer) argbEvaluator.evaluate(this.d0, Integer.valueOf(color), Integer.valueOf(color2))).intValue();
        this.T.setBackgroundColor(iIntValue);
        float[] fArr = new float[3];
        Color.colorToHSV(iIntValue2, fArr);
        fArr[2] = (float) (((double) fArr[2]) * 0.95d);
        int iHSVToColor = Color.HSVToColor(fArr);
        this.V.setPageIndicatorColor(iHSVToColor);
        ImageButton imageButton = this.Y;
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(iHSVToColor);
        WeakHashMap weakHashMap = uf1.a;
        lf1.i(imageButton, colorStateListValueOf);
        lf1.i(this.X, ColorStateList.valueOf(iHSVToColor));
        int color5 = this.i0 == 2 ? getColor(android.R.color.white) : iHSVToColor;
        lf1.i(this.W.getChildAt(0), ColorStateList.valueOf(color5));
        lf1.i(this.W.getChildAt(1), ColorStateList.valueOf(color5));
        int color6 = wl.c(iIntValue2) > 0.4d ? getColor(R.color.mi_icon_color_light) : getColor(R.color.mi_icon_color_dark);
        this.V.setCurrentPageIndicatorColor(color6);
        this.Y.getDrawable().setTint(color6);
        this.X.getDrawable().setTint(color6);
        if (this.i0 != 2) {
            iHSVToColor = color6;
        }
        ((Button) this.W.getChildAt(0)).setTextColor(iHSVToColor);
        ((Button) this.W.getChildAt(1)).setTextColor(iHSVToColor);
        getWindow().setStatusBarColor(iIntValue2);
        if (this.c0 == this.a0.g.size()) {
            getWindow().setNavigationBarColor(0);
        } else if (this.c0 + this.d0 >= this.a0.g.size() - 1) {
            TypedArray typedArrayObtainStyledAttributes = obtainStyledAttributes(new TypedValue().data, new int[]{android.R.attr.navigationBarColor});
            int color7 = typedArrayObtainStyledAttributes.getColor(0, -16777216);
            typedArrayObtainStyledAttributes.recycle();
            getWindow().setNavigationBarColor(((Integer) argbEvaluator.evaluate(this.d0, Integer.valueOf(color7), 0)).intValue());
        }
        int systemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
        getWindow().getDecorView().setSystemUiVisibility(wl.c(iIntValue2) > 0.4d ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
        a0();
        Z();
        float f2 = this.c0 + this.d0;
        float dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.mi_y_offset);
        if (f2 < this.a0.g.size() - 2) {
            this.Y.setTranslationY(0.0f);
        } else {
            float size = this.a0.g.size() - 1;
            int i = this.g0;
            if (f2 < size) {
                ImageButton imageButton2 = this.Y;
                if (i == 2) {
                    imageButton2.setTranslationY(0.0f);
                } else {
                    imageButton2.setTranslationY(this.d0 * dimensionPixelSize);
                }
            } else if (f2 >= this.a0.g.size() - 1) {
                ImageButton imageButton3 = this.Y;
                if (i == 2) {
                    imageButton3.setTranslationY(this.d0 * dimensionPixelSize);
                } else {
                    imageButton3.setTranslationY(-dimensionPixelSize);
                }
            }
        }
        float f3 = this.c0 + this.d0;
        float dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.mi_y_offset);
        float size2 = this.a0.g.size() - 1;
        FixedInkPageIndicator fixedInkPageIndicator = this.V;
        if (f3 < size2) {
            fixedInkPageIndicator.setTranslationY(0.0f);
        } else {
            fixedInkPageIndicator.setTranslationY(this.d0 * dimensionPixelSize2);
        }
        if (this.c0 != H()) {
            gg0 gg0VarB = I(this.c0).b();
            gg0 gg0VarB2 = this.c0 < H() - 1 ? I(this.c0 + 1).b() : null;
            if (gg0VarB instanceof hp0) {
                ((hp0) gg0VarB).d(this.d0);
            }
            if (gg0VarB2 instanceof hp0) {
                ((hp0) gg0VarB2).d(this.d0 - 1.0f);
            }
        }
        c0();
        float f4 = this.c0 + this.d0;
        float size3 = this.a0.g.size() - 1;
        ConstraintLayout constraintLayout = this.T;
        if (f4 < size3) {
            constraintLayout.setAlpha(1.0f);
        } else {
            constraintLayout.setAlpha(1.0f - (this.d0 * 0.5f));
        }
    }

    public final void e0() {
        int color;
        String string = getTitle().toString();
        Drawable drawableLoadIcon = getApplicationInfo().loadIcon(getPackageManager());
        Bitmap bitmap = drawableLoadIcon instanceof BitmapDrawable ? ((BitmapDrawable) drawableLoadIcon).getBitmap() : null;
        if (this.c0 < H()) {
            try {
                color = getColor(F(this.c0));
            } catch (Resources.NotFoundException unused) {
                color = getColor(E(this.c0));
            }
        } else {
            TypedArray typedArrayObtainStyledAttributes = obtainStyledAttributes(new TypedValue().data, new int[]{R.attr.colorPrimary});
            int color2 = typedArrayObtainStyledAttributes.getColor(0, 0);
            typedArrayObtainStyledAttributes.recycle();
            color = color2;
        }
        setTaskDescription(new ActivityManager.TaskDescription(string, bitmap, wl.f(color, 255)));
    }

    @Override // defpackage.hc0, defpackage.pm, android.app.Activity
    public final void onBackPressed() {
        if (this.c0 > 0) {
            J(this.U.getCurrentItem() - 1);
        } else {
            setResult(0);
            super.onBackPressed();
        }
    }

    @Override // defpackage.hc0, defpackage.z7, defpackage.pm, defpackage.om, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.l0 = AnimationUtils.loadInterpolator(this, android.R.interpolator.accelerate_decelerate);
        this.m0 = getResources().getInteger(android.R.integer.config_shortAnimTime);
        if (bundle != null) {
            if (bundle.containsKey("com.heinrichreimersoftware.materialintro.app.QCIntroActivity.KEY_CURRENT_ITEM")) {
                this.c0 = bundle.getInt("com.heinrichreimersoftware.materialintro.app.QCIntroActivity.KEY_CURRENT_ITEM", this.c0);
            }
            if (bundle.containsKey("com.heinrichreimersoftware.materialintro.app.QCIntroActivity.KEY_FULLSCREEN")) {
                this.e0 = bundle.getBoolean("com.heinrichreimersoftware.materialintro.app.QCIntroActivity.KEY_FULLSCREEN", this.e0);
            }
            if (bundle.containsKey("com.heinrichreimersoftware.materialintro.app.QCIntroActivity.KEY_BUTTON_CTA_VISIBLE")) {
                this.f0 = bundle.getBoolean("com.heinrichreimersoftware.materialintro.app.QCIntroActivity.KEY_BUTTON_CTA_VISIBLE", this.f0);
            }
        }
        if (this.e0) {
            getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | 1280);
            c0();
        }
        getWindow().setSoftInputMode(16);
        setContentView(R.layout.qc_activity_intro);
        this.T = (ConstraintLayout) findViewById(R.id.mi_frame);
        this.U = (FadeableViewPager) findViewById(R.id.mi_pager);
        this.V = (FixedInkPageIndicator) findViewById(R.id.mi_pager_indicator);
        this.W = (TextSwitcher) findViewById(R.id.mi_button_cta);
        this.X = (ImageButton) findViewById(R.id.mi_button_back);
        this.Y = (ImageButton) findViewById(R.id.mi_button_next);
        TextSwitcher textSwitcher = this.W;
        if (textSwitcher != null) {
            textSwitcher.setInAnimation(this, R.anim.mi_fade_in);
            this.W.setOutAnimation(this, R.anim.mi_fade_out);
        }
        e11 e11Var = new e11(w());
        this.a0 = e11Var;
        this.U.setAdapter(e11Var);
        this.U.b(this.b0);
        this.U.z(this.c0, false);
        this.V.setViewPager(this.U);
        ImageButton imageButton = this.Y;
        if (imageButton != null) {
            imageButton.setOnClickListener(new cs0(this, 1));
        }
        ImageButton imageButton2 = this.X;
        if (imageButton2 != null) {
            imageButton2.setOnClickListener(new cs0(this, 0));
        }
        this.Y.setOnLongClickListener(new tj());
        this.X.setOnLongClickListener(new tj());
    }

    @Override // defpackage.z7, android.app.Activity
    public final void onDestroy() {
        this.R = false;
        super.onDestroy();
    }

    @Override // defpackage.hc0, defpackage.z7, android.app.Activity
    public final void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.R = true;
        e0();
        b0();
        Y();
        d0();
        this.T.addOnLayoutChangeListener(new ug(2, this));
    }

    @Override // defpackage.hc0, defpackage.z7, defpackage.pm, android.app.Activity
    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        a0();
    }

    @Override // defpackage.hc0, defpackage.z7, android.app.Activity
    public void onResume() {
        super.onResume();
        c0();
    }

    @Override // defpackage.hc0, defpackage.pm, defpackage.om, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("com.heinrichreimersoftware.materialintro.app.QCIntroActivity.KEY_CURRENT_ITEM", this.U.getCurrentItem());
        bundle.putBoolean("com.heinrichreimersoftware.materialintro.app.QCIntroActivity.KEY_FULLSCREEN", this.e0);
        bundle.putBoolean("com.heinrichreimersoftware.materialintro.app.QCIntroActivity.KEY_BUTTON_CTA_VISIBLE", this.f0);
    }

    @Override // android.app.Activity
    public final void onUserInteraction() {
    }
}
