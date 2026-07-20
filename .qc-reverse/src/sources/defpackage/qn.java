package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class qn {
    public static final SparseIntArray p0;
    public int A;
    public float B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public float T;
    public float U;
    public int V;
    public int W;
    public int X;
    public int Y;
    public int Z;
    public boolean a;
    public int a0;
    public int b;
    public int b0;
    public int c;
    public int c0;
    public int d;
    public float d0;
    public int e;
    public float e0;
    public float f;
    public int f0;
    public boolean g;
    public int g0;
    public int h;
    public int h0;
    public int i;
    public int[] i0;
    public int j;
    public String j0;
    public int k;
    public String k0;
    public int l;
    public boolean l0;
    public int m;
    public boolean m0;
    public int n;
    public boolean n0;
    public int o;
    public int o0;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public float w;
    public float x;
    public String y;
    public int z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p0 = sparseIntArray;
        sparseIntArray.append(43, 24);
        sparseIntArray.append(44, 25);
        sparseIntArray.append(46, 28);
        sparseIntArray.append(47, 29);
        sparseIntArray.append(52, 35);
        sparseIntArray.append(51, 34);
        sparseIntArray.append(24, 4);
        sparseIntArray.append(23, 3);
        sparseIntArray.append(19, 1);
        sparseIntArray.append(61, 6);
        sparseIntArray.append(62, 7);
        sparseIntArray.append(31, 17);
        sparseIntArray.append(32, 18);
        sparseIntArray.append(33, 19);
        sparseIntArray.append(15, 90);
        sparseIntArray.append(0, 26);
        sparseIntArray.append(48, 31);
        sparseIntArray.append(49, 32);
        sparseIntArray.append(30, 10);
        sparseIntArray.append(29, 9);
        sparseIntArray.append(66, 13);
        sparseIntArray.append(69, 16);
        sparseIntArray.append(67, 14);
        sparseIntArray.append(64, 11);
        sparseIntArray.append(68, 15);
        sparseIntArray.append(65, 12);
        sparseIntArray.append(55, 38);
        sparseIntArray.append(41, 37);
        sparseIntArray.append(40, 39);
        sparseIntArray.append(54, 40);
        sparseIntArray.append(39, 20);
        sparseIntArray.append(53, 36);
        sparseIntArray.append(28, 5);
        sparseIntArray.append(42, 91);
        sparseIntArray.append(50, 91);
        sparseIntArray.append(45, 91);
        sparseIntArray.append(22, 91);
        sparseIntArray.append(18, 91);
        sparseIntArray.append(3, 23);
        sparseIntArray.append(5, 27);
        sparseIntArray.append(7, 30);
        sparseIntArray.append(8, 8);
        sparseIntArray.append(4, 33);
        sparseIntArray.append(6, 2);
        sparseIntArray.append(1, 22);
        sparseIntArray.append(2, 21);
        sparseIntArray.append(56, 41);
        sparseIntArray.append(34, 42);
        sparseIntArray.append(17, 87);
        sparseIntArray.append(16, 88);
        sparseIntArray.append(71, 76);
        sparseIntArray.append(25, 61);
        sparseIntArray.append(27, 62);
        sparseIntArray.append(26, 63);
        sparseIntArray.append(60, 69);
        sparseIntArray.append(38, 70);
        sparseIntArray.append(12, 71);
        sparseIntArray.append(10, 72);
        sparseIntArray.append(11, 73);
        sparseIntArray.append(13, 74);
        sparseIntArray.append(9, 75);
        sparseIntArray.append(58, 84);
        sparseIntArray.append(59, 86);
        sparseIntArray.append(58, 83);
        sparseIntArray.append(37, 85);
        sparseIntArray.append(56, 87);
        sparseIntArray.append(34, 88);
        sparseIntArray.append(91, 89);
        sparseIntArray.append(15, 90);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, rs0.e);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            SparseIntArray sparseIntArray = p0;
            int i2 = sparseIntArray.get(index);
            switch (i2) {
                case 1:
                    this.p = un.f(typedArrayObtainStyledAttributes, index, this.p);
                    break;
                case 2:
                    this.I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.I);
                    break;
                case 3:
                    this.o = un.f(typedArrayObtainStyledAttributes, index, this.o);
                    break;
                case 4:
                    this.n = un.f(typedArrayObtainStyledAttributes, index, this.n);
                    break;
                case 5:
                    this.y = typedArrayObtainStyledAttributes.getString(index);
                    break;
                case 6:
                    this.C = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.C);
                    break;
                case 7:
                    this.D = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.D);
                    break;
                case 8:
                    this.J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.J);
                    break;
                case 9:
                    this.v = un.f(typedArrayObtainStyledAttributes, index, this.v);
                    break;
                case 10:
                    this.u = un.f(typedArrayObtainStyledAttributes, index, this.u);
                    break;
                case 11:
                    this.P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.P);
                    break;
                case 12:
                    this.Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.Q);
                    break;
                case 13:
                    this.M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.M);
                    break;
                case 14:
                    this.O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.O);
                    break;
                case 15:
                    this.R = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.R);
                    break;
                case 16:
                    this.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.N);
                    break;
                case 17:
                    this.d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.d);
                    break;
                case 18:
                    this.e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.e);
                    break;
                case 19:
                    this.f = typedArrayObtainStyledAttributes.getFloat(index, this.f);
                    break;
                case 20:
                    this.w = typedArrayObtainStyledAttributes.getFloat(index, this.w);
                    break;
                case 21:
                    this.c = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.c);
                    break;
                case 22:
                    this.b = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.b);
                    break;
                case 23:
                    this.F = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.F);
                    break;
                case 24:
                    this.h = un.f(typedArrayObtainStyledAttributes, index, this.h);
                    break;
                case 25:
                    this.i = un.f(typedArrayObtainStyledAttributes, index, this.i);
                    break;
                case 26:
                    this.E = typedArrayObtainStyledAttributes.getInt(index, this.E);
                    break;
                case 27:
                    this.G = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.G);
                    break;
                case 28:
                    this.j = un.f(typedArrayObtainStyledAttributes, index, this.j);
                    break;
                case 29:
                    this.k = un.f(typedArrayObtainStyledAttributes, index, this.k);
                    break;
                case 30:
                    this.K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.K);
                    break;
                case 31:
                    this.s = un.f(typedArrayObtainStyledAttributes, index, this.s);
                    break;
                case 32:
                    this.t = un.f(typedArrayObtainStyledAttributes, index, this.t);
                    break;
                case 33:
                    this.H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.H);
                    break;
                case 34:
                    this.m = un.f(typedArrayObtainStyledAttributes, index, this.m);
                    break;
                case 35:
                    this.l = un.f(typedArrayObtainStyledAttributes, index, this.l);
                    break;
                case 36:
                    this.x = typedArrayObtainStyledAttributes.getFloat(index, this.x);
                    break;
                case 37:
                    this.U = typedArrayObtainStyledAttributes.getFloat(index, this.U);
                    break;
                case 38:
                    this.T = typedArrayObtainStyledAttributes.getFloat(index, this.T);
                    break;
                case 39:
                    this.V = typedArrayObtainStyledAttributes.getInt(index, this.V);
                    break;
                case 40:
                    this.W = typedArrayObtainStyledAttributes.getInt(index, this.W);
                    break;
                case 41:
                    un.g(this, typedArrayObtainStyledAttributes, index, 0);
                    break;
                case 42:
                    un.g(this, typedArrayObtainStyledAttributes, index, 1);
                    break;
                default:
                    switch (i2) {
                        case 61:
                            this.z = un.f(typedArrayObtainStyledAttributes, index, this.z);
                            break;
                        case 62:
                            this.A = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.A);
                            break;
                        case 63:
                            this.B = typedArrayObtainStyledAttributes.getFloat(index, this.B);
                            break;
                        default:
                            switch (i2) {
                                case 69:
                                    this.d0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                    break;
                                case 70:
                                    this.e0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                    break;
                                case 71:
                                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                    break;
                                case 72:
                                    this.f0 = typedArrayObtainStyledAttributes.getInt(index, this.f0);
                                    break;
                                case 73:
                                    this.g0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.g0);
                                    break;
                                case 74:
                                    this.j0 = typedArrayObtainStyledAttributes.getString(index);
                                    break;
                                case 75:
                                    this.n0 = typedArrayObtainStyledAttributes.getBoolean(index, this.n0);
                                    break;
                                case 76:
                                    this.o0 = typedArrayObtainStyledAttributes.getInt(index, this.o0);
                                    break;
                                case 77:
                                    this.q = un.f(typedArrayObtainStyledAttributes, index, this.q);
                                    break;
                                case 78:
                                    this.r = un.f(typedArrayObtainStyledAttributes, index, this.r);
                                    break;
                                case 79:
                                    this.S = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.S);
                                    break;
                                case 80:
                                    this.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.L);
                                    break;
                                case 81:
                                    this.X = typedArrayObtainStyledAttributes.getInt(index, this.X);
                                    break;
                                case 82:
                                    this.Y = typedArrayObtainStyledAttributes.getInt(index, this.Y);
                                    break;
                                case 83:
                                    this.a0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.a0);
                                    break;
                                case 84:
                                    this.Z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.Z);
                                    break;
                                case 85:
                                    this.c0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.c0);
                                    break;
                                case 86:
                                    this.b0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.b0);
                                    break;
                                case 87:
                                    this.l0 = typedArrayObtainStyledAttributes.getBoolean(index, this.l0);
                                    break;
                                case 88:
                                    this.m0 = typedArrayObtainStyledAttributes.getBoolean(index, this.m0);
                                    break;
                                case 89:
                                    this.k0 = typedArrayObtainStyledAttributes.getString(index);
                                    break;
                                case 90:
                                    this.g = typedArrayObtainStyledAttributes.getBoolean(index, this.g);
                                    break;
                                case 91:
                                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                                    break;
                                default:
                                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                                    break;
                            }
                            break;
                    }
                    break;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
