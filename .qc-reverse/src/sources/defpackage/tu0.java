package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class tu0 {
    public static final uu0 a;

    static {
        uu0 uu0Var = null;
        try {
            uu0Var = (uu0) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (uu0Var == null) {
            uu0Var = new uu0();
        }
        a = uu0Var;
    }
}
