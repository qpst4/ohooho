package defpackage;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF0' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ep1 {
    public static final ep1 c;
    public static final ep1 d;
    public static final ep1[] e;
    public static final /* synthetic */ ep1[] f;
    public final int b;

    /* JADX INFO: Fake field, exist only in values array */
    ep1 EF0;

    static {
        op1 op1Var = op1.f;
        ep1 ep1Var = new ep1("DOUBLE", 0, 0, 1, op1Var);
        op1 op1Var2 = op1.e;
        ep1 ep1Var2 = new ep1("FLOAT", 1, 1, 1, op1Var2);
        op1 op1Var3 = op1.d;
        ep1 ep1Var3 = new ep1("INT64", 2, 2, 1, op1Var3);
        ep1 ep1Var4 = new ep1("UINT64", 3, 3, 1, op1Var3);
        op1 op1Var4 = op1.c;
        ep1 ep1Var5 = new ep1("INT32", 4, 4, 1, op1Var4);
        ep1 ep1Var6 = new ep1("FIXED64", 5, 5, 1, op1Var3);
        ep1 ep1Var7 = new ep1("FIXED32", 6, 6, 1, op1Var4);
        op1 op1Var5 = op1.g;
        ep1 ep1Var8 = new ep1("BOOL", 7, 7, 1, op1Var5);
        op1 op1Var6 = op1.h;
        ep1 ep1Var9 = new ep1("STRING", 8, 8, 1, op1Var6);
        op1 op1Var7 = op1.k;
        ep1 ep1Var10 = new ep1("MESSAGE", 9, 9, 1, op1Var7);
        op1 op1Var8 = op1.i;
        ep1 ep1Var11 = new ep1("BYTES", 10, 10, 1, op1Var8);
        ep1 ep1Var12 = new ep1("UINT32", 11, 11, 1, op1Var4);
        op1 op1Var9 = op1.j;
        ep1 ep1Var13 = new ep1("ENUM", 12, 12, 1, op1Var9);
        ep1 ep1Var14 = new ep1("SFIXED32", 13, 13, 1, op1Var4);
        ep1 ep1Var15 = new ep1("SFIXED64", 14, 14, 1, op1Var3);
        ep1 ep1Var16 = new ep1("SINT32", 15, 15, 1, op1Var4);
        ep1 ep1Var17 = new ep1("SINT64", 16, 16, 1, op1Var3);
        ep1 ep1Var18 = new ep1("GROUP", 17, 17, 1, op1Var7);
        ep1 ep1Var19 = new ep1("DOUBLE_LIST", 18, 18, 2, op1Var);
        ep1 ep1Var20 = new ep1("FLOAT_LIST", 19, 19, 2, op1Var2);
        ep1 ep1Var21 = new ep1("INT64_LIST", 20, 20, 2, op1Var3);
        ep1 ep1Var22 = new ep1("UINT64_LIST", 21, 21, 2, op1Var3);
        ep1 ep1Var23 = new ep1("INT32_LIST", 22, 22, 2, op1Var4);
        ep1 ep1Var24 = new ep1("FIXED64_LIST", 23, 23, 2, op1Var3);
        ep1 ep1Var25 = new ep1("FIXED32_LIST", 24, 24, 2, op1Var4);
        ep1 ep1Var26 = new ep1("BOOL_LIST", 25, 25, 2, op1Var5);
        ep1 ep1Var27 = new ep1("STRING_LIST", 26, 26, 2, op1Var6);
        ep1 ep1Var28 = new ep1("MESSAGE_LIST", 27, 27, 2, op1Var7);
        ep1 ep1Var29 = new ep1("BYTES_LIST", 28, 28, 2, op1Var8);
        ep1 ep1Var30 = new ep1("UINT32_LIST", 29, 29, 2, op1Var4);
        ep1 ep1Var31 = new ep1("ENUM_LIST", 30, 30, 2, op1Var9);
        ep1 ep1Var32 = new ep1("SFIXED32_LIST", 31, 31, 2, op1Var4);
        ep1 ep1Var33 = new ep1("SFIXED64_LIST", 32, 32, 2, op1Var3);
        ep1 ep1Var34 = new ep1("SINT32_LIST", 33, 33, 2, op1Var4);
        ep1 ep1Var35 = new ep1("SINT64_LIST", 34, 34, 2, op1Var3);
        ep1 ep1Var36 = new ep1("DOUBLE_LIST_PACKED", 35, 35, 3, op1Var);
        c = ep1Var36;
        ep1 ep1Var37 = new ep1("FLOAT_LIST_PACKED", 36, 36, 3, op1Var2);
        ep1 ep1Var38 = new ep1("INT64_LIST_PACKED", 37, 37, 3, op1Var3);
        ep1 ep1Var39 = new ep1("UINT64_LIST_PACKED", 38, 38, 3, op1Var3);
        ep1 ep1Var40 = new ep1("INT32_LIST_PACKED", 39, 39, 3, op1Var4);
        ep1 ep1Var41 = new ep1("FIXED64_LIST_PACKED", 40, 40, 3, op1Var3);
        ep1 ep1Var42 = new ep1("FIXED32_LIST_PACKED", 41, 41, 3, op1Var4);
        ep1 ep1Var43 = new ep1("BOOL_LIST_PACKED", 42, 42, 3, op1Var5);
        ep1 ep1Var44 = new ep1("UINT32_LIST_PACKED", 43, 43, 3, op1Var4);
        ep1 ep1Var45 = new ep1("ENUM_LIST_PACKED", 44, 44, 3, op1Var9);
        ep1 ep1Var46 = new ep1("SFIXED32_LIST_PACKED", 45, 45, 3, op1Var4);
        ep1 ep1Var47 = new ep1("SFIXED64_LIST_PACKED", 46, 46, 3, op1Var3);
        ep1 ep1Var48 = new ep1("SINT32_LIST_PACKED", 47, 47, 3, op1Var4);
        ep1 ep1Var49 = new ep1("SINT64_LIST_PACKED", 48, 48, 3, op1Var3);
        d = ep1Var49;
        f = new ep1[]{ep1Var, ep1Var2, ep1Var3, ep1Var4, ep1Var5, ep1Var6, ep1Var7, ep1Var8, ep1Var9, ep1Var10, ep1Var11, ep1Var12, ep1Var13, ep1Var14, ep1Var15, ep1Var16, ep1Var17, ep1Var18, ep1Var19, ep1Var20, ep1Var21, ep1Var22, ep1Var23, ep1Var24, ep1Var25, ep1Var26, ep1Var27, ep1Var28, ep1Var29, ep1Var30, ep1Var31, ep1Var32, ep1Var33, ep1Var34, ep1Var35, ep1Var36, ep1Var37, ep1Var38, ep1Var39, ep1Var40, ep1Var41, ep1Var42, ep1Var43, ep1Var44, ep1Var45, ep1Var46, ep1Var47, ep1Var48, ep1Var49, new ep1("GROUP_LIST", 49, 49, 2, op1Var7), new ep1("MAP", 50, 50, 4, op1.b)};
        ep1[] ep1VarArrValues = values();
        e = new ep1[ep1VarArrValues.length];
        for (ep1 ep1Var50 : ep1VarArrValues) {
            e[ep1Var50.b] = ep1Var50;
        }
    }

    public ep1(String str, int i, int i2, int i3, op1 op1Var) {
        this.b = i2;
        int i4 = i3 - 1;
        if (i4 == 1 || i4 == 3) {
            op1Var.getClass();
        }
        if (i3 == 1) {
            op1 op1Var2 = op1.b;
            op1Var.ordinal();
        }
    }

    public static ep1[] values() {
        return (ep1[]) f.clone();
    }
}
