package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import defpackage.a2;
import defpackage.b71;
import defpackage.bo;
import defpackage.m8;
import defpackage.ng1;
import defpackage.x1;
import defpackage.y8;
import defpackage.zk0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {
    public TypedValue b;
    public TypedValue c;
    public TypedValue d;
    public TypedValue e;
    public TypedValue f;
    public TypedValue g;
    public final Rect h;
    public bo i;

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.h = new Rect();
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f == null) {
            this.f = new TypedValue();
        }
        return this.f;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.g == null) {
            this.g = new TypedValue();
        }
        return this.g;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.d == null) {
            this.d = new TypedValue();
        }
        return this.d;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.e == null) {
            this.e = new TypedValue();
        }
        return this.e;
    }

    public TypedValue getMinWidthMajor() {
        if (this.b == null) {
            this.b = new TypedValue();
        }
        return this.b;
    }

    public TypedValue getMinWidthMinor() {
        if (this.c == null) {
            this.c = new TypedValue();
        }
        return this.c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        bo boVar = this.i;
        if (boVar != null) {
            boVar.getClass();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        a2 a2Var;
        super.onDetachedFromWindow();
        bo boVar = this.i;
        if (boVar != null) {
            y8 y8Var = ((m8) boVar).c;
            ActionBarOverlayLayout actionBarOverlayLayout = y8Var.r;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.k();
                ActionMenuView actionMenuView = ((b71) actionBarOverlayLayout.f).a.b;
                if (actionMenuView != null && (a2Var = actionMenuView.u) != null) {
                    a2Var.d();
                    x1 x1Var = a2Var.u;
                    if (x1Var != null && x1Var.b()) {
                        x1Var.i.dismiss();
                    }
                }
            }
            if (y8Var.w != null) {
                y8Var.m.getDecorView().removeCallbacks(y8Var.x);
                if (y8Var.w.isShowing()) {
                    try {
                        y8Var.w.dismiss();
                    } catch (IllegalArgumentException unused) {
                    }
                }
                y8Var.w = null;
            }
            ng1 ng1Var = y8Var.y;
            if (ng1Var != null) {
                ng1Var.b();
            }
            zk0 zk0Var = y8Var.z(0).h;
            if (zk0Var != null) {
                zk0Var.c(true);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00de  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r17, int r18) {
        /*
            Method dump skipped, instruction units count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public void setAttachListener(bo boVar) {
        this.i = boVar;
    }
}
