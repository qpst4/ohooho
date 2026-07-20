package defpackage;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.TypedValue;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class cq implements Parcelable {
    public static final Parcelable.Creator<cq> CREATOR = new c4(10);
    public final float A;
    public final float B;
    public final int C;
    public final int D;
    public final float E;
    public final int F;
    public final int G;
    public final int H;
    public final int I;
    public final int J;
    public final int K;
    public final int L;
    public final int M;
    public final CharSequence N;
    public final int O;
    public final Integer P;
    public final Uri Q;
    public final Bitmap.CompressFormat R;
    public final int S;
    public final int T;
    public final int U;
    public final lq V;
    public final boolean W;
    public final Rect X;
    public final int Y;
    public final boolean Z;
    public final boolean a0;
    public final boolean b;
    public final boolean b0;
    public final boolean c;
    public final int c0;
    public final eq d;
    public final boolean d0;
    public final dq e;
    public final boolean e0;
    public final float f;
    public final CharSequence f0;
    public final float g;
    public final int g0;
    public float h;
    public final boolean h0;
    public fq i;
    public final boolean i0;
    public final mq j;
    public final String j0;
    public final boolean k;
    public final List k0;
    public final boolean l;
    public final float l0;
    public final boolean m;
    public final int m0;
    public final int n;
    public final String n0;
    public final boolean o;
    public final int o0;
    public final boolean p;
    public final Integer p0;
    public final boolean q;
    public final Integer q0;
    public final boolean r;
    public final Integer r0;
    public int s;
    public final Integer s0;
    public final float t;
    public final boolean u;
    public final int v;
    public final int w;
    public final float x;
    public final int y;
    public final float z;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ cq(eq eqVar, dq dqVar, float f, float f2, float f3, fq fqVar, mq mqVar, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i, float f4, boolean z7, int i2, int i3, float f5, int i4, float f6, float f7, float f8, int i5, int i6, float f9, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, boolean z8, boolean z9, float f10, int i15, String str, int i16, int i17, int i18) {
        int i19;
        float fApplyDimension;
        boolean z10;
        int iArgb;
        eq eqVar2 = (i16 & 4) != 0 ? eq.b : eqVar;
        dq dqVar2 = (i16 & 8) != 0 ? dq.b : dqVar;
        float fApplyDimension2 = (i16 & 16) != 0 ? TypedValue.applyDimension(1, 10.0f, Resources.getSystem().getDisplayMetrics()) : f;
        float fApplyDimension3 = (i16 & 32) != 0 ? TypedValue.applyDimension(1, 3.0f, Resources.getSystem().getDisplayMetrics()) : f2;
        float fApplyDimension4 = (i16 & 64) != 0 ? TypedValue.applyDimension(1, 24.0f, Resources.getSystem().getDisplayMetrics()) : f3;
        fq fqVar2 = (i16 & 128) != 0 ? fq.d : fqVar;
        mq mqVar2 = (i16 & 256) != 0 ? mq.b : mqVar;
        boolean z11 = (i16 & 512) != 0 ? true : z;
        boolean z12 = (i16 & 1024) != 0 ? false : z2;
        boolean z13 = (i16 & 2048) != 0 ? true : z3;
        int iRgb = Color.rgb(153, 51, 153);
        boolean z14 = (i16 & 8192) != 0 ? true : z4;
        boolean z15 = (i16 & 16384) != 0 ? false : z5;
        boolean z16 = (32768 & i16) != 0 ? true : z6;
        int i20 = (131072 & i16) != 0 ? 4 : i;
        float f11 = (262144 & i16) != 0 ? 0.0f : f4;
        boolean z17 = (524288 & i16) != 0 ? false : z7;
        int i21 = (1048576 & i16) != 0 ? 1 : i2;
        int i22 = (2097152 & i16) != 0 ? 1 : i3;
        if ((i16 & 4194304) != 0) {
            i19 = 4194304;
            fApplyDimension = TypedValue.applyDimension(1, 3.0f, Resources.getSystem().getDisplayMetrics());
        } else {
            i19 = 4194304;
            fApplyDimension = f5;
        }
        int iArgb2 = (i16 & 8388608) != 0 ? Color.argb(170, 255, 255, 255) : i4;
        float fApplyDimension5 = (16777216 & i16) != 0 ? TypedValue.applyDimension(1, 2.0f, Resources.getSystem().getDisplayMetrics()) : f6;
        float fApplyDimension6 = (33554432 & i16) != 0 ? TypedValue.applyDimension(1, 5.0f, Resources.getSystem().getDisplayMetrics()) : f7;
        float fApplyDimension7 = (67108864 & i16) != 0 ? TypedValue.applyDimension(1, 14.0f, Resources.getSystem().getDisplayMetrics()) : f8;
        int i23 = (134217728 & i16) != 0 ? -1 : i5;
        int i24 = (268435456 & i16) != 0 ? -1 : i6;
        float fApplyDimension8 = (536870912 & i16) != 0 ? TypedValue.applyDimension(1, 1.0f, Resources.getSystem().getDisplayMetrics()) : f9;
        int iArgb3 = (i16 & 1073741824) != 0 ? Color.argb(170, 255, 255, 255) : i7;
        if ((i16 & Integer.MIN_VALUE) != 0) {
            z10 = false;
            iArgb = Color.argb(119, 0, 0, 0);
        } else {
            z10 = false;
            iArgb = i8;
        }
        this(true, true, eqVar2, dqVar2, fApplyDimension2, fApplyDimension3, fApplyDimension4, fqVar2, mqVar2, z11, z12, z13, iRgb, z14, z15, z16, true, i20, f11, z17, i21, i22, fApplyDimension, iArgb2, fApplyDimension5, fApplyDimension6, fApplyDimension7, i23, i24, fApplyDimension8, iArgb3, iArgb, (i17 & 1) != 0 ? (int) TypedValue.applyDimension(1, 42.0f, Resources.getSystem().getDisplayMetrics()) : i9, (i17 & 2) != 0 ? (int) TypedValue.applyDimension(1, 42.0f, Resources.getSystem().getDisplayMetrics()) : i10, (i17 & 4) != 0 ? 40 : i11, (i17 & 8) != 0 ? 40 : i12, (i17 & 16) != 0 ? 99999 : i13, (i17 & 32) != 0 ? 99999 : i14, "", 0, null, null, Bitmap.CompressFormat.JPEG, 90, 0, 0, lq.b, false, null, -1, true, true, false, 90, (i17 & i19) != 0 ? z10 : z8, (i17 & 8388608) != 0 ? z10 : z9, null, 0, false, false, null, oy.b, (i17 & 1073741824) != 0 ? TypedValue.applyDimension(2, 20.0f, Resources.getSystem().getDisplayMetrics()) : f10, (i17 & Integer.MIN_VALUE) != 0 ? -1 : i15, (i18 & 1) != 0 ? "" : str, -1, null, null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cq)) {
            return false;
        }
        cq cqVar = (cq) obj;
        return this.b == cqVar.b && this.c == cqVar.c && this.d == cqVar.d && this.e == cqVar.e && Float.compare(this.f, cqVar.f) == 0 && Float.compare(this.g, cqVar.g) == 0 && Float.compare(this.h, cqVar.h) == 0 && this.i == cqVar.i && this.j == cqVar.j && this.k == cqVar.k && this.l == cqVar.l && this.m == cqVar.m && this.n == cqVar.n && this.o == cqVar.o && this.p == cqVar.p && this.q == cqVar.q && this.r == cqVar.r && this.s == cqVar.s && Float.compare(this.t, cqVar.t) == 0 && this.u == cqVar.u && this.v == cqVar.v && this.w == cqVar.w && Float.compare(this.x, cqVar.x) == 0 && this.y == cqVar.y && Float.compare(this.z, cqVar.z) == 0 && Float.compare(this.A, cqVar.A) == 0 && Float.compare(this.B, cqVar.B) == 0 && this.C == cqVar.C && this.D == cqVar.D && Float.compare(this.E, cqVar.E) == 0 && this.F == cqVar.F && this.G == cqVar.G && this.H == cqVar.H && this.I == cqVar.I && this.J == cqVar.J && this.K == cqVar.K && this.L == cqVar.L && this.M == cqVar.M && fc0.b(this.N, cqVar.N) && this.O == cqVar.O && fc0.b(this.P, cqVar.P) && fc0.b(this.Q, cqVar.Q) && this.R == cqVar.R && this.S == cqVar.S && this.T == cqVar.T && this.U == cqVar.U && this.V == cqVar.V && this.W == cqVar.W && fc0.b(this.X, cqVar.X) && this.Y == cqVar.Y && this.Z == cqVar.Z && this.a0 == cqVar.a0 && this.b0 == cqVar.b0 && this.c0 == cqVar.c0 && this.d0 == cqVar.d0 && this.e0 == cqVar.e0 && fc0.b(this.f0, cqVar.f0) && this.g0 == cqVar.g0 && this.h0 == cqVar.h0 && this.i0 == cqVar.i0 && fc0.b(this.j0, cqVar.j0) && fc0.b(this.k0, cqVar.k0) && Float.compare(this.l0, cqVar.l0) == 0 && this.m0 == cqVar.m0 && fc0.b(this.n0, cqVar.n0) && this.o0 == cqVar.o0 && fc0.b(this.p0, cqVar.p0) && fc0.b(this.q0, cqVar.q0) && fc0.b(this.r0, cqVar.r0) && fc0.b(this.s0, cqVar.s0);
    }

    public final int hashCode() {
        int iG = l11.g(this.O, (this.N.hashCode() + l11.g(this.M, l11.g(this.L, l11.g(this.K, l11.g(this.J, l11.g(this.I, l11.g(this.H, l11.g(this.G, l11.g(this.F, (Float.hashCode(this.E) + l11.g(this.D, l11.g(this.C, (Float.hashCode(this.B) + ((Float.hashCode(this.A) + ((Float.hashCode(this.z) + l11.g(this.y, (Float.hashCode(this.x) + l11.g(this.w, l11.g(this.v, (Boolean.hashCode(this.u) + ((Float.hashCode(this.t) + l11.g(this.s, (Boolean.hashCode(this.r) + ((Boolean.hashCode(this.q) + ((Boolean.hashCode(this.p) + ((Boolean.hashCode(this.o) + l11.g(this.n, (Boolean.hashCode(this.m) + ((Boolean.hashCode(this.l) + ((Boolean.hashCode(this.k) + ((this.j.hashCode() + ((this.i.hashCode() + ((Float.hashCode(this.h) + ((Float.hashCode(this.g) + ((Float.hashCode(this.f) + ((this.e.hashCode() + ((this.d.hashCode() + ((Boolean.hashCode(this.c) + (Boolean.hashCode(this.b) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31, 31)) * 31)) * 31)) * 31)) * 31, 31)) * 31)) * 31, 31), 31)) * 31, 31)) * 31)) * 31)) * 31, 31), 31)) * 31, 31), 31), 31), 31), 31), 31), 31), 31)) * 31, 31);
        Integer num = this.P;
        int iHashCode = (iG + (num == null ? 0 : num.hashCode())) * 31;
        Uri uri = this.Q;
        int iHashCode2 = (Boolean.hashCode(this.W) + ((this.V.hashCode() + l11.g(this.U, l11.g(this.T, l11.g(this.S, (this.R.hashCode() + ((iHashCode + (uri == null ? 0 : uri.hashCode())) * 31)) * 31, 31), 31), 31)) * 31)) * 31;
        Rect rect = this.X;
        int iHashCode3 = (Boolean.hashCode(this.e0) + ((Boolean.hashCode(this.d0) + l11.g(this.c0, (Boolean.hashCode(this.b0) + ((Boolean.hashCode(this.a0) + ((Boolean.hashCode(this.Z) + l11.g(this.Y, (iHashCode2 + (rect == null ? 0 : rect.hashCode())) * 31, 31)) * 31)) * 31)) * 31, 31)) * 31)) * 31;
        CharSequence charSequence = this.f0;
        int iHashCode4 = (Boolean.hashCode(this.i0) + ((Boolean.hashCode(this.h0) + l11.g(this.g0, (iHashCode3 + (charSequence == null ? 0 : charSequence.hashCode())) * 31, 31)) * 31)) * 31;
        String str = this.j0;
        int iHashCode5 = (iHashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        List list = this.k0;
        int iG2 = l11.g(this.m0, (Float.hashCode(this.l0) + ((iHashCode5 + (list == null ? 0 : list.hashCode())) * 31)) * 31, 31);
        String str2 = this.n0;
        int iG3 = l11.g(this.o0, (iG2 + (str2 == null ? 0 : str2.hashCode())) * 31, 31);
        Integer num2 = this.p0;
        int iHashCode6 = (iG3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.q0;
        int iHashCode7 = (iHashCode6 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.r0;
        int iHashCode8 = (iHashCode7 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.s0;
        return iHashCode8 + (num5 != null ? num5.hashCode() : 0);
    }

    public final String toString() {
        return "CropImageOptions(imageSourceIncludeGallery=" + this.b + ", imageSourceIncludeCamera=" + this.c + ", cropShape=" + this.d + ", cornerShape=" + this.e + ", cropCornerRadius=" + this.f + ", snapRadius=" + this.g + ", touchRadius=" + this.h + ", guidelines=" + this.i + ", scaleType=" + this.j + ", showCropOverlay=" + this.k + ", showCropLabel=" + this.l + ", showProgressBar=" + this.m + ", progressBarColor=" + this.n + ", autoZoomEnabled=" + this.o + ", multiTouchEnabled=" + this.p + ", centerMoveEnabled=" + this.q + ", canChangeCropWindow=" + this.r + ", maxZoom=" + this.s + ", initialCropWindowPaddingRatio=" + this.t + ", fixAspectRatio=" + this.u + ", aspectRatioX=" + this.v + ", aspectRatioY=" + this.w + ", borderLineThickness=" + this.x + ", borderLineColor=" + this.y + ", borderCornerThickness=" + this.z + ", borderCornerOffset=" + this.A + ", borderCornerLength=" + this.B + ", borderCornerColor=" + this.C + ", circleCornerFillColorHexValue=" + this.D + ", guidelinesThickness=" + this.E + ", guidelinesColor=" + this.F + ", backgroundColor=" + this.G + ", minCropWindowWidth=" + this.H + ", minCropWindowHeight=" + this.I + ", minCropResultWidth=" + this.J + ", minCropResultHeight=" + this.K + ", maxCropResultWidth=" + this.L + ", maxCropResultHeight=" + this.M + ", activityTitle=" + ((Object) this.N) + ", activityMenuIconColor=" + this.O + ", activityMenuTextColor=" + this.P + ", customOutputUri=" + this.Q + ", outputCompressFormat=" + this.R + ", outputCompressQuality=" + this.S + ", outputRequestWidth=" + this.T + ", outputRequestHeight=" + this.U + ", outputRequestSizeOptions=" + this.V + ", noOutputImage=" + this.W + ", initialCropWindowRectangle=" + this.X + ", initialRotation=" + this.Y + ", allowRotation=" + this.Z + ", allowFlipping=" + this.a0 + ", allowCounterRotation=" + this.b0 + ", rotationDegrees=" + this.c0 + ", flipHorizontally=" + this.d0 + ", flipVertically=" + this.e0 + ", cropMenuCropButtonTitle=" + ((Object) this.f0) + ", cropMenuCropButtonIcon=" + this.g0 + ", skipEditing=" + this.h0 + ", showIntentChooser=" + this.i0 + ", intentChooserTitle=" + this.j0 + ", intentChooserPriorityList=" + this.k0 + ", cropperLabelTextSize=" + this.l0 + ", cropperLabelTextColor=" + this.m0 + ", cropperLabelText=" + this.n0 + ", activityBackgroundColor=" + this.o0 + ", toolbarColor=" + this.p0 + ", toolbarTitleColor=" + this.q0 + ", toolbarBackButtonColor=" + this.r0 + ", toolbarTintColor=" + this.s0 + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeInt(this.b ? 1 : 0);
        parcel.writeInt(this.c ? 1 : 0);
        parcel.writeString(this.d.name());
        parcel.writeString(this.e.name());
        parcel.writeFloat(this.f);
        parcel.writeFloat(this.g);
        parcel.writeFloat(this.h);
        parcel.writeString(this.i.name());
        parcel.writeString(this.j.name());
        parcel.writeInt(this.k ? 1 : 0);
        parcel.writeInt(this.l ? 1 : 0);
        parcel.writeInt(this.m ? 1 : 0);
        parcel.writeInt(this.n);
        parcel.writeInt(this.o ? 1 : 0);
        parcel.writeInt(this.p ? 1 : 0);
        parcel.writeInt(this.q ? 1 : 0);
        parcel.writeInt(this.r ? 1 : 0);
        parcel.writeInt(this.s);
        parcel.writeFloat(this.t);
        parcel.writeInt(this.u ? 1 : 0);
        parcel.writeInt(this.v);
        parcel.writeInt(this.w);
        parcel.writeFloat(this.x);
        parcel.writeInt(this.y);
        parcel.writeFloat(this.z);
        parcel.writeFloat(this.A);
        parcel.writeFloat(this.B);
        parcel.writeInt(this.C);
        parcel.writeInt(this.D);
        parcel.writeFloat(this.E);
        parcel.writeInt(this.F);
        parcel.writeInt(this.G);
        parcel.writeInt(this.H);
        parcel.writeInt(this.I);
        parcel.writeInt(this.J);
        parcel.writeInt(this.K);
        parcel.writeInt(this.L);
        parcel.writeInt(this.M);
        TextUtils.writeToParcel(this.N, parcel, i);
        parcel.writeInt(this.O);
        Integer num = this.P;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeParcelable(this.Q, i);
        parcel.writeString(this.R.name());
        parcel.writeInt(this.S);
        parcel.writeInt(this.T);
        parcel.writeInt(this.U);
        parcel.writeString(this.V.name());
        parcel.writeInt(this.W ? 1 : 0);
        parcel.writeParcelable(this.X, i);
        parcel.writeInt(this.Y);
        parcel.writeInt(this.Z ? 1 : 0);
        parcel.writeInt(this.a0 ? 1 : 0);
        parcel.writeInt(this.b0 ? 1 : 0);
        parcel.writeInt(this.c0);
        parcel.writeInt(this.d0 ? 1 : 0);
        parcel.writeInt(this.e0 ? 1 : 0);
        TextUtils.writeToParcel(this.f0, parcel, i);
        parcel.writeInt(this.g0);
        parcel.writeInt(this.h0 ? 1 : 0);
        parcel.writeInt(this.i0 ? 1 : 0);
        parcel.writeString(this.j0);
        parcel.writeStringList(this.k0);
        parcel.writeFloat(this.l0);
        parcel.writeInt(this.m0);
        parcel.writeString(this.n0);
        parcel.writeInt(this.o0);
        Integer num2 = this.p0;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        Integer num3 = this.q0;
        if (num3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num3.intValue());
        }
        Integer num4 = this.r0;
        if (num4 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num4.intValue());
        }
        Integer num5 = this.s0;
        if (num5 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num5.intValue());
        }
    }

    public cq(boolean z, boolean z2, eq eqVar, dq dqVar, float f, float f2, float f3, fq fqVar, mq mqVar, boolean z3, boolean z4, boolean z5, int i, boolean z6, boolean z7, boolean z8, boolean z9, int i2, float f4, boolean z10, int i3, int i4, float f5, int i5, float f6, float f7, float f8, int i6, int i7, float f9, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, CharSequence charSequence, int i16, Integer num, Uri uri, Bitmap.CompressFormat compressFormat, int i17, int i18, int i19, lq lqVar, boolean z11, Rect rect, int i20, boolean z12, boolean z13, boolean z14, int i21, boolean z15, boolean z16, CharSequence charSequence2, int i22, boolean z17, boolean z18, String str, List list, float f10, int i23, String str2, int i24, Integer num2, Integer num3, Integer num4, Integer num5) {
        eqVar.getClass();
        dqVar.getClass();
        fqVar.getClass();
        mqVar.getClass();
        charSequence.getClass();
        compressFormat.getClass();
        lqVar.getClass();
        this.b = z;
        this.c = z2;
        this.d = eqVar;
        this.e = dqVar;
        this.f = f;
        this.g = f2;
        this.h = f3;
        this.i = fqVar;
        this.j = mqVar;
        this.k = z3;
        this.l = z4;
        this.m = z5;
        this.n = i;
        this.o = z6;
        this.p = z7;
        this.q = z8;
        this.r = z9;
        this.s = i2;
        this.t = f4;
        this.u = z10;
        this.v = i3;
        this.w = i4;
        this.x = f5;
        this.y = i5;
        this.z = f6;
        this.A = f7;
        this.B = f8;
        this.C = i6;
        this.D = i7;
        this.E = f9;
        this.F = i8;
        this.G = i9;
        this.H = i10;
        this.I = i11;
        this.J = i12;
        this.K = i13;
        this.L = i14;
        this.M = i15;
        this.N = charSequence;
        this.O = i16;
        this.P = num;
        this.Q = uri;
        this.R = compressFormat;
        this.S = i17;
        this.T = i18;
        this.U = i19;
        this.V = lqVar;
        this.W = z11;
        this.X = rect;
        this.Y = i20;
        this.Z = z12;
        this.a0 = z13;
        this.b0 = z14;
        this.c0 = i21;
        this.d0 = z15;
        this.e0 = z16;
        this.f0 = charSequence2;
        this.g0 = i22;
        this.h0 = z17;
        this.i0 = z18;
        this.j0 = str;
        this.k0 = list;
        this.l0 = f10;
        this.m0 = i23;
        this.n0 = str2;
        this.o0 = i24;
        this.p0 = num2;
        this.q0 = num3;
        this.r0 = num4;
        this.s0 = num5;
        if (i2 < 0) {
            zy.n("Cannot set max zoom to a number < 1");
            throw null;
        }
        if (f3 < 0.0f) {
            zy.n("Cannot set touch radius value to a number <= 0 ");
            throw null;
        }
        if (f4 < 0.0f || f4 >= 0.5d) {
            zy.n("Cannot set initial crop window padding value to a number < 0 or >= 0.5");
            throw null;
        }
        if (i3 <= 0) {
            zy.n("Cannot set aspect ratio value to a number less than or equal to 0.");
            throw null;
        }
        if (i4 <= 0) {
            zy.n("Cannot set aspect ratio value to a number less than or equal to 0.");
            throw null;
        }
        if (f5 < 0.0f) {
            zy.n("Cannot set line thickness value to a number less than 0.");
            throw null;
        }
        if (f6 < 0.0f) {
            zy.n("Cannot set corner thickness value to a number less than 0.");
            throw null;
        }
        if (f9 < 0.0f) {
            zy.n("Cannot set guidelines thickness value to a number less than 0.");
            throw null;
        }
        if (i11 < 0) {
            zy.n("Cannot set min crop window height value to a number < 0 ");
            throw null;
        }
        if (i12 < 0) {
            zy.n("Cannot set min crop result width value to a number < 0 ");
            throw null;
        }
        if (i13 < 0) {
            zy.n("Cannot set min crop result height value to a number < 0 ");
            throw null;
        }
        if (i14 < i12) {
            zy.n("Cannot set max crop result width to smaller value than min crop result width");
            throw null;
        }
        if (i15 < i13) {
            zy.n("Cannot set max crop result height to smaller value than min crop result height");
            throw null;
        }
        if (i18 < 0) {
            zy.n("Cannot set request width value to a number < 0 ");
            throw null;
        }
        if (i19 < 0) {
            zy.n("Cannot set request height value to a number < 0 ");
            throw null;
        }
        if (i21 < 0 || i21 > 360) {
            zy.n("Cannot set rotation degrees value to a number < 0 or > 360");
            throw null;
        }
    }
}
