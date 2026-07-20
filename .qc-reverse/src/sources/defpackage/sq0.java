package defpackage;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class sq0 {
    public static final Charset c = Charset.forName("UTF-8");
    public ConcurrentHashMap a;
    public rq0 b;

    public final List a(byte[] bArr) {
        List list = (List) this.a.get(new String(bArr, c));
        return list != null ? list : Collections.EMPTY_LIST;
    }
}
