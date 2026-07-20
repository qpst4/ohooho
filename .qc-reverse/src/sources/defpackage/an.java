package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class an {
    public static final an e;
    public static final an f;
    public final boolean a;
    public final boolean b;
    public final String[] c;
    public final String[] d;

    static {
        jk jkVar = jk.q;
        jk jkVar2 = jk.r;
        jk jkVar3 = jk.s;
        jk jkVar4 = jk.t;
        jk jkVar5 = jk.u;
        jk jkVar6 = jk.k;
        jk jkVar7 = jk.m;
        jk jkVar8 = jk.l;
        jk jkVar9 = jk.n;
        jk jkVar10 = jk.p;
        jk jkVar11 = jk.o;
        jk[] jkVarArr = {jkVar, jkVar2, jkVar3, jkVar4, jkVar5, jkVar6, jkVar7, jkVar8, jkVar9, jkVar10, jkVar11};
        jk[] jkVarArr2 = {jkVar, jkVar2, jkVar3, jkVar4, jkVar5, jkVar6, jkVar7, jkVar8, jkVar9, jkVar10, jkVar11, jk.i, jk.j, jk.g, jk.h, jk.e, jk.f, jk.d};
        zm zmVar = new zm(true);
        zmVar.a(jkVarArr);
        g61 g61Var = g61.c;
        g61 g61Var2 = g61.d;
        zmVar.c(g61Var, g61Var2);
        zmVar.b = true;
        zm zmVar2 = new zm(true);
        zmVar2.a(jkVarArr2);
        g61 g61Var3 = g61.e;
        g61 g61Var4 = g61.f;
        zmVar2.c(g61Var, g61Var2, g61Var3, g61Var4);
        zmVar2.b = true;
        e = new an(zmVar2);
        zm zmVar3 = new zm(true);
        zmVar3.a(jkVarArr2);
        zmVar3.c(g61Var4);
        zmVar3.b = true;
        f = new an(new zm(false));
    }

    public an(zm zmVar) {
        this.a = zmVar.a;
        this.c = (String[]) zmVar.c;
        this.d = (String[]) zmVar.d;
        this.b = zmVar.b;
    }

    public final boolean a(SSLSocket sSLSocket) {
        if (!this.a) {
            return false;
        }
        String[] strArr = this.d;
        if (strArr != null && !be1.n(be1.f, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.c;
        return strArr2 == null || be1.n(jk.b, strArr2, sSLSocket.getEnabledCipherSuites());
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof an)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        an anVar = (an) obj;
        boolean z = anVar.a;
        boolean z2 = this.a;
        if (z2 != z) {
            return false;
        }
        if (z2) {
            return Arrays.equals(this.c, anVar.c) && Arrays.equals(this.d, anVar.d) && this.b == anVar.b;
        }
        return true;
    }

    public final int hashCode() {
        if (this.a) {
            return ((((527 + Arrays.hashCode(this.c)) * 31) + Arrays.hashCode(this.d)) * 31) + (!this.b ? 1 : 0);
        }
        return 17;
    }

    public final String toString() {
        String string;
        if (!this.a) {
            return "ConnectionSpec()";
        }
        String string2 = "[all enabled]";
        String[] strArr = this.c;
        if (strArr != null) {
            ArrayList arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                arrayList.add(jk.a(str));
            }
            string = Collections.unmodifiableList(arrayList).toString();
        } else {
            string = "[all enabled]";
        }
        String[] strArr2 = this.d;
        if (strArr2 != null) {
            ArrayList arrayList2 = new ArrayList(strArr2.length);
            for (String str2 : strArr2) {
                arrayList2.add(g61.a(str2));
            }
            string2 = Collections.unmodifiableList(arrayList2).toString();
        }
        return "ConnectionSpec(cipherSuites=" + string + ", tlsVersions=" + string2 + ", supportsTlsExtensions=" + this.b + ")";
    }
}
