package defpackage;

import android.animation.ArgbEvaluator;
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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextSwitcher;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heinrichreimersoftware.materialintro.view.FadeableViewPager;
import com.heinrichreimersoftware.materialintro.view.InkPageIndicator;
import com.quickcursor.R;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class hc0 extends z7 {
    public static final AccelerateDecelerateInterpolator Q = new AccelerateDecelerateInterpolator();
    public ConstraintLayout A;
    public FadeableViewPager B;
    public InkPageIndicator C;
    public TextSwitcher D;
    public ImageButton E;
    public ImageButton F;
    public e11 H;
    public final ArgbEvaluator G = new ArgbEvaluator();
    public final gc0 I = new gc0(this, 0);
    public int J = 0;
    public float K = 0.0f;
    public boolean L = false;
    public boolean M = false;
    public final int N = 2;
    public final int O = 2;
    public final int P = 1;

    public hc0() {
        new ArrayList();
        new Handler();
    }

    public abstract int E(int i);

    public abstract int F(int i);

    public final cp0 G(int i) {
        if (i < H() && (I(i) instanceof sh)) {
            sh shVar = (sh) I(i);
            if (shVar.i() != null && (shVar.f() != null || shVar.c() != 0)) {
                return shVar.f() != null ? new cp0(shVar.f(), shVar.i()) : new cp0(getString(shVar.c()), shVar.i());
            }
        }
        if (!this.M) {
            return null;
        }
        int i2 = 2;
        return !TextUtils.isEmpty(null) ? new cp0(null, new l1(i2, this)) : new cp0(getString(R.string.mi_label_button_cta), new l1(i2, this));
    }

    public abstract int H();

    public abstract d11 I(int i);

    public abstract boolean J(int i);

    public abstract void K();

    public final void L() {
        float f = this.J + this.K;
        float dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.mi_y_offset);
        if (f < this.H.g.size()) {
            cp0 cp0VarG = G(this.J);
            cp0 cp0VarG2 = this.K == 0.0f ? null : G(this.J + 1);
            AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = Q;
            if (cp0VarG == null) {
                TextSwitcher textSwitcher = this.D;
                if (cp0VarG2 == null) {
                    textSwitcher.setVisibility(8);
                } else {
                    Object obj = cp0VarG2.b;
                    Object obj2 = cp0VarG2.a;
                    textSwitcher.setVisibility(0);
                    if (!((Button) this.D.getCurrentView()).getText().equals(obj2)) {
                        this.D.setText((CharSequence) obj2);
                    }
                    View.OnClickListener onClickListener = (View.OnClickListener) obj;
                    this.D.getChildAt(0).setOnClickListener(onClickListener);
                    this.D.getChildAt(1).setOnClickListener(onClickListener);
                    this.D.setAlpha(this.K);
                    this.D.setScaleX(this.K);
                    this.D.setScaleY(this.K);
                    ViewGroup.LayoutParams layoutParams = this.D.getLayoutParams();
                    layoutParams.height = Math.round(accelerateDecelerateInterpolator.getInterpolation(this.K) * getResources().getDimensionPixelSize(R.dimen.mi_button_cta_height));
                    this.D.setLayoutParams(layoutParams);
                }
            } else {
                Object obj3 = cp0VarG.b;
                Object obj4 = cp0VarG.a;
                TextSwitcher textSwitcher2 = this.D;
                if (cp0VarG2 == null) {
                    textSwitcher2.setVisibility(0);
                    if (!((Button) this.D.getCurrentView()).getText().equals(obj4)) {
                        this.D.setText((CharSequence) obj4);
                    }
                    View.OnClickListener onClickListener2 = (View.OnClickListener) obj3;
                    this.D.getChildAt(0).setOnClickListener(onClickListener2);
                    this.D.getChildAt(1).setOnClickListener(onClickListener2);
                    this.D.setAlpha(1.0f - this.K);
                    this.D.setScaleX(1.0f - this.K);
                    this.D.setScaleY(1.0f - this.K);
                    ViewGroup.LayoutParams layoutParams2 = this.D.getLayoutParams();
                    layoutParams2.height = Math.round(accelerateDecelerateInterpolator.getInterpolation(1.0f - this.K) * getResources().getDimensionPixelSize(R.dimen.mi_button_cta_height));
                    this.D.setLayoutParams(layoutParams2);
                } else {
                    Object obj5 = cp0VarG2.b;
                    Object obj6 = cp0VarG2.a;
                    textSwitcher2.setVisibility(0);
                    ViewGroup.LayoutParams layoutParams3 = this.D.getLayoutParams();
                    layoutParams3.height = getResources().getDimensionPixelSize(R.dimen.mi_button_cta_height);
                    this.D.setLayoutParams(layoutParams3);
                    float f2 = this.K;
                    TextSwitcher textSwitcher3 = this.D;
                    if (f2 >= 0.5f) {
                        if (!((Button) textSwitcher3.getCurrentView()).getText().equals(obj6)) {
                            this.D.setText((CharSequence) obj6);
                        }
                        View.OnClickListener onClickListener3 = (View.OnClickListener) obj5;
                        this.D.getChildAt(0).setOnClickListener(onClickListener3);
                        this.D.getChildAt(1).setOnClickListener(onClickListener3);
                    } else {
                        if (!((Button) textSwitcher3.getCurrentView()).getText().equals(obj4)) {
                            this.D.setText((CharSequence) obj4);
                        }
                        View.OnClickListener onClickListener4 = (View.OnClickListener) obj3;
                        this.D.getChildAt(0).setOnClickListener(onClickListener4);
                        this.D.getChildAt(1).setOnClickListener(onClickListener4);
                    }
                }
            }
        }
        float size = this.H.g.size() - 1;
        TextSwitcher textSwitcher4 = this.D;
        if (f < size) {
            textSwitcher4.setTranslationY(0.0f);
        } else {
            textSwitcher4.setTranslationY(this.K * dimensionPixelSize);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void M() {
        /*
            r7 = this;
            int r0 = r7.J
            float r0 = (float) r0
            float r1 = r7.K
            float r0 = r0 + r1
            r1 = 1065353216(0x3f800000, float:1.0)
            r2 = 1
            r3 = 0
            int r4 = r7.N
            r5 = 2
            if (r4 != r5) goto L30
            e11 r4 = r7.H
            java.util.ArrayList r4 = r4.g
            int r4 = r4.size()
            int r4 = r4 - r2
            float r4 = (float) r4
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 < 0) goto L1f
            r0 = r1
            goto L31
        L1f:
            e11 r4 = r7.H
            java.util.ArrayList r4 = r4.g
            int r4 = r4.size()
            int r4 = r4 - r5
            float r4 = (float) r4
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 < 0) goto L30
            float r0 = r7.K
            goto L31
        L30:
            r0 = r3
        L31:
            int r4 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            android.widget.ImageButton r5 = r7.F
            r6 = 2131231159(0x7f0801b7, float:1.8078391E38)
            if (r4 > 0) goto L49
            r5.setImageResource(r6)
            android.widget.ImageButton r7 = r7.F
            android.graphics.drawable.Drawable r7 = r7.getDrawable()
            r0 = 255(0xff, float:3.57E-43)
            r7.setAlpha(r0)
            return
        L49:
            r4 = 2131231160(0x7f0801b8, float:1.8078393E38)
            r5.setImageResource(r4)
            android.widget.ImageButton r4 = r7.F
            android.graphics.drawable.Drawable r4 = r4.getDrawable()
            if (r4 == 0) goto L80
            android.widget.ImageButton r4 = r7.F
            android.graphics.drawable.Drawable r4 = r4.getDrawable()
            boolean r4 = r4 instanceof android.graphics.drawable.LayerDrawable
            if (r4 == 0) goto L80
            android.widget.ImageButton r7 = r7.F
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
            android.widget.ImageButton r7 = r7.F
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L89
            r6 = 2131231158(0x7f0801b6, float:1.807839E38)
        L89:
            r7.setImageResource(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hc0.M():void");
    }

    public final void N() {
        if (this.H != null && this.J + this.K > r0.g.size() - 1) {
            getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() & (-4101));
            return;
        }
        boolean z = this.L;
        int systemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
        getWindow().getDecorView().setSystemUiVisibility(z ? systemUiVisibility | 4100 : systemUiVisibility & (-4101));
    }

    public final void O() {
        int iF;
        int iF2;
        int color;
        int color2;
        if (this.J == H()) {
            iF = 0;
            iF2 = 0;
            color2 = 0;
            color = 0;
        } else {
            int color3 = getColor(E(this.J));
            int color4 = getColor(E(Math.min(this.J + 1, H() - 1)));
            iF = wl.f(color3, 255);
            iF2 = wl.f(color4, 255);
            try {
                color = getColor(F(this.J));
            } catch (Resources.NotFoundException unused) {
                color = getColor(R.color.mi_status_bar_background);
            }
            try {
                color2 = getColor(F(Math.min(this.J + 1, H() - 1)));
            } catch (Resources.NotFoundException unused2) {
                color2 = getColor(R.color.mi_status_bar_background);
            }
        }
        if (this.J + this.K >= this.H.g.size() - 1) {
            iF2 = wl.f(iF, 0);
            color2 = wl.f(color, 0);
        }
        float f = this.K;
        Integer numValueOf = Integer.valueOf(iF);
        Integer numValueOf2 = Integer.valueOf(iF2);
        ArgbEvaluator argbEvaluator = this.G;
        int iIntValue = ((Integer) argbEvaluator.evaluate(f, numValueOf, numValueOf2)).intValue();
        int iIntValue2 = ((Integer) argbEvaluator.evaluate(this.K, Integer.valueOf(color), Integer.valueOf(color2))).intValue();
        this.A.setBackgroundColor(iIntValue);
        float[] fArr = new float[3];
        Color.colorToHSV(iIntValue2, fArr);
        fArr[2] = (float) (((double) fArr[2]) * 0.95d);
        int iHSVToColor = Color.HSVToColor(fArr);
        this.C.setPageIndicatorColor(iHSVToColor);
        ImageButton imageButton = this.F;
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(iHSVToColor);
        WeakHashMap weakHashMap = uf1.a;
        lf1.i(imageButton, colorStateListValueOf);
        lf1.i(this.E, ColorStateList.valueOf(iHSVToColor));
        int i = this.P;
        int color5 = i == 2 ? getColor(android.R.color.white) : iHSVToColor;
        lf1.i(this.D.getChildAt(0), ColorStateList.valueOf(color5));
        lf1.i(this.D.getChildAt(1), ColorStateList.valueOf(color5));
        int color6 = wl.c(iIntValue2) > 0.4d ? getColor(R.color.mi_icon_color_light) : getColor(R.color.mi_icon_color_dark);
        this.C.setCurrentPageIndicatorColor(color6);
        this.F.getDrawable().setTint(color6);
        this.E.getDrawable().setTint(color6);
        if (i != 2) {
            iHSVToColor = color6;
        }
        ((Button) this.D.getChildAt(0)).setTextColor(iHSVToColor);
        ((Button) this.D.getChildAt(1)).setTextColor(iHSVToColor);
        getWindow().setStatusBarColor(iIntValue2);
        if (this.J == this.H.g.size()) {
            getWindow().setNavigationBarColor(0);
        } else if (this.J + this.K >= this.H.g.size() - 1) {
            TypedArray typedArrayObtainStyledAttributes = obtainStyledAttributes(new TypedValue().data, new int[]{android.R.attr.navigationBarColor});
            int color7 = typedArrayObtainStyledAttributes.getColor(0, -16777216);
            typedArrayObtainStyledAttributes.recycle();
            getWindow().setNavigationBarColor(((Integer) argbEvaluator.evaluate(this.K, Integer.valueOf(color7), 0)).intValue());
        }
        int systemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
        getWindow().getDecorView().setSystemUiVisibility(wl.c(iIntValue2) > 0.4d ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
        L();
        float f2 = this.J + this.K;
        float dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.mi_y_offset);
        int i2 = this.O;
        if (f2 < 1.0f && i2 == 1) {
            this.E.setTranslationY((1.0f - this.K) * dimensionPixelSize);
        } else if (f2 < this.H.g.size() - 2) {
            this.E.setTranslationY(0.0f);
            this.E.setTranslationX(0.0f);
        } else {
            if (f2 < this.H.g.size() - 1) {
                if (i2 == 2) {
                    this.E.setTranslationX(this.K * (getResources().getConfiguration().getLayoutDirection() == 1 ? 1 : -1) * this.B.getWidth());
                } else {
                    this.E.setTranslationX(0.0f);
                }
            } else if (i2 == 2) {
                this.E.setTranslationX(this.B.getWidth() * (getResources().getConfiguration().getLayoutDirection() == 1 ? 1 : -1));
            } else {
                this.E.setTranslationY(this.K * dimensionPixelSize);
            }
        }
        float f3 = this.J + this.K;
        float dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.mi_y_offset);
        if (f3 < this.H.g.size() - 2) {
            this.F.setTranslationY(0.0f);
        } else {
            float size = this.H.g.size() - 1;
            int i3 = this.N;
            if (f3 < size) {
                ImageButton imageButton2 = this.F;
                if (i3 == 2) {
                    imageButton2.setTranslationY(0.0f);
                } else {
                    imageButton2.setTranslationY(this.K * dimensionPixelSize2);
                }
            } else if (f3 >= this.H.g.size() - 1) {
                ImageButton imageButton3 = this.F;
                if (i3 == 2) {
                    imageButton3.setTranslationY(this.K * dimensionPixelSize2);
                } else {
                    imageButton3.setTranslationY(-dimensionPixelSize2);
                }
            }
        }
        float f4 = this.J + this.K;
        float dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.mi_y_offset);
        float size2 = this.H.g.size() - 1;
        InkPageIndicator inkPageIndicator = this.C;
        if (f4 < size2) {
            inkPageIndicator.setTranslationY(0.0f);
        } else {
            inkPageIndicator.setTranslationY(this.K * dimensionPixelSize3);
        }
        if (this.J != H()) {
            gg0 gg0VarB = I(this.J).b();
            gg0 gg0VarB2 = this.J < H() - 1 ? I(this.J + 1).b() : null;
            if (gg0VarB instanceof hp0) {
                ((hp0) gg0VarB).d(this.K);
            }
            if (gg0VarB2 instanceof hp0) {
                ((hp0) gg0VarB2).d(this.K - 1.0f);
            }
        }
        N();
        float f5 = this.J + this.K;
        float size3 = this.H.g.size() - 1;
        ConstraintLayout constraintLayout = this.A;
        if (f5 < size3) {
            constraintLayout.setAlpha(1.0f);
        } else {
            constraintLayout.setAlpha(1.0f - (this.K * 0.5f));
        }
    }

    public final void P() {
        int color;
        String string = getTitle().toString();
        Drawable drawableLoadIcon = getApplicationInfo().loadIcon(getPackageManager());
        Bitmap bitmap = drawableLoadIcon instanceof BitmapDrawable ? ((BitmapDrawable) drawableLoadIcon).getBitmap() : null;
        if (this.J < H()) {
            try {
                color = getColor(F(this.J));
            } catch (Resources.NotFoundException unused) {
                color = getColor(E(this.J));
            }
        } else {
            TypedArray typedArrayObtainStyledAttributes = obtainStyledAttributes(new TypedValue().data, new int[]{R.attr.colorPrimary});
            int color2 = typedArrayObtainStyledAttributes.getColor(0, 0);
            typedArrayObtainStyledAttributes.recycle();
            color = color2;
        }
        setTaskDescription(new ActivityManager.TaskDescription(string, bitmap, wl.f(color, 255)));
    }

    @Override // defpackage.pm, android.app.Activity
    public void onBackPressed() {
        if (this.J > 0) {
            ((es0) this).J(r1.U.getCurrentItem() - 1);
        } else {
            setResult(0);
            super.onBackPressed();
        }
    }

    @Override // defpackage.z7, defpackage.pm, defpackage.om, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AnimationUtils.loadInterpolator(this, android.R.interpolator.accelerate_decelerate);
        getResources().getInteger(android.R.integer.config_shortAnimTime);
        if (bundle != null) {
            if (bundle.containsKey("com.heinrichreimersoftware.materialintro.app.IntroActivity.KEY_CURRENT_ITEM")) {
                this.J = bundle.getInt("com.heinrichreimersoftware.materialintro.app.IntroActivity.KEY_CURRENT_ITEM", this.J);
            }
            if (bundle.containsKey("com.heinrichreimersoftware.materialintro.app.IntroActivity.KEY_FULLSCREEN")) {
                this.L = bundle.getBoolean("com.heinrichreimersoftware.materialintro.app.IntroActivity.KEY_FULLSCREEN", this.L);
            }
            if (bundle.containsKey("com.heinrichreimersoftware.materialintro.app.IntroActivity.KEY_BUTTON_CTA_VISIBLE")) {
                this.M = bundle.getBoolean("com.heinrichreimersoftware.materialintro.app.IntroActivity.KEY_BUTTON_CTA_VISIBLE", this.M);
            }
        }
        if (this.L) {
            getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | 1280);
            N();
        }
        getWindow().setSoftInputMode(16);
        setContentView(R.layout.mi_activity_intro);
        this.A = (ConstraintLayout) findViewById(R.id.mi_frame);
        this.B = (FadeableViewPager) findViewById(R.id.mi_pager);
        this.C = (InkPageIndicator) findViewById(R.id.mi_pager_indicator);
        this.D = (TextSwitcher) findViewById(R.id.mi_button_cta);
        this.E = (ImageButton) findViewById(R.id.mi_button_back);
        this.F = (ImageButton) findViewById(R.id.mi_button_next);
        TextSwitcher textSwitcher = this.D;
        if (textSwitcher != null) {
            textSwitcher.setInAnimation(this, R.anim.mi_fade_in);
            this.D.setOutAnimation(this, R.anim.mi_fade_out);
        }
        e11 e11Var = new e11(w());
        this.H = e11Var;
        this.B.setAdapter(e11Var);
        this.B.b(this.I);
        this.B.z(this.J, false);
        this.C.setViewPager(this.B);
        es0 es0Var = (es0) this;
        ImageButton imageButton = es0Var.Y;
        if (imageButton != null) {
            imageButton.setOnClickListener(new cs0(es0Var, 1));
        }
        ImageButton imageButton2 = es0Var.X;
        if (imageButton2 != null) {
            imageButton2.setOnClickListener(new cs0(es0Var, 0));
        }
        this.F.setOnLongClickListener(new tj());
        this.E.setOnLongClickListener(new tj());
    }

    @Override // defpackage.z7, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        P();
        M();
        ImageButton imageButton = this.E;
        if (this.O == 2) {
            imageButton.setImageResource(R.drawable.mi_ic_skip);
        } else {
            imageButton.setImageResource(R.drawable.mi_ic_previous);
        }
        O();
        this.A.addOnLayoutChangeListener(new ug(1, this));
    }

    @Override // defpackage.z7, defpackage.pm, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        L();
    }

    @Override // defpackage.z7, android.app.Activity
    public void onResume() {
        super.onResume();
        N();
    }

    @Override // defpackage.pm, defpackage.om, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("com.heinrichreimersoftware.materialintro.app.IntroActivity.KEY_CURRENT_ITEM", this.B.getCurrentItem());
        bundle.putBoolean("com.heinrichreimersoftware.materialintro.app.IntroActivity.KEY_FULLSCREEN", this.L);
        bundle.putBoolean("com.heinrichreimersoftware.materialintro.app.IntroActivity.KEY_BUTTON_CTA_VISIBLE", this.M);
    }
}
