package defpackage;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class de1 {
    public static final /* synthetic */ int a = 0;

    static {
        Charset.forName("UTF-8");
    }

    public static we0 a(se0 se0Var) {
        te0 te0Var = (te0) we0.f.k();
        int i = se0Var.d;
        te0Var.c();
        ((we0) te0Var.c).d = i;
        for (re0 re0Var : se0Var.e) {
            ue0 ue0Var = (ue0) ve0.h.k();
            String str = re0Var.p().d;
            ue0Var.c();
            ve0 ve0Var = (ve0) ue0Var.c;
            ve0Var.getClass();
            str.getClass();
            ve0Var.d = str;
            int iQ = re0Var.q();
            ue0Var.c();
            ve0 ve0Var2 = (ve0) ue0Var.c;
            ve0Var2.getClass();
            int i2 = 1;
            if (iQ == 1) {
                i2 = 0;
            } else if (iQ != 2) {
                i2 = 3;
                if (iQ == 3) {
                    i2 = 2;
                } else if (iQ != 4) {
                    if (iQ != 5) {
                        throw null;
                    }
                    i2 = -1;
                }
            }
            ve0Var2.e = i2;
            int iB = l11.b(re0Var.g);
            if (iB == 0) {
                iB = 6;
            }
            ue0Var.c();
            ve0 ve0Var3 = (ve0) ue0Var.c;
            ve0Var3.getClass();
            ve0Var3.g = l11.f(iB);
            int i3 = re0Var.f;
            ue0Var.c();
            ((ve0) ue0Var.c).f = i3;
            ve0 ve0Var4 = (ve0) ue0Var.a();
            te0Var.c();
            we0 we0Var = (we0) te0Var.c;
            we0Var.getClass();
            sr0 sr0Var = we0Var.e;
            if (!sr0Var.b) {
                we0Var.e = w50.h(sr0Var);
            }
            we0Var.e.add(ve0Var4);
        }
        return (we0) te0Var.a();
    }
}
