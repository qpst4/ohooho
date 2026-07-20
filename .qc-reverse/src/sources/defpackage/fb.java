package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class fb {
    public final lb b;
    public final ra c;
    public int a = 0;
    public int d = 8;
    public int[] e = new int[8];
    public int[] f = new int[8];
    public float[] g = new float[8];
    public int h = -1;
    public int i = -1;
    public boolean j = false;

    public fb(lb lbVar, ra raVar) {
        this.b = lbVar;
        this.c = raVar;
    }

    public final void a(m11 m11Var, float f, boolean z) {
        if (f <= -0.001f || f >= 0.001f) {
            int i = this.h;
            lb lbVar = this.b;
            if (i == -1) {
                this.h = 0;
                this.g[0] = f;
                this.e[0] = m11Var.c;
                this.f[0] = -1;
                m11Var.l++;
                m11Var.a(lbVar);
                this.a++;
                if (this.j) {
                    return;
                }
                int i2 = this.i + 1;
                this.i = i2;
                int[] iArr = this.e;
                if (i2 >= iArr.length) {
                    this.j = true;
                    this.i = iArr.length - 1;
                    return;
                }
                return;
            }
            int i3 = -1;
            for (int i4 = 0; i != -1 && i4 < this.a; i4++) {
                int i5 = this.e[i];
                int i6 = m11Var.c;
                if (i5 == i6) {
                    float[] fArr = this.g;
                    float f2 = fArr[i] + f;
                    if (f2 > -0.001f && f2 < 0.001f) {
                        f2 = 0.0f;
                    }
                    fArr[i] = f2;
                    if (f2 == 0.0f) {
                        int i7 = this.h;
                        int[] iArr2 = this.f;
                        if (i == i7) {
                            this.h = iArr2[i];
                        } else {
                            iArr2[i3] = iArr2[i];
                        }
                        if (z) {
                            m11Var.b(lbVar);
                        }
                        if (this.j) {
                            this.i = i;
                        }
                        m11Var.l--;
                        this.a--;
                        return;
                    }
                    return;
                }
                if (i5 < i6) {
                    i3 = i;
                }
                i = this.f[i];
            }
            int length = this.i;
            int i8 = length + 1;
            if (this.j) {
                int[] iArr3 = this.e;
                if (iArr3[length] != -1) {
                    length = iArr3.length;
                }
            } else {
                length = i8;
            }
            int[] iArr4 = this.e;
            if (length >= iArr4.length && this.a < iArr4.length) {
                int i9 = 0;
                while (true) {
                    int[] iArr5 = this.e;
                    if (i9 >= iArr5.length) {
                        break;
                    }
                    if (iArr5[i9] == -1) {
                        length = i9;
                        break;
                    }
                    i9++;
                }
            }
            int[] iArr6 = this.e;
            if (length >= iArr6.length) {
                length = iArr6.length;
                int i10 = this.d * 2;
                this.d = i10;
                this.j = false;
                this.i = length - 1;
                this.g = Arrays.copyOf(this.g, i10);
                this.e = Arrays.copyOf(this.e, this.d);
                this.f = Arrays.copyOf(this.f, this.d);
            }
            this.e[length] = m11Var.c;
            this.g[length] = f;
            int[] iArr7 = this.f;
            if (i3 != -1) {
                iArr7[length] = iArr7[i3];
                iArr7[i3] = length;
            } else {
                iArr7[length] = this.h;
                this.h = length;
            }
            m11Var.l++;
            m11Var.a(lbVar);
            this.a++;
            if (!this.j) {
                this.i++;
            }
            int i11 = this.i;
            int[] iArr8 = this.e;
            if (i11 >= iArr8.length) {
                this.j = true;
                this.i = iArr8.length - 1;
            }
        }
    }

    public final void b() {
        int i = this.h;
        for (int i2 = 0; i != -1 && i2 < this.a; i2++) {
            m11 m11Var = ((m11[]) this.c.e)[this.e[i]];
            if (m11Var != null) {
                m11Var.b(this.b);
            }
            i = this.f[i];
        }
        this.h = -1;
        this.i = -1;
        this.j = false;
        this.a = 0;
    }

    public final float c(m11 m11Var) {
        int i = this.h;
        for (int i2 = 0; i != -1 && i2 < this.a; i2++) {
            if (this.e[i] == m11Var.c) {
                return this.g[i];
            }
            i = this.f[i];
        }
        return 0.0f;
    }

    public final int d() {
        return this.a;
    }

    public final m11 e(int i) {
        int i2 = this.h;
        for (int i3 = 0; i2 != -1 && i3 < this.a; i3++) {
            if (i3 == i) {
                return ((m11[]) this.c.e)[this.e[i2]];
            }
            i2 = this.f[i2];
        }
        return null;
    }

    public final float f(int i) {
        int i2 = this.h;
        for (int i3 = 0; i2 != -1 && i3 < this.a; i3++) {
            if (i3 == i) {
                return this.g[i2];
            }
            i2 = this.f[i2];
        }
        return 0.0f;
    }

    public final void g(m11 m11Var, float f) {
        if (f == 0.0f) {
            h(m11Var, true);
            return;
        }
        int i = this.h;
        lb lbVar = this.b;
        if (i == -1) {
            this.h = 0;
            this.g[0] = f;
            this.e[0] = m11Var.c;
            this.f[0] = -1;
            m11Var.l++;
            m11Var.a(lbVar);
            this.a++;
            if (this.j) {
                return;
            }
            int i2 = this.i + 1;
            this.i = i2;
            int[] iArr = this.e;
            if (i2 >= iArr.length) {
                this.j = true;
                this.i = iArr.length - 1;
                return;
            }
            return;
        }
        int i3 = -1;
        for (int i4 = 0; i != -1 && i4 < this.a; i4++) {
            int i5 = this.e[i];
            int i6 = m11Var.c;
            if (i5 == i6) {
                this.g[i] = f;
                return;
            }
            if (i5 < i6) {
                i3 = i;
            }
            i = this.f[i];
        }
        int length = this.i;
        int i7 = length + 1;
        if (this.j) {
            int[] iArr2 = this.e;
            if (iArr2[length] != -1) {
                length = iArr2.length;
            }
        } else {
            length = i7;
        }
        int[] iArr3 = this.e;
        if (length >= iArr3.length && this.a < iArr3.length) {
            int i8 = 0;
            while (true) {
                int[] iArr4 = this.e;
                if (i8 >= iArr4.length) {
                    break;
                }
                if (iArr4[i8] == -1) {
                    length = i8;
                    break;
                }
                i8++;
            }
        }
        int[] iArr5 = this.e;
        if (length >= iArr5.length) {
            length = iArr5.length;
            int i9 = this.d * 2;
            this.d = i9;
            this.j = false;
            this.i = length - 1;
            this.g = Arrays.copyOf(this.g, i9);
            this.e = Arrays.copyOf(this.e, this.d);
            this.f = Arrays.copyOf(this.f, this.d);
        }
        this.e[length] = m11Var.c;
        this.g[length] = f;
        int[] iArr6 = this.f;
        if (i3 != -1) {
            iArr6[length] = iArr6[i3];
            iArr6[i3] = length;
        } else {
            iArr6[length] = this.h;
            this.h = length;
        }
        m11Var.l++;
        m11Var.a(lbVar);
        int i10 = this.a + 1;
        this.a = i10;
        if (!this.j) {
            this.i++;
        }
        int[] iArr7 = this.e;
        if (i10 >= iArr7.length) {
            this.j = true;
        }
        if (this.i >= iArr7.length) {
            this.j = true;
            this.i = iArr7.length - 1;
        }
    }

    public final float h(m11 m11Var, boolean z) {
        int i = this.h;
        if (i == -1) {
            return 0.0f;
        }
        int i2 = 0;
        int i3 = -1;
        while (i != -1 && i2 < this.a) {
            if (this.e[i] == m11Var.c) {
                int i4 = this.h;
                int[] iArr = this.f;
                if (i == i4) {
                    this.h = iArr[i];
                } else {
                    iArr[i3] = iArr[i];
                }
                if (z) {
                    m11Var.b(this.b);
                }
                m11Var.l--;
                this.a--;
                this.e[i] = -1;
                if (this.j) {
                    this.i = i;
                }
                return this.g[i];
            }
            i2++;
            i3 = i;
            i = this.f[i];
        }
        return 0.0f;
    }

    public final String toString() {
        int i = this.h;
        String string = "";
        for (int i2 = 0; i != -1 && i2 < this.a; i2++) {
            StringBuilder sbL = l11.l(string.concat(" -> "));
            sbL.append(this.g[i]);
            sbL.append(" : ");
            StringBuilder sbL2 = l11.l(sbL.toString());
            sbL2.append(((m11[]) this.c.e)[this.e[i]]);
            string = sbL2.toString();
            i = this.f[i];
        }
        return string;
    }
}
