package defpackage;

import com.quickcursor.R;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class w11 {
    public final int a;
    public final String b;
    public final int c;
    public final int d;

    public w11(int i, int i2) {
        this.c = i;
        this.d = i2;
        Type type = uv0.MAP_HASH_TYPE;
        this.a = i < i2 ? R.drawable.icon_rotation_portrait : R.drawable.icon_rotation_landscape;
        this.b = i + "x" + i2;
    }
}
