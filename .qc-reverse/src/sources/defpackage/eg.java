package defpackage;

import android.graphics.Bitmap;
import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class eg {
    public int a;
    public boolean b;
    public boolean c;
    public final Object d;

    public eg(Bitmap bitmap, int i, boolean z, boolean z2) {
        this.d = bitmap;
        this.a = i;
        this.b = z;
        this.c = z2;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.Serializable, java.lang.String[]] */
    public an a(SSLSocket sSLSocket) throws UnknownServiceException {
        boolean z;
        an anVar;
        int i = this.a;
        List list = (List) this.d;
        int size = list.size();
        while (true) {
            z = true;
            if (i >= size) {
                anVar = null;
                break;
            }
            anVar = (an) list.get(i);
            if (anVar.a(sSLSocket)) {
                this.a = i + 1;
                break;
            }
            i++;
        }
        if (anVar == null) {
            StringBuilder sb = new StringBuilder("Unable to find acceptable protocols. isFallback=");
            sb.append(this.c);
            sb.append(", modes=");
            sb.append(list);
            String string = Arrays.toString(sSLSocket.getEnabledProtocols());
            sb.append(", supported protocols=");
            sb.append(string);
            throw new UnknownServiceException(sb.toString());
        }
        int i2 = this.a;
        while (true) {
            if (i2 >= list.size()) {
                z = false;
                break;
            }
            if (((an) list.get(i2)).a(sSLSocket)) {
                break;
            }
            i2++;
        }
        this.b = z;
        c70 c70Var = c70.l;
        boolean z2 = this.c;
        c70Var.getClass();
        ?? r0 = anVar.d;
        String[] strArr = anVar.c;
        String[] strArrL = strArr != null ? be1.l(jk.b, sSLSocket.getEnabledCipherSuites(), strArr) : sSLSocket.getEnabledCipherSuites();
        String[] strArrL2 = r0 != 0 ? be1.l(be1.f, sSLSocket.getEnabledProtocols(), r0) : sSLSocket.getEnabledProtocols();
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        ik ikVar = jk.b;
        byte[] bArr = be1.a;
        int length = supportedCipherSuites.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                i3 = -1;
                break;
            }
            if (ikVar.compare(supportedCipherSuites[i3], "TLS_FALLBACK_SCSV") == 0) {
                break;
            }
            i3++;
        }
        if (z2 && i3 != -1) {
            String str = supportedCipherSuites[i3];
            int length2 = strArrL.length;
            String[] strArr2 = new String[length2 + 1];
            System.arraycopy(strArrL, 0, strArr2, 0, strArrL.length);
            strArr2[length2] = str;
            strArrL = strArr2;
        }
        zm zmVar = new zm();
        zmVar.a = anVar.a;
        zmVar.c = strArr;
        zmVar.d = r0;
        zmVar.b = anVar.b;
        zmVar.b(strArrL);
        zmVar.d(strArrL2);
        an anVar2 = new an(zmVar);
        String[] strArr3 = anVar2.d;
        if (strArr3 != null) {
            sSLSocket.setEnabledProtocols(strArr3);
        }
        String[] strArr4 = anVar2.c;
        if (strArr4 != null) {
            sSLSocket.setEnabledCipherSuites(strArr4);
        }
        return anVar;
    }

    public eg(List list) {
        this.a = 0;
        this.d = list;
    }
}
