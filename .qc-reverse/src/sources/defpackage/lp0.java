package defpackage;

import android.graphics.Path;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class lp0 {
    public char a;
    public final float[] b;

    public lp0(lp0 lp0Var) {
        this.a = lp0Var.a;
        float[] fArr = lp0Var.b;
        this.b = xr.c(fArr, fArr.length);
    }

    public static void a(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
        double d;
        double d2;
        double radians = Math.toRadians(f7);
        double dCos = Math.cos(radians);
        double dSin = Math.sin(radians);
        double d3 = f;
        double d4 = f2;
        double d5 = f5;
        double d6 = ((d4 * dSin) + (d3 * dCos)) / d5;
        double d7 = f6;
        double d8 = ((d4 * dCos) + (((double) (-f)) * dSin)) / d7;
        double d9 = f4;
        double d10 = ((d9 * dSin) + (((double) f3) * dCos)) / d5;
        double d11 = ((d9 * dCos) + (((double) (-f3)) * dSin)) / d7;
        double d12 = d6 - d10;
        double d13 = d8 - d11;
        double d14 = (d6 + d10) / 2.0d;
        double d15 = (d8 + d11) / 2.0d;
        double d16 = (d13 * d13) + (d12 * d12);
        if (d16 == 0.0d) {
            Log.w("PathParser", " Points are coincident");
            return;
        }
        double d17 = (1.0d / d16) - 0.25d;
        if (d17 < 0.0d) {
            Log.w("PathParser", "Points are too far apart " + d16);
            float fSqrt = (float) (Math.sqrt(d16) / 1.99999d);
            a(path, f, f2, f3, f4, f5 * fSqrt, fSqrt * f6, f7, z, z2);
            return;
        }
        double dSqrt = Math.sqrt(d17);
        double d18 = dSqrt * d12;
        double d19 = dSqrt * d13;
        if (z == z2) {
            d = d14 - d19;
            d2 = d15 + d18;
        } else {
            d = d14 + d19;
            d2 = d15 - d18;
        }
        double dAtan2 = Math.atan2(d8 - d2, d6 - d);
        double dAtan22 = Math.atan2(d11 - d2, d10 - d) - dAtan2;
        if (z2 != (dAtan22 >= 0.0d)) {
            dAtan22 = dAtan22 > 0.0d ? dAtan22 - 6.283185307179586d : dAtan22 + 6.283185307179586d;
        }
        double d20 = d * d5;
        double d21 = d2 * d7;
        double d22 = (d20 * dCos) - (d21 * dSin);
        double d23 = (d21 * dCos) + (d20 * dSin);
        int iCeil = (int) Math.ceil(Math.abs((dAtan22 * 4.0d) / 3.141592653589793d));
        double dCos2 = Math.cos(radians);
        double dSin2 = Math.sin(radians);
        double dCos3 = Math.cos(dAtan2);
        double dSin3 = Math.sin(dAtan2);
        double d24 = -d5;
        double d25 = d24 * dCos2;
        double d26 = d7 * dSin2;
        double d27 = (d25 * dSin3) - (d26 * dCos3);
        double d28 = d24 * dSin2;
        double d29 = d7 * dCos2;
        double d30 = dAtan22 / ((double) iCeil);
        double d31 = (dCos3 * d29) + (dSin3 * d28);
        double d32 = d3;
        double d33 = d4;
        int i = 0;
        double d34 = dAtan2;
        while (i < iCeil) {
            double d35 = d34 + d30;
            double dSin4 = Math.sin(d35);
            double dCos4 = Math.cos(d35);
            int i2 = iCeil;
            double d36 = (((d5 * dCos2) * dCos4) + d22) - (d26 * dSin4);
            double d37 = (d29 * dSin4) + (d5 * dSin2 * dCos4) + d23;
            double d38 = (d25 * dSin4) - (d26 * dCos4);
            double d39 = (dCos4 * d29) + (dSin4 * d28);
            double d40 = d35 - d34;
            double dTan = Math.tan(d40 / 2.0d);
            double dSqrt2 = ((Math.sqrt(((dTan * 3.0d) * dTan) + 4.0d) - 1.0d) * Math.sin(d40)) / 3.0d;
            path.rLineTo(0.0f, 0.0f);
            path.cubicTo((float) ((d27 * dSqrt2) + d32), (float) ((d31 * dSqrt2) + d33), (float) (d36 - (dSqrt2 * d38)), (float) (d37 - (dSqrt2 * d39)), (float) d36, (float) d37);
            i++;
            d33 = d37;
            dCos2 = dCos2;
            d28 = d28;
            d34 = d35;
            d31 = d39;
            d32 = d36;
            iCeil = i2;
            d27 = d38;
            d30 = d30;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(lp0[] lp0VarArr, Path path) {
        int i;
        float[] fArr;
        int i2;
        lp0 lp0Var;
        int i3;
        char c;
        float f;
        float f2;
        lp0 lp0Var2;
        boolean z;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        lp0[] lp0VarArr2 = lp0VarArr;
        Path path2 = path;
        float[] fArr2 = new float[6];
        int length = lp0VarArr2.length;
        int i4 = 0;
        int i5 = 0;
        char c2 = 'm';
        while (i5 < length) {
            lp0 lp0Var3 = lp0VarArr2[i5];
            char c3 = lp0Var3.a;
            float[] fArr3 = lp0Var3.b;
            float f11 = fArr2[i4];
            float f12 = fArr2[1];
            float f13 = fArr2[2];
            float f14 = fArr2[3];
            float f15 = fArr2[4];
            int i6 = i4;
            float f16 = fArr2[5];
            switch (c3) {
                case 'A':
                case 'a':
                    i = 7;
                    break;
                case 'C':
                case 'c':
                    i = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i = 1;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i = 4;
                    break;
                case 'Z':
                case 'z':
                    path2.close();
                    path2.moveTo(f15, f16);
                    f11 = f15;
                    f13 = f11;
                    f12 = f16;
                    f14 = f12;
                default:
                    i = 2;
                    break;
            }
            float f17 = f15;
            float f18 = f16;
            float f19 = f11;
            float f20 = f12;
            int i7 = i6;
            while (i7 < fArr3.length) {
                if (c3 == 'A') {
                    fArr = fArr3;
                    i2 = i7;
                    lp0Var = lp0Var3;
                    float f21 = f19;
                    float f22 = f20;
                    i3 = i5;
                    c = c3;
                    int i8 = i2 + 5;
                    int i9 = i2 + 6;
                    a(path, f21, f22, fArr[i8], fArr[i9], fArr[i2], fArr[i2 + 1], fArr[i2 + 2], fArr[i2 + 3] != 0.0f ? 1 : i6, fArr[i2 + 4] != 0.0f ? 1 : i6);
                    f13 = fArr[i8];
                    f = fArr[i9];
                    f14 = f;
                    f2 = f13;
                } else if (c3 == 'C') {
                    fArr = fArr3;
                    i2 = i7;
                    i3 = i5;
                    lp0Var = lp0Var3;
                    c = c3;
                    int i10 = i2 + 2;
                    int i11 = i2 + 3;
                    int i12 = i2 + 4;
                    int i13 = i2 + 5;
                    path2.cubicTo(fArr[i2], fArr[i2 + 1], fArr[i10], fArr[i11], fArr[i12], fArr[i13]);
                    float f23 = fArr[i12];
                    float f24 = fArr[i13];
                    f13 = fArr[i10];
                    f14 = fArr[i11];
                    f = f24;
                    f2 = f23;
                } else if (c3 == 'H') {
                    fArr = fArr3;
                    i2 = i7;
                    lp0Var = lp0Var3;
                    c = c3;
                    f = f20;
                    i3 = i5;
                    path2.lineTo(fArr[i2], f);
                    f2 = fArr[i2];
                } else if (c3 == 'Q') {
                    fArr = fArr3;
                    i2 = i7;
                    i3 = i5;
                    lp0Var = lp0Var3;
                    c = c3;
                    int i14 = i2 + 1;
                    int i15 = i2 + 2;
                    int i16 = i2 + 3;
                    path2.quadTo(fArr[i2], fArr[i14], fArr[i15], fArr[i16]);
                    float f25 = fArr[i2];
                    float f26 = fArr[i14];
                    float f27 = fArr[i15];
                    float f28 = fArr[i16];
                    f13 = f25;
                    f14 = f26;
                    f2 = f27;
                    f = f28;
                } else if (c3 == 'V') {
                    fArr = fArr3;
                    i2 = i7;
                    i3 = i5;
                    lp0Var = lp0Var3;
                    f2 = f19;
                    c = c3;
                    path2.lineTo(f2, fArr[i2]);
                    f = fArr[i2];
                } else if (c3 != 'a') {
                    if (c3 == 'c') {
                        fArr = fArr3;
                        i2 = i7;
                        int i17 = i2 + 2;
                        int i18 = i2 + 3;
                        int i19 = i2 + 4;
                        int i20 = i2 + 5;
                        path2.rCubicTo(fArr[i2], fArr[i2 + 1], fArr[i17], fArr[i18], fArr[i19], fArr[i20]);
                        float f29 = fArr[i17] + f19;
                        float f30 = fArr[i18] + f20;
                        f19 += fArr[i19];
                        f20 += fArr[i20];
                        f13 = f29;
                        f14 = f30;
                    } else if (c3 != 'h') {
                        if (c3 != 'q') {
                            if (c3 != 'v') {
                                if (c3 == 'L') {
                                    fArr = fArr3;
                                    i2 = i7;
                                    int i21 = i2 + 1;
                                    path2.lineTo(fArr[i2], fArr[i21]);
                                    f2 = fArr[i2];
                                    f = fArr[i21];
                                } else if (c3 == 'M') {
                                    fArr = fArr3;
                                    i2 = i7;
                                    f2 = fArr[i2];
                                    f = fArr[i2 + 1];
                                    if (i2 > 0) {
                                        path2.lineTo(f2, f);
                                    } else {
                                        path2.moveTo(f2, f);
                                        f17 = f2;
                                        f18 = f;
                                    }
                                } else if (c3 != 'S') {
                                    if (c3 == 'T') {
                                        fArr = fArr3;
                                        i2 = i7;
                                        if (c2 == 'q' || c2 == 't' || c2 == 'Q' || c2 == 'T') {
                                            f19 = (f19 * 2.0f) - f13;
                                            f20 = (f20 * 2.0f) - f14;
                                        }
                                        int i22 = i2 + 1;
                                        path2.quadTo(f19, f20, fArr[i2], fArr[i22]);
                                        f2 = fArr[i2];
                                        f = fArr[i22];
                                        lp0Var = lp0Var3;
                                        f13 = f19;
                                        f14 = f20;
                                    } else if (c3 == 'l') {
                                        fArr = fArr3;
                                        i2 = i7;
                                        int i23 = i2 + 1;
                                        path2.rLineTo(fArr[i2], fArr[i23]);
                                        f19 += fArr[i2];
                                        f6 = fArr[i23];
                                    } else if (c3 == 'm') {
                                        fArr = fArr3;
                                        i2 = i7;
                                        float f31 = fArr[i2];
                                        f19 += f31;
                                        float f32 = fArr[i2 + 1];
                                        f20 += f32;
                                        if (i2 > 0) {
                                            path2.rLineTo(f31, f32);
                                        } else {
                                            path2.rMoveTo(f31, f32);
                                            lp0Var = lp0Var3;
                                            f2 = f19;
                                            f17 = f2;
                                            f = f20;
                                            f18 = f;
                                        }
                                    } else if (c3 != 's') {
                                        if (c3 != 't') {
                                            fArr = fArr3;
                                            i2 = i7;
                                            lp0Var = lp0Var3;
                                            f2 = f19;
                                        } else {
                                            if (c2 == 'q' || c2 == 't' || c2 == 'Q' || c2 == 'T') {
                                                f9 = f19 - f13;
                                                f10 = f20 - f14;
                                            } else {
                                                f10 = 0.0f;
                                                f9 = 0.0f;
                                            }
                                            int i24 = i7 + 1;
                                            path2.rQuadTo(f9, f10, fArr3[i7], fArr3[i24]);
                                            float f33 = f9 + f19;
                                            float f34 = f10 + f20;
                                            float f35 = f19 + fArr3[i7];
                                            f20 += fArr3[i24];
                                            f14 = f34;
                                            fArr = fArr3;
                                            i2 = i7;
                                            lp0Var = lp0Var3;
                                            f2 = f35;
                                            f13 = f33;
                                        }
                                        f = f20;
                                    } else {
                                        if (c2 == 'c' || c2 == 's' || c2 == 'C' || c2 == 'S') {
                                            f7 = f20 - f14;
                                            f8 = f19 - f13;
                                        } else {
                                            f8 = 0.0f;
                                            f7 = 0.0f;
                                        }
                                        int i25 = i7;
                                        int i26 = i25 + 1;
                                        int i27 = i25 + 2;
                                        int i28 = i25 + 3;
                                        fArr = fArr3;
                                        i2 = i25;
                                        path2.rCubicTo(f8, f7, fArr3[i25], fArr3[i26], fArr3[i27], fArr3[i28]);
                                        f3 = fArr[i2] + f19;
                                        f4 = fArr[i26] + f20;
                                        f19 += fArr[i27];
                                        f5 = fArr[i28];
                                    }
                                    i3 = i5;
                                    c = c3;
                                } else {
                                    fArr = fArr3;
                                    i2 = i7;
                                    if (c2 == 'c' || c2 == 's' || c2 == 'C' || c2 == 'S') {
                                        f19 = (f19 * 2.0f) - f13;
                                        f20 = (f20 * 2.0f) - f14;
                                    }
                                    float f36 = f19;
                                    float f37 = f20;
                                    int i29 = i2 + 1;
                                    int i30 = i2 + 2;
                                    int i31 = i2 + 3;
                                    path2.cubicTo(f36, f37, fArr[i2], fArr[i29], fArr[i30], fArr[i31]);
                                    f13 = fArr[i2];
                                    f14 = fArr[i29];
                                    f2 = fArr[i30];
                                    f = fArr[i31];
                                }
                                i3 = i5;
                                lp0Var = lp0Var3;
                                c = c3;
                            } else {
                                fArr = fArr3;
                                i2 = i7;
                                path2.rLineTo(0.0f, fArr[i2]);
                                f6 = fArr[i2];
                            }
                            f20 += f6;
                        } else {
                            fArr = fArr3;
                            i2 = i7;
                            int i32 = i2 + 1;
                            int i33 = i2 + 2;
                            int i34 = i2 + 3;
                            path2.rQuadTo(fArr[i2], fArr[i32], fArr[i33], fArr[i34]);
                            f3 = fArr[i2] + f19;
                            f4 = fArr[i32] + f20;
                            f19 += fArr[i33];
                            f5 = fArr[i34];
                        }
                        f20 += f5;
                        f13 = f3;
                        f14 = f4;
                    } else {
                        fArr = fArr3;
                        i2 = i7;
                        path2.rLineTo(fArr[i2], 0.0f);
                        f19 += fArr[i2];
                    }
                    lp0Var = lp0Var3;
                    f2 = f19;
                    f = f20;
                    i3 = i5;
                    c = c3;
                } else {
                    fArr = fArr3;
                    i2 = i7;
                    int i35 = i2 + 5;
                    float f38 = fArr[i35] + f19;
                    int i36 = i2 + 6;
                    float f39 = fArr[i36] + f20;
                    float f40 = fArr[i2];
                    float f41 = fArr[i2 + 1];
                    float f42 = fArr[i2 + 2];
                    if (fArr[i2 + 3] != 0.0f) {
                        lp0Var2 = lp0Var3;
                        z = 1;
                    } else {
                        lp0Var2 = lp0Var3;
                        z = i6;
                    }
                    lp0Var = lp0Var2;
                    float f43 = f19;
                    c = c3;
                    float f44 = f20;
                    i3 = i5;
                    a(path, f43, f44, f38, f39, f40, f41, f42, z, fArr[i2 + 4] != 0.0f ? 1 : i6);
                    f2 = f43 + fArr[i35];
                    f = f44 + fArr[i36];
                    f13 = f2;
                    f14 = f;
                }
                i7 = i2 + i;
                path2 = path;
                lp0Var3 = lp0Var;
                c3 = c;
                i5 = i3;
                f19 = f2;
                f20 = f;
                c2 = c3;
                fArr3 = fArr;
            }
            fArr2[i6] = f19;
            fArr2[1] = f20;
            fArr2[2] = f13;
            fArr2[3] = f14;
            fArr2[4] = f17;
            fArr2[5] = f18;
            c2 = lp0Var3.a;
            i5++;
            lp0VarArr2 = lp0VarArr;
            path2 = path;
            i4 = i6;
        }
    }

    public lp0(char c, float[] fArr) {
        this.a = c;
        this.b = fArr;
    }
}
