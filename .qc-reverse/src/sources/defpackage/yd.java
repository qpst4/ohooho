package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.quickcursor.R;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class yd extends Drawable implements z41 {
    public final WeakReference b;
    public final ik0 c;
    public final a51 d;
    public final Rect e;
    public final ae f;
    public float g;
    public float h;
    public final int i;
    public float j;
    public float k;
    public float l;
    public WeakReference m;
    public WeakReference n;

    public yd(Context context) {
        x41 x41Var;
        WeakReference weakReference = new WeakReference(context);
        this.b = weakReference;
        f01.n(context, f01.j, "Theme.MaterialComponents");
        this.e = new Rect();
        a51 a51Var = new a51(this);
        this.d = a51Var;
        Paint.Align align = Paint.Align.CENTER;
        TextPaint textPaint = a51Var.a;
        textPaint.setTextAlign(align);
        ae aeVar = new ae(context);
        this.f = aeVar;
        boolean zF = f();
        zd zdVar = aeVar.b;
        ik0 ik0Var = new ik0(mz0.a(context, zF ? zdVar.h.intValue() : zdVar.f.intValue(), f() ? zdVar.i.intValue() : zdVar.g.intValue(), new h(0.0f)).a());
        this.c = ik0Var;
        h();
        Context context2 = (Context) weakReference.get();
        if (context2 != null && a51Var.g != (x41Var = new x41(context2, zdVar.e.intValue()))) {
            a51Var.b(x41Var, context2);
            textPaint.setColor(zdVar.d.intValue());
            invalidateSelf();
            j();
            invalidateSelf();
        }
        int i = zdVar.m;
        if (i != -2) {
            this.i = ((int) Math.pow(10.0d, ((double) i) - 1.0d)) - 1;
        } else {
            this.i = zdVar.n;
        }
        a51Var.e = true;
        j();
        invalidateSelf();
        a51Var.e = true;
        h();
        j();
        invalidateSelf();
        textPaint.setAlpha(getAlpha());
        invalidateSelf();
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(zdVar.c.intValue());
        if (ik0Var.b.c != colorStateListValueOf) {
            ik0Var.k(colorStateListValueOf);
            invalidateSelf();
        }
        textPaint.setColor(zdVar.d.intValue());
        invalidateSelf();
        WeakReference weakReference2 = this.m;
        if (weakReference2 != null && weakReference2.get() != null) {
            View view = (View) this.m.get();
            WeakReference weakReference3 = this.n;
            i(view, weakReference3 != null ? (FrameLayout) weakReference3.get() : null);
        }
        j();
        setVisible(zdVar.u.booleanValue(), false);
    }

    @Override // defpackage.z41
    public final void a() {
        invalidateSelf();
    }

    public final String b() {
        ae aeVar = this.f;
        zd zdVar = aeVar.b;
        zd zdVar2 = aeVar.b;
        String str = zdVar.k;
        WeakReference weakReference = this.b;
        if (str == null) {
            if (!g()) {
                return null;
            }
            int i = this.i;
            if (i == -2 || e() <= i) {
                return NumberFormat.getInstance(zdVar2.o).format(e());
            }
            Context context = (Context) weakReference.get();
            return context == null ? "" : String.format(zdVar2.o, context.getString(R.string.mtrl_exceed_max_badge_number_suffix), Integer.valueOf(i), "+");
        }
        int i2 = zdVar.m;
        if (i2 == -2 || str == null || str.length() <= i2) {
            return str;
        }
        Context context2 = (Context) weakReference.get();
        if (context2 == null) {
            return "";
        }
        return String.format(context2.getString(R.string.m3_exceed_max_badge_text_suffix), str.substring(0, i2 - 1), "…");
    }

    public final CharSequence c() {
        Context context;
        if (!isVisible()) {
            return null;
        }
        ae aeVar = this.f;
        zd zdVar = aeVar.b;
        if (zdVar.k != null) {
            CharSequence charSequence = zdVar.p;
            return charSequence != null ? charSequence : aeVar.b.k;
        }
        boolean zG = g();
        zd zdVar2 = aeVar.b;
        if (!zG) {
            return zdVar2.q;
        }
        if (zdVar2.r == 0 || (context = (Context) this.b.get()) == null) {
            return null;
        }
        int i = this.i;
        return (i == -2 || e() <= i) ? context.getResources().getQuantityString(zdVar2.r, e(), Integer.valueOf(e())) : context.getString(zdVar2.s, Integer.valueOf(i));
    }

    public final FrameLayout d() {
        WeakReference weakReference = this.n;
        if (weakReference != null) {
            return (FrameLayout) weakReference.get();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        String strB;
        if (getBounds().isEmpty() || getAlpha() == 0 || !isVisible()) {
            return;
        }
        this.c.draw(canvas);
        if (!f() || (strB = b()) == null) {
            return;
        }
        Rect rect = new Rect();
        a51 a51Var = this.d;
        a51Var.a.getTextBounds(strB, 0, strB.length(), rect);
        float fExactCenterY = this.h - rect.exactCenterY();
        canvas.drawText(strB, this.g, rect.bottom <= 0 ? (int) fExactCenterY : Math.round(fExactCenterY), a51Var.a);
    }

    public final int e() {
        int i = this.f.b.l;
        if (i != -1) {
            return i;
        }
        return 0;
    }

    public final boolean f() {
        return this.f.b.k != null || g();
    }

    public final boolean g() {
        zd zdVar = this.f.b;
        return zdVar.k == null && zdVar.l != -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f.b.j;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.e.height();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.e.width();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public final void h() {
        Context context = (Context) this.b.get();
        if (context == null) {
            return;
        }
        boolean zF = f();
        ae aeVar = this.f;
        this.c.setShapeAppearanceModel(mz0.a(context, zF ? aeVar.b.h.intValue() : aeVar.b.f.intValue(), f() ? aeVar.b.i.intValue() : aeVar.b.g.intValue(), new h(0.0f)).a());
        invalidateSelf();
    }

    public final void i(View view, FrameLayout frameLayout) {
        this.m = new WeakReference(view);
        this.n = new WeakReference(frameLayout);
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
        j();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0283  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j() {
        /*
            Method dump skipped, instruction units count: 734
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yd.j():void");
    }

    @Override // android.graphics.drawable.Drawable, defpackage.z41
    public final boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        ae aeVar = this.f;
        aeVar.a.j = i;
        aeVar.b.j = i;
        this.d.a.setAlpha(getAlpha());
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
