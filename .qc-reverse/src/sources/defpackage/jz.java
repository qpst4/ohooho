package defpackage;

import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class jz {
    public static final Logger c = Logger.getLogger(jz.class.getName());
    public static final ArrayList d;
    public static final jz e;
    public static final jz f;
    public static final jz g;
    public static final jz h;
    public static final jz i;
    public final kz a;
    public final List b = d;

    static {
        try {
            Class.forName("android.app.Application", false, null);
            String[] strArr = {"GmsCore_OpenSSL", "AndroidOpenSSL"};
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < 2; i2++) {
                String str = strArr[i2];
                Provider provider = Security.getProvider(str);
                if (provider != null) {
                    arrayList.add(provider);
                } else {
                    c.info("Provider " + str + " not available");
                }
            }
            d = arrayList;
        } catch (Exception unused) {
            d = new ArrayList();
        }
        e = new jz(new c70(14));
        f = new jz(new c70(15));
        g = new jz(new ow0(15));
        h = new jz(new ix(15));
        i = new jz(new ow0(14));
    }

    public jz(kz kzVar) {
        this.a = kzVar;
    }

    public final Object a(String str) {
        Iterator it = this.b.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            kz kzVar = this.a;
            if (!zHasNext) {
                return kzVar.c(str, null);
            }
            Provider provider = (Provider) it.next();
            try {
                kzVar.c(str, provider);
                return kzVar.c(str, provider);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
