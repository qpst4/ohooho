package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.TypedValue;
import com.quickcursor.R;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class bw0 {
    public static bw0 g;
    public WeakHashMap a;
    public final WeakHashMap b = new WeakHashMap(0);
    public TypedValue c;
    public boolean d;
    public a9 e;
    public static final PorterDuff.Mode f = PorterDuff.Mode.SRC_IN;
    public static final aw0 h = new aw0(6);

    public static synchronized bw0 b() {
        try {
            if (g == null) {
                g = new bw0();
            }
        } catch (Throwable th) {
            throw th;
        }
        return g;
    }

    public static synchronized PorterDuffColorFilter e(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        aw0 aw0Var = h;
        aw0Var.getClass();
        int i2 = (31 + i) * 31;
        porterDuffColorFilter = (PorterDuffColorFilter) aw0Var.f(Integer.valueOf(mode.hashCode() + i2));
        if (porterDuffColorFilter == null) {
            porterDuffColorFilter = new PorterDuffColorFilter(i, mode);
        }
        return porterDuffColorFilter;
    }

    public final Drawable a(Context context, int i) {
        LayerDrawable layerDrawableE;
        WeakReference weakReference;
        Drawable drawableNewDrawable;
        if (this.c == null) {
            this.c = new TypedValue();
        }
        TypedValue typedValue = this.c;
        context.getResources().getValue(i, typedValue, true);
        long j = (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
        synchronized (this) {
            vi0 vi0Var = (vi0) this.b.get(context);
            layerDrawableE = null;
            if (vi0Var != null && (weakReference = (WeakReference) vi0Var.b(j)) != null) {
                Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
                if (constantState != null) {
                    drawableNewDrawable = constantState.newDrawable(context.getResources());
                } else {
                    int iF = f01.f(vi0Var.c, vi0Var.e, j);
                    if (iF >= 0) {
                        Object[] objArr = vi0Var.d;
                        Object obj = objArr[iF];
                        Object obj2 = tk0.f;
                        if (obj != obj2) {
                            objArr[iF] = obj2;
                            vi0Var.b = true;
                        }
                    }
                }
            }
            drawableNewDrawable = null;
        }
        if (drawableNewDrawable != null) {
            return drawableNewDrawable;
        }
        if (this.e != null) {
            if (i == R.drawable.abc_cab_background_top_material) {
                layerDrawableE = new LayerDrawable(new Drawable[]{c(context, R.drawable.abc_cab_background_internal_bg), c(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
            } else if (i == R.drawable.abc_ratingbar_material) {
                layerDrawableE = a9.e(this, context, R.dimen.abc_star_big);
            } else if (i == R.drawable.abc_ratingbar_indicator_material) {
                layerDrawableE = a9.e(this, context, R.dimen.abc_star_medium);
            } else if (i == R.drawable.abc_ratingbar_small_material) {
                layerDrawableE = a9.e(this, context, R.dimen.abc_star_small);
            }
        }
        if (layerDrawableE == null) {
            return layerDrawableE;
        }
        layerDrawableE.setChangingConfigurations(typedValue.changingConfigurations);
        synchronized (this) {
            try {
                Drawable.ConstantState constantState2 = layerDrawableE.getConstantState();
                if (constantState2 == null) {
                    return layerDrawableE;
                }
                vi0 vi0Var2 = (vi0) this.b.get(context);
                if (vi0Var2 == null) {
                    vi0Var2 = new vi0();
                    this.b.put(context, vi0Var2);
                }
                vi0Var2.d(j, new WeakReference(constantState2));
                return layerDrawableE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized Drawable c(Context context, int i) {
        return d(context, i, false);
    }

    public final synchronized Drawable d(Context context, int i, boolean z) {
        Drawable drawableA;
        try {
            if (!this.d) {
                this.d = true;
                Drawable drawableC = c(context, R.drawable.abc_vector_test);
                if (drawableC == null || (!(drawableC instanceof qe1) && !"android.graphics.drawable.VectorDrawable".equals(drawableC.getClass().getName()))) {
                    this.d = false;
                    throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
                }
            }
            drawableA = a(context, i);
            if (drawableA == null) {
                drawableA = context.getDrawable(i);
            }
            if (drawableA != null) {
                drawableA = g(context, i, z, drawableA);
            }
            if (drawableA != null) {
                vu.a(drawableA);
            }
        } catch (Throwable th) {
            throw th;
        }
        return drawableA;
    }

    public final synchronized ColorStateList f(Context context, int i) {
        ColorStateList colorStateList;
        t11 t11Var;
        Object obj;
        WeakHashMap weakHashMap = this.a;
        ColorStateList colorStateListF = null;
        if (weakHashMap == null || (t11Var = (t11) weakHashMap.get(context)) == null) {
            colorStateList = null;
        } else {
            int iE = f01.e(t11Var.d, i, t11Var.b);
            if (iE < 0 || (obj = t11Var.c[iE]) == xy0.g) {
                obj = null;
            }
            colorStateList = (ColorStateList) obj;
        }
        if (colorStateList == null) {
            a9 a9Var = this.e;
            if (a9Var != null) {
                colorStateListF = a9Var.f(context, i);
            }
            if (colorStateListF != null) {
                if (this.a == null) {
                    this.a = new WeakHashMap();
                }
                t11 t11Var2 = (t11) this.a.get(context);
                if (t11Var2 == null) {
                    t11Var2 = new t11();
                    this.a.put(context, t11Var2);
                }
                t11Var2.a(i, colorStateListF);
            }
            colorStateList = colorStateListF;
        }
        return colorStateList;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.drawable.Drawable g(android.content.Context r9, int r10, boolean r11, android.graphics.drawable.Drawable r12) {
        /*
            Method dump skipped, instruction units count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bw0.g(android.content.Context, int, boolean, android.graphics.drawable.Drawable):android.graphics.drawable.Drawable");
    }
}
