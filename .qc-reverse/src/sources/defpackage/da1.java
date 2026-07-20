package defpackage;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class da1 {
    private ca1 type = ca1.valueOf(dn.D2);
    private int size = 0;
    private int margin = 0;
    private int backgroundColor = 0;
    private int cornerRadius = 0;
    private ba1 cornerRadiusMode = ba1.outside;
    private int borderSize = 0;
    private int borderColor = 0;
    private int glowSize = 0;
    private int glowColor = 0;
    private String customImage = null;

    public da1() {
        o();
    }

    public static da1 a(da1 da1Var, float f) {
        da1 da1Var2 = new da1();
        da1Var2.D(da1Var.type);
        da1Var2.size = (int) (da1Var.size * f);
        da1Var2.margin = (int) (da1Var.margin * f);
        da1Var2.backgroundColor = da1Var.backgroundColor;
        da1Var2.cornerRadius = (int) (da1Var.cornerRadius * f);
        da1Var2.cornerRadiusMode = da1Var.cornerRadiusMode;
        da1Var2.borderSize = (int) (da1Var.borderSize * f);
        da1Var2.borderColor = da1Var.borderColor;
        da1Var2.glowSize = (int) (da1Var.glowSize * f);
        da1Var2.glowColor = da1Var.glowColor;
        da1Var2.y(da1Var.g());
        return da1Var2;
    }

    public final void A(int i) {
        this.glowSize = i;
    }

    public final void B(int i) {
        this.margin = i;
    }

    public final void C(int i) {
        this.size = i;
    }

    public final void D(ca1 ca1Var) {
        this.type = ca1Var;
        if (ca1Var != ca1.custom) {
            this.customImage = null;
        }
    }

    public final int b() {
        return this.backgroundColor;
    }

    public final int c() {
        return this.borderColor;
    }

    public final int d() {
        return this.borderSize;
    }

    public final int e() {
        return this.cornerRadius;
    }

    public final ba1 f() {
        return this.cornerRadiusMode;
    }

    public final Bitmap g() {
        try {
            Bitmap bitmapH = xr.h(this.customImage);
            if (bitmapH != null) {
                return bitmapH;
            }
            return null;
        } catch (Exception e) {
            si0.b("getCustomImage error: " + e);
            return null;
        }
    }

    public final int h() {
        return this.glowColor;
    }

    public final int i() {
        return this.glowSize;
    }

    public final int j() {
        return this.margin;
    }

    public final int k() {
        return this.size;
    }

    public final ca1 l() {
        return this.type;
    }

    public final boolean m() {
        return this.type == ca1.custom;
    }

    public final boolean n() {
        return this.type == ca1.rectangle;
    }

    public final void o() {
        this.size = ey0.a(6);
        this.margin = 0;
        int i = dn.O2;
        this.backgroundColor = i;
        this.cornerRadius = ey0.a(3);
        this.cornerRadiusMode = ba1.all;
        this.borderSize = 0;
        this.borderColor = i;
        this.glowSize = 0;
        this.glowColor = dn.P2;
    }

    public final void p() {
        this.size = 0;
        this.margin = 0;
        int i = dn.O2;
        this.backgroundColor = i;
        this.cornerRadius = 0;
        this.cornerRadiusMode = ba1.all;
        this.borderSize = 0;
        this.borderColor = i;
        this.glowSize = ey0.a(10);
        this.glowColor = dn.P2;
    }

    public final void q() {
        this.size = ey0.a(1);
        this.margin = 0;
        int i = dn.O2;
        this.backgroundColor = i;
        this.cornerRadius = 0;
        this.cornerRadiusMode = ba1.all;
        this.borderSize = 0;
        this.borderColor = i;
        this.glowSize = 0;
        this.glowColor = dn.P2;
    }

    public final void r() {
        this.size = ey0.a(1);
        this.margin = 0;
        int i = dn.O2;
        this.backgroundColor = i;
        this.cornerRadius = 0;
        this.cornerRadiusMode = ba1.all;
        this.borderSize = 0;
        this.borderColor = i;
        this.glowSize = ey0.a(10);
        this.glowColor = dn.P2;
    }

    public final void s(f91 f91Var) {
        this.size = Math.min(Math.min(f91Var.h().c(), f91Var.h().f()), ey0.a(10));
        this.margin = 0;
        int i = dn.O2;
        this.backgroundColor = i;
        this.cornerRadius = ey0.a(5);
        this.cornerRadiusMode = ba1.outside;
        this.borderSize = 0;
        this.borderColor = i;
        this.glowSize = 0;
        this.glowColor = dn.P2;
    }

    public final void t(int i) {
        this.backgroundColor = i;
    }

    public final void u(int i) {
        this.borderColor = i;
    }

    public final void v(int i) {
        this.borderSize = i;
    }

    public final void w(int i) {
        this.cornerRadius = i;
    }

    public final void x(ba1 ba1Var) {
        this.cornerRadiusMode = ba1Var;
    }

    public final void y(Bitmap bitmap) {
        if (bitmap == null) {
            this.customImage = null;
            return;
        }
        try {
            this.customImage = xr.j(bitmap);
            si0.b("Encoded length:" + this.customImage.length());
        } catch (Exception e) {
            si0.b("setCustomImage error: " + e);
        }
    }

    public final void z(int i) {
        this.glowColor = i;
    }
}
