package defpackage;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class yi {
    public static final yi c = new yi(new LinkedHashSet(new ArrayList()), null);
    public final LinkedHashSet a;
    public final i1 b;

    public yi(LinkedHashSet linkedHashSet, i1 i1Var) {
        this.a = linkedHashSet;
        this.b = i1Var;
    }

    public static String b(X509Certificate x509Certificate) {
        if (x509Certificate == null) {
            zy.n("Certificate pinning requires X509 certificates");
            return null;
        }
        StringBuilder sb = new StringBuilder("sha256/");
        try {
            byte[] bArr = ai.f(MessageDigest.getInstance("SHA-256").digest(ai.f(x509Certificate.getPublicKey().getEncoded()).b)).b;
            byte[] bArr2 = fc0.a;
            byte[] bArr3 = new byte[((bArr.length + 2) / 3) * 4];
            int length = bArr.length - (bArr.length % 3);
            int i = 0;
            for (int i2 = 0; i2 < length; i2 += 3) {
                bArr3[i] = bArr2[(bArr[i2] & 255) >> 2];
                int i3 = i2 + 1;
                bArr3[i + 1] = bArr2[((bArr[i2] & 3) << 4) | ((bArr[i3] & 255) >> 4)];
                int i4 = i + 3;
                int i5 = (bArr[i3] & 15) << 2;
                int i6 = i2 + 2;
                bArr3[i + 2] = bArr2[i5 | ((bArr[i6] & 255) >> 6)];
                i += 4;
                bArr3[i4] = bArr2[bArr[i6] & 63];
            }
            int length2 = bArr.length % 3;
            if (length2 == 1) {
                bArr3[i] = bArr2[(bArr[length] & 255) >> 2];
                bArr3[i + 1] = bArr2[(bArr[length] & 3) << 4];
                bArr3[i + 2] = 61;
                bArr3[i + 3] = 61;
            } else if (length2 == 2) {
                bArr3[i] = bArr2[(bArr[length] & 255) >> 2];
                int i7 = (bArr[length] & 3) << 4;
                int i8 = length + 1;
                bArr3[i + 1] = bArr2[((bArr[i8] & 255) >> 4) | i7];
                bArr3[i + 2] = bArr2[(bArr[i8] & 15) << 2];
                bArr3[i + 3] = 61;
            }
            try {
                sb.append(new String(bArr3, "US-ASCII"));
                return sb.toString();
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    public final void a(String str, List list) {
        List list2 = Collections.EMPTY_LIST;
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            throw l11.h(it);
        }
        if (list2.isEmpty()) {
            return;
        }
        i1 i1Var = this.b;
        if (i1Var != null) {
            list = i1Var.h(str, list);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list2.size() > 0) {
                list2.get(0).getClass();
                s1.d();
                return;
            }
        }
        StringBuilder sb = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
        int size2 = list.size();
        for (int i2 = 0; i2 < size2; i2++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i2);
            sb.append("\n    ");
            sb.append(b(x509Certificate));
            sb.append(": ");
            sb.append(x509Certificate.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        int size3 = list2.size();
        for (int i3 = 0; i3 < size3; i3++) {
            if (list2.get(i3) != null) {
                s1.d();
                return;
            }
            sb.append("\n    null");
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof yi)) {
            return false;
        }
        yi yiVar = (yi) obj;
        return be1.i(this.b, yiVar.b) && this.a.equals(yiVar.a);
    }

    public final int hashCode() {
        i1 i1Var = this.b;
        return this.a.hashCode() + ((i1Var != null ? i1Var.hashCode() : 0) * 31);
    }
}
