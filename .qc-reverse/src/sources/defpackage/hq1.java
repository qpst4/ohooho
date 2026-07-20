package defpackage;

import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class hq1 extends kj1 implements IInterface {
    public final int c;

    public hq1(byte[] bArr) {
        super("com.google.android.gms.common.internal.ICertData");
        if (bArr.length != 25) {
            throw new IllegalArgumentException();
        }
        this.c = Arrays.hashCode(bArr);
    }

    public static byte[] e(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    @Override // defpackage.kj1
    public final boolean d(int i, Parcel parcel, Parcel parcel2) {
        if (i != 1) {
            if (i != 2) {
                return false;
            }
            parcel2.writeNoException();
            parcel2.writeInt(this.c);
            return true;
        }
        on0 on0Var = new on0(f());
        parcel2.writeNoException();
        int i2 = pl1.a;
        parcel2.writeStrongBinder(on0Var);
        return true;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof hq1)) {
            try {
                hq1 hq1Var = (hq1) obj;
                if (hq1Var.c == this.c) {
                    return Arrays.equals(f(), (byte[]) new on0(hq1Var.f()).c);
                }
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            }
        }
        return false;
    }

    public abstract byte[] f();

    public final int hashCode() {
        return this.c;
    }
}
