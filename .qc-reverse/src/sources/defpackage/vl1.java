package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class vl1 {
    static {
        int i = xl1.a;
    }

    public static String a(Exception exc) {
        if (exc == null) {
            return null;
        }
        try {
            String simpleName = exc.getClass().getSimpleName();
            String message = exc.getMessage();
            if (message == null) {
                message = "";
            }
            String str = simpleName + ":" + message;
            int i = pn1.a;
            return str.length() > 40 ? str.substring(0, 40) : str;
        } catch (Throwable th) {
            pn1.h("BillingLogger", "Unable to get truncated exception info", th);
            return null;
        }
    }

    public static sq1 b(int i, int i2, df dfVar) {
        try {
            rq1 rq1VarR = sq1.r();
            xq1 xq1VarS = yq1.s();
            int i3 = dfVar.a;
            xq1VarS.c();
            yq1.q((yq1) xq1VarS.c, i3);
            String str = dfVar.b;
            xq1VarS.c();
            yq1.p((yq1) xq1VarS.c, str);
            xq1VarS.d(i);
            rq1VarR.d(xq1VarS);
            rq1VarR.c();
            sq1.q((sq1) rq1VarR.c, i2);
            return (sq1) rq1VarR.b();
        } catch (Exception e) {
            pn1.h("BillingLogger", "Unable to create logging payload", e);
            return null;
        }
    }

    public static sq1 c(int i, int i2, df dfVar, String str) {
        try {
            xq1 xq1VarS = yq1.s();
            int i3 = dfVar.a;
            xq1VarS.c();
            yq1.q((yq1) xq1VarS.c, i3);
            String str2 = dfVar.b;
            xq1VarS.c();
            yq1.p((yq1) xq1VarS.c, str2);
            xq1VarS.d(i);
            if (str != null) {
                xq1VarS.c();
                yq1.o((yq1) xq1VarS.c, str);
            }
            rq1 rq1VarR = sq1.r();
            rq1VarR.d(xq1VarS);
            rq1VarR.c();
            sq1.q((sq1) rq1VarR.c, i2);
            return (sq1) rq1VarR.b();
        } catch (Throwable th) {
            pn1.h("BillingLogger", "Unable to create logging payload", th);
            return null;
        }
    }

    public static wq1 d(int i) {
        try {
            vq1 vq1VarQ = wq1.q();
            vq1VarQ.c();
            wq1.p((wq1) vq1VarQ.c, i);
            return (wq1) vq1VarQ.b();
        } catch (Exception e) {
            pn1.h("BillingLogger", "Unable to create logging payload", e);
            return null;
        }
    }
}
