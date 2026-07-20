package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public enum om1 {
    c("RESPONSE_CODE_UNSPECIFIED"),
    /* JADX INFO: Fake field, exist only in values array */
    EF18("SERVICE_TIMEOUT"),
    /* JADX INFO: Fake field, exist only in values array */
    EF27("FEATURE_NOT_SUPPORTED"),
    /* JADX INFO: Fake field, exist only in values array */
    EF36("SERVICE_DISCONNECTED"),
    /* JADX INFO: Fake field, exist only in values array */
    EF45("OK"),
    /* JADX INFO: Fake field, exist only in values array */
    EF53("USER_CANCELED"),
    /* JADX INFO: Fake field, exist only in values array */
    EF63("SERVICE_UNAVAILABLE"),
    /* JADX INFO: Fake field, exist only in values array */
    EF71("BILLING_UNAVAILABLE"),
    /* JADX INFO: Fake field, exist only in values array */
    EF80("ITEM_UNAVAILABLE"),
    /* JADX INFO: Fake field, exist only in values array */
    EF92("DEVELOPER_ERROR"),
    /* JADX INFO: Fake field, exist only in values array */
    EF102("ERROR"),
    /* JADX INFO: Fake field, exist only in values array */
    EF111("ITEM_ALREADY_OWNED"),
    /* JADX INFO: Fake field, exist only in values array */
    EF120("ITEM_NOT_OWNED"),
    /* JADX INFO: Fake field, exist only in values array */
    EF134("EXPIRED_OFFER_TOKEN"),
    /* JADX INFO: Fake field, exist only in values array */
    EF147("NETWORK_ERROR");

    public static final ym1 d;
    public final int b;

    static {
        f9 f9Var = new f9(5);
        f9Var.c = new Object[8];
        f9Var.b = 0;
        for (om1 om1Var : values()) {
            Integer numValueOf = Integer.valueOf(om1Var.b);
            int i = f9Var.b + 1;
            Object[] objArr = (Object[]) f9Var.c;
            int length = objArr.length;
            int i2 = i + i;
            if (i2 > length) {
                f9Var.c = Arrays.copyOf(objArr, wl1.b(length, i2));
            }
            Object[] objArr2 = (Object[]) f9Var.c;
            int i3 = f9Var.b;
            int i4 = i3 + i3;
            objArr2[i4] = numValueOf;
            objArr2[i4 + 1] = om1Var;
            f9Var.b = i3 + 1;
        }
        fm1 fm1Var = (fm1) f9Var.d;
        if (fm1Var != null) {
            throw fm1Var.a();
        }
        ym1 ym1VarA = ym1.a(f9Var.b, (Object[]) f9Var.c, f9Var);
        fm1 fm1Var2 = (fm1) f9Var.d;
        if (fm1Var2 != null) {
            throw fm1Var2.a();
        }
        d = ym1VarA;
    }

    om1(String str) {
        this.b = i;
    }
}
