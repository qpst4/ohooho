package defpackage;

import android.content.Context;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class d91 {
    public static volatile or e;
    public final xk a;
    public final xk b;
    public final ss c;
    public final vd1 d;

    public d91(xk xkVar, xk xkVar2, ss ssVar, vd1 vd1Var, g7 g7Var) {
        this.a = xkVar;
        this.b = xkVar2;
        this.c = ssVar;
        this.d = vd1Var;
        ((Executor) g7Var.c).execute(new lk0(26, g7Var));
    }

    public static d91 a() {
        or orVar = e;
        if (orVar != null) {
            return (d91) orVar.g.get();
        }
        s1.f("Not initialized!");
        return null;
    }

    public static void b(Context context) {
        if (e == null) {
            synchronized (d91.class) {
                try {
                    if (e == null) {
                        nr nrVar = new nr();
                        context.getClass();
                        nrVar.a = context;
                        e = nrVar.b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final ra c(bi biVar) {
        Set setUnmodifiableSet = biVar instanceof bi ? Collections.unmodifiableSet(bi.d) : Collections.singleton(new uy("proto"));
        ra raVarA = hd.a();
        biVar.getClass();
        raVarA.c = "cct";
        String str = biVar.a;
        String str2 = biVar.b;
        if (str2 == null) {
            str2 = "";
        }
        raVarA.d = ("1$" + str + "\\" + str2).getBytes(Charset.forName("UTF-8"));
        return new ra(setUnmodifiableSet, raVarA.m(), this, 19);
    }
}
