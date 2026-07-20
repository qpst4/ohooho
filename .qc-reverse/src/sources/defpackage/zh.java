package defpackage;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class zh implements Iterable, Serializable {
    public static final zh d = new zh(ec0.b);
    public static final yh e;
    public int b = 0;
    public final byte[] c;

    static {
        yh c70Var;
        int i = 9;
        try {
            Class.forName("android.content.Context");
            c70Var = new ow0(i);
        } catch (ClassNotFoundException unused) {
            c70Var = new c70(i);
        }
        e = c70Var;
    }

    public zh(byte[] bArr) {
        this.c = bArr;
    }

    public static zh c(byte[] bArr, int i, int i2) {
        return new zh(e.a(bArr, i, i2));
    }

    public byte b(int i) {
        return this.c[i];
    }

    public int d() {
        return 0;
    }

    public final byte[] e() {
        int size = size();
        if (size == 0) {
            return ec0.b;
        }
        byte[] bArr = new byte[size];
        System.arraycopy(this.c, 0, bArr, 0, size);
        return bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zh) || size() != ((zh) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zh)) {
            return obj.equals(this);
        }
        zh zhVar = (zh) obj;
        int i = this.b;
        int i2 = zhVar.b;
        if (i != 0 && i2 != 0 && i != i2) {
            return false;
        }
        int size = size();
        if (size > zhVar.size()) {
            throw new IllegalArgumentException("Length too large: " + size + size());
        }
        if (size > zhVar.size()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + size + ", " + zhVar.size());
        }
        byte[] bArr = zhVar.c;
        int iD = d() + size;
        int iD2 = d();
        int iD3 = zhVar.d();
        while (iD2 < iD) {
            if (this.c[iD2] != bArr[iD3]) {
                return false;
            }
            iD2++;
            iD3++;
        }
        return true;
    }

    public final int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int size = size();
        int iD = d();
        Charset charset = ec0.a;
        int i2 = size;
        for (int i3 = iD; i3 < iD + size; i3++) {
            i2 = (i2 * 31) + this.c[i3];
        }
        if (i2 == 0) {
            i2 = 1;
        }
        this.b = i2;
        return i2;
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new xh(this);
    }

    public int size() {
        return this.c.length;
    }

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }
}
