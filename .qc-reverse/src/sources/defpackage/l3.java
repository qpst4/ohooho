package defpackage;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class l3 {
    public final Class<?> actionClass;
    public final k3 actionTypePickedInterceptor;
    public final int categoryId;
    public final int descriptionId;
    public final boolean extraConfigs;
    public final HashMap<String, Object> extras;
    public final int iconId;
    public final int requirements;
    public final int titleId;
    public final int types;
    public final int valueId;

    public l3(Class cls, int i, int i2, int i3, int i4, int i5, int i6, int i7, Boolean bool, k3 k3Var, HashMap map) {
        this.actionClass = cls;
        this.categoryId = i;
        this.valueId = i2;
        this.titleId = i3;
        this.descriptionId = i4;
        this.iconId = i5;
        this.types = i6;
        this.requirements = i7;
        this.extraConfigs = bool.booleanValue();
        this.actionTypePickedInterceptor = k3Var;
        this.extras = map;
    }
}
