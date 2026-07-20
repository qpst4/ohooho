package com.quickcursor.android.drawables.globals;

import android.animation.ObjectAnimator;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import defpackage.dx;
import defpackage.ey0;
import defpackage.i1;
import defpackage.i9;
import defpackage.lw;
import defpackage.n3;
import defpackage.oq0;
import defpackage.pn0;
import defpackage.s60;
import defpackage.sw;
import defpackage.xw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class EdgeActionsDrawable extends Drawable implements s60 {
    public static final AccelerateInterpolator o = new AccelerateInterpolator();
    public static final DecelerateInterpolator p = new DecelerateInterpolator();
    public static final DecelerateInterpolator q = new DecelerateInterpolator(0.75f);
    public static final int r = ey0.a(1);
    public static final int s;
    public static final int t;
    public static final int u;
    public final int b;
    public final int c;
    public final float d;
    public final int e;
    public final int f;
    public final boolean g;
    public final int h;
    public final ArrayList i;
    public final List j;
    public List k;
    public boolean l = false;
    public float m = 0.0f;
    public ObjectAnimator n;

    static {
        int iA = ey0.a(36);
        s = iA;
        t = iA / 2;
        u = iA / 3;
    }

    public EdgeActionsDrawable() {
        List listF;
        xw xwVar = xw.e;
        dx dxVarD = xwVar.d("leftEdgeBar");
        dx dxVarD2 = xwVar.d("topEdgeBar");
        dx dxVarD3 = xwVar.d("rightEdgeBar");
        dx dxVarD4 = xwVar.d("bottomEdgeBar");
        this.h = (int) oq0.b((SharedPreferences) pn0.t().d, oq0.k0);
        this.b = oq0.c((SharedPreferences) pn0.t().d, oq0.r0);
        this.c = (int) oq0.b((SharedPreferences) pn0.t().d, oq0.s0);
        this.d = oq0.c((SharedPreferences) pn0.t().d, oq0.t0) / 100.0f;
        this.e = oq0.c((SharedPreferences) pn0.t().d, oq0.p0) * ey0.a(25);
        this.f = oq0.c((SharedPreferences) pn0.t().d, oq0.q0) * ey0.a(10);
        this.g = oq0.a((SharedPreferences) pn0.t().d, oq0.o0);
        boolean zA = oq0.a((SharedPreferences) pn0.t().d, oq0.f0);
        ArrayList arrayListF = f(dxVarD, dxVarD2, dxVarD3, dxVarD4);
        this.i = arrayListF;
        if (zA) {
            dx dxVar = new dx(Collections.singletonList(new lw(n3.stopGestureRecorder, null)));
            listF = f(dxVar, dxVar, dxVar, dxVar);
        } else {
            listF = Collections.EMPTY_LIST;
        }
        this.j = listF;
        this.k = arrayListF;
    }

    @Override // defpackage.s60
    public final boolean a() {
        return this.m == 0.0f;
    }

    @Override // defpackage.s60
    public final boolean c() {
        return false;
    }

    @Override // android.graphics.drawable.Drawable, defpackage.s60
    public final void draw(Canvas canvas) {
        for (sw swVar : this.k) {
            int i = this.c;
            if (i > 0) {
                float f = this.d;
                if (f > 0.0f) {
                    swVar.h.setColor(i1.e(swVar.g, f * this.m));
                    float f2 = i;
                    canvas.drawRoundRect(swVar.b, f2, f2, swVar.h);
                }
            }
            float f3 = swVar.k;
            Paint paint = swVar.i;
            Paint paint2 = swVar.j;
            Drawable drawable = swVar.f;
            Point point = swVar.e;
            if (f3 > 0.0f) {
                float f4 = f3 * this.m;
                if (this.f > 0) {
                    paint.setColor(i1.e(swVar.g, f4));
                    canvas.drawRect(swVar.a, paint);
                }
                if (this.g) {
                    int i2 = t;
                    int interpolation = (int) ((q.getInterpolation(f4) * s * 1.15f) + (i2 * (-1)));
                    int i3 = (int) (f4 * 255.0f);
                    drawable.setAlpha(i3);
                    paint2.setAlpha(i3);
                    Rect rect = swVar.c;
                    int i4 = rect.right;
                    int i5 = u;
                    if (i4 == 0) {
                        canvas.drawCircle(point.x + interpolation, point.y, i2, paint2);
                        int i6 = point.x;
                        int i7 = point.y;
                        drawable.setBounds((i6 - i5) + interpolation, i7 - i5, i6 + i5 + interpolation, i7 + i5);
                    } else if (rect.bottom == 0) {
                        canvas.drawCircle(point.x, point.y + interpolation, i2, paint2);
                        int i8 = point.x;
                        int i9 = point.y;
                        drawable.setBounds(i8 - i5, (i9 - i5) + interpolation, i8 + i5, i9 + i5 + interpolation);
                    } else {
                        int i10 = rect.top;
                        int iB = ey0.b();
                        int i11 = point.x;
                        if (i10 == iB) {
                            canvas.drawCircle(i11, point.y - interpolation, i2, paint2);
                            int i12 = point.x;
                            int i13 = point.y;
                            drawable.setBounds(i12 - i5, (i13 - i5) - interpolation, i12 + i5, (i13 + i5) - interpolation);
                        } else {
                            canvas.drawCircle(i11 - interpolation, point.y, i2, paint2);
                            int i14 = point.x;
                            int i15 = point.y;
                            drawable.setBounds((i14 - i5) - interpolation, i15 - i5, (i14 + i5) - interpolation, i15 + i5);
                        }
                    }
                    drawable.draw(canvas);
                }
            }
        }
    }

    public final ArrayList f(dx dxVar, dx dxVar2, dx dxVar3, dx dxVar4) {
        EdgeActionsDrawable edgeActionsDrawable = this;
        ArrayList arrayList = new ArrayList();
        boolean zBooleanValue = dxVar.g().booleanValue();
        int i = edgeActionsDrawable.f;
        int i2 = r;
        int i3 = edgeActionsDrawable.c;
        int i4 = edgeActionsDrawable.h;
        int i5 = 0;
        if (zBooleanValue && dxVar.c() > 0) {
            int iB = ey0.b() / dxVar.e();
            int iJ = 0;
            int i6 = 0;
            for (lw lwVar : dxVar.d()) {
                if (lwVar.b() != n3.nothing) {
                    int i7 = iJ * iB;
                    int iJ2 = (lwVar.j() * iB) + i7;
                    Point point = new Point(i5, (i7 + iJ2) / 2);
                    float f = i3;
                    RectF rectF = new RectF(i3 * (-1), i7 + i2, f, iJ2 - i2);
                    if (i6 == 0) {
                        rectF.top = f / 1.35f;
                    }
                    int i8 = i4 * (-1);
                    arrayList.add(new sw(edgeActionsDrawable, rectF, new Rect(i * (-1), i7, 0, iJ2), new i9(new Point(i8, i7), new Point(i8, iJ2), 24, false), point, lwVar));
                }
                i6++;
                iJ = lwVar.j() + iJ;
                i5 = 0;
                edgeActionsDrawable = this;
            }
        }
        if (dxVar2.g().booleanValue() && dxVar2.c() > 0) {
            int iC = ey0.c() / dxVar2.e();
            int iJ3 = 0;
            for (lw lwVar2 : dxVar2.d()) {
                if (lwVar2.b() != n3.nothing) {
                    int i9 = iJ3 * iC;
                    int iJ4 = (lwVar2.j() * iC) + i9;
                    int i10 = i4 * (-1);
                    arrayList.add(new sw(this, new RectF(i9 + i2, i3 * (-1), iJ4 - i2, i3), new Rect(i9, i * (-1), iJ4, 0), new i9(new Point(i9, i10), new Point(iJ4, i10), 24, false), new Point((i9 + iJ4) / 2, 0), lwVar2));
                }
                iJ3 += lwVar2.j();
            }
        }
        if (dxVar3.g().booleanValue() && dxVar3.c() > 0) {
            int iB2 = ey0.b() / dxVar3.e();
            int iC2 = ey0.c();
            int iJ5 = 0;
            int i11 = 0;
            for (lw lwVar3 : dxVar3.d()) {
                if (lwVar3.b() != n3.nothing) {
                    int i12 = iJ5 * iB2;
                    int iJ6 = (lwVar3.j() * iB2) + i12;
                    Point point2 = new Point(ey0.c(), (i12 + iJ6) / 2);
                    RectF rectF2 = new RectF(iC2 - i3, i12 + i2, iC2 + i3, iJ6 - i2);
                    if (i11 == 0) {
                        rectF2.top = i3 / 1.35f;
                    }
                    Rect rect = new Rect(iC2, i12, iC2 + i, iJ6);
                    int i13 = iC2 + i4;
                    i9 i9Var = new i9(new Point(i13, i12), new Point(i13, iJ6), 24, false);
                    lwVar3 = lwVar3;
                    arrayList.add(new sw(this, rectF2, rect, i9Var, point2, lwVar3));
                }
                iJ5 += lwVar3.j();
                i11++;
            }
        }
        if (dxVar4.g().booleanValue() && dxVar4.c() > 0) {
            int iC3 = ey0.c() / dxVar4.e();
            int iB3 = ey0.b();
            int iJ7 = 0;
            for (lw lwVar4 : dxVar4.d()) {
                if (lwVar4.b() != n3.nothing) {
                    int i14 = iJ7 * iC3;
                    int iJ8 = (lwVar4.j() * iC3) + i14;
                    Point point3 = new Point((i14 + iJ8) / 2, ey0.b());
                    RectF rectF3 = new RectF(i14 + i2, iB3 - i3, iJ8 - i2, iB3 + i3);
                    Rect rect2 = new Rect(i14, iB3, iJ8, iB3 + i);
                    int i15 = iB3 + i4;
                    i9 i9Var2 = new i9(new Point(i14, i15), new Point(iJ8, i15), 24, false);
                    lwVar4 = lwVar4;
                    arrayList.add(new sw(this, rectF3, rect2, i9Var2, point3, lwVar4));
                }
                iJ7 += lwVar4.j();
            }
        }
        return arrayList;
    }

    public final void g(boolean z) {
        if (this.l != z) {
            this.l = z;
            ObjectAnimator objectAnimator = this.n;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "shouldPreviewAnimation", this.m, this.l ? 1.0f : 0.0f);
            this.n = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setInterpolator(this.l ? o : p);
            this.n.setDuration(300L);
            this.n.start();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public void setShouldPreviewAnimation(float f) {
        this.m = f;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
