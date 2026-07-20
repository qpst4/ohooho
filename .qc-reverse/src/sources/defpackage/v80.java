package defpackage;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class v80 {
    public static final v70[] a;
    public static final Map b;

    static {
        v70 v70Var = new v70(v70.i, "");
        ai aiVar = v70.f;
        v70 v70Var2 = new v70(aiVar, "GET");
        v70 v70Var3 = new v70(aiVar, "POST");
        ai aiVar2 = v70.g;
        v70 v70Var4 = new v70(aiVar2, "/");
        v70 v70Var5 = new v70(aiVar2, "/index.html");
        ai aiVar3 = v70.h;
        v70 v70Var6 = new v70(aiVar3, "http");
        v70 v70Var7 = new v70(aiVar3, "https");
        ai aiVar4 = v70.e;
        v70[] v70VarArr = {v70Var, v70Var2, v70Var3, v70Var4, v70Var5, v70Var6, v70Var7, new v70(aiVar4, "200"), new v70(aiVar4, "204"), new v70(aiVar4, "206"), new v70(aiVar4, "304"), new v70(aiVar4, "400"), new v70(aiVar4, "404"), new v70(aiVar4, "500"), new v70("accept-charset", ""), new v70("accept-encoding", "gzip, deflate"), new v70("accept-language", ""), new v70("accept-ranges", ""), new v70("accept", ""), new v70("access-control-allow-origin", ""), new v70("age", ""), new v70("allow", ""), new v70("authorization", ""), new v70("cache-control", ""), new v70("content-disposition", ""), new v70("content-encoding", ""), new v70("content-language", ""), new v70("content-length", ""), new v70("content-location", ""), new v70("content-range", ""), new v70("content-type", ""), new v70("cookie", ""), new v70("date", ""), new v70("etag", ""), new v70("expect", ""), new v70("expires", ""), new v70("from", ""), new v70("host", ""), new v70("if-match", ""), new v70("if-modified-since", ""), new v70("if-none-match", ""), new v70("if-range", ""), new v70("if-unmodified-since", ""), new v70("last-modified", ""), new v70("link", ""), new v70("location", ""), new v70("max-forwards", ""), new v70("proxy-authenticate", ""), new v70("proxy-authorization", ""), new v70("range", ""), new v70("referer", ""), new v70("refresh", ""), new v70("retry-after", ""), new v70("server", ""), new v70("set-cookie", ""), new v70("strict-transport-security", ""), new v70("transfer-encoding", ""), new v70("user-agent", ""), new v70("vary", ""), new v70("via", ""), new v70("www-authenticate", "")};
        a = v70VarArr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(v70VarArr.length);
        for (int i = 0; i < v70VarArr.length; i++) {
            if (!linkedHashMap.containsKey(v70VarArr[i].a)) {
                linkedHashMap.put(v70VarArr[i].a, Integer.valueOf(i));
            }
        }
        b = Collections.unmodifiableMap(linkedHashMap);
    }

    public static void a(ai aiVar) {
        int i = aiVar.i();
        for (int i2 = 0; i2 < i; i2++) {
            byte bD = aiVar.d(i2);
            if (bD >= 65 && bD <= 90) {
                zy.o("PROTOCOL_ERROR response malformed: mixed case name: ", aiVar.l());
                return;
            }
        }
    }
}
