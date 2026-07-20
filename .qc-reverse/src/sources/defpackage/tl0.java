package defpackage;

import android.content.Context;
import com.google.android.datatransport.cct.CctBackendFactory;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class tl0 {
    public final i9 a;
    public final ra b;
    public final HashMap c;

    public tl0(Context context, ra raVar) {
        i9 i9Var = new i9(27, context);
        this.c = new HashMap();
        this.a = i9Var;
        this.b = raVar;
    }

    public final synchronized c91 a(String str) {
        if (this.c.containsKey(str)) {
            return (c91) this.c.get(str);
        }
        CctBackendFactory cctBackendFactoryW = this.a.w(str);
        if (cctBackendFactoryW == null) {
            return null;
        }
        ra raVar = this.b;
        c91 c91VarCreate = cctBackendFactoryW.create(new wc((Context) raVar.e, (xk) raVar.c, (xk) raVar.d, str));
        this.c.put(str, c91VarCreate);
        return c91VarCreate;
    }
}
