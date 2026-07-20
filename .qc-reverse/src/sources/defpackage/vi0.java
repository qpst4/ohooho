package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class vi0 implements Cloneable {
    public /* synthetic */ boolean b;
    public /* synthetic */ long[] c;
    public /* synthetic */ Object[] d;
    public /* synthetic */ int e;

    public vi0() {
        int i;
        int i2 = 4;
        while (true) {
            i = 80;
            if (i2 >= 32) {
                break;
            }
            int i3 = (1 << i2) - 12;
            if (80 <= i3) {
                i = i3;
                break;
            }
            i2++;
        }
        int i4 = i / 8;
        this.c = new long[i4];
        this.d = new Object[i4];
    }

    public final void a() {
        int i = this.e;
        Object[] objArr = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.e = 0;
        this.b = false;
    }

    public final Object b(long j) {
        Object obj;
        int iF = f01.f(this.c, this.e, j);
        if (iF < 0 || (obj = this.d[iF]) == tk0.f) {
            return null;
        }
        return obj;
    }

    public final long c(int i) {
        int i2;
        if (i < 0 || i >= (i2 = this.e)) {
            throw new IllegalArgumentException(qq0.i("Expected index to be within 0..size()-1, but was ", i).toString());
        }
        if (this.b) {
            long[] jArr = this.c;
            Object[] objArr = this.d;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                Object obj = objArr[i4];
                if (obj != tk0.f) {
                    if (i4 != i3) {
                        jArr[i3] = jArr[i4];
                        objArr[i3] = obj;
                        objArr[i4] = null;
                    }
                    i3++;
                }
            }
            this.b = false;
            this.e = i3;
        }
        return this.c[i];
    }

    public final Object clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        objClone.getClass();
        vi0 vi0Var = (vi0) objClone;
        vi0Var.c = (long[]) this.c.clone();
        vi0Var.d = (Object[]) this.d.clone();
        return vi0Var;
    }

    public final void d(long j, Object obj) {
        Object obj2 = tk0.f;
        int iF = f01.f(this.c, this.e, j);
        if (iF >= 0) {
            this.d[iF] = obj;
            return;
        }
        int i = ~iF;
        int i2 = this.e;
        if (i < i2) {
            Object[] objArr = this.d;
            if (objArr[i] == obj2) {
                this.c[i] = j;
                objArr[i] = obj;
                return;
            }
        }
        if (this.b) {
            long[] jArr = this.c;
            if (i2 >= jArr.length) {
                Object[] objArr2 = this.d;
                int i3 = 0;
                for (int i4 = 0; i4 < i2; i4++) {
                    Object obj3 = objArr2[i4];
                    if (obj3 != obj2) {
                        if (i4 != i3) {
                            jArr[i3] = jArr[i4];
                            objArr2[i3] = obj3;
                            objArr2[i4] = null;
                        }
                        i3++;
                    }
                }
                this.b = false;
                this.e = i3;
                i = ~f01.f(this.c, i3, j);
            }
        }
        int i5 = this.e;
        if (i5 >= this.c.length) {
            int i6 = (i5 + 1) * 8;
            int i7 = 4;
            while (true) {
                if (i7 >= 32) {
                    break;
                }
                int i8 = (1 << i7) - 12;
                if (i6 <= i8) {
                    i6 = i8;
                    break;
                }
                i7++;
            }
            int i9 = i6 / 8;
            this.c = Arrays.copyOf(this.c, i9);
            this.d = Arrays.copyOf(this.d, i9);
        }
        int i10 = this.e - i;
        if (i10 != 0) {
            long[] jArr2 = this.c;
            int i11 = i + 1;
            jArr2.getClass();
            System.arraycopy(jArr2, i, jArr2, i11, i10);
            Object[] objArr3 = this.d;
            pb.f0(i11, i, this.e, objArr3, objArr3);
        }
        this.c[i] = j;
        this.d[i] = obj;
        this.e++;
    }

    public final int e() {
        if (this.b) {
            int i = this.e;
            long[] jArr = this.c;
            Object[] objArr = this.d;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                Object obj = objArr[i3];
                if (obj != tk0.f) {
                    if (i3 != i2) {
                        jArr[i2] = jArr[i3];
                        objArr[i2] = obj;
                        objArr[i3] = null;
                    }
                    i2++;
                }
            }
            this.b = false;
            this.e = i2;
        }
        return this.e;
    }

    public final Object f(int i) {
        int i2;
        if (i < 0 || i >= (i2 = this.e)) {
            throw new IllegalArgumentException(qq0.i("Expected index to be within 0..size()-1, but was ", i).toString());
        }
        if (this.b) {
            long[] jArr = this.c;
            Object[] objArr = this.d;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                Object obj = objArr[i4];
                if (obj != tk0.f) {
                    if (i4 != i3) {
                        jArr[i3] = jArr[i4];
                        objArr[i3] = obj;
                        objArr[i4] = null;
                    }
                    i3++;
                }
            }
            this.b = false;
            this.e = i3;
        }
        return this.d[i];
    }

    public final String toString() {
        if (e() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.e * 28);
        sb.append('{');
        int i = this.e;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(c(i2));
            sb.append('=');
            Object objF = f(i2);
            if (objF != sb) {
                sb.append(objF);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
