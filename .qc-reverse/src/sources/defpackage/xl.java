package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class xl extends hf0 implements z40 {
    public static final xl d;
    public static final xl e;
    public static final xl f;
    public static final xl g;
    public static final xl h;
    public static final xl i;
    public static final xl j;
    public final /* synthetic */ int c;

    static {
        int i2 = 2;
        d = new xl(i2, 0);
        e = new xl(i2, 1);
        f = new xl(i2, 2);
        g = new xl(i2, 3);
        h = new xl(i2, 4);
        i = new xl(i2, 5);
        j = new xl(i2, 6);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ xl(int i2, int i3) {
        super(i2);
        this.c = i3;
    }

    @Override // defpackage.z40
    public final Object f(Object obj, Object obj2) {
        yl ylVar;
        switch (this.c) {
            case 0:
                String str = (String) obj;
                cp cpVar = (cp) obj2;
                str.getClass();
                if (str.length() == 0) {
                    return cpVar.toString();
                }
                return str + ", " + cpVar;
            case 1:
                ep epVar = (ep) obj;
                cp cpVar2 = (cp) obj2;
                epVar.getClass();
                ep epVarM = epVar.m(cpVar2.getKey());
                my myVar = my.b;
                if (epVarM == myVar) {
                    return cpVar2;
                }
                ow0 ow0Var = ow0.d;
                hp hpVar = (hp) epVarM.i(ow0Var);
                if (hpVar == null) {
                    ylVar = new yl(cpVar2, epVarM);
                } else {
                    ep epVarM2 = epVarM.m(ow0Var);
                    if (epVarM2 == myVar) {
                        return new yl(hpVar, cpVar2);
                    }
                    ylVar = new yl(hpVar, new yl(cpVar2, epVarM2));
                }
                return ylVar;
            case 2:
                return ((ep) obj).h((cp) obj2);
            case 3:
                Boolean bool = (Boolean) obj;
                bool.getClass();
                return bool;
            case 4:
                return obj;
            case 5:
                if (obj == null) {
                    return null;
                }
                s1.d();
                return null;
            case 6:
                return (q51) obj;
            default:
                return ((ep) obj).h((cp) obj2);
        }
    }
}
